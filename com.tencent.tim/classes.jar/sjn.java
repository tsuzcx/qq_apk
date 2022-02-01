import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjn
  implements View.OnClickListener
{
  public sjn(ServiceFolderFollowPBHeadView paramServiceFolderFollowPBHeadView) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(ServiceFolderFollowPBHeadView.a(this.this$0))) {
      rzd.sW(ServiceFolderFollowPBHeadView.a(this.this$0));
    }
    for (;;)
    {
      ServiceFolderFollowPBHeadView.a(this.this$0).setVisibility(8);
      anot.a(null, "dc00898", "", "", "auth_page", "msg_exp", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e(ServiceFolderFollowPBHeadView.access$100(), 2, "jump error mJumpWebMessageListUrl is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjn
 * JD-Core Version:    0.7.0.1
 */