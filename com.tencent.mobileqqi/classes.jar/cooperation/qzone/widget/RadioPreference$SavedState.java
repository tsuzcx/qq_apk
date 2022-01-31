package cooperation.qzone.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.Preference.BaseSavedState;
import iid;

public class RadioPreference$SavedState
  extends Preference.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new iid();
  boolean a;
  
  public RadioPreference$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.a = bool;
      return;
      bool = false;
    }
  }
  
  public RadioPreference$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.a) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.widget.RadioPreference.SavedState
 * JD-Core Version:    0.7.0.1
 */