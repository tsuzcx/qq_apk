package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_photo_list_2_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static int cache_sort_type = 0;
  static int cache_type;
  public String albumid = "";
  public String attach_info = "";
  public Map<Integer, String> busi_param;
  public String ciphertext = "";
  public String curlloc = "";
  public long face_uin;
  public boolean need_pos;
  public String password = "";
  public long password_cleartext = 1L;
  public int pn;
  public int ps;
  public String req_url = "";
  public long sharer;
  public int sheight;
  public int sort_type = 0;
  public int swidth;
  public int type;
  public long uin;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_type = 0;
  }
  
  public get_photo_list_2_req() {}
  
  public get_photo_list_2_req(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, Map<Integer, String> paramMap, String paramString4, long paramLong2, String paramString5, long paramLong3, int paramInt5, long paramLong4, boolean paramBoolean, int paramInt6, String paramString6)
  {
    this.uin = paramLong1;
    this.albumid = paramString1;
    this.ps = paramInt1;
    this.pn = paramInt2;
    this.password = paramString2;
    this.curlloc = paramString3;
    this.swidth = paramInt3;
    this.sheight = paramInt4;
    this.busi_param = paramMap;
    this.req_url = paramString4;
    this.face_uin = paramLong2;
    this.ciphertext = paramString5;
    this.password_cleartext = paramLong3;
    this.type = paramInt5;
    this.sharer = paramLong4;
    this.need_pos = paramBoolean;
    this.sort_type = paramInt6;
    this.attach_info = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.albumid = paramJceInputStream.readString(2, true);
    this.ps = paramJceInputStream.read(this.ps, 3, true);
    this.pn = paramJceInputStream.read(this.pn, 4, true);
    this.password = paramJceInputStream.readString(5, false);
    this.curlloc = paramJceInputStream.readString(6, false);
    this.swidth = paramJceInputStream.read(this.swidth, 7, false);
    this.sheight = paramJceInputStream.read(this.sheight, 8, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 9, false));
    this.req_url = paramJceInputStream.readString(10, false);
    this.face_uin = paramJceInputStream.read(this.face_uin, 11, false);
    this.ciphertext = paramJceInputStream.readString(12, false);
    this.password_cleartext = paramJceInputStream.read(this.password_cleartext, 13, false);
    this.type = paramJceInputStream.read(this.type, 14, false);
    this.sharer = paramJceInputStream.read(this.sharer, 15, false);
    this.need_pos = paramJceInputStream.read(this.need_pos, 16, false);
    this.sort_type = paramJceInputStream.read(this.sort_type, 17, false);
    this.attach_info = paramJceInputStream.readString(18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.albumid, 2);
    paramJceOutputStream.write(this.ps, 3);
    paramJceOutputStream.write(this.pn, 4);
    if (this.password != null) {
      paramJceOutputStream.write(this.password, 5);
    }
    if (this.curlloc != null) {
      paramJceOutputStream.write(this.curlloc, 6);
    }
    paramJceOutputStream.write(this.swidth, 7);
    paramJceOutputStream.write(this.sheight, 8);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 9);
    }
    if (this.req_url != null) {
      paramJceOutputStream.write(this.req_url, 10);
    }
    paramJceOutputStream.write(this.face_uin, 11);
    if (this.ciphertext != null) {
      paramJceOutputStream.write(this.ciphertext, 12);
    }
    paramJceOutputStream.write(this.password_cleartext, 13);
    paramJceOutputStream.write(this.type, 14);
    paramJceOutputStream.write(this.sharer, 15);
    paramJceOutputStream.write(this.need_pos, 16);
    paramJceOutputStream.write(this.sort_type, 17);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_list_2_req
 * JD-Core Version:    0.7.0.1
 */