import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

public class uve
  extends bjwv<stSimpleMetaPerson, bjwy<stSimpleMetaPerson>>
  implements uvh
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private ujh jdField_a_of_type_Ujh;
  
  public uve(Context paramContext, ujh paramujh)
  {
    super(paramContext);
    this.jdField_a_of_type_Ujh = paramujh;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public bjwy<stSimpleMetaPerson> a(ViewGroup paramViewGroup, int paramInt)
  {
    return uvf.a(paramViewGroup, this);
  }
  
  public void a(stFeed paramstFeed)
  {
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    ung.a().a(paramstSimpleMetaPerson.id);
    a(paramstSimpleMetaPerson);
    paramstSimpleMetaPerson = a();
    if ((paramstSimpleMetaPerson == null) || (paramstSimpleMetaPerson.size() == 0)) {
      this.jdField_a_of_type_Ujh.a(this.jdField_a_of_type_UserGrowthStFeed);
    }
    bhzt.a().a(2131719676);
  }
  
  public void a(bjwy<stSimpleMetaPerson> parambjwy)
  {
    super.onViewAttachedToWindow(parambjwy);
    if (((parambjwy instanceof uvf)) && (this.jdField_a_of_type_Ujh != null) && (this.jdField_a_of_type_Ujh.a().getUserVisibleHint())) {
      ((uvf)parambjwy).b();
    }
  }
  
  public void a(bjwy<stSimpleMetaPerson> parambjwy, int paramInt)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)a(paramInt);
    if (localstSimpleMetaPerson == null) {}
    while (!(parambjwy instanceof uvf)) {
      return;
    }
    ((uvf)parambjwy).a(localstSimpleMetaPerson, paramInt);
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    uxr.a(this.jdField_a_of_type_Ujh.a(), paramstSimpleMetaPerson.avatarSchema, 702, paramstSimpleMetaPerson.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uve
 * JD-Core Version:    0.7.0.1
 */