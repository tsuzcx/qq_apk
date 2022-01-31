package NS_SHARE_ALBUM;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class sa_get_photo_list_rsp
  extends JceStruct
{
  static Album cache_albuminfo;
  static Map cache_batchinfo;
  static ArrayList cache_msglist;
  static ArrayList cache_photolist;
  public Album albuminfo = null;
  public int appid = 0;
  public String attach_info = "";
  public Map batchinfo = null;
  public int hasmore = 0;
  public ArrayList msglist = null;
  public int operationMask = 0;
  public ArrayList photolist = null;
  
  public sa_get_photo_list_rsp() {}
  
  public sa_get_photo_list_rsp(Album paramAlbum, ArrayList paramArrayList1, int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList2, int paramInt3, Map paramMap)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList1;
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.operationMask = paramInt2;
    this.msglist = paramArrayList2;
    this.appid = paramInt3;
    this.batchinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_albuminfo == null) {
      cache_albuminfo = new Album();
    }
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, false));
    Object localObject;
    if (cache_photolist == null)
    {
      cache_photolist = new ArrayList();
      localObject = new s_picdata();
      cache_photolist.add(localObject);
    }
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.operationMask = paramJceInputStream.read(this.operationMask, 4, false);
    if (cache_msglist == null)
    {
      cache_msglist = new ArrayList();
      localObject = new PhotoListMsg();
      cache_msglist.add(localObject);
    }
    this.msglist = ((ArrayList)paramJceInputStream.read(cache_msglist, 5, false));
    this.appid = paramJceInputStream.read(this.appid, 6, false);
    if (cache_batchinfo == null)
    {
      cache_batchinfo = new HashMap();
      localObject = new BatchInfo();
      cache_batchinfo.put("", localObject);
    }
    this.batchinfo = ((Map)paramJceInputStream.read(cache_batchinfo, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albuminfo != null) {
      paramJceOutputStream.write(this.albuminfo, 0);
    }
    if (this.photolist != null) {
      paramJceOutputStream.write(this.photolist, 1);
    }
    paramJceOutputStream.write(this.hasmore, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.operationMask, 4);
    if (this.msglist != null) {
      paramJceOutputStream.write(this.msglist, 5);
    }
    paramJceOutputStream.write(this.appid, 6);
    if (this.batchinfo != null) {
      paramJceOutputStream.write(this.batchinfo, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_get_photo_list_rsp
 * JD-Core Version:    0.7.0.1
 */