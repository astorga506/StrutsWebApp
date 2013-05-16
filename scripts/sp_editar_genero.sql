USE VideoA80703

GO

CREATE PROCEDURE editar_genero(
	@cod_genero int,
	@nombre_genero varchar(60)
)

AS

BEGIN

	UPDATE Genero
	SET nombre_genero = RTRIM(@nombre_genero)
	WHERE cod_genero = @cod_genero

END
