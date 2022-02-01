import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

class wxe
  extends acku
{
  wxe(wxc paramwxc) {}
  
  public void wV(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedpointHandler", 2, "troopChatPie RedpointObserver  onDataChange");
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)wxc.a(this.a).app.getManager(36)).a(4, String.valueOf(130500));
    if (this.a.sJ == null) {
      this.a.sJ = ((ImageView)wxc.a(this.a).mAIORootView.findViewById(2131377002));
    }
    if (this.a.sJ == null) {
      return;
    }
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      this.a.sJ.setVisibility(0);
      return;
    }
    this.a.sJ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxe
 * JD-Core Version:    0.7.0.1
 */