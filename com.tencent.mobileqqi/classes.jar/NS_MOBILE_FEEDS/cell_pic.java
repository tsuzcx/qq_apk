package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_pic
  extends JceStruct
{
  static Map cache_busi_param;
  static ArrayList cache_facemans;
  static s_user cache_friendinfo;
  static ArrayList cache_picdata;
  public int actiontype = 18;
  public String actionurl = "";
  public String albumanswer = "";
  public String albumid = "";
  public String albumname = "";
  public int albumnum = 0;
  public String albumquestion = "";
  public int albumrights = 0;
  public int albumtype = 0;
  public int allow_access = 0;
  public int anonymity = 0;
  public boolean balbum = true;
  public Map busi_param = null;
  public String desc = "";
  public int faceman_num = 0;
  public ArrayList facemans = null;
  public s_user friendinfo = null;
  public boolean isSubscribe = true;
  public int lastupdatetime = 0;
  public String news = "";
  public ArrayList picdata = null;
  public String qunid = "";
  public long uin = 0L;
  public int unread_count = 0;
  public int uploadnum = 0;
  
  public cell_pic() {}
  
  public cell_pic(ArrayList paramArrayList1, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, long paramLong, boolean paramBoolean1, int paramInt4, Map paramMap, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString7, boolean paramBoolean2, s_user params_user, String paramString8, int paramInt9, ArrayList paramArrayList2, int paramInt10)
  {
    this.picdata = paramArrayList1;
    this.albumname = paramString1;
    this.albumid = paramString2;
    this.albumnum = paramInt1;
    this.uploadnum = paramInt2;
    this.albumrights = paramInt3;
    this.albumquestion = paramString3;
    this.albumanswer = paramString4;
    this.desc = paramString5;
    this.uin = paramLong;
    this.balbum = paramBoolean1;
    this.lastupdatetime = paramInt4;
    this.busi_param = paramMap;
    this.qunid = paramString6;
    this.allow_access = paramInt5;
    this.anonymity = paramInt6;
    this.albumtype = paramInt7;
    this.actiontype = paramInt8;
    this.actionurl = paramString7;
    this.isSubscribe = paramBoolean2;
    this.friendinfo = params_user;
    this.news = paramString8;
    this.unread_count = paramInt9;
    this.facemans = paramArrayList2;
    this.faceman_num = paramInt10;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject;
    if (cache_picdata == null)
    {
      cache_picdata = new ArrayList();
      localObject = new s_picdata();
      cache_picdata.add(localObject);
    }
    this.picdata = ((ArrayList)paramJceInputStream.read(cache_picdata, 0, false));
    this.albumname = paramJceInputStream.readString(1, false);
    this.albumid = paramJceInputStream.readString(2, false);
    this.albumnum = paramJceInputStream.read(this.albumnum, 3, false);
    this.uploadnum = paramJceInputStream.read(this.uploadnum, 4, false);
    this.albumrights = paramJceInputStream.read(this.albumrights, 5, false);
    this.albumquestion = paramJceInputStream.readString(6, false);
    this.albumanswer = paramJceInputStream.readString(7, false);
    this.desc = paramJceInputStream.readString(8, false);
    this.uin = paramJceInputStream.read(this.uin, 9, false);
    this.balbum = paramJceInputStream.read(this.balbum, 10, false);
    this.lastupdatetime = paramJceInputStream.read(this.lastupdatetime, 11, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 12, false));
    this.qunid = paramJceInputStream.readString(13, false);
    this.allow_access = paramJceInputStream.read(this.allow_access, 14, false);
    this.anonymity = paramJceInputStream.read(this.anonymity, 15, false);
    this.albumtype = paramJceInputStream.read(this.albumtype, 16, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 17, false);
    this.actionurl = paramJceInputStream.readString(18, false);
    this.isSubscribe = paramJceInputStream.read(this.isSubscribe, 19, false);
    if (cache_friendinfo == null) {
      cache_friendinfo = new s_user();
    }
    this.friendinfo = ((s_user)paramJceInputStream.read(cache_friendinfo, 20, false));
    this.news = paramJceInputStream.readString(21, false);
    this.unread_count = paramJceInputStream.read(this.unread_count, 22, false);
    if (cache_facemans == null)
    {
      cache_facemans = new ArrayList();
      localObject = new s_user();
      cache_facemans.add(localObject);
    }
    this.facemans = ((ArrayList)paramJceInputStream.read(cache_facemans, 23, false));
    this.faceman_num = paramJceInputStream.read(this.faceman_num, 24, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 0);
    }
    if (this.albumname != null) {
      paramJceOutputStream.write(this.albumname, 1);
    }
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 2);
    }
    paramJceOutputStream.write(this.albumnum, 3);
    paramJceOutputStream.write(this.uploadnum, 4);
    paramJceOutputStream.write(this.albumrights, 5);
    if (this.albumquestion != null) {
      paramJceOutputStream.write(this.albumquestion, 6);
    }
    if (this.albumanswer != null) {
      paramJceOutputStream.write(this.albumanswer, 7);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 8);
    }
    paramJceOutputStream.write(this.uin, 9);
    paramJceOutputStream.write(this.balbum, 10);
    paramJceOutputStream.write(this.lastupdatetime, 11);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 12);
    }
    if (this.qunid != null) {
      paramJceOutputStream.write(this.qunid, 13);
    }
    paramJceOutputStream.write(this.allow_access, 14);
    paramJceOutputStream.write(this.anonymity, 15);
    paramJceOutputStream.write(this.albumtype, 16);
    paramJceOutputStream.write(this.actiontype, 17);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 18);
    }
    paramJceOutputStream.write(this.isSubscribe, 19);
    if (this.friendinfo != null) {
      paramJceOutputStream.write(this.friendinfo, 20);
    }
    if (this.news != null) {
      paramJceOutputStream.write(this.news, 21);
    }
    paramJceOutputStream.write(this.unread_count, 22);
    if (this.facemans != null) {
      paramJceOutputStream.write(this.facemans, 23);
    }
    paramJceOutputStream.write(this.faceman_num, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_pic
 * JD-Core Version:    0.7.0.1
 */