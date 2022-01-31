package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_permission
  extends JceStruct
{
  public String permission_info = "";
  public int permission_mask = 0;
  public byte permission_visit = 0;
  public String status_info = "";
  
  public cell_permission() {}
  
  public cell_permission(String paramString1, int paramInt, String paramString2, byte paramByte)
  {
    this.permission_info = paramString1;
    this.permission_mask = paramInt;
    this.status_info = paramString2;
    this.permission_visit = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.permission_info = paramJceInputStream.readString(0, false);
    this.permission_mask = paramJceInputStream.read(this.permission_mask, 1, false);
    this.status_info = paramJceInputStream.readString(2, false);
    this.permission_visit = paramJceInputStream.read(this.permission_visit, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.permission_info != null) {
      paramJceOutputStream.write(this.permission_info, 0);
    }
    paramJceOutputStream.write(this.permission_mask, 1);
    if (this.status_info != null) {
      paramJceOutputStream.write(this.status_info, 2);
    }
    paramJceOutputStream.write(this.permission_visit, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_permission
 * JD-Core Version:    0.7.0.1
 */