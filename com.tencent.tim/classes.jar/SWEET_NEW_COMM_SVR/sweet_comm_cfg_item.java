package SWEET_NEW_COMM_SVR;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sweet_comm_cfg_item
  extends JceStruct
{
  public String cmd = "";
  public String dynamic_value = "";
  public String icon = "";
  public String title = "";
  public String url = "";
  public String wording = "";
  
  public sweet_comm_cfg_item() {}
  
  public sweet_comm_cfg_item(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.cmd = paramString1;
    this.dynamic_value = paramString2;
    this.wording = paramString3;
    this.url = paramString4;
    this.icon = paramString5;
    this.title = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.readString(0, true);
    this.dynamic_value = paramJceInputStream.readString(1, true);
    this.wording = paramJceInputStream.readString(2, true);
    this.url = paramJceInputStream.readString(3, true);
    this.icon = paramJceInputStream.readString(4, true);
    this.title = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    paramJceOutputStream.write(this.dynamic_value, 1);
    paramJceOutputStream.write(this.wording, 2);
    paramJceOutputStream.write(this.url, 3);
    paramJceOutputStream.write(this.icon, 4);
    paramJceOutputStream.write(this.title, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SWEET_NEW_COMM_SVR.sweet_comm_cfg_item
 * JD-Core Version:    0.7.0.1
 */