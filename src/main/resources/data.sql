--Users Data
INSERT into user values(10001, sysdate(), 'Batman');
INSERT into user values(10002, sysdate(), 'Robin');
INSERT into user values(10003, sysdate(), 'Nightwing');

--Posts Data
INSERT INTO post values(11001, 'My First Post', 10001);
INSERT INTO post values(11002, 'My Second Post', 10001);