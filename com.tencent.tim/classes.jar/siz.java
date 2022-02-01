import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;

public final class siz
  implements Parcelable.Creator<CommodityBean>
{
  public CommodityBean a(Parcel paramParcel)
  {
    return new CommodityBean(paramParcel);
  }
  
  public CommodityBean[] a(int paramInt)
  {
    return new CommodityBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     siz
 * JD-Core Version:    0.7.0.1
 */