import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.vendorpush.VendorPushHelper.1;

public class auqf
  implements XGIOperateCallback
{
  public auqf(VendorPushHelper.1 param1, long paramLong) {}
  
  public void onFail(Object paramObject, int paramInt, String paramString)
  {
    long l = System.currentTimeMillis() - this.val$startTime;
    paramObject = XGPushConfig.getOtherPushErrCode(BaseApplication.getContext());
    auqe.e(false, l, paramObject, XGPushConfig.getOtherPushType(BaseApplication.getContext()));
    QLog.d("TPush", 1, new Object[] { "注册失败，errCode:", Integer.valueOf(paramInt), " ,errMsg：", paramString, " ,otherPushCode:", paramObject, " ,cost:", Long.valueOf(l) });
  }
  
  public void onSuccess(Object paramObject, int paramInt)
  {
    long l = System.currentTimeMillis() - this.val$startTime;
    String str1 = XGPushConfig.getOtherPushErrCode(BaseApplication.getContext());
    String str2 = XGPushConfig.getOtherPushType(BaseApplication.getContext());
    QLog.d("TPush", 1, new Object[] { "注册成功，token:", paramObject, " ,otherPushCode:", str1, " ,cost:", Long.valueOf(l) });
    auqe.access$002((String)paramObject);
    auqe.ewg();
    auqe.e(true, l, str1, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqf
 * JD-Core Version:    0.7.0.1
 */