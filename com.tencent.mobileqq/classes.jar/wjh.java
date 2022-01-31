import android.content.res.Resources;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class wjh
  extends asfx
{
  public wjh(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((ascz)TroopMemberApiService.f(this.a).getManager(106)).d.put(((QQAppInterface)TroopMemberApiService.g(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      baig.a(BaseApplication.getContext(), false);
      bbmy.a(BaseApplication.getContext(), 2, ajjy.a(2131649763), 0).b(this.a.getResources().getDimensionPixelSize(2131167766));
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (String str = "1";; str = "2")
    {
      asfn.a("clk_del_video", new String[] { str });
      return;
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131649840), 0).b(this.a.getResources().getDimensionPixelSize(2131167766));
      break;
    }
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
    }
    ((ascz)TroopMemberApiService.h(this.a).getManager(106)).d.put(((QQAppInterface)TroopMemberApiService.i(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      baig.a(BaseApplication.getContext(), true);
      bbmy.a(BaseApplication.getContext(), 2, ajjy.a(2131649841), 0).b(this.a.getResources().getDimensionPixelSize(2131167766));
      if (!paramBoolean) {
        break label166;
      }
    }
    label166:
    for (paramHeadInfo = "1";; paramHeadInfo = "2")
    {
      asfn.a("clk_upload_video", new String[] { paramHeadInfo });
      return;
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131649769), 0).b(this.a.getResources().getDimensionPixelSize(2131167766));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wjh
 * JD-Core Version:    0.7.0.1
 */