package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_friend_ship
  extends JceStruct
{
  public int intimacyScore = 0;
  public String url = "";
  
  public s_friend_ship() {}
  
  public s_friend_ship(int paramInt, String paramString)
  {
    this.intimacyScore = paramInt;
    this.url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.intimacyScore = paramJceInputStream.read(this.intimacyScore, 0, false);
    this.url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.intimacyScore, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_friend_ship
 * JD-Core Version:    0.7.0.1
 */