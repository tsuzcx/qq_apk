import android.os.Parcel;
import org.json.JSONObject;

public class tix
{
  public String mAbTest;
  public int mType;
  
  protected tix(Parcel paramParcel)
  {
    this.mType = paramParcel.readInt();
    this.mAbTest = paramParcel.readString();
  }
  
  protected tix(JSONObject paramJSONObject)
  {
    this.mType = paramJSONObject.optInt("type");
    this.mAbTest = paramJSONObject.optString("qq_abtest");
    parseJson(paramJSONObject);
  }
  
  protected void parseJson(JSONObject paramJSONObject) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mType);
    paramParcel.writeString(this.mAbTest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tix
 * JD-Core Version:    0.7.0.1
 */