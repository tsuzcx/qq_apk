import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

public final class aqlp
  implements Parcelable.Creator<QQRecorder.RecorderParam>
{
  public QQRecorder.RecorderParam a(Parcel paramParcel)
  {
    return new QQRecorder.RecorderParam(paramParcel);
  }
  
  public QQRecorder.RecorderParam[] a(int paramInt)
  {
    return new QQRecorder.RecorderParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqlp
 * JD-Core Version:    0.7.0.1
 */