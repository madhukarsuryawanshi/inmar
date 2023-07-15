drop table if exists SKU_TABLE;

create table SKU_TABLE(
    skuId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    skuName VARCHAR(100) NOT NULL UNIQUE,
    location VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    subCategory VARCHAR(100) NOT NULL
);

