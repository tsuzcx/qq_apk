import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class nop
  extends BroadcastReceiver
{
  nop(nom paramnom) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.this$0.a);
    this.this$0.j(false, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nop
 * JD-Core Version:    0.7.0.1
 */