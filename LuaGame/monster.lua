require "player"

monsterList = {}

local Monster = {
        X = math.random(200, 600),
        Y = math.random(200, 600),
        timer = 0,
        hp = 100,
        speed = 2
    }
--table.insert(monsterList, Monster)

function monsterList:more()
    newMon = Monster:new()
    newMon.speed = math.random(4)
    newMon.hp = math.random(80,100)
    newMon.X = math.random(200, 600)
    newMon.Y = math.random(200, 600)
    table.insert(self, newMon)
end

function Monster:new(m)
    m = m or {}
    setmetatable(m, self)
    self.__index = self
    return m
end

function Monster:update(dt)
    if player.X - self.X < 120 and player.Y - self.Y < 120 then
        self.X = self.X + (player.X - self.X) * self.speed * dt
        self.Y = self.Y + (player.Y - self.Y) * self.speed * dt
        else
        self.timer = self.timer - 10 * dt

        while self.timer <= 0 do
            dir = math.random(4)
            self.timer = 50
        end

        if dir == 1 and self.X <= windowWidth-5 then
            self.X = self.X + 1
        end
        if dir == 2 and self.X >= 0 then
            self.X = self.X - 1
        end
        if dir == 3 and self.Y <= windowHeight-5 then
            self.Y = self.Y + 1
        end
        if dir == 4 and self.Y >= 0 then
            self.Y = self.Y - 1
        end
    end
end

function Monster:draw()
    love.graphics.setColor(120, 50, 100, 255)
    love.graphics.circle("fill", self.X, self.Y, 10, 10)
    love.graphics.setColor(255, 0, 0, 255)
    love.graphics.print(math.floor(self.hp), self.X - 10, self.Y -30)
end

function numberOfMonsters()
  local count = 0
  for _ in pairs(monsterList) do count = count + 1 end
  return count
end

return monsterList
