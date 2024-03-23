CREATE TABLE question (
    id uuid,
    created_at timestamp without time zone NOT NULL,
    description text NOT NULL,
    technology varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
