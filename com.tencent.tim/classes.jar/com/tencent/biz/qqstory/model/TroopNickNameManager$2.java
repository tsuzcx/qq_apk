package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.TroopManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import pmi;
import ptc;
import ptc.a;

public class TroopNickNameManager$2
  implements Runnable
{
  public TroopNickNameManager$2(ptc paramptc, String paramString, QQUserUIItem paramQQUserUIItem, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.this$0.a.c(this.Uf, this.a.qq) != null)
    {
      locala = new ptc.a();
      localArrayList = new ArrayList();
      localArrayList.add(this.a.qq);
      locala.uinList = localArrayList;
      locala.troopUin = this.Uf;
      pmi.a().dispatch(locala);
    }
    while (this.aBy)
    {
      ptc.a locala;
      ArrayList localArrayList;
      return;
    }
    this.this$0.a(this.a, this.Uf, this.aBz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.2
 * JD-Core Version:    0.7.0.1
 */