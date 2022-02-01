import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.a;

public class aofa
  extends Handler
{
  public aofa(ShareAppLogHelper paramShareAppLogHelper, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (ShareAppLogHelper.a(this.this$0) == null);
        ShareAppLogHelper.a(this.this$0).Gk((String)paramMessage.obj);
        return;
      } while (ShareAppLogHelper.a(this.this$0) == null);
      ShareAppLogHelper.a(this.this$0).onError(((Integer)paramMessage.obj).intValue());
      return;
    } while (ShareAppLogHelper.a(this.this$0) == null);
    ShareAppLogHelper.a(this.this$0).Ks(((Integer)paramMessage.obj).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofa
 * JD-Core Version:    0.7.0.1
 */