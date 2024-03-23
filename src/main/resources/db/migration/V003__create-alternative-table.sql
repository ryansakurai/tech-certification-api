CREATE TABLE alternative (
    id uuid,
    created_at timestamp without time zone NOT NULL,
    description text NOT NULL,
    correct boolean NOT NULL,
    question_id uuid NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES question (id)
);
