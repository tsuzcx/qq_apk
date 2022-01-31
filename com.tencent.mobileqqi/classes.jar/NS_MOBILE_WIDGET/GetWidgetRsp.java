package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetWidgetRsp
  extends JceStruct
{
  static PartnerPlugin cache_partner_info;
  static byte[] cache_widget;
  public String attach_info = "";
  public int expire = 0;
  public int no_update = 0;
  public PartnerPlugin partner_info = null;
  public int stored_widget_id = 0;
  public byte[] widget = null;
  
  public GetWidgetRsp() {}
  
  public GetWidgetRsp(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString, PartnerPlugin paramPartnerPlugin, int paramInt3)
  {
    this.widget = paramArrayOfByte;
    this.expire = paramInt1;
    this.no_update = paramInt2;
    this.attach_info = paramString;
    this.partner_info = paramPartnerPlugin;
    this.stored_widget_id = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_widget == null)
    {
      cache_widget = (byte[])new byte[1];
      ((byte[])cache_widget)[0] = 0;
    }
    this.widget = ((byte[])paramJceInputStream.read(cache_widget, 0, false));
    this.expire = paramJceInputStream.read(this.expire, 1, false);
    this.no_update = paramJceInputStream.read(this.no_update, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    if (cache_partner_info == null) {
      cache_partner_info = new PartnerPlugin();
    }
    this.partner_info = ((PartnerPlugin)paramJceInputStream.read(cache_partner_info, 4, false));
    this.stored_widget_id = paramJceInputStream.read(this.stored_widget_id, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.widget != null) {
      paramJceOutputStream.write(this.widget, 0);
    }
    paramJceOutputStream.write(this.expire, 1);
    paramJceOutputStream.write(this.no_update, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    if (this.partner_info != null) {
      paramJceOutputStream.write(this.partner_info, 4);
    }
    paramJceOutputStream.write(this.stored_widget_id, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.GetWidgetRsp
 * JD-Core Version:    0.7.0.1
 */