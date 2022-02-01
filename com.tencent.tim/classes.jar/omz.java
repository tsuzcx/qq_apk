import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

public class omz
  extends auwm<stSimpleMetaPerson, auwn<stSimpleMetaPerson>>
  implements onc
{
  private stFeed a;
  private oey b;
  
  public omz(Context paramContext, oey paramoey)
  {
    super(paramContext);
    this.b = paramoey;
  }
  
  public void a(auwn<stSimpleMetaPerson> paramauwn)
  {
    super.onViewAttachedToWindow(paramauwn);
    if (((paramauwn instanceof ona)) && (this.b != null) && (this.b.a().getUserVisibleHint())) {
      ((ona)paramauwn).aCG();
    }
  }
  
  public auwn<stSimpleMetaPerson> b(ViewGroup paramViewGroup, int paramInt)
  {
    return ona.a(paramViewGroup, this);
  }
  
  public void b(stFeed paramstFeed)
  {
    this.a = paramstFeed;
  }
  
  public void b(auwn<stSimpleMetaPerson> paramauwn, int paramInt)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)getItem(paramInt);
    if (localstSimpleMetaPerson == null) {}
    while (!(paramauwn instanceof ona)) {
      return;
    }
    ((ona)paramauwn).a(localstSimpleMetaPerson, paramInt);
  }
  
  public void c(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    oig.a().pB(paramstSimpleMetaPerson.id);
    aj(paramstSimpleMetaPerson);
    paramstSimpleMetaPerson = be();
    if ((paramstSimpleMetaPerson == null) || (paramstSimpleMetaPerson.size() == 0)) {
      this.b.aj(this.a);
    }
    arxa.a().showToast(2131721924);
  }
  
  public void d(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    oor.a(this.b.getActivity(), paramstSimpleMetaPerson.avatarSchema, 702, paramstSimpleMetaPerson.id);
  }
  
  public int dr(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omz
 * JD-Core Version:    0.7.0.1
 */