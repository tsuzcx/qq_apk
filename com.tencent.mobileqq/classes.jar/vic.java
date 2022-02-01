import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.image.URLImageView;
import java.util.Iterator;
import java.util.List;

public class vic
  extends vhx<vir>
{
  private List<stNotificationRedDot> a;
  private List<stRedDotMenu> b;
  
  private int a()
  {
    return vau.a().a();
  }
  
  private vfr a()
  {
    return new vfr(new vlj(), null, new vid(this), 1001);
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Object localObject = vnd.a();
    if (localObject == null) {
      return;
    }
    paramstSimpleMetaFeed.feed_desc = vnd.a(paramstSimpleMetaFeed.feed_desc);
    ((pws)localObject).a(paramstSimpleMetaFeed);
    localObject = (vir)a();
    if ((localObject instanceof WSHomeFragment))
    {
      localObject = ((WSHomeFragment)localObject).getActivity();
      if ((localObject != null) && (!((FragmentActivity)localObject).isFinishing()))
      {
        vmp.e("WSHomeFragmentPresenter", "[handleSaveAndPreloadData] WSHomeFragment is not finishing");
        vmp.e("WSHomeFragmentPresenter", "[handleSaveAndPreloadData] feedInfo:" + paramstSimpleMetaFeed.video_url);
        return;
      }
    }
    vmp.e("WSHomeFragmentPresenter", "[handleSaveAndPreloadData] WSHomeFragment is finishing");
    uzc.a(paramstSimpleMetaFeed);
  }
  
  private void a(Context paramContext, stRedDotMenu paramstRedDotMenu, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramstRedDotMenu != null) && (paramstRedDotMenu.schema != null))
    {
      paramstRedDotMenu = paramstRedDotMenu.schema;
      if (paramstRedDotMenu.type == 1)
      {
        if (paramInt2 == 1) {
          vnd.d("homepage_main");
        }
        for (;;)
        {
          a(paramContext, paramstRedDotMenu.miniAppSchema);
          return;
          if (paramInt2 == 2) {
            vnd.d("message");
          }
        }
      }
      if (paramstRedDotMenu.type == 2)
      {
        a(paramContext, paramstRedDotMenu.schema, "", "", paramInt1);
        return;
      }
      if (paramstRedDotMenu.type == 3)
      {
        uyt.a(paramContext, paramstRedDotMenu.H5Url);
        return;
      }
      vmp.d("WSHomeFragmentPresenter", "jumOtherPlatform other type：" + paramstRedDotMenu.type);
      a(paramContext, paramString, "", "", paramInt1);
      return;
    }
    vmp.d("WSHomeFragmentPresenter", "jumOtherPlatform messageMenu is null");
    a(paramContext, paramString, "", "", paramInt1);
  }
  
  private void a(Context paramContext, String paramString)
  {
    uyt.a(paramContext, paramString, new vie(this));
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    vnd.a(paramContext, paramString1, paramString2, paramString3, a(), new vif(this, paramContext, paramInt));
  }
  
  public List<stRedDotMenu> a()
  {
    return this.b;
  }
  
  public void a(Context paramContext)
  {
    Object localObject2 = a();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (stRedDotMenu)localIterator.next();
        if (!TextUtils.equals("PersonalPage", ((stRedDotMenu)localObject2).menuKey)) {
          break label70;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      a(paramContext, localObject1, "weishi://profile?goto=myself", 603, 1);
      return;
      label70:
      break;
      localObject1 = null;
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    Object localObject2 = a();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (stRedDotMenu)localIterator.next();
        if (!TextUtils.equals("Notification", ((stRedDotMenu)localObject2).menuKey)) {
          break label74;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      a(paramContext, localObject1, "weishi://message?page=notifiaction", paramInt, 2);
      return;
      label74:
      break;
      localObject1 = null;
    }
  }
  
  public void a(Context paramContext, stPublisherRsp paramstPublisherRsp)
  {
    if ((paramstPublisherRsp == null) || (paramstPublisherRsp.guide == null)) {
      return;
    }
    URLImageView localURLImageView = new URLImageView(paramContext);
    paramContext = paramContext.getResources().getDrawable(2130841740);
    new uxu().a(localURLImageView, paramContext, paramstPublisherRsp.guide.imageUrl, true, true);
  }
  
  public void a(List<stNotificationRedDot> paramList)
  {
    this.a = paramList;
  }
  
  public List<stNotificationRedDot> b()
  {
    return this.a;
  }
  
  public void c()
  {
    vfk.a().a(a());
  }
  
  public void d()
  {
    vfr localvfr = new vfr(new vla(), null, new vig(this), 4008);
    vfk.a().a(localvfr);
  }
  
  public void e()
  {
    long l = System.currentTimeMillis();
    vfr localvfr = new vfr(new vkw(), null, new vih(this, l), 4015);
    vfk.a().a(localvfr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vic
 * JD-Core Version:    0.7.0.1
 */