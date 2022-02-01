import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.List;

public class pkc
{
  public AddressItem a;
  public pkx.a a;
  public String geohashString;
  public List<pkd.a> picList;
  
  public pkc(String paramString)
  {
    this.geohashString = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof pkc));
    return TextUtils.equals(this.geohashString, ((pkc)paramObject).geohashString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("GeoHashPhotoGroup=[");
    localStringBuilder1.append("geohashString:").append(this.geohashString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("picList size:");
    if (this.picList == null) {}
    for (int i = 0;; i = this.picList.size())
    {
      localStringBuilder2.append(i);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkc
 * JD-Core Version:    0.7.0.1
 */