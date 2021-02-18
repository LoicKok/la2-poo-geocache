-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 01 fév. 2021 à 16:24
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `geocache`
--

-- --------------------------------------------------------

--
-- Structure de la table `cache`
--

DROP TABLE IF EXISTS `cache`;
CREATE TABLE IF NOT EXISTS `cache` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lieu` int(11) DEFAULT NULL,
  `proprietaire` int(11) DEFAULT NULL,
  `description` text,
  `typeCache` char(1) NOT NULL DEFAULT 'T',
  `natureCache` char(1) DEFAULT 'P',
  `etat` char(1) DEFAULT 'A',
  `coordGPS` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cache_user_id_fk` (`proprietaire`),
  KEY `cache_lieu_id_fk` (`lieu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(64) DEFAULT NULL,
  `ville` varchar(128) DEFAULT NULL,
  `codep` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(25) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `visite`
--

DROP TABLE IF EXISTS `visite`;
CREATE TABLE IF NOT EXISTS `visite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cache` int(11) DEFAULT NULL,
  `visiteur` int(11) DEFAULT NULL,
  `dateVisite` date DEFAULT NULL,
  `photoVisite` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `visite_cache_id_fk` (`cache`),
  KEY `visite_user_id_fk` (`visiteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cache`
--
ALTER TABLE `cache`
  ADD CONSTRAINT `cache_lieu_id_fk` FOREIGN KEY (`lieu`) REFERENCES `lieu` (`id`),
  ADD CONSTRAINT `cache_user_id_fk` FOREIGN KEY (`proprietaire`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `visite_cache_id_fk` FOREIGN KEY (`cache`) REFERENCES `cache` (`id`),
  ADD CONSTRAINT `visite_user_id_fk` FOREIGN KEY (`visiteur`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
