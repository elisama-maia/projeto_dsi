CREATE TABLE IF NOT EXISTS projects (
    cd_project SERIAL PRIMARY KEY,
    nm_project VARCHAR(40),
    ds_project VARCHAR(80),
    dt_start DATE,
    dt_end DATE
);

CREATE TABLE IF NOT EXISTS employees (
    cd_employee SERIAL PRIMARY KEY,
    cd_project INT,
    nm_employee VARCHAR(40),
    CONSTRAINT fk_projects
        FOREIGN KEY(cd_project)
            REFERENCES projects(cd_project)
);

CREATE TABLE IF NOT EXISTS tasks (
    cd_task SERIAL PRIMARY KEY,
    cd_project INT,
    cd_employee INT,
    nm_task VARCHAR(40),
    ds_task VARCHAR(80),
    dt_start DATE,
    dt_end DATE,
    ds_status VARCHAR(40),
    ds_priority VARCHAR(40),
    CONSTRAINT fk_project
        FOREIGN KEY(cd_project)
            REFERENCES projects(cd_project),
    CONSTRAINT fk_employee
        FOREIGN KEY(cd_employee)
            REFERENCES employees(cd_employee)
);