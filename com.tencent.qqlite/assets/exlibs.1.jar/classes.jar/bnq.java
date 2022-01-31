import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bnq
  implements Runnable
{
  public bnq(TroopMemberCardActivity paramTroopMemberCardActivity, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a(this.jdField_a_of_type_JavaLangString, (byte)3, true);
    if (localBitmap != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.runOnUiThread(new bnr(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnq
 * JD-Core Version:    0.7.0.1
 */