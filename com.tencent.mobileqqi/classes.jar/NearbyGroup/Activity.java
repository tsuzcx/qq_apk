package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Activity
  extends JceStruct
{
  public String strActivityName = "";
  
  public Activity() {}
  
  public Activity(String paramString)
  {
    this.strActivityName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strActivityName = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strActivityName, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NearbyGroup.Activity
 * JD-Core Version:    0.7.0.1
 */