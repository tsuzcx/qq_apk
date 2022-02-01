package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import wwn;
import wwp;

public class QWalletAIOLifeCycleHelper$2$1
  implements Runnable
{
  public QWalletAIOLifeCycleHelper$2$1(wwp paramwwp) {}
  
  public void run()
  {
    ((XPanelContainer)wwn.a(this.a.a).mAIORootView.findViewById(2131377546)).abp(1);
    wwn.a(this.a.a).a.setSelection(wwn.a(this.a.a).a.getText().toString().length());
    wwn.a(this.a.a).a.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2.1
 * JD-Core Version:    0.7.0.1
 */