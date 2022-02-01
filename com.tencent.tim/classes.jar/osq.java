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

public class osq
  extends oso
{
  private Intent v;
  
  public osq(oqi.b paramb)
  {
    super(paramb);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, oqm paramoqm, long paramLong)
  {
    oie.a().a(paramBoolean2, paramBoolean1, "", 10, new osr(this, paramLong, paramBoolean2, paramoqm));
  }
  
  private List<oqr> ae(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (localstSimpleMetaFeed != null)
      {
        oqr localoqr = new oqr();
        localoqr.ad(localstSimpleMetaFeed);
        localArrayList.add(localoqr);
      }
    }
    return localArrayList;
  }
  
  public boolean Ho()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2) {
      return false;
    }
    a(paramBoolean1, false, this, System.currentTimeMillis());
    return true;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.b(paramViewHolder, paramInt);
    if (this.v == null) {
      this.v = new Intent();
    }
    this.v.putExtra("key_feed_position", paramInt);
    this.v.putExtra("key_from", this.a.getFrom());
    this.v.putExtra("key_play_scene", this.a.getPlayScene());
    if (this.a != null)
    {
      this.a.u(8193, this.v);
      paramViewHolder = new WSItemExposeEvent((stSimpleMetaFeed)((oqr)this.a.a().getItem(paramInt)).B());
      oiv.a().b(paramViewHolder);
    }
  }
  
  public void bgg()
  {
    super.bgg();
    if (this.a == null) {}
    do
    {
      do
      {
        return;
        localObject = this.a.a();
      } while (localObject == null);
      localObject = ((WSPlayerManager)localObject).b();
    } while (localObject == null);
    ((ole)localObject).b = null;
    ((ole)localObject).ci = null;
    oie.a().a((ole)localObject);
    Object localObject = new WSVideoPlayEvent();
    ((WSVideoPlayEvent)localObject).mCurrentPosition = this.mCurrentPosition;
    oiv.a().b((WSSimpleBaseEvent)localObject);
  }
  
  public List<oqr> d(ArrayList paramArrayList)
  {
    Object localObject = oie.a().la;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
        oqr localoqr = new oqr();
        localoqr.ad(localstSimpleMetaFeed);
        paramArrayList.add(localoqr);
      }
      return paramArrayList;
    }
    return null;
  }
  
  public int dJ(int paramInt)
  {
    return oie.a().D.get(paramInt) + 1;
  }
  
  public void doOnPause()
  {
    if ((this.aye) && (this.a != null))
    {
      ooz.d("WSVerticalForFollowPresenter", "onPause() back to follow page");
      Object localObject = this.a.a().a();
      if ((localObject != null) && ((((osf)localObject).a instanceof orb)))
      {
        localObject = (orb)((osf)localObject).a;
        if ((((orb)localObject).b() instanceof orw)) {
          ((orw)((orb)localObject).b()).dB(0, 100);
        }
      }
      return;
    }
    super.doOnPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osq
 * JD-Core Version:    0.7.0.1
 */