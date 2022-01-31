import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.item.PLNewsItemBuilder;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;

public class vhl
  implements View.OnClickListener
{
  public vhl(PLNewsItemBuilder paramPLNewsItemBuilder, MessageForPLNews paramMessageForPLNews, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = (vhm)paramView.getTag();
    if (paramView == null) {
      return;
    }
    paramView = new ProfileActivity.AllInOne(paramView.jdField_a_of_type_JavaLangString, 1);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPLNewsItemBuilder.a, PersonalityLabelGalleryActivity.class);
    localIntent.putExtra("personality_label_allinone", paramView);
    localIntent.putExtra("fromType", 2);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPLNews.frienduin);
    localIntent.putExtra("nickname", this.jdField_a_of_type_JavaLangString);
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPLNewsItemBuilder.a instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPLNewsItemBuilder.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vhl
 * JD-Core Version:    0.7.0.1
 */