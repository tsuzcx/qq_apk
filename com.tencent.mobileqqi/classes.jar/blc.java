import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoInviteActivity;

public class blc
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public blc(VideoInviteActivity paramVideoInviteActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a == null) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.r();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d();
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.t();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blc
 * JD-Core Version:    0.7.0.1
 */