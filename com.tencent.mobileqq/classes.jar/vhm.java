import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

final class vhm
  implements DialogInterface.OnClickListener
{
  vhm(StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    wsv.d("Q.qqstory.player.PlayModeUtils", "onClick delete =%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem });
    ukd.a(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vhm
 * JD-Core Version:    0.7.0.1
 */