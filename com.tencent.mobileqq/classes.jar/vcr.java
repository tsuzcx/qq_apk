import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;

class vcr
  implements Observer<vup<QQCirclePrivateMsgShow.StGetPMSettingRsp>>
{
  vcr(vcq paramvcq) {}
  
  public void a(@Nullable vup<QQCirclePrivateMsgShow.StGetPMSettingRsp> paramvup)
  {
    if ((paramvup != null) && (paramvup.a() == 3)) {
      vcq.a(this.a, (QQCirclePrivateMsgShow.StGetPMSettingRsp)paramvup.a());
    }
    while ((paramvup == null) || (paramvup.a() != 4)) {
      return;
    }
    vcq.a(this.a, paramvup.a(), paramvup.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcr
 * JD-Core Version:    0.7.0.1
 */