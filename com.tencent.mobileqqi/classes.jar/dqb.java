import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class dqb
  implements Runnable
{
  public dqb(TroopMemberCardActivity paramTroopMemberCardActivity, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b.a(this.jdField_a_of_type_JavaLangString, (byte)3, true);
    if (localBitmap != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.runOnUiThread(new dqc(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqb
 * JD-Core Version:    0.7.0.1
 */