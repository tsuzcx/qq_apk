package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ResultReceiver$1
  implements Parcelable.Creator<ResultReceiver>
{
  public ResultReceiver createFromParcel(Parcel paramParcel)
  {
    return new ResultReceiver(paramParcel);
  }
  
  public ResultReceiver[] newArray(int paramInt)
  {
    return new ResultReceiver[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver.1
 * JD-Core Version:    0.7.0.1
 */