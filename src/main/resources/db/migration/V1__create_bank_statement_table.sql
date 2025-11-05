CREATE TABLE bank_statement (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    customer_id VARCHAR(255) NOT NULL,
    transaction_id VARCHAR(255) NOT NULL,
    transaction_type VARCHAR(255) NOT NULL,
    transaction_value NUMERIC(19, 2) NOT NULL,
    transaction_date DATETIME2 NOT NULL,
    description VARCHAR(255) NOT NULL
);
