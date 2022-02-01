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

public class vsa
  extends vrx
{
  private Intent a;
  
  public vsa(voi paramvoi)
  {
    super(paramvoi);
  }
  
  private List<vpj> a(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (localstSimpleMetaFeed != null)
      {
        vpj localvpj = new vpj();
        localvpj.a(localstSimpleMetaFeed);
        localArrayList.add(localvpj);
      }
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, vos paramvos, long paramLong)
  {
    vbc.a().a(paramBoolean2, paramBoolean1, "", 10, paramLong, new vsb(this, paramvos, paramBoolean1, paramBoolean2));
  }
  
  public int a(int paramInt)
  {
    return vbc.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt) + 1;
  }
  
  public List<vpj> a(ArrayList paramArrayList)
  {
    Object localObject = vbc.a().jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
        vpj localvpj = new vpj();
        localvpj.a(localstSimpleMetaFeed);
        paramArrayList.add(localvpj);
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
    paramViewHolder = new WSItemExposeEvent((stSimpleMetaFeed)((vpj)paramViewHolder.a().a(paramInt)).a());
    vbw.a().a(paramViewHolder);
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
      vmp.b("WSVerticalForFollowPresenter", "onPause() back to follow page");
      localObject = ((voi)localObject).a().a();
      if ((localObject != null) && ((((vrn)localObject).a instanceof vqe)))
      {
        localObject = (vqe)((vrn)localObject).a;
        if ((((vqe)localObject).a() instanceof vrd)) {
          ((vrd)((vqe)localObject).a()).a(0, 100);
        }
      }
      vft.a().a(false);
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
        localObject = ((voi)localObject).a();
      } while (localObject == null);
      localObject = ((WSPlayerManager)localObject).a();
    } while (localObject == null);
    ((vgb)localObject).jdField_a_of_type_Vfs = null;
    ((vgb)localObject).jdField_a_of_type_AndroidViewViewGroup = null;
    vbc.a().a((vgb)localObject);
    localObject = new WSVideoPlayEvent();
    ((WSVideoPlayEvent)localObject).mCurrentPosition = this.jdField_a_of_type_Int;
    vbw.a().a((WSSimpleBaseEvent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsa
 * JD-Core Version:    0.7.0.1
 */