import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;

public class umi
  extends bkrs<uhj, bkrv<uhj>>
{
  private ucp a;
  
  public umi(Context paramContext, ucp paramucp)
  {
    super(paramContext);
    this.a = paramucp;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public bkrv<uhj> a(ViewGroup paramViewGroup, int paramInt)
  {
    return umj.a(paramViewGroup);
  }
  
  public void a(bkrv<uhj> parambkrv)
  {
    super.onViewAttachedToWindow(parambkrv);
    if (((parambkrv instanceof umj)) && (this.a != null) && (this.a.a().getUserVisibleHint()) && (this.a.a().isResumed())) {
      ((umj)parambkrv).a();
    }
  }
  
  public void a(bkrv<uhj> parambkrv, int paramInt)
  {
    uhj localuhj = (uhj)a(paramInt);
    if (localuhj == null) {}
    while (!(parambkrv instanceof umj)) {
      return;
    }
    ((umj)parambkrv).a(localuhj, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umi
 * JD-Core Version:    0.7.0.1
 */