import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;

public class ayup
  extends aygy
{
  private View Nu;
  private View Nv;
  private Activity activity;
  private aytw b;
  private View containerView;
  private boolean dAW;
  
  public ayup(@NonNull aytw paramaytw, Activity paramActivity)
  {
    super(paramaytw);
    this.b = paramaytw;
    this.activity = paramActivity;
    if (rma.a().tG() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.dAW = bool;
      return;
    }
  }
  
  private void adL()
  {
    aqha.a(this.activity, 230).setMessage(2131718243).setPositiveButton(2131717752, new ayut(this)).setNegativeButton(2131720223, new ayus(this)).show();
  }
  
  private void eTG()
  {
    aqha.a(this.activity, 230).setMessage(2131718244).setPositiveButton(2131721058, new ayuv(this)).setNegativeButton(2131691970, new ayuu(this)).show();
  }
  
  private void hh(String paramString)
  {
    String str = getResources().getString(2131718106);
    avpw.d locald = avpw.d.a();
    avpw.a(this.activity, locald, paramString, QQStoryContext.a().dE(), "", 1010, str, false);
  }
  
  private void initView()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)y(2131366264);
    this.containerView = LayoutInflater.from(getContext()).inflate(2131562454, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, ayxa.sNotchHeight, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.Nu = this.containerView.findViewById(2131376009);
    this.Nv = this.containerView.findViewById(2131376008);
    if (this.dAW)
    {
      this.Nu.setVisibility(8);
      this.Nv.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.containerView, localLayoutParams);
      return;
      this.Nu.setOnClickListener(new ayuq(this));
      this.Nv.setOnClickListener(new ayur(this));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      arxa.a().showToast(2131717976);
      this.b.bwI = true;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    awig.a().Wp();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.containerView == null);
      this.containerView.setVisibility(0);
      return;
    } while (this.containerView == null);
    this.containerView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayup
 * JD-Core Version:    0.7.0.1
 */