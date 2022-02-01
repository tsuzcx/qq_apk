import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ahnx
  extends SosoInterface.a
{
  public ahnx(NearbyHybridFragment paramNearbyHybridFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString, long paramLong2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    long l = System.currentTimeMillis() - this.AG;
    this.this$0.mHandler.removeMessages(7);
    StringBuilder localStringBuilder = new StringBuilder().append("onLocationFinish, errCode=").append(paramInt).append(", timeCost=").append(l).append(", info==null?");
    if (paramSosoLbsInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("nearby.NearbyHybridFragment.webloading", 1, bool + ", isTimeOut=" + this.this$0.chG);
      if ((paramInt == 0) && (paramSosoLbsInfo != null)) {
        break label188;
      }
      this.this$0.e(false, paramInt, l);
      if (!this.this$0.chG) {
        break;
      }
      return;
    }
    if (aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1, acfp.m(2131708739), 1).show();
    }
    this.this$0.mHandler.removeMessages(3);
    this.this$0.dao = 1;
    this.this$0.mHandler.sendEmptyMessage(5);
    return;
    label188:
    NearbyHybridFragment.aaH = System.currentTimeMillis();
    NearbyHybridFragment.g = paramSosoLbsInfo;
    ajrb.b(this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), paramSosoLbsInfo);
    if (!this.this$0.chG) {
      this.this$0.doS();
    }
    for (;;)
    {
      this.this$0.e(true, paramInt, l);
      return;
      this.this$0.d(paramSosoLbsInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnx
 * JD-Core Version:    0.7.0.1
 */