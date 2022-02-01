import android.content.Context;
import com.rookery.translate.AITranslator;
import com.rookery.translate.AITranslator.TranslatorType;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.Header;

public class iex
  extends ier
{
  public iex(AITranslator paramAITranslator, Context paramContext) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    if (paramString.equalsIgnoreCase("1"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Translator", 2, "[policy update]: GOOGLE");
      }
      AITranslator.a(this.b, this.H, Boolean.valueOf(true));
      AITranslator.a(this.b, this.H, AITranslator.TranslatorType.GOOGLE, 0L);
      AITranslator.a(this.b, this.H, AITranslator.TranslatorType.MS, 200000L);
    }
    do
    {
      return;
      if (paramString.equals("2"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: MS");
        }
        AITranslator.a(this.b, this.H, Boolean.valueOf(true));
        AITranslator.a(this.b, this.H, AITranslator.TranslatorType.MS, 0L);
        AITranslator.a(this.b, this.H, AITranslator.TranslatorType.GOOGLE, 200000L);
        return;
      }
      if (paramString.equals("0"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: stop service");
        }
        AITranslator.a(this.b, this.H, Boolean.valueOf(false));
        return;
      }
      if (paramString.equals("3"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: decide by Client");
        }
        AITranslator.a(this.b, this.H, Boolean.valueOf(true));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Translator", 2, "[policy update]: Update Failed");
  }
  
  public void c(Throwable paramThrowable, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "update policy error" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iex
 * JD-Core Version:    0.7.0.1
 */