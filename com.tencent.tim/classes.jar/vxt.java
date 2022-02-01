import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;

public class vxt
  extends Handler
{
  public vxt(TroopAssisSettingActivity paramTroopAssisSettingActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.this$0.a.ac(this.this$0.hp);
    this.this$0.a.notifyDataSetChanged();
    this.this$0.bWo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxt
 * JD-Core Version:    0.7.0.1
 */