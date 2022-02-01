import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import com.tencent.av.service.QQServiceForAV;

public class asey
  implements jkf.a
{
  private static asey jdField_a_of_type_Asey;
  private BroadcastReceiver A;
  private asey.a jdField_a_of_type_Asey$a;
  private iua jdField_a_of_type_Iua;
  private jkf jdField_a_of_type_Jkf;
  private Context mContext;
  private boolean mInited;
  private ServiceConnection mServiceConnection;
  
  public static asey a()
  {
    if (jdField_a_of_type_Asey == null) {}
    try
    {
      if (jdField_a_of_type_Asey == null) {
        jdField_a_of_type_Asey = new asey();
      }
      return jdField_a_of_type_Asey;
    }
    finally {}
  }
  
  private void emY()
  {
    if (this.A == null) {
      this.A = new asez(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    this.mContext.registerReceiver(this.A, localIntentFilter);
  }
  
  private void emZ()
  {
    if (this.mServiceConnection == null) {
      this.mServiceConnection = new asfa(this);
    }
    Intent localIntent = new Intent(this.mContext, QQServiceForAV.class);
    this.mContext.bindService(localIntent, this.mServiceConnection, 1);
  }
  
  public void a(asey.a parama)
  {
    this.jdField_a_of_type_Asey$a = parama;
  }
  
  public boolean bF()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Iua != null) {
        bool = this.jdField_a_of_type_Iua.bF();
      }
      return bool;
    }
    catch (Exception localException)
    {
      asev.e("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public void fT(Context paramContext)
  {
    if (!this.mInited)
    {
      this.mContext = paramContext;
      this.jdField_a_of_type_Jkf = new jkf(this.mContext, this);
      emY();
      emZ();
      this.mInited = true;
    }
  }
  
  public void onCallStateChanged(boolean paramBoolean)
  {
    asev.d("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Asey$a != null) {
      this.jdField_a_of_type_Asey$a.Uz(paramBoolean);
    }
  }
  
  public boolean sM()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Iua != null) {
        bool = this.jdField_a_of_type_Iua.sM();
      }
      return bool;
    }
    catch (Exception localException)
    {
      asev.e("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void Uy(boolean paramBoolean);
    
    public abstract void Uz(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asey
 * JD-Core Version:    0.7.0.1
 */