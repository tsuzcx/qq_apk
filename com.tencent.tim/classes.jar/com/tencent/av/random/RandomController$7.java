package com.tencent.av.random;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

class RandomController$7
  implements Runnable
{
  RandomController$7(RandomController paramRandomController) {}
  
  public void run()
  {
    if (!RandomController.a(this.this$0).vk())
    {
      this.this$0.ju(RandomController.a(this.this$0).getAccount());
      RandomController.a(this.this$0).getHandler().postDelayed(RandomController.b(this.this$0), 2000L);
    }
    do
    {
      return;
      if (RandomController.a(this.this$0))
      {
        RandomController.b(this.this$0, false);
        RandomController.a(this.this$0).set(0);
        RandomController.a(this.this$0).a(RandomController.b(this.this$0), RandomController.c(this.this$0), 1, new String[0]);
        return;
      }
    } while (!RandomController.b(this.this$0));
    RandomController.c(this.this$0, false);
    RandomController.a(this.this$0).s(this.this$0.Ur, RandomController.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController.7
 * JD-Core Version:    0.7.0.1
 */