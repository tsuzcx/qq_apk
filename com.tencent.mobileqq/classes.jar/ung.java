import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;

public class ung
  extends blsv<uho, blsy<uho>>
{
  private ucr a;
  
  public ung(Context paramContext, ucr paramucr)
  {
    super(paramContext);
    this.a = paramucr;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public blsy<uho> a(ViewGroup paramViewGroup, int paramInt)
  {
    return unh.a(paramViewGroup);
  }
  
  public void a(blsy<uho> paramblsy)
  {
    super.onViewAttachedToWindow(paramblsy);
    if (((paramblsy instanceof unh)) && (this.a != null) && (this.a.a().getUserVisibleHint()) && (this.a.a().isResumed())) {
      ((unh)paramblsy).a();
    }
  }
  
  public void a(blsy<uho> paramblsy, int paramInt)
  {
    uho localuho = (uho)a(paramInt);
    if (localuho == null) {}
    while (!(paramblsy instanceof unh)) {
      return;
    }
    ((unh)paramblsy).a(localuho, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ung
 * JD-Core Version:    0.7.0.1
 */