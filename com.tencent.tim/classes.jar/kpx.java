import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class kpx
  extends lce
{
  public kpx(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    super.a(paramInt1, paramLong, paramString1, paramInt2, paramString2, paramString3);
    ReadInJoyDeliverBiuActivity.b(this.this$0, true);
    ReadInJoyDeliverBiuActivity.b(this.this$0);
    QLog.d("ReadInJoyDeliverBiuActivity", 2, "onDeliverUGCResult retCode=" + paramInt1 + ", feedsId=" + paramLong + ", rowkey=" + paramString1 + ", status=" + paramInt2 + ", comment=" + paramString2);
    if (paramInt1 == 0)
    {
      ReadInJoyDeliverBiuActivity.e(this.this$0, -1);
      ReadInJoyDeliverBiuActivity.c(this.this$0);
      this.this$0.getIntent().putExtra("KEY_VIDEO_BIU_SUCCESS", true);
      this.this$0.finish();
      if (ReadInJoyDeliverBiuActivity.o(this.this$0) != 14) {
        lbz.a().mY(true);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (ReadInJoyDeliverBiuActivity.b(this.this$0))) {
        this.this$0.finish();
      }
      return;
      QQToast.a(this.this$0, 1, paramString3, 0).show(this.this$0.getTitleBarHeight());
    }
  }
  
  public void h(long paramLong, int paramInt, String paramString)
  {
    boolean bool = true;
    QLog.i("ReadInJoyDeliverBiuActivity", 1, "onBiuResult: retCode = " + paramInt + " errorMsg = " + paramString);
    ReadInJoyDeliverBiuActivity.c(this.this$0, true);
    ReadInJoyDeliverBiuActivity.d(this.this$0);
    paramLong = NetConnInfoCenter.getServerTimeMillis() - ReadInJoyDeliverBiuActivity.a(this.this$0);
    if (paramInt == 0)
    {
      if (ReadInJoyDeliverBiuActivity.g(this.this$0)) {}
      ReadInJoyDeliverBiuActivity.d(this.this$0, false);
      if (!this.this$0.getIntent().getBooleanExtra("hideSuccessToast", false)) {}
      ReadInJoyDeliverBiuActivity.f(this.this$0, -1);
      ReadInJoyDeliverBiuActivity.c(this.this$0);
      this.this$0.getIntent().putExtra("KEY_VIDEO_BIU_SUCCESS", true);
      this.this$0.finish();
      if (ReadInJoyDeliverBiuActivity.o(this.this$0) != 14) {
        lbz.a().mY(true);
      }
      if (paramInt != 0) {
        break label373;
      }
    }
    for (;;)
    {
      paramString = new HashMap();
      paramString.put("param_FailCode", paramInt + "");
      paramString.put("param_FromType", ReadInJoyDeliverBiuActivity.o(this.this$0) + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actMultiBiuResult", bool, paramLong, 0L, paramString, "");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "doStatisticReport-->success:" + bool + ", costTime:" + paramLong + ", retcode:" + paramInt);
      }
      if (bool) {
        ReadInJoyDeliverBiuActivity.a(this.this$0, bool);
      }
      if ((paramInt != 0) && (ReadInJoyDeliverBiuActivity.b(this.this$0))) {
        this.this$0.finish();
      }
      return;
      QQToast.a(this.this$0, 1, paramString, 0).show(this.this$0.getTitleBarHeight());
      break;
      label373:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpx
 * JD-Core Version:    0.7.0.1
 */