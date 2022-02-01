import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class xve
  implements TextWatcher
{
  public int a;
  public Context a;
  public BubbleTextView a;
  public String a;
  public yck a;
  public boolean a;
  private int b;
  public String b;
  private int c;
  
  public xve(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((!"1_".equals(paramString2)) && (!"2_".equals(paramString2))) {
      throw new IllegalArgumentException("illegal textWatcher source");
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
  }
  
  public static void a(EditText paramEditText, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("at_video_text");
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.atvideo.AtVideoTextWatcher", 2, "on activity result, at video text=" + paramIntent);
      }
    } while ((paramEditText == null) || (TextUtils.isEmpty(paramIntent)));
    paramEditText.getText().insert(paramEditText.getSelectionStart(), paramIntent);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.c > 0)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null)
      {
        ViewParent localViewParent2 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent();
        ViewParent localViewParent1 = localViewParent2;
        if (localViewParent2 != null)
        {
          localViewParent1 = localViewParent2;
          if (!(localViewParent2 instanceof RelativeLayout)) {
            localViewParent1 = localViewParent2.getParent();
          }
        }
        if ((localViewParent1 != null) && ((localViewParent1 instanceof RelativeLayout))) {
          ((RelativeLayout)localViewParent1).removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
      }
      if (('@' == paramEditable.charAt(this.jdField_b_of_type_Int + this.c - 1)) || (65312 == paramEditable.charAt(this.jdField_b_of_type_Int + this.c - 1)))
      {
        ykv.a("home_page", "send_at", 0, 0, new String[0]);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.atvideo.AtVideoTextWatcher", 2, "trigger at video process");
        }
        if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_Boolean)) {
          StoryAtVideoFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, (String)this.jdField_a_of_type_Yck.a.get(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xve
 * JD-Core Version:    0.7.0.1
 */