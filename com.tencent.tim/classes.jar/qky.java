import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.SavedState;

public final class qky
  implements ParcelableCompatCreatorCallbacks<XViewPager.SavedState>
{
  public XViewPager.SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new XViewPager.SavedState(paramParcel, paramClassLoader);
  }
  
  public XViewPager.SavedState[] a(int paramInt)
  {
    return new XViewPager.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qky
 * JD-Core Version:    0.7.0.1
 */