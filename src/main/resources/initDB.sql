USE test;
DROP TABLE IF EXISTS parts;
CREATE TABLE parts
(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(100)   NOT NULL,
 needed TINYINT(1) DEFAULT 0 NOT NULL, quantity INT(4)  NOT NULL, PRIMARY KEY(id))
  ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO parts (name, needed, quantity) VALUES
('processor AMD', 1, 3),
('motherboard 1', 1, 4),
('box 1', 1, 3),
('video card Nvidia', 1, 6),
('monitor Dell', 0, 10),
('keyboard A4Tech', 0, 13),
('mouse A4Tech', 0, 20),
('RAM 1', 1, 4),
('cooler 1', 1, 8),
('microphone 1', 0, 11),
('processor Intel', 1, 3),
('motherboard 2', 1, 4),
('box 2', 1, 7),
('video card ATI', 1, 6),
('monitor Samsung', 0, 10),
('keyboard Logitech', 0, 13),
('mouse Logitech', 0, 20),
('RAM 2', 1, 4),
('cooler 2', 1, 8),
('microphone 2', 0, 11),
('Loudspeakers 1', 0, 3);
('Loudspeakers 2', 0, 4);