package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class ViewPager$SavedState$1
  implements Parcelable.ClassLoaderCreator
{
  public ViewPager.SavedState createFromParcel(Parcel paramParcel)
  {
    return new ViewPager.SavedState(paramParcel, null);
  }
  
  public ViewPager.SavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new ViewPager.SavedState(paramParcel, paramClassLoader);
  }
  
  public ViewPager.SavedState[] newArray(int paramInt)
  {
    return new ViewPager.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager.SavedState.1
 * JD-Core Version:    0.7.0.1
 */