import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;

public class xbi
  extends Dialog
  implements View.OnClickListener
{
  public final int a;
  public ViewGroup a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  public ClipboardEditText a;
  public String a;
  public xah a;
  public xbm a;
  public int b;
  public int c = -1;
  public int d = 1000;
  public int e;
  public int f;
  public int g;
  
  public xbi(Context paramContext)
  {
    super(paramContext, 2131755181);
    this.jdField_a_of_type_Int = 420;
    this.jdField_a_of_type_Xah = new xah();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561572, null));
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new xbo(this, null);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new xbn(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText = ((ClipboardEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377641));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setBackgroundColor(super.getContext().getResources().getColor(2131166374));
    if (wzs.jdField_a_of_type_Int > xee.b(getContext(), 14.0F)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setPadding(wzs.jdField_a_of_type_Int, xee.b(getContext(), 5.0F), wzs.jdField_a_of_type_Int, xee.b(getContext(), 5.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.requestFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setCursorVisible(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.addTextChangedListener(new xbj(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setOnTouchListener(new xbk(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setOnFocusChangeListener(new xbl(this));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setPadding(xee.b(getContext(), 14.0F), xee.b(getContext(), 5.0F), xee.b(getContext(), 14.0F), xee.b(getContext(), 5.0F));
    }
  }
  
  private void b()
  {
    Window localWindow = super.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.flags |= 0x20;
      localLayoutParams.gravity = 80;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  protected int a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getTop();
    int j = b();
    TextPaint localTextPaint = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getPaint();
    return (int)(i + j + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBaseline() + localTextPaint.ascent());
  }
  
  public int a(String paramString)
  {
    int i = 0;
    int k = 0;
    if (TextUtils.isEmpty(paramString)) {}
    int m;
    int j;
    do
    {
      return k;
      paramString = paramString.toCharArray();
      m = paramString.length;
      j = 0;
      k = i;
    } while (j >= m);
    if (bdje.c(paramString[j])) {
      i += 3;
    }
    for (;;)
    {
      j += 1;
      break;
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public void a(xah paramxah)
  {
    String str2 = paramxah.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramxah.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_JavaLangString = str1;
    this.e = paramxah.jdField_a_of_type_Int;
    this.f = paramxah.d;
    this.jdField_a_of_type_Xah.a(paramxah);
    wsv.b("EditTextDialog", "setTextInfo:" + this.jdField_a_of_type_Xah.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setTextSize(xee.c(getContext(), this.jdField_a_of_type_Xah.b));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setText(this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString);
    int j = this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString.length();
    paramxah = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText;
    int i = j;
    if (this.d < j) {
      i = this.d;
    }
    paramxah.setSelection(i);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setCursorVisible(true);
    if (this.jdField_a_of_type_Xah.c == 2) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setBackgroundColor(super.getContext().getResources().getColor(2131166374));
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
  }
  
  public void a(xbm paramxbm)
  {
    this.jdField_a_of_type_Xbm = paramxbm;
  }
  
  public void a(xea paramxea)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setClipboardCallBack(paramxea);
    }
  }
  
  protected int b()
  {
    return this.g;
  }
  
  public void onClick(View paramView)
  {
    paramView = (InputMethodManager)getContext().getSystemService("input_method");
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText != null) && (paramView.isActive())) {
      paramView.toggleSoftInput(1, 2);
    }
    super.dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Xbm == null) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_Xbm.a(false, this.jdField_a_of_type_Xah);
  }
  
  public void setContentView(int paramInt)
  {
    this.b = aekt.a(100.0F, getContext().getResources());
    b();
    a();
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbi
 * JD-Core Version:    0.7.0.1
 */