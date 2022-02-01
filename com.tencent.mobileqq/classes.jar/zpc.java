import android.content.res.Resources;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class zpc
  extends awkv
{
  public zpc(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((awhw)TroopMemberApiService.f(this.a).getManager(106)).d.put(((QQAppInterface)TroopMemberApiService.g(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      bfyz.a(BaseApplication.getContext(), false);
      QQToast.a(BaseApplication.getContext(), 2, amtj.a(2131714571), 0).b(this.a.getResources().getDimensionPixelSize(2131299076));
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (String str = "1";; str = "2")
    {
      awkl.a("clk_del_video", new String[] { str });
      return;
      QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131714648), 0).b(this.a.getResources().getDimensionPixelSize(2131299076));
      break;
    }
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel())
    {
      if (paramHeadInfo != null) {
        QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
      }
    }
    else
    {
      ((awhw)TroopMemberApiService.h(this.a).getManager(106)).d.put(((QQAppInterface)TroopMemberApiService.i(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
      if (!paramBoolean) {
        break label149;
      }
      bfyz.a(BaseApplication.getContext(), true);
      QQToast.a(BaseApplication.getContext(), 2, amtj.a(2131714649), 0).b(this.a.getResources().getDimensionPixelSize(2131299076));
      label117:
      if (!paramBoolean) {
        break label181;
      }
    }
    label149:
    label181:
    for (paramHeadInfo = "1";; paramHeadInfo = "2")
    {
      awkl.a("clk_upload_video", new String[] { paramHeadInfo });
      return;
      QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo , headInfo is null");
      break;
      QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131714577), 0).b(this.a.getResources().getDimensionPixelSize(2131299076));
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpc
 * JD-Core Version:    0.7.0.1
 */