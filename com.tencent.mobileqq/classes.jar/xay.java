import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
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
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class xay
  extends Dialog
  implements View.OnClickListener
{
  public final int a;
  public ViewGroup a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  public EditText a;
  public TextView a;
  public EditVideoParams a;
  public HorizontalSelectColorLayout a;
  public String a;
  public xah a;
  public xbf a;
  public int b;
  public TextView b;
  public int c = -1;
  public int d;
  public int e;
  public int f;
  
  public xay(Context paramContext)
  {
    super(paramContext, 2131755180);
    this.jdField_a_of_type_Int = 420;
    this.jdField_a_of_type_Xah = new xah();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561418, null));
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new xbh(this, null);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new xbg(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377641));
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(super.getContext().getResources().getColor(2131166374));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377639));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377640));
    if (wzs.jdField_a_of_type_Int > xee.b(getContext(), 14.0F)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setPadding(wzs.jdField_a_of_type_Int, xee.b(getContext(), 5.0F), wzs.jdField_a_of_type_Int, xee.b(getContext(), 5.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new xaz(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new xba(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new xbb(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371081));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new xkj(), false, 0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(xkl.a[1]);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new xbc(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new xbd(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new xbe(this));
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setPadding(xee.b(getContext(), 14.0F), xee.b(getContext(), 5.0F), xee.b(getContext(), 14.0F), xee.b(getContext(), 5.0F));
    }
  }
  
  private void b()
  {
    Window localWindow = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = (xee.b(getContext()) - b());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
  }
  
  protected int a()
  {
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getTop();
    int j = b();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    return (int)(i + j + this.jdField_a_of_type_AndroidWidgetEditText.getBaseline() + localTextPaint.ascent());
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
    this.f = paramInt;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(xah paramxah)
  {
    String str = paramxah.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      str = "";
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    for (;;)
    {
      paramxah.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_JavaLangString = str;
      this.d = paramxah.jdField_a_of_type_Int;
      this.e = paramxah.d;
      this.jdField_a_of_type_Xah.a(paramxah);
      wsv.b("EditTextDialog", "setTextInfo:" + this.jdField_a_of_type_Xah.toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(xee.c(getContext(), this.jdField_a_of_type_Xah.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_Xah.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString.length());
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      if (this.jdField_a_of_type_Xah.c == 2)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(super.getContext().getResources().getColor(2131166374));
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(this.jdField_a_of_type_Xah.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12b7f5"));
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
    }
  }
  
  public void a(xbf paramxbf)
  {
    this.jdField_a_of_type_Xbf = paramxbf;
  }
  
  protected int b()
  {
    return this.f;
  }
  
  public void onClick(View paramView)
  {
    super.dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Xbf == null) {
      return;
    }
    String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_Xbf.a(false, this.jdField_a_of_type_Xah);
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_b_of_type_Int = aekt.a(100.0F, getContext().getResources());
    b();
    a();
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xay
 * JD-Core Version:    0.7.0.1
 */