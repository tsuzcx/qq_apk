import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aewm
  implements Manager
{
  private ClipboardManager b;
  private QQAppInterface mApp;
  private SharedPreferences sp;
  
  public aewm(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private ClipboardManager a()
  {
    if (this.b == null) {
      this.b = ((ClipboardManager)this.mApp.getApp().getApplicationContext().getSystemService("clipboard"));
    }
    return this.b;
  }
  
  private SharedPreferences getPref()
  {
    if (this.sp == null) {
      this.sp = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp());
    }
    return this.sp;
  }
  
  public String getPrompt()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      long l1 = getPref().getLong("KEY_LAST_COPY_TIME", 0L);
      Object localObject = a();
      alkw.a((ClipboardManager)localObject);
      localObject = ((ClipboardManager)localObject).getPrimaryClipDescription();
      if (localObject != null)
      {
        long l2 = ((ClipDescription)localObject).getTimestamp();
        long l3 = System.currentTimeMillis();
        if ((l2 != l1) && (l3 - l2 < 180000L))
        {
          getPref().edit().putLong("KEY_LAST_COPY_TIME", l2).apply();
          localObject = a();
          alkw.a((ClipboardManager)localObject);
          if (((ClipboardManager)localObject).hasPrimaryClip())
          {
            localObject = a();
            alkw.a((ClipboardManager)localObject);
            if (((ClipboardManager)localObject).getPrimaryClip() != null)
            {
              localObject = a();
              alkw.a((ClipboardManager)localObject);
              if (((ClipboardManager)localObject).getPrimaryClip().getItemCount() > 0)
              {
                localObject = a();
                alkw.a((ClipboardManager)localObject);
                localObject = ((ClipboardManager)localObject).getPrimaryClip().getItemAt(0);
                if (QLog.isColorLevel()) {
                  QLog.d("CopyPromptManager", 2, "origin copy data : " + localObject);
                }
                if (localObject != null)
                {
                  localObject = ((ClipData.Item)localObject).getText();
                  if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                    return String.valueOf(localObject);
                  }
                }
              }
            }
          }
        }
      }
    }
    return "";
  }
  
  public void onDestroy()
  {
    this.sp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewm
 * JD-Core Version:    0.7.0.1
 */