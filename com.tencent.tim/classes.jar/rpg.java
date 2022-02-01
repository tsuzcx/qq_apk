import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper.2;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Locale;

public class rpg
{
  public static int a(Rect[] paramArrayOfRect, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramArrayOfRect == null) || (paramArrayOfRect.length == 0)) {
      i = -1;
    }
    Rect localRect;
    do
    {
      return i;
      localRect = paramArrayOfRect[0];
    } while ((paramInt2 >= 0) && (paramInt2 <= localRect.bottom) && (paramInt1 >= 0) && (paramInt1 <= localRect.right));
    int j = 1;
    for (;;)
    {
      if (j >= paramArrayOfRect.length) {
        break label110;
      }
      localRect = paramArrayOfRect[j];
      if ((paramInt2 >= localRect.top) && (paramInt2 <= localRect.bottom) && (paramInt1 >= localRect.left))
      {
        i = j;
        if (paramInt1 <= localRect.right) {
          break;
        }
      }
      j += 1;
    }
    label110:
    return -1;
  }
  
  public static String a(TextView paramTextView, int paramInt)
  {
    Layout localLayout = paramTextView.getLayout();
    String str = paramTextView.getText().toString();
    paramTextView = str;
    if (localLayout != null)
    {
      paramTextView = str;
      if (localLayout.getLineCount() > paramInt) {
        paramTextView = str.substring(0, localLayout.getLineStart(paramInt));
      }
    }
    return paramTextView;
  }
  
  public static rpg.a a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return new rpg.j(paramContext);
  }
  
  public static float[] a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new float[] { (float)(paramFloat1 * Math.cos(paramFloat3 * 3.141592653589793D / 180.0D)) - (float)(paramFloat2 * Math.sin(paramFloat3 * 3.141592653589793D / 180.0D)), (float)(paramFloat1 * Math.sin(paramFloat3 * 3.141592653589793D / 180.0D)) + (float)(paramFloat2 * Math.cos(paramFloat3 * 3.141592653589793D / 180.0D)) };
  }
  
  public static abstract interface a
  {
    public abstract void E(List<QQUserUIItem> paramList, int paramInt);
    
    public abstract rpg.f a(int paramInt);
    
    public abstract rpg.g a();
    
    public abstract void a(StoryVideoItem.b paramb, float paramFloat1, float paramFloat2);
    
    public abstract void a(rpg.c paramc);
    
    public abstract void a(rpg.e parame);
    
    public abstract rpg.i[] a();
    
    public abstract void bvM();
    
    public abstract Bitmap getBitmap();
    
    public abstract View getView();
    
    public abstract void j(int[] paramArrayOfInt);
    
    public abstract int tL();
    
    public abstract void tW(boolean paramBoolean);
    
    public abstract void tX(boolean paramBoolean);
    
    public abstract void tY(boolean paramBoolean);
    
    public abstract void tZ(boolean paramBoolean);
    
    public abstract void ua(boolean paramBoolean);
  }
  
  public static class b
    extends rpg.f
  {
    public int index;
    
    public b(rpg.j paramj, View paramView, int paramInt)
    {
      super(paramView);
      this.index = paramInt;
    }
    
    public CharSequence getHint()
    {
      ram.e("NullOptionElement", "getHint() on %d", new Object[] { Integer.valueOf(this.index) });
      return "";
    }
    
    public CharSequence getText()
    {
      ram.e("NullOptionElement", "getText() on %d", new Object[] { Integer.valueOf(this.index) });
      return "";
    }
    
    public void setText(CharSequence paramCharSequence)
    {
      ram.e("NullOptionElement", "setText() on %d", new Object[] { Integer.valueOf(this.index) });
    }
    
    public int tM()
    {
      ram.e("NullOptionElement", "getOptionIndex() on %d", new Object[] { Integer.valueOf(this.index) });
      return this.index;
    }
    
    public void ub(boolean paramBoolean) {}
  }
  
  public static abstract interface c
  {
    public abstract void a(rpg.a parama);
  }
  
  public static abstract interface d
  {
    public abstract void a(rpg.i parami, boolean paramBoolean);
  }
  
  public static abstract interface e
  {
    public abstract void a(rpg.a parama, rpg.i parami);
  }
  
  public static abstract class f
    extends rpg.i
  {
    public f(rpg.j paramj, View paramView)
    {
      super(paramView);
    }
    
    public abstract int tM();
  }
  
  public static class g
    extends rpg.i
  {
    TextView yZ;
    
    public g(rpg.j paramj, View paramView)
    {
      super(paramView);
      this.yZ = ((TextView)paramView.findViewById(2131379446));
      this.yZ.setMaxLines(1);
      this.yZ.setSingleLine();
    }
    
    public CharSequence getHint()
    {
      return this.yZ.getHint();
    }
    
    public CharSequence getText()
    {
      return this.yZ.getText();
    }
    
    public void setHint(CharSequence paramCharSequence)
    {
      this.yZ.setHint(paramCharSequence);
      this.yZ.setGravity(17);
    }
    
    public void setText(CharSequence paramCharSequence)
    {
      paramCharSequence = paramCharSequence.toString();
      this.yZ.setText(paramCharSequence);
      paramCharSequence = rpg.a(this.yZ, 1);
      this.yZ.setText(paramCharSequence);
    }
    
    public void ub(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.yZ.setBackgroundResource(2130845462);
        return;
      }
      this.yZ.setBackgroundResource(0);
    }
  }
  
  public static class h
    extends rpg.f
    implements View.OnTouchListener
  {
    public static final int[] en = { 2131363929, 2131363930 };
    public static final int[] eo = { 2130845514, 2130845517 };
    public static final int[] ep = { 2130845515, 2130845518 };
    public static final int[] eq = { 2131379532, 2131379533 };
    public boolean aJf;
    int btN;
    TextView za;
    TextView zb;
    
    public h(rpg.j paramj, View paramView, int paramInt)
    {
      super(paramView);
      this.btN = paramInt;
      this.za = ((TextView)paramView.findViewById(en[paramInt]));
      this.zb = ((TextView)paramView.findViewById(eq[paramInt]));
      paramView.setOnTouchListener(this);
    }
    
    public void ah(float paramFloat)
    {
      this.zb.setText(String.format(Locale.getDefault(), "%.0f%%", new Object[] { Float.valueOf(paramFloat) }));
    }
    
    public CharSequence getHint()
    {
      return this.za.getHint();
    }
    
    public CharSequence getText()
    {
      return this.za.getText();
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if ((isSelected()) || (this.b == null) || (!this.a.LO())) {
        return paramView.onTouchEvent(paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        return paramView.onTouchEvent(paramMotionEvent);
        uc(true);
        continue;
        uc(false);
        continue;
        if ((paramMotionEvent.getX() < 0.0F) || (paramMotionEvent.getX() > paramView.getWidth()) || (paramMotionEvent.getY() < 0.0F) || (paramMotionEvent.getY() > paramView.getHeight())) {
          uc(false);
        }
      }
    }
    
    public void setSelect(boolean paramBoolean)
    {
      uc(paramBoolean);
      super.setSelect(paramBoolean);
    }
    
    public void setText(CharSequence paramCharSequence)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {}
      for (CharSequence localCharSequence = this.za.getHint();; localCharSequence = paramCharSequence)
      {
        int j;
        int k;
        float[] arrayOfFloat1;
        if (this.zb.getVisibility() == 0)
        {
          j = 1;
          if (j == 0) {
            break label201;
          }
          k = rpq.dip2px(this.za.getContext(), 72.5F);
          arrayOfFloat1 = new float[3];
          float[] tmp55_53 = arrayOfFloat1;
          tmp55_53[0] = 21.0F;
          float[] tmp60_55 = tmp55_53;
          tmp60_55[1] = 18.0F;
          float[] tmp65_60 = tmp60_55;
          tmp65_60[2] = 14.0F;
          tmp65_60;
        }
        int i;
        int n;
        for (;;)
        {
          this.za.setMaxWidth(k);
          float[] arrayOfFloat2 = new float[localCharSequence.length()];
          Paint localPaint = new Paint(this.za.getPaint());
          i = 0;
          if (i >= arrayOfFloat1.length) {
            break label335;
          }
          localPaint.setTextSize(TypedValue.applyDimension(1, arrayOfFloat1[i], this.za.getResources().getDisplayMetrics()));
          localPaint.getTextWidths(localCharSequence.toString(), arrayOfFloat2);
          n = 0;
          int i1 = arrayOfFloat2.length;
          int m = 0;
          while (m < i1)
          {
            float f = arrayOfFloat2[m];
            n = (int)(n + f);
            m += 1;
          }
          j = 0;
          break;
          label201:
          k = rpq.dip2px(this.za.getContext(), 84.0F);
          arrayOfFloat1 = new float[2];
          float[] tmp222_220 = arrayOfFloat1;
          tmp222_220[0] = 28.0F;
          float[] tmp227_222 = tmp222_220;
          tmp227_222[1] = 21.0F;
          tmp227_222;
        }
        if ((n <= k) || (i == arrayOfFloat1.length - 1))
        {
          this.za.setTextSize(1, arrayOfFloat1[i]);
          this.za.setText(paramCharSequence);
          ram.b("Q.qqstory.widget.PollWidgetUtils", "text size = %s", Float.valueOf(arrayOfFloat1[i]));
        }
        for (;;)
        {
          paramCharSequence = rpg.a(this.za, 2);
          this.za.setText(paramCharSequence);
          if ((j != 0) && (i == arrayOfFloat1.length - 1)) {
            this.zb.setTextSize(1, 20.0F);
          }
          return;
          i += 1;
          break;
          label335:
          i = -1;
        }
      }
    }
    
    public int tM()
    {
      return this.btN;
    }
    
    public void tW(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.zb.getVisibility() != 0))
      {
        this.zb.setVisibility(0);
        setText(this.za.getText());
      }
      while ((paramBoolean) || (this.zb.getVisibility() != 0)) {
        return;
      }
      this.zb.setVisibility(8);
      setText(this.za.getText());
    }
    
    public void ub(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.za.setBackgroundResource(2130845462);
        return;
      }
      this.za.setBackgroundResource(0);
    }
    
    public void uc(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.rootView.setBackgroundResource(eo[this.btN]);
        this.za.setShadowLayer(0.01F, 0.0F, 2.0F, -35568);
        this.za.setTextColor(-1);
        this.zb.setShadowLayer(0.01F, 0.0F, 2.0F, -35568);
        this.zb.setTextColor(-1);
        return;
      }
      if (this.aJf) {
        this.rootView.setBackgroundResource(0);
      }
      for (;;)
      {
        this.za.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        this.za.setTextColor(-16777216);
        this.zb.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        this.zb.setTextColor(-16777216);
        return;
        this.rootView.setBackgroundResource(ep[this.btN]);
      }
    }
    
    public void updateBackground(boolean paramBoolean)
    {
      this.aJf = paramBoolean;
      uc(this.selected);
    }
  }
  
  public static abstract class i
  {
    rpg.d jdField_a_of_type_Rpg$d;
    rpg.j jdField_a_of_type_Rpg$j;
    rpg.e b;
    private View.OnClickListener cA = new rph(this);
    View rootView;
    boolean selected = false;
    
    public i(rpg.j paramj, View paramView)
    {
      this.jdField_a_of_type_Rpg$j = paramj;
      this.rootView = paramView;
    }
    
    void a(rpg.d paramd)
    {
      this.jdField_a_of_type_Rpg$d = paramd;
    }
    
    public void ah(float paramFloat) {}
    
    public void b(rpg.e parame)
    {
      this.b = parame;
      if (this.b != null)
      {
        this.rootView.setOnClickListener(this.cA);
        return;
      }
      this.rootView.setOnClickListener(null);
      this.rootView.setClickable(false);
    }
    
    public abstract CharSequence getHint();
    
    public Rect getRect()
    {
      Rect localRect = new Rect();
      this.rootView.getHitRect(localRect);
      return localRect;
    }
    
    public abstract CharSequence getText();
    
    public boolean isSelected()
    {
      return this.selected;
    }
    
    public void setHint(CharSequence paramCharSequence) {}
    
    public void setSelect(boolean paramBoolean)
    {
      if (this.selected != paramBoolean)
      {
        this.selected = paramBoolean;
        rpg.d locald = this.jdField_a_of_type_Rpg$d;
        if (locald != null) {
          locald.a(this, paramBoolean);
        }
      }
    }
    
    public void setText(CharSequence paramCharSequence) {}
    
    public void tW(boolean paramBoolean) {}
    
    public abstract void ub(boolean paramBoolean);
  }
  
  public static class j
    implements View.OnAttachStateChangeListener, View.OnClickListener, View.OnLayoutChangeListener, rpg.a
  {
    rpg.f a;
    public rpg.g a;
    private boolean aJg;
    private boolean aJh;
    public boolean aJi;
    private boolean aJj;
    public rpg.c b;
    rpg.d jdField_b_of_type_Rpg$d = new rpi(this);
    rpg.f jdField_b_of_type_Rpg$f;
    public int btO;
    public int btP;
    public int btQ;
    private Handler bu = new Handler(Looper.getMainLooper());
    private ViewGroup cA;
    public ViewGroup cB;
    public float nM;
    public float nN;
    public float nO;
    public float nP;
    public float offsetX;
    public float offsetY;
    public List<QQUserUIItem> pd;
    public float rotation;
    public float scale;
    private int viewHeight;
    private int viewWidth;
    
    static
    {
      if (!rpg.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public j(Context paramContext)
    {
      this.cB = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131561127, null, false));
      this.cB.addOnLayoutChangeListener(this);
      this.cB.addOnAttachStateChangeListener(this);
      this.jdField_a_of_type_Rpg$g = new rpg.g(this, this.cB.findViewById(2131379446));
      this.jdField_a_of_type_Rpg$f = new rpg.h(this, this.cB.findViewById(2131370244), 0);
      this.jdField_a_of_type_Rpg$f.a(this.jdField_b_of_type_Rpg$d);
      this.jdField_b_of_type_Rpg$f = new rpg.h(this, this.cB.findViewById(2131370245), 1);
      this.jdField_b_of_type_Rpg$f.a(this.jdField_b_of_type_Rpg$d);
    }
    
    private void bvN()
    {
      if (this.cA == null)
      {
        ram.d("WidgetWrapper", "mAttendWidget is null, no action, return");
        return;
      }
      float f4 = this.nO * this.scale + this.offsetX;
      float f5 = this.nP * this.scale + this.offsetY;
      int i = this.cA.getHeight();
      int j = this.cA.getWidth();
      float[] arrayOfFloat = rpg.a(0.0F, this.viewHeight * 1.0F / 2.0F + i * 1.0F / 2.0F + rpq.dip2px(this.cA.getContext(), 10.0F), this.rotation);
      float f2 = arrayOfFloat[0];
      float f1 = arrayOfFloat[1];
      float f3;
      if ((this.nM * f2 + f4 < 0.0F) || ((this.cA.getParent() != null) && (f5 + this.nN * f1 > ((ViewGroup)this.cA.getParent()).getHeight())) || ((this.cA.getParent() != null) && (f4 + this.nM * f2 > ((ViewGroup)this.cA.getParent()).getWidth())) || (this.nN * f1 + f5 < 0.0F))
      {
        f2 = -f2;
        f3 = -f1;
        f1 = f2;
        f2 = f1;
      }
      for (;;)
      {
        this.cA.setX(this.nM * f2 + f4 - j * 1.0F / 2.0F);
        this.cA.setY(this.nN * f3 + f5 - i * 1.0F / 2.0F);
        this.cA.setRotation(this.rotation);
        this.cA.setScaleX(this.nM);
        this.cA.setScaleY(this.nN);
        if (j != 0) {
          tX(this.aJi);
        }
        for (;;)
        {
          ram.b("WidgetWrapper", "relayoutAttendView %d", Integer.valueOf(this.cA.hashCode()));
          ram.d("WidgetWrapper", "relayoutAttendView 2widgets(%d, %d, %d, %d) showAttend? %b, stack=%s", new Object[] { Integer.valueOf(this.viewWidth), Integer.valueOf(this.viewHeight), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(this.aJi), rov.getStackTrace(5) });
          ram.a("WidgetWrapper", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.offsetX), Float.valueOf(this.offsetY), Float.valueOf(f2), Float.valueOf(f3));
          return;
          this.cA.setVisibility(4);
        }
        f3 = f1;
      }
    }
    
    public void E(List<QQUserUIItem> paramList, int paramInt)
    {
      this.pd = paramList;
      this.btQ = paramInt;
      if (this.cA == null) {
        ram.d("WidgetWrapper", "setPollUsers mAttendWidget == null stack=%s", rov.getStackTrace(4));
      }
      Object localObject1;
      Object localObject2;
      do
      {
        return;
        if (this.pd == null)
        {
          ram.e("WidgetWrapper", "setPollUsers mPollUsers == null stack=%s", new Object[] { rov.getStackTrace(4) });
          return;
        }
        ram.b("WidgetWrapper", "setPollUsers mAttendWidget usercount: %d", Integer.valueOf(paramList.size()));
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
        ram.b("WidgetWrapper", "pollUsers: %s", ((StringBuilder)localObject1).toString());
        localObject1 = (ViewGroup)this.cA.findViewById(2131370300);
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
          rpq.a((ImageView)localObject2, ((QQUserUIItem)localObject3).headUrl, 80, 80, 1);
        }
        for (;;)
        {
          ((View)localObject2).setVisibility(0);
          break;
          Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130847333);
          localObject3 = aqdj.a(QQStoryContext.c(), 1, String.valueOf(((QQUserUIItem)localObject3).qq), 3, localDrawable, localDrawable);
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
      for (paramList = String.format(Locale.getDefault(), "%d人参与 >", new Object[] { Integer.valueOf(k) });; paramList = String.format(Locale.getDefault(), acfp.m(2131709801), new Object[] { Integer.valueOf(k) }))
      {
        ((TextView)this.cA.findViewById(2131379559)).setText(paramList);
        return;
      }
    }
    
    public boolean LO()
    {
      return this.aJh;
    }
    
    public rpg.f a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return new rpg.b(this, this.jdField_b_of_type_Rpg$f.rootView, paramInt);
      case 0: 
        return this.jdField_a_of_type_Rpg$f;
      }
      return this.jdField_b_of_type_Rpg$f;
    }
    
    public rpg.g a()
    {
      return this.jdField_a_of_type_Rpg$g;
    }
    
    public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      ram.i("WidgetWrapper", "setPositionInfo %.2f, %.2f, %.2f, %d, %d, %.2f, %.2f, r:%.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat4), Float.valueOf(paramFloat5), Float.valueOf(paramFloat6) });
      this.aJg = true;
      this.viewWidth = tN();
      this.viewHeight = tO();
      this.scale = paramFloat1;
      this.offsetX = paramFloat2;
      this.offsetY = paramFloat3;
      this.btO = paramInt1;
      this.btP = paramInt2;
      this.nO = paramFloat4;
      this.nP = paramFloat5;
      this.rotation = paramFloat6;
    }
    
    public void a(StoryVideoItem.b paramb, float paramFloat1, float paramFloat2)
    {
      float f1 = paramb.screenWidth;
      float f2 = paramb.screenHeight;
      this.offsetX = 0.0F;
      this.offsetY = 0.0F;
      if (f2 * 1.0F / f1 > paramFloat2 * 1.0F / paramFloat1)
      {
        this.scale = (paramFloat1 * 1.0F / f1);
        this.offsetY = (-(this.scale * f2 - paramFloat2) / 2.0F);
      }
      for (;;)
      {
        a(this.scale, this.offsetX, this.offsetY, paramb.bkn, paramb.layoutHeight, paramb.bko, paramb.bkp, paramb.rotation);
        return;
        this.scale = (paramFloat2 * 1.0F / f2);
        this.offsetX = (-(f1 * this.scale - paramFloat1) / 2.0F);
      }
    }
    
    public void a(rpg.c paramc)
    {
      this.jdField_b_of_type_Rpg$c = paramc;
    }
    
    public void a(rpg.e parame)
    {
      this.jdField_a_of_type_Rpg$g.b(parame);
      this.jdField_a_of_type_Rpg$f.b(parame);
      this.jdField_b_of_type_Rpg$f.b(parame);
    }
    
    public rpg.i[] a()
    {
      return new rpg.i[] { this.jdField_a_of_type_Rpg$g, this.jdField_a_of_type_Rpg$f, this.jdField_b_of_type_Rpg$f };
    }
    
    public void bvM()
    {
      if (!this.aJg) {}
      do
      {
        return;
        this.viewWidth = tN();
        this.viewHeight = tO();
        this.nM = (this.scale * this.btO / this.viewWidth);
        this.nN = (this.scale * this.btP / this.viewHeight);
      } while ((this.viewWidth == 0) || (this.viewHeight == 0));
      float f1 = this.nO * this.scale + this.offsetX;
      float f2 = this.nP * this.scale + this.offsetY;
      getView().setX(f1 - this.viewWidth * 1.0F / 2.0F);
      getView().setY(f2 - this.viewHeight * 1.0F / 2.0F);
      getView().setRotation(this.rotation);
      getView().setScaleX(this.nM);
      getView().setScaleY(this.nN);
      ram.d("WidgetWrapper", "%s relayoutPollView view center (%.2f, %.2f) rotation(%.2f) scale(%.2f, %.2f) widgets(%d, %d)", new Object[] { a().getText(), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(this.rotation), Float.valueOf(this.nM), Float.valueOf(this.nN), Integer.valueOf(this.viewWidth), Integer.valueOf(this.viewHeight) });
      ram.b("WidgetWrapper", "relayoutPollView offset(%.2f, %.2f)", Float.valueOf(this.offsetX), Float.valueOf(this.offsetY));
      bvN();
    }
    
    public Bitmap getBitmap()
    {
      Bitmap localBitmap = Bitmap.createBitmap(this.cB.getWidth(), this.cB.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      this.cB.draw(localCanvas);
      return localBitmap;
    }
    
    public View getView()
    {
      return this.cB;
    }
    
    public void j(int[] paramArrayOfInt)
    {
      int m = 0;
      int k = 0;
      if (paramArrayOfInt == null) {
        ram.e("WidgetWrapper", "Error: setOptionNumbers get null numbers!! stack = %s", new Object[] { rov.getStackTrace(5) });
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
            a(i).ah(0.0F);
            i += 1;
          }
        }
        else
        {
          while (j < paramArrayOfInt.length)
          {
            a(j).ah(paramArrayOfInt[j] * 100.0F / i);
            j += 1;
          }
        }
      }
    }
    
    public void onClick(View paramView)
    {
      if (this.jdField_b_of_type_Rpg$c != null) {
        this.jdField_b_of_type_Rpg$c.a(this);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (paramView == this.cA)
      {
        ram.d("WidgetWrapper", "attendWidget onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        bvN();
        return;
      }
      ram.d("WidgetWrapper", "onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      bvM();
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      paramView = paramView.getParent();
      assert ((paramView != null) && ((paramView instanceof ViewGroup)));
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131373483)
      {
        this.cA = ((ViewGroup)((ViewGroup)LayoutInflater.from(this.cB.getContext()).inflate(2131561126, paramView)).findViewById(2131365787));
        ((TextView)this.cA.findViewById(2131379456)).setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(this.cA.hashCode()) }));
        this.cA.setOnClickListener(this);
        this.cA.addOnLayoutChangeListener(this);
        E(this.pd, this.btQ);
      }
    }
    
    public void onViewDetachedFromWindow(View paramView) {}
    
    public int tL()
    {
      return 3;
    }
    
    public int tN()
    {
      return getView().getWidth();
    }
    
    public int tO()
    {
      return getView().getHeight();
    }
    
    public void tW(boolean paramBoolean)
    {
      rpg.i[] arrayOfi = a();
      int j = arrayOfi.length;
      int i = 0;
      while (i < j)
      {
        arrayOfi[i].tW(paramBoolean);
        i += 1;
      }
    }
    
    public void tX(boolean paramBoolean)
    {
      ViewGroup localViewGroup;
      if (this.cA != null)
      {
        localViewGroup = this.cA;
        if (!paramBoolean) {
          break label29;
        }
      }
      label29:
      for (int i = 0;; i = 4)
      {
        localViewGroup.setVisibility(i);
        this.aJi = paramBoolean;
        return;
      }
    }
    
    public void tY(boolean paramBoolean)
    {
      this.aJh = paramBoolean;
    }
    
    public void tZ(boolean paramBoolean)
    {
      int i = 0;
      if (paramBoolean)
      {
        this.aJj = false;
        this.bu.removeCallbacksAndMessages(null);
        while (i < 2500)
        {
          this.bu.postDelayed(new PollWidgetUtils.WidgetWrapper.2(this), i);
          i += 500;
        }
        this.bu.postDelayed(new PollWidgetUtils.WidgetWrapper.3(this), i);
        return;
      }
      this.aJj = false;
      this.bu.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Rpg$g.ub(false);
    }
    
    public void ua(boolean paramBoolean)
    {
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.cB.findViewById(2131363236).getBackground();
      if (localAnimationDrawable != null)
      {
        if (!paramBoolean) {
          break label52;
        }
        localAnimationDrawable.start();
      }
      for (;;)
      {
        ((rpg.h)this.jdField_a_of_type_Rpg$f).updateBackground(paramBoolean);
        ((rpg.h)this.jdField_b_of_type_Rpg$f).updateBackground(paramBoolean);
        return;
        label52:
        localAnimationDrawable.stop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpg
 * JD-Core Version:    0.7.0.1
 */