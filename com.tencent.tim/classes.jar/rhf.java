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
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class rhf
  extends ReportDialog
  implements View.OnClickListener
{
  public final int MAX_TEXT_LENGTH = 420;
  public ClipboardEditText a;
  public rhf.a a;
  public String aAz;
  public rgm b = new rgm();
  public int brh;
  public int bri = -1;
  public int brj;
  public int brk;
  public int brl;
  public int brn = 1000;
  public ViewTreeObserver.OnGlobalLayoutListener e;
  public ViewGroup mRootView;
  
  public rhf(Context paramContext)
  {
    super(paramContext, 2131755375);
  }
  
  private void bub()
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
  
  private void initView()
  {
    this.mRootView = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561983, null));
    this.e = new rhf.c(null);
    this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new rhf.b(null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText = ((ClipboardEditText)this.mRootView.findViewById(2131379497));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setBackgroundColor(super.getContext().getResources().getColor(2131166737));
    if (rgb.PADDING > riw.dip2px(getContext(), 14.0F)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setPadding(rgb.PADDING, riw.dip2px(getContext(), 5.0F), rgb.PADDING, riw.dip2px(getContext(), 5.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.requestFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setCursorVisible(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.addTextChangedListener(new rhg(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setOnTouchListener(new rhh(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setOnFocusChangeListener(new rhi(this));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setPadding(riw.dip2px(getContext(), 14.0F), riw.dip2px(getContext(), 5.0F), riw.dip2px(getContext(), 14.0F), riw.dip2px(getContext(), 5.0F));
    }
  }
  
  public void a(rgm paramrgm)
  {
    String str2 = paramrgm.text;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramrgm.text = str1;
    this.aAz = str1;
    this.brj = paramrgm.color;
    this.brk = paramrgm.brg;
    this.b.b(paramrgm);
    ram.d("EditTextDialog", "setTextInfo:" + this.b.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setTextSize(riw.px2sp(getContext(), this.b.size));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setText(this.b.text);
    int j = this.b.text.length();
    paramrgm = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText;
    int i = j;
    if (this.brn < j) {
      i = this.brn;
    }
    paramrgm.setSelection(i);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setCursorVisible(true);
    if (this.b.state == 2) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setBackgroundColor(super.getContext().getResources().getColor(2131166737));
    }
    this.mRootView.setOnClickListener(this);
  }
  
  public void a(rhf.a parama)
  {
    this.jdField_a_of_type_Rhf$a = parama;
  }
  
  public int bi(String paramString)
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
    if (aqmr.isChinese(paramString[j])) {
      i += 3;
    }
    for (;;)
    {
      j += 1;
      break;
      i += 1;
    }
  }
  
  protected int getMarginTop()
  {
    return this.brl;
  }
  
  public void onClick(View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText != null) && (localInputMethodManager.isActive())) {
      localInputMethodManager.toggleSoftInput(1, 2);
    }
    super.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Rhf$a == null) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    this.b.text = str1;
    this.jdField_a_of_type_Rhf$a.a(false, this.b);
  }
  
  public void setClipboardCallBack(ClipboardEditText.a parama)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setClipboardCallBack(parama);
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.brh = wja.dp2px(100.0F, getContext().getResources());
    bub();
    initView();
    super.setContentView(this.mRootView);
  }
  
  public void setMaxTextLength(int paramInt)
  {
    this.brn = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  protected int tq()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getTop();
    int j = getMarginTop();
    TextPaint localTextPaint = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getPaint();
    return (int)(i + j + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBaseline() + localTextPaint.ascent());
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, rgm paramrgm);
    
    public abstract void buc();
    
    public abstract void c(rgm paramrgm);
    
    public abstract void xj(int paramInt);
    
    public abstract void xo(int paramInt);
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private b() {}
    
    public void onGlobalLayout()
    {
      int i = rhf.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBottom();
      if (rhf.this.bri < 0)
      {
        rhf.this.bri = i;
        rhf.this.jdField_a_of_type_Rhf$a.buc();
      }
      do
      {
        do
        {
          return;
        } while (rhf.this.bri - i <= rhf.this.brh);
        rhf.this.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        rhf.this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(rhf.this.e);
        rhf.this.bri = i;
        rhf.this.mRootView.requestLayout();
      } while (rhf.this.jdField_a_of_type_Rhf$a == null);
      rhf.this.jdField_a_of_type_Rhf$a.a(true, null);
      rhf.this.jdField_a_of_type_Rhf$a.xo(rhf.this.tq());
    }
  }
  
  class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private c() {}
    
    public void onGlobalLayout()
    {
      if (rhf.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBottom() - rhf.this.bri > rhf.this.brh)
      {
        rhf.this.dismiss();
        return;
      }
      rhf.this.jdField_a_of_type_Rhf$a.xo(rhf.this.tq());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhf
 * JD-Core Version:    0.7.0.1
 */