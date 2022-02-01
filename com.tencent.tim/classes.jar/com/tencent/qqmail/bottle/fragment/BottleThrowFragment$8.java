package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleThrowController;
import com.tencent.qqmail.bottle.controller.BottleThrowController.BottleLocationWatcher;
import com.tencent.qqmail.bottle.controller.BottleThrowController.LocationError;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class BottleThrowFragment$8
  implements BottleThrowController.BottleLocationWatcher
{
  BottleThrowFragment$8(BottleThrowFragment paramBottleThrowFragment) {}
  
  private void logStatus(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      DataCollector.logStatus("AppStat_Bottle_Send_Location", str);
      return;
    }
  }
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleThrowFragment", "mLocationWatcher onErrorInMainThread error:" + paramQMNetworkError);
    logStatus(false);
    if (((paramQMNetworkError instanceof BottleThrowController.LocationError)) && (((BottleThrowController.LocationError)paramQMNetworkError).code == -20002))
    {
      BottleThrowFragment.access$1300(this.this$0);
      if (this.this$0.getActivity() != null) {
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131690984)).setMessage(this.this$0.getString(2131690991)).addAction(2131691246, new BottleThrowFragment.8.2(this))).addAction(2131696547, new BottleThrowFragment.8.1(this))).create().show();
      }
    }
    while (!BottleThrowFragment.access$100(this.this$0).isOpenedLBS()) {
      return;
    }
    BottleThrowFragment.access$200(this.this$0, null);
  }
  
  public void onSuccessInMainThread(String paramString1, String paramString2)
  {
    QMLog.log(4, "BottleThrowFragment", "mLocationWatcher onSuccessInMainThread geo:" + paramString1 + ",cityName:" + paramString2);
    if (BottleThrowFragment.access$100(this.this$0).isOpenedLBS())
    {
      BottleThrowFragment.access$1200(this.this$0, paramString1, paramString2);
      BottleThrowFragment.access$200(this.this$0, paramString2);
      logStatus(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.8
 * JD-Core Version:    0.7.0.1
 */