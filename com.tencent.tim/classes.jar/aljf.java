import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;
import java.util.List;

public class aljf
{
  private static volatile aljf a;
  private Object lock = new Object();
  
  public static aljf a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aljf();
      }
      return a;
    }
    finally {}
  }
  
  public void a(EntityManager paramEntityManager, long paramLong, aljf.a parama)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramEntityManager, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, parama), 8, null, false);
  }
  
  public void a(EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate)
  {
    ThreadManager.post(new PushDialogDbUtil.2(this, paramEntityManager, paramPushDialogTemplate), 8, null, false);
  }
  
  public void b(EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate)
  {
    if ((paramEntityManager == null) || (paramPushDialogTemplate == null)) {
      return;
    }
    ThreadManager.post(new PushDialogDbUtil.3(this, paramEntityManager, paramPushDialogTemplate), 2, null, false);
  }
  
  public static abstract interface a
  {
    public abstract void lR(List<PushDialogTemplate> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljf
 * JD-Core Version:    0.7.0.1
 */