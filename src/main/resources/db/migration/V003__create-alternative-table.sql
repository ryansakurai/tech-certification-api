CREATE TABLE alternative (
    id uuid,
    description text NOT NULL,
    correct boolean NOT NULL,
    question_id uuid NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES question (id)
);
