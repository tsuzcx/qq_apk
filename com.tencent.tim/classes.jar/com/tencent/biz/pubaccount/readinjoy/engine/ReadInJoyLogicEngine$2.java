package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.qphone.base.util.QLog;
import lbz;
import lcc;

public class ReadInJoyLogicEngine$2
  implements Runnable
{
  public ReadInJoyLogicEngine$2(lbz paramlbz, int paramInt) {}
  
  public void run()
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticle, channelID = ", Integer.valueOf(this.aHH) });
    lcc.a().b(false, this.aHH, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.2
 * JD-Core Version:    0.7.0.1
 */