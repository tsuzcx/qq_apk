import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

public class umm
  extends bkrs<stSimpleMetaPerson, bkrv<stSimpleMetaPerson>>
  implements ump
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private ucp jdField_a_of_type_Ucp;
  
  public umm(Context paramContext, ucp paramucp)
  {
    super(paramContext);
    this.jdField_a_of_type_Ucp = paramucp;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public bkrv<stSimpleMetaPerson> a(ViewGroup paramViewGroup, int paramInt)
  {
    return umn.a(paramViewGroup, this);
  }
  
  public void a(stFeed paramstFeed)
  {
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    ugn.a().a(paramstSimpleMetaPerson.id);
    a(paramstSimpleMetaPerson);
    paramstSimpleMetaPerson = a();
    if ((paramstSimpleMetaPerson == null) || (paramstSimpleMetaPerson.size() == 0)) {
      this.jdField_a_of_type_Ucp.a(this.jdField_a_of_type_UserGrowthStFeed);
    }
    biti.a().a(2131719183);
  }
  
  public void a(bkrv<stSimpleMetaPerson> parambkrv)
  {
    super.onViewAttachedToWindow(parambkrv);
    if (((parambkrv instanceof umn)) && (this.jdField_a_of_type_Ucp != null) && (this.jdField_a_of_type_Ucp.a().getUserVisibleHint())) {
      ((umn)parambkrv).b();
    }
  }
  
  public void a(bkrv<stSimpleMetaPerson> parambkrv, int paramInt)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)a(paramInt);
    if (localstSimpleMetaPerson == null) {}
    while (!(parambkrv instanceof umn)) {
      return;
    }
    ((umn)parambkrv).a(localstSimpleMetaPerson, paramInt);
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    uov.a(this.jdField_a_of_type_Ucp.a(), paramstSimpleMetaPerson.avatarSchema, 702, paramstSimpleMetaPerson.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umm
 * JD-Core Version:    0.7.0.1
 */