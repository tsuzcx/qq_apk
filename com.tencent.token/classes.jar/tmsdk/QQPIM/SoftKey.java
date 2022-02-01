package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SoftKey
  extends JceStruct
  implements Comparable<SoftKey>
{
  public String apkFileMd5 = "";
  public int appid = 0;
  public int break_flag = 0;
  public int category = 0;
  public int categorytype = 0;
  public String cert = "";
  public int filesize = 0;
  public int isbuildin = 0;
  public String name = "";
  public String newest_version = "";
  public int old_versioncode = 0;
  public String producttime = "";
  public int sdk_version = 0;
  public String softname = "";
  public int source = 0;
  public String uid = "";
  public String version = "";
  public int versioncode = 0;
  
  public SoftKey() {}
  
  public SoftKey(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, String paramString6, int paramInt2, String paramString7, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, String paramString8)
  {
    this.uid = paramString1;
    this.softname = paramString2;
    this.version = paramString3;
    this.producttime = paramString4;
    this.cert = paramString5;
    this.versioncode = paramInt1;
    this.name = paramString6;
    this.isbuildin = paramInt2;
    this.newest_version = paramString7;
    this.old_versioncode = paramInt3;
    this.categorytype = paramInt4;
    this.category = paramInt5;
    this.break_flag = paramInt6;
    this.source = paramInt7;
    this.sdk_version = paramInt8;
    this.appid = paramInt9;
    this.filesize = paramInt10;
    this.apkFileMd5 = paramString8;
  }
  
  public int compareTo(SoftKey paramSoftKey)
  {
    int k = 0;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = JceUtil.compareTo(this.uid, paramSoftKey.uid);
    arrayOfInt[1] = JceUtil.compareTo(this.softname, paramSoftKey.softname);
    arrayOfInt[2] = JceUtil.compareTo(this.version, paramSoftKey.version);
    arrayOfInt[3] = JceUtil.compareTo(this.producttime, paramSoftKey.producttime);
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < arrayOfInt.length)
      {
        if (arrayOfInt[i] != 0) {
          j = arrayOfInt[i];
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.readString(0, true);
    this.softname = paramJceInputStream.readString(1, true);
    this.version = paramJceInputStream.readString(2, true);
    this.producttime = paramJceInputStream.readString(3, false);
    this.cert = paramJceInputStream.readString(4, false);
    this.versioncode = paramJceInputStream.read(this.versioncode, 5, false);
    this.name = paramJceInputStream.readString(6, false);
    this.isbuildin = paramJceInputStream.read(this.isbuildin, 7, false);
    this.newest_version = paramJceInputStream.readString(8, false);
    this.old_versioncode = paramJceInputStream.read(this.old_versioncode, 9, false);
    this.categorytype = paramJceInputStream.read(this.categorytype, 10, false);
    this.category = paramJceInputStream.read(this.category, 11, false);
    this.break_flag = paramJceInputStream.read(this.break_flag, 12, false);
    this.source = paramJceInputStream.read(this.source, 13, false);
    this.sdk_version = paramJceInputStream.read(this.sdk_version, 14, false);
    this.appid = paramJceInputStream.read(this.appid, 15, false);
    this.filesize = paramJceInputStream.read(this.filesize, 16, false);
    this.apkFileMd5 = paramJceInputStream.readString(17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uid, 0);
    paramJceOutputStream.write(this.softname, 1);
    paramJceOutputStream.write(this.version, 2);
    if (this.producttime != null) {
      paramJceOutputStream.write(this.producttime, 3);
    }
    if (this.cert != null) {
      paramJceOutputStream.write(this.cert, 4);
    }
    paramJceOutputStream.write(this.versioncode, 5);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 6);
    }
    paramJceOutputStream.write(this.isbuildin, 7);
    if (this.newest_version != null) {
      paramJceOutputStream.write(this.newest_version, 8);
    }
    paramJceOutputStream.write(this.old_versioncode, 9);
    paramJceOutputStream.write(this.categorytype, 10);
    paramJceOutputStream.write(this.category, 11);
    paramJceOutputStream.write(this.break_flag, 12);
    paramJceOutputStream.write(this.source, 13);
    paramJceOutputStream.write(this.sdk_version, 14);
    paramJceOutputStream.write(this.appid, 15);
    paramJceOutputStream.write(this.filesize, 16);
    if (this.apkFileMd5 != null) {
      paramJceOutputStream.write(this.apkFileMd5, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftKey
 * JD-Core Version:    0.7.0.1
 */