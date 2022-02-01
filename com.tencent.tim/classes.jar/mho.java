import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.articlesummary.articlesummary.LocalInfo;

public class mho
{
  public String aaW;
  public String ahh;
  public String ahi;
  public String corporate_image_name;
  public String distance_description;
  public String store_address;
  public String store_name;
  public String store_url;
  
  public mho() {}
  
  public mho(articlesummary.LocalInfo paramLocalInfo)
  {
    if (paramLocalInfo == null) {
      return;
    }
    this.store_name = paramLocalInfo.bytes_store_url.get().toStringUtf8();
    this.store_url = paramLocalInfo.bytes_store_url.get().toStringUtf8();
    this.store_address = paramLocalInfo.bytes_store_address.get().toStringUtf8();
    this.ahh = paramLocalInfo.bytes_store_longitude.get().toStringUtf8();
    this.ahi = paramLocalInfo.bytes_store_latitude.get().toStringUtf8();
    this.distance_description = paramLocalInfo.bytes_distance_description.get().toStringUtf8();
    this.corporate_image_name = paramLocalInfo.bytes_corporate_image_name.get().toStringUtf8();
    this.aaW = paramLocalInfo.bytes_distance_limit.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mho
 * JD-Core Version:    0.7.0.1
 */