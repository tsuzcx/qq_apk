import android.content.Context;
import android.os.SystemClock;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class xpf
  implements ifu
{
  xpf(xpc paramxpc, xpc.a parama, Context paramContext, String paramString) {}
  
  public void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, xpc.a parama)
  {
    xpc.a(this.a, this.c);
    if (parama != null) {
      ifs.a(this.H).b(this.aVO, parama.aVP, parama.uniseq, Boolean.valueOf(false));
    }
    String str;
    if (this.c != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Translator", 2, "[ChatAdapter]holder id:" + this.c.uniseq + "request id:" + paramLong);
      }
      if ((!paramString1.equalsIgnoreCase(this.c.msg)) || (this.c.uniseq != paramLong) || (parama == null) || (parama.wR == null) || (this.H == null)) {
        break label481;
      }
      if (!paramLanguage.toString().equalsIgnoreCase(this.aVO)) {
        break label317;
      }
      xpc.bVP += 1;
      if (this.c.istroop != 0) {
        break label389;
      }
      str = "0";
      label180:
      anpc.a(this.a.mContext).a(this.a.app, this.a.app.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 0, String.valueOf(SystemClock.uptimeMillis() - parama.Jk), str, paramLanguage.toString(), this.aVO);
      if ((paramLanguage.toString().equalsIgnoreCase(this.aVO)) || (paramString2.equalsIgnoreCase(paramString1))) {
        break label434;
      }
      paramLanguage = ifs.a(this.a.mContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.aVO);
      }
      parama.bVR = 1;
      this.a.notifyDataSetChanged();
    }
    label317:
    label481:
    do
    {
      return;
      if ((paramLanguage.toString().equalsIgnoreCase("zh-CHS")) && (this.aVO.equalsIgnoreCase("zh-CN")))
      {
        xpc.bVP += 1;
        break;
      }
      if ((!paramLanguage.toString().equalsIgnoreCase("zh-CHT")) || (!this.aVO.equalsIgnoreCase("zh-TW"))) {
        break;
      }
      xpc.bVP += 1;
      break;
      if (this.c.istroop == 1)
      {
        str = "1";
        break label180;
      }
      if (this.c.istroop == 3000)
      {
        str = "2";
        break label180;
      }
      str = "";
      break label180;
      paramLanguage = ifs.a(this.a.mContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.aVO);
      }
      this.a.As(2131717242);
      return;
      if ((!paramLanguage.toString().equalsIgnoreCase(this.aVO)) && (this.H != null))
      {
        ifs.a(this.H).a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.aVO);
        return;
      }
    } while (this.H == null);
    label389:
    label434:
    ifs.a(this.H).a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.aVO);
  }
  
  public void a(long paramLong, String paramString, TranslateError paramTranslateError, xpc.a parama)
  {
    xpc.a(this.a, this.c);
    if (parama != null) {
      ifs.a(this.H).b(this.aVO, parama.aVP, parama.uniseq, Boolean.valueOf(false));
    }
    if ((parama != null) && (parama.wR != null) && (paramTranslateError != null)) {
      if ((paramTranslateError.getMessage() != null) && (paramTranslateError.getMessage().length() > 0)) {
        if ((paramTranslateError.getMessage().indexOf("Unable to resolve host") >= 0) || (paramTranslateError.getMessage().indexOf("can't resolve host") >= 0))
        {
          this.a.As(2131717243);
          if (this.c.istroop != 0) {
            break label232;
          }
          paramString = "0";
          anpc.a(this.a.mContext).a(this.a.app, this.a.app.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 1, "", paramString, "", "");
          if (QLog.isColorLevel()) {
            QLog.e("Translator", 2, "onFailed:" + paramTranslateError);
          }
        }
      }
    }
    label232:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.a.As(2131717245);
        continue;
        this.a.As(2131717246);
        continue;
        if (this.c.istroop == 1) {
          paramString = "1";
        } else if (this.c.istroop == 3000) {
          paramString = "2";
        } else {
          paramString = "";
        }
      }
    }
    QLog.e("Translator", 2, "onFailed:e is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpf
 * JD-Core Version:    0.7.0.1
 */