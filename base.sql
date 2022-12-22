CREATE TABLE Equipe (
    id_Equipe VARCHAR(12) PRIMARY KEY, 
    nom_Equipe VARCHAR(12)
);

CREATE TABLE Joueur (
    id_Joueur VARCHAR(12) PRIMARY KEY,
    nom_Joueur VARCHAR(12),
    id_Equipe VARCHAR(12),
    FOREIGN KEY (id_Equipe) REFERENCES Equipe(id_Equipe)
);

CREATE TABLE Rencontre (
    id_Rencontre VARCHAR(15) PRIMARY KEY,
    id_Equipe1 VARCHAR(12),
    id_Equipe2 VARCHAR(12),
    FOREIGN KEY (id_Equipe1) REFERENCES Equipe(id_Equipe),
    FOREIGN KEY (id_Equipe2) REFERENCES Equipe(id_Equipe)
);

-- CREATE TABLE Tir (
--     id_Tir VARCHAR(9) PRIMARY KEY,
--     id_Joueur VARCHAR(12),
--     id_Rencontre VARCHAR(15),
--     temps TIMESTAMP,
--     tir int,
--     FOREIGN KEY (id_Joueur) REFERENCES Joueur(id_Joueur),
--     FOREIGN KEY (id_Rencontre) REFERENCES Rencontre(id_Rencontre)
-- );

CREATE TABLE Passe (
    id_Passe VARCHAR(11) PRIMARY KEY,
    id_Joueur1 VARCHAR(12),
    id_Joueur2 VARCHAR(12),
    id_Rencontre VARCHAR(15),
    temps TIMESTAMP,
    FOREIGN KEY (id_Joueur1) REFERENCES Joueur(id_Joueur),
    FOREIGN KEY (id_Joueur2) REFERENCES Joueur(id_Joueur),
    FOREIGN KEY (id_Rencontre) REFERENCES Rencontre(id_Rencontre)
);

CREATE TABLE ACTION (
    id_Action VARCHAR(12) PRIMARY KEY,
    id_Joueur VARCHAR(12),
    action VARCHAR(10),
    point int,
    id_Rencontre VARCHAR(15),
    temps TIMESTAMP,
    FOREIGN KEY (id_Joueur) REFERENCES Joueur(id_Joueur),
    FOREIGN KEY (id_Rencontre) REFERENCES Rencontre(id_Rencontre)
); 

CREATE SEQUENCE seq_Rencontre
START WITH 1 
INCREMENT BY 1
NOCACHE;


CREATE SEQUENCE seq_Passe
START WITH 1 
INCREMENT BY 1
NOCACHE;


CREATE SEQUENCE seq_Action
START WITH 1 
INCREMENT BY 1
NOCACHE;


INSERT INTO Equipe VALUES ('Equipe00001','Equipe1');
INSERT INTO Equipe VALUES ('Equipe00002','Equipe2');
INSERT INTO Equipe VALUES ('Equipe00003','Equipe3');
INSERT INTO Equipe VALUES ('Equipe00004','Equipe4');

INSERT INTO JOUEUR VALUES ('Joueur00001','J1_E1','Equipe00001');
INSERT INTO JOUEUR VALUES ('Joueur00002','J2_E1','Equipe00001');
INSERT INTO JOUEUR VALUES ('Joueur00003','J3_E1','Equipe00001');
INSERT INTO JOUEUR VALUES ('Joueur00004','J4_E1','Equipe00001');
INSERT INTO JOUEUR VALUES ('Joueur00005','J5_E1','Equipe00001');

INSERT INTO JOUEUR VALUES ('Joueur00006','J1_E2','Equipe00002');
INSERT INTO JOUEUR VALUES ('Joueur00007','J2_E2','Equipe00002');
INSERT INTO JOUEUR VALUES ('Joueur00008','J3_E2','Equipe00002');
INSERT INTO JOUEUR VALUES ('Joueur00009','J4_E2','Equipe00002');
INSERT INTO JOUEUR VALUES ('Joueur00010','J5_E2','Equipe00002');

INSERT INTO JOUEUR VALUES ('Joueur00011','J1_E3','Equipe00003');
INSERT INTO JOUEUR VALUES ('Joueur00012','J2_E3','Equipe00003');
INSERT INTO JOUEUR VALUES ('Joueur00013','J3_E3','Equipe00003');
INSERT INTO JOUEUR VALUES ('Joueur00014','J4_E3','Equipe00003');
INSERT INTO JOUEUR VALUES ('Joueur00015','J5_E3','Equipe00003');

INSERT INTO JOUEUR VALUES ('Joueur00016','J1_E4','Equipe00004');
INSERT INTO JOUEUR VALUES ('Joueur00017','J2_E4','Equipe00004');
INSERT INTO JOUEUR VALUES ('Joueur00018','J3_E4','Equipe00004');
INSERT INTO JOUEUR VALUES ('Joueur00019','J4_E4','Equipe00004');
INSERT INTO JOUEUR VALUES ('Joueur00020','J5_E4','Equipe00004');

INSERT INTO Rencontre VALUES('Rencontre00001','Equipe00001','Equipe00002');
