import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

public class unk
  extends blsv<stSimpleMetaPerson, blsy<stSimpleMetaPerson>>
  implements unn
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private ucr jdField_a_of_type_Ucr;
  
  public unk(Context paramContext, ucr paramucr)
  {
    super(paramContext);
    this.jdField_a_of_type_Ucr = paramucr;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public blsy<stSimpleMetaPerson> a(ViewGroup paramViewGroup, int paramInt)
  {
    return unl.a(paramViewGroup, this);
  }
  
  public void a(stFeed paramstFeed)
  {
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    ugp.a().a(paramstSimpleMetaPerson.id);
    a(paramstSimpleMetaPerson);
    paramstSimpleMetaPerson = a();
    if ((paramstSimpleMetaPerson == null) || (paramstSimpleMetaPerson.size() == 0)) {
      this.jdField_a_of_type_Ucr.a(this.jdField_a_of_type_UserGrowthStFeed);
    }
    bjuh.a().a(2131719358);
  }
  
  public void a(blsy<stSimpleMetaPerson> paramblsy)
  {
    super.onViewAttachedToWindow(paramblsy);
    if (((paramblsy instanceof unl)) && (this.jdField_a_of_type_Ucr != null) && (this.jdField_a_of_type_Ucr.a().getUserVisibleHint())) {
      ((unl)paramblsy).b();
    }
  }
  
  public void a(blsy<stSimpleMetaPerson> paramblsy, int paramInt)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)a(paramInt);
    if (localstSimpleMetaPerson == null) {}
    while (!(paramblsy instanceof unl)) {
      return;
    }
    ((unl)paramblsy).a(localstSimpleMetaPerson, paramInt);
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    upw.a(this.jdField_a_of_type_Ucr.a(), paramstSimpleMetaPerson.avatarSchema, 702, paramstSimpleMetaPerson.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unk
 * JD-Core Version:    0.7.0.1
 */