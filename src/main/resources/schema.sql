CREATE TABLE department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_number VARCHAR(255) UNIQUE NOT NULL,
    employee_name VARCHAR(255) NOT NULL,
    department_id BIGINT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (id)
);
