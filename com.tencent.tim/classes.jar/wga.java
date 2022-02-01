import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wga
  implements View.OnClickListener
{
  public wga(VisitorsActivity paramVisitorsActivity, CardProfile paramCardProfile, alen paramalen, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.type == 3)
    {
      j = 1;
      k = this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.bIsLastVoteCharged;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.type != 3) {
        break label143;
      }
      if (!((ajqh)this.this$0.app.getManager(207)).ct(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID)) {
        break label138;
      }
    }
    for (;;)
    {
      this.this$0.a(this.jdField_a_of_type_Alen, this.val$position, this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.bVoteCnt, i);
      anot.a(this.this$0.app, "CliOper", "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID), "like_mall", "like_list_view", j, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      j = 0;
      break;
      label138:
      i = 0;
      continue;
      label143:
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wga
 * JD-Core Version:    0.7.0.1
 */