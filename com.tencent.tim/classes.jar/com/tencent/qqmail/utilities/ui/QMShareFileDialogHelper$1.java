package com.tencent.qqmail.utilities.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import java.io.File;
import java.util.ArrayList;

class QMShareFileDialogHelper$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  QMShareFileDialogHelper$1(QMShareFileDialogHelper paramQMShareFileDialogHelper, ArrayList paramArrayList) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramString = (ResolveInfo)this.val$resInfo.get(paramInt);
    paramView = paramString.activityInfo.packageName;
    paramString = paramString.activityInfo.name;
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("share_from_mail", true);
    if (QMShareFileDialogHelper.access$000(this.this$0) == QMShareFileDialogHelper.SHARE_TYPE_IMG)
    {
      localIntent.setType("image/*");
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(QMShareFileDialogHelper.access$100(this.this$0))));
      if (QMShareFileDialogHelper.FROM_SHARE_MAIL_OR_NOTE_CONTENT == QMShareFileDialogHelper.access$200(this.this$0))
      {
        QMShareFileDialogHelper.access$300(this.this$0, paramView, paramString, localIntent);
        paramQMBottomDialog.dismiss();
      }
    }
    else
    {
      if (QMShareFileDialogHelper.access$000(this.this$0) != QMShareFileDialogHelper.SHARE_TYPE_NORMAL_ATT) {
        break label226;
      }
      localIntent.setType("*/*");
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(QMShareFileDialogHelper.access$100(this.this$0))));
    }
    for (;;)
    {
      QMShareFileDialogHelper.access$600(this.this$0, paramView, paramString);
      localIntent.setClassName(paramView, paramString);
      localIntent.setComponent(new ComponentName(paramView, paramString));
      QMShareFileDialogHelper.access$700(this.this$0).startActivity(localIntent);
      paramQMBottomDialog.dismiss();
      return;
      label226:
      if (paramView.equals("com.tencent.mm"))
      {
        QMShareFileDialogHelper.access$400(this.this$0, paramString);
        paramQMBottomDialog.dismiss();
        return;
      }
      localIntent.setType("text/plain");
      localIntent.putExtra("android.intent.extra.TEXT", QMShareFileDialogHelper.access$500(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper.1
 * JD-Core Version:    0.7.0.1
 */