import android.os.Bundle;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import java.util.List;
import mqq.observer.BusinessObserver;

public class xzl
  implements BusinessObserver
{
  public xzl(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, List<String> paramList1, List<String> paramList2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      a(paramBoolean, paramBundle.getStringArrayList("nickname_list"), paramBundle.getStringArrayList("uin_list"));
      return;
    }
    this.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xzl
 * JD-Core Version:    0.7.0.1
 */