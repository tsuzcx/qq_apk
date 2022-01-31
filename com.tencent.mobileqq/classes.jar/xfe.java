import android.content.Context;
import android.content.Intent;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgChatState;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.widget.FormEditItem;

public class xfe
  extends xfd
{
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new xff(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private EditText b;
  
  public xfe(GoldMsgSettingActivity paramGoldMsgSettingActivity, Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramGoldMsgSettingActivity, paramContext, paramIntent, paramString1, paramString2, paramString3, paramInt);
  }
  
  void a(View paramView)
  {
    Object localObject = (FormEditItem)paramView.findViewById(2131364770);
    paramView = (FormEditItem)paramView.findViewById(2131364771);
    this.jdField_a_of_type_AndroidWidgetEditText = ((FormEditItem)localObject).a();
    this.b = paramView.a();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.b.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(8194);
    this.b.setInputType(2);
    paramView = GoldMsgChatHelper.a().a(this.jdField_a_of_type_Int, this.c);
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(NumAnim.formatNumber(paramView.b / 100.0D, false));
      localObject = paramView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener((TextWatcher)localObject);
      localObject = paramView.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
      this.b.setText(String.valueOf(paramView.c));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener((TextWatcher)localObject);
    }
  }
  
  boolean a()
  {
    return GoldMsgChatHelper.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.d, this.c, this.jdField_a_of_type_AndroidWidgetEditText, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfe
 * JD-Core Version:    0.7.0.1
 */