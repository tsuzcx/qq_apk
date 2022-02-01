import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class igs
{
  private static Boolean o;
  private String LT;
  private igp jdField_a_of_type_Igp;
  private igs.a jdField_a_of_type_Igs$a;
  private WeakReference<Activity> aG;
  private boolean lm;
  private VideoAppInterface mApp;
  
  public igs(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_Igs$a = new igs.a(this, null);
  }
  
  private void alp()
  {
    this.mApp.sS();
    register();
  }
  
  private void hC(boolean paramBoolean)
  {
    o = Boolean.valueOf(paramBoolean);
  }
  
  private void register()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.q2v.avReceivePushMsg");
    this.mApp.getApplication().registerReceiver(this.jdField_a_of_type_Igs$a, localIntentFilter);
    this.lm = true;
    if (QLog.isColorLevel()) {
      QLog.i("RealNameVideoProcessHelper", 2, "register");
    }
  }
  
  private boolean sj()
  {
    o = Boolean.valueOf(this.mApp.sR());
    return o.booleanValue();
  }
  
  private void unRegister()
  {
    try
    {
      QLog.d("RealNameVideoProcessHelper", 1, "unRegister start ");
      if (this.lm)
      {
        this.mApp.getApplication().unregisterReceiver(this.jdField_a_of_type_Igs$a);
        this.lm = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RealNameVideoProcessHelper", 2, "unRegister");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("RealNameVideoProcessHelper", 1, new Object[] { "unregisterReceiver error : ", localException.getMessage() });
      }
    }
  }
  
  public void a(igp paramigp)
  {
    this.jdField_a_of_type_Igp = paramigp;
  }
  
  public void alq()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RealNameVideoProcessHelper", 2, "showRealNameDialog");
    }
    Object localObject1 = this.aG;
    if (this.aG != null)
    {
      localObject1 = (Activity)((WeakReference)localObject1).get();
      if (localObject1 != null) {
        break label44;
      }
    }
    label44:
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
      } while (!(localObject1 instanceof AVActivity));
      localObject2 = (AVActivity)localObject1;
    } while ((((AVActivity)localObject2).isFinishing()) || (((AVActivity)localObject2).isDestroyed()));
    String str = ((Activity)localObject1).getString(2131690697);
    Object localObject2 = ((Activity)localObject1).getString(2131690696);
    if (this.LT != null) {
      localObject2 = this.LT;
    }
    localObject1 = aqha.a((Context)localObject1, 230, str, (CharSequence)localObject2, ((Activity)localObject1).getString(2131701570), ((Activity)localObject1).getString(2131701572), new igt(this, (Activity)localObject1), new igu(this));
    ((aqju)localObject1).setCancelable(false);
    ((aqju)localObject1).show();
  }
  
  public void av(Activity paramActivity)
  {
    this.aG = new WeakReference(paramActivity);
  }
  
  public void b(igp paramigp)
  {
    if (sj())
    {
      paramigp.hz(true);
      return;
    }
    a(paramigp);
    alq();
  }
  
  public void hO(String paramString)
  {
    this.LT = paramString;
  }
  
  public void o(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RealNameVideoProcessHelper", 2, "onActivityResult");
    }
    if (this.jdField_a_of_type_Igp != null) {
      this.jdField_a_of_type_Igp.hz(o.booleanValue());
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    private final WeakReference<igs> mRef;
    
    private a(igs paramigs)
    {
      this.mRef = new WeakReference(paramigs);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {}
      boolean bool;
      do
      {
        do
        {
          return;
          paramContext = paramIntent.getAction();
          if (QLog.isColorLevel()) {
            QLog.i("RealNameVideoProcessHelper", 2, "onReceive action[" + paramContext + "]");
          }
        } while (!"tencent.video.q2v.avReceivePushMsg".equals(paramContext));
        bool = paramIntent.getBooleanExtra("real_name_result", false);
        paramContext = (igs)this.mRef.get();
      } while (paramContext == null);
      igs.a(paramContext, bool);
      igs.b(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igs
 * JD-Core Version:    0.7.0.1
 */