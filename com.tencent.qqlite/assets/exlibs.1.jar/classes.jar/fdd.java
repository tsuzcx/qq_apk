import android.graphics.Bitmap;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.open.agent.util.AuthorityUtil;

public class fdd
  implements Runnable
{
  public fdd(BindGroupConfirmActivity paramBindGroupConfirmActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity, this.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.runOnUiThread(new fde(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fdd
 * JD-Core Version:    0.7.0.1
 */