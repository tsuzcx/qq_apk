import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.widget.ListView;

public class epu
  extends Dialog
  implements TextWatcher, View.OnClickListener, View.OnTouchListener
{
  private View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ept jdField_a_of_type_Ept;
  
  public epu(CountryActivity paramCountryActivity, Context paramContext)
  {
    super(paramContext, 2131624528);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2130903147);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131233085));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    paramContext = (Button)findViewById(2131233084);
    paramContext.setVisibility(0);
    paramContext.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231401);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231403));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562494);
    findViewById(2131231404).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131231402));
    this.jdField_a_of_type_Ept = new ept(paramCountryActivity, null);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ept);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(this);
  }
  
  void a(String paramString)
  {
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Ept.a(paramString);
    if (this.jdField_a_of_type_Ept.getCount() == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ept.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    a(paramEditable);
    if (paramEditable.equals(""))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131233085: 
    default: 
      return;
    case 2131233084: 
      dismiss();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epu
 * JD-Core Version:    0.7.0.1
 */