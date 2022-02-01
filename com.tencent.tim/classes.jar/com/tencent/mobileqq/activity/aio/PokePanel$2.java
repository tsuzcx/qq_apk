package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import xks;

class PokePanel$2
  implements Runnable
{
  PokePanel$2(PokePanel paramPokePanel, String paramString, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel]start parsing config");
    }
    PokePanel.a(this.this$0, this.aTi);
    PokePanel.a(this.this$0, this.qg);
    ArrayList localArrayList = xks.a(PokePanel.a(this.this$0), this.this$0.c);
    this.qg.addAll(localArrayList);
    if (this.qg.size() > 0) {
      ThreadManager.getUIHandler().post(new PokePanel.2.1(this));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel] parsing config end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel.2
 * JD-Core Version:    0.7.0.1
 */