package com.tencent.qqmail.utilities.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import java.util.ArrayList;

class QMShareLinkDialogHelper$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  QMShareLinkDialogHelper$1(QMShareLinkDialogHelper paramQMShareLinkDialogHelper, ArrayList paramArrayList) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramString = (ResolveInfo)this.val$resInfo.get(paramInt);
    paramView = paramString.activityInfo.packageName;
    paramString = paramString.activityInfo.name;
    if ((paramView.equals("com.tencent.mm")) && (QMShareLinkDialogHelper.access$000(this.this$0, paramString)))
    {
      paramQMBottomDialog.dismiss();
      return;
    }
    QMShareLinkDialogHelper.access$100(this.this$0, paramView, paramString);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", "来自QQ邮箱的分享");
    localIntent.putExtra("android.intent.extra.TEXT", QMShareLinkDialogHelper.access$200(this.this$0));
    localIntent.setClassName(paramView, paramString);
    localIntent.setComponent(new ComponentName(paramView, paramString));
    QMShareLinkDialogHelper.access$300(this.this$0).startActivity(localIntent);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMShareLinkDialogHelper.1
 * JD-Core Version:    0.7.0.1
 */