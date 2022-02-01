import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahul
  implements View.OnClickListener
{
  public ahul(ImgHeaderView paramImgHeaderView, Activity paramActivity, QQGameMsgInfo paramQQGameMsgInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewImgHeaderView, this.val$activity, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.paMsgid, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId, this.val$position, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahul
 * JD-Core Version:    0.7.0.1
 */