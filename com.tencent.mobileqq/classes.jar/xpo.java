import android.os.Handler;
import com.qq.im.poi.LbsPackObserver;
import com.tencent.mobileqq.activity.richmedia.LBSDetetor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class xpo
  extends LbsPackObserver
{
  private xpo(LBSDetetor paramLBSDetetor) {}
  
  public void onGetLBSTemplateIds(int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((LBSDetetor.a(this.a) != null) && (LBSDetetor.a(this.a).hasMessages(paramInt))) {
      LBSDetetor.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpo
 * JD-Core Version:    0.7.0.1
 */