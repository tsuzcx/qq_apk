import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import mqq.app.AppRuntime;

public class avjs
  extends ampy
{
  private static ForegroundColorSpan e = new ForegroundColorSpan(amxk.xk());
  private CharSequence aJ;
  public long azA;
  public long azz;
  public String cLr;
  public int exb;
  public int exc;
  public int exd;
  public int exe;
  public int exf;
  public int exg;
  public int exh;
  public long favId;
  public byte[] hX;
  public String keyword;
  public boolean playable;
  public int postion;
  public String source;
  public String title;
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
    avja.d(localBaseActivity, localBaseActivity.getAppRuntime().getAccount(), this.favId);
    amxk.a(this.keyword, 60, 0, paramView);
    if ((localBaseActivity instanceof UniteSearchActivity)) {
      amxk.b("all_result", "clk_collect", new String[] { "" + this.keyword });
    }
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.source != null)
    {
      if (this.exb == 1) {
        localSpannableStringBuilder.append("来自: ").append(this.source).setSpan(e, this.exc + 4, this.exd + 4, 33);
      }
    }
    else {
      return localSpannableStringBuilder;
    }
    return localSpannableStringBuilder.append("来自: ").append(amxk.a(this.source, this.keyword, 30));
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    if ((this.aJ == null) && (this.title != null))
    {
      aofk localaofk = new aofk(this.title, 3, 20);
      if ((this.exb == 0) && (this.exd > this.exc)) {
        localaofk.setSpan(e, this.exc, this.exd, 33);
      }
      this.aJ = localaofk;
    }
    return this.aJ;
  }
  
  public String getUin()
  {
    if (this.azA == 0L) {
      return null;
    }
    return "" + this.azA;
  }
  
  public int pG()
  {
    switch (this.exf)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 4;
    }
    return 101;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjs
 * JD-Core Version:    0.7.0.1
 */