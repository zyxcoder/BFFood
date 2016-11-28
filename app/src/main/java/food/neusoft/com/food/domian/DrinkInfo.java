package food.neusoft.com.food.domian;

/**
 * Created by 张宇翔 on 2016/11/24 22:35.
 * Email：1124751755@qq.com
 * 功能：饮品信息
 */

public class DrinkInfo {
    private String bookIconPath;
    private String discountIconPath;
    private String marketAdress;
    private String marketBigPicture;
    private double marketDiscount;
    private double marketDistance;
    private double marketHotLevel;
    private String marketIconPath;
    private String marketIntroduce;
    private String marketName;
    private double marketNo;
    private double marketPrice;
    private String typeName;

    public DrinkInfo(String bookIconPath, String typeName, double marketPrice, double marketNo, String marketName, String marketIntroduce, String marketIconPath, double marketHotLevel, double marketDistance, double marketDiscount, String marketBigPicture, String marketAdress, String discountIconPath) {
        this.bookIconPath = bookIconPath;
        this.typeName = typeName;
        this.marketPrice = marketPrice;
        this.marketNo = marketNo;
        this.marketName = marketName;
        this.marketIntroduce = marketIntroduce;
        this.marketIconPath = marketIconPath;
        this.marketHotLevel = marketHotLevel;
        this.marketDistance = marketDistance;
        this.marketDiscount = marketDiscount;
        this.marketBigPicture = marketBigPicture;
        this.marketAdress = marketAdress;
        this.discountIconPath = discountIconPath;
    }

    public String getBookIconPath() {
        return bookIconPath;
    }

    public void setBookIconPath(String bookIconPath) {
        this.bookIconPath = bookIconPath;
    }

    public String getDiscountIconPath() {
        return discountIconPath;
    }

    public void setDiscountIconPath(String discountIconPath) {
        this.discountIconPath = discountIconPath;
    }

    public String getMarketBigPicture() {
        return marketBigPicture;
    }

    public void setMarketBigPicture(String marketBigPicture) {
        this.marketBigPicture = marketBigPicture;
    }

    public double getMarketDiscount() {
        return marketDiscount;
    }

    public void setMarketDiscount(double marketDiscount) {
        this.marketDiscount = marketDiscount;
    }

    public double getMarketDistance() {
        return marketDistance;
    }

    public void setMarketDistance(double marketDistance) {
        this.marketDistance = marketDistance;
    }

    public double getMarketHotLevel() {
        return marketHotLevel;
    }

    public void setMarketHotLevel(double marketHotLevel) {
        this.marketHotLevel = marketHotLevel;
    }

    public String getMarketIconPath() {
        return marketIconPath;
    }

    public void setMarketIconPath(String marketIconPath) {
        this.marketIconPath = marketIconPath;
    }

    public String getMarketIntroduce() {
        return marketIntroduce;
    }

    public void setMarketIntroduce(String marketIntroduce) {
        this.marketIntroduce = marketIntroduce;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public double getMarketNo() {
        return marketNo;
    }

    public void setMarketNo(double marketNo) {
        this.marketNo = marketNo;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getMarketAdress() {
        return marketAdress;
    }

    public void setMarketAdress(String marketAdress) {
        this.marketAdress = marketAdress;
    }

}
