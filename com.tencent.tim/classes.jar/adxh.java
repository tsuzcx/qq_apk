import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.Foreground;

public class adxh
  implements adwq, adwv
{
  private WeakReference<Context> gB;
  @Nullable
  private Object listener;
  
  adxh(Context paramContext, @Nullable adwq paramadwq)
  {
    this.gB = new WeakReference(paramContext);
    this.listener = paramadwq;
  }
  
  adxh(Context paramContext, @Nullable adwv paramadwv)
  {
    this.gB = new WeakReference(paramContext);
    this.listener = paramadwv;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    if ((this.listener instanceof adwq)) {
      ((adwq)this.listener).a(paramBoolean1, paramBoolean2, paramInt, paramString1, paramString2);
    }
  }
  
  public boolean afK()
  {
    if ((this.listener instanceof adwq)) {
      return ((adwq)this.listener).afK();
    }
    return false;
  }
  
  void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    QLog.d("TeleScreenListenerWrapper", 1, "download | pass: " + paramBoolean2 + ", errCode: " + paramInt + ", errMsg: " + paramString1);
    a(paramBoolean1, paramBoolean2, paramInt, paramString1, paramString2);
    if (((this.listener instanceof adwq)) && (!((adwq)this.listener).afK())) {}
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.gB.get();
    } while ((localContext == null) || (!paramBoolean1) || (paramBoolean2) || (TextUtils.isEmpty(paramString2)));
    Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString2);
    if ((localContext instanceof Activity)) {}
    for (paramString1 = (Activity)localContext; paramString1 == null; paramString1 = Foreground.getTopActivity())
    {
      localIntent.addFlags(268435456);
      localContext.startActivity(localIntent);
      return;
    }
    paramString1.startActivity(localIntent);
  }
  
  public void c(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.listener instanceof adwv)) {
      ((adwv)this.listener).c(paramBoolean, paramInt1, paramInt2, paramString);
    }
  }
  
  void d(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("TeleScreenListenerWrapper", 1, "jump | jump: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
    c(paramBoolean, paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxh
 * JD-Core Version:    0.7.0.1
 */