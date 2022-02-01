import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;

public class abxd
  implements Handler.Callback
{
  private final abxd.a jdField_a_of_type_Abxd$a;
  private abxd.b jdField_a_of_type_Abxd$b;
  private boolean ajb = true;
  private boolean mCancelled;
  private final Handler mHandler;
  private int mTimeOut;
  
  public abxd(abxd.a parama)
  {
    this.jdField_a_of_type_Abxd$a = parama;
    this.mHandler = new auru(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a(int paramInt, abxd.b paramb)
  {
    this.mTimeOut = paramInt;
    this.jdField_a_of_type_Abxd$b = paramb;
  }
  
  public void av(Bundle paramBundle)
  {
    this.mCancelled = false;
    do
    {
      while (!this.mCancelled) {
        switch (this.jdField_a_of_type_Abxd$a.m(paramBundle))
        {
        case 0: 
        default: 
          break;
        case -1: 
          if (this.jdField_a_of_type_Abxd$b != null)
          {
            paramBundle = this.mHandler.obtainMessage(3);
            this.mHandler.sendMessageDelayed(paramBundle, this.mTimeOut);
          }
          break;
        }
      }
      return;
    } while (!this.ajb);
    Message localMessage = this.mHandler.obtainMessage(2);
    localMessage.setData(paramBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void cFX()
  {
    this.ajb = false;
  }
  
  public void cancel()
  {
    this.mCancelled = true;
    this.jdField_a_of_type_Abxd$b = null;
    this.mHandler.removeMessages(2);
    this.mHandler.removeMessages(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!this.mCancelled) {
        av(paramMessage.getData());
      }
      return true;
      if (this.jdField_a_of_type_Abxd$b != null)
      {
        this.jdField_a_of_type_Abxd$b.cFV();
        this.jdField_a_of_type_Abxd$b = null;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract int m(Bundle paramBundle);
  }
  
  public static abstract interface b
  {
    public abstract void cFV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxd
 * JD-Core Version:    0.7.0.1
 */