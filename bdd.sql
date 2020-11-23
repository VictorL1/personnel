--
-- Création de la base de données :  personnel - PPE Java
--

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` 
(
  `idEmploye` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `dateFin` date DEFAULT NULL,
  `dateDebut` date NOT NULL,
  `estAdmin` int(1) NOT NULL DEFAULT 0, -- par défaut à 0, 
  `estRoot` int(1) NOT NULL DEFAULT 0, -- par défaut à 0,
  `ligueID` int(11) NOT NULL,
  PRIMARY KEY (`idEmploye`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ligue`
--

DROP TABLE IF EXISTS `ligue`;
CREATE TABLE IF NOT EXISTS `ligue` 
(
  `idLigue` int(11) NOT NULL AUTO_INCREMENT,
  `nomLigue` varchar(255) NOT NULL,
  PRIMARY KEY (`idLigue`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
COMMIT;

ALTER TABLE `employe`
  ADD CONSTRAINT FK_EmpLigue FOREIGN KEY (ligueID) REFERENCES ligue(idLigue);
