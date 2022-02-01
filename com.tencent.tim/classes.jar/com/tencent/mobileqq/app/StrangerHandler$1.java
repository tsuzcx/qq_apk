package com.tencent.mobileqq.app;

import acmb;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class StrangerHandler$1
  implements Runnable
{
  public StrangerHandler$1(acmb paramacmb) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.a().createEntityManager();
    List localList = ((EntityManager)localObject).query(Stranger.class);
    ((EntityManager)localObject).close();
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    this.this$0.notifyUI(3, true, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerHandler.1
 * JD-Core Version:    0.7.0.1
 */