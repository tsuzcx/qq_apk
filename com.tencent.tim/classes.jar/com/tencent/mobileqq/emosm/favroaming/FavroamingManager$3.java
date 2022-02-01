package com.tencent.mobileqq.emosm.favroaming;

import acef;
import afhu;
import afhv;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class FavroamingManager$3
  implements Runnable
{
  public FavroamingManager$3(afhv paramafhv, acef paramacef) {}
  
  public void run()
  {
    List localList = ((afhu)afhv.h(this.this$0).getManager(149)).ar("needDel");
    if (localList.size() > 0) {
      this.b.ai(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.this$0.cYZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.3
 * JD-Core Version:    0.7.0.1
 */