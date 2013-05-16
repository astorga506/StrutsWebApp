USE Gimnasio_A80703
GO

ALTER PROCEDURE sp_buscar_cliente
	@apellidos varchar(60)


AS

BEGIN

SELECT *
	FROM Cliente
    WHERE apellidos_cliente LIKE '%'+rtrim(@apellidos)+'%'
END

GO


