import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;

public final class ammq
  implements Parcelable.Creator<AssociateSearchWordsFragment.AssociateItem>
{
  public AssociateSearchWordsFragment.AssociateItem a(Parcel paramParcel)
  {
    return new AssociateSearchWordsFragment.AssociateItem(paramParcel);
  }
  
  public AssociateSearchWordsFragment.AssociateItem[] a(int paramInt)
  {
    return new AssociateSearchWordsFragment.AssociateItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ammq
 * JD-Core Version:    0.7.0.1
 */