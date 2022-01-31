import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import java.util.ArrayList;

public class cfk
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private cfk(ChatActivity paramChatActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (paramTextView.length() > 0)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1) {
          break label118;
        }
        paramTextView = new ArrayList();
        paramKeyEvent = AtTroopMemberSpan.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), paramTextView);
        ChatActivityFacade.a(this.a.b, this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramKeyEvent, paramTextView);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
        ChatActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, -1);
        return true;
        label118:
        ChatActivityFacade.a(this.a.b, this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramTextView, null);
      }
    }
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 66)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        paramKeyEvent = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((this.a.c) && (paramKeyEvent.length() > 0))
        {
          if ((!paramKeyEvent.endsWith("\r")) && (!paramKeyEvent.endsWith("\n"))) {
            break label94;
          }
          paramView = paramKeyEvent.substring(0, paramKeyEvent.length() - 1);
        }
      }
      for (;;)
      {
        if (paramView.length() > 0) {
          this.a.b();
        }
        return true;
        label94:
        paramView = paramKeyEvent;
        if (paramKeyEvent.endsWith("\r\n")) {
          paramView = paramKeyEvent.substring(0, paramKeyEvent.length() - 2);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfk
 * JD-Core Version:    0.7.0.1
 */