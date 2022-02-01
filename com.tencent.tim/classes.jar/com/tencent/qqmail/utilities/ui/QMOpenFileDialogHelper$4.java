package com.tencent.qqmail.utilities.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;

class QMOpenFileDialogHelper$4
  implements AdapterView.OnItemClickListener
{
  QMOpenFileDialogHelper$4(QMOpenFileDialogHelper paramQMOpenFileDialogHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView.setSelected(true);
    if ((QMOpenFileDialogHelper.access$100(this.this$0)) && (paramInt == 0))
    {
      QMOpenFileDialogHelper.access$202(this.this$0, null);
      QMOpenFileDialogHelper.access$302(this.this$0, null);
      QMOpenFileDialogHelper.access$400(this.this$0).setEnabled(false);
      QMOpenFileDialogHelper.access$500(this.this$0).setEnabled(false);
      if (QMOpenFileDialogHelper.access$600(this.this$0) != null) {
        QMOpenFileDialogHelper.access$600(this.this$0).findViewById(2131368857).setVisibility(8);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      QMOpenFileDialogHelper.access$202(this.this$0, new Intent());
      QMOpenFileDialogHelper.access$302(this.this$0, (ResolveInfo)paramAdapterView.getItemAtPosition(paramInt));
      String str = QMOpenFileDialogHelper.access$300(this.this$0).activityInfo.packageName;
      try
      {
        Object localObject1 = QMApplicationContext.sharedInstance().getPackageManager().getPackageInfo(str, 16384);
        StringBuilder localStringBuilder = new StringBuilder().append("file type:").append(QMOpenFileDialogHelper.access$700(this.this$0)).append(" open by: ").append(str).append(" version: ");
        if (localObject1 == null)
        {
          i = 0;
          QMLog.log(4, "QMOpenFileDialog", i);
          localObject1 = QMOpenFileDialogHelper.access$300(this.this$0).activityInfo.name;
          if ((QMOpenFileDialogHelper.access$800(this.this$0) == null) || (!QMOpenFileDialogHelper.access$800(this.this$0).exists())) {
            break label471;
          }
          QMOpenFileDialogHelper.access$200(this.this$0).addFlags(268435456);
          QMOpenFileDialogHelper.access$200(this.this$0).setAction("android.intent.action.VIEW");
          QMOpenFileDialogHelper.access$200(this.this$0).addFlags(1);
          QMOpenFileDialogHelper.access$200(this.this$0).setDataAndType(Uri.fromFile(QMOpenFileDialogHelper.access$800(this.this$0)), QMOpenFileDialogHelper.access$700(this.this$0));
          QMOpenFileDialogHelper.access$200(this.this$0).setClassName(str, (String)localObject1);
          QMOpenFileDialogHelper.access$200(this.this$0).setComponent(new ComponentName(str, (String)localObject1));
          QMOpenFileDialogHelper.access$200(this.this$0).setPackage(str);
          QMOpenFileDialogHelper.access$400(this.this$0).setEnabled(true);
          QMOpenFileDialogHelper.access$500(this.this$0).setEnabled(true);
          if (QMOpenFileDialogHelper.access$600(this.this$0) != null) {
            QMOpenFileDialogHelper.access$600(this.this$0).findViewById(2131368857).setVisibility(8);
          }
          paramView.findViewById(2131368857).setVisibility(0);
          QMOpenFileDialogHelper.access$602(this.this$0, paramView);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
          Object localObject2 = null;
          continue;
          int i = localObject2.versionCode;
          continue;
          label471:
          QMOpenFileDialogHelper.access$200(this.this$0).setAction("android.intent.action.VIEW");
          QMOpenFileDialogHelper.access$200(this.this$0).setData(Uri.parse(QMOpenFileDialogHelper.access$900(this.this$0)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMOpenFileDialogHelper.4
 * JD-Core Version:    0.7.0.1
 */