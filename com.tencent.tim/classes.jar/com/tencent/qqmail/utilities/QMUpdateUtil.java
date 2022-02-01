package com.tencent.qqmail.utilities;

import android.content.Context;
import android.widget.Button;
import com.tencent.qqmail.activity.watcher.AppStatusWatcher;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Iterator;
import java.util.List;
import moai.core.watcher.Watchers;

public class QMUpdateUtil
{
  private static final String TAG = QMUpdateUtil.class.getSimpleName();
  private static boolean hasGoDownload = false;
  public static boolean isTipsShowing = false;
  private Context context;
  private QMUIDialog.MessageDialogBuilder mBuilder;
  private int updateType;
  private String updateUrl;
  private AppStatusWatcher watcher = new QMUpdateUtil.1(this);
  
  private boolean isForceUpdate(int paramInt)
  {
    return paramInt == 2;
  }
  
  private void setPositiveBtnEnable(QMUIDialog.MessageDialogBuilder paramMessageDialogBuilder, boolean paramBoolean)
  {
    if (paramMessageDialogBuilder == null) {
      return;
    }
    Iterator localIterator = paramMessageDialogBuilder.getPositiveAction().iterator();
    label15:
    QMUIDialogAction localQMUIDialogAction;
    Button localButton;
    if (localIterator.hasNext())
    {
      localQMUIDialogAction = (QMUIDialogAction)localIterator.next();
      localButton = localQMUIDialogAction.getButton();
      if (!paramBoolean) {
        break label74;
      }
    }
    label74:
    for (paramMessageDialogBuilder = this.context.getString(2131694371);; paramMessageDialogBuilder = this.context.getString(2131692973))
    {
      localButton.setText(paramMessageDialogBuilder);
      localQMUIDialogAction.getButton().setEnabled(paramBoolean);
      break label15;
      break;
    }
  }
  
  public void update(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QMLog.log(4, TAG, "QMUpdateUtil.update. isshowing:" + isTipsShowing);
    if (isTipsShowing) {}
    do
    {
      return;
      if (hasGoDownload)
      {
        QMLog.log(4, TAG, "QMUpdateUtil.update. hasgodownload.return");
        return;
      }
      this.context = paramContext;
      this.updateUrl = paramString3;
      this.updateType = paramInt;
      isTipsShowing = true;
      this.mBuilder = new QMUIDialog.MessageDialogBuilder(paramContext);
      ((QMUIDialog.MessageDialogBuilder)this.mBuilder.setTitle(paramString2)).setMessage(paramString1);
      if (isForceUpdate(paramInt)) {
        this.mBuilder.addAction(2131691246, new QMUpdateUtil.2(this, paramInt, paramContext, paramString3, paramString4));
      }
      this.mBuilder.addAction(0, 2131720008, 0, new QMUpdateUtil.3(this, paramContext, paramString3));
      paramString1 = this.mBuilder.create();
      paramString1.setOnKeyListener(new QMUpdateUtil.4(this, paramInt, paramContext));
      paramString1.setOnDismissListener(new QMUpdateUtil.5(this));
      paramString1.setCanceledOnTouchOutside(false);
    } while (paramString1.isShowing());
    Watchers.bind(this.watcher, true);
    paramString1.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMUpdateUtil
 * JD-Core Version:    0.7.0.1
 */