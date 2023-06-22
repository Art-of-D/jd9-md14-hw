CREATE TABLE IF NOT EXISTS notes (
    id BIGINT NOT NULL PRIMARY KEY,
    title VARCHAR,
    content VARCHAR
);

INSERT INTO notes (id, title, content) VALUES (
1, 's1', 'smth1'
);
INSERT INTO notes (id, title, content) VALUES (
2, 's2', 'smth2'
);
INSERT INTO notes (id, title, content) VALUES (
3, 's3', 'smth3'
);
INSERT INTO notes (id, title, content) VALUES (
4, 's4', 'smth4'
);