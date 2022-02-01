import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;

public class uuh
{
  public String mMsgData;
  public String mPushId;
  
  protected uuh(Parcel paramParcel)
  {
    this.mPushId = paramParcel.readString();
    this.mMsgData = paramParcel.readString();
  }
  
  protected uuh(String paramString)
  {
    this.mMsgData = paramString;
    try
    {
      parseJson(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      uya.b("WSPushMsgActionData parse failed : " + paramString.getLocalizedMessage());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuh
 * JD-Core Version:    0.7.0.1
 */