import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.setting.QIMSelectEffectParams;

public final class aycd
  implements Parcelable.Creator<QIMSelectEffectParams>
{
  public QIMSelectEffectParams a(Parcel paramParcel)
  {
    return new QIMSelectEffectParams(paramParcel);
  }
  
  public QIMSelectEffectParams[] a(int paramInt)
  {
    return new QIMSelectEffectParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycd
 * JD-Core Version:    0.7.0.1
 */