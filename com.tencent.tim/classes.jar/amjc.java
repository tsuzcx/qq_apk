import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.scribble.ScribbleResMgr.a;
import com.tencent.mobileqq.scribble.ScribbleResMgr.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class amjc
  extends Handler
{
  public amjc(ScribbleResMgr paramScribbleResMgr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScribbleResMgr", 2, "handleMessage  status: " + paramMessage.what + " type: " + paramMessage.arg1);
    }
    if (paramMessage.what == 1001) {
      ScribbleResMgr.a(this.this$0, paramMessage.arg1, paramMessage.arg2, true);
    }
    for (;;)
    {
      return;
      if (paramMessage.what == 1002)
      {
        ScribbleResMgr.a(this.this$0, paramMessage.arg1, paramMessage.arg2, false);
        return;
      }
      Iterator localIterator = ScribbleResMgr.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ScribbleResMgr.a)localIterator.next();
        if (localObject != null)
        {
          View localView = ((ScribbleResMgr.a)localObject).getView();
          localObject = ((ScribbleResMgr.a)localObject).a();
          if ((localView != null) && (localObject != null)) {
            ((ScribbleResMgr.b)localObject).a(localView, paramMessage.arg1, (ScribbleResMgr.ResInfo)paramMessage.obj, paramMessage.what);
          } else {
            localIterator.remove();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjc
 * JD-Core Version:    0.7.0.1
 */