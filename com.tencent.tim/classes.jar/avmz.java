import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qqreader.js.JsCallParams;

public final class avmz
  implements Parcelable.Creator<JsCallParams>
{
  public JsCallParams a(Parcel paramParcel)
  {
    return new JsCallParams(paramParcel, null);
  }
  
  public JsCallParams[] a(int paramInt)
  {
    return new JsCallParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmz
 * JD-Core Version:    0.7.0.1
 */