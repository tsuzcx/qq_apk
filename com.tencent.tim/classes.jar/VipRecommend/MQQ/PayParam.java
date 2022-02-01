package VipRecommend.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PayParam
  extends JceStruct
{
  public String app_id = "";
  public int maxUpMonth;
  public String offerid = "";
  public int openMode;
  public int openMonth;
  public int openServicePrice;
  public int openType;
  public int pay_item;
  public String product_id = "";
  public String product_type = "";
  public int qq_product_id;
  public String qq_product_name = "";
  public String serviceName = "";
  public String serviceType = "";
  public String type = "";
  
  public PayParam() {}
  
  public PayParam(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, String paramString7, int paramInt6, int paramInt7, String paramString8)
  {
    this.type = paramString1;
    this.openMode = paramInt1;
    this.openMonth = paramInt2;
    this.maxUpMonth = paramInt3;
    this.offerid = paramString2;
    this.serviceType = paramString3;
    this.serviceName = paramString4;
    this.openType = paramInt4;
    this.openServicePrice = paramInt5;
    this.app_id = paramString5;
    this.product_id = paramString6;
    this.product_type = paramString7;
    this.pay_item = paramInt6;
    this.qq_product_id = paramInt7;
    this.qq_product_name = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.readString(0, true);
    this.openMode = paramJceInputStream.read(this.openMode, 1, true);
    this.openMonth = paramJceInputStream.read(this.openMonth, 2, true);
    this.maxUpMonth = paramJceInputStream.read(this.maxUpMonth, 3, true);
    this.offerid = paramJceInputStream.readString(4, false);
    this.serviceType = paramJceInputStream.readString(5, false);
    this.serviceName = paramJceInputStream.readString(6, false);
    this.openType = paramJceInputStream.read(this.openType, 7, false);
    this.openServicePrice = paramJceInputStream.read(this.openServicePrice, 8, false);
    this.app_id = paramJceInputStream.readString(9, false);
    this.product_id = paramJceInputStream.readString(10, false);
    this.product_type = paramJceInputStream.readString(11, false);
    this.pay_item = paramJceInputStream.read(this.pay_item, 12, false);
    this.qq_product_id = paramJceInputStream.read(this.qq_product_id, 13, false);
    this.qq_product_name = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.openMode, 1);
    paramJceOutputStream.write(this.openMonth, 2);
    paramJceOutputStream.write(this.maxUpMonth, 3);
    if (this.offerid != null) {
      paramJceOutputStream.write(this.offerid, 4);
    }
    if (this.serviceType != null) {
      paramJceOutputStream.write(this.serviceType, 5);
    }
    if (this.serviceName != null) {
      paramJceOutputStream.write(this.serviceName, 6);
    }
    paramJceOutputStream.write(this.openType, 7);
    paramJceOutputStream.write(this.openServicePrice, 8);
    if (this.app_id != null) {
      paramJceOutputStream.write(this.app_id, 9);
    }
    if (this.product_id != null) {
      paramJceOutputStream.write(this.product_id, 10);
    }
    if (this.product_type != null) {
      paramJceOutputStream.write(this.product_type, 11);
    }
    paramJceOutputStream.write(this.pay_item, 12);
    paramJceOutputStream.write(this.qq_product_id, 13);
    if (this.qq_product_name != null) {
      paramJceOutputStream.write(this.qq_product_name, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VipRecommend.MQQ.PayParam
 * JD-Core Version:    0.7.0.1
 */