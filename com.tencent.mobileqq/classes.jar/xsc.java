import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper.2;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper.3;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;
import java.util.Locale;

public class xsc
  implements View.OnAttachStateChangeListener, View.OnClickListener, View.OnLayoutChangeListener, xrs
{
  public float a;
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public ViewGroup a;
  public List<QQUserUIItem> a;
  public xru a;
  xrv jdField_a_of_type_Xrv = new xsd(this);
  xrx jdField_a_of_type_Xrx;
  public xry a;
  public boolean a;
  public float b;
  public int b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  xrx jdField_b_of_type_Xrx;
  public float c;
  public int c;
  private boolean c;
  public float d;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  public float e;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  public float f;
  public float g;
  public float h;
  
  static
  {
    if (!xrr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  public xsc(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131560757, null, false));
    this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.addOnAttachStateChangeListener(this);
    this.jdField_a_of_type_Xry = new xry(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377644));
    this.jdField_a_of_type_Xrx = new xrz(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369244), 0);
    this.jdField_a_of_type_Xrx.a(this.jdField_a_of_type_Xrv);
    this.jdField_b_of_type_Xrx = new xrz(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369245), 1);
    this.jdField_b_of_type_Xrx.a(this.jdField_a_of_type_Xrv);
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup == null)
    {
      wxe.b("WidgetWrapper", "mAttendWidget is null, no action, return");
      return;
    }
    float f4 = this.f * this.jdField_a_of_type_Float + this.jdField_b_of_type_Float;
    float f5 = this.g * this.jdField_a_of_type_Float + this.jdField_c_of_type_Float;
    int i = this.jdField_b_of_type_AndroidViewViewGroup.getHeight();
    int j = this.jdField_b_of_type_AndroidViewViewGroup.getWidth();
    float[] arrayOfFloat = xrr.a(0.0F, this.jdField_d_of_type_Int * 1.0F / 2.0F + i * 1.0F / 2.0F + xsm.a(this.jdField_b_of_type_AndroidViewViewGroup.getContext(), 10.0F), this.h);
    float f2 = arrayOfFloat[0];
    float f1 = arrayOfFloat[1];
    float f3;
    if ((this.jdField_d_of_type_Float * f2 + f4 < 0.0F) || ((this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null) && (f5 + this.jdField_e_of_type_Float * f1 > ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).getHeight())) || ((this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null) && (f4 + this.jdField_d_of_type_Float * f2 > ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).getWidth())) || (this.jdField_e_of_type_Float * f1 + f5 < 0.0F))
    {
      f2 = -f2;
      f3 = -f1;
      f1 = f2;
      f2 = f1;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewViewGroup.setX(this.jdField_d_of_type_Float * f2 + f4 - j * 1.0F / 2.0F);
      this.jdField_b_of_type_AndroidViewViewGroup.setY(this.jdField_e_of_type_Float * f3 + f5 - i * 1.0F / 2.0F);
      this.jdField_b_of_type_AndroidViewViewGroup.setRotation(this.h);
      this.jdField_b_of_type_AndroidViewViewGroup.setScaleX(this.jdField_d_of_type_Float);
      this.jdField_b_of_type_AndroidViewViewGroup.setScaleY(this.jdField_e_of_type_Float);
      if (j != 0) {
        b(this.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        wxe.a("WidgetWrapper", "relayoutAttendView %d", Integer.valueOf(this.jdField_b_of_type_AndroidViewViewGroup.hashCode()));
        wxe.b("WidgetWrapper", "relayoutAttendView 2widgets(%d, %d, %d, %d) showAttend? %b, stack=%s", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(this.jdField_a_of_type_Boolean), xre.a(5) });
        wxe.a("WidgetWrapper", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.jdField_b_of_type_Float), Float.valueOf(this.jdField_c_of_type_Float), Float.valueOf(f2), Float.valueOf(f3));
        return;
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      }
      f3 = f1;
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidViewViewGroup.getWidth(), this.jdField_a_of_type_AndroidViewViewGroup.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.jdField_a_of_type_AndroidViewViewGroup.draw(localCanvas);
    return localBitmap;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public xrx a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new xrt(this, this.jdField_b_of_type_Xrx.a, paramInt);
    case 0: 
      return this.jdField_a_of_type_Xrx;
    }
    return this.jdField_b_of_type_Xrx;
  }
  
  public xry a()
  {
    return this.jdField_a_of_type_Xry;
  }
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_e_of_type_Int = b();
      this.jdField_d_of_type_Int = c();
      this.jdField_d_of_type_Float = (this.jdField_a_of_type_Float * this.jdField_a_of_type_Int / this.jdField_e_of_type_Int);
      this.jdField_e_of_type_Float = (this.jdField_a_of_type_Float * this.jdField_b_of_type_Int / this.jdField_d_of_type_Int);
    } while ((this.jdField_e_of_type_Int == 0) || (this.jdField_d_of_type_Int == 0));
    float f1 = this.f * this.jdField_a_of_type_Float + this.jdField_b_of_type_Float;
    float f2 = this.g * this.jdField_a_of_type_Float + this.jdField_c_of_type_Float;
    a().setX(f1 - this.jdField_e_of_type_Int * 1.0F / 2.0F);
    a().setY(f2 - this.jdField_d_of_type_Int * 1.0F / 2.0F);
    a().setRotation(this.h);
    a().setScaleX(this.jdField_d_of_type_Float);
    a().setScaleY(this.jdField_e_of_type_Float);
    wxe.b("WidgetWrapper", "%s relayoutPollView view center (%.2f, %.2f) rotation(%.2f) scale(%.2f, %.2f) widgets(%d, %d)", new Object[] { a().a(), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(this.h), Float.valueOf(this.jdField_d_of_type_Float), Float.valueOf(this.jdField_e_of_type_Float), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int) });
    wxe.a("WidgetWrapper", "relayoutPollView offset(%.2f, %.2f)", Float.valueOf(this.jdField_b_of_type_Float), Float.valueOf(this.jdField_c_of_type_Float));
    b();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    wxe.c("WidgetWrapper", "setPositionInfo %.2f, %.2f, %.2f, %d, %d, %.2f, %.2f, r:%.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat4), Float.valueOf(paramFloat5), Float.valueOf(paramFloat6) });
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Int = b();
    this.jdField_d_of_type_Int = c();
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.f = paramFloat4;
    this.g = paramFloat5;
    this.h = paramFloat6;
  }
  
  public void a(List<QQUserUIItem> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_b_of_type_AndroidViewViewGroup == null) {
      wxe.b("WidgetWrapper", "setPollUsers mAttendWidget == null stack=%s", xre.a(4));
    }
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        wxe.e("WidgetWrapper", "setPollUsers mPollUsers == null stack=%s", new Object[] { xre.a(4) });
        return;
      }
      wxe.a("WidgetWrapper", "setPollUsers mAttendWidget usercount: %d", Integer.valueOf(paramList.size()));
      localObject1 = new StringBuilder();
      i = 0;
      if (i < paramList.size())
      {
        localObject2 = (QQUserUIItem)paramList.get(i);
        if (localObject2 == null) {}
        for (;;)
        {
          i += 1;
          break;
          ((StringBuilder)localObject1).append(((QQUserUIItem)localObject2).getName());
          ((StringBuilder)localObject1).append(", ");
        }
      }
      wxe.a("WidgetWrapper", "pollUsers: %s", ((StringBuilder)localObject1).toString());
      localObject1 = (ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369299);
    } while (localObject1 == null);
    int j = ((ViewGroup)localObject1).getChildCount() - 1;
    int k = paramList.size();
    int i = Math.min(j, k);
    k = Math.max(k, paramInt);
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(paramInt);
      Object localObject3;
      if ((localObject2 instanceof ImageView))
      {
        localObject3 = (QQUserUIItem)paramList.get(paramInt);
        if (localObject3 != null) {}
      }
      else
      {
        paramInt += 1;
        continue;
      }
      if ((TextUtils.isEmpty(((QQUserUIItem)localObject3).qq)) || (TextUtils.equals(((QQUserUIItem)localObject3).qq, "0"))) {
        xsm.a((ImageView)localObject2, ((QQUserUIItem)localObject3).headUrl, 80, 80, 1);
      }
      for (;;)
      {
        ((View)localObject2).setVisibility(0);
        break;
        Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846012);
        localObject3 = bdbk.a(QQStoryContext.a(), 1, String.valueOf(((QQUserUIItem)localObject3).qq), 3, localDrawable, localDrawable);
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
      }
    }
    paramInt = i;
    while (paramInt < j)
    {
      paramList = ((ViewGroup)localObject1).getChildAt(paramInt);
      if ((paramList instanceof ImageView)) {
        paramList.setVisibility(4);
      }
      paramInt += 1;
    }
    if (k <= j) {}
    for (paramList = String.format(Locale.getDefault(), "%d人参与 >", new Object[] { Integer.valueOf(k) });; paramList = String.format(Locale.getDefault(), alud.a(2131708723), new Object[] { Integer.valueOf(k) }))
    {
      ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131377757)).setText(paramList);
      return;
    }
  }
  
  public void a(uxk paramuxk, float paramFloat1, float paramFloat2)
  {
    float f1 = paramuxk.jdField_c_of_type_Int;
    float f2 = paramuxk.jdField_d_of_type_Int;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    if (f2 * 1.0F / f1 > paramFloat2 * 1.0F / paramFloat1)
    {
      this.jdField_a_of_type_Float = (paramFloat1 * 1.0F / f1);
      this.jdField_c_of_type_Float = (-(this.jdField_a_of_type_Float * f2 - paramFloat2) / 2.0F);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, paramuxk.jdField_e_of_type_Int, paramuxk.f, paramuxk.g, paramuxk.h, paramuxk.i);
      return;
      this.jdField_a_of_type_Float = (paramFloat2 * 1.0F / f2);
      this.jdField_b_of_type_Float = (-(f1 * this.jdField_a_of_type_Float - paramFloat1) / 2.0F);
    }
  }
  
  public void a(xru paramxru)
  {
    this.jdField_a_of_type_Xru = paramxru;
  }
  
  public void a(xrw paramxrw)
  {
    this.jdField_a_of_type_Xry.a(paramxrw);
    this.jdField_a_of_type_Xrx.a(paramxrw);
    this.jdField_b_of_type_Xrx.a(paramxrw);
  }
  
  public void a(boolean paramBoolean)
  {
    xsa[] arrayOfxsa = a();
    int j = arrayOfxsa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfxsa[i].e(paramBoolean);
      i += 1;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int m = 0;
    int k = 0;
    if (paramArrayOfInt == null) {
      wxe.e("WidgetWrapper", "Error: setOptionNumbers get null numbers!! stack = %s", new Object[] { xre.a(5) });
    }
    for (;;)
    {
      return;
      int j = 0;
      int i = 0;
      while (j < paramArrayOfInt.length)
      {
        i += paramArrayOfInt[j];
        j += 1;
      }
      j = m;
      if (i <= 0)
      {
        i = k;
        while (i < paramArrayOfInt.length)
        {
          a(i).a(0.0F);
          i += 1;
        }
      }
      else
      {
        while (j < paramArrayOfInt.length)
        {
          a(j).a(paramArrayOfInt[j] * 100.0F / i);
          j += 1;
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public xsa[] a()
  {
    return new xsa[] { this.jdField_a_of_type_Xry, this.jdField_a_of_type_Xrx, this.jdField_b_of_type_Xrx };
  }
  
  public int b()
  {
    return a().getWidth();
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_b_of_type_AndroidViewViewGroup != null)
    {
      localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 4)
    {
      localViewGroup.setVisibility(i);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public int c()
  {
    return a().getHeight();
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      while (i < 2500)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PollWidgetUtils.WidgetWrapper.2(this), i);
        i += 500;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PollWidgetUtils.WidgetWrapper.3(this), i);
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Xry.a(false);
  }
  
  public void e(boolean paramBoolean)
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363034).getBackground();
    if (localAnimationDrawable != null)
    {
      if (!paramBoolean) {
        break label52;
      }
      localAnimationDrawable.start();
    }
    for (;;)
    {
      ((xrz)this.jdField_a_of_type_Xrx).d(paramBoolean);
      ((xrz)this.jdField_b_of_type_Xrx).d(paramBoolean);
      return;
      label52:
      localAnimationDrawable.stop();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xru != null) {
      this.jdField_a_of_type_Xru.a(this);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView == this.jdField_b_of_type_AndroidViewViewGroup)
    {
      wxe.b("WidgetWrapper", "attendWidget onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      b();
      return;
    }
    wxe.b("WidgetWrapper", "onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    a();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    paramView = paramView.getParent();
    if ((!jdField_b_of_type_Boolean) && ((paramView == null) || (!(paramView instanceof ViewGroup)))) {
      throw new AssertionError();
    }
    paramView = (ViewGroup)paramView;
    if (paramView.getId() == 2131372176)
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidViewViewGroup.getContext()).inflate(2131560756, paramView)).findViewById(2131365160));
      ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131377654)).setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_AndroidViewViewGroup.hashCode()) }));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this);
      a(this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Int);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsc
 * JD-Core Version:    0.7.0.1
 */