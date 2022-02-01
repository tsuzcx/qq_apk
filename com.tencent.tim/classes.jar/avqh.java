import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;

public class avqh
  implements afxx.a
{
  public avqh(QZoneNavigateToQQTransparentFragment paramQZoneNavigateToQQTransparentFragment, FragmentActivity paramFragmentActivity) {}
  
  public void bPe()
  {
    QZoneNavigateToQQTransparentFragment.f(this.b);
  }
  
  public void d(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    QZoneNavigateToQQTransparentFragment.a(this.b, paramBoolean, paramInt, paramString1, paramString2);
  }
  
  public void dk(String paramString1, String paramString2)
  {
    QZoneNavigateToQQTransparentFragment.b(this.b, paramString1, paramString2);
  }
  
  public void showToast(int paramInt)
  {
    if (this.b == null)
    {
      QLog.d("QZoneNavigateToQQTransparentFragment", 1, "sendMsgDirectly()-> showToast() activity is null just return");
      return;
    }
    QZoneNavigateToQQTransparentFragment.b(this.b, this.b.getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqh
 * JD-Core Version:    0.7.0.1
 */