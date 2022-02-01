import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class uul
  extends uuq
{
  protected long a;
  private boolean b = true;
  
  public uul(uqu paramuqu)
  {
    super(paramuqu);
  }
  
  @Nullable
  private stSimpleMetaFeed a()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = a();
    if (localObject3 == null) {
      localObject2 = localObject1;
    }
    int i;
    do
    {
      do
      {
        return localObject2;
        uru localuru = ((uqu)localObject3).a().a();
        upe.a("WSVerticalForHomePresenter", "handleOnBackEvent");
        localObject1 = localObject2;
        if (localuru != null)
        {
          localObject1 = localObject2;
          if ((localuru.a() instanceof stSimpleMetaFeed)) {
            localObject1 = (stSimpleMetaFeed)localuru.a();
          }
        }
        if ((localObject1 == null) || (TextUtils.isEmpty(((stSimpleMetaFeed)localObject1).feed_desc))) {
          break;
        }
        localObject2 = localObject1;
      } while (((stSimpleMetaFeed)localObject1).video_type != 2);
      i = ((uqu)localObject3).a().a();
      localObject3 = ((uqu)localObject3).a().a();
      localObject2 = localObject1;
    } while (i >= ((List)localObject3).size() - 2);
    i += 1;
    if (i < ((List)localObject3).size())
    {
      localObject2 = (stSimpleMetaFeed)((uru)((List)localObject3).get(i)).a();
      if (((stSimpleMetaFeed)localObject2).video_type == 2) {}
      for (;;)
      {
        i += 1;
        break;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject2).feed_desc)) {
          return localObject1;
        }
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private Object a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_should_clear_data_on_refresh", Boolean.valueOf(this.b));
    return new JSONObject(localHashMap).toString();
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {}
    WSVideoPreDownloadManager localWSVideoPreDownloadManager;
    boolean bool;
    do
    {
      return;
      localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.sApplication);
      bool = localWSVideoPreDownloadManager.a(paramstSimpleMetaFeed.video_url);
      upe.a("WSVerticalForHomePresenter", "sec itemInfo : " + paramstSimpleMetaFeed + "; isCached = " + bool);
    } while (bool);
    localWSVideoPreDownloadManager.a(new uum(paramstSimpleMetaFeed));
    localWSVideoPreDownloadManager.a(new uun(localWSVideoPreDownloadManager, paramstSimpleMetaFeed.video_url));
    localWSVideoPreDownloadManager.a(0);
  }
  
  private void a(List<uru> paramList, boolean paramBoolean)
  {
    Object localObject1 = a();
    if ((!paramBoolean) || (paramList == null) || (paramList.size() <= 1))
    {
      upe.a("WSVerticalForHomePresenter", "data from cache or pushMsg");
      return;
    }
    if ((localObject1 == null) || (((uqu)localObject1).a() == null) || (((uqu)localObject1).a().getItemCount() <= 0))
    {
      upe.a("WSVerticalForHomePresenter", "not data in screen");
      return;
    }
    Object localObject2 = (uru)((uqu)localObject1).a().a(0);
    localObject1 = (uru)paramList.get(0);
    if ((localObject2 == null) || (localObject1 == null))
    {
      upe.a("WSVerticalForHomePresenter", "data could be null");
      return;
    }
    Object localObject3 = ((uru)localObject2).a();
    localObject2 = ((uru)localObject1).a();
    if ((!(localObject3 instanceof stSimpleMetaFeed)) || (!(localObject2 instanceof stSimpleMetaFeed)))
    {
      upe.a("WSVerticalForHomePresenter", "data type is incorrect");
      return;
    }
    localObject3 = (stSimpleMetaFeed)localObject3;
    localObject2 = (stSimpleMetaFeed)localObject2;
    if (TextUtils.equals(((stSimpleMetaFeed)localObject3).id, ((stSimpleMetaFeed)localObject2).id))
    {
      upe.a("WSVerticalForHomePresenter", "updateFirstItem");
      paramList.remove(localObject1);
      a((uru)localObject1);
      return;
    }
    upe.a("WSVerticalForHomePresenter", "data not equip，feedInScreen.id = " + ((stSimpleMetaFeed)localObject3).id + "，feedFirst.id = " + ((stSimpleMetaFeed)localObject2).id);
  }
  
  private void a(uru paramuru)
  {
    if (paramuru == null) {}
    Object localObject;
    do
    {
      return;
      localObject = a();
    } while ((localObject == null) || (((uqu)localObject).a() == null));
    if (((uqu)localObject).a().a() != null)
    {
      upe.a("WSVerticalForHomePresenter", "onSuccess getItemCount: " + ((uqu)localObject).a().getItemCount());
      localObject = ((uqu)localObject).a().a().a;
      if ((localObject instanceof usp)) {
        ((usp)localObject).b(paramuru);
      }
    }
    b(paramuru);
  }
  
  private void a(boolean paramBoolean, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((!paramBoolean) && (TextUtils.isEmpty("")) && (paramstSimpleMetaFeed != null)) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        umw.a(301, new Object[] { Integer.valueOf(paramInt), "0", paramstSimpleMetaFeed, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2) });
        return;
      }
    }
  }
  
  private void a(boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (!paramBoolean) {}
    do
    {
      return;
      localObject = a();
    } while (!(localObject instanceof WSVerticalPageFragment));
    Object localObject = ((WSVerticalPageFragment)localObject).getActivity();
    uha.a().a((Activity)localObject, paramInt, paramstSimpleMetaFeed);
  }
  
  private boolean a(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof String)) {}
    try
    {
      bool = new JSONObject((String)paramObject).optBoolean("key_should_clear_data_on_refresh", true);
      return bool;
    }
    catch (JSONException paramObject)
    {
      paramObject.printStackTrace();
    }
    return true;
  }
  
  private void b(uru paramuru)
  {
    Object localObject = a();
    if ((localObject == null) || (((uqu)localObject).a() == null)) {
      return;
    }
    localObject = (uru)((uqu)localObject).a().a(0);
    stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((uru)localObject).a();
    paramuru = (stSimpleMetaFeed)paramuru.a();
    pnp.b(paramuru);
    paramuru.floatingLayerCardStyle.cardType = localstSimpleMetaFeed.floatingLayerCardStyle.cardType;
    ((uru)localObject).a(paramuru);
  }
  
  private boolean d()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((uqu)localObject).a();
    } while (localObject == null);
    return ((WSPlayerManager)localObject).e();
  }
  
  private boolean e()
  {
    uqu localuqu = a();
    if ((localuqu == null) || (localuqu.a() == null)) {}
    uru localuru;
    do
    {
      return false;
      localuru = localuqu.a().a();
    } while (localuru == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localuru);
    localuqu.a(localArrayList);
    return true;
  }
  
  private void g()
  {
    upe.a("WSVerticalForHomePresenter", "cacheRecommendFeed");
    Object localObject = a();
    if ((localObject == null) || (((uqu)localObject).a() == null))
    {
      upe.a("WSVerticalForHomePresenter", "view == null");
      return;
    }
    if (!TextUtils.equals(((uqu)localObject).a(), "aio_home_page"))
    {
      upe.a("WSVerticalForHomePresenter", "from is not AIO_HOME_PAGE");
      return;
    }
    localObject = a();
    if (localObject == null)
    {
      upe.a("WSVerticalForHomePresenter", "itemInfo == null");
      return;
    }
    upe.a("WSVerticalForHomePresenter", "cacheRecommendFeed");
    List localList = Arrays.asList(new stSimpleMetaFeed[] { localObject });
    ups.a(localList);
    a((stSimpleMetaFeed)localObject);
    pnp localpnp = ups.a();
    if (localpnp != null)
    {
      upe.a("WSVerticalForHomePresenter", "saveLastFeedInfo");
      localpnp.a((stSimpleMetaFeed)localObject);
    }
    ups.a(localList, false);
    uen.a().b(localList);
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    uqu localuqu = a();
    if (localuqu == null) {
      return;
    }
    this.b = true;
    if (e())
    {
      this.b = false;
      localuqu.f();
    }
    super.a(paramString);
  }
  
  public void a(List<uru> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    a(paramList, paramBoolean2);
    super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
        if (paramBoolean2)
        {
          this.a = (System.currentTimeMillis() - this.a);
          g();
        }
      } while ((paramList == null) || (paramList.size() <= 0));
      paramList = ((uru)paramList.get(0)).a();
    } while (!(paramList instanceof stSimpleMetaFeed));
    paramList = (stSimpleMetaFeed)paramList;
    int i = 1;
    paramObject = ugb.a().a();
    if (paramObject != null)
    {
      upe.d("WSVerticalForHomePresenter", "RockDownloader:" + paramObject.download);
      i = paramObject.link_strategy_type;
    }
    a(false, i, paramList);
    a(paramBoolean2, paramList, i);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    if (paramBoolean2) {
      return d();
    }
    return (a(paramObject)) && (paramBoolean1);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    uqu localuqu = a();
    if (localuqu == null) {
      return false;
    }
    this.a = System.currentTimeMillis();
    WSVerticalDataManager.a().a(12, paramBoolean1, paramBoolean2, paramString, localuqu.a(), this, a());
    return true;
  }
  
  public boolean b()
  {
    uqu localuqu = a();
    return (localuqu != null) && (localuqu.b());
  }
  
  public void f()
  {
    super.f();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uul
 * JD-Core Version:    0.7.0.1
 */