import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.widgets.KandianTextView;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.1;
import java.lang.ref.WeakReference;

public class auvw
  extends PopupWindow
{
  private ImageView Hr;
  private FrameLayout cv;
  private int evh;
  private int evi;
  private int evj;
  private int evk;
  private int evl;
  private Drawable gQ;
  private Drawable gR;
  private Handler handler = new auvw.c();
  private int mAlignMode = 81;
  private LinearLayout mContainer;
  private int position;
  
  public auvw(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, -2, paramInt2);
  }
  
  public auvw(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    if (paramInt1 < 0) {
      throw new RuntimeException("You must specify the window width explicitly(do not use WRAP_CONTENT or MATCH_PARENT)!!!");
    }
    this.position = paramInt3;
    this.mContainer = new LinearLayout(paramContext);
    this.mContainer.setPadding(0, 0, 0, 0);
    this.mContainer.setOrientation(1);
    this.Hr = new ImageView(paramContext);
    this.cv = new FrameLayout(paramContext);
    setBackgroundDrawable(new ColorDrawable());
    setOutsideTouchable(true);
    setFocusable(false);
  }
  
  private void A(ImageView paramImageView)
  {
    Rect localRect = new Rect(0, 0, paramImageView.getDrawable().getIntrinsicWidth(), paramImageView.getDrawable().getIntrinsicHeight());
    Matrix localMatrix = new Matrix();
    paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    localMatrix.postRotate(180.0F, localRect.width() / 2, localRect.height() / 2);
    paramImageView.setImageMatrix(localMatrix);
  }
  
  private void K(View paramView, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        i = aqcx.dip2px(paramView.getContext(), 300.0F);
        int j = aqcx.dip2px(paramView.getContext(), 120.0F);
        this.cv.measure(i, j);
        this.evi = aqcx.dip2px(paramView.getContext(), this.evi);
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        j = localRect.right - localRect.left;
        int m = localRect.bottom - localRect.top;
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        float f1;
        int n;
        int i2;
        int k;
        if ((this.position == 51) || (this.position == 52))
        {
          i = this.Hr.getDrawable().getIntrinsicWidth();
          setWidth(getWidth() + i);
          if (this.position == 51)
          {
            i = (i + this.cv.getMeasuredWidth()) * -1 - this.evi;
            if (this.mAlignMode == 83)
            {
              f1 = (localRect.centerY() - arrayOfInt[1]) / m;
              paramInt2 = (int)((paramView.getHeight() + this.cv.getMeasuredHeight()) / 2 - f1 * this.cv.getMeasuredWidth() / 2.0F) * -1;
              paramInt1 = i;
              n = arrayOfInt[0] + paramInt1;
              i2 = getWidth();
              int i1 = arrayOfInt[1] + paramInt2;
              int i3 = i1 + this.cv.getMeasuredHeight();
              k = 0;
              i = 0;
              if ((this.position != 51) && (this.position != 52)) {
                continue;
              }
              if (i3 > m - this.evh) {
                i = i3 - (m - this.evh);
              }
              j = paramInt1;
              if (i1 < localRect.top + this.evh)
              {
                i = localRect.top + this.evh - i1;
                j = paramInt1;
              }
              N(paramView, j, i);
              ram.b("CalloutPopupWindow.VASH", "show tips xoff=%d, yAnchorOff=%d, yoff=%d", Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt2));
              super.showAsDropDown(paramView, j, i + paramInt2);
              if (this.evj <= 0) {
                break;
              }
              this.handler.sendMessageDelayed(this.handler.obtainMessage(1, new WeakReference(this)), this.evj * 1000);
            }
          }
          else
          {
            if (this.position != 52) {
              break label741;
            }
            paramInt1 = paramView.getWidth();
            i = this.evi + (i + paramInt1);
            continue;
          }
          paramInt1 = i;
          if (this.mAlignMode != 82) {
            continue;
          }
          paramInt2 = (paramView.getHeight() + this.cv.getMeasuredHeight()) * -1 / 2;
          paramInt1 = i;
          continue;
        }
        else
        {
          i = this.Hr.getDrawable().getIntrinsicHeight();
          if (this.position == 49)
          {
            paramInt2 = (i + (this.cv.getMeasuredHeight() + paramView.getHeight())) * -1 - this.evi;
            if (this.mAlignMode == 83)
            {
              f1 = (localRect.centerX() - arrayOfInt[0]) / j;
              float f2 = (paramView.getWidth() - getWidth()) / 2;
              paramInt1 = (int)(f1 * getWidth() / 2.0F + f2);
            }
          }
          else
          {
            if (this.position != 50) {
              continue;
            }
            paramInt2 = this.evi;
            continue;
          }
          if (this.mAlignMode != 82) {
            break label738;
          }
          paramInt1 = (paramView.getWidth() - getWidth()) / 2;
          continue;
        }
        if (n + i2 > j - this.evh) {
          paramInt1 = j - this.evh - getWidth() - arrayOfInt[0];
        }
        i = k;
        j = paramInt1;
        if (n >= localRect.left + this.evh) {
          continue;
        }
        paramInt1 = localRect.left;
        i = this.evh;
        j = arrayOfInt[0];
        j = paramInt1 + i - j;
        i = k;
        continue;
        continue;
      }
      catch (Exception paramView)
      {
        Log.e("CalloutPopupWindow", "[showInternal] failed to show window", paramView);
        return;
      }
      label738:
      label741:
      int i = paramInt1;
    }
  }
  
  private void N(View paramView, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.Hr.getDrawable();
    if ((this.position == 51) || (this.position == 52))
    {
      paramInt1 = this.cv.getMeasuredHeight();
      i = localDrawable.getIntrinsicHeight();
      this.Hr.setPadding(0, (paramInt1 - i) / 2 - paramInt2, 0, 0);
      return;
    }
    paramInt2 = paramView.getWidth();
    int i = localDrawable.getIntrinsicWidth();
    this.Hr.setPadding((paramInt2 - i) / 2 - paramInt1, 0, 0, 0);
  }
  
  public static auvw.a a(Context paramContext)
  {
    return new auvw.a(paramContext, null);
  }
  
  public void J(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView.getWidth() == 0) && (paramView.getVisibility() == 0))
    {
      this.handler.post(new CalloutPopupWindow.1(this, paramView, paramInt1, paramInt2));
      return;
    }
    K(paramView, paramInt1, paramInt2);
  }
  
  public void L(View paramView, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        i = aqcx.dip2px(paramView.getContext(), 300.0F);
        int j = aqcx.dip2px(paramView.getContext(), 120.0F);
        this.cv.measure(i, j);
        this.evi = aqcx.dip2px(paramView.getContext(), this.evi);
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        j = localRect.right - localRect.left;
        int m = localRect.bottom - localRect.top;
        int[] arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        float f1;
        int n;
        int i2;
        int k;
        if ((this.position == 51) || (this.position == 52))
        {
          i = this.Hr.getDrawable().getIntrinsicWidth();
          setWidth(getWidth() + i);
          if (this.position == 51)
          {
            i = (i + this.cv.getMeasuredWidth()) * -1 - this.evi;
            if (this.mAlignMode == 83)
            {
              f1 = (localRect.centerY() - arrayOfInt[1]) / m;
              paramInt2 = (int)((paramView.getHeight() + this.cv.getMeasuredHeight()) / 2 - f1 * this.cv.getMeasuredWidth() / 2.0F) * -1;
              paramInt1 = i;
              n = arrayOfInt[0] + paramInt1;
              i2 = getWidth();
              int i1 = arrayOfInt[1] + paramInt2;
              int i3 = i1 + this.cv.getMeasuredHeight();
              k = 0;
              i = 0;
              if ((this.position != 51) && (this.position != 52)) {
                continue;
              }
              if (i3 > m - this.evh) {
                i = i3 - (m - this.evh);
              }
              j = paramInt1;
              if (i1 < localRect.top + this.evh)
              {
                i = localRect.top + this.evh - i1;
                j = paramInt1;
              }
              N(paramView, j, i);
              super.showAtLocation(paramView, 51, n, i + (arrayOfInt[1] + paramInt2) + paramView.getHeight());
              if (this.evj <= 0) {
                break;
              }
              this.handler.sendMessageDelayed(this.handler.obtainMessage(1, new WeakReference(this)), this.evj * 1000);
            }
          }
          else
          {
            if (this.position != 52) {
              break label732;
            }
            paramInt1 = paramView.getWidth();
            i = this.evi + (i + paramInt1);
            continue;
          }
          paramInt1 = i;
          if (this.mAlignMode != 82) {
            continue;
          }
          paramInt2 = (paramView.getHeight() + this.cv.getMeasuredHeight()) * -1 / 2;
          paramInt1 = i;
          continue;
        }
        else
        {
          i = this.Hr.getDrawable().getIntrinsicHeight();
          if (this.position == 49)
          {
            paramInt2 = (i + (this.cv.getMeasuredHeight() + paramView.getHeight())) * -1 - this.evi;
            if (this.mAlignMode == 83)
            {
              f1 = (localRect.centerX() - arrayOfInt[0]) / j;
              float f2 = (paramView.getWidth() - getWidth()) / 2;
              paramInt1 = (int)(f1 * getWidth() / 2.0F + f2);
            }
          }
          else
          {
            if (this.position != 50) {
              continue;
            }
            paramInt2 = this.evi;
            continue;
          }
          if (this.mAlignMode != 82) {
            break label729;
          }
          paramInt1 = (paramView.getWidth() - getWidth()) / 2;
          continue;
        }
        if (n + i2 > j - this.evh) {
          paramInt1 = j - this.evh - getWidth() - arrayOfInt[0];
        }
        i = k;
        j = paramInt1;
        if (n >= localRect.left + this.evh) {
          continue;
        }
        paramInt1 = localRect.left;
        i = this.evh;
        j = arrayOfInt[0];
        j = paramInt1 + i - j;
        i = k;
        continue;
        continue;
      }
      catch (Exception paramView)
      {
        Log.e("CalloutPopupWindow", "[showInternal] failed to show window", paramView);
        return;
      }
      label729:
      label732:
      int i = paramInt1;
    }
  }
  
  public void M(View paramView, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = 0;
    int j = 0;
    int m = 0;
    label772:
    label783:
    for (;;)
    {
      try
      {
        int n = aqcx.dip2px(paramView.getContext(), 300.0F);
        int i1 = aqcx.dip2px(paramView.getContext(), 120.0F);
        this.cv.measure(n, i1);
        this.evi = aqcx.dip2px(paramView.getContext(), this.evi);
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        i1 = localRect.right - localRect.left;
        int i2 = localRect.bottom - localRect.top;
        int[] arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        float f1;
        int i3;
        if ((this.position == 51) || (this.position == 52))
        {
          k = this.Hr.getDrawable().getIntrinsicWidth();
          setWidth(getWidth() + k);
          if (this.position == 51)
          {
            i = (this.cv.getMeasuredWidth() + k) * -1 - this.evi;
            if (this.mAlignMode == 83)
            {
              f1 = (localRect.centerY() - arrayOfInt[1]) / i2;
              j = (int)((paramView.getHeight() + this.cv.getMeasuredHeight()) / 2 - f1 * this.cv.getMeasuredWidth() / 2.0F) * -1;
              break label783;
              i3 = arrayOfInt[0] + i;
              m = getWidth();
              int i4 = arrayOfInt[1] + j;
              int i5 = i4 + this.cv.getMeasuredHeight();
              n = 0;
              k = 0;
              if ((this.position != 51) && (this.position != 52)) {
                continue;
              }
              if (i5 > i2 - this.evh) {
                k = i5 - (i2 - this.evh);
              }
              m = i;
              if (i4 < localRect.top + this.evh)
              {
                k = localRect.top + this.evh - i4;
                m = i;
              }
              N(paramView, m, k);
              super.showAtLocation(paramView, 51, m + paramInt1, k + (j + arrayOfInt[1]) + paramView.getHeight() + paramInt2);
              if (this.evj <= 0) {
                break;
              }
              this.handler.sendMessageDelayed(this.handler.obtainMessage(1, new WeakReference(this)), this.evj * 1000);
            }
          }
          else
          {
            if (this.position != 52) {
              continue;
            }
            i = paramView.getWidth() + k + this.evi;
            continue;
          }
          if (this.mAlignMode != 82) {
            break label783;
          }
          j = (paramView.getHeight() + this.cv.getMeasuredHeight()) * -1 / 2;
          break label783;
        }
        else
        {
          i = this.Hr.getDrawable().getIntrinsicHeight();
          if (this.position == 49)
          {
            i = (this.cv.getMeasuredHeight() + paramView.getHeight() + i) * -1 - this.evi;
            if (this.mAlignMode == 83)
            {
              f1 = (localRect.centerX() - arrayOfInt[0]) / i1;
              float f2 = (paramView.getWidth() - getWidth()) / 2;
              k = (int)(f1 * getWidth() / 2.0F + f2);
              j = i;
              i = k;
            }
          }
          else
          {
            i = m;
            if (this.position != 50) {
              continue;
            }
            i = this.evi;
            continue;
          }
          if (this.mAlignMode != 82) {
            break label772;
          }
          k = (paramView.getWidth() - getWidth()) / 2;
          j = i;
          i = k;
          continue;
        }
        if (i3 + m > i1 - this.evh) {
          i = i1 - this.evh - getWidth() - arrayOfInt[0];
        }
        k = n;
        m = i;
        if (i3 >= localRect.left + this.evh) {
          continue;
        }
        i = localRect.left;
        k = this.evh;
        m = arrayOfInt[0];
        m = i + k - m;
        k = n;
        continue;
        j = i;
      }
      catch (Exception paramView)
      {
        Log.e("CalloutPopupWindow", "[showInternal] failed to show window", paramView);
        return;
      }
      i = k;
    }
  }
  
  public void abq(int paramInt)
  {
    this.evh = paramInt;
  }
  
  public void abr(int paramInt)
  {
    this.evi = paramInt;
  }
  
  public void abs(int paramInt)
  {
    this.evk = paramInt;
  }
  
  public void abt(int paramInt)
  {
    this.evl = paramInt;
  }
  
  public void aj(Drawable paramDrawable)
  {
    this.gQ = paramDrawable;
  }
  
  public void ak(Drawable paramDrawable)
  {
    this.gR = paramDrawable;
  }
  
  public void dismiss()
  {
    this.handler.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public void jb(View paramView)
  {
    J(paramView, 0, 0);
  }
  
  public void setAlignMode(int paramInt)
  {
    this.mAlignMode = paramInt;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.cv.setBackgroundDrawable(paramDrawable);
    super.setBackgroundDrawable(new ColorDrawable());
  }
  
  public void setContentView(View paramView)
  {
    if (paramView != null) {
      this.mContainer.removeAllViews();
    }
    switch (this.position)
    {
    default: 
    case 49: 
    case 50: 
    case 52: 
      for (;;)
      {
        this.cv.addView(paramView, -2, -2);
        super.setContentView(this.mContainer);
        return;
        this.mContainer.addView(this.cv, -2, -2);
        this.mContainer.addView(this.Hr, -2, -2);
        if (this.gQ != null) {
          this.Hr.setImageDrawable(this.gQ);
        }
        for (;;)
        {
          A(this.Hr);
          break;
          this.Hr.setImageResource(this.evk);
        }
        this.mContainer.addView(this.Hr, -2, -2);
        this.mContainer.addView(this.cv, -2, -2);
        if (this.gQ != null)
        {
          this.Hr.setImageDrawable(this.gQ);
        }
        else
        {
          this.Hr.setImageResource(this.evk);
          continue;
          this.mContainer.setOrientation(0);
          this.mContainer.addView(this.Hr, -2, -2);
          this.mContainer.addView(this.cv, -2, -2);
          if (this.gR != null) {
            this.Hr.setImageDrawable(this.gR);
          } else {
            this.Hr.setImageResource(this.evl);
          }
        }
      }
    }
    this.mContainer.setOrientation(0);
    this.mContainer.addView(this.cv, -2, -2);
    this.mContainer.addView(this.Hr, -2, -2);
    if (this.gR != null) {
      this.Hr.setImageDrawable(this.gR);
    }
    for (;;)
    {
      A(this.Hr);
      break;
      this.Hr.setImageResource(this.evl);
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mContainer.setOnClickListener(paramOnClickListener);
  }
  
  public static class a
  {
    private boolean amg = true;
    private Drawable backgroundDrawable;
    private Context context;
    private boolean dlt;
    private int evj = 5;
    private int evo = 17170445;
    private int evp = 17170445;
    private Drawable gQ;
    private Drawable gR;
    private int position = 49;
    private String text;
    private int textColor = -1;
    private float textSize = 12.0F;
    
    private a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public a a(float paramFloat)
    {
      this.textSize = paramFloat;
      return this;
    }
    
    public a a(int paramInt)
    {
      this.textColor = paramInt;
      return this;
    }
    
    public a a(Drawable paramDrawable)
    {
      this.gQ = paramDrawable;
      return this;
    }
    
    public a a(String paramString)
    {
      this.text = paramString;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.dlt = paramBoolean;
      return this;
    }
    
    public auvw a()
    {
      try
      {
        int i = aqcx.dip2px(this.context, 300.0F);
        int j = aqcx.dip2px(this.context, 120.0F);
        LinearLayout localLinearLayout = new LinearLayout(this.context);
        localLinearLayout.setOrientation(0);
        localLinearLayout.setPadding(aqcx.dip2px(this.context, 10.0F), aqcx.dip2px(this.context, 8.0F), aqcx.dip2px(this.context, 10.0F), aqcx.dip2px(this.context, 8.0F));
        Object localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (this.dlt) {}
        for (localObject = new KandianTextView(this.context);; localObject = new TextView(this.context))
        {
          ((TextView)localObject).setTextColor(this.context.getResources().getColor(17170443));
          ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
          localLinearLayout.addView((View)localObject);
          if (this.backgroundDrawable != null)
          {
            int k = localLinearLayout.getPaddingLeft();
            int m = localLinearLayout.getPaddingTop();
            int n = localLinearLayout.getPaddingRight();
            int i1 = localLinearLayout.getPaddingBottom();
            localLinearLayout.setBackgroundDrawable(this.backgroundDrawable);
            localLinearLayout.setPadding(k, m, n, i1);
          }
          ((TextView)localObject).setMaxWidth(i);
          ((TextView)localObject).setMaxHeight(j);
          ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
          ((TextView)localObject).setText(this.text);
          ((TextView)localObject).setTextSize(this.textSize);
          ((TextView)localObject).setTextColor(this.textColor);
          localLinearLayout.measure(i, j);
          localObject = new auvw(this.context, localLinearLayout.getMeasuredWidth(), this.position);
          ((auvw)localObject).abs(this.evo);
          ((auvw)localObject).aj(this.gQ);
          ((auvw)localObject).ak(this.gR);
          ((auvw)localObject).abt(this.evp);
          ((auvw)localObject).setContentView(localLinearLayout);
          ((auvw)localObject).setAlignMode(83);
          if (!this.amg) {
            ((auvw)localObject).setOutsideTouchable(false);
          }
          ((auvw)localObject).abq(aqcx.dip2px(this.context, 6.0F));
          auvw.a((auvw)localObject, this.evj);
          return localObject;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        Log.e("CalloutPopupWindow", "[build] failed to build window", localThrowable);
      }
    }
    
    public a b(int paramInt)
    {
      this.evj = paramInt;
      return this;
    }
    
    public a b(Drawable paramDrawable)
    {
      this.gR = paramDrawable;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.position = paramInt;
      return this;
    }
    
    public a c(Drawable paramDrawable)
    {
      this.backgroundDrawable = paramDrawable;
      return this;
    }
  }
  
  public static class b
  {
    private auvw.a a;
    private int color;
    private int evq = 12;
    private int evr = 8;
    private int radius;
    
    public b(auvw.a parama)
    {
      this.a = parama;
    }
    
    private static Drawable a(float paramFloat, int paramInt)
    {
      ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat }, null, null));
      localShapeDrawable.getPaint().setColor(paramInt);
      return localShapeDrawable;
    }
    
    private static Drawable c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Object localObject = new auvx(getDirection(paramInt3));
      ((auvx)localObject).resize(paramInt1, paramInt2);
      localObject = new ShapeDrawable((Shape)localObject);
      ((ShapeDrawable)localObject).setIntrinsicWidth(paramInt1);
      ((ShapeDrawable)localObject).setIntrinsicHeight(paramInt2);
      ((ShapeDrawable)localObject).getPaint().setColor(paramInt4);
      return localObject;
    }
    
    private int dp2px(float paramFloat)
    {
      return aqcx.dip2px(auvw.a.a(this.a), paramFloat);
    }
    
    private static int getDirection(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 32;
      case 49: 
        return 33;
      case 50: 
        return 34;
      case 51: 
        return 36;
      }
      return 35;
    }
    
    public auvw.a a()
    {
      Drawable localDrawable1 = a(dp2px(this.radius), this.color);
      this.a.c(localDrawable1);
      localDrawable1 = c(dp2px(this.evq), dp2px(this.evr), 49, this.color);
      Drawable localDrawable2 = c(dp2px(this.evr), dp2px(this.evq), 51, this.color);
      this.a.b(localDrawable2);
      this.a.a(localDrawable1);
      return this.a;
    }
    
    public b a(int paramInt)
    {
      this.radius = paramInt;
      return this;
    }
    
    public b b(int paramInt)
    {
      this.color = paramInt;
      return this;
    }
  }
  
  static class c
    extends Handler
  {
    public c()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while (paramMessage.obj == null);
        paramMessage = ((WeakReference)paramMessage.obj).get();
      } while ((paramMessage == null) || (!(paramMessage instanceof auvw)));
      ((auvw)paramMessage).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvw
 * JD-Core Version:    0.7.0.1
 */