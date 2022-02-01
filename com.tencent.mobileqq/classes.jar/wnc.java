import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class wnc
  implements TextView.OnEditorActionListener
{
  public wnc(StoryInputBarView paramStoryInputBarView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramTextView = paramTextView.getText().toString();
      if (paramTextView.length() <= 0) {
        break label140;
      }
      this.a.setKeyBoardState(false);
      if (this.a.jdField_a_of_type_Wmf != null) {
        this.a.jdField_a_of_type_Wmf.a(paramTextView, this.a.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
      this.a.c();
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      if (StoryInputBarView.a(this.a) != null) {
        StoryInputBarView.a(this.a).a(paramTextView, this.a.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory:StoryInputBarView", 2, "onEditorAction vaule=" + paramTextView);
      }
    }
    return false;
    label140:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnc
 * JD-Core Version:    0.7.0.1
 */