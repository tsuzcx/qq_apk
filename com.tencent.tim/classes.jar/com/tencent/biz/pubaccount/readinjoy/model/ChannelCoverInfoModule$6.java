package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lcc;
import lhn;

public class ChannelCoverInfoModule$6
  implements Runnable
{
  public ChannelCoverInfoModule$6(lhn paramlhn, int paramInt, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "notifyUIToRefresh channelId=" + this.aMH + " ;size = " + this.hT.size());
    }
    if (this.aMH == 0) {
      lcc.a().m(true, this.hT);
    }
    for (;;)
    {
      lcc.a().a(this.aMH, true, this.hT);
      return;
      if (this.aMH == 56) {
        lcc.a().g(true, this.hT);
      } else if (this.aMH == 41402) {
        lcc.a().n(true, this.hT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.6
 * JD-Core Version:    0.7.0.1
 */