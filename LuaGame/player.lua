require "playerAttacks"

    player = {
        X = 100,
        Y = 100,
        direction = "up",
        cooldown = 0,
        hp = 100,
        speed = 6
    }

function player.update(dt)
    if player.speed > 8 then
        player.speed = player.speed - 100 * dt
    end

    if player.cooldown > 0 then
        player.cooldown = player.cooldown - dt
    else
        --MOVEMENT--
        if love.keyboard.isDown("right") then
            player.X = player.X + player.speed
            player.direction = "right"
        end
        if love.keyboard.isDown("left") then
            player.X = player.X - player.speed
            player.direction = "left"
        end
        if love.keyboard.isDown("down") then
            player.Y = player.Y + player.speed
            player.direction = "down"
        end
        if love.keyboard.isDown("up") then
            player.Y = player.Y - player.speed
            player.direction = "up"
        end
        --ATTACKS--
        if love.keyboard.isDown("space") then
            attack()
        end
        if kills >= 10 and love.keyboard.isDown("z") then
            attackTwo()
        end
        if kills >= 100 and love.keyboard.isDown("x") then
            if player.hp < 100 then
                player.hp = player.hp + 1
            end
            player.cooldown = .1
        end
        if kills >= 50 and love.keyboard.isDown("c") then
            player.speed = 14

        end
    end
end

function player.draw()
    love.graphics.setColor(100, 200, 255, 255)
    love.graphics.circle("fill", player.X, player.Y, 10, 10)
    love.graphics.setColor(255, 0, 0, 255)
    love.graphics.print(math.floor(player.hp), player.X - 10, player.Y -30)
end
