package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axiy;
import axjj.a.a;
import axjr;
import axjs;
import axjt;
import axju;
import axjv;
import axjw;
import axjx;
import axjy;
import axjz;
import axka;
import axkb;
import axkc;
import axkd;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import rpq;

public class AEEditorAILoadingView
  extends FrameLayout
{
  protected static String cVi = axjj.a.a.cVa + File.separator + "ProcessAnimation" + File.separator;
  protected static String cVj = "ComicTextAnimation1";
  protected static String cVk = "ComicTextAnimation2";
  private View MI;
  private View MJ;
  private View MK;
  private a a;
  private TextView ahj;
  private TextView ahk;
  private TextView ahl;
  private volatile boolean dvc;
  private ApolloLottieAnim e;
  private int eFM;
  private int eFN;
  private ApolloLottieAnim f;
  private ApolloLottieAnim g;
  private ApolloLottieAnim h;
  private Button hV;
  protected LinearLayout mt;
  private RelativeLayout nW;
  protected RelativeLayout nX;
  private DiniFlyAnimationView p;
  private DiniFlyAnimationView q;
  private DiniFlyAnimationView r;
  private DiniFlyAnimationView s;
  private String scene;
  
  public AEEditorAILoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorAILoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorAILoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (aON())
    {
      LayoutInflater.from(paramContext).inflate(2131558615, this);
      eLM();
      return;
    }
    LayoutInflater.from(paramContext).inflate(2131558616, this);
    eLL();
  }
  
  public static boolean aON()
  {
    Object localObject = cVi + "ImageAnimation1";
    String str1 = cVi + "ImageAnimation2";
    String str2 = cVi + "TextAnimation1";
    String str3 = cVi + "TextAnimation2";
    String str4 = cVi + "VideoTextAnimation1";
    String str5 = cVi + "VideoTextAnimation2";
    String str6 = cVi + cVj;
    String str7 = cVi + cVk;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(str1);
    localArrayList.add(str2);
    localArrayList.add(str3);
    localArrayList.add(str5);
    localArrayList.add(str4);
    localArrayList.add(str6);
    localArrayList.add(str7);
    localObject = localArrayList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!ug((String)((Iterator)localObject).next())) {
        break label344;
      }
      i += 1;
    }
    label344:
    for (;;)
    {
      break;
      axiy.i("AEEditorAILoadingView", "lottie file count: " + i);
      if ((i >= 0) && (i < 8))
      {
        ThreadManager.excute(new AEEditorAILoadingView.15(), 64, null, true);
        return false;
      }
      return true;
    }
  }
  
  private void dIT()
  {
    this.MI = findViewById(2131371159);
    this.nX = ((RelativeLayout)findViewById(2131377366));
    this.p = ((DiniFlyAnimationView)findViewById(2131369570));
    this.q = ((DiniFlyAnimationView)findViewById(2131369564));
    this.r = ((DiniFlyAnimationView)findViewById(2131369569));
    this.s = ((DiniFlyAnimationView)findViewById(2131369563));
    this.nW = ((RelativeLayout)findViewById(2131377368));
    this.ahj = ((TextView)findViewById(2131379402));
    this.ahk = ((TextView)findViewById(2131379404));
    this.ahl = ((TextView)findViewById(2131379407));
    this.MJ = findViewById(2131377198);
    this.MK = findViewById(2131382237);
    this.eFM = rpq.dip2px(getContext(), 7.0F);
    this.s.loop(true);
    this.q.loop(true);
    this.e = new ApolloLottieAnim(null, getContext());
    this.f = new ApolloLottieAnim(null, getContext());
    this.g = new ApolloLottieAnim(null, getContext());
    this.h = new ApolloLottieAnim(null, getContext());
    this.f.a(getContext(), this.p, cVi + "ImageAnimation1" + File.separator, true);
    this.h.a(getContext(), this.q, cVi + "ImageAnimation2" + File.separator, false);
    this.e.a(getContext(), this.r, HR(), true);
    this.g.a(getContext(), this.s, HS(), false);
    eLN();
  }
  
  private void eLL()
  {
    eLN();
    this.mt = ((LinearLayout)findViewById(2131370620));
  }
  
  private void eLM()
  {
    dIT();
    this.p.addAnimatorListener(new axjx(this));
    this.r.addAnimatorListener(new axjy(this));
    this.q.addAnimatorListener(new axjz(this));
    this.q.addAnimatorUpdateListener(new axka(this));
  }
  
  private void eLN()
  {
    this.hV = ((Button)findViewById(2131364229));
    this.hV.setOnClickListener(new axkb(this));
  }
  
  private void eLO()
  {
    axiy.d("AEEditorAILoadingView", "showResultAnimation start.");
    this.q.cancelAnimation();
    this.s.cancelAnimation();
    this.q.animate().setDuration(100L).alpha(0.0F).start();
    this.s.animate().setDuration(100L).alpha(0.0F).start();
    int i;
    if (getResources().getString(2131689947).equals(this.scene))
    {
      i = 1;
      this.MK.setVisibility(8);
      this.MJ.setVisibility(8);
    }
    for (;;)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator1.setDuration(1000L);
      localValueAnimator1.addUpdateListener(new axkc(this));
      localValueAnimator1.addListener(new axkd(this));
      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator2.setDuration(1000L);
      localValueAnimator2.addUpdateListener(new axjr(this));
      ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator3.setDuration(1000L);
      localValueAnimator3.addUpdateListener(new axjs(this));
      ValueAnimator localValueAnimator4 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator4.setDuration(500L);
      localValueAnimator4.addUpdateListener(new axjt(this));
      if (i == 0)
      {
        this.MJ.setAlpha(0.0F);
        this.MJ.setVisibility(0);
        this.MJ.setMinimumWidth(this.ahj.getWidth() + Utils.dp2px(20.0D));
        ValueAnimator localValueAnimator5 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localValueAnimator5.setDuration(1000L);
        localValueAnimator5.addUpdateListener(new axju(this));
        localAnimatorSet.play(localValueAnimator4).before(localValueAnimator1);
        localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2).with(localValueAnimator5);
        localAnimatorSet.play(localValueAnimator3).after(localValueAnimator1);
      }
      for (;;)
      {
        localAnimatorSet.addListener(new axjv(this));
        localAnimatorSet.start();
        axiy.d("AEEditorAILoadingView", "showResultAnimation end.");
        return;
        localAnimatorSet.play(localValueAnimator4).before(localValueAnimator1);
        localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2);
        localAnimatorSet.play(localValueAnimator3).after(localValueAnimator1);
      }
      i = 0;
    }
  }
  
  public static float f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 * paramFloat2 / paramFloat1 - 1.0F;
    return (paramFloat1 * (paramFloat1 * paramFloat1 * paramFloat1 * paramFloat1) + 1.0F) * (paramFloat4 - paramFloat3) + paramFloat3;
  }
  
  private static boolean ug(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      paramString = paramString.listFiles(new axjw());
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String HR()
  {
    return cVi + "TextAnimation1" + File.separator;
  }
  
  public String HS()
  {
    return cVi + "TextAnimation2" + File.separator;
  }
  
  public void cancelLoading()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("cancelLoading: ");
    if (getParent() == null) {}
    for (boolean bool = true;; bool = false)
    {
      axiy.d("AEEditorAILoadingView", bool);
      if (getParent() != null) {
        break;
      }
      return;
    }
    ((ViewGroup)getParent()).removeAllViews();
  }
  
  public void setLoadingListener(a parama)
  {
    this.a = parama;
  }
  
  public void setSceneText(String paramString1, String paramString2, String paramString3)
  {
    this.scene = paramString1;
    if (this.ahj != null) {
      this.ahj.setText(paramString1);
    }
    if (this.ahk != null) {
      this.ahk.setText(paramString2);
    }
    if (this.ahl != null) {
      this.ahl.setText(paramString3);
    }
  }
  
  public void setShowResult(boolean paramBoolean)
  {
    axiy.d("AEEditorAILoadingView", "setShowResult: " + paramBoolean);
    if (this.mt != null)
    {
      this.mt.post(new AEEditorAILoadingView.1(this));
      return;
    }
    this.q.post(new AEEditorAILoadingView.2(this));
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView
 * JD-Core Version:    0.7.0.1
 */