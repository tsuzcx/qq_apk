import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class tjm
{
  private tjm.a jdField_a_of_type_Tjm$a;
  private tjm.b jdField_a_of_type_Tjm$b;
  private Context mContext;
  
  public tjm(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void a(tjm.b paramb)
  {
    this.jdField_a_of_type_Tjm$b = paramb;
  }
  
  public void registerReceiver()
  {
    this.jdField_a_of_type_Tjm$a = new tjm.a(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.mContext.registerReceiver(this.jdField_a_of_type_Tjm$a, localIntentFilter);
  }
  
  public void unregisterReceiver()
  {
    if ((this.jdField_a_of_type_Tjm$a != null) && (this.mContext != null))
    {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_Tjm$a);
      this.jdField_a_of_type_Tjm$b = null;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
      if (i == 3) {}
      for (boolean bool = true;; bool = false)
      {
        tkw.d("VolumeBroadcastReceiver", "VolumeBroadcastReceiver action type = " + paramIntent.getAction() + ", isStreamMusic = " + bool + ", streamType = " + i);
        if (("android.media.VOLUME_CHANGED_ACTION".equals(paramIntent.getAction())) && (bool) && (tjm.a(tjm.this) != null)) {
          tjm.a(tjm.this).v(new Object[0]);
        }
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void v(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjm
 * JD-Core Version:    0.7.0.1
 */