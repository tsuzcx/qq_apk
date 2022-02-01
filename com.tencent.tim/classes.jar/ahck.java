import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ahck
  implements ahcj.b
{
  ahck(ahcj paramahcj) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(ahcj.TAG, 1, "[UniformDL][" + this.this$0.Zd + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", ahcj.a(this.this$0));
    paramBundle.putString("_CB_URL", ahcj.a(this.this$0));
    paramBundle.putBundle("_CB_USERDATA", ahcj.a(this.this$0));
    Iterator localIterator = ahcj.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ahcj.b localb = (ahcj.b)localIterator.next();
      if (localb != null) {
        localb.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(ahcj.TAG, 1, "[UniformDL][" + this.this$0.Zd + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((ahcj.b(this.this$0) < 1) && (1 == ahcj.a(this.this$0)))
    {
      QLog.i(ahcj.TAG, 1, "[UniformDL][" + this.this$0.Zd + "]. onDownloadFailed. errorRetry");
      ahcj.c(this.this$0);
      ahcj.a(this.this$0, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", ahcj.a(this.this$0));
      }
      Iterator localIterator = ahcj.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ahcj.b localb = (ahcj.b)localIterator.next();
        if (localb != null) {
          localb.b(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void p(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.this$0.amO();
    QLog.i(ahcj.TAG, 1, "[UniformDL][" + this.this$0.Zd + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.this$0.Ki(true);
      Object localObject = ahcj.a(this.this$0);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", ahcj.a(this.this$0));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ahcj.b localb = (ahcj.b)((Iterator)localObject).next();
        if (localb != null) {
          localb.p(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void q(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", ahcj.a(this.this$0));
    }
    Iterator localIterator = ahcj.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ahcj.b localb = (ahcj.b)localIterator.next();
      if (localb != null) {
        localb.q(paramInt, paramBundle);
      }
    }
  }
  
  public void r(int paramInt, Bundle paramBundle)
  {
    QLog.i(ahcj.TAG, 1, "[UniformDL][" + this.this$0.Zd + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", ahcj.a(this.this$0));
    }
    Iterator localIterator = ahcj.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ahcj.b localb = (ahcj.b)localIterator.next();
      if (localb != null) {
        localb.r(paramInt, paramBundle);
      }
    }
  }
  
  public void s(int paramInt, Bundle paramBundle)
  {
    QLog.i(ahcj.TAG, 1, "[UniformDL][" + this.this$0.Zd + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", ahcj.a(this.this$0));
    }
    Iterator localIterator = ahcj.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ahcj.b localb = (ahcj.b)localIterator.next();
      if (localb != null) {
        localb.s(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahck
 * JD-Core Version:    0.7.0.1
 */