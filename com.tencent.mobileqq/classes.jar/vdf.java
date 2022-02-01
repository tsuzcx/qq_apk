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

public class vdf
  extends vdc
{
  private Intent a;
  
  public vdf(uzq paramuzq)
  {
    super(paramuzq);
  }
  
  private List<vaq> a(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (localstSimpleMetaFeed != null)
      {
        vaq localvaq = new vaq();
        localvaq.a(localstSimpleMetaFeed);
        localArrayList.add(localvaq);
      }
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, vaa paramvaa, long paramLong)
  {
    unc.a().a(paramBoolean2, paramBoolean1, "", 10, paramLong, new vdg(this, paramvaa, paramBoolean1, paramBoolean2));
  }
  
  public int a(int paramInt)
  {
    return unc.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt) + 1;
  }
  
  public List<vaq> a(ArrayList paramArrayList)
  {
    Object localObject = unc.a().jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
        vaq localvaq = new vaq();
        localvaq.a(localstSimpleMetaFeed);
        paramArrayList.add(localvaq);
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
    paramViewHolder = new WSItemExposeEvent((stSimpleMetaFeed)((vaq)paramViewHolder.a().a(paramInt)).a());
    unw.a().a(paramViewHolder);
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
    if ((this.b) && (localObject != null))
    {
      uya.b("WSVerticalForFollowPresenter", "onPause() back to follow page");
      localObject = ((uzq)localObject).a().a();
      if ((localObject != null) && ((((vct)localObject).a instanceof vbl)))
      {
        localObject = (vbl)((vct)localObject).a;
        if ((((vbl)localObject).a() instanceof vcj)) {
          ((vcj)((vbl)localObject).a()).a(0, 100);
        }
      }
      url.a().a(false);
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
        localObject = ((uzq)localObject).a();
      } while (localObject == null);
      localObject = ((WSPlayerManager)localObject).a();
    } while (localObject == null);
    ((urt)localObject).jdField_a_of_type_Urk = null;
    ((urt)localObject).jdField_a_of_type_AndroidViewViewGroup = null;
    unc.a().a((urt)localObject);
    localObject = new WSVideoPlayEvent();
    ((WSVideoPlayEvent)localObject).mCurrentPosition = this.jdField_a_of_type_Int;
    unw.a().a((WSSimpleBaseEvent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdf
 * JD-Core Version:    0.7.0.1
 */