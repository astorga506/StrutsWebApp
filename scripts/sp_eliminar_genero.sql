USE [VideoA80703]
GO
/****** Object:  StoredProcedure [dbo].[eliminat_genero]    Script Date: 05/16/2013 14:36:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[eliminar_genero](	
	@cod_genero int
)

AS

BEGIN

	DELETE FROM Genero
	WHERE cod_genero = @cod_genero
	
END

