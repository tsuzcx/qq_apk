import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class ayld
  implements TextWatcher
{
  ayld(aykw paramaykw) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.jdField_a_of_type_Aykw$a == null) {}
    axvb localaxvb;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        aykw.a(this.this$0, true);
        if (this.this$0.b != null) {
          this.this$0.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.this$0.b.Rw(), paramCharSequence.toString());
        }
      } while (!(this.this$0.b instanceof axvb));
      localaxvb = (axvb)this.this$0.b;
      if ((localaxvb.uj(paramCharSequence.toString())) && (paramInt3 != 0) && ((aykw.a(this.this$0) == null) || (!aykw.a(this.this$0).isShowing())))
      {
        aykw.a(this.this$0, QQToast.a(this.this$0.getContext(), acfp.m(2131705478), 0));
        aykw.a(this.this$0).show();
      }
    } while ((this.this$0.b.getHeight() == aykw.a(this.this$0)) || (localaxvb.getLineCount() == aykw.b(this.this$0)));
    if ((this.this$0.b.getHeight() > aykw.b(this.this$0)) && (aykw.b(this.this$0) < localaxvb.getLineCount()))
    {
      boolean bool = localaxvb.a(aykw.a(this.this$0), paramCharSequence.toString(), aykw.b(this.this$0), aykw.c(this.this$0));
      aykw.a(this.this$0, localaxvb.getTextSize());
      aykw.a(this.this$0);
      if ((bool) && ((aykw.a(this.this$0) == null) || (!aykw.a(this.this$0).isShowing())))
      {
        aykw.a(this.this$0, QQToast.a(this.this$0.getContext(), acfp.m(2131705477), 0));
        aykw.a(this.this$0).show();
      }
    }
    for (;;)
    {
      aykw.a(this.this$0, this.this$0.b.getHeight());
      aykw.b(this.this$0, localaxvb.getLineCount());
      return;
      if ((this.this$0.b.getHeight() < aykw.b(this.this$0)) && (aykw.c(this.this$0) < axvb.TEXT_SIZE) && (aykw.b(this.this$0) > localaxvb.getLineCount()))
      {
        aykw.a(this.this$0, localaxvb.a(aykw.a(this.this$0), paramCharSequence.toString(), aykw.b(this.this$0), aykw.c(this.this$0)));
        aykw.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayld
 * JD-Core Version:    0.7.0.1
 */