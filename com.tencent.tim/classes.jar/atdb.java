import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tim.call.qcall.PstnCardInfo;

public final class atdb
  implements Parcelable.Creator<PstnCardInfo>
{
  public PstnCardInfo a(Parcel paramParcel)
  {
    return new PstnCardInfo(paramParcel);
  }
  
  public PstnCardInfo[] a(int paramInt)
  {
    return new PstnCardInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdb
 * JD-Core Version:    0.7.0.1
 */