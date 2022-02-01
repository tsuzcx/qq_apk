import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;

public class uva
  extends bjwv<uof, bjwy<uof>>
{
  private ujh a;
  
  public uva(Context paramContext, ujh paramujh)
  {
    super(paramContext);
    this.a = paramujh;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public bjwy<uof> a(ViewGroup paramViewGroup, int paramInt)
  {
    return uvb.a(paramViewGroup);
  }
  
  public void a(bjwy<uof> parambjwy)
  {
    super.onViewAttachedToWindow(parambjwy);
    if (((parambjwy instanceof uvb)) && (this.a != null) && (this.a.a().getUserVisibleHint()) && (this.a.a().isResumed())) {
      ((uvb)parambjwy).a();
    }
  }
  
  public void a(bjwy<uof> parambjwy, int paramInt)
  {
    uof localuof = (uof)a(paramInt);
    if (localuof == null) {}
    while (!(parambjwy instanceof uvb)) {
      return;
    }
    ((uvb)parambjwy).a(localuof, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uva
 * JD-Core Version:    0.7.0.1
 */