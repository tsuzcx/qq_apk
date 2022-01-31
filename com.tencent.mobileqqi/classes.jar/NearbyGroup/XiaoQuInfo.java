package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class XiaoQuInfo
  extends JceStruct
{
  public int iMemberCnt = 0;
  public String strIntro = "";
  public String strLocation = "";
  public String strName = "";
  public String strURL = "";
  
  public XiaoQuInfo() {}
  
  public XiaoQuInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.strName = paramString1;
    this.strLocation = paramString2;
    this.iMemberCnt = paramInt;
    this.strIntro = paramString3;
    this.strURL = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strName = paramJceInputStream.readString(1, true);
    this.strLocation = paramJceInputStream.readString(2, true);
    this.iMemberCnt = paramJceInputStream.read(this.iMemberCnt, 3, true);
    this.strIntro = paramJceInputStream.readString(4, true);
    this.strURL = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strName, 1);
    paramJceOutputStream.write(this.strLocation, 2);
    paramJceOutputStream.write(this.iMemberCnt, 3);
    paramJceOutputStream.write(this.strIntro, 4);
    paramJceOutputStream.write(this.strURL, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NearbyGroup.XiaoQuInfo
 * JD-Core Version:    0.7.0.1
 */