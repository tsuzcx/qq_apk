import android.content.res.Resources;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class wyg
  extends atcd
{
  public wyg(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((aszf)TroopMemberApiService.f(this.a).getManager(106)).d.put(((QQAppInterface)TroopMemberApiService.g(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      bbkb.a(BaseApplication.getContext(), false);
      bcql.a(BaseApplication.getContext(), 2, ajya.a(2131715565), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (String str = "1";; str = "2")
    {
      atbt.a("clk_del_video", new String[] { str });
      return;
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131715642), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
      break;
    }
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
    }
    ((aszf)TroopMemberApiService.h(this.a).getManager(106)).d.put(((QQAppInterface)TroopMemberApiService.i(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      bbkb.a(BaseApplication.getContext(), true);
      bcql.a(BaseApplication.getContext(), 2, ajya.a(2131715643), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
      if (!paramBoolean) {
        break label166;
      }
    }
    label166:
    for (paramHeadInfo = "1";; paramHeadInfo = "2")
    {
      atbt.a("clk_upload_video", new String[] { paramHeadInfo });
      return;
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131715571), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyg
 * JD-Core Version:    0.7.0.1
 */