import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.JumpActivity.b;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager.a;

public class vel
  implements WebProcessManager.a
{
  public vel(JumpActivity.b paramb, JumpActivity paramJumpActivity) {}
  
  public void onResult(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.bPU();
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_key_jump_src", 1);
    ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, 1, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vel
 * JD-Core Version:    0.7.0.1
 */