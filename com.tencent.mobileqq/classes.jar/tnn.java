import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public abstract class tnn
  implements tmi, tmr
{
  public int a;
  public WeakReference<tmj> a;
  public tmj a;
  public boolean a;
  private boolean b;
  
  public tnn(tmj paramtmj)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramtmj);
    this.jdField_a_of_type_Tmj = ((tmj)this.jdField_a_of_type_MqqUtilWeakReference.get());
  }
  
  private stSimpleMetaFeed a(tmv paramtmv)
  {
    if ((paramtmv != null) && ((paramtmv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramtmv.a();
    }
    return null;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Tmj == null) {}
    for (;;)
    {
      return;
      VideoFeedsRecyclerView localVideoFeedsRecyclerView = this.jdField_a_of_type_Tmj.a();
      int j = localVideoFeedsRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = localVideoFeedsRecyclerView.getChildViewHolder(localVideoFeedsRecyclerView.getChildAt(i));
        if ((localObject instanceof tnj))
        {
          localObject = (tnj)localObject;
          stSimpleMetaFeed localstSimpleMetaFeed = a((tmv)((tnj)localObject).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramString)))
          {
            ((tnj)localObject).jdField_a_of_type_Tcl.b(1);
            tlo.b("AbsWSVerticalPagePresenter", "[updateFollowStatus]" + localstSimpleMetaFeed.poster.followStatus);
          }
        }
        i += 1;
      }
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    tlo.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    if (this.jdField_a_of_type_Tmj == null) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_Tmj.a();
    } while ((localObject1 == null) || (((tmf)localObject1).a() == null));
    Object localObject1 = ((tmf)localObject1).a();
    int i = 0;
    label48:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (tmv)((List)localObject1).get(i);
      if ((localObject2 != null) && (((tmv)localObject2).a() != null) && (((stSimpleMetaFeed)((tmv)localObject2).a()).poster != null)) {
        break label104;
      }
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label104:
      localObject2 = ((stSimpleMetaFeed)((tmv)localObject2).a()).poster;
      if (TextUtils.equals(((stSimpleMetaPerson)localObject2).id, paramWSSimpleBaseEvent.getPersonId()))
      {
        ((stSimpleMetaPerson)localObject2).followStatus = paramWSSimpleBaseEvent.getIsFollow();
        a(paramWSSimpleBaseEvent.getPersonId());
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Tmj == null) {}
    for (;;)
    {
      return;
      VideoFeedsRecyclerView localVideoFeedsRecyclerView = this.jdField_a_of_type_Tmj.a();
      int j = localVideoFeedsRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = localVideoFeedsRecyclerView.getChildViewHolder(localVideoFeedsRecyclerView.getChildAt(i));
        if ((localObject instanceof tnj))
        {
          localObject = (tnj)localObject;
          stSimpleMetaFeed localstSimpleMetaFeed = a((tmv)((tnj)localObject).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((tnj)localObject).jdField_a_of_type_Tcl.b(0);
          }
        }
        i += 1;
      }
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    tlo.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    if (this.jdField_a_of_type_Tmj == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_Tmj.a();
    } while ((localObject == null) || (((tmf)localObject).a() == null));
    Object localObject = ((tmf)localObject).a();
    int i = 0;
    label53:
    tmv localtmv;
    if (i < ((List)localObject).size())
    {
      localtmv = (tmv)((List)localObject).get(i);
      if ((localtmv != null) && (localtmv.a() != null)) {
        break label97;
      }
    }
    label97:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localtmv.a()).id))
    {
      i += 1;
      break label53;
      break;
    }
    int j;
    label153:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != ((stSimpleMetaFeed)localtmv.a()).is_ding)
    {
      if (((stSimpleMetaFeed)localtmv.a()).is_ding != 1) {
        break label205;
      }
      j = 1;
      if (j == 0) {
        break label210;
      }
      localstSimpleMetaFeed = (stSimpleMetaFeed)localtmv.a();
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      ((stSimpleMetaFeed)localtmv.a()).is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      b(paramWSSimpleBaseEvent.getFeedId());
      break;
      label205:
      j = 0;
      break label153;
      label210:
      localstSimpleMetaFeed = (stSimpleMetaFeed)localtmv.a();
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    this.b = false;
    WSPublicAccReport.getInstance().reportEnterVerticalVideo(null, 2, false, paramInt);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent == null) {}
    do
    {
      return;
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        c(paramWSSimpleBaseEvent);
        return;
      }
    } while (!(paramWSSimpleBaseEvent instanceof FollowEvent));
    b(paramWSSimpleBaseEvent);
  }
  
  public void a(List<tmv> paramList)
  {
    this.b = false;
    b(paramList);
    if (this.jdField_a_of_type_Tmj != null)
    {
      this.jdField_a_of_type_Tmj.d();
      this.jdField_a_of_type_Tmj.a(paramList);
    }
    WSPublicAccReport.getInstance().reportEnterVerticalVideo(paramList, 2, true, -1);
  }
  
  public void a(@NonNull tmj paramtmj) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b) {
      return;
    }
    this.b = a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2);
  
  public void b()
  {
    if ((this.jdField_a_of_type_Tmj != null) && (this.jdField_a_of_type_Tmj.a() != null)) {
      this.jdField_a_of_type_Tmj.a().c(a());
    }
  }
  
  public void b(List<tmv> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tmv localtmv = (tmv)paramList.next();
      if ((localtmv != null) && ((localtmv.a() instanceof stSimpleMetaFeed))) {
        localArrayList.add((stSimpleMetaFeed)localtmv.a());
      }
    }
    tlv.a(localArrayList, true);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Tmj != null) && (this.jdField_a_of_type_Tmj.a() != null)) {
      this.jdField_a_of_type_Tmj.a().e();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Tmj != null) && (this.jdField_a_of_type_Tmj.a() != null)) {
      this.jdField_a_of_type_Tmj.a().f();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnn
 * JD-Core Version:    0.7.0.1
 */