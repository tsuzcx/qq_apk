import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

public class tjn
  extends bieg<stSimpleMetaPerson, biej<stSimpleMetaPerson>>
  implements tjq
{
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private tbb jdField_a_of_type_Tbb;
  
  public tjn(Context paramContext, tbb paramtbb)
  {
    super(paramContext);
    this.jdField_a_of_type_Tbb = paramtbb;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public biej<stSimpleMetaPerson> a(ViewGroup paramViewGroup, int paramInt)
  {
    return tjo.a(paramViewGroup, this);
  }
  
  public void a(stFeed paramstFeed)
  {
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    tep.a().a(paramstSimpleMetaPerson.id);
    a(paramstSimpleMetaPerson);
    paramstSimpleMetaPerson = a();
    if ((paramstSimpleMetaPerson == null) || (paramstSimpleMetaPerson.size() == 0)) {
      this.jdField_a_of_type_Tbb.a(this.jdField_a_of_type_UserGrowthStFeed);
    }
    bflz.a().a(2131721482);
  }
  
  public void a(biej<stSimpleMetaPerson> parambiej)
  {
    super.onViewAttachedToWindow(parambiej);
    if (((parambiej instanceof tjo)) && (this.jdField_a_of_type_Tbb != null) && (this.jdField_a_of_type_Tbb.a().getUserVisibleHint())) {
      ((tjo)parambiej).b();
    }
  }
  
  public void a(biej<stSimpleMetaPerson> parambiej, int paramInt)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)a(paramInt);
    if (localstSimpleMetaPerson == null) {}
    while (!(parambiej instanceof tjo)) {
      return;
    }
    ((tjo)parambiej).a(localstSimpleMetaPerson, paramInt);
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    tlf.a(this.jdField_a_of_type_Tbb.a(), paramstSimpleMetaPerson.avatarSchema, 702, paramstSimpleMetaPerson.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjn
 * JD-Core Version:    0.7.0.1
 */