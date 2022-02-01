import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.olympic.activity.ARTipsCircleProgress;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class akqe
{
  private akqe.a a;
  private ViewConfiguration b;
  private Handler di;
  private ViewGroup en;
  private RelativeLayout f;
  private LayoutInflater mLayoutInflater;
  private Resources mResources;
  
  public akqe(Context paramContext, RelativeLayout paramRelativeLayout, akqe.a parama)
  {
    this.mLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mResources = paramContext.getResources();
    this.b = ViewConfiguration.get(paramContext);
    this.di = new akqe.d(this);
    this.f = paramRelativeLayout;
    this.a = parama;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, akqe.b paramb, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramb, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, akqe.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramb, Boolean.valueOf(paramBoolean1) }));
    }
    akqe.f localf = new akqe.f(null);
    localf.mTag = paramInt1;
    localf.mType = paramInt2;
    localf.cuf = paramBoolean1;
    localf.mTitle = paramString1;
    localf.mContent = paramString2;
    localf.jdField_a_of_type_Akqe$b = paramb;
    localf.cug = paramBoolean2;
    this.di.removeMessages(101);
    paramString1 = this.di.obtainMessage(100);
    paramString1.obj = localf;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, akqe.c paramc, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramc, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    akqe.f localf = new akqe.f(null);
    localf.mTag = paramInt1;
    localf.mType = paramInt2;
    localf.cuf = paramBoolean;
    localf.mTips = paramString1;
    localf.mDescription = paramString2;
    localf.kN = paramString3;
    localf.jdField_a_of_type_Akqe$c = paramc;
    localf.mProgress = paramInt3;
    this.di.removeMessages(101);
    paramString1 = this.di.obtainMessage(100);
    paramString1.obj = localf;
    paramString1.sendToTarget();
  }
  
  private void a(akqe.f paramf)
  {
    if (this.en == null) {
      this.en = u();
    }
    akqe.g localg;
    int i;
    if (this.en != null)
    {
      this.en.setTag(2131362928, paramf);
      localg = (akqe.g)this.en.getTag();
      if (localg != null)
      {
        i = paramf.mType;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label352;
        }
        localg.eo.setVisibility(0);
        localg.ep.setVisibility(8);
        localg.Fw.setVisibility(8);
        localg.Wv.setText(paramf.mTips);
        if (!TextUtils.isEmpty(paramf.mDescription)) {
          break label213;
        }
        localg.Ww.setVisibility(8);
        localg.Wv.setTextSize(1, 16.0F);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      if (this.en.getParent() == null) {
        dCQ();
      }
      if (paramf.cuf)
      {
        this.di.removeMessages(101);
        paramf = this.di.obtainMessage(101);
        this.di.sendMessageDelayed(paramf, 5000L);
      }
      return;
      label213:
      localg.Ww.setVisibility(0);
      localg.Ww.setText(paramf.mDescription);
      localg.Wv.setTextSize(1, 20.0F);
      break;
      localg.Wx.setVisibility(8);
      localg.a.setVisibility(8);
      localg.eo.setEnabled(false);
      continue;
      localg.Wx.setVisibility(0);
      localg.a.setVisibility(8);
      localg.Wx.setText(paramf.kN);
      localg.eo.setEnabled(true);
      continue;
      localg.Wx.setVisibility(8);
      localg.a.setVisibility(0);
      localg.a.setProgress(paramf.mProgress);
      localg.eo.setEnabled(false);
      continue;
      label352:
      if ((i == 10) || (i == 11))
      {
        localg.eo.setVisibility(8);
        localg.Fw.setVisibility(8);
        localg.ep.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramf.cug)
        {
          localg.nP.setVisibility(0);
          localg.Wy.setText(paramf.mTitle);
          localg.Wz.setText(paramf.mContent);
          localg.eq.setOnClickListener(new akqg(this, paramf));
          localLayoutParams = (FrameLayout.LayoutParams)localg.ep.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localg.ep.setLayoutParams(localLayoutParams);
          break;
          localg.nP.setVisibility(4);
          break label405;
          localg.er.setVisibility(8);
          localLayoutParams.bottomMargin = wja.dp2px(20.0F, this.mResources);
          continue;
          localg.er.setVisibility(0);
          localg.WA.setOnClickListener(new akqh(this, paramf));
          localLayoutParams.bottomMargin = wja.dp2px(0.0F, this.mResources);
        }
      }
      label405:
      if (i == 12)
      {
        localg.eo.setVisibility(8);
        localg.ep.setVisibility(8);
        localg.Fw.setVisibility(0);
        if (paramf.jdField_a_of_type_Akqe$e != null)
        {
          localg.WB.setOnClickListener(new akqi(this, paramf));
          localg.WC.setOnClickListener(new akqj(this, paramf));
        }
      }
    }
  }
  
  private void dCQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "addTipsWithAnim");
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    this.f.addView(this.en, (ViewGroup.LayoutParams)localObject);
    this.en.setVisibility(4);
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(400L);
    ((ValueAnimator)localObject).addUpdateListener(new akqk(this));
    ((ValueAnimator)localObject).addListener(new akql(this));
    ((ValueAnimator)localObject).start();
    if (this.a != null) {
      this.a.fq(true);
    }
  }
  
  private void dCR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "removeTipsWithAnim");
    }
    if (this.en != null)
    {
      ViewGroup localViewGroup = this.en;
      this.en = null;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener(new akqm(this, localViewGroup));
      localValueAnimator.addListener(new akqn(this, localViewGroup));
      localValueAnimator.start();
      if (this.a != null) {
        this.a.fq(false);
      }
    }
  }
  
  private ViewGroup u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.mLayoutInflater.inflate(2131558743, null);
    if (localViewGroup != null)
    {
      akqe.g localg = new akqe.g(null);
      localg.eo = ((ViewGroup)localViewGroup.findViewById(2131362929));
      localg.Wv = ((TextView)localViewGroup.findViewById(2131362933));
      localg.Ww = ((TextView)localViewGroup.findViewById(2131362931));
      localg.Wx = ((TextView)localViewGroup.findViewById(2131362930));
      localg.a = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362932));
      localg.ep = ((ViewGroup)localViewGroup.findViewById(2131362917));
      localg.eq = ((ViewGroup)localViewGroup.findViewById(2131362919));
      localg.Wy = ((TextView)localViewGroup.findViewById(2131362921));
      localg.Wz = ((TextView)localViewGroup.findViewById(2131362920));
      localg.er = ((ViewGroup)localViewGroup.findViewById(2131362922));
      localg.WA = ((TextView)localViewGroup.findViewById(2131362923));
      localg.Fw = localViewGroup.findViewById(2131362924);
      localg.WB = ((TextView)localViewGroup.findViewById(2131362925));
      localg.WC = ((TextView)localViewGroup.findViewById(2131362927));
      localg.nP = ((ImageView)localViewGroup.findViewById(2131362918));
      localViewGroup.setTag(localg);
      localViewGroup.setOnTouchListener(new akqf(this));
    }
    return localViewGroup;
  }
  
  public int Hb()
  {
    if (this.en != null)
    {
      akqe.f localf = (akqe.f)this.en.getTag(2131362928);
      if (localf != null) {
        return localf.mTag;
      }
    }
    return 0;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, akqe.b paramb)
  {
    a(paramInt, 11, paramString1, paramString2, paramb, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, akqe.c paramc, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramc, 0, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, akqe.b paramb, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramb, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, akqe.c paramc)
  {
    a(paramString1, paramString2, paramc, false);
  }
  
  public void a(String paramString1, String paramString2, akqe.c paramc, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramc, paramBoolean);
  }
  
  public void dCP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("dismissTips", new Object[0]));
    }
    this.di.removeMessages(100);
    if (this.en != null) {
      this.di.obtainMessage(101).sendToTarget();
    }
  }
  
  public void du(int paramInt, String paramString)
  {
    a(paramInt, 1, paramString, null, null, null, 0, true);
  }
  
  public void fu(String paramString, int paramInt)
  {
    a(0, 3, paramString, null, null, null, paramInt, false);
  }
  
  public boolean isVisible()
  {
    return (this.en != null) && (this.en.getVisibility() == 0);
  }
  
  public void showTips(String paramString)
  {
    du(0, paramString);
  }
  
  public void v(int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, 1, paramString, null, null, null, 0, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void fq(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void Hj();
    
    public abstract void OV();
  }
  
  public static abstract interface c
  {
    public abstract void cTm();
  }
  
  static class d
    extends Handler
  {
    private WeakReference<akqe> mRef;
    
    public d(akqe paramakqe)
    {
      this.mRef = new WeakReference(paramakqe);
    }
    
    public void handleMessage(Message paramMessage)
    {
      akqe localakqe = (akqe)this.mRef.get();
      if (localakqe == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 100: 
        akqe.a(localakqe, (akqe.f)paramMessage.obj);
        return;
      }
      akqe.a(localakqe);
    }
  }
  
  public static abstract interface e
  {
    public abstract void dCS();
    
    public abstract void dCT();
  }
  
  class f
  {
    public akqe.b a;
    public akqe.c a;
    public akqe.e a;
    public boolean cuf;
    public boolean cug = true;
    public String kN;
    public String mContent;
    public String mDescription;
    public int mProgress;
    public int mTag;
    public String mTips;
    public String mTitle;
    public int mType;
    
    private f() {}
  }
  
  class g
  {
    public View Fw;
    public TextView WA;
    public TextView WB;
    public TextView WC;
    public TextView Wv;
    public TextView Ww;
    public TextView Wx;
    public TextView Wy;
    public TextView Wz;
    public ARTipsCircleProgress a;
    public ViewGroup eo;
    public ViewGroup ep;
    public ViewGroup eq;
    public ViewGroup er;
    public ImageView nP;
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqe
 * JD-Core Version:    0.7.0.1
 */