import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.biz.widgets.ScannerView;

public class zcj
  extends Handler
{
  public zcj(ScannerView paramScannerView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9)
    {
      paramMessage = Toast.makeText(this.a.getContext(), this.a.getContext().getString(2131690643), 1);
      paramMessage.setGravity(17, 0, 0);
      paramMessage.show();
    }
    Object localObject;
    do
    {
      return;
      localObject = ScannerView.a(this.a);
      if (localObject != null) {}
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        localObject = ScannerView.a(this.a);
        if (localObject != null) {}
        switch (paramMessage.what)
        {
        default: 
          localObject = ScannerView.a(this.a);
        }
        break;
      }
    } while (localObject == null);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      ((zcm)localObject).a(bool);
      return;
      ((zcn)localObject).a(String.valueOf(paramMessage.obj));
      return;
      ((zcn)localObject).c();
      return;
      ((zcn)localObject).b();
      return;
      ((zcn)localObject).a();
      return;
      ((zcl)localObject).a(String.valueOf(paramMessage.obj), 1, 1);
      return;
      ((zcl)localObject).a(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zcj
 * JD-Core Version:    0.7.0.1
 */