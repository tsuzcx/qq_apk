import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar.a;
import java.util.ArrayList;
import java.util.List;

public class sop
  extends sor
{
  private int RX;
  protected CustomMenuBar.a a;
  private ViewGroup cF;
  private List<soo> dK = new ArrayList();
  private int mAnimStyle;
  private ImageView mArrowDown;
  private LayoutInflater mInflater;
  
  public sop(Context paramContext)
  {
    super(paramContext);
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    hL(2131559308);
    this.mAnimStyle = 4;
    this.RX = 0;
  }
  
  private void f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mArrowDown.getMeasuredWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mArrowDown.getLayoutParams();
    if (paramInt3 > paramInt1)
    {
      if (paramInt3 > paramInt2 * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 - i / 2);
        return;
      }
      if (paramInt3 > (paramInt4 - paramInt2) * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 + paramInt3 - paramInt4 - i / 2);
        return;
      }
      localLayoutParams.addRule(14);
      return;
    }
    localLayoutParams.addRule(14);
  }
  
  private void n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (this.mAnimStyle)
    {
    default: 
      return;
    }
    this.mWindow.setAnimationStyle(2131755066);
  }
  
  public void aO(View paramView)
  {
    preShow();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    this.mRootView.measure(-2, -2);
    int i = this.mRootView.getMeasuredWidth();
    int j = this.mRootView.getMeasuredHeight();
    int k = this.mWindowManager.getDefaultDisplay().getWidth();
    int m = arrayOfInt[0];
    int n = (paramView.getWidth() - i) / 2;
    int i1 = localRect.top;
    f(paramView.getWidth(), localRect.centerX(), i, k);
    n(k, localRect.centerX(), true);
    this.mWindow.showAtLocation(paramView, 0, m + n, i1 - j - 10);
  }
  
  public void c(soo paramsoo)
  {
    this.dK.add(paramsoo);
    String str = paramsoo.getTitle();
    Drawable localDrawable = paramsoo.getIcon();
    if (this.RX != 0)
    {
      localObject1 = new ImageView(this.mContext);
      ((ImageView)localObject1).setBackgroundResource(2130840189);
      localObject2 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      ((LinearLayout.LayoutParams)localObject2).setMargins(wja.dp2px(15.0F, ((ImageView)localObject1).getResources()), 0, wja.dp2px(15.0F, ((ImageView)localObject1).getResources()), 0);
      this.cF.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    Object localObject1 = this.mInflater.inflate(2131559307, null);
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131371289);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131371301);
    if (localDrawable != null)
    {
      ((ImageView)localObject2).setImageDrawable(localDrawable);
      if (str == null) {
        break label267;
      }
      if (jqn.aC(str) <= 18) {
        break label258;
      }
      localTextView.setText(jqn.c(str, 18, "..."));
    }
    for (;;)
    {
      ((View)localObject1).setOnClickListener(new soq(this, paramsoo.eo(), paramsoo.hF()));
      ((View)localObject1).setFocusable(true);
      ((View)localObject1).setClickable(true);
      paramsoo = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      paramsoo.gravity = 17;
      ((View)localObject1).setLayoutParams(paramsoo);
      this.cF.addView((View)localObject1);
      this.RX += 1;
      return;
      ((ImageView)localObject2).setVisibility(8);
      break;
      label258:
      localTextView.setText(str);
      continue;
      label267:
      localTextView.setVisibility(8);
    }
  }
  
  public void hL(int paramInt)
  {
    this.mRootView = ((ViewGroup)this.mInflater.inflate(paramInt, null));
    this.cF = ((ViewGroup)this.mRootView.findViewById(2131371283));
    this.mArrowDown = ((ImageView)this.mRootView.findViewById(2131362986));
    this.mRootView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    super.setContentView(this.mRootView);
  }
  
  public void setOnMenuItemClickListener(CustomMenuBar.a parama)
  {
    this.a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sop
 * JD-Core Version:    0.7.0.1
 */