import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.widget.textview.RichTextParser;
import com.tencent.biz.subscribe.widget.textview.RichTextParser.RichSpannableStringBuilder;
import com.tencent.biz.subscribe.widget.textview.RichTextParser.TextImageSpanConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class zhm
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  zhm(zhf paramzhf) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    RichTextParser.TextImageSpanConfig localTextImageSpanConfig = null;
    if (paramEditable == null) {
      return;
    }
    this.jdField_a_of_type_Zhf.a.removeTextChangedListener(this);
    String str = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = str.indexOf('/');
    Object localObject = localTextImageSpanConfig;
    if (i >= 0)
    {
      localObject = localTextImageSpanConfig;
      if (i < str.length() - 1)
      {
        localObject = new RichTextParser.RichSpannableStringBuilder(paramEditable.toString());
        localTextImageSpanConfig = new RichTextParser.TextImageSpanConfig();
        localTextImageSpanConfig.iconSize = ((int)(22.0D * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5D));
        localTextImageSpanConfig.verticalAlignment = 0;
        localTextImageSpanConfig.oldText = paramEditable.toString();
        RichTextParser.asyncParseSmiley(localTextImageSpanConfig, str, null, (RichTextParser.RichSpannableStringBuilder)localObject, null, false);
      }
    }
    if (localObject != null) {
      i = this.jdField_a_of_type_Zhf.a.getSelectionEnd();
    }
    try
    {
      this.jdField_a_of_type_Zhf.a.setText((CharSequence)localObject);
      this.jdField_a_of_type_Zhf.a.setSelection(i);
      this.b = 0;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Zhf.a.addTextChangedListener(this);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Zhf.a.setText(paramEditable.toString());
        i = paramEditable.toString().length();
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhm
 * JD-Core Version:    0.7.0.1
 */