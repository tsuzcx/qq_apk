import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

public class klg
{
  private klg.a jdField_a_of_type_Klg$a;
  private klg.b jdField_a_of_type_Klg$b;
  private AtomicBoolean am = new AtomicBoolean(false);
  private Context mContext;
  private IntentFilter mFilter;
  
  public klg(Context paramContext)
  {
    this.mContext = paramContext;
    this.mFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
  }
  
  public void a(klg.b paramb)
  {
    this.jdField_a_of_type_Klg$b = paramb;
    this.jdField_a_of_type_Klg$a = new klg.a();
  }
  
  public void startWatch()
  {
    if ((this.jdField_a_of_type_Klg$a != null) && (this.am.compareAndSet(false, true))) {
      this.mContext.registerReceiver(this.jdField_a_of_type_Klg$a, this.mFilter);
    }
  }
  
  public void stopWatch()
  {
    if ((this.jdField_a_of_type_Klg$a != null) && (this.am.compareAndSet(true, false))) {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_Klg$a);
    }
  }
  
  public boolean zK()
  {
    return this.am.get();
  }
  
  class a
    extends BroadcastReceiver
  {
    final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
    final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    final String SYSTEM_DIALOG_REASON_KEY = "reason";
    final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if ((paramContext != null) && (klg.a(klg.this) != null))
        {
          if (!paramContext.equals("homekey")) {
            break label55;
          }
          klg.a(klg.this).onHomePressed();
        }
      }
      label55:
      while (!paramContext.equals("recentapps")) {
        return;
      }
      klg.a(klg.this).aEd();
    }
  }
  
  public static abstract interface b
  {
    public abstract void aEd();
    
    public abstract void onHomePressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     klg
 * JD-Core Version:    0.7.0.1
 */