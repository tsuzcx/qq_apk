import android.content.res.Resources;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class ymz
  extends autc
{
  public ymz(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((auqc)TroopMemberApiService.f(this.a).getManager(106)).d.put(((QQAppInterface)TroopMemberApiService.g(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      bdiv.a(BaseApplication.getContext(), false);
      QQToast.a(BaseApplication.getContext(), 2, alpo.a(2131715937), 0).b(this.a.getResources().getDimensionPixelSize(2131298914));
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (String str = "1";; str = "2")
    {
      auss.a("clk_del_video", new String[] { str });
      return;
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131716014), 0).b(this.a.getResources().getDimensionPixelSize(2131298914));
      break;
    }
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
    }
    ((auqc)TroopMemberApiService.h(this.a).getManager(106)).d.put(((QQAppInterface)TroopMemberApiService.i(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      bdiv.a(BaseApplication.getContext(), true);
      QQToast.a(BaseApplication.getContext(), 2, alpo.a(2131716015), 0).b(this.a.getResources().getDimensionPixelSize(2131298914));
      if (!paramBoolean) {
        break label166;
      }
    }
    label166:
    for (paramHeadInfo = "1";; paramHeadInfo = "2")
    {
      auss.a("clk_upload_video", new String[] { paramHeadInfo });
      return;
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131715943), 0).b(this.a.getResources().getDimensionPixelSize(2131298914));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ymz
 * JD-Core Version:    0.7.0.1
 */