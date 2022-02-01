package com.tencent.mobileqq.apollo;

import abhh;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class ApolloManager$16
  implements Runnable
{
  public ApolloManager$16(abhh paramabhh, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (abhh.a(this.this$0))
    {
      if ((abhh.a(this.this$0) != null) && (this.a != null) && (abhh.a(this.this$0).contains(this.a))) {
        abhh.a(this.this$0).remove(this.a);
      }
      if (abhh.a(this.this$0) != null)
      {
        abhh.a(this.this$0).remove(this.a);
        abhh.a(this.this$0).close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.16
 * JD-Core Version:    0.7.0.1
 */