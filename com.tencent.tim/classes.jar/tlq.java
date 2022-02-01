import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationItem;
import com.tencent.widget.AuthorizationItem.a;
import java.util.Iterator;
import java.util.List;

public class tlq
{
  private tlq.b a(String paramString1, String paramString2, String paramString3, List<AuthorizationItem.a> paramList)
  {
    if (paramList.contains(AuthorizationItem.a))
    {
      if (!paramList.contains(AuthorizationItem.b)) {
        break label57;
      }
      label26:
      if (!paramList.contains(AuthorizationItem.c)) {
        break label63;
      }
    }
    for (;;)
    {
      return new tlq.b(paramString1, paramString2, paramString3, null);
      paramString1 = "";
      break;
      label57:
      paramString2 = "";
      break label26;
      label63:
      paramString3 = "";
    }
  }
  
  private void a(Activity paramActivity, boolean paramBoolean, tlq.b paramb, tlq.a parama, List<AuthorizationItem.a> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult: entity -> " + paramb);
    }
    if (paramBoolean)
    {
      if (a(paramActivity, paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult has authorized, return info direct ");
        }
        if (parama != null)
        {
          paramb.errCode = 0;
          parama.a(paramb);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult show authorize dialog to authorize user info");
      }
      paramActivity = new ausy(paramActivity, paramb, parama, paramList);
      paramb = paramActivity.getWindow();
      if (paramb != null) {
        paramb.setWindowAnimations(2131755013);
      }
      paramActivity.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult get result fail");
    }
    if (parama != null) {
      parama.a(tlq.b.b());
    }
    Toast.makeText(paramActivity, paramActivity.getString(2131690654), 0).show();
  }
  
  private boolean a(Context paramContext, List<AuthorizationItem.a> paramList)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!paramContext.getBoolean(((AuthorizationItem.a)paramList.next()).key, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GdtUserInfoAuthorizationHelper", 2, "checkAuthorize user phone not authorize");
        }
        return false;
      }
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(tlq.b paramb);
  }
  
  public static class b
  {
    public final String SB;
    public final String city;
    public int errCode;
    public final String name;
    
    private b(String paramString1, String paramString2, String paramString3)
    {
      this(paramString1, paramString2, paramString3, 0);
    }
    
    private b(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this.name = paramString1;
      this.SB = paramString2;
      this.city = paramString3;
      this.errCode = paramInt;
    }
    
    private static b a()
    {
      return new b("", "", "", 1);
    }
    
    public String gW(String paramString)
    {
      if (TextUtils.equals(paramString, AuthorizationItem.a.key)) {
        return this.name;
      }
      if (TextUtils.equals(paramString, AuthorizationItem.b.key)) {
        return this.SB;
      }
      if (TextUtils.equals(paramString, AuthorizationItem.c.key)) {
        return this.city;
      }
      return "";
    }
    
    @NonNull
    public String toString()
    {
      return "UserInfoEntity : [name -> " + this.name + ", phone -> " + this.SB + ", city -> " + this.city + ", errCode -> " + this.errCode + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlq
 * JD-Core Version:    0.7.0.1
 */