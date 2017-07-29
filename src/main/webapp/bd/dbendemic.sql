-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 10-Jul-2017 às 22:57
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE SCHEMA IF NOT EXISTS `dbendemic` DEFAULT CHARACTER SET utf8 ;
USE `dbendemic` ;

--
-- Database: `dbendemic`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `denuncia`
--

CREATE TABLE `denuncia` (
  `iddenuncia` int(11) NOT NULL,
  `data_denuncia` datetime NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `quadra` varchar(5) DEFAULT NULL,
  `lote` varchar(5) DEFAULT NULL,
  `numero` varchar(5) DEFAULT NULL,
  `cidade` varchar(30) NOT NULL,
  `tp_imovel` varchar(15) NOT NULL,
  `desc_den` varchar(300) NOT NULL,
  `denunciante` varchar(255) NOT NULL,
  `cep` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `denuncia`
--

INSERT INTO `denuncia` (`iddenuncia`, `data_denuncia`, `bairro`, `rua`, `quadra`, `lote`, `numero`, `cidade`, `tp_imovel`, `desc_den`, `denunciante`, `cep`) VALUES
(1, '2017-06-14 06:45:00', 'Setor Aeroporto', 'Rua Antonio Carlos', '10', '8', '1', 'Goiania', 'Apartamento', 'A casa dos fundos está com muitos focos de dengue.', 'Maria Antonieta da Silva', '75400000'),
(2, '2017-07-03 00:00:00', 'Centro', 'Rua 1', '10', '11', '2', 'Goiania', 'Apartamento', 'No condomínio, a caixa d''agua está cheia de larvas.', 'Leonardo José', '74000000'),
(3, '2017-07-03 00:00:00', 'Setor Goiá', 'Rua X', '34', '12', '1', 'Goiania', 'Loja', 'O vizinho de frente acumula água nos vasos de planta.', 'João Nascimento', '74000000'),
(4, '2017-07-04 00:00:00', 'Leste Vila Nova', 'Rua X', '10', '10', '10', 'Goiania', 'Apartamento', 'O condomínio possui muitos focos de mosquito da dengue.', 'Mogli Cunhal', '74000000'),
(5, '2017-07-13 05:00:00', 'Nova Vila', 'Rua A', '10', '10', '10', 'Goiania', 'Casa', 'José Peixoto', 'José Peixoto', '74000000'),
(6, '2017-07-05 06:00:00', 'Setor Alto da Glória', 'Rua AAA', '10', '11', '50', 'Goiania', 'Apartamento', 'Muitos pneus acumulando água na rua.', 'Adriana Silveira', '74000000'),
(7, '2017-07-07 00:00:00', 'Setor Jaó', 'AAA', '1', '1', '1', 'Aparecida de Goiânia', 'Casa', 'Muitos focos na rua.', 'Marcos Daniel da Silva', '10');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `matricula` varchar(10) CHARACTER SET utf8 NOT NULL,
  `nome` varchar(60) CHARACTER SET utf8 NOT NULL,
  `funcao` varchar(20) CHARACTER SET utf8 NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `senha` varchar(15) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `matricula`, `nome`, `funcao`, `email`, `senha`) VALUES
(1, 'admin', 'Administrador', 'Administrador', 'administrador@sysendemic.com', 'admin'),
(2, '100001', 'Sabrina Carneiro', 'Atendente', 'sabrina@sysendemic.com', '123'),
(3, '100002', 'Henrique Coimbra', 'Agente', 'henrique@sysendemic.com', '123'),
(4, '100003', 'Eduardo Braz', 'Agente', 'eduardo@sysendemic.com', '123'),
(5, '100004', 'Marieta Severo', 'Atendente', 'marieta@sysendemic.com', '123'),
(6, '100005', 'Lorena Abrahão', 'Atendente', 'lorena@sysendemic.com', '123'),
(7, '100006', 'Márcio Coimbra', 'Agente', 'marcio@sysendemic.com', '123'),
(8, '100007', 'Cinara de Jesus', 'Agente', 'cinara@sysendemic.com', '123'),
(9, '100008', 'Marcos Nascimento Pereira', 'Agente', 'marcos@sysendemic.com', '123'),
(10, '100009', 'Lourenço Peixoto', 'Atendente', 'lourenco@sysendemic.com', '123'),
(11, '100010', 'Moisés Assunção', 'Agente', 'moises@sysendemic.com', '123'),
(12, '100011', 'Maria de Fátima da Silva', 'Atendente', 'maria@sysendemic.com', '123'),
(13, '100012', 'Carlos Daniel Menezes', 'Atendente', 'carlos@sysendemic.com', '123'),
(14, '100013', 'Zélia Costa', 'Agente', 'zelia@sysendmic.com', '123'),
(15, '100014', 'Talita Queróz', 'Agente', 'talita@sysendmic.com', '123'),
(16, '100015', 'Bruna Nunes', 'Agente', 'bruna@sysendemic.com', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `visita`
--

CREATE TABLE `visita` (
  `idvisita` int(11) NOT NULL,
  `agente` varchar(60) NOT NULL,
  `data_visita` datetime NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `quadra` varchar(5) NOT NULL,
  `lote` int(11) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `cep` int(11) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `latitude` varchar(20) DEFAULT NULL,
  `longitude` varchar(20) DEFAULT NULL,
  `tp_imovel` varchar(15) NOT NULL,
  `estagio` varchar(10) NOT NULL,
  `tp_larvicida` varchar(10) NOT NULL,
  `ac_corretiva` varchar(15) NOT NULL,
  `local_foco` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `visita`
--

INSERT INTO `visita` (`idvisita`, `agente`, `data_visita`, `bairro`, `rua`, `quadra`, `lote`, `numero`, `cep`, `cidade`, `latitude`, `longitude`, `tp_imovel`, `estagio`, `tp_larvicida`, `ac_corretiva`, `local_foco`) VALUES
(1, 'Henrique Coimbra', '2017-02-13 00:00:00', 'Negrão de Lima', 'Rua Dona Gercina', '25', 2, 'sn', 74650130, 'Goiânia', '-16.652459', '-49.244200', 'Casa', 'Pupa', 'Tipo 2', 'Borrifacao', 'garrafas plásticas'),
(2, 'Eduardo Braz', '2017-03-21 00:00:00', 'Morada Nova', 'Avenida Antonio Alves', '20', 16, '2', 756000000, 'Senador Canedo', '-16.695039', '-49.101233', 'Apartamento', 'Larva', 'Tipo 1', 'Nebolização', 'caixa d''agua'),
(3, 'Márcio Coimbra', '2017-04-11 00:00:00', 'Setor dos Arcos', 'Rua Rodriguez Peixoto', '10', 11, 'sn', 74000000, 'Aparecida de Goiânia', '-16.824134', '-49.253728', 'Deposito', 'Mosquito', 'Tipo 3', 'Borrifação', 'espalhado por todo depósito'),
(4, 'Cinara de Jesus', '2017-07-03 17:00:00', 'Setor Aeroporto', 'Avenida Independência', '20', 12, '10', 74000000, 'Goiânia', '-16.669820', '-49.276510', 'Loja', 'Ovo', 'Tipo 1', 'Nebolização', ''),
(5, 'Marcos Nascimento Pereira', '2017-05-09 00:00:00', 'Setor Jaó', 'Alameda Couto Paranhos', '10', 47, 'sn', 74000000, 'Goiânia', '-16.643337', '-49.235922', 'Sala', 'Mosquito', 'Tipo 3', 'Borrifação', 'vasos'),
(6, 'Moisés Assunção', '2017-02-20 00:00:00', 'Santa Genoveva', 'Rua Alberto Gonçalez', '54', 11, '2', 74001000, 'Goiânia', '-16.633160', '-49.236371', 'Apartamento', 'Pupa', 'Tipo 3', 'Borrifação', 'vasos'),
(7, 'Zélia Costa', '2017-07-03 00:00:00', 'Aeroviário', 'Rua 3', '44', 9, 'sn', 74550000, 'Trindade', '-16.635824', '-49.494415', 'Casa', 'Mosquito', 'Tipo 3', 'Borrifação', 'Caixa dágua'),
(8, 'Talita Queróz', '2017-07-10 00:00:00', 'Goiá', 'Rua dos Mosqueteiro', '20', 20, '20', 74000000, 'Goiânia', '-16.751548', '-49.293462', 'Deposito', 'Pupa', 'Tipo 2', 'Nebolização', 'Espalhado por embalagens'),
(9, 'Bruna Nunes', '2017-06-13 00:00:00', 'Negrão de Lima', 'Rua das Flores', '10', 11, '12', 74000000, 'Aparecida de Goiânia', '-16.751548', '-49.293462', 'Casa', 'Pupa', 'Tipo 2', 'Nebolização', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `denuncia`
--
ALTER TABLE `denuncia`
  ADD PRIMARY KEY (`iddenuncia`),
  ADD UNIQUE KEY `iddenuncia_UNIQUE` (`iddenuncia`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`),
  ADD UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  ADD UNIQUE KEY `idfuncionario_UNIQUE` (`idfuncionario`);

--
-- Indexes for table `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`idvisita`),
  ADD UNIQUE KEY `idvisita_UNIQUE` (`idvisita`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `denuncia`
--
ALTER TABLE `denuncia`
  MODIFY `iddenuncia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `visita`
--
ALTER TABLE `visita`
  MODIFY `idvisita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
