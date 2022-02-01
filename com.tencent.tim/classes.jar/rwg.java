import android.content.Context;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class rwg
  implements Manager
{
  private rwi a;
  private QQAppInterface app;
  private Context mContext;
  
  public rwg(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void bxd()
  {
    if (this.a != null) {
      this.a.bxd();
    }
  }
  
  private void bxe()
  {
    if (this.a != null) {
      this.a.bxe();
    }
  }
  
  public void a(Context paramContext, ScannerParams paramScannerParams)
  {
    this.mContext = paramContext;
    if ((paramScannerParams.aKj) && (!paramScannerParams.aKh) && (this.a == null)) {
      this.a = new rwi(this.mContext, this.app);
    }
  }
  
  public void bxf()
  {
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
  }
  
  public void onDestroy()
  {
    bxf();
    this.app = null;
    this.mContext = null;
  }
  
  public void yd(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 2: 
      bxd();
      return;
    case 3: 
      bxe();
      return;
    }
    bxf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwg
 * JD-Core Version:    0.7.0.1
 */