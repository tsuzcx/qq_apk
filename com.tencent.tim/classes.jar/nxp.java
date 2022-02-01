import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.vinstance.Precondition;
import com.tencent.viola.vinstance.PreconditionAdapter;

public class nxp
  implements ViolaBaseView.c, PreconditionAdapter
{
  private Precondition a;
  private String aoI;
  private boolean avv;
  private Precondition b;
  private ViolaBaseView c;
  
  public nxp(String paramString)
  {
    this.aoI = paramString;
  }
  
  public void bcc()
  {
    ViolaLogUtils.d("Wormhole", "success");
    if (this.a != null) {
      this.a.setResult(true);
    }
  }
  
  public void bcd()
  {
    ViolaLogUtils.d("Wormhole", "error");
    if (this.a != null) {
      this.a.setResult(false);
    }
  }
  
  public void bce()
  {
    ViolaLogUtils.d("Wormhole", "error");
    if ((this.b != null) && (!this.avv))
    {
      this.b.setResult(false, null);
      this.avv = true;
    }
  }
  
  public void init(Precondition paramPrecondition)
  {
    this.c = new ViolaBaseView(BaseApplicationImpl.getApplication());
    this.c.a(this.aoI, null, null);
    this.c.setBaseViewListener(this);
    this.a = paramPrecondition;
    this.avv = false;
  }
  
  public void loadWormhole(Precondition paramPrecondition)
  {
    this.b = paramPrecondition;
  }
  
  public void oH(String paramString)
  {
    ViolaLogUtils.d("Wormhole", paramString);
    if ((this.b != null) && (!this.avv))
    {
      this.b.setResult(true, paramString);
      this.avv = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxp
 * JD-Core Version:    0.7.0.1
 */