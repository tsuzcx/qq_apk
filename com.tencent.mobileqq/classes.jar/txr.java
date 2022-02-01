import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager$createPlayerObserver$1", "Lcom/tencent/biz/pubaccount/readinjoy/video/MediaPlayListenerAdapter;", "onCompletion", "", "player", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "onError", "", "model", "", "what", "extra", "detailInfo", "", "info", "", "onVideoPrepared", "tag", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class txr
  extends rst
{
  public void a(@Nullable sdj paramsdj, @Nullable Object paramObject)
  {
    twp.a("VideoPlayerWrapper_AD", "onVideoPrepared");
    txq.a(txq.a).set(2);
    paramsdj = txq.a(txq.a).a();
    paramObject = txq.a(txq.a);
    if (paramObject != null) {}
    for (long l = paramObject.b();; l = 0L)
    {
      paramsdj.g((int)l);
      txq.a(txq.a).a().f(2);
      txq.a.e();
      return;
    }
  }
  
  public boolean a(@Nullable sdj paramsdj, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString, @Nullable Object paramObject)
  {
    twp.a("VideoPlayerWrapper_AD", "onError");
    txq.a(txq.a).set(6);
    txq.a(txq.a, 6);
    paramString = ((Map)txq.a(txq.a)).entrySet().iterator();
    if (paramString.hasNext())
    {
      paramObject = (txt)((Map.Entry)paramString.next()).getValue();
      if (paramObject != null)
      {
        paramsdj = txq.a(txq.a).a();
        if (paramsdj == null) {
          break label112;
        }
      }
      label112:
      for (paramsdj = paramsdj.o;; paramsdj = null)
      {
        paramObject.c(paramsdj);
        break;
      }
    }
    txq.a(txq.a, false);
    return false;
  }
  
  public void b(@Nullable sdj paramsdj)
  {
    twp.a("VideoPlayerWrapper_AD", "onCompletion");
    txq.a(txq.a).set(7);
    txq.a(txq.a, 7);
    Iterator localIterator = ((Map)txq.a(txq.a)).entrySet().iterator();
    if (localIterator.hasNext())
    {
      txt localtxt = (txt)((Map.Entry)localIterator.next()).getValue();
      if (localtxt != null)
      {
        paramsdj = txq.a(txq.a).a();
        if (paramsdj == null) {
          break label106;
        }
      }
      label106:
      for (paramsdj = paramsdj.o;; paramsdj = null)
      {
        localtxt.d(paramsdj);
        break;
      }
    }
    txq.a(txq.a).a().c(1);
    txq.a(txq.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txr
 * JD-Core Version:    0.7.0.1
 */