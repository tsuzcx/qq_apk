import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

final class xjc
  implements DialogInterface.OnClickListener
{
  xjc(StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    yuk.d("Q.qqstory.player.PlayModeUtils", "onClick delete =%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem });
    wlt.a(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjc
 * JD-Core Version:    0.7.0.1
 */