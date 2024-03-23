ALTER TABLE alternative
ADD CONSTRAINT unique_question_id_id UNIQUE (question_id, id);

CREATE TABLE answer (
    id uuid,
    correct boolean NOT NULL,
    certification_id uuid NOT NULL,
    question_id uuid NOT NULL,
    alternative_id uuid NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (certification_id) REFERENCES certification (id) ON DELETE CASCADE,
    FOREIGN KEY (question_id, alternative_id) REFERENCES alternative (question_id, id)
);
