import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public abstract class acuk
  extends aqhv
{
  public acuk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public void Ge(String paramString)
  {
    HashMap localHashMap = new HashMap(1);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.source == null) {
      this.source = "";
    }
    if (this.cti == null) {
      this.cti = "";
    }
    if (this.ctj == null) {
      this.ctj = "";
    }
    paramString = new StringBuilder();
    paramString.append(str).append("source:").append(this.source).append("server_name:").append(this.cti).append("action_name:").append(this.ctj);
    localHashMap.put("keyJumpParserUtilDoActionErrorInfo", paramString.toString());
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, localHashMap, "", false);
  }
  
  public boolean ace()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acuk
 * JD-Core Version:    0.7.0.1
 */