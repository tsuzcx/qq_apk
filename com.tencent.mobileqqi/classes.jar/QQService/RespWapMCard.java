package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespWapMCard
  extends JceStruct
{
  static RespHead cache_stHeader;
  static Intro cache_stIntro;
  static ArrayList cache_vFaceIDURL;
  public int iLat = 0;
  public int iLon = 0;
  public RespHead stHeader = null;
  public Intro stIntro = null;
  public String strAddress = "";
  public String strCertification = "";
  public String strCertificationInfo = "";
  public String strContactName = "";
  public String strContactTelNumber = "";
  public String strCustomTelNumber = "";
  public int uFaceTimeStamp = 0;
  public ArrayList vFaceIDURL = null;
  public String vQQFaceIDURL = "";
  
  public RespWapMCard() {}
  
  public RespWapMCard(RespHead paramRespHead, String paramString1, String paramString2, Intro paramIntro, int paramInt1, ArrayList paramArrayList, String paramString3, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.stHeader = paramRespHead;
    this.strCertification = paramString1;
    this.strCertificationInfo = paramString2;
    this.stIntro = paramIntro;
    this.uFaceTimeStamp = paramInt1;
    this.vFaceIDURL = paramArrayList;
    this.vQQFaceIDURL = paramString3;
    this.iLat = paramInt2;
    this.iLon = paramInt3;
    this.strAddress = paramString4;
    this.strCustomTelNumber = paramString5;
    this.strContactName = paramString6;
    this.strContactTelNumber = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.strCertification = paramJceInputStream.readString(1, true);
    this.strCertificationInfo = paramJceInputStream.readString(2, true);
    if (cache_stIntro == null) {
      cache_stIntro = new Intro();
    }
    this.stIntro = ((Intro)paramJceInputStream.read(cache_stIntro, 3, true));
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 4, true);
    if (cache_vFaceIDURL == null)
    {
      cache_vFaceIDURL = new ArrayList();
      cache_vFaceIDURL.add("");
    }
    this.vFaceIDURL = ((ArrayList)paramJceInputStream.read(cache_vFaceIDURL, 5, true));
    this.vQQFaceIDURL = paramJceInputStream.readString(6, true);
    this.iLat = paramJceInputStream.read(this.iLat, 7, true);
    this.iLon = paramJceInputStream.read(this.iLon, 8, true);
    this.strAddress = paramJceInputStream.readString(9, false);
    this.strCustomTelNumber = paramJceInputStream.readString(10, false);
    this.strContactName = paramJceInputStream.readString(11, false);
    this.strContactTelNumber = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.strCertification, 1);
    paramJceOutputStream.write(this.strCertificationInfo, 2);
    paramJceOutputStream.write(this.stIntro, 3);
    paramJceOutputStream.write(this.uFaceTimeStamp, 4);
    paramJceOutputStream.write(this.vFaceIDURL, 5);
    paramJceOutputStream.write(this.vQQFaceIDURL, 6);
    paramJceOutputStream.write(this.iLat, 7);
    paramJceOutputStream.write(this.iLon, 8);
    if (this.strAddress != null) {
      paramJceOutputStream.write(this.strAddress, 9);
    }
    if (this.strCustomTelNumber != null) {
      paramJceOutputStream.write(this.strCustomTelNumber, 10);
    }
    if (this.strContactName != null) {
      paramJceOutputStream.write(this.strContactName, 11);
    }
    if (this.strContactTelNumber != null) {
      paramJceOutputStream.write(this.strContactTelNumber, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespWapMCard
 * JD-Core Version:    0.7.0.1
 */