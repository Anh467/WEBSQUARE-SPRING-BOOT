
DELIMITER go
CREATE PROCEDURE IncreaseQuantity(IN pSHOP_ID VARCHAR(50), IN pSHOE_NAME VARCHAR(40), IN pDATE DATE, IN pSIZE VARCHAR(50), IN pCOUNT INT, IN pPRICE FLOAT, IN pINVENTORY INT)
BEGIN
  DECLARE existingRecord INT;
  
  -- Kiểm tra xem bản ghi với pDATE, pSHOP_ID và pSHOE_NAME đã tồn tại hay chưa
  SELECT COUNT(*) INTO existingRecord
  FROM shopdetail
  WHERE DATE = pDATE AND SHOP_ID = pSHOP_ID AND SHOE_NAME = pSHOE_NAME;
  
  -- Nếu đã tồn tại, thì tăng số lượng
  IF existingRecord > 0 THEN
    UPDATE shopdetail
    SET INVENTORY = INVENTORY + pINVENTORY
    WHERE DATE = pDATE AND SHOP_ID = pSHOP_ID AND SHOE_NAME = pSHOE_NAME;
   ELSE
    -- Nếu không tồn tại, thêm một bản ghi mới
   INSERT INTO shopdetail (SHOP_ID, SHOE_NAME, DATE, SIZE, COUNT, PRICE, INVENTORY)
			VALUES
				(
			     pSHOP_ID, 
			     pSHOE_NAME, 
			     pDATE, 
			     pSIZE, 
			     pCOUNT, 
			     pPRICE, 
			     pINVENTORY
			    );
  END IF;
END;
go
DELIMITER;