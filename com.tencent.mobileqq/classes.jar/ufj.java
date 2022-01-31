import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class ufj
  implements View.OnClickListener
{
  public ufj(VisitorsActivity paramVisitorsActivity, CardProfile paramCardProfile, PraiseInfo paramPraiseInfo, int paramInt) {}
  
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
        break label136;
      }
      if (!((NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app.getManager(206)).c(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID)) {
        break label131;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.bVoteCnt, i);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, "CliOper", "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID), "like_mall", "like_list_view", j, 0, "", "", "", "");
      return;
      j = 0;
      break;
      label131:
      i = 0;
      continue;
      label136:
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufj
 * JD-Core Version:    0.7.0.1
 */