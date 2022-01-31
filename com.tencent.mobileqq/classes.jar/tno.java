import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseIntArray;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tno
  extends tnn
{
  private Intent a;
  
  public tno(tmj paramtmj)
  {
    super(paramtmj);
  }
  
  private List<tmv> a(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (localstSimpleMetaFeed != null)
      {
        tmv localtmv = new tmv();
        localtmv.a(localstSimpleMetaFeed);
        localArrayList.add(localtmv);
      }
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, tmr paramtmr)
  {
    tel.a().a(paramBoolean2, paramBoolean1, "", 10, new tnp(this, paramtmr));
  }
  
  public int a(int paramInt)
  {
    return tel.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt) + 1;
  }
  
  public List<tmv> a(ArrayList paramArrayList)
  {
    Object localObject = tel.a().jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
        tmv localtmv = new tmv();
        localtmv.a(localstSimpleMetaFeed);
        paramArrayList.add(localtmv);
      }
      return paramArrayList;
    }
    return null;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    if (this.jdField_a_of_type_AndroidContentIntent == null) {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_feed_position", paramInt);
    if (this.jdField_a_of_type_Tmj != null)
    {
      this.jdField_a_of_type_Tmj.a(8193, this.jdField_a_of_type_AndroidContentIntent);
      paramViewHolder = new WSItemExposeEvent((stSimpleMetaFeed)((tmv)this.jdField_a_of_type_Tmj.a().a(paramInt)).a());
      tff.a().a(paramViewHolder);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      return false;
    }
    a(paramBoolean1, false, this);
    return true;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Tmj != null))
    {
      tlo.b("WSVerticalForFollowPresenter", "onPause() back to follow page");
      Object localObject = this.jdField_a_of_type_Tmj.a().a();
      if ((localObject != null) && ((((tnj)localObject).a instanceof tnk)))
      {
        localObject = ((tnk)((tnj)localObject).a).a();
        if (localObject != null) {
          ((tnc)localObject).a(0, 100);
        }
      }
      return;
    }
    super.d();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Tmj == null) {}
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Tmj.a();
      } while (localObject == null);
      localObject = ((WSPlayerManager)localObject).a();
    } while (localObject == null);
    ((thl)localObject).jdField_a_of_type_Thf = null;
    ((thl)localObject).jdField_a_of_type_AndroidViewViewGroup = null;
    tel.a().a((thl)localObject);
    Object localObject = new WSVideoPlayEvent();
    ((WSVideoPlayEvent)localObject).mCurrentPosition = this.jdField_a_of_type_Int;
    tff.a().a((WSSimpleBaseEvent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tno
 * JD-Core Version:    0.7.0.1
 */