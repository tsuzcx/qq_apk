import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

final class wzn
  implements DialogInterface.OnClickListener
{
  wzn(StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ykq.d("Q.qqstory.player.PlayModeUtils", "onClick delete =%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem });
    wcn.a(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzn
 * JD-Core Version:    0.7.0.1
 */