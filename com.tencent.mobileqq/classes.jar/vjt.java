import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

public class vjt
  extends blig<stSimpleMetaPerson, blij<stSimpleMetaPerson>>
  implements vjw
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private uxe jdField_a_of_type_Uxe;
  
  public vjt(Context paramContext, uxe paramuxe)
  {
    super(paramContext);
    this.jdField_a_of_type_Uxe = paramuxe;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public blij<stSimpleMetaPerson> a(ViewGroup paramViewGroup, int paramInt)
  {
    return vju.a(paramViewGroup, this);
  }
  
  public void a(stFeed paramstFeed)
  {
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    vbg.a().a(paramstSimpleMetaPerson.id);
    a(paramstSimpleMetaPerson);
    paramstSimpleMetaPerson = b();
    if ((paramstSimpleMetaPerson == null) || (paramstSimpleMetaPerson.size() == 0)) {
      this.jdField_a_of_type_Uxe.a(this.jdField_a_of_type_UserGrowthStFeed);
    }
    bjkv.a().a(2131720129);
  }
  
  public void a(blij<stSimpleMetaPerson> paramblij)
  {
    super.onViewAttachedToWindow(paramblij);
    if (((paramblij instanceof vju)) && (this.jdField_a_of_type_Uxe != null) && (this.jdField_a_of_type_Uxe.a().getUserVisibleHint())) {
      ((vju)paramblij).b();
    }
  }
  
  public void a(blij<stSimpleMetaPerson> paramblij, int paramInt)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)a(paramInt);
    if (localstSimpleMetaPerson == null) {}
    while (!(paramblij instanceof vju)) {
      return;
    }
    ((vju)paramblij).a(localstSimpleMetaPerson, paramInt);
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    vmg.a(this.jdField_a_of_type_Uxe.a(), paramstSimpleMetaPerson.avatarSchema, 702, paramstSimpleMetaPerson.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjt
 * JD-Core Version:    0.7.0.1
 */