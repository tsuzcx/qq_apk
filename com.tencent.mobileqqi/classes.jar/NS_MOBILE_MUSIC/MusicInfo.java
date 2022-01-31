package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MusicInfo
  extends JceStruct
{
  public int type = 0;
  public String xalbumpic_url = "";
  public boolean xexpire = true;
  public long xqusic_id = 0L;
  public String xqusic_mid = "";
  public int xsinger_id = 0;
  public String xsinger_name = "";
  public String xsong_name = "";
  public String xsong_url = "";
  
  public MusicInfo() {}
  
  public MusicInfo(String paramString1, long paramLong, String paramString2, int paramInt1, String paramString3, boolean paramBoolean, String paramString4, int paramInt2, String paramString5)
  {
    this.xqusic_mid = paramString1;
    this.xqusic_id = paramLong;
    this.xsong_name = paramString2;
    this.xsinger_id = paramInt1;
    this.xsinger_name = paramString3;
    this.xexpire = paramBoolean;
    this.xsong_url = paramString4;
    this.type = paramInt2;
    this.xalbumpic_url = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.xqusic_mid = paramJceInputStream.readString(0, false);
    this.xqusic_id = paramJceInputStream.read(this.xqusic_id, 1, false);
    this.xsong_name = paramJceInputStream.readString(2, false);
    this.xsinger_id = paramJceInputStream.read(this.xsinger_id, 3, false);
    this.xsinger_name = paramJceInputStream.readString(4, false);
    this.xexpire = paramJceInputStream.read(this.xexpire, 5, false);
    this.xsong_url = paramJceInputStream.readString(6, false);
    this.type = paramJceInputStream.read(this.type, 7, false);
    this.xalbumpic_url = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.xqusic_mid != null) {
      paramJceOutputStream.write(this.xqusic_mid, 0);
    }
    paramJceOutputStream.write(this.xqusic_id, 1);
    if (this.xsong_name != null) {
      paramJceOutputStream.write(this.xsong_name, 2);
    }
    paramJceOutputStream.write(this.xsinger_id, 3);
    if (this.xsinger_name != null) {
      paramJceOutputStream.write(this.xsinger_name, 4);
    }
    paramJceOutputStream.write(this.xexpire, 5);
    if (this.xsong_url != null) {
      paramJceOutputStream.write(this.xsong_url, 6);
    }
    paramJceOutputStream.write(this.type, 7);
    if (this.xalbumpic_url != null) {
      paramJceOutputStream.write(this.xalbumpic_url, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MUSIC.MusicInfo
 * JD-Core Version:    0.7.0.1
 */