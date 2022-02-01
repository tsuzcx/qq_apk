import android.content.res.Resources;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class skw
  extends ajrw
{
  public skw(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
    }
    ((ajpj)TroopMemberApiService.h(this.d).getManager(106)).go.put(((QQAppInterface)TroopMemberApiService.i(this.d)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      aqmj.I(BaseApplication.getContext(), true);
      QQToast.a(BaseApplication.getContext(), 2, acfp.m(2131715990), 0).show(this.d.getResources().getDimensionPixelSize(2131299627));
      if (!paramBoolean) {
        break label166;
      }
    }
    label166:
    for (paramHeadInfo = "1";; paramHeadInfo = "2")
    {
      ajrm.k("clk_upload_video", new String[] { paramHeadInfo });
      return;
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131715918), 0).show(this.d.getResources().getDimensionPixelSize(2131299627));
      break;
    }
  }
  
  protected void uR(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((ajpj)TroopMemberApiService.f(this.d).getManager(106)).go.put(((QQAppInterface)TroopMemberApiService.g(this.d)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      aqmj.I(BaseApplication.getContext(), false);
      QQToast.a(BaseApplication.getContext(), 2, acfp.m(2131715912), 0).show(this.d.getResources().getDimensionPixelSize(2131299627));
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (String str = "1";; str = "2")
    {
      ajrm.k("clk_del_video", new String[] { str });
      return;
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131715989), 0).show(this.d.getResources().getDimensionPixelSize(2131299627));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skw
 * JD-Core Version:    0.7.0.1
 */