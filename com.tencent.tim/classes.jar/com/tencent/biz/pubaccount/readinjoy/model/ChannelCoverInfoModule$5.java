package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lcc;
import lhn;

public class ChannelCoverInfoModule$5
  implements Runnable
{
  public ChannelCoverInfoModule$5(lhn paramlhn, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (this.val$success) {
      i = 1;
    }
    QLog.d("ChannelCoverInfoModule", 2, new Object[] { "notifyIndependentTabUIToRefresh, success = ", Integer.valueOf(i) });
    lcc.a().d(this.val$success, this.val$list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.5
 * JD-Core Version:    0.7.0.1
 */