import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

final class tsu
  implements DialogInterface.OnClickListener
{
  tsu(StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ved.d("Q.qqstory.player.PlayModeUtils", "onClick delete =%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem });
    svl.a(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsu
 * JD-Core Version:    0.7.0.1
 */