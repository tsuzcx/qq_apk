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

public class uui
  extends uuf
{
  private Intent a;
  
  public uui(uqu paramuqu)
  {
    super(paramuqu);
  }
  
  private List<uru> a(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (localstSimpleMetaFeed != null)
      {
        uru localuru = new uru();
        localuru.a(localstSimpleMetaFeed);
        localArrayList.add(localuru);
      }
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, ure paramure, long paramLong)
  {
    ugj.a().a(paramBoolean2, paramBoolean1, "", 10, new uuj(this, paramLong, paramBoolean2, paramure, paramBoolean1));
  }
  
  public int a(int paramInt)
  {
    return ugj.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt) + 1;
  }
  
  public List<uru> a(ArrayList paramArrayList)
  {
    Object localObject = ugj.a().jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
        uru localuru = new uru();
        localuru.a(localstSimpleMetaFeed);
        paramArrayList.add(localuru);
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
    paramViewHolder = new WSItemExposeEvent((stSimpleMetaFeed)((uru)paramViewHolder.a().a(paramInt)).a());
    uhd.a().a(paramViewHolder);
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
      upe.b("WSVerticalForFollowPresenter", "onPause() back to follow page");
      localObject = ((uqu)localObject).a().a();
      if ((localObject != null) && ((((utw)localObject).a instanceof usp)))
      {
        localObject = (usp)((utw)localObject).a;
        if ((((usp)localObject).a() instanceof utm)) {
          ((utm)((usp)localObject).a()).a(0, 100);
        }
      }
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
        localObject = ((uqu)localObject).a();
      } while (localObject == null);
      localObject = ((WSPlayerManager)localObject).a();
    } while (localObject == null);
    ((ukb)localObject).jdField_a_of_type_Ujv = null;
    ((ukb)localObject).jdField_a_of_type_AndroidViewViewGroup = null;
    ugj.a().a((ukb)localObject);
    localObject = new WSVideoPlayEvent();
    ((WSVideoPlayEvent)localObject).mCurrentPosition = this.jdField_a_of_type_Int;
    uhd.a().a((WSSimpleBaseEvent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uui
 * JD-Core Version:    0.7.0.1
 */