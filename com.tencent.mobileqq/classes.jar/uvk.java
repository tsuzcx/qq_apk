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

public class uvk
  extends uvh
{
  private Intent a;
  
  public uvk(urv paramurv)
  {
    super(paramurv);
  }
  
  private List<usv> a(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (localstSimpleMetaFeed != null)
      {
        usv localusv = new usv();
        localusv.a(localstSimpleMetaFeed);
        localArrayList.add(localusv);
      }
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, usf paramusf, long paramLong)
  {
    ugl.a().a(paramBoolean2, paramBoolean1, "", 10, new uvl(this, paramLong, paramusf, paramBoolean1, paramBoolean2));
  }
  
  public int a(int paramInt)
  {
    return ugl.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt) + 1;
  }
  
  public List<usv> a(ArrayList paramArrayList)
  {
    Object localObject = ugl.a().jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
        usv localusv = new usv();
        localusv.a(localstSimpleMetaFeed);
        paramArrayList.add(localusv);
      }
      return paramArrayList;
    }
    return null;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = a();
    if (paramViewHolder == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentIntent == null) {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_feed_position", paramInt);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_from", paramViewHolder.a());
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_play_scene", paramViewHolder.b());
    paramViewHolder.a(8193, this.jdField_a_of_type_AndroidContentIntent);
    paramViewHolder = new WSItemExposeEvent((stSimpleMetaFeed)((usv)paramViewHolder.a().a(paramInt)).a());
    uhf.a().a(paramViewHolder);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2) {
      return false;
    }
    a(paramBoolean1, false, this, System.currentTimeMillis());
    return true;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void e()
  {
    Object localObject = a();
    if ((this.jdField_a_of_type_Boolean) && (localObject != null))
    {
      uqf.b("WSVerticalForFollowPresenter", "onPause() back to follow page");
      localObject = ((urv)localObject).a().a();
      if ((localObject != null) && ((((uuy)localObject).a instanceof utq)))
      {
        localObject = (utq)((uuy)localObject).a;
        if ((((utq)localObject).a() instanceof uuo)) {
          ((uuo)((utq)localObject).a()).a(0, 100);
        }
      }
      ukq.a().a(false);
      return;
    }
    super.e();
  }
  
  public void f()
  {
    super.f();
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = ((urv)localObject).a();
      } while (localObject == null);
      localObject = ((WSPlayerManager)localObject).a();
    } while (localObject == null);
    ((ukz)localObject).jdField_a_of_type_Ukp = null;
    ((ukz)localObject).jdField_a_of_type_AndroidViewViewGroup = null;
    ugl.a().a((ukz)localObject);
    localObject = new WSVideoPlayEvent();
    ((WSVideoPlayEvent)localObject).mCurrentPosition = this.jdField_a_of_type_Int;
    uhf.a().a((WSSimpleBaseEvent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvk
 * JD-Core Version:    0.7.0.1
 */