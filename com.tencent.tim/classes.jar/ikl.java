import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTools.1;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ikl
  extends iki
{
  public String Ny;
  
  public ikl(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static int a(PendantItem paramPendantItem, boolean paramBoolean)
  {
    if ((paramPendantItem != null) || (paramBoolean)) {}
    switch (AEFilterSupport.lo())
    {
    case 5: 
    case 6: 
    default: 
      return 0;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      if (paramVideoMaterial.getFabbyParts() != null)
      {
        paramVideoMaterial = paramVideoMaterial.getFabbyParts().getParts().iterator();
        FabbyMvPart localFabbyMvPart;
        do
        {
          if (!paramVideoMaterial.hasNext()) {
            break;
          }
          localFabbyMvPart = (FabbyMvPart)paramVideoMaterial.next();
        } while ((localFabbyMvPart.bgItem == null) || (localFabbyMvPart.bgItem.name == null) || (!localFabbyMvPart.bgItem.name.endsWith("_360")));
        return true;
      }
    }
    else {
      return false;
    }
    return false;
  }
  
  public void Y(int paramInt, String paramString)
  {
    long l = AudioHelper.hG();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 4, "MuteByOthers, seq[" + l + "], fromMuteKey[" + paramInt + "], data[" + paramString + "]");
    }
    if (paramInt == kU()) {}
    do
    {
      do
      {
        return;
        if (paramInt != 3003) {
          break;
        }
      } while (!"creativecop".equals(paramString));
      d(l, "0");
      return;
    } while ((paramInt != 3001) && (paramInt != 3004) && (paramInt != 3005));
    d(l, "0");
  }
  
  public iki.a a(int paramInt1, int paramInt2)
  {
    iki.a locala = super.a(paramInt1, paramInt2);
    if ((this.a != null) && (locala != null) && (locala.a != null))
    {
      boolean bool = ikg.a().tD();
      if ((!a(locala.a)) || (bool)) {
        this.a.kN(0);
      }
    }
    return locala;
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString1 = (PendantItem)a();
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getId())));
    a(paramLong, null);
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((bool) && (paramPendantItem != null) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      localObject = (ijt)this.mApp.a(12);
      if (localObject != null) {
        ((ijt)localObject).X(3002, paramPendantItem.getId());
      }
    }
    String str = this.TAG;
    if (paramPendantItem == null) {}
    for (Object localObject = null;; localObject = paramPendantItem.getId())
    {
      ikl.a.aT(str, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "setCurrentItem, item[" + paramPendantItem + "]");
      }
      return bool;
    }
  }
  
  protected boolean b(PendantItem paramPendantItem)
  {
    int j = 1;
    if ((getConfigID() <= 0) || (paramPendantItem == null) || (TextUtils.isEmpty(paramPendantItem.getId())))
    {
      igd.aL(this.TAG, "isTemplateUsable:" + getConfigID() + "|");
      return false;
    }
    if (TextUtils.isEmpty(paramPendantItem.getResurl())) {
      return true;
    }
    File localFile = new File(a(paramPendantItem));
    boolean bool = localFile.exists();
    Object localObject1;
    long l1;
    Object localObject2;
    if (!bool)
    {
      localObject1 = igg.gv() + paramPendantItem.getName();
      localFile = new File((String)localObject1);
      if (localFile.exists())
      {
        l1 = System.currentTimeMillis();
        localObject1 = SecUtil.getFileMd5((String)localObject1);
        long l2 = System.currentTimeMillis();
        localObject2 = paramPendantItem.getMd5();
        igd.aJ(this.TAG, "isTemplateUsable :" + (String)localObject1 + "|" + (String)localObject2 + "|" + (l2 - l1));
        bool = ((String)localObject2).equalsIgnoreCase((String)localObject1);
      }
    }
    for (;;)
    {
      int i;
      if (bool)
      {
        localObject1 = c(paramPendantItem);
        localObject2 = new File((String)localObject1, "params.json");
        l1 = ((File)localObject2).length();
        if (((((File)localObject2).exists()) && (l1 < 1L)) || (!((File)localObject2).exists()))
        {
          i = 1;
          if (i == 0) {
            break label370;
          }
          localObject1 = new File((String)localObject1, "params.dat");
          l1 = ((File)localObject1).length();
          if (((File)localObject1).exists())
          {
            i = j;
            if (l1 < 1L) {}
          }
          else
          {
            if (((File)localObject1).exists()) {
              break label362;
            }
            i = j;
          }
        }
      }
      label362:
      label370:
      for (;;)
      {
        if (i != 0)
        {
          ThreadManager.post(new EffectPendantTools.1(this, localFile, paramPendantItem), 5, null, false);
          return false;
          i = 0;
          break;
          i = 0;
          continue;
        }
        return bool;
      }
    }
  }
  
  public int getConfigID()
  {
    return 106;
  }
  
  public int kU()
  {
    return 3002;
  }
  
  public VideoMaterial parseVideoMaterial(String paramString)
  {
    VideoMaterial localVideoMaterial = QQTemplateParser.parseVideoMaterial(paramString, "params");
    localVideoMaterial.setDataPath(paramString);
    return localVideoMaterial;
  }
  
  public static class a
  {
    private static String NA = "actAVFunChatDecorate";
    static String Nz;
    static long lt;
    
    public static void a(String paramString, VideoAppInterface paramVideoAppInterface)
    {
      if (paramVideoAppInterface.ch(2))
      {
        paramVideoAppInterface = (PendantItem)((ikl)paramVideoAppInterface.a(2)).a();
        if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId()))) {
          aT(paramString, null);
        }
      }
    }
    
    static void aT(String paramString1, String paramString2)
    {
      long l1 = System.currentTimeMillis();
      if (!irc.equals(paramString2, Nz))
      {
        if ((!TextUtils.isEmpty(Nz)) && (lt != 0L))
        {
          long l2 = lt;
          f(paramString1, Nz, (l1 - l2) / 1000L);
        }
        Nz = paramString2;
        lt = l1;
      }
    }
    
    public static void f(String paramString1, String paramString2, long paramLong)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        long l = (System.currentTimeMillis() - paramLong) / 1000L;
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempID", paramString2);
        localHashMap.put("duration", l + "");
        UserAction.onUserAction(NA, true, -1L, -1L, localHashMap, true);
        igd.aJ(paramString1, "onStateReport, ID: " + paramString2 + "  pendant time: " + paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikl
 * JD-Core Version:    0.7.0.1
 */