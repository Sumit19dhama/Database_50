# Write your MySQL query statement below
SELECT s.user_id ,
    ROUND(
        IFNULL(SUM(c.action = 'confirmed') / COUNT(c.action), 0),
        2
    ) AS confirmation_rate
FROM signups as s
LEFT JOIN 
Confirmations as c
ON s.user_id = c.user_Id
GROUP BY s.user_Id;