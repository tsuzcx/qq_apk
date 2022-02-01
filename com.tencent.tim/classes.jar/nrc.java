import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;

public abstract class nrc
  extends PopupWindow
{
  public final String TAG = "ReadInJoyBasePopupWindow";
  private final int aMa = 0;
  protected FrameLayout as;
  private int bbr;
  private int bbs;
  public final float jg = 0.8F;
  public final float jh = 1.0F;
  protected ImageView kR;
  protected ImageView kS;
  public Activity mActivity;
  protected boolean mHasInit;
  protected View mRootView;
  private int screenHeight;
  private int screenWidth;
  
  public nrc(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
  }
  
  private void bao()
  {
    this.mRootView.measure(0, 0);
    this.bbs = this.mRootView.getMeasuredHeight();
    setHeight(this.bbs);
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "calculatePopupWindow, popupHeight = ", Integer.valueOf(this.bbs) });
  }
  
  public void aHq()
  {
    setOnDismissListener(new nrd(this));
  }
  
  public abstract View b(LayoutInflater paramLayoutInflater);
  
  protected final void dj(View paramView)
  {
    bao();
    i(0.8F);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = this.screenHeight;
    int m = arrayOfInt[1];
    int n = paramView.getHeight();
    int j = (int)this.mActivity.getResources().getDimension(2131299225);
    int k = this.bbr - (arrayOfInt[0] - j) - paramView.getWidth() / 2;
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "marginRight = ", Integer.valueOf(k) });
    if (i - (m + n) > this.bbs)
    {
      if (k > this.bbr * 0.1D) {
        setAnimationStyle(2131755042);
      }
      for (;;)
      {
        i = arrayOfInt[1] + paramView.getHeight() + aqnm.dip2px(4.0F);
        this.kR.setVisibility(0);
        this.kS.setVisibility(4);
        this.kR.setPadding(0, 0, k, 0);
        showAtLocation(paramView, 0, j, i);
        QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "x = ", Integer.valueOf(j), ", y = ", Integer.valueOf(i), ", width = ", Integer.valueOf(this.bbr), ", height = ", Integer.valueOf(this.bbs) });
        return;
        setAnimationStyle(2131755041);
      }
    }
    if (k > this.bbr * 0.1D) {
      setAnimationStyle(2131755045);
    }
    for (;;)
    {
      i = arrayOfInt[1] - this.bbs - aqnm.dip2px(4.0F);
      this.kR.setVisibility(4);
      this.kS.setVisibility(0);
      this.kS.setPadding(0, 0, k, 0);
      break;
      setAnimationStyle(2131755044);
    }
  }
  
  protected void i(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.mActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  protected void initUI()
  {
    this.screenWidth = ((int)aqgz.hK());
    this.screenHeight = ((int)aqgz.hL());
    Object localObject = (LayoutInflater)this.mActivity.getSystemService("layout_inflater");
    this.mRootView = ((LayoutInflater)localObject).inflate(2131560260, null);
    this.as = ((FrameLayout)this.mRootView.findViewById(2131365360));
    this.kR = ((ImageView)this.mRootView.findViewById(2131380181));
    this.kS = ((ImageView)this.mRootView.findViewById(2131380180));
    localObject = b((LayoutInflater)localObject);
    if (localObject != null) {
      this.as.addView((View)localObject);
    }
    setBackgroundDrawable(new ColorDrawable(0));
    this.bbr = ((int)(this.screenWidth - this.mActivity.getResources().getDimension(2131299225) * 2.0F));
    setWidth(this.bbr);
    setTouchable(true);
    setFocusable(true);
    setContentView(this.mRootView);
    aHq();
    this.mHasInit = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrc
 * JD-Core Version:    0.7.0.1
 */