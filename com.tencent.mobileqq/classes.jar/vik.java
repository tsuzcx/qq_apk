import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class vik
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  vik(vih paramvih) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    aanc localaanc = null;
    if (paramEditable == null) {
      return;
    }
    this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.removeTextChangedListener(this);
    for (;;)
    {
      Object localObject;
      try
      {
        int j = QzoneConfig.getQQCircleCommentMaxWordsLimit();
        if (vih.a(this.jdField_a_of_type_Vih) != null) {
          break label301;
        }
        i = 0;
        if (i >= j)
        {
          this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramEditable.toString().substring(0, i));
          this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setSelection(this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText().toString().length());
          this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(this);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        String str = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
        i = str.indexOf('/');
        localObject = localaanc;
        if (i >= 0)
        {
          localObject = localaanc;
          if (i < str.length() - 1)
          {
            localObject = new aanb(paramEditable.toString());
            localaanc = new aanc();
            localaanc.jdField_a_of_type_Float = ((int)(22.0D * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5D));
            localaanc.jdField_a_of_type_Int = 0;
            localaanc.jdField_a_of_type_JavaLangCharSequence = paramEditable.toString();
            aana.a(localaanc, str, null, (aanb)localObject, false);
          }
        }
        if (localObject == null) {
          break label272;
        }
      }
      int i = this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getSelectionEnd();
      try
      {
        this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText((CharSequence)localObject);
        this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setSelection(i);
        label272:
        this.b = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(this);
        vih.b(this.jdField_a_of_type_Vih);
        return;
        label301:
        i = Integer.parseInt(vih.a(this.jdField_a_of_type_Vih).getText().toString());
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Vih.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramEditable.toString());
          i = paramEditable.toString().length();
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    if ((this.jdField_a_of_type_Vih.jdField_a_of_type_Boolean) && (paramInt3 == 1) && (paramInt2 == 0))
    {
      if (!paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@")) {
        break label87;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCircleBaseInputPopupWindow", 2, "输入@呼起好友选择器");
      }
      this.jdField_a_of_type_Vih.c = true;
      this.jdField_a_of_type_Vih.f();
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt3;
      return;
      label87:
      this.jdField_a_of_type_Vih.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vik
 * JD-Core Version:    0.7.0.1
 */