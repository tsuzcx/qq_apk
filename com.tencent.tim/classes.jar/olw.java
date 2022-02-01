import UserGrowth.stNotificationRedDot;
import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class olw
  extends olr<omh>
{
  private List<stNotificationRedDot> lf;
  private List<stRedDotMenu> lg;
  
  private okz a()
  {
    return new okz(new ooa(), null, new olx(this), 1001);
  }
  
  private void a(Context paramContext, stRedDotMenu paramstRedDotMenu, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramstRedDotMenu != null) && (paramstRedDotMenu.schema != null))
    {
      paramstRedDotMenu = paramstRedDotMenu.schema;
      if (paramstRedDotMenu.type == 1)
      {
        if (paramInt2 == 1) {
          opn.pQ("homepage_main");
        }
        for (;;)
        {
          aW(paramContext, paramstRedDotMenu.miniAppSchema);
          return;
          if (paramInt2 == 2) {
            opn.pQ("message");
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
        ogj.aM(paramContext, paramstRedDotMenu.H5Url);
        return;
      }
      ooz.e("WSHomeFragmentPresenter", "jumOtherPlatform other type：" + paramstRedDotMenu.type);
      a(paramContext, paramString, "", "", paramInt1);
      return;
    }
    ooz.e("WSHomeFragmentPresenter", "jumOtherPlatform messageMenu is null");
    a(paramContext, paramString, "", "", paramInt1);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    opn.a(paramContext, paramString1, paramString2, paramString3, rx(), new olz(this, paramContext, paramInt));
  }
  
  private void aW(Context paramContext, String paramString)
  {
    ogj.a(paramContext, paramString, new oly(this));
  }
  
  private int rx()
  {
    return ohy.a().rp();
  }
  
  public void R(Context paramContext, int paramInt)
  {
    Object localObject2 = bo();
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
  
  public void bfL()
  {
    oks.a().b(a());
  }
  
  public void bfM()
  {
    okz localokz = new okz(new ont(), null, new oma(this), 4008);
    oks.a().b(localokz);
  }
  
  public List<stRedDotMenu> bo()
  {
    return this.lg;
  }
  
  public List<stNotificationRedDot> bp()
  {
    return this.lf;
  }
  
  public void cr(Context paramContext)
  {
    Object localObject2 = bo();
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
  
  public void dA(List<stNotificationRedDot> paramList)
  {
    this.lf = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olw
 * JD-Core Version:    0.7.0.1
 */