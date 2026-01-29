CREATE TABLE IF NOT EXISTS gjUsuario (
    gjIdUsuario INTEGER PRIMARY KEY AUTOINCREMENT,
    gjNombre TEXT NOT NULL,
    gjUsername TEXT NOT NULL UNIQUE,
    gjPassword TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS gjTipoArma (
    gjIdTipoArma INTEGER PRIMARY KEY AUTOINCREMENT,
    gjNombre TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS gjArma (
    gjIdArma INTEGER PRIMARY KEY AUTOINCREMENT,
    gjIdTipoArma INTEGER NOT NULL,
    gjNombre TEXT NOT NULL,
    FOREIGN KEY (gjIdTipoArma) REFERENCES gjTipoArma(gjIdTipoArma)
);
CREATE TABLE IF NOT EXISTS gjTipoExobot (
    gjIdTipoExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    gjNombre TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS gjExobot (
    gjIdExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    gjIdTipoExobot INTEGER NOT NULL,
    gjIdUsuario INTEGER,
    gjEntrenado INTEGER DEFAULT 0,
    -- 0: No, 1: Si
    gjNumeroAccion INTEGER DEFAULT 0,
    gjIdArma INTEGER,
    FOREIGN KEY (gjIdTipoExobot) REFERENCES gjTipoExobot(gjIdTipoExobot),
    FOREIGN KEY (gjIdUsuario) REFERENCES gjUsuario(gjIdUsuario),
    FOREIGN KEY (gjIdArma) REFERENCES gjArma(gjIdArma)
);
CREATE TABLE IF NOT EXISTS gjExoTracer (
    gjIdExoTracer INTEGER PRIMARY KEY AUTOINCREMENT,
    gjIdExobot INTEGER,
    gjNumeroAccion INTEGER,
    gjEnShow TEXT,
    FOREIGN KEY (gjIdExobot) REFERENCES gjExobot(gjIdExobot)
);
-- Datos Iniciales (Seed Data)
INSERT INTO gjUsuario (gjNombre, gjUsername, gjPassword)
VALUES ('Patricio Michael', 'patmic', '123');
INSERT INTO gjTipoArma (gjNombre)
VALUES ('Fusil / Revolver');
INSERT INTO gjTipoArma (gjNombre)
VALUES ('GPS / Giroscopio');
INSERT INTO gjTipoArma (gjNombre)
VALUES ('Misil / Mortero');
INSERT INTO gjTipoArma (gjNombre)
VALUES ('BioSensor / BioEscaner');
INSERT INTO gjTipoArma (gjNombre)
VALUES ('Laser / Bayoneta');
INSERT INTO gjTipoExobot (gjNombre)
VALUES ('ExoAsalto');
INSERT INTO gjTipoExobot (gjNombre)
VALUES ('ExoExplorador');
INSERT INTO gjTipoExobot (gjNombre)
VALUES ('ExoInfanteria');
INSERT INTO gjTipoExobot (gjNombre)
VALUES ('ExoMedico');
INSERT INTO gjTipoExobot (gjNombre)
VALUES ('ExoComando');
INSERT INTO gjArma (gjIdTipoArma, gjNombre)
VALUES (1, 'Fusil');
INSERT INTO gjArma (gjIdTipoArma, gjNombre)
VALUES (2, 'GPS');
INSERT INTO gjArma (gjIdTipoArma, gjNombre)
VALUES (3, 'Misil');
INSERT INTO gjArma (gjIdTipoArma, gjNombre)
VALUES (4, 'BioSensor');
INSERT INTO gjArma (gjIdTipoArma, gjNombre)
VALUES (5, 'Laser');