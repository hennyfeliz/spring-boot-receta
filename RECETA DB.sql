create database Receta;

use Receta;

/*
@@ Receta database tablas


@ Receta
* id
* Nombre
* Descripcion
* ingredientes (foránea [Ingrediente])


@ Ingrediente
* id
* Nombre
* Precio
* cantidad (foránea [Cantidad])


@ Cantidad
* id
* Centigramo
* Miligramos
* Kilogramos
* Gramos
* Libras


*/
create table Cantidad(
	id int auto_increment,
    cantidad enum('Centigramo','Miligramos','Kilogramos','Gramos','Libras'),
    primary key(id)
);

create table Ingrediente(
	id int auto_increment,
    nombre varchar(20),
    precio double,
    cantidad int,
    primary key(id),
    foreign key(cantidad) references Cantidad(id)
);


create table Receta(
	id int auto_increment,
	nombre varchar(20),
    descripcion text,
    ingrediente int,
    primary key(id),
    foreign key(ingrediente) references Ingrediente(id)
);

select * from Cantidad;
select * from Ingrediente;
select * from Receta;

insert into Ingrediente (nombre, precio, cantidad) values
('Manzana', 8000.00, 1),
('Arroz', 3500.00, 2),
('Habichuela', 5900.00, 3),
('Pollo', 3400.00, 3),
('Lechuga', 400.00, 4);

insert into Receta (nombre, descripcion, ingrediente) values
('Perlue', 'Una receta de alimentos bajo en calorias', 2),
('Langozte', 'Una receta de alimentos bajo en calorias', 1),
('LeMoure', 'Una receta de alimentos bajo en calorias', 3),
('Francesa', 'Una receta de alimentos bajo en calorias', 4),
('Frijoles', 'Una receta de alimentos bajo en calorias', 5);


