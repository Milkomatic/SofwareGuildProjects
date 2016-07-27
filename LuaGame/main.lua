require "player"
monsters = require "monster"

function love.load(arg)
    windowWidth  = love.graphics.getWidth()
    windowHeight = love.graphics.getHeight()
    kills = 0
    monTimer = 0
end

function love.update(dt)
    if player.hp > 0 then
        mainUpdate(dt)
    end
end

function love.draw()
    if player.hp > 0 then
        mainDraw()
    else
        love.graphics.print("Game Over", windowWidth/3, windowHeight/2.6, 0, 4, 4)
        love.graphics.print("Kills: " .. kills, windowWidth/2.6, windowHeight/2, 0, 5, 5)
    end
end

function mainDraw()
    love.graphics.push()
    love.graphics.setColor(200, 200, 200, 255)
    love.graphics.print("Kills: " .. kills, 20, 0, 0, 2, 2)
    love.graphics.print("'space' to attack!", 600, 0, 0, 1.5, 1.5)

    if kills >= 10 then
        love.graphics.print("'z' attack unlocked!", 600, 20, 0, 1.5, 1.5)
    love.graphics.print("'z' attack unlocked!", 600, 20, 0, 1.5, 1.5)
    end
    if kills >= 100 then
        love.graphics.print("'x' to heal!", 600, 60, 0, 1.5, 1.5)
    end
    if kills >= 50 then
        love.graphics.print("'c' to sprint!", 600, 40, 0, 1.5, 1.5)
    end
    player.draw()
    playerAttacks.draw()
    for i,v in ipairs(monsters) do
        v:draw()
    end
    love.graphics.pop()
end

function mainUpdate(dt)
    deltaTime = dt
    monTimer = monTimer - 100 * dt

    while monTimer <= 0 and numberOfMonsters() <= kills + 1 do
        monsters:more()
        monTimer = monTimer + 10
    end

    player.update(dt)
    playerAttacks.update(dt)
    for i,v in ipairs (monsters) do
        v:update(dt)
        if v.hp < 1 then
            table.remove(monsters, i)
            kills = kills + 1
        end
    end
    for i,v in ipairs (playerAttacks) do
        for ii,vv in ipairs (monsters) do
            if CheckCollision(v, vv) then
                vv.hp = vv.hp - v.power * dt
            end
        end
    end
    for i,v in ipairs (monsters) do
        if CheckCollision(player, v) then
            player.hp = player.hp - 100 * dt
        end
    end
end

--all objects are 10x10
function CheckCollision(objectA, objectB)
  return objectA.X < (objectB.X)+10 and
         objectB.X < (objectA.X)+10 and
         objectA.Y < (objectB.Y)+10 and
         objectB.Y < (objectA.Y)+10
end
