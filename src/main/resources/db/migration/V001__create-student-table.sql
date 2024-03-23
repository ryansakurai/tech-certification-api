CREATE TABLE student(
    id uuid,
    created_at timestamp without time zone NOT NULL,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL UNIQUE,

    PRIMARY KEY (id)
);
