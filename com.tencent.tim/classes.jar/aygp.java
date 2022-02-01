import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class aygp
  extends aygy
  implements View.OnClickListener
{
  protected aypf a;
  protected String azM;
  protected TextView yo;
  protected ViewStub z;
  
  public aygp(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private void bsO()
  {
    bsQ();
    if (this.a.getVisibility() != 0)
    {
      this.a.setVisibility(0);
      this.a.c.requestFocus();
      aurd.aO(this.a.c);
    }
  }
  
  private void bsP()
  {
    if ((this.a != null) && (this.a.getVisibility() == 0))
    {
      this.a.setVisibility(4);
      aurd.hide(this.a.c);
      this.a.c.clearFocus();
    }
  }
  
  private void bsQ()
  {
    if (this.a == null)
    {
      this.a = new aypf(this.z.inflate());
      this.a.p(new aygr(this));
      this.a.q(new aygs(this));
    }
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    paramayqb.g.videoLabel = mS();
    aygz localaygz;
    String str;
    if (!TextUtils.isEmpty(mS()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localaygz = this.b;
        str = mS();
        if (!this.b.La()) {
          break label89;
        }
      }
    }
    label89:
    for (paramayqb = "2";; paramayqb = "1")
    {
      localaygz.c("pub_tag", 0, 0, new String[] { "1", str, paramayqb });
      return;
      paramInt = 0;
      break;
    }
  }
  
  @Nullable
  public String mS()
  {
    return this.azM;
  }
  
  public boolean onBackPressed()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.getVisibility() == 0)
      {
        this.b.changeState(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate()
  {
    this.z = ((ViewStub)y(2131362222));
    this.yo.setOnClickListener(this);
    this.yo.setOnTouchListener(new aygq(this));
  }
  
  public void onDestroy() {}
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      bsP();
      return;
    case 0: 
      bsP();
      return;
    }
    bsO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygp
 * JD-Core Version:    0.7.0.1
 */