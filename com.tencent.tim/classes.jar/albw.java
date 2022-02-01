import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.b;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.c;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;

public class albw
  implements DialogInterface.OnClickListener
{
  public albw(PersonalityLabelGalleryActivity.c paramc, View paramView, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = (PersonalityLabelGalleryActivity.b)this.val$v.getTag(2131365679);
    if (paramDialogInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$c.this$0.c(paramDialogInterface.itemView, this.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albw
 * JD-Core Version:    0.7.0.1
 */