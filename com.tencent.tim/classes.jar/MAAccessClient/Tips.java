package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Tips
  extends JceStruct
{
  public String button = "";
  public String content = "";
  public String title = "";
  
  public Tips() {}
  
  public Tips(String paramString1, String paramString2, String paramString3)
  {
    this.title = paramString1;
    this.button = paramString2;
    this.content = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, true);
    this.button = paramJceInputStream.readString(1, true);
    this.content = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.title, 0);
    paramJceOutputStream.write(this.button, 1);
    paramJceOutputStream.write(this.content, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MAAccessClient.Tips
 * JD-Core Version:    0.7.0.1
 */