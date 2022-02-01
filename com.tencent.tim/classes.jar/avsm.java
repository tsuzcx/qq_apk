import android.content.Intent;
import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.widget.AbsListView.e;
import cooperation.qzone.contentbox.model.MQMsg;

public abstract interface avsm
  extends AbsListView.e
{
  public abstract boolean a(ViewGroup paramViewGroup, MQMsg paramMQMsg);
  
  public abstract void clearCache();
  
  public abstract void h(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDestroy();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void setHandler(Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsm
 * JD-Core Version:    0.7.0.1
 */