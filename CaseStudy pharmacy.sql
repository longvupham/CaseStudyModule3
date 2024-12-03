CREATE DATABASE PharmacyDB;

USE PharmacyDB;

CREATE TABLE Medicines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
);
INSERT INTO Medicines (name, manufacturer, price, stock)
VALUES 
('Paracetamol', 'Pharma Co.', 10000, 100),
('Nolvadex-D', 'Astra Ltd.', 177000, 10),
('Ginkokup', 'Korea Pharm Ltd.', 150000, 5),
('Phosphalugel Sanofi', 'Pharmatis Ltd.', 104000, 20),
('Fugacar 500mg Janssen', 'Lusomedicamenta', 22000, 50),
('Azibiotic 500 Medipharco', 'MEDIPHARCO', 75000, 30),
('Amoxicillin', 'MedLife Inc.', 160000, 60);