import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class vsd
  extends vsg
{
  private static final int b = ScreenUtil.dip2px(48.0F);
  protected long a;
  private boolean c = true;
  
  public vsd(voi paramvoi)
  {
    super(paramvoi);
  }
  
  @Nullable
  private stSimpleMetaFeed a()
  {
    voi localvoi = a();
    Object localObject2;
    if (localvoi == null) {
      localObject2 = null;
    }
    Object localObject3;
    Object localObject1;
    int i;
    do
    {
      do
      {
        vpj localvpj;
        do
        {
          return localObject2;
          localvpj = localvoi.a().a();
          vmp.a("WSVerticalForHomePresenter", "handleOnBackEvent");
          localObject3 = vmm.a().a();
          localObject2 = localObject3;
        } while (localObject3 != null);
        localObject1 = localObject3;
        if (localvpj != null)
        {
          localObject1 = localObject3;
          if ((localvpj.a() instanceof stSimpleMetaFeed)) {
            localObject1 = (stSimpleMetaFeed)localvpj.a();
          }
        }
        if ((localObject1 == null) || (TextUtils.isEmpty(((stSimpleMetaFeed)localObject1).feed_desc))) {
          break;
        }
        localObject2 = localObject1;
      } while (((stSimpleMetaFeed)localObject1).video_type != 2);
      i = localvoi.a().a();
      localObject3 = localvoi.a().b();
      localObject2 = localObject1;
    } while (i >= ((List)localObject3).size() - 2);
    i += 1;
    if (i < ((List)localObject3).size())
    {
      localObject2 = (stSimpleMetaFeed)((vpj)((List)localObject3).get(i)).a();
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
    localHashMap.put("key_should_clear_data_on_refresh", Boolean.valueOf(this.c));
    return new JSONObject(localHashMap).toString();
  }
  
  private void a(List<vpj> paramList)
  {
    Object localObject1 = a();
    if ((paramList == null) || (paramList.size() <= 1))
    {
      vmp.a("WSVerticalForHomePresenter", "data from cache or pushMsg");
      return;
    }
    if ((localObject1 == null) || (((voi)localObject1).a() == null) || (((voi)localObject1).a().getItemCount() <= 0))
    {
      vmp.a("WSVerticalForHomePresenter", "not data in screen");
      return;
    }
    Object localObject2 = (vpj)((voi)localObject1).a().a(0);
    localObject1 = (vpj)paramList.get(0);
    if ((localObject2 == null) || (localObject1 == null))
    {
      vmp.a("WSVerticalForHomePresenter", "data could be null");
      return;
    }
    Object localObject3 = ((vpj)localObject2).a();
    localObject2 = ((vpj)localObject1).a();
    if ((!(localObject3 instanceof stSimpleMetaFeed)) || (!(localObject2 instanceof stSimpleMetaFeed)))
    {
      vmp.a("WSVerticalForHomePresenter", "data type is incorrect");
      return;
    }
    localObject3 = (stSimpleMetaFeed)localObject3;
    localObject2 = (stSimpleMetaFeed)localObject2;
    if (TextUtils.equals(((stSimpleMetaFeed)localObject3).id, ((stSimpleMetaFeed)localObject2).id))
    {
      vmp.a("WSVerticalForHomePresenter", "updateFirstItem");
      paramList.remove(localObject1);
      a((vpj)localObject1);
      return;
    }
    vmp.a("WSVerticalForHomePresenter", "data not equip，feedInScreen.id = " + ((stSimpleMetaFeed)localObject3).id + "，feedFirst.id = " + ((stSimpleMetaFeed)localObject2).id);
  }
  
  private void a(List<vpj> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      a(paramList);
    }
    while (!paramBoolean2) {
      return;
    }
    g();
  }
  
  private void a(voi paramvoi, boolean paramBoolean)
  {
    if ((paramvoi instanceof WSVerticalPageFragment))
    {
      paramvoi = ((WSVerticalPageFragment)paramvoi).a();
      if (paramvoi != null) {}
    }
    else
    {
      return;
    }
    paramvoi.f(paramBoolean);
    paramvoi.e(paramBoolean);
  }
  
  private void a(vpj paramvpj)
  {
    if (paramvpj == null) {}
    Object localObject;
    do
    {
      return;
      localObject = a();
    } while ((localObject == null) || (((voi)localObject).a() == null));
    if (((voi)localObject).a().a() != null)
    {
      vmp.a("WSVerticalForHomePresenter", "onSuccess getItemCount: " + ((voi)localObject).a().getItemCount());
      localObject = ((voi)localObject).a().a().jdField_a_of_type_Uyx;
      if ((localObject instanceof vqe)) {
        ((vqe)localObject).b(paramvpj);
      }
    }
    b(paramvpj);
  }
  
  private void a(boolean paramBoolean, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((!paramBoolean) && (TextUtils.isEmpty("")) && (paramstSimpleMetaFeed != null)) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        vkf.a(301, new Object[] { Integer.valueOf(paramInt), "0", paramstSimpleMetaFeed, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2) });
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
    vbt.a().a((Activity)localObject, paramInt, paramstSimpleMetaFeed);
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
  
  private void b(vpj paramvpj)
  {
    voi localvoi = a();
    if (localvoi != null)
    {
      localObject = localvoi.a();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    vpj localvpj = (vpj)((vnw)localObject).a(0);
    stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)localvpj.a();
    paramvpj = (stSimpleMetaFeed)paramvpj.a();
    paramvpj.floatingLayerCardStyle.cardType = localstSimpleMetaFeed.floatingLayerCardStyle.cardType;
    localvpj.a(paramvpj);
    Object localObject = ((vnw)localObject).a();
    if ((localObject != null) && (((vrn)localObject).jdField_a_of_type_Vgb != null)) {
      ((vrn)localObject).jdField_a_of_type_Vgb.a = vgd.a(paramvpj);
    }
    a(localvoi, paramvpj.isLoop);
  }
  
  private boolean d()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((voi)localObject).a();
    } while (localObject == null);
    return ((WSPlayerManager)localObject).e();
  }
  
  private boolean e()
  {
    voi localvoi = a();
    if ((localvoi != null) && (localvoi.a() != null))
    {
      localObject = localvoi.a().a();
      if ((localObject != null) && (((List)localObject).size() != 0)) {}
    }
    else
    {
      return false;
    }
    Object localObject = new ArrayList((Collection)localObject);
    localvoi.a((List)localObject);
    voq.a("[WSVerticalForHomePresenter.java][fillFirstDataOnRefresh]", (List)localObject);
    return true;
  }
  
  private void g()
  {
    voi localvoi = a();
    Object localObject;
    if (localvoi != null)
    {
      localObject = localvoi.a();
      if (localObject != null) {
        break label21;
      }
    }
    label21:
    int i;
    do
    {
      return;
      i = ((vnw)localObject).a();
      localObject = ((vnw)localObject).b();
    } while (i > ((List)localObject).size());
    ((List)localObject).removeAll(((List)localObject).subList(i, ((List)localObject).size()));
    localvoi.a().notifyItemMoved(i, ((List)localObject).size());
    voq.a("[WSVerticalForHomePresenter.java][preFilterDataForRefresh] firstVideo", (List)localObject);
  }
  
  private void h()
  {
    vmp.e("WSVerticalForHomePresenter", "[handleOnBackEvent][cacheRecommendFeed] saveFeed and cache");
    Object localObject = a();
    if ((localObject == null) || (((voi)localObject).a() == null))
    {
      vmp.a("WSVerticalForHomePresenter", "view == null");
      return;
    }
    if (!TextUtils.equals(((voi)localObject).a(), "aio_home_page"))
    {
      vmp.a("WSVerticalForHomePresenter", "from is not AIO_HOME_PAGE");
      return;
    }
    localObject = a();
    if (localObject == null)
    {
      vmp.a("WSVerticalForHomePresenter", "itemInfo == null");
      return;
    }
    vmp.a("WSVerticalForHomePresenter", "cacheRecommendFeed");
    vnd.a(Arrays.asList(new stSimpleMetaFeed[] { localObject }));
    pws localpws = vnd.a();
    if (localpws != null) {
      localpws.a((stSimpleMetaFeed)localObject);
    }
    uzc.a((stSimpleMetaFeed)localObject);
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    voi localvoi = a();
    if (localvoi == null) {
      return;
    }
    this.c = true;
    if (e())
    {
      this.c = false;
      localvoi.d();
    }
    super.a(paramString);
  }
  
  public void a(List<vpj> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    a(paramList, paramBoolean2, paramBoolean1);
    super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
    voq.a("[WSVerticalForHomePresenter.java][onSuccess] >>>>>", paramList);
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
        if (paramBoolean2) {
          this.a = (System.currentTimeMillis() - this.a);
        }
      } while ((paramList == null) || (paramList.size() <= 0));
      paramList = ((vpj)paramList.get(0)).a();
    } while (!(paramList instanceof stSimpleMetaFeed));
    paramList = (stSimpleMetaFeed)paramList;
    int i = 1;
    paramObject = vau.a().a(12);
    if (paramObject != null)
    {
      vmp.d("WSVerticalForHomePresenter", "RockDownloader:" + paramObject.download);
      i = paramObject.link_strategy_type;
    }
    a(false, i, paramList);
    a(paramBoolean2, paramList, i);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    voi localvoi = a();
    if (localvoi == null) {
      return false;
    }
    this.a = System.currentTimeMillis();
    WSVerticalDataManager.a().a(12, paramBoolean1, paramBoolean2, paramString, localvoi.a(), this, a());
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<vpj> paramList, Object paramObject)
  {
    if (paramBoolean2) {
      return d();
    }
    return (a(paramObject)) && (paramBoolean1);
  }
  
  public int b()
  {
    return b;
  }
  
  public boolean b()
  {
    voi localvoi = a();
    return (localvoi != null) && (localvoi.b());
  }
  
  public void f()
  {
    super.f();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsd
 * JD-Core Version:    0.7.0.1
 */