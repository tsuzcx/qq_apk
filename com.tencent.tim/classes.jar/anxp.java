import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class anxp
  extends acmf
{
  anxp(anxo paramanxo) {}
  
  protected void a(boolean paramBoolean, anxs paramanxs)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (paramanxs == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!anxo.a(this.this$0).isReleased) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = paramanxs.aQf;
      break;
      label73:
      if ((!anxo.a(this.this$0)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(anxo.a(this.this$0), 100L);
      }
      if (paramanxs != null)
      {
        if (paramanxs.azk()) {
          anxk.a(anxo.a(this.this$0), paramanxs.dM(), 2);
        }
        if (paramanxs.azl())
        {
          ??? = paramanxs.dN();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              anxk.aL(anxo.a(this.this$0), (String)localObject2);
            }
          }
        }
        paramanxs.dTL();
      }
      synchronized (anxo.access$700())
      {
        anxo.c(this.this$0, false);
        anxo.d(this.this$0, true);
        if ((paramanxs == null) || (!paramanxs.cKA)) {
          continue;
        }
        anxk.d(anxo.a(this.this$0), paramanxs.aQf, false);
        ??? = (aeoa)aeif.a().o(607);
        if ((??? == null) || (((aeoa)???).bVj)) {
          continue;
        }
        anxq.a(anxo.a(this.this$0), paramanxs.aQf);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, anxs arg2)
  {
    synchronized ()
    {
      anxo.a(this.this$0, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, anxs arg2)
  {
    synchronized ()
    {
      anxo.b(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxp
 * JD-Core Version:    0.7.0.1
 */