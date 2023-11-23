-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Nov 05. 15:38
-- Kiszolgáló verziója: 10.4.24-MariaDB
-- PHP verzió: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `mozimusor`
--
CREATE DATABASE IF NOT EXISTS `mozimusor` DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;
USE `mozimusor`;
-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `film`
--

CREATE TABLE `film` (
  `fkod` int(9) NOT NULL,
  `filmcim` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `szines` tinyint(1) NOT NULL,
  `szinkron` varchar(50) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `szarmazas` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `mufaj` varchar(50) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `hossz` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `film`
--

INSERT INTO `film` (`fkod`, `filmcim`, `szines`, `szinkron`, `szarmazas`, `mufaj`, `hossz`) VALUES
(1, 'Ágnes öcsénk', -1, 'fel', 'német', 'dráma', 115),
(2, 'Az állomásfõnök', -1, 'mb', 'amerikai', 'dráma', 88),
(3, 'Álmodozók', -1, 'fel', 'angol-francia-olasz', 'dráma', 110),
(4, 'Amelie csodálatos élete', -1, 'mb', 'francia-német', 'vígjáték', 117),
(5, 'Annie Hall', -1, 'mb', 'amerikai', 'vígjáték', 89),
(6, 'Anyám a lányokat szereti', -1, 'fel', 'spanyol', 'vígjáték', 96),
(7, 'Anyátlanok', -1, 'fel', 'japán', 'játékfilm', 141),
(8, 'Apokalipszis most - rendezõi változat', -1, 'fel', 'amerikai', 'dráma', 202),
(9, 'Apokalipszis most I-II;', -1, 'fel', 'amerikai', 'dráma', 159),
(10, 'Arizonai álmodozók', -1, 'mb', 'amerikai', 'dráma', 135),
(11, 'Bábok', -1, 'mb', 'japán', 'dráma', 109),
(12, 'Beszélj hozzá!', -1, 'mb', 'spanyol', 'dráma', 109),
(13, 'Bin-jip - Lopakodó lelkek', -1, 'fel', 'dél-koreai-japán', 'dráma', 88),
(14, 'A bíró és a hóhér', -1, 'mb', 'NSZK-olasz', 'krimi', 90),
(15, 'Broken Flowers - Hervadó virágok', -1, 'fel', 'amerikai-francia', 'vígjáték', 105),
(16, 'A bûvös körhinta', -1, 'mb', 'francia', 'animációs', 85),
(17, 'Cápasrác és Lávalány kalandjai', -1, 'mb', 'amerikai', 'kalandfilm', 112),
(18, 'Charlie és a csokigyár', -1, 'mb', 'amerikai-angol', 'vígjáték', 106),
(19, 'Che Guevara: A motoros naplója', 0, 'fel', 'amerikai-angol-argentin-német', 'dráma', 128),
(20, 'Csak szex és más semmi', -1, '', 'magyar', 'vígjáték', 93),
(21, 'Csodacsibe', -1, 'mb', 'amerikai', 'animációs', 77),
(22, 'Csodálatos Júlia', -1, 'mb', 'kanadai', '', 104),
(23, 'Datolya', -1, 'fel', 'belga-francia-tunéziai', '', 82),
(24, 'Dig! - Ezt kapd ki!', -1, 'fel', 'amerikai', 'dokumentum', 107),
(25, 'A diktátor', 0, 'mb', 'amerikai', 'filmszatíra', 120),
(26, 'Dogville - A menedék', -1, 'fel', 'dán-svéd-norvég-német-finn-olasz-japán-angol-ameri', 'dráma', 177),
(27, 'Domino', -1, 'fel', 'francia-amerikai', 'akció', 127),
(28, 'Durr; durr és csók', -1, 'fel', 'amerikai', 'thriller', 103),
(29, 'Edukators', -1, 'fel', 'német-osztrák', 'játékfilm', 127),
(30, 'Egy cipõben', -1, 'fel', 'amerikai', 'vígjáték', 130),
(31, 'Egy hulla, egy falafel és a többiek…', -1, 'fel', 'ausztrál-olasz', 'vígjáték', 107),
(32, 'Egy szoknya, egy nadrág', -1, '', 'magyar', 'vígjáték', 95),
(33, 'Elveszett jelentés', -1, 'mb', 'amerikai-japán', 'dráma', 102),
(34, 'Én, Pán Péter', -1, 'fel', 'angol-amerikai', 'dráma', 106),
(35, 'Eros', -1, 'fel', 'amerikai-olasz-hongkongi-kínai-francia-luxemburgi-', 'dráma', 104),
(36, 'Fej vagy írás', -1, '', 'magyar', 'vígjáték', 90),
(37, 'Fekete Kefe', 0, '', 'magyar', 'vígjáték', 80),
(38, 'A fény ösvényei', -1, '', 'magyar', 'dráma', 89),
(39, 'Futball faktor', -1, 'fel', 'angol', 'dráma', 91),
(40, 'Fûrész 2', -1, 'fel', 'amerikai', 'thriller', 93),
(41, 'Galaxis útikalauz stopposoknak', -1, 'fel', 'amerikai-angol', 'vígjáték', 110),
(42, 'Garfield', -1, 'mb', 'amerikai', 'vígjáték', 81),
(43, 'Genezis', -1, 'mb', 'francia-olasz', 'természetfilm', 81),
(44, 'Getno', -1, '', 'magyar', 'játékfilm', 95),
(45, 'Grimm', -1, 'fel', 'cseh-amerikai', 'fantasy', 118),
(46, 'Ha igaz volna…', -1, 'fel', 'amerikai', 'vígjáték', 95),
(47, 'A halott menyasszony', -1, 'fel', 'angol', 'animációs', 78),
(48, 'Harry Potter és a Tûz Serlege', -1, 'mb', 'amerikai', 'fantasy', 157),
(49, 'Hawaii, Oslo', -1, 'fel', 'dán-svéd-norvég', 'dráma', 125),
(50, 'A hetedik nap', -1, 'fel', 'spanyol', 'dráma', 103),
(51, 'Hétköznapi mennyország', -1, 'fel', 'svéd', 'dráma', 130),
(52, 'Híd a Kwai folyón', -1, 'mb', 'angol-amerikai', 'dráma', 161),
(53, 'Hideg csontok', -1, 'fel', 'spanyol', 'thriller', 100),
(54, 'Holdfényév', -1, 'mb', 'amerikai', 'dráma', 117),
(55, 'Hölgyek levendulában', -1, 'fel', 'angol', 'dráma', 103),
(56, 'Hõs', -1, 'mb', 'hongkongi', '', 96),
(57, 'A hõsök nem pihennek', -1, '', 'francia-osztrák', 'dráma', 104),
(58, 'Human Traffic', -1, '', 'angol-ír', 'vígjáték', 99),
(59, 'Hurrá, nyaralunk!', 0, 'mb', 'szovjet', 'ifjúsági', 74),
(60, 'Az igazi Mikulás', -1, '', 'magyar', 'játékfilm', 90),
(61, 'Az igazság fogságában', -1, 'fel', 'kanadai', '', 108),
(62, 'Az ígéret - Fényes nappal történt', 0, 'fel', 'NSZK-svájci-spanyol', 'krimi', 90),
(63, 'Az ígéret megszállottja', -1, 'fel', 'amerikai', 'dráma', 124),
(64, 'Intimitás', -1, 'mb', 'francia-angol-német-spanyol', 'dráma', 115),
(65, 'Isten városa', -1, 'mb', 'brazil-francia', 'dráma', 130),
(66, 'Játszik még a szív', -1, 'fel', 'angol', 'vígjáték', 100),
(67, 'Johanna', -1, '', 'magyar', 'operafilm', 90),
(68, 'Kairó bíbor rózsája', -1, 'mb', 'amerikai', 'vígjáték', 84),
(69, 'Kávé és cigaretta', 0, 'fel', 'amerikai', 'zenés', 95),
(70, 'Kész cirkusz', -1, '', 'magyar', 'vígjáték', 74),
(71, 'A kilencedik nap', -1, 'fel', 'német-luxemburgi', 'dráma', 98),
(72, 'King Kong', -1, 'mb', 'új-zélandi', '', 188),
(73, 'Kontroll', -1, '', 'magyar', 'thriller', 102),
(74, 'Kõkemény család', -1, 'mb', 'amerikai', 'vígjáték', 104),
(75, 'A közvetítõ', -1, '', 'magyar', 'dokumentum', 89),
(76, 'Kulcsár & Haverok', -1, '', 'magyar', '', 80),
(77, 'Kutyaszorítóban', -1, 'fel', 'amerikai', 'thriller', 99),
(78, 'Kutyátlanok kíméljenek', -1, 'fel', 'amerikai', 'vígjáték', 98),
(79, 'Lakótársat keresünk', -1, 'fel', 'francia-spanyol', 'vígjáték', 120),
(80, 'Leány gyöngy fülbevalóval', -1, 'fel', 'angol-luxemburgi', 'dráma', 95),
(81, 'Légcsavar', -1, 'fel', 'amerikai', 'thriller', 98),
(82, 'A legtöbb ember Kínában él…', -1, 'fel', 'norvég', 'dráma', 82),
(83, 'Lélektõl lélekig', -1, 'fel', 'francia-dél-afrikai-angol', 'kalandfilm', 122),
(84, 'Madagaszkár', -1, 'mb', 'amerikai', 'animációs', 80),
(85, 'Magyar vándor', -1, '', 'magyar', 'vígjáték', 110),
(86, 'Manderlay', -1, 'fel', 'dán-svéd-francia-német-amerikai', 'dráma', 139),
(87, 'Manhattan', 0, 'mb', 'amerikai', 'vígjáték', 96),
(88, 'Maszájok', -1, 'fel', 'francia', 'dráma', 94),
(89, 'Még mindig lakótársat keresünk', -1, 'fel', 'francia-angol', 'vígjáték', 125),
(90, 'Melinda és Melinda', -1, 'fel', 'amerikai', 'vígjáték', 100),
(91, 'Mennyország most', -1, 'fel', 'francia-német-holland-izrael', '', 90),
(92, 'Mezítlábas szerelem', -1, 'fel', 'német', 'vígjáték', 110),
(93, 'Mi a csudát tudunk a világról?', -1, 'mb', 'amerikai', 'játékfilm', 108),
(94, 'Mint egy angyal', -1, 'fel', 'francia-olasz', 'dráma', 110),
(95, 'Monsieur Ibrahim és a Korán virágai', -1, 'fel', 'francia-török', 'dráma', 94),
(96, 'Naqoyqatsi - Erõszakos világ', -1, 'szöv nélkül', 'amerikai', 'filmesszé', 89),
(97, 'Narnia Krónikái - Az oroszlán, a boszorkány és a r', -1, 'mb', 'amerikai-új-zélandi', 'fantasy', 140),
(98, 'Nesze neked, Pete Tong!', -1, 'fel', 'angol-kanadai', 'vígjáték', 90),
(99, 'Nézz balra, ott egy svéd!', -1, 'fel', 'dán', 'vígjáték', 90),
(100, 'Nyomorultak', -1, 'mb', 'francia-olasz-NDK', 'dráma', 225),
(101, 'Oldboy', -1, 'fel', 'dél-koreai', 'thriller', 120),
(102, 'Az operaház fantomja', -1, '', 'amerikai', 'musical', 92),
(103, 'Ördögûzés Emily Rose üdvéért', -1, 'fel', 'amerikai', 'horror', 119),
(104, 'Pata-csata', -1, 'mb', 'dél-afrikai-amerikai', 'vígjáték', 94),
(105, 'Pingvinek vándorlása', -1, 'mb', 'francia', 'dokumentum', 85),
(106, 'A pityergõ teve története', -1, 'fel', 'német-mongol', 'dokumentum', 87),
(107, 'Ponyvaregény - Pulp Fiction', -1, 'fel', 'amerikai', 'filmszatíra', 150),
(108, 'Porcelánbaba', -1, '', 'magyar', 'dráma', 74),
(109, 'Rap, Revü, Rómeó', -1, '', 'magyar', 'vígjáték', 82),
(110, 'A Rashevski tangó', -1, 'fel', 'belga-luxemburgi-francia', '', 90),
(111, 'Rekonstrukció', -1, 'mb', 'dán', 'dráma', 88),
(112, 'A repülõ tõrök klánja', -1, 'fel', 'kínai-hongkongi', 'akció', 111),
(113, 'A rövidek éjszakája', -1, 'fel', 'francia-angol-spanyol-dán', 'rövidfilm', 68),
(114, 'Segítség, hal lettem!', -1, 'mb', 'dán-ír-német', 'animációs', 80),
(115, 'Senki nem tud semmit', 0, 'mb', 'csehszlovák', 'vígjáték', 70),
(116, 'Sin City', -1, 'mb', 'amerikai', 'akció', 124),
(117, 'Sóhajtenger - Kuba', 0, '', 'magyar', 'rövidfilm', 5),
(118, 'Egy sorozatgyilkos nyara', -1, 'mb', 'amerikai', 'dráma', 136),
(119, 'A sötétség útja - Mulholland Drive', -1, 'mb', 'amerikai-francia', 'dráma', 141),
(120, 'Stalker', -1, 'fel', 'szovjet-NSZK', 'sci-fi', 160),
(121, 'Super Size Me', -1, 'fel', 'amerikai', 'dokumentum', 96),
(122, 'Szamszára', -1, 'mb', 'indiai-német-francia-olasz', 'dráma', 140),
(123, 'Szent Lajos király hídja', -1, 'fel', 'spanyol', '', 120),
(124, 'A szenvedélyek labirintusa', -1, 'mb', 'spanyol', 'játékfilm', 100),
(125, 'Szerelmem nyara', -1, 'fel', 'angol', 'dráma', 86),
(126, 'Szeress, ha mersz', -1, 'mb', 'francia-belga', '', 93),
(127, 'Szex, szerelem, olaszok', -1, 'fel', 'olasz-svájci-angol', 'vígjáték', 125),
(128, 'Szõke Kóla', -1, '', 'magyar', 'vígjáték', 96),
(129, 'Szürke, Mercivel', -1, 'fel', 'jugoszláv-német-szlovén-szerb', 'vígjáték', 95),
(130, 'Szürkület', 0, '', 'magyar', 'krimi', 105),
(131, 'Táncos a sötétben', -1, 'mb', 'dán-svéd-francia', 'dráma', 134),
(132, 'Tangó és tulipán', -1, 'fel', 'olasz-svájci', 'vígjáték', 112),
(133, 'Tapló télapó', -1, 'fel', 'amerikai-német', 'vígjáték', 98),
(134, 'Tavasz, Nyár, Õsz, Tél és Tavasz', -1, 'mb', 'dél-koreai-német', 'dráma', 99),
(135, 'Tavasz van', 0, 'fel', 'olasz', 'dráma', 90),
(136, 'Twist Olivér', -1, 'mb', 'angol-cseh-francia-olasz', 'dráma', 130),
(137, 'Utazások egy szerzetessel', -1, '', 'magyar', 'dokumentum', 65),
(138, 'Ütközések', -1, 'fel', 'amerikai-német', 'dráma', 113),
(139, 'Üvegfal', -1, '', 'magyar', 'játékfilm', 87),
(140, 'Üvegtigris', -1, '', 'magyar', 'vígjáték', 100),
(141, 'Vad galamb', -1, 'mb', 'angol', 'animációs', 76),
(142, 'A vágy törvénye', -1, 'fel', 'spanyol', 'dráma', 102),
(143, 'Van élet a halál elõtt?', -1, '', 'magyar', 'dokumentum', 110),
(144, 'A vándorló palota', -1, 'mb', 'japán', 'animációs', 119),
(145, 'Vera Drake', -1, 'fel', 'angol-francia-új-zélandi', 'dráma', 124),
(146, 'Világok arca: Baraka', -1, 'szöveg nélküli', 'amerikai', 'dokumentum', 96),
(147, 'Vincent, François, Paul és a többiek', -1, 'mb', 'francia-olasz', 'dráma', 120),
(148, 'Vízcseppek a forró kövön', -1, 'fel', 'francia', 'dráma', 90),
(149, 'Vuk', -1, '', 'magyar', 'rajzfilm', 74),
(150, 'Wallace & Gromit és az Elvetemült Veteménylény', -1, 'mb', 'angol', 'animációs', 94),
(151, 'Waterloo Bridge', 0, 'fel', 'amerikai', 'dráma', 103),
(152, 'Whisky', -1, 'fel', 'uruguayi-argentin-német-spanyol', 'komédia', 99),
(153, 'Zorro legendája', -1, 'mb', 'amerikai', 'kalandfilm', 131),
(154, '5x2', -1, 'fel', 'francia', 'dráma', 90);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hely`
--

CREATE TABLE `hely` (
  `fkod` int(11) NOT NULL,
  `moziazon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `hely`
--

INSERT INTO `hely` (`fkod`, `moziazon`) VALUES
(1, 8),
(1, 24),
(2, 37),
(3, 21),
(3, 24),
(4, 21),
(5, 27),
(6, 21),
(7, 24),
(7, 39),
(8, 21),
(9, 27),
(10, 27),
(11, 27),
(12, 24),
(13, 24),
(13, 26),
(13, 39),
(14, 27),
(15, 3),
(15, 24),
(15, 32),
(15, 38),
(15, 39),
(16, 12),
(17, 3),
(17, 6),
(17, 13),
(18, 3),
(19, 24),
(20, 9),
(20, 12),
(20, 13),
(20, 14),
(20, 15),
(20, 20),
(20, 26),
(20, 28),
(20, 29),
(20, 30),
(20, 31),
(20, 32),
(20, 41),
(21, 6),
(21, 7),
(21, 9),
(21, 12),
(21, 13),
(21, 14),
(21, 15),
(21, 20),
(21, 28),
(21, 29),
(21, 30),
(21, 31),
(22, 3),
(23, 36),
(24, 36),
(25, 27),
(26, 24),
(27, 6),
(27, 12),
(27, 13),
(27, 14),
(27, 28),
(27, 29),
(27, 31),
(28, 9),
(28, 12),
(28, 13),
(28, 14),
(28, 20),
(28, 29),
(28, 30),
(28, 31),
(28, 32),
(29, 39),
(30, 30),
(31, 3),
(32, 12),
(32, 14),
(32, 16),
(33, 3),
(34, 3),
(35, 24),
(36, 3),
(37, 3),
(37, 36),
(38, 24),
(38, 42),
(39, 16),
(40, 7),
(40, 9),
(40, 12),
(40, 13),
(40, 15),
(40, 28),
(40, 29),
(40, 30),
(40, 31),
(41, 21),
(42, 41),
(43, 3),
(43, 38),
(43, 41),
(44, 12),
(44, 13),
(45, 29),
(45, 39),
(45, 41),
(46, 12),
(46, 13),
(46, 14),
(46, 28),
(46, 29),
(46, 31),
(47, 20),
(47, 39),
(47, 42),
(48, 6),
(48, 7),
(48, 9),
(48, 12),
(48, 13),
(48, 14),
(48, 15),
(48, 20),
(48, 28),
(48, 29),
(48, 30),
(48, 31),
(49, 37),
(50, 8),
(50, 24),
(51, 26),
(51, 37),
(51, 39),
(52, 27),
(53, 6),
(53, 13),
(53, 15),
(53, 28),
(53, 29),
(53, 31),
(54, 3),
(55, 16),
(55, 24),
(55, 32),
(56, 38),
(57, 36),
(58, 16),
(59, 21),
(60, 41),
(61, 16),
(61, 24),
(61, 29),
(61, 37),
(61, 39),
(61, 41),
(61, 42),
(62, 27),
(63, 27),
(64, 24),
(65, 24),
(66, 28),
(66, 29),
(66, 30),
(66, 31),
(67, 24),
(68, 27),
(69, 21),
(69, 36),
(70, 21),
(71, 3),
(71, 21),
(72, 6),
(72, 7),
(72, 9),
(72, 12),
(72, 13),
(72, 14),
(72, 15),
(72, 20),
(72, 28),
(72, 29),
(72, 30),
(72, 31),
(73, 21),
(74, 6),
(74, 9),
(74, 12),
(74, 13),
(74, 14),
(74, 15),
(74, 28),
(74, 29),
(74, 30),
(74, 31),
(74, 32),
(75, 41),
(76, 42),
(77, 21),
(78, 3),
(79, 37),
(80, 37),
(80, 38),
(81, 16),
(81, 29),
(82, 8),
(83, 21),
(84, 12),
(84, 21),
(84, 37),
(84, 41),
(85, 20),
(86, 24),
(87, 27),
(88, 8),
(89, 21),
(89, 38),
(90, 24),
(91, 24),
(91, 26),
(91, 38),
(92, 3),
(92, 24),
(93, 26),
(93, 38),
(93, 41),
(94, 39),
(95, 24),
(95, 36),
(96, 21),
(97, 6),
(97, 7),
(97, 9),
(97, 12),
(97, 13),
(97, 14),
(97, 15),
(97, 28),
(97, 29),
(97, 30),
(97, 31),
(98, 24),
(98, 36),
(98, 39),
(98, 41),
(98, 42),
(99, 39),
(100, 38),
(101, 21),
(101, 28),
(101, 39),
(102, 27),
(103, 12),
(104, 41),
(105, 24),
(105, 26),
(105, 30),
(105, 38),
(105, 41),
(105, 42),
(106, 37),
(107, 24),
(107, 26),
(107, 42),
(108, 24),
(108, 37),
(109, 12),
(109, 13),
(109, 14),
(110, 24),
(110, 26),
(110, 32),
(110, 36),
(110, 39),
(111, 21),
(112, 3),
(112, 21),
(113, 21),
(114, 41),
(115, 27),
(116, 3),
(116, 24),
(117, 24),
(117, 26),
(117, 39),
(118, 21),
(119, 39),
(120, 8),
(121, 21),
(122, 38),
(123, 24),
(123, 32),
(123, 41),
(124, 26),
(125, 24),
(126, 21),
(127, 24),
(128, 6),
(128, 9),
(128, 12),
(128, 13),
(128, 14),
(128, 28),
(128, 29),
(128, 30),
(128, 31),
(129, 37),
(130, 27),
(131, 24),
(132, 24),
(133, 26),
(134, 21),
(134, 38),
(135, 27),
(136, 16),
(136, 24),
(136, 32),
(136, 41),
(136, 42),
(137, 38),
(138, 16),
(139, 37),
(139, 41),
(140, 21),
(141, 3),
(141, 41),
(142, 24),
(143, 38),
(144, 9),
(144, 13),
(144, 24),
(144, 29),
(144, 30),
(144, 41),
(145, 24),
(146, 38),
(147, 27),
(148, 21),
(149, 21),
(150, 6),
(150, 12),
(150, 13),
(150, 14),
(150, 36),
(151, 27),
(152, 37),
(153, 12),
(153, 16),
(153, 41),
(154, 21),
(154, 24),
(154, 37);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_hungarian_ci NOT NULL,
  `text` varchar(250) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `mozi`
--

CREATE TABLE `mozi` (
  `moziazon` int(11) NOT NULL,
  `mozinev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `irszam` int(11) NOT NULL,
  `cim` varchar(150) COLLATE utf8_hungarian_ci NOT NULL,
  `telefon` varchar(15) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `mozi`
--

INSERT INTO `mozi` (`moziazon`, `mozinev`, `irszam`, `cim`, `telefon`) VALUES
(1, 'A38 Hajó', 1113, 'Petõfi híd budai hídfõ', '4643940'),
(2, 'Bárka Kikötõ a Ráday utcában', 1092, 'Ráday utca', ''),
(3, 'Bem', 1024, 'Margit krt. 5/b.', '3168708'),
(4, 'Budapesti Európai Ifjúsági Központ', 1024, 'Zivatar u. 1-3.', '2124080'),
(5, 'Cervantes Intézet', 1000, 'Vörösmarty u. 32.', ''),
(6, 'Cinema City Csepel Plaza', 1212, 'Rákóczi F. út 154-170.', '4258111'),
(7, 'Cinema City Új Udvar', 1036, 'Bécsi út 38-44.', '4378383'),
(8, 'Cirko-Gejzír', 1055, 'Balassi Bálint u. 15-17.', '2690904'),
(9, 'Corvin Budapest Filmpalota', 1082, 'Corvin köz 1.', '4595050'),
(10, 'Erlin 9 galéria', 1000, 'Ráday utca', ''),
(11, 'FilmesHáz', 1092, 'Ráday utca 31/K', ''),
(12, 'Hollywood Multiplex Duna Plaza', 1138, 'Váci út 178. (Duna Plaza)', '4674267'),
(13, 'Hollywood Multiplex Lurdy Ház', 1092, 'Mester utca és Könyves Kálmán körút sarok', '4674267'),
(14, 'Hollywood Multiplex Óbuda', 1030, 'Bécsi út 154. (Eurocenter)', '4674267'),
(15, 'Hollywood Multiplex Pólus', 1152, 'Szentmihályi út 131.', '4674267'),
(16, 'Hunnia', 1073, 'Erzsébet krt. 26.', ''),
(17, 'Jailhouse Club', 1094, 'IX. kerület, Tûzoltó utca 22.', '9894905'),
(18, 'Jókai klub', 1121, 'Hollós út 5.', '3925452'),
(19, 'Kis Erkel', 1000, 'Ráday utca', ''),
(20, 'Kossuth Mozi', 1132, 'Váci út 14.', '4674260'),
(21, 'Kultiplex', 1095, 'Kinizsi u. 28.', '2190706'),
(22, 'Millenáris Fogadó', 1024, 'Kisrókus u. 16-20.', '4361717'),
(23, 'Mûcsarnok', 1406, 'Hõsõk tere', ''),
(24, 'Mûvész', 1066, 'Teréz krt. 30.', '3326726'),
(25, 'Mûvészetek Palotája', 1095, 'Komor Marcell u. 1.', '5553000'),
(26, 'Odeon-Lloyd mozi', 1136, 'Hollán Ernõ utca 7.', '3292064'),
(27, 'Örökmozgó', 1073, 'Erzsébet krt. 39.', '3422167'),
(28, 'Palace Campona', 1222, 'Nagytétényi út 37-43.', '3458160'),
(29, 'Palace Mammut', 1024, 'Lövõház u. 2-6.', '3458160'),
(30, 'Palace MOM Park', 1123, 'Alkotás út 53.', '3458160'),
(31, 'Palace Westend', 1062, 'Váci út 1-3.', '3365555'),
(32, 'Puskin', 1053, 'Kossuth L. u. 18.', '4296080'),
(33, 'Ráday könyves ház', 1000, 'Ráday utca', ''),
(34, 'Sambhala Tibet Központ', 1088, 'Lõrinc pap tér 2.', '2668084'),
(35, 'Science Park', 1117, 'Irínyi József u. 4.-20.', ''),
(36, 'Szimpla Kert Mozi', 1075, 'Kazinczy u. 14.', '3215880'),
(37, 'Szindbád', 1137, 'Szent István krt. 16.', '3492773'),
(38, 'Tabán', 1016, 'Krisztina krt. 87-89.', '3568162'),
(39, 'Toldi', 1054, 'Bajcsy-Zsilinszky út 36-38.', '4720397'),
(40, 'Tûzraktár', 1094, 'Tûzoltó u. 54-56', ''),
(41, 'Uránia Nemzeti Filmszínház', 1088, 'Rákóczi út 21.', '4863413'),
(42, 'Vörösmarty', 1075, 'Üllõi út 4.', '3174542');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role_name` varchar(10) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `roles`
--

INSERT INTO `roles` (`id`, `role_name`) VALUES
(1, 'Guest'),
(2, 'User'),
(3, 'Admin');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_hungarian_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `roleid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`fkod`);

--
-- A tábla indexei `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `mozi`
--
ALTER TABLE `mozi`
  ADD PRIMARY KEY (`moziazon`);

--
-- A tábla indexei `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
