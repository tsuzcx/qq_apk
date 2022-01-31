import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class aie
  implements TextWatcher
{
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  public boolean a;
  int b;
  public boolean b;
  int c;
  
  public aie(DetailProfileActivity paramDetailProfileActivity, int paramInt, EditText paramEditText)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject1 = str1;
    Object localObject3;
    String str3;
    String str2;
    Object localObject2;
    if (str1.getBytes().length > this.jdField_a_of_type_Int)
    {
      localObject3 = "";
      str3 = "";
      localObject1 = "";
      str2 = str1;
      paramEditable = (Editable)localObject1;
      localObject2 = str3;
    }
    try
    {
      String str4 = str1.substring(0, this.jdField_b_of_type_Int);
      str2 = str1;
      paramEditable = (Editable)localObject1;
      localObject2 = str3;
      localObject3 = str4;
      String str5 = str1.substring(this.jdField_b_of_type_Int + this.c, str1.length());
      str2 = str1;
      paramEditable = (Editable)localObject1;
      localObject2 = str5;
      localObject3 = str4;
      str3 = str1.substring(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int + this.c);
      localObject1 = str1;
      str2 = str1;
      paramEditable = str3;
      localObject2 = str5;
      localObject3 = str4;
      if (str4.getBytes().length + str5.getBytes().length <= this.jdField_a_of_type_Int)
      {
        localObject1 = str3;
        for (;;)
        {
          str2 = str1;
          paramEditable = (Editable)localObject1;
          localObject2 = str5;
          localObject3 = str4;
          if (str1.getBytes().length <= this.jdField_a_of_type_Int) {
            break;
          }
          str2 = str1;
          paramEditable = (Editable)localObject1;
          localObject2 = str5;
          localObject3 = str4;
          if (((String)localObject1).length() <= 0) {
            break;
          }
          str2 = str1;
          paramEditable = (Editable)localObject1;
          localObject2 = str5;
          localObject3 = str4;
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          str2 = str1;
          paramEditable = (Editable)localObject1;
          localObject2 = str5;
          localObject3 = str4;
          str1 = str4 + (String)localObject1 + str5;
        }
        str2 = str1;
        paramEditable = (Editable)localObject1;
        localObject2 = str5;
        localObject3 = str4;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
        str2 = str1;
        paramEditable = (Editable)localObject1;
        localObject2 = str5;
        localObject3 = str4;
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str4.length() + ((String)localObject1).length());
        localObject1 = str1;
      }
    }
    catch (Throwable localThrowable)
    {
      label470:
      do
      {
        for (;;)
        {
          localObject1 = str2;
          if (QLog.isColorLevel())
          {
            QLog.d("DetailProfileActivity", 2, "afterTextChanged, headStr:" + (String)localObject3 + ", tailStr = " + (String)localObject2 + ", insert = " + paramEditable, localThrowable);
            localObject1 = str2;
            continue;
            this.jdField_b_of_type_Boolean = true;
            DetailProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity, true);
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetEditText == DetailProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.a(DetailProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity), DetailProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity), this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.getString(2131364463), (String)localObject1);
          return;
        }
        if (this.jdField_a_of_type_AndroidWidgetEditText == DetailProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.a(DetailProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity), DetailProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity), this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.getString(2131364465), (String)localObject1);
          return;
        }
      } while (this.jdField_a_of_type_AndroidWidgetEditText != DetailProfileActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity));
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.a(DetailProfileActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity), DetailProfileActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity), this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.getString(2131364471), (String)localObject1);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetEditText != DetailProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity)) {
        break label470;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.a(DetailProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity), DetailProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity), this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.getString(2131364453), (String)localObject1);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aie
 * JD-Core Version:    0.7.0.1
 */