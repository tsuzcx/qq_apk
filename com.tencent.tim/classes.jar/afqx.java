import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.b;
import java.util.List;

public class afqx
  extends afnq
{
  protected EmoticonLinearLayout.b a;
  private afmf f;
  protected int[] kW;
  private List<afmi> zU;
  
  public afqx(Context paramContext, afmf paramafmf, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.f = paramafmf;
    this.kW = afqv.Q();
  }
  
  public int Ad()
  {
    return afqr.d(this.kW);
  }
  
  protected void ai(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((hn(paramInt) != 2007) || (paramInt >= Ad())) {
      return;
    }
    if (this.zU == null) {
      this.zU = afqv.c(this.kW);
    }
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
    dbB();
    this.a.setPage(paramInt);
    this.a.bF(this.zU);
    this.a.Mh();
  }
  
  protected void dbB()
  {
    if (this.a != null) {
      this.a.hN(3, 7);
    }
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
 * Qualified Name:     afqx
 * JD-Core Version:    0.7.0.1
 */