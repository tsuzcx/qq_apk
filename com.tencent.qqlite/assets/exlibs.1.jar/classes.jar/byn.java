import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

public class byn
  implements DialogInterface.OnClickListener
{
  public byn(AIOImageListScene paramAIOImageListScene, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label47;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
    }
    for (;;)
    {
      AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, null);
      return;
      label47:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byn
 * JD-Core Version:    0.7.0.1
 */