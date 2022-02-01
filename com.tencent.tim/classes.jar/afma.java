import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.b;
import java.util.List;

public class afma
  extends afnq
{
  private EmoticonLinearLayout.b a;
  private afmf f;
  private int[] kW;
  private List<afmi> zU;
  
  public afma(Context paramContext, afmf paramafmf, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.f = paramafmf;
    this.kW = afqv.Q();
  }
  
  public int Ad()
  {
    return Dh() + afqr.cTs;
  }
  
  public int Dh()
  {
    return afqr.d(this.kW);
  }
  
  protected void ai(View paramView, int paramInt)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = hn(paramInt);
      } while (paramInt >= Ad());
      if (this.zU == null) {
        this.zU = afqr.b(this.kW);
      }
    } while (i != 2007);
    if (this.a == null)
    {
      this.a = new afnq.a(this, 2007);
      this.a.HT(true);
      this.a.HV(false);
      this.a.HU(false);
      afmi localafmi = new afmi();
      localafmi.action = "delete";
      this.a.c(localafmi);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.f);
    paramView.setAdapter(this.a);
    this.a.hN(3, 7);
    this.a.setPage(paramInt);
    this.a.bF(this.zU);
    this.a.Mh();
  }
  
  public void destroy()
  {
    super.destroy();
    this.f = null;
  }
  
  protected int hn(int paramInt)
  {
    return 2007;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afma
 * JD-Core Version:    0.7.0.1
 */