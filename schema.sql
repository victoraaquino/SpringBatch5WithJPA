CREATE TABLE cars (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model varchar(50) NOT NULL,
    brand varchar(50) NOT NULL,
    viewed int NOT NULL DEFAULT 0
 );

INSERT INTO cars (model, brand) VALUES ('uno', 'fiat');

CREATE PROCEDURE FIND_CARS_BY_BRAND (IN brand_in VARCHAR(50))
begin
 	DECLARE test INT;
 	SELECT COUNT(*) INTO test FROM cars WHERE brand = brand_in AND viewed = 0;

  IF (test > 0) THEN
  	UPDATE cars SET viewed = 1 WHERE brand = brand_in;
    SELECT * FROM cars WHERE brand = brand_in;
  ELSE
  	SELECT * FROM cars WHERE brand = brand_in AND viewed = 0;
  END IF;

end