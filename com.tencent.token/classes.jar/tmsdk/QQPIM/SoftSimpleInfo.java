package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SoftSimpleInfo
  extends JceStruct
{
  static byte[] dM;
  static SoftKey dw;
  public String apkFileMd5 = "";
  public String break_fileurl = "";
  public String break_mini_os = "";
  public String channelId = "";
  public float cn_fee = 0.0F;
  public float cn_lfee = 0.0F;
  public long diffFileSizeByte = 0L;
  public String diffFileUrl = "";
  public int downloadtimes = 0;
  public byte[] expand = null;
  public float fee = 0.0F;
  public int feetype = 0;
  public int filesize = 0;
  public String fileurl = "";
  public int iFileID = 0;
  public int iProductID = 0;
  public int iSoftID = 0;
  public float lfee = 0.0F;
  public String likepercent = "";
  public String logourl = "";
  public String nick_name = "";
  public String pageurl = "";
  public int plugintype = 0;
  public String pname = "";
  public String publishtime = "";
  public int safeType = 0;
  public int score = 0;
  public int sign = 0;
  public String softclass = "";
  public SoftKey softkey = null;
  public String strSource = "";
  public int suser = 0;
  public int topsign = 0;
  public String type = "";
  public int updatetime = 0;
  
  public SoftSimpleInfo() {}
  
  public SoftSimpleInfo(SoftKey paramSoftKey, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, float paramFloat1, String paramString7, String paramString8, float paramFloat2, float paramFloat3, float paramFloat4, byte[] paramArrayOfByte, int paramInt9, String paramString9, String paramString10, String paramString11, int paramInt10, int paramInt11, int paramInt12, String paramString12, long paramLong, String paramString13, int paramInt13, String paramString14, String paramString15)
  {
    this.softkey = paramSoftKey;
    this.type = paramString1;
    this.softclass = paramString2;
    this.nick_name = paramString3;
    this.logourl = paramString4;
    this.filesize = paramInt1;
    this.publishtime = paramString5;
    this.downloadtimes = paramInt2;
    this.fileurl = paramString6;
    this.score = paramInt3;
    this.suser = paramInt4;
    this.iProductID = paramInt5;
    this.iSoftID = paramInt6;
    this.iFileID = paramInt7;
    this.feetype = paramInt8;
    this.fee = paramFloat1;
    this.pname = paramString7;
    this.pageurl = paramString8;
    this.lfee = paramFloat2;
    this.cn_fee = paramFloat3;
    this.cn_lfee = paramFloat4;
    this.expand = paramArrayOfByte;
    this.safeType = paramInt9;
    this.strSource = paramString9;
    this.break_fileurl = paramString10;
    this.break_mini_os = paramString11;
    this.sign = paramInt10;
    this.updatetime = paramInt11;
    this.topsign = paramInt12;
    this.diffFileUrl = paramString12;
    this.diffFileSizeByte = paramLong;
    this.apkFileMd5 = paramString13;
    this.plugintype = paramInt13;
    this.likepercent = paramString14;
    this.channelId = paramString15;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (dw == null) {
      dw = new SoftKey();
    }
    this.softkey = ((SoftKey)paramJceInputStream.read(dw, 0, true));
    this.type = paramJceInputStream.readString(1, false);
    this.softclass = paramJceInputStream.readString(2, false);
    this.nick_name = paramJceInputStream.readString(3, false);
    this.logourl = paramJceInputStream.readString(4, false);
    this.filesize = paramJceInputStream.read(this.filesize, 5, false);
    this.publishtime = paramJceInputStream.readString(6, false);
    this.downloadtimes = paramJceInputStream.read(this.downloadtimes, 7, false);
    this.fileurl = paramJceInputStream.readString(8, false);
    this.score = paramJceInputStream.read(this.score, 9, false);
    this.suser = paramJceInputStream.read(this.suser, 10, false);
    this.iProductID = paramJceInputStream.read(this.iProductID, 11, false);
    this.iSoftID = paramJceInputStream.read(this.iSoftID, 12, false);
    this.iFileID = paramJceInputStream.read(this.iFileID, 13, false);
    this.feetype = paramJceInputStream.read(this.feetype, 14, false);
    this.fee = paramJceInputStream.read(this.fee, 15, false);
    this.pname = paramJceInputStream.readString(16, false);
    this.pageurl = paramJceInputStream.readString(17, false);
    this.lfee = paramJceInputStream.read(this.lfee, 18, false);
    this.cn_fee = paramJceInputStream.read(this.cn_fee, 19, false);
    this.cn_lfee = paramJceInputStream.read(this.cn_lfee, 20, false);
    if (dM == null)
    {
      dM = (byte[])new byte[1];
      ((byte[])dM)[0] = 0;
    }
    this.expand = ((byte[])paramJceInputStream.read(dM, 21, false));
    this.safeType = paramJceInputStream.read(this.safeType, 22, false);
    this.strSource = paramJceInputStream.readString(23, false);
    this.break_fileurl = paramJceInputStream.readString(24, false);
    this.break_mini_os = paramJceInputStream.readString(25, false);
    this.sign = paramJceInputStream.read(this.sign, 26, false);
    this.updatetime = paramJceInputStream.read(this.updatetime, 27, false);
    this.topsign = paramJceInputStream.read(this.topsign, 28, false);
    this.diffFileUrl = paramJceInputStream.readString(29, false);
    this.diffFileSizeByte = paramJceInputStream.read(this.diffFileSizeByte, 30, false);
    this.apkFileMd5 = paramJceInputStream.readString(31, false);
    this.plugintype = paramJceInputStream.read(this.plugintype, 32, false);
    this.likepercent = paramJceInputStream.readString(33, false);
    this.channelId = paramJceInputStream.readString(34, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.softkey, 0);
    Object localObject = this.type;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.softclass;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.nick_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.logourl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.filesize, 5);
    localObject = this.publishtime;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.downloadtimes, 7);
    localObject = this.fileurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.score, 9);
    paramJceOutputStream.write(this.suser, 10);
    paramJceOutputStream.write(this.iProductID, 11);
    paramJceOutputStream.write(this.iSoftID, 12);
    paramJceOutputStream.write(this.iFileID, 13);
    paramJceOutputStream.write(this.feetype, 14);
    paramJceOutputStream.write(this.fee, 15);
    localObject = this.pname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    localObject = this.pageurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 17);
    }
    paramJceOutputStream.write(this.lfee, 18);
    paramJceOutputStream.write(this.cn_fee, 19);
    paramJceOutputStream.write(this.cn_lfee, 20);
    localObject = this.expand;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 21);
    }
    paramJceOutputStream.write(this.safeType, 22);
    localObject = this.strSource;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 23);
    }
    localObject = this.break_fileurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 24);
    }
    localObject = this.break_mini_os;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 25);
    }
    paramJceOutputStream.write(this.sign, 26);
    paramJceOutputStream.write(this.updatetime, 27);
    paramJceOutputStream.write(this.topsign, 28);
    localObject = this.diffFileUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 29);
    }
    paramJceOutputStream.write(this.diffFileSizeByte, 30);
    localObject = this.apkFileMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 31);
    }
    paramJceOutputStream.write(this.plugintype, 32);
    localObject = this.likepercent;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 33);
    }
    localObject = this.channelId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 34);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftSimpleInfo
 * JD-Core Version:    0.7.0.1
 */