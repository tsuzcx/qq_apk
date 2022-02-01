import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.b;
import com.tencent.biz.widgets.ScannerView.c;
import com.tencent.biz.widgets.ScannerView.d;

public class swd
  extends Handler
{
  public swd(ScannerView paramScannerView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9)
    {
      paramMessage = Toast.makeText(this.this$0.getContext(), this.this$0.getContext().getString(2131691241), 1);
      paramMessage.setGravity(17, 0, 0);
      paramMessage.show();
    }
    Object localObject;
    do
    {
      return;
      localObject = ScannerView.a(this.this$0);
      if (localObject != null) {}
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        localObject = ScannerView.a(this.this$0);
        if (localObject != null) {}
        switch (paramMessage.what)
        {
        default: 
          localObject = ScannerView.a(this.this$0);
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
      ((ScannerView.c)localObject).vg(bool);
      return;
      ((ScannerView.d)localObject).tU(String.valueOf(paramMessage.obj));
      return;
      ((ScannerView.d)localObject).bBx();
      return;
      ((ScannerView.d)localObject).bBw();
      return;
      ((ScannerView.d)localObject).bBv();
      return;
      ((ScannerView.b)localObject).z(String.valueOf(paramMessage.obj), 1, 1);
      return;
      ((ScannerView.b)localObject).yc(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     swd
 * JD-Core Version:    0.7.0.1
 */