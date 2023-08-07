CREATE DATABASE db_batm;

CREATE TABLE tb_m_region(
    id INT PRIMARY KEY AUTO_INCREMENT,  
    name VARCHAR(50)
);

CREATE TABLE tb_m_role(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE tb_m_division (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

    
CREATE TABLE tb_m_department(
    id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(50),
    region_id INT,
    division_id INT,
    FOREIGN KEY (division_id) REFERENCES tb_m_division(id),
    FOREIGN KEY (region_id) REFERENCES tb_m_region (id)
);

CREATE TABLE tb_m_employee(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(50),
    joindate DATE,
    numberphone VARCHAR(50),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES tb_m_department (id)
);

CREATE TABLE tb_m_user(
    id INT PRIMARY KEY,
    email VARCHAR(50),
    password VARCHAR(60),
    role_id INT,
    FOREIGN KEY (id) REFERENCES tb_m_employee (id),
    FOREIGN KEY (role_id) REFERENCES tb_m_role (id)
);




