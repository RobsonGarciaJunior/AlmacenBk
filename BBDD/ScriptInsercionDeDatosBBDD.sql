-- Usuarios
INSERT INTO Usuario (email, nombre, apellido, foto, habilitado, contrasenna, tipo_usuario) VALUES
( 'anape@email.com', 'Ana', 'Pérez', 'ana.jpg', TRUE, '$2a$10$Dow1POHd1WnD4UCaL2r8uOmIN2K.n65hXUkqED0u1Tu1KnXX4keVu', 'admin'),
('luisGo@email.com', 'Luis', 'Gomez', 'luis.jpg', TRUE, '$2a$10$Dow1POHd1WnD4UCaL2r8uOmIN2K.n65hXUkqED0u1Tu1KnXX4keVu', 'empleado');

-- Productos
INSERT INTO Producto (nombre, foto, habilitado) VALUES
('Laptop', 'laptop.jpg', TRUE),
('Mouse', 'mouse.jpg', TRUE),
('Teclado', 'teclado.jpg', TRUE);

-- Almacenes
INSERT INTO Almacen (nombre, direccion) VALUES
('Almacen Central', 'Calle Falsa 123'),
('Almacen Norte', 'Avenida Real 456');

-- Productos en almacenes
INSERT INTO AlmacenProducto (almacen_id, producto_id, cantidad, cantidadMin) VALUES
(1, 1, 50, 10),
(1, 2, 150, 30),
(2, 3, 200, 20);

-- Pedidos
INSERT INTO Pedido (nombre_razon_social, CIF_NIF, importe, pagado, fecha_emision, fecha_entrega) VALUES
('Empresa A', 'A12345678', 1200.50, TRUE, '2024-04-15', '2024-04-20'),
('Empresa B', 'B87654321', 850.00, FALSE, '2024-04-16', '2024-04-22');

-- Productos en pedidos
INSERT INTO ProductoPedido (pedido_id, producto_id, cantidad) VALUES
(1, 1, 3),
(1, 2, 5),
(2, 3, 10);

-- Asignación de gestores
INSERT INTO GestionProducto (producto_id, usuario_id) VALUES
(1, 1),
(2, 1),
(3, 2);

INSERT INTO GestionPedido (pedido_id, usuario_id) VALUES
(1, 2),
(2, 1);
