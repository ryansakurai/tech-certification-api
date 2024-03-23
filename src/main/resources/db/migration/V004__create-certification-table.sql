CREATE TABLE certification (
    id uuid,
    created_at timestamp without time zone NOT NULL,
    technology varchar(255) NOT NULL,
    grade double precision NOT NULL,
    student_id uuid NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);