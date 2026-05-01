-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 10 mars 2026 à 10:24
-- Version du serveur : 5.7.31
-- Version de PHP : 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de données : `amset`
--
CREATE DATABASE IF NOT EXISTS `amset` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `amset`;

-- --------------------------------------------------------

--
-- Structure de la table `salarie`
--

DROP TABLE IF EXISTS `salarie`;
CREATE TABLE IF NOT EXISTS `salarie` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(127) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(127) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fonction` varchar(127) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_naissance` date NOT NULL,
  `service_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_service_id` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `salarie`
--

INSERT INTO `salarie` (`id`, `nom`, `prenom`, `fonction`, `date_naissance`, `service_id`) VALUES
(2, 'Martin', 'Lucas', 'Directeur général', '1972-03-12', 1),
(3, 'Bernard', 'Emma', 'Assistante de direction', '1988-07-25', 1),
(4, 'Petit', 'Louis', 'Responsable RH', '1984-02-14', 2),
(5, 'Durand', 'Manon', 'Chargée de recrutement', '1993-12-02', 2),
(6, 'Fournier', 'Eva', 'Assistante RH', '1999-02-09', 2),
(7, 'Martinez', 'Anais', 'Chargée de formation', '1993-08-11', 2),
(8, 'Laurent', 'Inès', 'Juriste', '1989-08-27', 3),
(9, 'Michel', 'Sarah', 'Juriste senior', '1986-07-14', 3),
(10, 'Andre', 'Paul', 'Directeur juridique', '1970-04-15', 3),
(11, 'Thomas', 'Chloé', 'Comptable', '1985-01-17', 4),
(12, 'Bonnet', 'Elise', 'Comptable senior', '1983-02-26', 4),
(13, 'Garnier', 'Lucie', 'Responsable administrative et financière', '1981-07-18', 4),
(14, 'Roussel', 'Florian', 'Contrôleur de gestion', '1991-01-22', 4),
(15, 'Richard', 'Léa', 'Chargée de communication', '1996-05-21', 5),
(16, 'Bernard', 'Julien', 'Responsable marketing', '1987-11-03', 5),
(17, 'Moreau', 'Camille', 'Graphiste', '1997-10-08', 5),
(18, 'Rousseau', 'Pauline', 'Community manager', '1997-04-23', 5),
(19, 'Francois', 'Victor', 'Chef de produit', '1989-09-30', 5),
(20, 'Vincent', 'Antoine', 'Responsable commercial', '1982-06-22', 6),
(21, 'Henry', 'Oceane', 'Chargée de clientèle', '1996-09-07', 6),
(22, 'Muller', 'Nicolas', 'Directeur commercial', '1975-03-03', 6),
(23, 'Legrand', 'Romain', 'Commercial grands comptes', '1984-05-04', 6),
(24, 'Dupont', 'Marine', 'Commerciale', '1992-06-12', 6),
(25, 'Garcia', 'Enzo', 'Ingénieur réseau', '1990-11-11', 7),
(26, 'Dubois', 'Hugo', 'Administrateur systèmes', '1992-11-03', 7),
(27, 'Simon', 'Arthur', 'Développeur backend', '1993-04-18', 7),
(28, 'Bertrand', 'Théo', 'Développeur frontend', '1999-09-16', 7),
(29, 'Faure', 'Mathis', 'Développeur full stack', '1998-12-01', 7),
(30, 'Blanc', 'Adrien', 'Data engineer', '1992-10-14', 7),
(31, 'Mercier', 'Alexandre', 'Analyste cybersécurité', '1990-03-28', 7),
(32, 'Leroy', 'Gabriel', 'Data analyst', '1994-06-30', 7),
(33, 'Robert', 'Nathan', 'Chef de projet IT', '1984-09-09', 7),
(34, 'Morel', 'Maxime', 'Ingénieur logiciel', '1991-05-13', 7),
(35, 'Lefebvre', 'Jules', 'DevOps', '1991-03-05', 7),
(36, 'Lefevre', 'Zoé', 'Développeuse mobile', '1997-01-07', 7),
(37, 'Lambert', 'Baptiste', 'Technicien support', '1996-11-20', 7),
(38, 'Girard', 'Laura', 'Consultante IT', '1988-10-04', 7),
(39, 'David', 'Julie', 'Product owner', '1986-01-29', 7),
(40, 'Roux', 'Clara', 'UX designer', '1995-12-19', 7),
(41, 'Nicolas', 'Margaux', 'Testeur QA', '1994-11-26', 7);

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(127) COLLATE utf8mb4_unicode_ci NOT NULL,
  `administratif` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`id`, `nom`, `administratif`) VALUES
(1, 'direction', 1),
(2, 'RH', 1),
(3, 'juridique', 1),
(4, 'comptable et financier', 1),
(5, 'marketing', 0),
(6, 'commercial', 0),
(7, 'informatique', 0);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `salarie`
--
ALTER TABLE `salarie`
  ADD CONSTRAINT `FK_service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`);
COMMIT;
