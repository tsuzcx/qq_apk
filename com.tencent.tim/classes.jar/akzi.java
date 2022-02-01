import android.os.CountDownTimer;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.ProgressViewRed;

class akzi
  extends CountDownTimer
{
  akzi(akze paramakze, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    PortalManager localPortalManager = (PortalManager)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getManager(79);
    if (localPortalManager != null) {
      localPortalManager.dEy();
    }
  }
  
  public void onTick(long paramLong)
  {
    if (akze.a(this.this$0).getVisibility() == 0)
    {
      this.this$0.ky(paramLong);
      akze.a(this.this$0).a(paramLong, this.an[0], this.this$0.R);
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.getVisibility() == 0)
    {
      this.this$0.ky(paramLong);
      this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramLong, this.an[0], this.this$0.S);
    }
    paramLong = System.currentTimeMillis() - this.this$0.afE;
    if (paramLong > 2000L) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
    }
    while (paramLong <= 1000L) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzi
 * JD-Core Version:    0.7.0.1
 */