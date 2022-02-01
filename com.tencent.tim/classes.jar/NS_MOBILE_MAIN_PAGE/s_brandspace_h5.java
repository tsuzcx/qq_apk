package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_brandspace_h5
  extends JceStruct
{
  public String frdfans_nick = "";
  public long frdfans_num;
  public String url = "";
  
  public s_brandspace_h5() {}
  
  public s_brandspace_h5(long paramLong, String paramString1, String paramString2)
  {
    this.frdfans_num = paramLong;
    this.frdfans_nick = paramString1;
    this.url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.frdfans_num = paramJceInputStream.read(this.frdfans_num, 0, true);
    this.frdfans_nick = paramJceInputStream.readString(1, false);
    this.url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.frdfans_num, 0);
    if (this.frdfans_nick != null) {
      paramJceOutputStream.write(this.frdfans_nick, 1);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_brandspace_h5
 * JD-Core Version:    0.7.0.1
 */