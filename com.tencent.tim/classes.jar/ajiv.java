import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SavedState;

public final class ajiv
  implements Parcelable.ClassLoaderCreator<MultiAIOBaseViewPager.SavedState>
{
  public MultiAIOBaseViewPager.SavedState a(Parcel paramParcel)
  {
    return new MultiAIOBaseViewPager.SavedState(paramParcel, null);
  }
  
  public MultiAIOBaseViewPager.SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new MultiAIOBaseViewPager.SavedState(paramParcel, paramClassLoader);
  }
  
  public MultiAIOBaseViewPager.SavedState[] a(int paramInt)
  {
    return new MultiAIOBaseViewPager.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajiv
 * JD-Core Version:    0.7.0.1
 */