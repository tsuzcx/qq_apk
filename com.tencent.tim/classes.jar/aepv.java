import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aepv
  implements aehx<String>
{
  public String byc;
  public HashMap<String, aepv.a> jZ = new HashMap();
  
  public aepv()
  {
    this.jZ.put("*", new aepv.a());
    this.byc = "";
  }
  
  public void lR(String paramString)
  {
    int i;
    Object localObject2;
    aepv.a locala;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.length() == 0) {
        return;
      }
      this.byc = paramString;
      paramString = localJSONObject.names();
      i = 0;
      if (i >= paramString.length()) {
        break label212;
      }
      localObject1 = paramString.getString(i).trim().toLowerCase();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label213;
      }
      localObject2 = localJSONObject.optJSONObject((String)localObject1);
      locala = new aepv.a();
      locala.cOw = ((JSONObject)localObject2).getInt("CellNetAutoDownloadSize");
      locala.cOv = ((JSONObject)localObject2).getInt("CellNetWarningSize");
      locala.cOu = ((JSONObject)localObject2).getInt("WiFiNetAutoDownloadSize");
      if (!((String)localObject1).contains(",")) {
        this.jZ.put(localObject1, locala);
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("", 1, QLog.getStackTraceString(paramString));
      return;
    }
    Object localObject1 = ((String)localObject1).split(",");
    int j = 0;
    for (;;)
    {
      if (j < localObject1.length)
      {
        localObject2 = localObject1[j].trim().toLowerCase();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jZ.put(localObject2, locala);
        }
      }
      else
      {
        label212:
        label213:
        i += 1;
        break;
      }
      j += 1;
    }
  }
  
  public class a
  {
    public int cOu = 512000;
    public int cOv = 3145728;
    public int cOw = 3145728;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepv
 * JD-Core Version:    0.7.0.1
 */