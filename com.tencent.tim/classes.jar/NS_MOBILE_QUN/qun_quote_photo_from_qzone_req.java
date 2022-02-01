package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_quote_photo_from_qzone_req
  extends JceStruct
{
  static ArrayList<s_quote_photo_info> cache_photo_list;
  public String albumid = "";
  public long batchid;
  public String clientkey = "";
  public String desc = "";
  public long fromUin;
  public ArrayList<s_quote_photo_info> photo_list;
  public String qunid = "";
  
  public qun_quote_photo_from_qzone_req() {}
  
  public qun_quote_photo_from_qzone_req(String paramString1, String paramString2, long paramLong1, ArrayList<s_quote_photo_info> paramArrayList, String paramString3, long paramLong2, String paramString4)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
    this.fromUin = paramLong1;
    this.photo_list = paramArrayList;
    this.desc = paramString3;
    this.batchid = paramLong2;
    this.clientkey = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.fromUin = paramJceInputStream.read(this.fromUin, 2, true);
    if (cache_photo_list == null)
    {
      cache_photo_list = new ArrayList();
      s_quote_photo_info locals_quote_photo_info = new s_quote_photo_info();
      cache_photo_list.add(locals_quote_photo_info);
    }
    this.photo_list = ((ArrayList)paramJceInputStream.read(cache_photo_list, 3, true));
    this.desc = paramJceInputStream.readString(4, false);
    this.batchid = paramJceInputStream.read(this.batchid, 5, false);
    this.clientkey = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.fromUin, 2);
    paramJceOutputStream.write(this.photo_list, 3);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 4);
    }
    paramJceOutputStream.write(this.batchid, 5);
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_quote_photo_from_qzone_req
 * JD-Core Version:    0.7.0.1
 */