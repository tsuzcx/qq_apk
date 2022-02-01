import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.BaseFragment;

public class ahpb
{
  public BaseFragment a;
  public String bLg;
  public String bLh;
  public String bLi;
  public String bLj;
  public boolean chN = true;
  public boolean chO = false;
  public int daq;
  public View.OnClickListener fk;
  public boolean showProgress;
  public String strTitle;
  
  public ahpb(BaseFragment paramBaseFragment)
  {
    this.a = paramBaseFragment;
  }
  
  public void Kv(boolean paramBoolean)
  {
    this.chN = paramBoolean;
  }
  
  public ahpb a(View.OnClickListener paramOnClickListener)
  {
    this.fk = paramOnClickListener;
    return this;
  }
  
  public ahpb a(String paramString)
  {
    this.bLi = paramString;
    return this;
  }
  
  public ahpb a(boolean paramBoolean)
  {
    this.chO = paramBoolean;
    return this;
  }
  
  public ahpb b(String paramString)
  {
    this.strTitle = paramString;
    return this;
  }
  
  public ahpb b(boolean paramBoolean)
  {
    this.showProgress = paramBoolean;
    return this;
  }
  
  public void refresh()
  {
    if (this.a != null) {
      this.a.doK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpb
 * JD-Core Version:    0.7.0.1
 */