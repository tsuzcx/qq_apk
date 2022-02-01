package com.tencent.biz.subscribe.other.story;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class FakeProgressRunner
{
  private AtomicBoolean bf;
  
  static class FakeProgressTask
    implements Runnable
  {
    private long CP;
    private final FakeProgressRunner.a jdField_a_of_type_ComTencentBizSubscribeOtherStoryFakeProgressRunner$a;
    private final FakeProgressRunner jdField_a_of_type_ComTencentBizSubscribeOtherStoryFakeProgressRunner;
    private volatile boolean isRunning;
    private final long tN;
    
    public void run()
    {
      for (;;)
      {
        if ((!this.isRunning) || (this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryFakeProgressRunner == null)) {}
        while (!FakeProgressRunner.a(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryFakeProgressRunner).get())
        {
          this.isRunning = false;
          return;
        }
        try
        {
          Thread.sleep(this.tN);
          long l = System.currentTimeMillis();
          if (l - this.CP <= this.tN) {
            continue;
          }
          this.CP = l;
          ThreadManager.getUIHandler().post(new FakeProgressRunner.FakeProgressTask.1(this));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.FakeProgressRunner
 * JD-Core Version:    0.7.0.1
 */