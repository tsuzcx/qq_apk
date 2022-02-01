package com.tencent.mobileqq.gamecenter.message;

import ahta;
import ahtj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GameMsgManager$4
  implements Runnable
{
  public GameMsgManager$4(ahta paramahta, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 1;
    if (ahta.a(this.this$0) == null) {
      QLog.w(ahta.access$000(), 1, "app is null");
    }
    for (;;)
    {
      return;
      ahtj localahtj = (ahtj)ahta.a(this.this$0).getBusinessHandler(175);
      if (this.cig)
      {
        localahtj.eu(this.xc);
        return;
      }
      ArrayList localArrayList = ahta.a(this.this$0, this.xc);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {}
      while (i != 0)
      {
        localahtj.eu(localArrayList);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.4
 * JD-Core Version:    0.7.0.1
 */