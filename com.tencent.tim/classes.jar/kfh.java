import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.5.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public class kfh
  extends aczc.b
{
  kfh(kfa paramkfa, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.i("DailyHeaderViewController", 1, "[onLocationFinish] errCode=" + paramInt + "");
    ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderViewController.5.1(this, paramInt, paramSosoLbsInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfh
 * JD-Core Version:    0.7.0.1
 */