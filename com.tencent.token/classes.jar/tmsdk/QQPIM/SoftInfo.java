package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SoftInfo
  extends JceStruct
{
  static ArrayList<String> dF;
  static byte[] dM;
  static SoftKey dw;
  static ArrayList<ProcInfo> eZ;
  static ArrayList<Comment> fa;
  static ArrayList<String> fb;
  static ArrayList<String> fc;
  public String apkFileMd5 = "";
  public int asopt = 0;
  public int autostart = 0;
  public String break_fileurl = "";
  public String break_mini_os = "";
  public String channelId = "";
  public float cn_fee = 0.0F;
  public float cn_lfee = 0.0F;
  public ArrayList<Comment> comments = null;
  public String description = "";
  public long diffFileSizeByte = 0L;
  public String diffFileUrl = "";
  public int downloadtimes = 0;
  public byte[] expand = null;
  public float fee = 0.0F;
  public int feetype = 0;
  public int filesize = 0;
  public String fileurl = "";
  public String function = "";
  public String hprice = "";
  public int iFileID = 0;
  public int iProductID = 0;
  public int iSoftID = 0;
  public int isoftclass = 0;
  public float lfee = 0.0F;
  public String logourl = "";
  public ArrayList<String> logourls = null;
  public int netaccess = 0;
  public String nick_name = "";
  public int official = 0;
  public String pageurl = "";
  public int phonemonitor = 0;
  public ArrayList<String> picurls = null;
  public int plugintype = 0;
  public String pname = "";
  public ArrayList<ProcInfo> procinfo = null;
  public String publishtime = "";
  public int reportFeature = 0;
  public int score = 0;
  public String short_desc = "";
  public int sign = 0;
  public int smsmonitor = 0;
  public int softDescTimestamp = 0;
  public String softclass = "";
  public SoftKey softkey = null;
  public ArrayList<String> srcpicurls = null;
  public String strLinkContent = "";
  public String strLinkUrl = "";
  public String strSource = "";
  public int suser = 0;
  public String type = "";
  public int update = 0;
  public String version_break = "";
  
  public SoftInfo() {}
  
  public SoftInfo(SoftKey paramSoftKey, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<ProcInfo> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString5, int paramInt6, String paramString6, int paramInt7, String paramString7, int paramInt8, String paramString8, String paramString9, ArrayList<String> paramArrayList1, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, float paramFloat1, String paramString10, String paramString11, ArrayList<Comment> paramArrayList2, ArrayList<String> paramArrayList3, String paramString12, float paramFloat2, int paramInt18, float paramFloat3, float paramFloat4, ArrayList<String> paramArrayList4, byte[] paramArrayOfByte, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, long paramLong, String paramString20, int paramInt19, int paramInt20, String paramString21)
  {
    this.softkey = paramSoftKey;
    this.short_desc = paramString1;
    this.description = paramString2;
    this.type = paramString3;
    this.softclass = paramString4;
    this.procinfo = paramArrayList;
    this.smsmonitor = paramInt1;
    this.phonemonitor = paramInt2;
    this.netaccess = paramInt3;
    this.autostart = paramInt4;
    this.asopt = paramInt5;
    this.nick_name = paramString5;
    this.reportFeature = paramInt6;
    this.logourl = paramString6;
    this.filesize = paramInt7;
    this.publishtime = paramString7;
    this.downloadtimes = paramInt8;
    this.function = paramString8;
    this.fileurl = paramString9;
    this.picurls = paramArrayList1;
    this.official = paramInt9;
    this.update = paramInt10;
    this.score = paramInt11;
    this.suser = paramInt12;
    this.softDescTimestamp = paramInt13;
    this.iProductID = paramInt14;
    this.iSoftID = paramInt15;
    this.iFileID = paramInt16;
    this.feetype = paramInt17;
    this.fee = paramFloat1;
    this.pname = paramString10;
    this.hprice = paramString11;
    this.comments = paramArrayList2;
    this.logourls = paramArrayList3;
    this.pageurl = paramString12;
    this.lfee = paramFloat2;
    this.isoftclass = paramInt18;
    this.cn_fee = paramFloat3;
    this.cn_lfee = paramFloat4;
    this.srcpicurls = paramArrayList4;
    this.expand = paramArrayOfByte;
    this.strSource = paramString13;
    this.strLinkContent = paramString14;
    this.strLinkUrl = paramString15;
    this.break_fileurl = paramString16;
    this.version_break = paramString17;
    this.break_mini_os = paramString18;
    this.diffFileUrl = paramString19;
    this.diffFileSizeByte = paramLong;
    this.apkFileMd5 = paramString20;
    this.plugintype = paramInt19;
    this.sign = paramInt20;
    this.channelId = paramString21;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (dw == null) {
      dw = new SoftKey();
    }
    this.softkey = ((SoftKey)paramJceInputStream.read(dw, 0, true));
    this.short_desc = paramJceInputStream.readString(1, false);
    this.description = paramJceInputStream.readString(2, false);
    this.type = paramJceInputStream.readString(3, false);
    this.softclass = paramJceInputStream.readString(4, false);
    Object localObject;
    if (eZ == null)
    {
      eZ = new ArrayList();
      localObject = new ProcInfo();
      eZ.add(localObject);
    }
    this.procinfo = ((ArrayList)paramJceInputStream.read(eZ, 5, false));
    this.smsmonitor = paramJceInputStream.read(this.smsmonitor, 6, false);
    this.phonemonitor = paramJceInputStream.read(this.phonemonitor, 7, false);
    this.netaccess = paramJceInputStream.read(this.netaccess, 8, false);
    this.autostart = paramJceInputStream.read(this.autostart, 9, false);
    this.asopt = paramJceInputStream.read(this.asopt, 10, false);
    this.nick_name = paramJceInputStream.readString(11, false);
    this.reportFeature = paramJceInputStream.read(this.reportFeature, 12, false);
    this.logourl = paramJceInputStream.readString(13, false);
    this.filesize = paramJceInputStream.read(this.filesize, 14, false);
    this.publishtime = paramJceInputStream.readString(15, false);
    this.downloadtimes = paramJceInputStream.read(this.downloadtimes, 16, false);
    this.function = paramJceInputStream.readString(17, false);
    this.fileurl = paramJceInputStream.readString(18, false);
    if (dF == null)
    {
      dF = new ArrayList();
      dF.add("");
    }
    this.picurls = ((ArrayList)paramJceInputStream.read(dF, 19, false));
    this.official = paramJceInputStream.read(this.official, 20, false);
    this.update = paramJceInputStream.read(this.update, 21, false);
    this.score = paramJceInputStream.read(this.score, 22, false);
    this.suser = paramJceInputStream.read(this.suser, 23, false);
    this.softDescTimestamp = paramJceInputStream.read(this.softDescTimestamp, 24, false);
    this.iProductID = paramJceInputStream.read(this.iProductID, 25, false);
    this.iSoftID = paramJceInputStream.read(this.iSoftID, 26, false);
    this.iFileID = paramJceInputStream.read(this.iFileID, 27, false);
    this.feetype = paramJceInputStream.read(this.feetype, 28, false);
    this.fee = paramJceInputStream.read(this.fee, 29, false);
    this.pname = paramJceInputStream.readString(30, false);
    this.hprice = paramJceInputStream.readString(31, false);
    if (fa == null)
    {
      fa = new ArrayList();
      localObject = new Comment();
      fa.add(localObject);
    }
    this.comments = ((ArrayList)paramJceInputStream.read(fa, 32, false));
    if (fb == null)
    {
      fb = new ArrayList();
      fb.add("");
    }
    this.logourls = ((ArrayList)paramJceInputStream.read(fb, 33, false));
    this.pageurl = paramJceInputStream.readString(34, false);
    this.lfee = paramJceInputStream.read(this.lfee, 35, false);
    this.isoftclass = paramJceInputStream.read(this.isoftclass, 36, false);
    this.cn_fee = paramJceInputStream.read(this.cn_fee, 37, false);
    this.cn_lfee = paramJceInputStream.read(this.cn_lfee, 38, false);
    if (fc == null)
    {
      fc = new ArrayList();
      fc.add("");
    }
    this.srcpicurls = ((ArrayList)paramJceInputStream.read(fc, 39, false));
    if (dM == null)
    {
      dM = (byte[])new byte[1];
      ((byte[])dM)[0] = 0;
    }
    this.expand = ((byte[])paramJceInputStream.read(dM, 40, false));
    this.strSource = paramJceInputStream.readString(41, false);
    this.strLinkContent = paramJceInputStream.readString(42, false);
    this.strLinkUrl = paramJceInputStream.readString(43, false);
    this.break_fileurl = paramJceInputStream.readString(44, false);
    this.version_break = paramJceInputStream.readString(45, false);
    this.break_mini_os = paramJceInputStream.readString(46, false);
    this.diffFileUrl = paramJceInputStream.readString(47, false);
    this.diffFileSizeByte = paramJceInputStream.read(this.diffFileSizeByte, 48, false);
    this.apkFileMd5 = paramJceInputStream.readString(49, false);
    this.plugintype = paramJceInputStream.read(this.plugintype, 50, false);
    this.sign = paramJceInputStream.read(this.sign, 51, false);
    this.channelId = paramJceInputStream.readString(52, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.softkey, 0);
    if (this.short_desc != null) {
      paramJceOutputStream.write(this.short_desc, 1);
    }
    if (this.description != null) {
      paramJceOutputStream.write(this.description, 2);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 3);
    }
    if (this.softclass != null) {
      paramJceOutputStream.write(this.softclass, 4);
    }
    if (this.procinfo != null) {
      paramJceOutputStream.write(this.procinfo, 5);
    }
    paramJceOutputStream.write(this.smsmonitor, 6);
    paramJceOutputStream.write(this.phonemonitor, 7);
    paramJceOutputStream.write(this.netaccess, 8);
    paramJceOutputStream.write(this.autostart, 9);
    paramJceOutputStream.write(this.asopt, 10);
    if (this.nick_name != null) {
      paramJceOutputStream.write(this.nick_name, 11);
    }
    paramJceOutputStream.write(this.reportFeature, 12);
    if (this.logourl != null) {
      paramJceOutputStream.write(this.logourl, 13);
    }
    paramJceOutputStream.write(this.filesize, 14);
    if (this.publishtime != null) {
      paramJceOutputStream.write(this.publishtime, 15);
    }
    paramJceOutputStream.write(this.downloadtimes, 16);
    if (this.function != null) {
      paramJceOutputStream.write(this.function, 17);
    }
    if (this.fileurl != null) {
      paramJceOutputStream.write(this.fileurl, 18);
    }
    if (this.picurls != null) {
      paramJceOutputStream.write(this.picurls, 19);
    }
    paramJceOutputStream.write(this.official, 20);
    paramJceOutputStream.write(this.update, 21);
    paramJceOutputStream.write(this.score, 22);
    paramJceOutputStream.write(this.suser, 23);
    paramJceOutputStream.write(this.softDescTimestamp, 24);
    paramJceOutputStream.write(this.iProductID, 25);
    paramJceOutputStream.write(this.iSoftID, 26);
    paramJceOutputStream.write(this.iFileID, 27);
    paramJceOutputStream.write(this.feetype, 28);
    paramJceOutputStream.write(this.fee, 29);
    if (this.pname != null) {
      paramJceOutputStream.write(this.pname, 30);
    }
    if (this.hprice != null) {
      paramJceOutputStream.write(this.hprice, 31);
    }
    if (this.comments != null) {
      paramJceOutputStream.write(this.comments, 32);
    }
    if (this.logourls != null) {
      paramJceOutputStream.write(this.logourls, 33);
    }
    if (this.pageurl != null) {
      paramJceOutputStream.write(this.pageurl, 34);
    }
    paramJceOutputStream.write(this.lfee, 35);
    paramJceOutputStream.write(this.isoftclass, 36);
    paramJceOutputStream.write(this.cn_fee, 37);
    paramJceOutputStream.write(this.cn_lfee, 38);
    if (this.srcpicurls != null) {
      paramJceOutputStream.write(this.srcpicurls, 39);
    }
    if (this.expand != null) {
      paramJceOutputStream.write(this.expand, 40);
    }
    if (this.strSource != null) {
      paramJceOutputStream.write(this.strSource, 41);
    }
    if (this.strLinkContent != null) {
      paramJceOutputStream.write(this.strLinkContent, 42);
    }
    if (this.strLinkUrl != null) {
      paramJceOutputStream.write(this.strLinkUrl, 43);
    }
    if (this.break_fileurl != null) {
      paramJceOutputStream.write(this.break_fileurl, 44);
    }
    if (this.version_break != null) {
      paramJceOutputStream.write(this.version_break, 45);
    }
    if (this.break_mini_os != null) {
      paramJceOutputStream.write(this.break_mini_os, 46);
    }
    if (this.diffFileUrl != null) {
      paramJceOutputStream.write(this.diffFileUrl, 47);
    }
    paramJceOutputStream.write(this.diffFileSizeByte, 48);
    if (this.apkFileMd5 != null) {
      paramJceOutputStream.write(this.apkFileMd5, 49);
    }
    paramJceOutputStream.write(this.plugintype, 50);
    paramJceOutputStream.write(this.sign, 51);
    if (this.channelId != null) {
      paramJceOutputStream.write(this.channelId, 52);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftInfo
 * JD-Core Version:    0.7.0.1
 */