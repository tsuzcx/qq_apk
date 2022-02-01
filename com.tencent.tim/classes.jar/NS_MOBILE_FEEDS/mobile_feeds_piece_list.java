package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_feeds_piece_list
  extends JceStruct
{
  static ArrayList<single_feed> cache_all_feeds_data = new ArrayList();
  public ArrayList<single_feed> all_feeds_data;
  public long offset;
  public String tlv_attach_info = "";
  
  static
  {
    single_feed localsingle_feed = new single_feed();
    cache_all_feeds_data.add(localsingle_feed);
  }
  
  public mobile_feeds_piece_list() {}
  
  public mobile_feeds_piece_list(ArrayList<single_feed> paramArrayList, long paramLong, String paramString)
  {
    this.all_feeds_data = paramArrayList;
    this.offset = paramLong;
    this.tlv_attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 0, false));
    this.offset = paramJceInputStream.read(this.offset, 1, false);
    this.tlv_attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 0);
    }
    paramJceOutputStream.write(this.offset, 1);
    if (this.tlv_attach_info != null) {
      paramJceOutputStream.write(this.tlv_attach_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_piece_list
 * JD-Core Version:    0.7.0.1
 */