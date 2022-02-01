import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.lottieNew.LottieAnimationView.SavedState;

public final class trw
  implements Parcelable.Creator<LottieAnimationView.SavedState>
{
  public LottieAnimationView.SavedState a(Parcel paramParcel)
  {
    return new LottieAnimationView.SavedState(paramParcel, null);
  }
  
  public LottieAnimationView.SavedState[] a(int paramInt)
  {
    return new LottieAnimationView.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trw
 * JD-Core Version:    0.7.0.1
 */