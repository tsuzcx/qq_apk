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

public class qrj
  implements TextWatcher
{
  public BubbleTextView a;
  public qvf a;
  public boolean aET;
  private int bnN;
  public Context mContext;
  public String mFeedId;
  public int mRequestCode;
  public String mSource;
  private int mStart;
  
  public qrj(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((!"1_".equals(paramString2)) && (!"2_".equals(paramString2))) {
      throw new IllegalArgumentException("illegal textWatcher source");
    }
    this.mSource = paramString2;
    this.mContext = paramContext;
    this.mFeedId = paramString1;
    this.mRequestCode = paramInt;
    this.aET = paramBoolean;
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
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
    if (this.bnN > 0)
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
      if (('@' == paramEditable.charAt(this.mStart + this.bnN - 1)) || (65312 == paramEditable.charAt(this.mStart + this.bnN - 1)))
      {
        rar.a("home_page", "send_at", 0, 0, new String[0]);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.atvideo.AtVideoTextWatcher", 2, "trigger at video process");
        }
        if (((this.mContext instanceof Activity)) && (this.aET)) {
          StoryAtVideoFragment.c((Activity)this.mContext, this.mFeedId, (String)this.jdField_a_of_type_Qvf.gb.get(this.mSource + this.mFeedId), this.mRequestCode);
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mStart = paramInt1;
    this.bnN = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrj
 * JD-Core Version:    0.7.0.1
 */