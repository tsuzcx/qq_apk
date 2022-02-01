package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class JefsClass$7
  implements Runnable
{
  JefsClass$7(JefsClass paramJefsClass, Intent paramIntent, JefsClass.CancelableRunnable paramCancelableRunnable, WeakReference paramWeakReference, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str;
    for (Object localObject2 = null;; localObject2 = str)
    {
      try
      {
        if ("application/vnd.android.package-archive".equalsIgnoreCase(this.val$intent.getType())) {
          localObject1 = this.val$intent.getData();
        }
        for (Object localObject1 = FileProvider7Helper.getRealPathFromContentURI(BaseApplicationImpl.context, (Uri)localObject1); localObject1 == null; localObject1 = Uri.parse(this.val$intent.getStringExtra("yyb_install_url")).getQueryParameter("filepath"))
        {
          QLog.w("TeleScreen|JefsClass", 1, "apk path is null");
          JefsClass.a(this.this$0, this.a);
          return;
        }
        if (new File((String)localObject1).exists())
        {
          localObject1 = BaseApplicationImpl.context.getPackageManager().getPackageArchiveInfo((String)localObject1, 0);
          if (localObject1 != null)
          {
            localObject1 = ((PackageInfo)localObject1).packageName;
            continue;
          }
        }
        else
        {
          localObject1 = (Context)this.hb.get();
          if ((localObject2 == null) || (localObject1 == null)) {
            break label188;
          }
          JefsClass.a(this.this$0, (Context)localObject1, this.val$src, this.bLU, (String)localObject2, null, this.a);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TeleScreen|JefsClass", 1, localThrowable, new Object[0]);
        JefsClass.a(this.this$0, this.a);
        return;
      }
      str = "";
      continue;
      label188:
      QLog.i("TeleScreen|JefsClass", 1, "could not resolve apk file's package");
      JefsClass.a(this.this$0, this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.7
 * JD-Core Version:    0.7.0.1
 */