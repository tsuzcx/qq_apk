import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

public class whn
  implements EmoticonCallback
{
  public whn(StoryInputBarView paramStoryInputBarView) {}
  
  public void delete()
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      TextUtils.backspace(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
  }
  
  public void emoticonMall() {}
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(QQStoryContext.a(), this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whn
 * JD-Core Version:    0.7.0.1
 */