import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.qphone.base.util.QLog;

public class ahal
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, ahal.a parama)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
      }
      return;
    }
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), parama);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, ahal.a parama)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
      }
      return;
    }
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), parama);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, ahal.a parama)
  {
    aham localaham = new aham(parama);
    parama = new ahan(parama);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localaham, parama));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        aqha.a(paramContext, 230, paramString, (String)paramCharSequence, 2131693507, 2131693512, localaham, parama).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    aqha.a(paramContext, 230, paramString, paramCharSequence, 2131693507, 2131693512, localaham, parama).show();
  }
  
  public static abstract interface a
  {
    public abstract void aD();
    
    public abstract void aE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ahal
 * JD-Core Version:    0.7.0.1
 */