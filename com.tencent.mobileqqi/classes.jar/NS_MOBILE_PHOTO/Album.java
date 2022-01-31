package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Album
  extends JceStruct
{
  static ArrayList cache_album_white_list;
  static Map cache_busi_param;
  public ArrayList album_white_list = null;
  public String albumid = "";
  public int allow_share = 0;
  public String answer = "";
  public long birth_time = 0L;
  public Map busi_param = null;
  public String coverurl = "";
  public int createtime = 0;
  public String desc = "";
  public boolean isSubscribe = true;
  public int lastuploadtime = 0;
  public int moditytime = 0;
  public String name = "";
  public int opmask = 0;
  public int priv = 0;
  public String question = "";
  public long svrtime = 0L;
  public int total = 0;
  public int type = 0;
  public long uin = 0L;
  
  public Album() {}
  
  public Album(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, int paramInt6, ArrayList paramArrayList, long paramLong2, Map paramMap, long paramLong3, int paramInt7, boolean paramBoolean, int paramInt8, String paramString6)
  {
    this.uin = paramLong1;
    this.albumid = paramString1;
    this.name = paramString2;
    this.desc = paramString3;
    this.createtime = paramInt1;
    this.moditytime = paramInt2;
    this.lastuploadtime = paramInt3;
    this.priv = paramInt4;
    this.total = paramInt5;
    this.question = paramString4;
    this.answer = paramString5;
    this.allow_share = paramInt6;
    this.album_white_list = paramArrayList;
    this.svrtime = paramLong2;
    this.busi_param = paramMap;
    this.birth_time = paramLong3;
    this.type = paramInt7;
    this.isSubscribe = paramBoolean;
    this.opmask = paramInt8;
    this.coverurl = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.name = paramJceInputStream.readString(2, true);
    this.desc = paramJceInputStream.readString(3, true);
    this.createtime = paramJceInputStream.read(this.createtime, 4, true);
    this.moditytime = paramJceInputStream.read(this.moditytime, 5, true);
    this.lastuploadtime = paramJceInputStream.read(this.lastuploadtime, 6, true);
    this.priv = paramJceInputStream.read(this.priv, 7, true);
    this.total = paramJceInputStream.read(this.total, 8, true);
    this.question = paramJceInputStream.readString(9, false);
    this.answer = paramJceInputStream.readString(10, false);
    this.allow_share = paramJceInputStream.read(this.allow_share, 11, false);
    if (cache_album_white_list == null)
    {
      cache_album_white_list = new ArrayList();
      cache_album_white_list.add(Long.valueOf(0L));
    }
    this.album_white_list = ((ArrayList)paramJceInputStream.read(cache_album_white_list, 12, false));
    this.svrtime = paramJceInputStream.read(this.svrtime, 13, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 14, false));
    this.birth_time = paramJceInputStream.read(this.birth_time, 15, false);
    this.type = paramJceInputStream.read(this.type, 16, false);
    this.isSubscribe = paramJceInputStream.read(this.isSubscribe, 17, false);
    this.opmask = paramJceInputStream.read(this.opmask, 18, false);
    this.coverurl = paramJceInputStream.readString(19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.name, 2);
    paramJceOutputStream.write(this.desc, 3);
    paramJceOutputStream.write(this.createtime, 4);
    paramJceOutputStream.write(this.moditytime, 5);
    paramJceOutputStream.write(this.lastuploadtime, 6);
    paramJceOutputStream.write(this.priv, 7);
    paramJceOutputStream.write(this.total, 8);
    if (this.question != null) {
      paramJceOutputStream.write(this.question, 9);
    }
    if (this.answer != null) {
      paramJceOutputStream.write(this.answer, 10);
    }
    paramJceOutputStream.write(this.allow_share, 11);
    if (this.album_white_list != null) {
      paramJceOutputStream.write(this.album_white_list, 12);
    }
    paramJceOutputStream.write(this.svrtime, 13);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 14);
    }
    paramJceOutputStream.write(this.birth_time, 15);
    paramJceOutputStream.write(this.type, 16);
    paramJceOutputStream.write(this.isSubscribe, 17);
    paramJceOutputStream.write(this.opmask, 18);
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.Album
 * JD-Core Version:    0.7.0.1
 */