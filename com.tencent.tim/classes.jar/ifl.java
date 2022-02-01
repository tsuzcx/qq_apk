import android.content.Context;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class ifl
  extends iet
{
  ifl(ifk paramifk, Long paramLong, Context paramContext, List paramList, Language paramLanguage, ifv paramifv) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    try
    {
      ifk.a(this.b).LH = paramJSONObject.getString("access_token");
      ifk.a(this.b).kv = (paramJSONObject.getLong("expires_in") * 1000L + this.p.longValue());
      ifk.a(this.b, this.H, this.eV, this.jdField_a_of_type_ComRookeryTranslateTypeLanguage, ifk.a(this.b).LH, this.p, this.jdField_a_of_type_Ifv);
      return;
    }
    catch (JSONException paramArrayOfHeader)
    {
      this.jdField_a_of_type_Ifv.a(new TranslateError(paramArrayOfHeader), this.p);
    }
  }
  
  public void c(Throwable paramThrowable, String paramString)
  {
    this.jdField_a_of_type_Ifv.a(new TranslateError(paramThrowable), this.p);
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "error:" + paramThrowable + "\trequest_time:" + this.p);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifl
 * JD-Core Version:    0.7.0.1
 */