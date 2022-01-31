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

public class uzx
  extends Dialog
  implements View.OnClickListener
{
  public final int a;
  public ViewGroup a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  public ClipboardEditText a;
  public String a;
  public uyw a;
  public vab a;
  public int b;
  public int c = -1;
  public int d = 1000;
  public int e;
  public int f;
  public int g;
  
  public uzx(Context paramContext)
  {
    super(paramContext, 2131689641);
    this.jdField_a_of_type_Int = 420;
    this.jdField_a_of_type_Uyw = new uyw();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131495792, null));
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new vad(this, null);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new vac(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText = ((ClipboardEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311306));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setBackgroundColor(super.getContext().getResources().getColor(2131100735));
    if (uyh.jdField_a_of_type_Int > vct.a(getContext(), 14.0F)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setPadding(uyh.jdField_a_of_type_Int, vct.a(getContext(), 5.0F), uyh.jdField_a_of_type_Int, vct.a(getContext(), 5.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.requestFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setCursorVisible(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.addTextChangedListener(new uzy(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setOnTouchListener(new uzz(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setOnFocusChangeListener(new vaa(this));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setPadding(vct.a(getContext(), 14.0F), vct.a(getContext(), 5.0F), vct.a(getContext(), 14.0F), vct.a(getContext(), 5.0F));
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
    if (baip.c(paramString[j])) {
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
  
  public void a(uyw paramuyw)
  {
    String str2 = paramuyw.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramuyw.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_JavaLangString = str1;
    this.e = paramuyw.jdField_a_of_type_Int;
    this.f = paramuyw.d;
    this.jdField_a_of_type_Uyw.a(paramuyw);
    urk.b("EditTextDialog", "setTextInfo:" + this.jdField_a_of_type_Uyw.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setTextSize(vct.b(getContext(), this.jdField_a_of_type_Uyw.b));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setText(this.jdField_a_of_type_Uyw.jdField_a_of_type_JavaLangString);
    int j = this.jdField_a_of_type_Uyw.jdField_a_of_type_JavaLangString.length();
    paramuyw = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText;
    int i = j;
    if (this.d < j) {
      i = this.d;
    }
    paramuyw.setSelection(i);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setCursorVisible(true);
    if (this.jdField_a_of_type_Uyw.c == 2) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setBackgroundColor(super.getContext().getResources().getColor(2131100735));
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
  }
  
  public void a(vab paramvab)
  {
    this.jdField_a_of_type_Vab = paramvab;
  }
  
  public void a(vcp paramvcp)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setClipboardCallBack(paramvcp);
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
    if (this.jdField_a_of_type_Vab == null) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    this.jdField_a_of_type_Uyw.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_Vab.a(false, this.jdField_a_of_type_Uyw);
  }
  
  public void setContentView(int paramInt)
  {
    this.b = aciy.a(100.0F, getContext().getResources());
    b();
    a();
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzx
 * JD-Core Version:    0.7.0.1
 */