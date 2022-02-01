import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.RateWidget.1;
import com.tencent.biz.qqstory.view.widget.RateWidget.2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar.a;
import java.text.DecimalFormat;

public class rsr
  extends rsk
  implements View.OnClickListener, RateWidgetRatingBar.a
{
  private RateWidgetRatingBar a = (RateWidgetRatingBar)this.pi.findViewById(2131376628);
  private boolean aJj;
  private rsr.a jdField_b_of_type_Rsr$a;
  private rsr.b jdField_b_of_type_Rsr$b;
  private Handler bu = new Handler(Looper.getMainLooper());
  private ViewGroup cC = (ViewGroup)this.pi.findViewById(2131376623);
  private ViewGroup cD;
  private ImageView gX;
  private TextView ze = (TextView)this.pi.findViewById(2131380874);
  private TextView zf;
  private TextView zg;
  private TextView zh;
  
  public rsr(Context paramContext)
  {
    super(paramContext, 2131561129);
    this.a.setOnRatingChangeListener(this);
    try
    {
      this.cC.setBackgroundResource(2130845467);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      ram.e("RateWidget", "RateWidget set background failed : %s", paramContext);
    }
  }
  
  public String[] C()
  {
    return new String[] { this.ze.getText().toString() };
  }
  
  public void a(rsr.a parama, boolean paramBoolean)
  {
    if (this.pj != null)
    {
      this.jdField_b_of_type_Rsr$a = parama;
      parama = this.gX;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 8)
    {
      parama.setVisibility(i);
      return;
    }
  }
  
  public void a(rsr.b paramb)
  {
    this.jdField_b_of_type_Rsr$b = paramb;
  }
  
  public Rect[] a()
  {
    Rect localRect = new Rect();
    this.ze.getHitRect(localRect);
    return new Rect[] { localRect };
  }
  
  protected View aA()
  {
    View localView = LayoutInflater.from(this.pi.getContext()).inflate(2131561128, null).findViewById(2131376622);
    localView.setLayoutParams(new ViewGroup.LayoutParams(rpq.dip2px(this.pi.getContext(), 225.0F), rpq.dip2px(this.pi.getContext(), 54.0F)));
    this.zf = ((TextView)localView.findViewById(2131380872));
    this.zg = ((TextView)localView.findViewById(2131380873));
    this.zh = ((TextView)localView.findViewById(2131380558));
    this.cD = ((ViewGroup)localView.findViewById(2131370627));
    this.gX = ((ImageView)localView.findViewById(2131362978));
    this.cD.setOnClickListener(this);
    return localView;
  }
  
  public void ae(long paramLong, int paramInt)
  {
    if (this.pj == null) {
      return;
    }
    if (paramInt <= 0)
    {
      this.zf.setText("0");
      this.zg.setText("0");
      this.zh.setText("0人参与");
      return;
    }
    float f = (float)paramLong * 1.0F / (paramInt * 1.0F);
    Object localObject = new DecimalFormat(".0").format(f);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.zf.setText("0");
      this.zg.setText("0");
      this.zh.setText("0人参与");
      return;
    }
    localObject = ((String)localObject).split("\\.");
    if (localObject.length == 1)
    {
      this.zf.setText(localObject[0]);
      this.zg.setText("0");
    }
    for (;;)
    {
      this.zh.setText(paramInt + acfp.m(2131713609));
      return;
      if (localObject.length == 2)
      {
        this.zf.setText(localObject[0]);
        this.zg.setText(localObject[1]);
      }
    }
  }
  
  public void aj(float paramFloat)
  {
    if (this.jdField_b_of_type_Rsr$b != null) {
      this.jdField_b_of_type_Rsr$b.a(this, paramFloat);
    }
  }
  
  protected void bwg()
  {
    if (this.pj == null) {
      return;
    }
    float f1 = this.nV;
    float f2 = this.mScale;
    float f3 = this.mOffsetX;
    float f4 = this.nW;
    float f5 = this.mScale;
    float f6 = this.mOffsetY;
    int i = this.pj.getHeight();
    int j = this.pj.getWidth();
    int k = this.pi.getWidth();
    int m = this.pi.getHeight();
    float f7 = -(m * 1.0F / 2.0F + i * 1.0F / 2.0F - rpq.dip2px(this.pj.getContext(), 4.0F));
    float[] arrayOfFloat = rpg.a(rpq.dip2px(this.pj.getContext(), 37.0F), f7, this.mRotation);
    f7 = arrayOfFloat[0];
    float f8 = arrayOfFloat[1];
    this.pj.setX(f1 * f2 + f3 + this.nM * f7 - j * 1.0F / 2.0F);
    this.pj.setY(f4 * f5 + f6 + this.nN * f8 - i * 1.0F / 2.0F);
    this.pj.setRotation(this.mRotation);
    this.pj.setScaleX(this.nM);
    this.pj.setScaleY(this.nN);
    ram.b("InteractPasterWidget", "relayoutAttendView %d", Integer.valueOf(this.pj.hashCode()));
    ram.d("InteractPasterWidget", "relayoutAttendView 2widgets(%d, %d, %d, %d)  stack=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), rov.getStackTrace(5) });
    ram.a("InteractPasterWidget", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.mOffsetX), Float.valueOf(this.mOffsetY), Float.valueOf(f7), Float.valueOf(f8));
  }
  
  public String getHint()
  {
    return this.ze.getHint().toString();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Rsr$a != null) {
        this.jdField_b_of_type_Rsr$a.a(this);
      }
    }
  }
  
  public void setRatable(boolean paramBoolean)
  {
    this.a.setRatable(paramBoolean);
  }
  
  public void setRate(float paramFloat)
  {
    this.a.setRating((int)paramFloat);
  }
  
  public void t(String[] paramArrayOfString)
  {
    this.ze.setText(paramArrayOfString[0]);
  }
  
  public void uj(boolean paramBoolean)
  {
    TextView localTextView = this.ze;
    if (paramBoolean) {}
    for (int i = 2130845462;; i = 0)
    {
      localTextView.setBackgroundResource(i);
      return;
    }
  }
  
  public void uk(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      this.aJj = false;
      this.bu.removeCallbacksAndMessages(null);
      while (i < 2500)
      {
        this.bu.postDelayed(new RateWidget.1(this), i);
        i += 500;
      }
      this.bu.postDelayed(new RateWidget.2(this), i);
      return;
    }
    this.aJj = false;
    this.bu.removeCallbacksAndMessages(null);
    uj(false);
  }
  
  public static abstract interface a
  {
    public abstract void a(rsr paramrsr);
  }
  
  public static abstract interface b
  {
    public abstract void a(rsr paramrsr, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsr
 * JD-Core Version:    0.7.0.1
 */