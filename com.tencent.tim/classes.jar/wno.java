import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.a;
import com.tencent.mobileqq.activity.aio.anim.FloorJumperSet;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;

public class wno
  extends AIOAnimationConatiner.a
{
  static final float[] aK;
  static final float[] aL;
  static final int bPD;
  static final float density = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
  static final float g = 3000.0F * density;
  static final float pH;
  static final float pI;
  long Ih = 0L;
  long Ii = 0L;
  long Ij = 0L;
  private long Ik;
  private View animView;
  int bPE;
  public int bPF;
  public int businessId = -1;
  int dx;
  int dy;
  private Drawable img;
  float pJ;
  float pK;
  float pL = 750.0F * density;
  boolean running = true;
  int step = 0;
  int x;
  public int y;
  
  static
  {
    aK = new float[] { 0.0F, 3.82F, 7.28F, 10.38F, 13.12F, 15.499998F, 17.52F, 19.18F, 20.48F, 21.420002F, 21.999998F, 22.219999F, 22.08F, 21.580004F, 20.720001F, 19.500004F, 17.920002F, 15.98F, 13.680004F, 11.020004F, 8.0F, 4.620003F, 0.8799973F, 0.0F, 0.0F, 1.568F, 2.848F, 3.839999F, 4.543999F, 4.959999F, 5.087998F, 4.927998F, 4.479999F, 3.744F, 2.719999F, 1.407999F, 0.0F, 0.0F, 0.5824001F, 0.9344F, 1.056F, 0.9472004F, 0.6080008F, 0.0384007F, 0.0F };
    aL = new float[] { 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.042F, 1.024F, 1.006F, 0.988F, 0.97F, 0.952F, 0.966F, 0.984F, 1.002F, 1.02F, 1.038F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.0356F, 1.0212F, 1.0068F, 0.9924F, 0.978F, 0.9636F, 0.9508F, 0.9652F, 0.9796F, 0.994F, 1.0084F, 1.0228F, 1.0436F, 0.98488F, 0.97336F, 0.96184F, 0.95032F, 0.9612F, 0.97272F, 0.98424F, 1.02288F };
    bPD = aK.length * 10;
    pH = 39.772724F * density;
    pI = 17.5F * density;
  }
  
  public wno(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private BaseChatItemLayout a(long paramLong)
  {
    int i;
    Object localObject1;
    Object localObject2;
    if (paramLong == 0L)
    {
      i = 0;
      while (i < this.l.getChildCount())
      {
        localObject1 = this.l.getChildAt(i);
        if ((localObject1 instanceof BaseChatItemLayout))
        {
          localObject2 = (BaseBubbleBuilder.e)wja.a((View)localObject1);
          if ((((BaseBubbleBuilder.e)localObject2).bvc != 0) && (((BaseBubbleBuilder.e)localObject2).E.getTop() + ((View)localObject1).getTop() + BaseChatItemLayout.bNV > 0)) {
            return (BaseChatItemLayout)localObject1;
          }
        }
        i += 1;
      }
    }
    int n = this.l.getHeaderViewsCount();
    int i1 = this.l.getFooterViewsCount();
    int j = this.l.getFirstVisiblePosition();
    int i2 = this.l.getLastVisiblePosition();
    int k;
    if (j > 1)
    {
      k = 1;
      j -= 1;
    }
    for (;;)
    {
      localObject1 = this.l.getAdapter();
      if (localObject1 == null) {
        return null;
      }
      int i3 = ((ListAdapter)localObject1).getCount();
      i = 0;
      int m = j;
      if (m <= i2) {
        if (m >= n) {}
      }
      for (;;)
      {
        m += 1;
        break;
        if (m >= i3 - i1) {
          return null;
        }
        if (i == 0)
        {
          if (paramLong == ((ListAdapter)localObject1).getItemId(m)) {
            i = 1;
          }
        }
        else
        {
          localObject2 = this.l.getChildAt(m - j - k);
          if (((localObject2 instanceof BaseChatItemLayout)) && (((BaseBubbleBuilder.e)wja.a((View)localObject2)).bvc != 0)) {
            return (BaseChatItemLayout)localObject2;
          }
          if (localObject2 == null) {
            QLog.i("floor_jumper", 2, "not found idx: " + m + ", first: " + j + ", last: " + i2);
          }
        }
      }
      k = 0;
    }
  }
  
  int a(int paramInt, BaseBubbleBuilder.e parame)
  {
    int i;
    int j;
    int k;
    if (parame.mMessage.isSend())
    {
      i = parame.E.getLeft() + BaseChatItemLayout.bNY + BaseChatItemLayout.bOd;
      j = parame.E.getRight() - BaseChatItemLayout.bNX - BaseChatItemLayout.bOc;
      if (paramInt > i) {
        break label135;
      }
      if (j - pI >= i) {
        break label108;
      }
      k = i;
    }
    label108:
    do
    {
      return k;
      i = parame.E.getLeft() + BaseChatItemLayout.bNX + BaseChatItemLayout.bOc;
      j = parame.E.getRight() - BaseChatItemLayout.bNY - BaseChatItemLayout.bNY;
      break;
      d1 = Math.random();
      double d2 = j - i - pI;
      return (int)(i + d1 * d2);
      if (paramInt >= j)
      {
        if (i + pI < j) {
          return j;
        }
        d1 = i + pI;
        d2 = Math.random();
        return (int)((j - i - pI) * d2 + d1);
      }
      if (paramInt - i > pI) {
        break label217;
      }
      k = paramInt;
    } while (j - paramInt <= pI);
    label135:
    label217:
    float f;
    if ((paramInt - i > pI) && (j - paramInt > pI))
    {
      f = (int)(Math.random() * (j - i - pI - pI));
      return (int)(i + pI + f);
    }
    if (paramInt - i > pI)
    {
      d1 = Math.random();
      f = (int)((paramInt - i - pI) * d1);
      return (int)(paramInt - f);
    }
    double d1 = Math.random();
    return (int)((int)((j - paramInt - pI) * d1) + paramInt);
  }
  
  @TargetApi(11)
  void a(int paramInt1, int paramInt2, float... paramVarArgs)
  {
    int i = this.animView.getLeft();
    int j = this.animView.getWidth() / 2;
    int k = this.animView.getBottom();
    this.animView.offsetTopAndBottom(paramInt2 - k);
    this.animView.offsetLeftAndRight(paramInt1 - (i + j));
    if (VersionUtils.isHoneycomb())
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        this.animView.setScaleY(paramVarArgs[0]);
        this.animView.setScaleX(2.0F - paramVarArgs[0]);
      }
    }
    else {
      return;
    }
    this.animView.setScaleY(1.0F);
    this.animView.setScaleX(1.0F);
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.running) {
      return as(true);
    }
    return false;
  }
  
  public boolean as(boolean paramBoolean)
  {
    if (this.running)
    {
      if (paramBoolean) {
        switch (this.step)
        {
        }
      }
      int i;
      while ((this.c == null) || (this.animView == null))
      {
        this.running = false;
        this.img = null;
        this.animView = null;
        return false;
        i = wja.a(this.Ii, this.l.getAdapter());
        if (i < this.l.getFirstVisiblePosition())
        {
          this.y = -1;
        }
        else if (i > this.l.getLastVisiblePosition())
        {
          if (this.Ik > 0L)
          {
            stop();
            return false;
          }
          this.step = 5;
          this.Ih = 0L;
          this.Ii = 0L;
        }
        else
        {
          BaseBubbleBuilder.e locale = (BaseBubbleBuilder.e)wja.a(wja.a(this.l, i));
          if (locale != null)
          {
            i = locale.E.getTop();
            i = locale.a.getTop() + i + BaseChatItemLayout.bNV - this.l.getScrollY() - (this.bPF + this.dy);
            if (i != 0)
            {
              this.bPF += i;
              this.y += i;
              this.animView.offsetTopAndBottom(i);
            }
          }
          else
          {
            stop();
            return false;
            i = wja.a(this.Ii, this.l.getAdapter());
            int j = wja.a(this.Ih, this.l.getAdapter());
            if ((i >= this.l.getFirstVisiblePosition()) && (i <= this.l.getLastVisiblePosition()))
            {
              locale = (BaseBubbleBuilder.e)wja.a(wja.a(this.l, i));
              if (locale != null)
              {
                i = locale.E.getTop();
                i = locale.a.getTop() + i + BaseChatItemLayout.bNV - this.l.getScrollY() - (this.bPF + this.dy);
                if (i != 0)
                {
                  this.bPF += i;
                  this.y += i;
                  this.animView.offsetTopAndBottom(i);
                }
              }
              else
              {
                stop();
                return false;
              }
            }
            else if ((j >= this.l.getFirstVisiblePosition()) && (j <= this.l.getLastVisiblePosition()))
            {
              locale = (BaseBubbleBuilder.e)wja.a(wja.a(this.l, j));
              if (locale != null)
              {
                i = locale.E.getTop();
                i = locale.a.getTop() + i + BaseChatItemLayout.bNV - this.l.getScrollY() - (this.bPF + this.dy);
                if (i != 0)
                {
                  this.bPF += i;
                  this.y += i;
                  this.animView.offsetTopAndBottom(i);
                }
              }
              else
              {
                stop();
                return false;
              }
            }
            else if (i < this.l.getFirstVisiblePosition())
            {
              this.y = -1;
            }
            else if (j > this.l.getLastVisiblePosition())
            {
              this.step = 5;
              this.Ih = 0L;
              this.Ii = 0L;
            }
            else
            {
              stop();
              return false;
            }
          }
        }
      }
      if ((this.y > this.c.getHeight() + this.animView.getHeight()) || (this.x < -this.animView.getWidth() / 2) || (this.x > this.c.getWidth() + this.animView.getWidth() / 2))
      {
        stop();
        return false;
      }
      if (this.y <= 0) {
        switch (this.step)
        {
        }
      }
      for (;;)
      {
        return true;
        i = wja.a(this.Ii, this.l.getAdapter());
        if ((i < this.l.getFirstVisiblePosition()) || (i > this.l.getLastVisiblePosition()))
        {
          c(new Object[0]);
          a(this.x, this.y, new float[0]);
          continue;
          c(new Object[0]);
          a(this.x, this.y, new float[0]);
        }
      }
    }
    stop();
    return false;
  }
  
  @TargetApi(11)
  public boolean c(Object... paramVarArgs)
  {
    Rect localRect;
    if (this.animView == null)
    {
      this.img = ((Drawable)paramVarArgs[0]);
      if (this.img == null) {
        return false;
      }
      localRect = this.img.getBounds();
      this.animView = new View(this.l.getContext());
      this.animView.setBackgroundDrawable(this.img);
      this.c.addViewInLayout(this.animView, -1, AIOAnimationConatiner.i, false);
      if (localRect.isEmpty())
      {
        this.animView.layout(-this.img.getIntrinsicWidth(), -this.img.getIntrinsicHeight(), 0, 0);
        if (VersionUtils.isHoneycomb())
        {
          this.animView.setPivotX(this.animView.getWidth() / 2);
          this.animView.setPivotY(this.animView.getHeight());
          this.animView.setLayerType(2, null);
        }
        label161:
        this.step = 2;
        this.running = true;
        if (paramVarArgs.length <= 1) {
          break label301;
        }
      }
    }
    label301:
    for (paramVarArgs = paramVarArgs[1];; paramVarArgs = Integer.valueOf(0))
    {
      int i = ((Integer)paramVarArgs).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "start floor jumper. delay: " + i);
      }
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.Ij = (i + l);
      this.step = 1;
      return true;
      this.animView.layout(-localRect.width(), -localRect.height(), 0, 0);
      break;
      this.animView.offsetLeftAndRight(-this.animView.getRight());
      this.animView.offsetTopAndBottom(-this.animView.getBottom());
      break label161;
    }
  }
  
  public long en()
  {
    if (!this.running) {
      return -1L;
    }
    long l = AnimationUtils.currentAnimationTimeMillis();
    switch (this.step)
    {
    default: 
      return -1L;
    case 1: 
    case 3: 
      if (l < this.Ij) {
        return this.Ij - l;
      }
      BaseBubbleBuilder.e locale;
      if (this.step == 1)
      {
        this.Ij = l;
        localBaseChatItemLayout = a(0L);
        if (localBaseChatItemLayout != null)
        {
          locale = (BaseBubbleBuilder.e)wja.a(localBaseChatItemLayout);
          if (locale != null)
          {
            this.step = 2;
            this.Ih = 0L;
            this.Ii = locale.mMessage.uniseq;
            this.Ik = 0L;
            this.dx = 0;
            i = locale.E.getTop();
            this.dy = (localBaseChatItemLayout.getTop() + i + BaseChatItemLayout.bNV - this.l.getScrollY());
            this.bPE = a((locale.E.getLeft() + locale.E.getRight()) / 2, locale);
            this.bPF = 0;
            this.pJ = 0.0F;
            this.pK = ((float)(500.0F * density * Math.random()));
            this.y = 0;
            this.x = 0;
          }
        }
        for (;;)
        {
          return 0L;
          this.step = 5;
          this.bPE = (this.l.getWidth() / 2 + (int)(Math.random() * 160.0D * density - 80.0D));
          this.bPF = this.y;
          this.Ik = 0L;
          this.Ih = 0L;
          this.Ii = 0L;
          this.dx = 0;
          this.dy = 0;
          this.pJ = 0.0F;
          this.pK = ((float)(500.0F * density * Math.random()));
        }
      }
      BaseChatItemLayout localBaseChatItemLayout = a(this.Ii);
      if (localBaseChatItemLayout != null)
      {
        locale = (BaseBubbleBuilder.e)wja.a(localBaseChatItemLayout);
        if (locale != null)
        {
          this.bPE = this.x;
          this.bPF = this.y;
          this.step = 4;
          this.Ij = l;
          this.Ik = 0L;
          this.Ih = this.Ii;
          this.Ii = locale.mMessage.uniseq;
          this.pK = ((float)-(750.0D + (Math.random() - 1.0D) * 300.0D) * density);
          i = locale.E.getTop();
          this.dy = (localBaseChatItemLayout.getTop() + i + BaseChatItemLayout.bNV - this.l.getScrollY() - this.bPF);
          double d = (Math.sqrt(this.pK * this.pK + g * 2.0F * this.dy) - this.pK) / g;
          this.dx = (a(this.x, locale) - this.x);
          this.pJ = ((float)(this.dx / d));
        }
      }
      for (;;)
      {
        return 0L;
        this.bPE = this.x;
        this.bPF = this.y;
        this.step = 5;
        this.Ij = l;
        this.Ik = 0L;
        this.Ih = this.Ii;
        this.Ii = 0L;
        this.dx = 0;
        this.dy = 0;
        this.pJ = ((float)(Math.random() * 400.0D - 100.0D));
        this.pK = ((float)-(750.0D + (Math.random() - 1.0D) * 300.0D) * density);
      }
    case 2: 
    case 4: 
      if (this.Ik == 0L)
      {
        f1 = (float)(l - this.Ij) / 1000.0F;
        j = (int)(this.pK * f1 + g * f1 * f1 / 2.0F);
        int k = (int)(this.pJ * f1);
        f2 = this.pL;
        f3 = this.pK;
        f1 = Math.min(f2, Math.abs(f1 * g + f3)) / this.pL * 0.25F + 0.9F;
        i = j;
        if (j > this.dy)
        {
          i = this.dy;
          f1 = 1.0F;
          this.Ik = l;
        }
        this.y = (i + this.bPF);
        this.x = (this.bPE + k);
        a(this.x, this.y, new float[] { f1 });
        return FloorJumperSet.FRAME_DELAY;
      }
      if (l - this.Ik <= bPD)
      {
        f1 = (float)(l - this.Ik) / 1000.0F;
        j = Math.round((float)(l - this.Ik) / 10.0F);
        i = j;
        if (j >= aK.length) {
          i = aK.length - 1;
        }
        f1 = (int)(f1 * Math.max(Math.min(this.pJ, pH), -pH));
        f2 = aK[i];
        f3 = density;
        float f4 = aL[i];
        this.x = ((int)(f1 + (this.bPE + this.dx)));
        this.y = ((int)(this.bPF + this.dy - f2 * f3));
        a(this.x, this.y, new float[] { f4 });
        return FloorJumperSet.FRAME_DELAY;
      }
      this.y = (this.bPF + this.dy);
      a(this.x, this.y, new float[0]);
      i = (int)(500.0D + Math.random() * 800.0D - 400.0D);
      this.Ij = (AnimationUtils.currentAnimationTimeMillis() + i);
      this.step = 3;
      return i;
    }
    float f1 = (float)(l - this.Ij) / 1000.0F;
    int i = (int)(this.pK * f1 + g * f1 * f1 / 2.0F);
    int j = (int)(this.pJ * f1);
    float f2 = this.pL;
    float f3 = this.pK;
    f1 = Math.min(f2, Math.abs(f1 * g + f3)) / this.pL;
    this.y = (i + this.bPF);
    this.x = (this.bPE + j);
    if ((this.y > this.c.getHeight() + this.animView.getHeight()) || (this.x < -this.animView.getWidth() / 2) || (this.x > this.c.getWidth() + this.animView.getWidth() / 2))
    {
      a(0, this.animView.getWidth(), new float[0]);
      stop();
      return -1L;
    }
    a(this.x, this.y, new float[] { f1 * 0.25F + 0.9F });
    return FloorJumperSet.FRAME_DELAY;
  }
  
  public void stop()
  {
    this.running = false;
    this.c.removeViewInLayout(this.animView);
    this.img = null;
    this.animView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wno
 * JD-Core Version:    0.7.0.1
 */