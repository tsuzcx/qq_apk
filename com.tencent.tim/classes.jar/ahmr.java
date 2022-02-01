import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ahmr
  extends SosoInterface.a
{
  public ahmr(CommonTabFragment paramCommonTabFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonTabFragment", 2, "startLocation finish" + System.currentTimeMillis());
    }
    if (paramInt != 0)
    {
      QQToast.a(this.a.b, 1, acfp.m(2131704245), 1).show();
      this.a.init();
      return;
    }
    this.a.c(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmr
 * JD-Core Version:    0.7.0.1
 */