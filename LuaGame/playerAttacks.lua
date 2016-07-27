playerAttacks = {}

function attack()
    local attack = {
        X = player.X,
        Y = player.Y,
        direction = player.direction,
        timer = 0,
        --10 + how many "pixels" out to go
        speed = 10,
        --length in Milliseconds the attack stays on screen
        length = .15,
        power = 400
    }
    player.cooldown = attack.length
    player.cooldown = attack.length
    table.insert(playerAttacks, attack)
end

--15,.40,800
function attackTwo()
    player.cooldown = 0
    local attack = {
        X = player.X,
        Y = player.Y,
        direction = player.direction,
        timer = 0,
        --10 + how many "pixels" out to go
        speed = 100,
        --length in Milliseconds the attack stays on screen
        length = .10,
        power = 1200
    }
    player.cooldown = attack.length
    table.insert(playerAttacks, attack)
end

function playerAttacks.update(dt)
    for i,v in ipairs(playerAttacks) do
        v.timer = v.timer + dt
        v.speed = v.speed - v.speed / 3


        if v.direction == "up" then
            v.Y = v.Y - v.speed
        end
        if v.direction == "down" then
            v.Y = v.Y + v.speed
        end
        if v.direction == "left" then
            v.X = v.X - v.speed
        end
        if v.direction == "right" then
            v.X = v.X + v.speed
        end

        if v.timer > v.length then
            table.remove(playerAttacks, i)
        end
    end
end

function playerAttacks.draw()
    for i,v in ipairs(playerAttacks) do
        love.graphics.setColor(255, 0, 0, 255)
        love.graphics.circle("fill", v.X, v.Y, 10, 10)
    end
end
