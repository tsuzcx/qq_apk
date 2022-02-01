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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class rgy
  extends ReportDialog
  implements View.OnClickListener
{
  public final int MAX_TEXT_LENGTH = 420;
  public EditVideoParams a;
  public HorizontalSelectColorLayout a;
  public rgy.a a;
  public String aAz;
  public EditText ag;
  public rgm b = new rgm();
  public int brh;
  public int bri = -1;
  public int brj;
  public int brk;
  public int brl;
  public ViewTreeObserver.OnGlobalLayoutListener e;
  public TextView fd;
  public ViewGroup mRootView;
  public TextView yz;
  
  public rgy(Context paramContext)
  {
    super(paramContext, 2131755374);
  }
  
  private void bub()
  {
    Window localWindow = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = (riw.getWindowScreenHeight(getContext()) - getMarginTop());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
  }
  
  private void initView()
  {
    this.mRootView = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561829, null));
    this.e = new rgy.c(null);
    this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new rgy.b(null));
    this.ag = ((EditText)this.mRootView.findViewById(2131379497));
    this.ag.setBackgroundColor(super.getContext().getResources().getColor(2131166737));
    this.fd = ((TextView)this.mRootView.findViewById(2131379495));
    this.yz = ((TextView)this.mRootView.findViewById(2131379496));
    if (rgb.PADDING > riw.dip2px(getContext(), 14.0F)) {
      this.ag.setPadding(rgb.PADDING, riw.dip2px(getContext(), 5.0F), rgb.PADDING, riw.dip2px(getContext(), 5.0F));
    }
    for (;;)
    {
      this.ag.requestFocus();
      this.ag.setCursorVisible(false);
      this.ag.addTextChangedListener(new rgz(this));
      this.ag.setOnTouchListener(new rha(this));
      this.ag.setOnFocusChangeListener(new rhb(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)this.mRootView.findViewById(2131372322));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new rng(), false, 0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(rni.ek[1]);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new rhc(this));
      this.fd.setOnClickListener(new rhd(this));
      this.yz.setOnClickListener(new rhe(this));
      return;
      this.ag.setPadding(riw.dip2px(getContext(), 14.0F), riw.dip2px(getContext(), 5.0F), riw.dip2px(getContext(), 14.0F), riw.dip2px(getContext(), 5.0F));
    }
  }
  
  public void a(rgm paramrgm)
  {
    String str = paramrgm.text;
    if (TextUtils.isEmpty(str))
    {
      str = "";
      this.yz.setTextColor(Color.parseColor("#bbbbbb"));
      this.yz.setEnabled(false);
    }
    for (;;)
    {
      paramrgm.text = str;
      this.aAz = str;
      this.brj = paramrgm.color;
      this.brk = paramrgm.brg;
      this.b.b(paramrgm);
      ram.d("EditTextDialog", "setTextInfo:" + this.b.toString());
      this.ag.setTextSize(riw.px2sp(getContext(), this.b.size));
      this.ag.setTextColor(this.b.color);
      this.ag.setText(this.b.text);
      this.ag.setSelection(this.b.text.length());
      this.ag.setCursorVisible(true);
      if (this.b.state == 2)
      {
        this.ag.setBackgroundColor(super.getContext().getResources().getColor(2131166737));
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(this.b.color);
      }
      this.mRootView.setOnClickListener(this);
      return;
      this.yz.setTextColor(Color.parseColor("#12b7f5"));
      this.yz.setEnabled(true);
    }
  }
  
  public void a(rgy.a parama)
  {
    this.jdField_a_of_type_Rgy$a = parama;
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
    super.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Rgy$a == null) {
      return;
    }
    String str2 = this.ag.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    this.b.text = str1;
    this.jdField_a_of_type_Rgy$a.a(false, this.b);
  }
  
  public void setContentView(int paramInt)
  {
    this.brh = wja.dp2px(100.0F, getContext().getResources());
    bub();
    initView();
    super.setContentView(this.mRootView);
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  protected int tq()
  {
    int i = this.ag.getTop();
    int j = getMarginTop();
    TextPaint localTextPaint = this.ag.getPaint();
    return (int)(i + j + this.ag.getBaseline() + localTextPaint.ascent());
  }
  
  public void xn(int paramInt)
  {
    this.brl = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, rgm paramrgm);
    
    public abstract void buc();
    
    public abstract void xj(int paramInt);
    
    public abstract void xo(int paramInt);
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private b() {}
    
    public void onGlobalLayout()
    {
      int i = rgy.this.ag.getBottom();
      if (rgy.this.bri < 0)
      {
        rgy.this.bri = i;
        rgy.this.a.buc();
      }
      do
      {
        do
        {
          return;
        } while (rgy.this.bri - i <= rgy.this.brh);
        rgy.this.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        rgy.this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(rgy.this.e);
        rgy.this.bri = i;
        rgy.this.mRootView.requestLayout();
      } while (rgy.this.a == null);
      rgy.this.a.a(true, null);
      rgy.this.a.xo(rgy.this.tq());
    }
  }
  
  class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private c() {}
    
    public void onGlobalLayout()
    {
      if (rgy.this.ag.getBottom() - rgy.this.bri > rgy.this.brh)
      {
        rgy.this.dismiss();
        return;
      }
      rgy.this.a.xo(rgy.this.tq());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgy
 * JD-Core Version:    0.7.0.1
 */