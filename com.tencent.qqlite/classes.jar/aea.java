import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.statistics.ReportController;

public class aea
  extends ClickableSpan
{
  public aea(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_JavaLangString));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, "CliOper", "", this.b, "0X8004937", "0X8004937", 0, 0, "", "", "", "");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16732929);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aea
 * JD-Core Version:    0.7.0.1
 */