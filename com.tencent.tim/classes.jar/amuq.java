import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amuq
{
  private String ccg = "";
  private int dDG = 1;
  private String mExtraData = "";
  
  public static String a(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", paramInt);
      if (paramBoolean1)
      {
        paramInt = 1;
        localJSONObject.put("match", paramInt);
        localJSONObject.put("keyword", paramString);
        if (!paramBoolean2) {
          break label74;
        }
      }
      label74:
      for (paramInt = i;; paramInt = 0)
      {
        localJSONObject.put("nightmode", paramInt);
        paramString = localJSONObject.toString();
        return paramString;
        paramInt = 0;
        break;
      }
      return null;
    }
    catch (JSONException paramString)
    {
      QLog.e("RichMetaData", 2, "setLayout101ExtraData exception:" + paramString);
    }
  }
  
  public void PT(String paramString)
  {
    this.mExtraData = paramString;
  }
  
  public void PX(String paramString)
  {
    this.ccg = paramString;
  }
  
  public void Px(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dDG = 1;
      return;
    }
    this.dDG = 0;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("serverdata", new JSONObject(this.ccg));
      localJSONObject2.put("state", this.dDG);
      if (!TextUtils.isEmpty(this.mExtraData)) {
        localJSONObject2.put("extradata", new JSONObject(this.mExtraData));
      }
      localJSONObject1.put("data", localJSONObject2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("RichMetaData", 2, "convertMetaData exception : " + localJSONException);
      }
    }
    return localJSONObject1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amuq
 * JD-Core Version:    0.7.0.1
 */