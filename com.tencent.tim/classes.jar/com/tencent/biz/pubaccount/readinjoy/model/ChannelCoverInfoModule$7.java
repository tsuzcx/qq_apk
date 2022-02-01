package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import lcc;
import lhn;

public class ChannelCoverInfoModule$7
  implements Runnable
{
  public ChannelCoverInfoModule$7(lhn paramlhn, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    if (this.aki) {
      i = 1;
    }
    QLog.d("ChannelCoverInfoModule", 2, new Object[] { "notifyHasMoreChannelRedPoint, success = ", Integer.valueOf(i) });
    lcc.a().lT(this.aki);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.7
 * JD-Core Version:    0.7.0.1
 */