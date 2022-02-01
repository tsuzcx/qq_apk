import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class acwf
  extends acuk
{
  public acwf(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acJ()
  {
    if (this.source != null)
    {
      if (!awdd.a().B(this.pkgName, this.source))
      {
        QLog.e("QzoneAction", 1, "has no right to handle this schema");
        return false;
      }
      String str;
      if (this.source.startsWith("mqqzone"))
      {
        str = "mqzone" + this.source.substring("mqqzone".length());
        if (TextUtils.isEmpty(str)) {
          break label198;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("cmd", "Schema");
        localIntent.putExtra("schema", str);
        opn.a(this.c, this.dw);
        ogj.a(this.context, this.dw, this.c, localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          return true;
          str = (String)aurr.getArgumentsFromURL(this.source).get("schema");
          if (!TextUtils.isEmpty(str)) {
            try
            {
              str = new String(Base64.decode(str, 0), "utf-8");
            }
            catch (Exception localException)
            {
              QLog.e("QzoneAction", 1, localException, new Object[0]);
            }
          }
        }
        Object localObject = null;
        break;
        label198:
        QLog.e("QzoneAction", 1, "gotoQzoneHandleSchema,schema=null");
      }
    }
    return false;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acJ();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneAction", 1, "doAction error: " + localException.getMessage());
      Ge("QzoneAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwf
 * JD-Core Version:    0.7.0.1
 */