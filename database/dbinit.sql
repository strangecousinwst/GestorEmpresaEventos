DROP DATABASE IF EXISTS efa0124_08_joao_gestor_empresa;
CREATE DATABASE efa0124_08_joao_gestor_empresa;
USE efa0124_08_joao_gestor_empresa;

CREATE TABLE utilizador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL,
    tipo_utilizador ENUM('administrador', 'funcionario') NOT NULL
);

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telemovel VARCHAR(20),
    localidade VARCHAR(100) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE servico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    estado ENUM('aberto', 'seguimento', 'concluido', 'cancelado') DEFAULT 'aberto',
    preco DECIMAL(10, 2),
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
    ON DELETE CASCADE
);

CREATE TABLE processo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_servico INT NOT NULL,
    id_funcionario INT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    custo DECIMAL(10,2) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_servico) REFERENCES servico(id),
    FOREIGN KEY (id_funcionario) REFERENCES utilizador(id)
    ON DELETE CASCADE
);

INSERT INTO utilizador (nome, email, password, tipo_utilizador) VALUES 
('root', 'root', 'root', 'administrador'),
('Admin Backup', 'admin@empresa.com', 'admin123', 'administrador'),
('Diego Carrilho', 'cumprimentos@bruno.carvalho', '123', 'funcionario'),
('Rui Boticas', 'ruiboticas@email.com', '123', 'funcionario'),
('Ana Morais', 'ana.morais@email.com', '123', 'funcionario'),
('João Silva', 'joao.silva@email.com', '123', 'funcionario'),
('Sofia Rocha', 'sofia.rocha@email.com', '123', 'funcionario'),
('Miguel Correia', 'miguel.correia@email.com', '123', 'funcionario'),
('Helena Braga', 'helena.braga@email.com', '123', 'funcionario'),
('Lucas Amaral', 'lucas.amaral@email.com', '123', 'funcionario'),
('Carolina Silva', 'carolina.silva@email.com', '123', 'funcionario'),
('Fábio Moreira', 'fabio.moreira@email.com', '123', 'funcionario'),
('Patrícia Andrade', 'patricia.andrade@email.com', '123', 'funcionario'),
('Ricardo Mendes', 'ricardo.mendes@email.com', '123', 'funcionario'),
('Leonor Garcia', 'leonor.garcia@email.com', '123', 'funcionario'),
('Pedro Santos', 'pedro.santos@email.com', '123', 'funcionario'),
('Clara Rodrigues', 'clara.rodrigues@email.com', '123', 'funcionario'),
('Carlos Silva', 'carlos.silva@email.com', '123', 'funcionario'),
('Marta Ferreira', 'marta.ferreira@email.com', '123', 'funcionario'),
('Mariana Costa', 'mariana.costa@email.com', '123', 'funcionario'),
('António Pinto', 'antonio.pinto@email.com', '123', 'funcionario'),
('Inês Santos', 'ines.santos@email.com', '123', 'funcionario'),
('David Ferreira', 'david.ferreira@email.com', '123', 'funcionario'),
('Teresa Oliveira', 'teresa.oliveira@email.com', '123', 'funcionario'),
('Bruno Castro', 'bruno.castro@email.com', '123', 'funcionario'),
('Rita Machado', 'rita.machado@email.com', '123', 'funcionario'),
('Francisco Lima', 'francisco.lima@email.com', '123', 'funcionario');

INSERT INTO cliente (nome, email, telemovel, localidade) VALUES
('Marcos', 'marcos@email.com', '912345678', 'Mazagão'),
('Pêjota', 'pejota@email.com', '987654321', 'Mazagão'),
('Carla Almeida', 'carla.almeida@email.com', '921234567', 'Lisboa'),
('Tiago Fernandes', 'tiago.fernandes@email.com', '934567890', 'Porto'),
('Beatriz Costa', 'beatriz.costa@email.com', '911234567', 'Faro'),
('Hugo Martins', 'hugo.martins@email.com', '923456789', 'Coimbra'),
('Vera Sousa', 'vera.sousa@email.com', '933567890', 'Braga'),
('André Figueiredo', 'andre.figueiredo@email.com', '914567891', 'Aveiro'),
('Soraia Lopes', 'soraia.lopes@email.com', '915678912', 'Guimarães'),
('Cláudia Ferreira', 'claudia.ferreira@email.com', '916789123', 'Setúbal'),
('Bruno Matos', 'bruno.matos@email.com', '917891234', 'Évora'),
('Diana Cunha', 'diana.cunha@email.com', '918912345', 'Leiria'),
('João Correia', 'joao.correia@email.com', '914321098', 'Portimão'),
('Ana Marques', 'ana.marques@email.com', '913210987', 'Funchal'),
('Luís Monteiro', 'luis.monteiro@email.com', '912109876', 'Ponta Delgada'),
('Empresa Tech Solutions', 'contact@techsolutions.pt', '931234567', 'Lisboa'),
('Hotel Maravilha', 'eventos@hotelmaravilha.pt', '962345678', 'Porto'),
('Câmara Municipal de Braga', 'eventos@cmbraga.pt', '253123456', 'Braga'),
('Associação Cultural do Norte', 'geral@acnorte.pt', '922345678', 'Porto'),
('Festival Verão Quente', 'producer@veraoquente.pt', '935678901', 'Faro'),
('Universidade Nova', 'eventos@unova.pt', '213456789', 'Lisboa'),
('Teatro Municipal', 'producao@teatromunicipal.pt', '234567890', 'Aveiro'),
('Fundação Arte e Cultura', 'eventos@fundacaoarte.pt', '919876543', 'Coimbra'),
('Escola de Música do Porto', 'concertos@empmusica.pt', '229876543', 'Porto'),
('Casino Estoril', 'eventos@casinoestoril.pt', '214567890', 'Cascais'),
('Restaurante Sabor do Mar', 'eventos@sabordomar.pt', '915555666', 'Matosinhos'),
('Maria Antónia Produções', 'maria@maproducoes.pt', '936666777', 'Lisboa'),
('Bar Noite Velha', 'eventos@noitevelha.pt', '927777888', 'Porto'),
('Quinta dos Sonhos', 'reservas@quintasonhos.pt', '968888999', 'Sintra'),
('Pedro Mendes', 'pedro.mendes@email.com', '939999000', 'Oeiras'),
('Galeria Nova Arte', 'expo@novarte.pt', '911112222', 'Lisboa'),
('Banda Os Trovadores', 'booking@trovadores.pt', '922223333', 'Braga'),
('Sara Eventos', 'sara@saraeventos.pt', '933334444', 'Faro'),
('Club Millennium', 'eventos@millennium.pt', '944445555', 'Lisboa'),
('Instituto de Dança', 'espetaculos@institutodanca.pt', '955556666', 'Porto'),
('Carlos Almeida', 'carlos.almeida@email.com', '939595959', 'Lisboa'),
('Vanessa Ferreira', 'vanessa.ferreira@email.com', '938484848', 'Porto'),
('Paulo Nunes', 'paulo.nunes@email.com', '937373737', 'Faro'),
('Ricardo Costa', 'ricardo.costa@email.com', '936262626', 'Coimbra'),
('Ana Melo', 'ana.melo@email.com', '935151515', 'Braga'),
('Miguel Barbosa', 'miguel.barbosa@email.com', '934040404', 'Aveiro'),
('Helena Fernandes', 'helena.fernandes@email.com', '933939393', 'Guimarães'),
('João Martins', 'joao.martins@email.com', '932828282', 'Setúbal'),
('Sandra Silva', 'sandra.silva@email.com', '931717171', 'Évora'),
('Pedro Gomes', 'pedro.gomes@email.com', '930606060', 'Leiria'),
('Banco Futuro', 'eventos@bancofuturo.pt', '917777888', 'Lisboa'),
('Seguros Premium', 'marketing@segurospremium.pt', '928888999', 'Porto'),
('Tech Innovations Lab', 'events@techlab.pt', '939999000', 'Braga'),
('Green Energy Portugal', 'corporate@greenergy.pt', '960000111', 'Sines'),
('Fashion World', 'events@fashionworld.pt', '911111222', 'Lisboa'),
('Sports Academy', 'info@sportsacademy.pt', '922222333', 'Coimbra'),
('Global Consulting Group', 'events@gcgroup.pt', '933333444', 'Porto'),
('Medical Center Plus', 'marketing@medplus.pt', '944444555', 'Lisboa'),
('Auto Premium', 'eventos@autopremium.pt', '955555666', 'Faro'),
('Edu Solutions', 'contact@edusolutions.pt', '966666777', 'Aveiro'),
('Arena Atlântico', 'booking@arenaatlantico.pt', '977777888', 'Lisboa'),
('Clube Jazz Hot', 'eventos@jazzhotclub.pt', '988888999', 'Porto'),
('Teatro Riviera', 'producao@teatroriviera.pt', '999999000', 'Cascais'),
('Discoteca Platinum', 'eventos@platinum.pt', '910000111', 'Albufeira'),
('Centro Cultural Norte', 'eventos@ccnorte.pt', '921111222', 'Guimarães'),
('Pavilhão Multiusos', 'reservas@multiusos.pt', '932222333', 'Leiria'),
('Estádio Central', 'eventos@estadiocentral.pt', '943333444', 'Porto'),
('Casa da Música Nova', 'prog@musicanova.pt', '954444555', 'Braga'),
('Galeria Moderna', 'expo@galeriamoderna.pt', '965555666', 'Lisboa'),
('Quinta dos Eventos', 'reservas@quintaeventos.pt', '976666777', 'Sintra'),
('Henrique Monteiro', 'henrique.monteiro@email.com', '917123456', 'Porto'),
('Sofia Carvalho', 'sofia.carvalho@email.com', '928234567', 'Lisboa'),
('Martim Rodrigues', 'martim.rodrigues@email.com', '939345678', 'Braga'),
('Clara Oliveira', 'clara.oliveira@email.com', '940456789', 'Coimbra'),
('Ricardo Sousa', 'ricardo.sousa@email.com', '951567890', 'Faro'),
('Rafael Almeida', 'rafael.almeida@email.com', '918765432', 'Cascais'),
('Joana Tavares', 'joana.tavares@email.com', '917654321', 'Viseu'),
('Miguel Sousa', 'miguel.sousa@email.com', '916543210', 'Sintra'),
('Sara Pinto', 'sara.pinto@email.com', '915432109', 'Guarda'),
('Rita Martins', 'rita.martins@email.com', '917777777', 'Bragança'),
('Alexandre Fonseca', 'alexandre.fonseca@email.com', '916666666', 'Tomar'),
('Filipa Gomes', 'filipa.gomes@email.com', '915555555', 'Castelo Branco');

INSERT INTO servico (id_cliente, descricao, estado, preco) VALUES
(1, 'Serviço de Espetáculo Privado', 'concluido', 200.00),
(2, 'Tedx Talk', 'aberto', 1500.00),
(3, 'Casamento da Beatriz', 'aberto', 2500.00),
(4, 'Festival Universitário', 'seguimento', 7500.00),
(5, 'Conferência de Negócios', 'aberto', 4000.00),
(6, 'Show de Stand-up', 'concluido', 1200.00),
(7, 'Concerto Rock', 'concluido', 10000.00),
(8, 'Lançamento de Produto', 'seguimento', 6000.00),
(9, 'Festa de Aniversário', 'concluido', 3000.00),
(10, 'Formação Corporativa', 'aberto', 3500.00),
(11, 'Gala do Benfica', 'aberto', 8000.00),
(12, 'Festival de Verão', 'seguimento', 15000.00),
(11, 'Reunião de Stakeholders', 'aberto', 2500.00),
(10, 'Evento de Caridade', 'concluido', 4500.00),
(13, 'Workshop de Fotografia', 'aberto', 1200.00),
(14, 'Exposição de Arte', 'seguimento', 5000.00),
(15, 'Show de Talentos', 'aberto', 3000.00),
(16, 'Festival Gastronómico', 'concluido', 7000.00),
(17, 'Apresentação de Livro', 'seguimento', 2000.00),
(18, 'Desfile de Moda', 'aberto', 6000.00),
(19, 'Conferência Internacional', 'seguimento', 10000.00),
(20, 'Lançamento de Álbum', 'concluido', 8000.00),
(21, 'Evento de Networking', 'aberto', 2500.00),
(22, 'Conferência Tech Summit 2025', 'aberto', 15000.00),
(23, 'Gala Ano Novo 2025', 'aberto', 25000.00),
(24, 'Festival da Cidade', 'seguimento', 50000.00),
(25, 'Ciclo de Concertos Clássicos', 'aberto', 12000.00),
(26, 'Festival de Verão 2025', 'aberto', 75000.00),
(27, 'Cerimónia de Graduação', 'seguimento', 8000.00),
(28, 'Temporada de Ópera', 'aberto', 30000.00),
(29, 'Exposição Internacional', 'seguimento', 20000.00),
(30, 'Recital de Piano', 'aberto', 5000.00),
(15, 'Conferência Blockchain 2025', 'aberto', 35000.00),
(23, 'Summit Inteligência Artificial', 'seguimento', 42000.00),
(8, 'Conferência Marketing Digital', 'concluído', 28000.00),
(45, 'Workshop Liderança', 'aberto', 15000.00),
(31, 'Seminário Vendas B2B', 'seguimento', 18000.00),
(10, 'Feira Universitária', 'aberto', 42000.00),
(30, 'Congresso Educação', 'seguimento', 38000.00),
(15, 'Simpósio Científico', 'concluído', 45000.00),
(40, 'Feira Livro', 'aberto', 32000.00),
(25, 'Conferência Pesquisa', 'seguimento', 28000.00),
(12, 'Convenção Anual Seguros', 'aberto', 45000.00),
(27, 'Feira Tecnologia Verde', 'seguimento', 55000.00),
(39, 'Congresso Medicina 2025', 'aberto', 65000.00),
(16, 'Simpósio Arquitetura', 'concluído', 32000.00),
(42, 'Forum Inovação', 'seguimento', 38000.00),
(31, 'Show de Reveillon', 'aberto', 45000.00),
(13, 'Workshop de Fotografia', 'aberto', 1200.00),
(14, 'Exposição de Arte', 'seguimento', 5000.00),
(15, 'Show de Talentos', 'aberto', 3000.00),
(16, 'Festival Gastronómico', 'concluido', 7000.00),
(17, 'Apresentação de Livro', 'seguimento', 2000.00),
(18, 'Desfile de Moda', 'aberto', 6000.00),
(19, 'Conferência Internacional', 'seguimento', 10000.00),
(20, 'Lançamento de Álbum', 'concluido', 8000.00),
(21, 'Evento de Networking', 'aberto', 2500.00),
(22, 'Hackathon Tecnológico', 'aberto', 3000.00),
(23, 'Seminário de Educação', 'seguimento', 4000.00),
(24, 'Show de Mágica', 'concluido', 2000.00),
(25, 'Feira de Inovação', 'seguimento', 8000.00),
(32, 'Festival Gastronómico de Verão', 'aberto', 8000.00),
(33, 'Roadshow Promocional', 'seguimento', 12000.00),
(34, 'Noite de Fado', 'aberto', 3000.00),
(35, 'Casamento Premium', 'seguimento', 15000.00),
(36, 'Festa de Aniversário 50 Anos', 'aberto', 5000.00),
(37, 'Vernissage Internacional', 'concluído', 7000.00),
(38, 'Tour Nacional 2025', 'aberto', 25000.00),
(19, 'Festival Hip Hop', 'aberto', 85000.00),
(33, 'Festival Música Eletrônica', 'seguimento', 92000.00),
(7, 'Concerto Rock Alternativo', 'aberto', 45000.00),
(25, 'Festival Jazz Verão', 'concluído', 58000.00),
(8, 'Festa Ano Novo Corporativa', 'aberto', 75000.00),
(34, 'Festa Natal Empresa', 'seguimento', 45000.00),
(12, 'Carnaval Corporativo', 'concluído', 55000.00),
(45, 'Festival São João', 'aberto', 65000.00),
(19, 'Festa Halloween', 'seguimento', 35000.00),
(48, 'Noite Fado Tradicional', 'seguimento', 12000.00),
(11, 'Festival Metal', 'aberto', 75000.00),
(36, 'Concerto Música Clássica', 'seguimento', 35000.00),
(22, 'Festival Pop', 'aberto', 95000.00),
(44, 'Noite Blues', 'concluído', 15000.00),
(17, 'Festival Indie', 'seguimento', 48000.00),
(39, 'Festival de Praia', 'seguimento', 18000.00),
(40, 'Noite de Reveillon', 'aberto', 20000.00),
(41, 'Espetáculo Anual', 'seguimento', 9000.00),
(1, 'Evento Corporativo', 'seguimento', 5000.00),
(2, 'Lançamento de Livro', 'concluído', 3000.00),
(3, 'Festa de Aniversário', 'aberto', 2000.00),
(4, 'Show de Talentos', 'seguimento', 4000.00),
(33, 'Workshop Inovação', 'aberto', 18000.00),
(16, 'Treinamento Equipe', 'seguimento', 15000.00),
(42, 'Conferência Vendas', 'concluído', 28000.00),
(27, 'Reunião Acionistas', 'aberto', 35000.00),
(11, 'Apresentação Resultados', 'seguimento', 22000.00),
(5, 'Conferência Internacional', 'concluído', 10000.00),
(5, 'Casamento Luxury', 'aberto', 35000.00),
(28, 'Gala Beneficente', 'seguimento', 48000.00),
(35, 'Festa Aniversário VIP', 'concluído', 25000.00),
(38, 'Show Sertanejo', 'aberto', 65000.00),
(21, 'Festival Forró', 'seguimento', 48000.00),
(46, 'Noite Samba', 'concluído', 35000.00),
(9, 'Festival MPB', 'aberto', 42000.00),
(32, 'Show Rock Nacional', 'seguimento', 55000.00),
(14, 'Summit Sustentabilidade', 'aberto', 42000.00),
(41, 'Conferência RH', 'seguimento', 35000.00),
(26, 'Fórum Economia', 'concluído', 48000.00),
(5, 'Congresso Direito', 'aberto', 52000.00),
(28, 'Seminário Gestão', 'seguimento', 38000.00),
(18, 'Casamento Praia', 'aberto', 28000.00),
(43, 'Festa Formatura', 'seguimento', 32000.00),
(6, 'Workshop de Fotografia', 'aberto', 1500.00),
(7, 'Festival Gastronómico', 'concluído', 7000.00),
(8, 'Desfile de Moda', 'seguimento', 3000.00),
(9, 'Conferência Tech', 'aberto', 12000.00),
(10, 'Show de Stand-up', 'concluído', 2500.00),
(42, 'Conferência Anual de Tecnologia', 'aberto', 45000.00),
(43, 'Gala de Prêmios Seguros', 'seguimento', 35000.00),
(44, 'Hackathon Internacional', 'aberto', 28000.00),
(45, 'Simpósio de Energia Renovável', 'seguimento', 42000.00),
(46, 'Fashion Week Portugal', 'aberto', 85000.00),
(47, 'Campeonato Nacional Juvenil', 'concluído', 38000.00),
(6, 'Lançamento Smartphone', 'aberto', 55000.00),
(24, 'Apresentação Carro Elétrico', 'seguimento', 65000.00),
(37, 'Launch Fashion Collection', 'concluído', 45000.00),
(20, 'Lançamento Videogame', 'aberto', 58000.00),
(47, 'Apresentação Software', 'seguimento', 35000.00),
(48, 'Summit Empresarial 2025', 'aberto', 55000.00),
(49, 'Congresso Médico Internacional', 'seguimento', 65000.00),
(50, 'Auto Show Premium', 'aberto', 72000.00),
(51, 'Feira de Educação e Tecnologia', 'seguimento', 48000.00),
(52, 'Festival de Rock Verão', 'aberto', 95000.00),
(53, 'Temporada Jazz 2025', 'seguimento', 28000.00),
(54, 'Festival de Teatro Internacional', 'aberto', 45000.00),
(55, 'Série de Festas de Verão', 'seguimento', 65000.00),
(56, 'Festival de Artes Urbanas', 'aberto', 35000.00),
(57, 'Campeonato E-sports', 'concluído', 42000.00),
(58, 'Torneio Internacional Futebol', 'aberto', 85000.00),
(29, 'Festival Teatro Experimental', 'aberto', 28000.00),
(13, 'Exposição Arte Digital', 'seguimento', 32000.00),
(38, 'Mostra Cinema Independente', 'concluído', 25000.00),
(21, 'Festival Dança Contemporânea', 'aberto', 35000.00),
(46, 'Exposição Fotografia', 'seguimento', 18000.00),
(59, 'Festival de Música Clássica', 'seguimento', 38000.00),
(60, 'Bienal de Arte Contemporânea', 'aberto', 56000.00),
(61, 'Festival Gastronómico Internacional', 'seguimento', 48000.00),
(62, 'Workshop Corporativo', 'aberto', 8500.00),
(63, 'Lançamento Produto Tech', 'seguimento', 12500.00),
(64, 'Festa Empresarial', 'aberto', 15500.00),
(9, 'Torneio Futebol Regional', 'aberto', 45000.00),
(32, 'Campeonato Basketball', 'seguimento', 38000.00),
(14, 'Torneio Tennis', 'concluído', 28000.00),
(41, 'Competição Atletismo', 'aberto', 32000.00),
(26, 'Torneio eSports', 'seguimento', 42000.00),
(65, 'Seminário Executivo', 'concluído', 9500.00),
(66, 'Exposição Fotografia', 'seguimento', 7500.00),
(67, 'Casamento Vintage', 'aberto', 18500.00),
(68, 'Festa 40 Anos', 'seguimento', 12500.00),
(69, 'Bar Mitzvah', 'aberto', 15500.00),
(70, 'Batizado', 'concluído', 8500.00),
(71, 'Jantar Empresarial', 'seguimento', 9500.00);


INSERT INTO processo (id_servico, id_funcionario, descricao, custo) VALUES
(1, 6, 'Montagem P.A.', 100.00),
(1, 3, 'Operar mesa mistura', 100.00),
(2, 9, 'Montagem ecrãs LEDS', 500.00),
(2, 3, 'Operar ecrã LEDS', 500.00),
(3, 4, 'Montagem do palco', 1000.00),
(3, 5, 'Instalação de som', 500.00),
(3, 6, 'Iluminação', 1000.00),
(4, 3, 'Montagem estrutura do festival', 3000.00),
(4, 6, 'Testes de som e iluminação', 1500.00),
(4, 6, 'Operação técnica no palco principal', 2000.00),
(5, 9, 'Preparação do auditório', 500.00),
(5, 4, 'Configuração de projetores', 1000.00),
(5, 5, 'Testes de microfones', 500.00),
(6, 3, 'Montagem do palco para stand-up', 400.00),
(6, 6, 'Operação de áudio durante o show', 800.00),
(7, 4, 'Montagem de sistema de som para concerto', 5000.00),
(7, 5, 'Montagem de luzes para concerto', 3000.00),
(7, 6, 'Operação técnica durante o concerto', 2000.00),
(8, 7, 'Montagem de stands', 2000.00),
(8, 8, 'Preparação de equipamentos audiovisuais', 1500.00),
(8, 9, 'Configuração de projeção', 1000.00),
(9, 10, 'Montagem do palco para festa', 1200.00),
(9, 6, 'Iluminação personalizada', 800.00),
(10, 4, 'Configuração de som para palestra', 500.00),
(10, 5, 'Configuração de microfones', 300.00),
(11, 3, 'Montagem de estrutura para gala', 3000.00),
(11, 5, 'Testes de luz e som', 2000.00),
(12, 6, 'Montagem do palco principal do festival', 8000.00),
(12, 7, 'Preparação da iluminação para festival', 4000.00),
(12, 8, 'Coordenação técnica de som', 3000.00),
(13, 9, 'Configuração da sala para reunião', 1000.00),
(72, 3, 'Montagem sistema audiovisual', 8000.00),
(72, 8, 'Operação som e vídeo', 5000.00),
(72, 12, 'Iluminação palco', 4000.00),
(72, 15, 'Gestão streaming', 6000.00),
(73, 5, 'Setup palco principal', 10000.00),
(73, 9, 'Sistema som line array', 8000.00),
(73, 14, 'Iluminação ambiente', 6000.00),
(73, 18, 'Operação técnica', 5000.00),
(13, 10, 'Instalação de projetores e tela', 1500.00),
(14, 2, 'Organização de cabos e testes', 1000.00),
(14, 4, 'Operação técnica durante evento', 2500.00),
(14, 6, 'Iluminação para evento', 1000.00),
(15, 11, 'Montagem de palco', 1200.00),
(15, 12, 'Iluminação de cena', 800.00),
(16, 13, 'Montagem de bancadas', 3000.00),
(16, 14, 'Gestão de stands', 2000.00),
(16, 15, 'Coordenação de logística', 2000.00),
(17, 10, 'Configuração de som', 500.00),
(17, 9, 'Ajustes de iluminação', 400.00),
(18, 8, 'Organização de passarela', 3000.00),
(18, 7, 'Coordenação técnica', 2500.00),
(19, 6, 'Preparação do espaço', 5000.00),
(19, 5, 'Testes de som', 3000.00),
(74, 2, 'Montagem palco principal', 15000.00),
(74, 7, 'Sistema som festival', 12000.00),
(74, 11, 'Iluminação show', 10000.00),
(74, 16, 'Backline bandas', 8000.00),
(20, 4, 'Instalação de palco', 4000.00),
(20, 3, 'Operação de luzes', 2000.00),
(77, 20, 'Instalação projetores', 4500.00),
(77, 21, 'Sistema microfones', 3500.00),
(77, 12, 'Operação slides', 2500.00),
(77, 10, 'Gravação evento', 3000.00),
(21, 2, 'Organização do espaço', 1000.00),
(21, 1, 'Configuração de equipamentos audiovisuais', 1500.00),
(22, 20, 'Planejamento técnico geral', 3000.00),
(22, 21, 'Montagem sistema audiovisual', 4000.00),
(22, 22, 'Operação de streaming', 2000.00),
(22, 23, 'Gestão de palco', 2500.00),
(23, 24, 'Decoração e iluminação', 8000.00),
(23, 25, 'Sistema de som principal', 6000.00),
(23, 26, 'Coordenação técnica', 4000.00),
(24, 22, 'Montagem palco principal', 15000.00),
(24, 21, 'Montagem palco secundário', 10000.00),
(24, 12, 'Sistema de iluminação', 12000.00),
(24, 20, 'Operação de vídeo', 8000.00),
(25, 21, 'Sonorização acústica', 4000.00),
(25, 22, 'Gravação ao vivo', 3000.00),
(75, 4, 'Setup sistema PA', 18000.00),
(75, 10, 'Montagem palco', 15000.00),
(75, 13, 'Operação técnica', 12000.00),
(75, 17, 'Gestão backstage', 8000.00),
(25, 23, 'Iluminação cênica', 2500.00),
(26, 24, 'Infraestrutura elétrica', 20000.00),
(26, 25, 'Montagem palcos', 25000.00),
(26, 12, 'Sistemas de delay', 15000.00),
(26, 22, 'Operação multimídia', 10000.00),
(27, 17, 'Sonorização auditório', 3000.00),
(78, 21, 'Montagem palco corporativo', 6000.00),
(78, 13, 'Sistema som conferência', 5000.00),
(78, 21, 'Iluminação ambiente', 4000.00),
(78, 12, 'Operação técnica', 3500.00),
(27, 21, 'Projeção e telas', 2500.00),
(28, 20, 'Sistema de som teatro', 10000.00),
(79, 23, 'Iluminação exposição', 5500.00),
(79, 19, 'Som ambiente', 3500.00),
(79, 17, 'Projeção multimídia', 4500.00),
(79, 12, 'Suporte técnico', 2500.00),
(28, 21, 'Iluminação cênica', 8000.00),
(28, 22, 'Maquinária cênica', 7000.00),
(29, 23, 'Instalação projetores', 6000.00),
(29, 24, 'Montagem painéis LED', 8000.00),
(29, 25, 'Sistema de automação', 4000.00),
(30, 3, 'Sonorização específica piano', 2000.00),
(30, 7, 'Iluminação sala concerto', 1500.00),
(76, 6, 'Sistema som principal', 12000.00),
(76, 19, 'Iluminação decorativa', 8000.00),
(76, 22, 'Operação audiovisual', 6000.00),
(76, 25, 'Gestão técnica', 5000.00),
(31, 8, 'Montagem estrutura principal', 15000.00),
(31, 9, 'Sistema line array', 12000.00),
(31, 20, 'Pirotecnia e efeitos', 8000.00),
(32, 21, 'Montagem tendas', 2000.00),
(32, 22, 'Sistema de som ambiente', 1500.00),
(32, 23, 'Iluminação decorativa', 1200.00),
(33, 24, 'Palco móvel', 4000.00),
(33, 25, 'Sistema de som móvel', 3000.00),
(33, 6, 'Gerador principal', 2000.00),
(34, 7, 'Sonorização específica fado', 1000.00),
(34, 8, 'Iluminação ambiente', 800.00),
(35, 9, 'Estrutura principal', 5000.00),
(35, 20, 'Sistema som distributed', 4000.00),
(35, 21, 'Iluminação decorativa', 3000.00),
(36, 22, 'Sistema som festa', 1500.00),
(36, 23, 'Iluminação festa', 1200.00),
(37, 24, 'Iluminação galeria', 2500.00),
(37, 25, 'Som ambiente', 1500.00),
(38, 6, 'Sistema PA principal', 8000.00),
(38, 7, 'Backline completo', 6000.00),
(38, 8, 'Iluminação tour', 5000.00),
(39, 9, 'Palco praia', 6000.00),
(39, 20, 'Sistema som exterior', 5000.00),
(40, 21, 'Sistema som principal', 7000.00),
(40, 22, 'Iluminação festa', 6000.00),
(40, 23, 'Efeitos especiais', 4000.00),
(41, 24, 'Sonorização teatro', 3000.00),
(41, 25, 'Iluminação cênica', 2500.00),
(41, 6, 'Operação técnica', 2000.00),
(1, 2, 'Configuração de Equipamentos', 500.00),
(2, 3, 'Iluminação', 300.00),
(3, 4, 'Som', 200.00),
(4, 5, 'Palco', 700.00),
(15, 11, 'Montagem de palco', 1200.00),
(15, 12, 'Iluminação de cena', 800.00),
(16, 13, 'Montagem de bancadas', 3000.00),
(16, 14, 'Gestão de stands', 2000.00),
(16, 15, 'Coordenação de logística', 2000.00),
(17, 10, 'Configuração de som', 500.00),
(17, 9, 'Ajustes de iluminação', 400.00),
(18, 8, 'Organização de passarela', 3000.00),
(18, 7, 'Coordenação técnica', 2500.00),
(19, 6, 'Preparação do espaço', 5000.00),
(19, 5, 'Testes de som', 3000.00),
(20, 4, 'Instalação de palco', 4000.00),
(20, 3, 'Operação de luzes', 2000.00),
(21, 2, 'Organização do espaço', 1000.00),
(21, 1, 'Configuração de equipamentos audiovisuais', 1500.00),
(22, 10, 'Configuração de redes', 500.00),
(22, 8, 'Apoio técnico', 1000.00),
(23, 6, 'Ajuste de projeções', 2000.00),
(23, 9, 'Montagem de materiais didáticos', 1000.00),
(24, 4, 'Preparação do palco para mágica', 800.00),
(24, 3, 'Iluminação especial', 500.00),
(25, 12, 'Coordenação geral de stands', 3000.00),
(25, 14, 'Testes de expositores', 2500.00),
(5, 6, 'Coordenação Técnica', 1000.00),
(6, 7, 'Montagem', 400.00),
(7, 8, 'Decoração', 500.00),
(8, 9, 'Logística', 800.00),
(9, 10, 'Operação de Áudio', 600.00),
(10, 11, 'Vídeo', 1000.00),
(42, 7, 'Infraestrutura de rede', 8000.00),
(42, 8, 'Sistema audiovisual principal', 12000.00),
(42, 9, 'Tradução simultânea', 6000.00),
(42, 3, 'Streaming 4K', 8000.00),
(43, 11, 'Cenografia completa', 10000.00),
(43, 12, 'Sistema som e vídeo', 8000.00),
(43, 3, 'Iluminação cerimónia', 7000.00),
(44, 4, 'Infraestrutura TI', 9000.00),
(44, 5, 'Sistemas de apresentação', 6000.00),
(44, 6, 'Rede dedicada', 5000.00),
(45, 7, 'Montagem exposição', 12000.00),
(45, 8, 'Sistema apresentações', 8000.00),
(45, 9, 'Tradução simultânea', 7000.00),
(52, 10, 'Sistema line array principal', 25000.00),
(52, 1, 'Backline completo', 15000.00),
(52, 2, 'Iluminação ambiente', 18000.00),
(52, 3, 'Painéis LED', 20000.00),
(53, 4, 'Sistema som jazz', 8000.00),
(53, 5, 'Iluminação palco', 6000.00),
(53, 6, 'Gravação multitrack', 5000.00),
(54, 7, 'Maquinária cênica', 12000.00),
(54, 8, 'Iluminação teatral', 10000.00),
(54, 9, 'Sistema som teatro', 8000.00),
(55, 5, 'Sistema som clube', 15000.00),
(55, 14, 'Iluminação festa', 12000.00),
(55, 12, 'Efeitos especiais', 10000.00),
(62, 17, 'Equipamento audiovisual', 2500.00),
(62, 12, 'Sistema som conferência', 2000.00),
(63, 12, 'Palco produto', 4000.00),
(63, 3, 'Sistema som principal', 3500.00),
(64, 4, 'Sistema som festa', 5000.00),
(64, 5, 'Iluminação decorativa', 4000.00),
(65, 6, 'Projeção principal', 3000.00),
(65, 7, 'Sistema som palestra', 2500.00),
(66, 8, 'Iluminação exposição', 2500.00),
(66, 9, 'Sistema som ambiente', 1500.00),
(67, 10, 'Sistema som casamento', 6000.00),
(67, 14, 'Iluminação decorativa', 5000.00),
(67, 12, 'Palco banda', 4000.00),
(68, 3, 'Sistema som festa', 4000.00),
(68, 4, 'Iluminação festa', 3500.00),
(69, 5, 'Sistema som completo', 5000.00),
(69, 6, 'Iluminação evento', 4500.00),
(70, 7, 'Som ambiente', 3000.00),
(70, 8, 'Iluminação suave', 2500.00),
(71, 9, 'Sistema som jantar', 3500.00),
(71, 15, 'Iluminação ambiente', 2500.00),
(80, 13, 'Sistema som arena', 8500.00),
(80, 5, 'Telões LED', 12000.00),
(80, 6, 'Operação replay', 5500.00),
(80, 7, 'Gestão transmissão', 7500.00);