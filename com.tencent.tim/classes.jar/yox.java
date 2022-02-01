import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;

public final class yox
  implements Parcelable.Creator<SearchResultItem>
{
  public SearchResultItem a(Parcel paramParcel)
  {
    return new SearchResultItem(paramParcel);
  }
  
  public SearchResultItem[] a(int paramInt)
  {
    return new SearchResultItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yox
 * JD-Core Version:    0.7.0.1
 */