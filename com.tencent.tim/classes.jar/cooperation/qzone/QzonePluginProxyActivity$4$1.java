package cooperation.qzone;

import acfp;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import arig;
import avfw;
import avfw.d;
import avro;
import avrp;
import awcz;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.qphone.base.util.QLog;

public class QzonePluginProxyActivity$4$1
  implements Runnable
{
  public QzonePluginProxyActivity$4$1(avro paramavro, String paramString, boolean paramBoolean1, boolean paramBoolean2, avfw.d paramd) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = this.this$0.val$activity;
    if ((this.this$0.val$activity instanceof BasePluginActivity))
    {
      localObject1 = ((BasePluginActivity)this.this$0.val$activity).getOutActivity();
      QLog.w("QzonePluginProxyActivity", 1, acfp.m(2131713281) + this.vy + ",context:" + this.this$0.val$activity);
      if ((localObject1 != null) && ((localObject1 instanceof PluginTab))) {
        localObject1 = ((PluginTab)localObject1).getOutActivity();
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || ((localObject1 instanceof BasePluginActivity)))
      {
        QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
        awcz.h(new IllegalArgumentException(acfp.m(2131713273) + this.vy + ",context:" + this.this$0.val$activity), acfp.m(2131713266));
        return;
      }
      Intent localIntent = null;
      Object localObject2 = localIntent;
      if (this.dow)
      {
        localObject2 = localIntent;
        if (!this.dox)
        {
          localObject2 = new arig((Context)localObject1, this.this$0.val$intent);
          ((arig)localObject2).setMessage(acfp.m(2131713272));
          ((arig)localObject2).setOnDismissListener(new avrp(this));
        }
      }
      localIntent = this.this$0.val$intent;
      if (localObject2 != null) {}
      for (;;)
      {
        localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        this.a.mDialog = ((Dialog)localObject2);
        avfw.a((Context)localObject1, this.a);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4.1
 * JD-Core Version:    0.7.0.1
 */