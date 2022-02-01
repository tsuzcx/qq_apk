package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_parenting_photo_list_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  public String albumid = "";
  public String attach_info = "";
  public Map<Integer, String> busi_param;
  public String ciphertext = "";
  public String password = "";
  public int share_flag;
  public int type;
  public long uin;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public get_parenting_photo_list_req() {}
  
  public get_parenting_photo_list_req(long paramLong, String paramString1, String paramString2, String paramString3, Map<Integer, String> paramMap, int paramInt1, String paramString4, int paramInt2)
  {
    this.uin = paramLong;
    this.albumid = paramString1;
    this.attach_info = paramString2;
    this.password = paramString3;
    this.busi_param = paramMap;
    this.share_flag = paramInt1;
    this.ciphertext = paramString4;
    this.type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.attach_info = paramJceInputStream.readString(2, false);
    this.password = paramJceInputStream.readString(3, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 4, false));
    this.share_flag = paramJceInputStream.read(this.share_flag, 5, false);
    this.ciphertext = paramJceInputStream.readString(6, false);
    this.type = paramJceInputStream.read(this.type, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.albumid, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    if (this.password != null) {
      paramJceOutputStream.write(this.password, 3);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 4);
    }
    paramJceOutputStream.write(this.share_flag, 5);
    if (this.ciphertext != null) {
      paramJceOutputStream.write(this.ciphertext, 6);
    }
    paramJceOutputStream.write(this.type, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_parenting_photo_list_req
 * JD-Core Version:    0.7.0.1
 */