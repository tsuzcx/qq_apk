import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;

public class vjn
  extends blig<vcf, blij<vcf>>
{
  private uxe a;
  
  public vjn(Context paramContext, uxe paramuxe)
  {
    super(paramContext);
    this.a = paramuxe;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public Activity a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public blij<vcf> a(ViewGroup paramViewGroup, int paramInt)
  {
    return vjo.a(paramViewGroup, this);
  }
  
  public void a(blij<vcf> paramblij)
  {
    super.onViewAttachedToWindow(paramblij);
    if (((paramblij instanceof vjo)) && (this.a != null) && (this.a.a().getUserVisibleHint()) && (this.a.a().isResumed())) {
      ((vjo)paramblij).b();
    }
    if ((paramblij instanceof vjo)) {
      ((vjo)paramblij).a();
    }
  }
  
  public void a(blij<vcf> paramblij, int paramInt)
  {
    vcf localvcf = (vcf)a(paramInt);
    if (localvcf == null) {}
    while (!(paramblij instanceof vjo)) {
      return;
    }
    ((vjo)paramblij).a(localvcf, paramInt);
  }
  
  public void b(blij<vcf> paramblij)
  {
    super.onViewDetachedFromWindow(paramblij);
    paramblij.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjn
 * JD-Core Version:    0.7.0.1
 */