import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager$createPlayerObserver$1", "Lcom/tencent/biz/pubaccount/readinjoy/video/MediaPlayListenerAdapter;", "onCompletion", "", "player", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "onError", "", "model", "", "what", "extra", "detailInfo", "", "info", "", "onVideoPrepared", "tag", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uln
  extends sfi
{
  public void a(@Nullable spn paramspn, @Nullable Object paramObject)
  {
    ukq.a("VideoPlayerWrapper_AD", "onVideoPrepared");
    ulm.a(ulm.a).set(2);
    paramspn = ulm.a(ulm.a).a();
    paramObject = ulm.a(ulm.a);
    if (paramObject != null) {}
    for (long l = paramObject.b();; l = 0L)
    {
      paramspn.g((int)l);
      ulm.a(ulm.a).a().f(2);
      ulm.a.e();
      return;
    }
  }
  
  public boolean a(@Nullable spn paramspn, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString, @Nullable Object paramObject)
  {
    ukq.a("VideoPlayerWrapper_AD", "onError");
    ulm.a(ulm.a).set(6);
    ulm.a(ulm.a, 6);
    paramString = ((Map)ulm.a(ulm.a)).entrySet().iterator();
    if (paramString.hasNext())
    {
      paramObject = (ulp)((Map.Entry)paramString.next()).getValue();
      if (paramObject != null)
      {
        paramspn = ulm.a(ulm.a).a();
        if (paramspn == null) {
          break label112;
        }
      }
      label112:
      for (paramspn = paramspn.o;; paramspn = null)
      {
        paramObject.c(paramspn);
        break;
      }
    }
    ulm.a(ulm.a, false);
    return false;
  }
  
  public void b(@Nullable spn paramspn)
  {
    ukq.a("VideoPlayerWrapper_AD", "onCompletion");
    ulm.a(ulm.a).set(7);
    ulm.a(ulm.a, 7);
    Iterator localIterator = ((Map)ulm.a(ulm.a)).entrySet().iterator();
    if (localIterator.hasNext())
    {
      ulp localulp = (ulp)((Map.Entry)localIterator.next()).getValue();
      if (localulp != null)
      {
        paramspn = ulm.a(ulm.a).a();
        if (paramspn == null) {
          break label106;
        }
      }
      label106:
      for (paramspn = paramspn.o;; paramspn = null)
      {
        localulp.d(paramspn);
        break;
      }
    }
    ulm.a(ulm.a).a().c(1);
    ulm.a(ulm.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uln
 * JD-Core Version:    0.7.0.1
 */