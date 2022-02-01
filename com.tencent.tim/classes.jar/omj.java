import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;

public class omj
{
  public String mMsgData;
  public String mPushId;
  
  protected omj(Parcel paramParcel)
  {
    this.mPushId = paramParcel.readString();
    this.mMsgData = paramParcel.readString();
  }
  
  protected omj(String paramString)
  {
    this.mMsgData = paramString;
    try
    {
      parseJson(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      ooz.e("WSPushMsgActionData parse failed : " + paramString.getLocalizedMessage());
    }
  }
  
  protected void parseJson(JSONObject paramJSONObject)
  {
    this.mPushId = paramJSONObject.optString("pushid");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPushId);
    paramParcel.writeString(this.mMsgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omj
 * JD-Core Version:    0.7.0.1
 */