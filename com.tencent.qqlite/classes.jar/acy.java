import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;

public class acy
  implements TextWatcher
{
  public acy(ChatHistory paramChatHistory) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {}
    try
    {
      paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
      paramCharSequence = this.a;
      if (paramInt1 < this.a.jdField_b_of_type_Int)
      {
        paramCharSequence.c = paramInt1;
        if (this.a.c < this.a.jdField_b_of_type_Int) {
          break label195;
        }
        this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839125);
        if (this.a.c > 1) {
          break label221;
        }
        this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838109);
        this.a.e = ((this.a.c - 1) * 8);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.e);
      }
    }
    catch (Exception paramCharSequence)
    {
      for (;;)
      {
        paramInt1 = this.a.jdField_b_of_type_Int;
        continue;
        paramInt1 = this.a.jdField_b_of_type_Int;
        continue;
        label195:
        this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837707);
        continue;
        label221:
        this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837706);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     acy
 * JD-Core Version:    0.7.0.1
 */