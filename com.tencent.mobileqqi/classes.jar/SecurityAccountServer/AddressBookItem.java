package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddressBookItem
  extends JceStruct
{
  public String mobileNo = "";
  public String name = "";
  
  public AddressBookItem() {}
  
  public AddressBookItem(String paramString1, String paramString2)
  {
    this.mobileNo = paramString1;
    this.name = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mobileNo = paramJceInputStream.readString(0, true);
    this.name = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mobileNo, 0);
    paramJceOutputStream.write(this.name, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.AddressBookItem
 * JD-Core Version:    0.7.0.1
 */