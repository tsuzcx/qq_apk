package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avut;
import java.util.Map;

public class MapParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<MapParcelable> CREATOR = new avut();
  private Map<Integer, String> qf;
  
  public MapParcelable(Map<Integer, String> paramMap)
  {
    this.qf = paramMap;
  }
  
  public Map<Integer, String> aK()
  {
    return this.qf;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.qf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.MapParcelable
 * JD-Core Version:    0.7.0.1
 */