import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class fau
  implements Runnable
{
  public fau(BindGroupConfirmActivity paramBindGroupConfirmActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fau
 * JD-Core Version:    0.7.0.1
 */