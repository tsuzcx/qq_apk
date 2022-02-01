import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ahym
{
  public final ahym.a a;
  private ahym.c a;
  public Interpolator m;
  public final AtomicInteger mCounter = new AtomicInteger(0);
  public Handler mHandler;
  public final Random mRandom;
  public Interpolator n;
  
  public ahym(HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_Ahym$a = new ahym.a(paramHeartLayout);
    this.mRandom = new Random(System.currentTimeMillis());
    this.mHandler = new Handler(Looper.getMainLooper());
    this.m = new OvershootInterpolator(1.0F);
    this.n = new LinearInterpolator();
  }
  
  public ahym.a a()
  {
    return this.jdField_a_of_type_Ahym$a;
  }
  
  public Path a(int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger, View paramView)
  {
    Random localRandom = this.mRandom;
    Path localPath = new Path();
    label87:
    label99:
    int i;
    int j;
    int k;
    int i1;
    if (!this.jdField_a_of_type_Ahym$a.ciZ) {
      if ((paramInt1 < 0) || (paramInt1 > paramView.getWidth()))
      {
        this.jdField_a_of_type_Ahym$a.dcg = ((paramView.getWidth() - this.jdField_a_of_type_Ahym$a.dcn) / 2);
        if ((paramInt2 >= 0) && (paramInt2 <= paramView.getHeight())) {
          break label402;
        }
        this.jdField_a_of_type_Ahym$a.dch = this.jdField_a_of_type_Ahym$a.dco;
        if (!this.mRandom.nextBoolean()) {
          break label429;
        }
        paramInt1 = 1;
        i = paramInt1 * (localRandom.nextInt(this.jdField_a_of_type_Ahym$a.dci) + this.jdField_a_of_type_Ahym$a.dcj);
        j = paramInt1 * (localRandom.nextInt(this.jdField_a_of_type_Ahym$a.dci) + this.jdField_a_of_type_Ahym$a.dcj);
        k = paramView.getHeight() - this.jdField_a_of_type_Ahym$a.dch;
        paramInt1 = (int)(paramAtomicInteger.intValue() * 4 * this.jdField_a_of_type_Ahym$a.density);
        paramInt2 = this.jdField_a_of_type_Ahym$a.dcm;
        paramInt2 = localRandom.nextInt(this.jdField_a_of_type_Ahym$a.dcl) + (paramInt1 + paramInt2);
        i1 = paramInt2 / this.jdField_a_of_type_Ahym$a.dck;
        paramInt1 = k - paramInt2;
        if (paramInt1 >= 0) {
          break label648;
        }
        paramInt1 = 0;
      }
    }
    label648:
    for (;;)
    {
      paramInt2 = k - paramInt2 / 2;
      if (paramInt2 < 0) {
        paramInt2 = 0;
      }
      for (;;)
      {
        localPath.moveTo(this.jdField_a_of_type_Ahym$a.dcg, k);
        localPath.cubicTo(this.jdField_a_of_type_Ahym$a.dcg, k - i1, this.jdField_a_of_type_Ahym$a.dcg + i, paramInt2 + i1, this.jdField_a_of_type_Ahym$a.dcg + i, paramInt2);
        localPath.moveTo(this.jdField_a_of_type_Ahym$a.dcg + i, paramInt2);
        if (paramInt2 - i1 >= 0) {
          localPath.cubicTo(this.jdField_a_of_type_Ahym$a.dcg + i, paramInt2 - i1, this.jdField_a_of_type_Ahym$a.dcg + j, paramInt1 + i1, this.jdField_a_of_type_Ahym$a.dcg + j, paramInt1);
        }
        return localPath;
        this.jdField_a_of_type_Ahym$a.dcg = (paramInt1 - this.jdField_a_of_type_Ahym$a.dcn / 2);
        break;
        label402:
        this.jdField_a_of_type_Ahym$a.dch = (paramView.getHeight() - paramInt2 + this.jdField_a_of_type_Ahym$a.dcn / 2);
        break label87;
        label429:
        paramInt1 = -1;
        break label99;
        k = this.jdField_a_of_type_Ahym$a.dcq;
        i1 = this.jdField_a_of_type_Ahym$a.dcp;
        int i2 = this.jdField_a_of_type_Ahym$a.dcn / 2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.mRandom.nextBoolean())
        {
          i = 1;
          i3 = localRandom.nextInt(this.jdField_a_of_type_Ahym$a.dci);
          i4 = this.jdField_a_of_type_Ahym$a.dcj;
          i5 = localRandom.nextInt(this.jdField_a_of_type_Ahym$a.dci);
          i6 = this.jdField_a_of_type_Ahym$a.dcj;
          j = Math.abs(k - paramInt2) / (this.mRandom.nextInt(3) + 2);
          if (k <= paramInt2) {
            break label635;
          }
          j = k - j;
        }
        for (;;)
        {
          localPath.moveTo(paramInt1 - this.jdField_a_of_type_Ahym$a.dcn / 2, paramInt2 - this.jdField_a_of_type_Ahym$a.dco / 2);
          localPath.cubicTo(i * (i3 + i4) + paramInt1, j, paramInt1 - i * (i5 + i6), j, i1 - i2, k);
          return localPath;
          i = -1;
          break;
          label635:
          j += k;
        }
      }
    }
  }
  
  public void a(ahym.c paramc)
  {
    this.jdField_a_of_type_Ahym$c = paramc;
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, ViewGroup paramViewGroup, long paramLong, int paramInt3)
  {
    paramView.setTag(2131374881, Boolean.valueOf(true));
    paramViewGroup.addView(paramView, new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ahym.b localb = new ahym.b(a((int)paramFloat1, (int)paramFloat2, this.mCounter, paramViewGroup), bf(), paramViewGroup, paramView, this.jdField_a_of_type_Ahym$a);
    if (paramLong > 0L) {}
    for (;;)
    {
      localb.setDuration(paramLong);
      localb.setInterpolator(this.n);
      localb.dcr = paramInt3;
      localb.b = this.jdField_a_of_type_Ahym$c;
      localb.o = this.m;
      localb.setAnimationListener(new ahyn(this, paramViewGroup, paramView));
      paramView.startAnimation(localb);
      return;
      paramLong = this.jdField_a_of_type_Ahym$a.cav;
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, ViewGroup paramViewGroup)
  {
    a(paramView, paramFloat1, paramFloat2, paramViewGroup, -1L, 0);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, long paramLong, int paramInt)
  {
    a(paramView, paramFloat1, paramFloat2, this.jdField_a_of_type_Ahym$a.dcn, this.jdField_a_of_type_Ahym$a.dco, paramViewGroup, paramLong, paramInt);
  }
  
  public float bf()
  {
    return 1.0F * (this.mRandom.nextInt(40) - 20);
  }
  
  public static class a
  {
    public static float wI = 1.0F;
    public int cav = 3000;
    public boolean ciZ;
    public boolean cja = true;
    public int dcg = 250;
    public int dch;
    public int dci = 20;
    public int dcj = 10;
    public int dck = 8;
    public int dcl = 150;
    public int dcm = 300;
    public int dcn = 32;
    public int dco = 27;
    public int dcp;
    public int dcq;
    public float density;
    public float wJ = 1.0F;
    
    private a() {}
    
    public a(HeartLayout paramHeartLayout)
    {
      this.density = paramHeartLayout.getContext().getResources().getDisplayMetrics().density;
      this.dcg = ((int)((paramHeartLayout.getWidth() - this.density * 32.0F) / 2.0F));
      this.dch = ((int)(this.density * 27.0F));
      this.dcn = ((int)(this.density * 32.0F));
      this.dco = ((int)(this.density * 27.0F));
      this.dci = ((int)(this.density * 20.0F));
      this.dcj = ((int)(this.density * 10.0F));
      this.dcl = ((int)(this.density * 150.0F));
      this.dcm = ((int)(this.density * 300.0F));
    }
  }
  
  static class b
    extends Animation
  {
    public ahym.a a;
    public ahym.c b;
    public PathMeasure b;
    public int dcr;
    public float gi;
    public float mRotation;
    public View mView;
    public Interpolator o;
    
    @TargetApi(11)
    public b(Path paramPath, float paramFloat, View paramView1, View paramView2, ahym.a parama)
    {
      this.b = new PathMeasure(paramPath, false);
      this.gi = this.b.getLength();
      this.mView = paramView2;
      this.mRotation = paramFloat;
      this.a = parama;
      paramView1.setLayerType(2, null);
    }
    
    private static float b(int paramInt, float paramFloat)
    {
      switch (paramInt)
      {
      default: 
        return (float)Math.pow(paramFloat, 2.0D);
      case 1: 
        if (paramFloat < 0.8D) {
          return 0.0F;
        }
        return 5.0F * paramFloat - 4.0F;
      }
      return 0.5F * paramFloat + 0.5F;
    }
    
    @TargetApi(11)
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      Object localObject = paramTransformation.getMatrix();
      this.b.getMatrix(this.gi * paramFloat, (Matrix)localObject, 1);
      float f;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.mView;
        f = this.mRotation;
        ahym.a locala = this.a;
        ((View)localObject).setRotation(f * paramFloat * ahym.a.wI);
      }
      if (this.a.cja)
      {
        f = this.o.getInterpolation(paramFloat);
        this.mView.setScaleX(this.a.wJ * f);
        this.mView.setScaleY(f * this.a.wJ);
      }
      paramTransformation.setAlpha(1.0F - b(this.dcr, paramFloat));
    }
  }
  
  public static abstract interface c
  {
    public abstract void g(Animation paramAnimation);
    
    public abstract void h(Animation paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahym
 * JD-Core Version:    0.7.0.1
 */