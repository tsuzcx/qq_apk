package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAD
  extends JceStruct
{
  public int appid = 0;
  public String content = "";
  public String coverUrl = "";
  public boolean isUpdated = true;
  public int mode = 0;
  public int onOff = 0;
  public String packageUrl = "";
  public int packageVersion = 0;
  public int positionId = 0;
  public String title = "";
  public int version = 0;
  public String wmId = "";
  public String wmPackageUrl = "";
  
  public stAD() {}
  
  public stAD(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.appid = paramInt1;
    this.positionId = paramInt2;
    this.mode = paramInt3;
    this.isUpdated = paramBoolean;
    this.onOff = paramInt4;
    this.coverUrl = paramString1;
    this.title = paramString2;
    this.content = paramString3;
    this.wmId = paramString4;
    this.wmPackageUrl = paramString5;
    this.packageUrl = paramString6;
    this.packageVersion = paramInt5;
    this.version = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, true);
    this.positionId = paramJceInputStream.read(this.positionId, 1, true);
    this.mode = paramJceInputStream.read(this.mode, 2, true);
    this.isUpdated = paramJceInputStream.read(this.isUpdated, 3, true);
    this.onOff = paramJceInputStream.read(this.onOff, 4, true);
    this.coverUrl = paramJceInputStream.readString(5, true);
    this.title = paramJceInputStream.readString(6, true);
    this.content = paramJceInputStream.readString(7, true);
    this.wmId = paramJceInputStream.readString(8, false);
    this.wmPackageUrl = paramJceInputStream.readString(9, false);
    this.packageUrl = paramJceInputStream.readString(10, false);
    this.packageVersion = paramJceInputStream.read(this.packageVersion, 11, false);
    this.version = paramJceInputStream.read(this.version, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.positionId, 1);
    paramJceOutputStream.write(this.mode, 2);
    paramJceOutputStream.write(this.isUpdated, 3);
    paramJceOutputStream.write(this.onOff, 4);
    paramJceOutputStream.write(this.coverUrl, 5);
    paramJceOutputStream.write(this.title, 6);
    paramJceOutputStream.write(this.content, 7);
    if (this.wmId != null) {
      paramJceOutputStream.write(this.wmId, 8);
    }
    if (this.wmPackageUrl != null) {
      paramJceOutputStream.write(this.wmPackageUrl, 9);
    }
    if (this.packageUrl != null) {
      paramJceOutputStream.write(this.packageUrl, 10);
    }
    paramJceOutputStream.write(this.packageVersion, 11);
    paramJceOutputStream.write(this.version, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     WMDBClientInterface.stAD
 * JD-Core Version:    0.7.0.1
 */