CREATE TABLE todo (
	id INTEGER NOT NULL 
		GENERATED ALWAYS AS IDENTITY 
		(START WITH 1, INCREMENT BY 1),
	titulo VARCHAR(100) NOT NULL,
	descripcion VARCHAR(500),
	fecha DATE NOT NULL,
	estatus INT NOT NULL,
	PRIMARY KEY(id)
);
INSERT INTO todo (titulo, descripcion, fecha, estatus)
VALUES('Título #1', 'Descripción #1', '2012-01-01', 0);
INSERT INTO todo (titulo, descripcion, fecha, estatus)
VALUES('Título #2', 'Descripción #2', '2012-02-01', 0);
INSERT INTO todo (titulo, descripcion, fecha, estatus)
VALUES('Título #3', 'Descripción #3', '2012-03-01', 0);

SELECT * FROM todo;