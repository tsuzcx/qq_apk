import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import java.util.ArrayList;

public class ufi
  implements Runnable
{
  public ufi(VisitorsActivity paramVisitorsActivity) {}
  
  public void run()
  {
    ArrayList localArrayList1 = this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(2, 7);
    ArrayList localArrayList2 = this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(3, 7);
    if (!this.a.isFinishing())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a();
      this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, 0, 0, new Object[] { localArrayList1, localArrayList2 }).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufi
 * JD-Core Version:    0.7.0.1
 */