import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.RefreshCallback;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

public class wmt
  implements LebaTabRedTouch.RefreshCallback
{
  public wmt(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    boolean bool = true;
    Object localObject = this.a.a.obtainMessage(1);
    ((Message)localObject).obj = paramRedTypeInfo;
    this.a.a.sendMessage((Message)localObject);
    localObject = ReadinjoySPEventReport.a();
    if (paramRedTypeInfo != null) {}
    for (;;)
    {
      ((ReadinjoySPEventReport)localObject).a(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmt
 * JD-Core Version:    0.7.0.1
 */