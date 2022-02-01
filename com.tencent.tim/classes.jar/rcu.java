import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class rcu
  extends rdb
  implements View.OnClickListener
{
  protected rji a;
  protected String azM;
  protected TextView yo;
  protected ViewStub z;
  
  public rcu(@NonNull rdc paramrdc)
  {
    super(paramrdc);
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
      this.a = new rji(this.z.inflate());
      this.a.p(new rcw(this));
      this.a.q(new rcx(this));
    }
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    super.a(paramInt, paramrkm);
    paramrkm.g.videoLabel = mS();
    rdc localrdc;
    String str;
    if (!TextUtils.isEmpty(mS()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localrdc = this.b;
        str = mS();
        if (!this.b.La()) {
          break label89;
        }
      }
    }
    label89:
    for (paramrkm = "2";; paramrkm = "1")
    {
      localrdc.c("pub_tag", 0, 0, new String[] { "1", str, paramrkm });
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
    this.yo.setOnTouchListener(new rcv(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcu
 * JD-Core Version:    0.7.0.1
 */