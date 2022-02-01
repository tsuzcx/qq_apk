import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet.ConfigResult;

public final class kyc
  implements Parcelable.Creator<AladdinConfigServlet.ConfigResult>
{
  public AladdinConfigServlet.ConfigResult a(Parcel paramParcel)
  {
    return new AladdinConfigServlet.ConfigResult(paramParcel);
  }
  
  public AladdinConfigServlet.ConfigResult[] a(int paramInt)
  {
    return new AladdinConfigServlet.ConfigResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyc
 * JD-Core Version:    0.7.0.1
 */