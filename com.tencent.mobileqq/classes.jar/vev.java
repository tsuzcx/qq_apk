import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;

class vev
  implements Observer<vxq<QQCirclePrivateMsgShow.StGetPMSettingRsp>>
{
  vev(veu paramveu) {}
  
  public void a(@Nullable vxq<QQCirclePrivateMsgShow.StGetPMSettingRsp> paramvxq)
  {
    if ((paramvxq != null) && (paramvxq.a() == 3)) {
      veu.a(this.a, (QQCirclePrivateMsgShow.StGetPMSettingRsp)paramvxq.a());
    }
    while ((paramvxq == null) || (paramvxq.a() != 4)) {
      return;
    }
    veu.a(this.a, paramvxq.a(), paramvxq.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vev
 * JD-Core Version:    0.7.0.1
 */