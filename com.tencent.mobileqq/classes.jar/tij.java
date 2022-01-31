import UserGrowth.stNotificationRedDot;
import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.util.Iterator;
import java.util.List;

public class tij
  extends tie<tiu>
{
  private List<stNotificationRedDot> a;
  private List<stRedDotMenu> b;
  
  private int a()
  {
    return tee.a().a();
  }
  
  private the a()
  {
    return new the(new tko(), null, new tik(this), 1001);
  }
  
  private void a(Context paramContext, stRedDotMenu paramstRedDotMenu, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramstRedDotMenu != null) && (paramstRedDotMenu.schema != null))
    {
      paramstRedDotMenu = paramstRedDotMenu.schema;
      if (paramstRedDotMenu.type == 1)
      {
        if (paramInt2 == 1) {
          tlv.c("homepage_main");
        }
        for (;;)
        {
          a(paramContext, paramstRedDotMenu.miniAppSchema);
          return;
          if (paramInt2 == 2) {
            tlv.c("message");
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
        tch.a(paramContext, paramstRedDotMenu.H5Url);
        return;
      }
      tlo.d("WSHomeFragmentPresenter", "jumOtherPlatform other type：" + paramstRedDotMenu.type);
      a(paramContext, paramString, "", "", paramInt1);
      return;
    }
    tlo.d("WSHomeFragmentPresenter", "jumOtherPlatform messageMenu is null");
    a(paramContext, paramString, "", "", paramInt1);
  }
  
  private void a(Context paramContext, String paramString)
  {
    MiniAppLauncher.startMiniApp(paramContext, paramString, 2003, new til(this));
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    tlv.a(paramContext, paramString1, paramString2, paramString3, a(), new tim(this, paramContext, paramInt));
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
    tgx.a().a(a());
  }
  
  public void d()
  {
    the localthe = new the(new tkh(), null, new tin(this), 4008);
    tgx.a().a(localthe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tij
 * JD-Core Version:    0.7.0.1
 */