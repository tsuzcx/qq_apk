import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.view.CommonMenuPopupView.1;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.b;

public class akop
{
  public static int doa = 1;
  public static int dob = 2;
  private BubblePopupWindow.b b;
  aqoa e;
  private BubblePopupWindow g;
  private View.OnClickListener x;
  
  public void V(int paramInt1, String paramString, int paramInt2)
  {
    if (this.e == null) {
      this.e = new aqoa();
    }
    this.e.Z(paramInt1, paramString, paramInt2);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.g != null) && (this.g.isShowing()))
    {
      this.g.dismiss();
      this.g = null;
    }
    this.g = new BubblePopupWindow(-2, -2);
    this.g.setContentView(aqgq.a(this.g, paramView.getContext(), this.e, this.x, true));
    this.g.setBackgroundDrawable(new ColorDrawable(0));
    this.g.setOutsideTouchable(paramBoolean);
    if (paramBoolean) {
      this.g.setFocusable(true);
    }
    this.g.setFocusable(false);
    this.g.setOutsideTouchable(true);
    this.g.setSoftInputMode(1);
    this.g.setInputMethodMode(2);
    BubblePopupWindow localBubblePopupWindow = this.g;
    if (paramInt3 == doa) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localBubblePopupWindow.We(paramBoolean);
      this.g.a(this.b);
      paramView.post(new CommonMenuPopupView.1(this, paramView, paramInt1, paramInt2));
      return;
    }
  }
  
  public void d(View paramView, int paramInt1, int paramInt2)
  {
    b(paramView, paramInt1, paramInt2, dob, true);
  }
  
  public void dismiss()
  {
    if ((this.g != null) && (this.g.isShowing())) {
      this.g.dismiss();
    }
  }
  
  public boolean isShow()
  {
    return (this.g != null) && (this.g.isShowing());
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.x = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akop
 * JD-Core Version:    0.7.0.1
 */