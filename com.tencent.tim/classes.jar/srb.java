import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class srb
{
  protected sra a;
  private srb.b a;
  private int aDC = -1;
  
  public srb()
  {
    this.jdField_a_of_type_Srb$b = new srb.b(this, Looper.getMainLooper());
  }
  
  public void a(sra paramsra)
  {
    this.jdField_a_of_type_Sra = paramsra;
  }
  
  protected void bAa()
  {
    setStatus(5);
    if (this.jdField_a_of_type_Sra != null) {}
  }
  
  protected void bzY()
  {
    setStatus(3);
    if (this.jdField_a_of_type_Sra != null) {}
  }
  
  protected void bzZ()
  {
    setStatus(4);
    if (this.jdField_a_of_type_Sra != null) {}
  }
  
  public void detachView()
  {
    this.jdField_a_of_type_Srb$b.removeCallbacks(null);
    this.jdField_a_of_type_Sra = null;
  }
  
  protected void fu(long paramLong)
  {
    if (this.jdField_a_of_type_Sra != null) {
      this.jdField_a_of_type_Sra.ft(paramLong);
    }
  }
  
  protected void fv(long paramLong)
  {
    setStatus(3);
    if (this.jdField_a_of_type_Sra != null) {
      this.jdField_a_of_type_Sra.ft(paramLong);
    }
  }
  
  public void play()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Srb$b);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void setStatus(int paramInt)
  {
    this.aDC = paramInt;
  }
  
  public void stop()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Srb$b);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  public void update(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Srb$b);
    localMessage.what = 7;
    localMessage.obj = new srb.a(paramLong);
    localMessage.sendToTarget();
  }
  
  static class a
  {
    public long Dl;
    
    public a(long paramLong)
    {
      this.Dl = paramLong;
    }
  }
  
  static class b
    extends Handler
  {
    private WeakReference<srb> dr;
    
    public b(srb paramsrb, Looper paramLooper)
    {
      super();
      this.dr = new WeakReference(paramsrb);
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject2 = null;
      if (this.dr.get() != null) {}
      for (srb localsrb = (srb)this.dr.get();; localsrb = null)
      {
        Object localObject1 = localObject2;
        if (paramMessage.obj != null)
        {
          localObject1 = localObject2;
          if ((paramMessage.obj instanceof srb.a)) {
            localObject1 = (srb.a)paramMessage.obj;
          }
        }
        switch (paramMessage.what)
        {
        }
        for (;;)
        {
          super.handleMessage(paramMessage);
          return;
          if ((localsrb != null) && (localObject1 != null))
          {
            ((srb)this.dr.get()).bzY();
            continue;
            if ((localsrb != null) && (localObject1 != null))
            {
              ((srb)this.dr.get()).bzZ();
              continue;
              if ((localsrb != null) && (localObject1 != null))
              {
                ((srb)this.dr.get()).fv(((srb.a)localObject1).Dl);
                continue;
                if ((localsrb != null) && (localObject1 != null))
                {
                  ((srb)this.dr.get()).bAa();
                  continue;
                  if ((localsrb != null) && (localObject1 != null)) {
                    ((srb)this.dr.get()).fu(((srb.a)localObject1).Dl);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srb
 * JD-Core Version:    0.7.0.1
 */