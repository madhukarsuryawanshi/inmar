drop table if exists SKU_TABLE;

create table SKU_TABLE(
    skuId INT AUTO_INCREMENT PRIMARY KEY,
    skuName VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    subCategory VARCHAR(100) NOT NULL
);

