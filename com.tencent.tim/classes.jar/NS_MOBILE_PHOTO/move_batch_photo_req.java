package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class move_batch_photo_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param;
  static ArrayList<String> cache_src_picid_list;
  public Map<Integer, String> busi_param;
  public String dst_albumid = "";
  public String src_albumid = "";
  public ArrayList<String> src_picid_list;
  
  public move_batch_photo_req() {}
  
  public move_batch_photo_req(String paramString1, ArrayList<String> paramArrayList, String paramString2, Map<Integer, String> paramMap)
  {
    this.src_albumid = paramString1;
    this.src_picid_list = paramArrayList;
    this.dst_albumid = paramString2;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.src_albumid = paramJceInputStream.readString(0, true);
    if (cache_src_picid_list == null)
    {
      cache_src_picid_list = new ArrayList();
      cache_src_picid_list.add("");
    }
    this.src_picid_list = ((ArrayList)paramJceInputStream.read(cache_src_picid_list, 1, true));
    this.dst_albumid = paramJceInputStream.readString(2, true);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.src_albumid, 0);
    paramJceOutputStream.write(this.src_picid_list, 1);
    paramJceOutputStream.write(this.dst_albumid, 2);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.move_batch_photo_req
 * JD-Core Version:    0.7.0.1
 */