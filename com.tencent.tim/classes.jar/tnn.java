import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class tnn
  extends tnk
{
  private ArrayList<String> oE = new ArrayList();
  
  public tnn(JSONObject paramJSONObject)
  {
    readFromJson(paramJSONObject);
  }
  
  public boolean ae(boolean paramBoolean)
  {
    if (this.oE.size() <= 0)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigDalvik isValidConfig classIdList is empty");
      return false;
    }
    return super.ae(paramBoolean);
  }
  
  public ArrayList<String> bC()
  {
    return this.oE;
  }
  
  public String or()
  {
    String str1 = super.or();
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      localJSONObject.put("patchName", this.aJC);
      localJSONObject.put("patchUrl", this.patchUrl);
      localJSONObject.put("patchSize", this.bCx);
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((this.oE != null) && (this.oE.size() > 0))
      {
        Iterator localIterator = this.oE.iterator();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str3)) {
            localStringBuilder.append(str3).append(";");
          }
        }
      }
      localJSONException.put("classIdList", localStringBuilder.toString());
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigDalvik writeToJsonString", localJSONException);
      return str1;
    }
    String str2 = localJSONException.toString();
    return str2;
  }
  
  protected void readFromJson(JSONObject paramJSONObject)
  {
    int i = 0;
    super.readFromJson(paramJSONObject);
    this.aJC = paramJSONObject.optString("patchName", null);
    this.patchUrl = paramJSONObject.optString("patchUrl", null);
    this.bCx = paramJSONObject.optInt("patchSize", 0);
    paramJSONObject = paramJSONObject.optString("classIdList", "").split(";");
    if ((paramJSONObject != null) && (paramJSONObject.length > 0))
    {
      int j = paramJSONObject.length;
      while (i < j)
      {
        CharSequence localCharSequence = paramJSONObject[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          this.oE.add(localCharSequence);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tnn
 * JD-Core Version:    0.7.0.1
 */