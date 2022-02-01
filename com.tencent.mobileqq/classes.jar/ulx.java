import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.image.URLImageView;
import java.util.Iterator;
import java.util.List;

public class ulx
  extends uls<umk>
{
  private List<stNotificationRedDot> a;
  private List<stRedDotMenu> b;
  
  private int a()
  {
    return ugd.a().a();
  }
  
  private uko a()
  {
    return new uko(new uoz(), null, new uly(this), 1001);
  }
  
  private void a(Context paramContext, stRedDotMenu paramstRedDotMenu, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramstRedDotMenu != null) && (paramstRedDotMenu.schema != null))
    {
      paramstRedDotMenu = paramstRedDotMenu.schema;
      if (paramstRedDotMenu.type == 1)
      {
        if (paramInt2 == 1) {
          uqt.d("homepage_main");
        }
        for (;;)
        {
          a(paramContext, paramstRedDotMenu.miniAppSchema);
          return;
          if (paramInt2 == 2) {
            uqt.d("message");
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
        ueg.a(paramContext, paramstRedDotMenu.H5Url);
        return;
      }
      uqf.d("WSHomeFragmentPresenter", "jumOtherPlatform other type：" + paramstRedDotMenu.type);
      a(paramContext, paramString, "", "", paramInt1);
      return;
    }
    uqf.d("WSHomeFragmentPresenter", "jumOtherPlatform messageMenu is null");
    a(paramContext, paramString, "", "", paramInt1);
  }
  
  private void a(Context paramContext, String paramString)
  {
    ueg.a(paramContext, paramString, new ulz(this));
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    uqt.a(paramContext, paramString1, paramString2, paramString3, a(), new uma(this, paramContext, paramInt));
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
    paramContext = paramContext.getResources().getDrawable(2130841690);
    new udh().a(localURLImageView, paramContext, paramstPublisherRsp.guide.imageUrl, true, true);
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
    ukh.a().a(a());
  }
  
  public void d()
  {
    uko localuko = new uko(new uor(), null, new umb(this), 4008);
    ukh.a().a(localuko);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulx
 * JD-Core Version:    0.7.0.1
 */