import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonWebBean;

public final class afrv
  implements Parcelable.Creator<SearchEmoticonWebBean>
{
  public SearchEmoticonWebBean a(Parcel paramParcel)
  {
    return new SearchEmoticonWebBean(paramParcel);
  }
  
  public SearchEmoticonWebBean[] a(int paramInt)
  {
    return new SearchEmoticonWebBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrv
 * JD-Core Version:    0.7.0.1
 */