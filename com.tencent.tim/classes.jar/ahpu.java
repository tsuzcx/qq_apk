import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahpu
  implements View.OnClickListener
{
  public ahpu(IntimatePlayTogetherMiniGameCardView.a parama, MISC.StAppPlayingInfo paramStAppPlayingInfo, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    ahpv.a(paramView.getContext(), this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StAppPlayingInfo.appMetaInfo, IntimatePlayTogetherMiniGameCardView.a.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimatePlayTogetherMiniGameCardView$a), IntimatePlayTogetherMiniGameCardView.a.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimatePlayTogetherMiniGameCardView$a), this.chS);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpu
 * JD-Core Version:    0.7.0.1
 */