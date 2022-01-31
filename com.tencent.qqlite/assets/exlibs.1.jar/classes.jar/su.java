import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.biz.widgets.ScannerView.ScannerListener;

public class su
  extends Handler
{
  public su(ScannerView paramScannerView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9)
    {
      paramMessage = Toast.makeText(this.a.getContext(), this.a.getContext().getString(2131362383), 1);
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
      case 9: 
      default: 
        localObject = ScannerView.a(this.a);
      }
    } while (localObject == null);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      ((ScannerView.FileDecodeListener)localObject).c(String.valueOf(paramMessage.obj));
      return;
      ((ScannerView.ScannerListener)localObject).a(String.valueOf(paramMessage.obj));
      return;
      ((ScannerView.ScannerListener)localObject).h();
      return;
      ((ScannerView.ScannerListener)localObject).g();
      return;
      ((ScannerView.ScannerListener)localObject).f();
      return;
      ((ScannerView.ScannerListener)localObject).j();
      return;
    case 4: 
      ((ScannerView.FileDecodeListener)localObject).b();
      return;
    }
    ((ScannerView.FileDecodeListener)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     su
 * JD-Core Version:    0.7.0.1
 */