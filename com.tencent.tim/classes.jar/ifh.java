import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ifh
  extends iet
{
  ifh(ifg paramifg, ifv paramifv, Long paramLong) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GoogleTranslator", 2, "[ERROR][SHOULD NOT GO HERE][onSuccess] statusCode:" + paramInt);
    }
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    paramArrayOfHeader = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.getJSONArray("translations");
        if (paramJSONObject != null)
        {
          paramInt = 0;
          while (paramInt < paramJSONObject.length())
          {
            String str1 = ((JSONObject)paramJSONObject.get(paramInt)).getString("translatedText");
            String str2 = ((JSONObject)paramJSONObject.get(paramInt)).getString("detectedSourceLanguage");
            if ((paramArrayOfHeader != null) && (localArrayList != null))
            {
              paramArrayOfHeader.add(Language.fromString(str2));
              localArrayList.add(str1);
            }
            paramInt += 1;
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      this.a.a(paramArrayOfHeader, localArrayList, this.p);
    }
  }
  
  public void c(Throwable paramThrowable, String paramString)
  {
    this.a.a(new TranslateError(paramThrowable), this.p);
    if (QLog.isColorLevel()) {
      QLog.e("GoogleTranslator", 2, " [onFailure][GoogleTranslateClient] Throwable:" + paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifh
 * JD-Core Version:    0.7.0.1
 */