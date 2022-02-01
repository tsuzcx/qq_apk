import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ahob
  extends SosoInterface.a
{
  public ahob(NowLiveFragment paramNowLiveFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt != 0)
    {
      QQToast.a(this.this$0.b, 1, acfp.m(2131709201), 1).show();
      this.this$0.init();
    }
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveFragment", 2, "startLocation finish" + System.currentTimeMillis());
    }
    this.this$0.c(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahob
 * JD-Core Version:    0.7.0.1
 */