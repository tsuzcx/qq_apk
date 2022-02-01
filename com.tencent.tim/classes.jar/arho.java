import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arho
  implements aehn.b
{
  private QQAppInterface app;
  private arho.a b;
  private String cAv;
  private final Boolean[] d = new Boolean[11];
  private final int[] po = { 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 };
  
  public arho(QQAppInterface paramQQAppInterface, arho.a parama)
  {
    this.app = paramQQAppInterface;
    this.b = parama;
    if (this.app != null)
    {
      this.app.a().a("profile_btn_config", this);
      this.app.a().a("profile_switch_config", this);
    }
  }
  
  private void Wv(String paramString)
  {
    int[] arrayOfInt = new int[11];
    int i = 0;
    while (i < 11)
    {
      arrayOfInt[i] = this.po[i];
      i += 1;
    }
    label307:
    label462:
    label467:
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label474;
      }
      if (this.app != null) {
        break label307;
      }
      localObject = "";
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        localException1 = localException1;
        QLog.e("ProfileConfigHelper", 1, "initProfileSwitchConfig fail.", localException1);
        i = 0;
        if (i < 11)
        {
          arrayOfBoolean = this.d;
          if (arrayOfInt[i] == 1) {}
          for (bool = true;; bool = false)
          {
            arrayOfBoolean[i] = Boolean.valueOf(bool);
            i += 1;
            break;
          }
        }
      }
    }
    finally
    {
      i = 0;
      if (i >= 11) {
        break label467;
      }
      Boolean[] arrayOfBoolean = this.d;
      if (arrayOfInt[i] != 1) {
        break label462;
      }
      for (boolean bool = true;; bool = false)
      {
        arrayOfBoolean[i] = Boolean.valueOf(bool);
        i += 1;
        break;
      }
    }
    localObject = aehn.aS((String)localObject, "profile_switch_config");
    paramString = (String)localObject;
    label474:
    for (;;) {}
  }
  
  private void Ww(String paramString)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    label165:
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label165;
        }
        if (this.app == null)
        {
          str = "";
          str = aehn.aS(str, "profile_btn_config");
          paramString = str;
        }
      }
      catch (Exception localException1)
      {
        String str;
        localException1.printStackTrace();
        Object localObject1 = localObject4;
        if (TextUtils.isEmpty(null)) {
          localObject1 = acfp.m(2131709913);
        }
        this.cAv = ((String)localObject1);
        continue;
      }
      finally
      {
        paramString = (String)localObject3;
        if (TextUtils.isEmpty(null)) {
          paramString = acfp.m(2131709913);
        }
        this.cAv = paramString;
      }
      try
      {
        str = new JSONObject(paramString).optString("call_wording");
        localObject3 = str;
        if (TextUtils.isEmpty(str)) {
          localObject3 = acfp.m(2131709913);
        }
        this.cAv = ((String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.i("ProfileConfigHelper", 2, String.format("initVoiceBtnConfig [str:%s content:%s]", new Object[] { this.cAv, paramString }));
        }
        return;
      }
      catch (Exception localException2)
      {
        continue;
      }
      str = this.app.getCurrentAccountUin();
    }
  }
  
  public String CT()
  {
    if (this.app == null) {
      return acfp.m(2131709895);
    }
    if (this.cAv == null) {
      Ww(null);
    }
    return this.cAv;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aehn.a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      if ("profile_btn_config".equals(paramString)) {
        Ww(parama.strContent);
      }
      while (this.b != null)
      {
        this.b.bf(paramInt, paramString);
        return;
        if ("profile_switch_config".equals(paramString)) {
          Wv(parama.strContent);
        }
      }
    }
  }
  
  public void destroy()
  {
    if (this.app != null) {
      this.app.a().a(this);
    }
    this.app = null;
    this.b = null;
  }
  
  public boolean mI(int paramInt)
  {
    if (this.app == null) {}
    while ((paramInt < 0) || (paramInt >= 11)) {
      return false;
    }
    if (this.d[paramInt] == null) {
      Wv(null);
    }
    return this.d[paramInt].booleanValue();
  }
  
  public static abstract interface a
  {
    public abstract void bf(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arho
 * JD-Core Version:    0.7.0.1
 */