import SummaryCardTaf.SSummaryCardRsp;
import android.util.Pair;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.13.1;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;

public class uys
  extends accn
{
  public uys(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.e != null) && (this.this$0.jdField_a_of_type_Alcn.e.uin != null) && (paramString.equals(this.this$0.jdField_a_of_type_Alcn.e.uin))) {
      if ((paramBoolean1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.TL(paramBoolean2);
      }
    }
    for (;;)
    {
      QLog.d("FriendProfileCardActivity", 2, " isSuccess" + paramBoolean1 + " isAllow" + paramBoolean2);
      return;
      QLog.e("FriendProfileCardActivity", 2, "onGetAllowSeeLoginDays uin empty");
    }
  }
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (this.this$0.isFinishing()) {
          break;
        }
        this.this$0.b.removeCallbacks(this.this$0.mDismissRunnable);
        this.this$0.bF();
        if ((!paramBoolean) || (paramObject == null)) {
          break;
        }
        if ((paramObject instanceof Card))
        {
          ThreadManager.post(new FriendProfileCardActivity.13.1(this, (Card)paramObject), 5, null, true);
          return;
        }
        if (!(paramObject instanceof Pair)) {
          break;
        }
        paramObject = (Pair)paramObject;
        if (((Integer)paramObject.first).intValue() == 101107)
        {
          this.this$0.bGY = 1;
          this.this$0.bOQ();
          return;
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if (((Integer)paramObject.first).intValue() == 101108)
      {
        this.this$0.bGY = 2;
      }
      else if (((Integer)paramObject.first).intValue() == 101111)
      {
        this.this$0.bGY = 3;
      }
      else if (((Integer)paramObject.first).intValue() == 12002)
      {
        this.this$0.bGY = 4;
      }
      else
      {
        this.this$0.bGY = 5;
        this.this$0.a((SSummaryCardRsp)paramObject.second);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uys
 * JD-Core Version:    0.7.0.1
 */