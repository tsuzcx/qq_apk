import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public final class mgr
  implements Parcelable.Creator<ArticleInfo>
{
  public ArticleInfo a(Parcel paramParcel)
  {
    return new ArticleInfo(paramParcel);
  }
  
  public ArticleInfo[] a(int paramInt)
  {
    return new ArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgr
 * JD-Core Version:    0.7.0.1
 */