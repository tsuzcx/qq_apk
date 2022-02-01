import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ikd
  extends iki
{
  public static final String[] aM = { "params.dat" };
  public String Nv;
  public final ConcurrentHashMap<String, Integer> aC = new ConcurrentHashMap();
  public int anX;
  private int anY;
  
  public ikd(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.aN = aM;
  }
  
  public void U(String paramString, boolean paramBoolean)
  {
    super.U(paramString, paramBoolean);
    PendantItem localPendantItem = (PendantItem)a();
    if (localPendantItem == null)
    {
      this.Nv = null;
      this.anX = 50;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onDestroyUI, peerUin[" + paramString + "], quit[" + paramBoolean + "], item[" + a() + "]");
      }
      return;
      this.Nv = localPendantItem.getId();
    }
  }
  
  public void Y(int paramInt, String paramString)
  {
    long l = AudioHelper.hG();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 4, "MuteByOthers, fromMuteKey[" + paramInt + "], seq[" + l + "], data[" + paramString + "]");
    }
    if (paramInt == 3004) {}
    do
    {
      do
      {
        return;
        if (paramInt == 3002)
        {
          if (this.anY == 3003) {
            d(l, this.Nv);
          }
          this.anY = 3002;
          return;
        }
        if (paramInt != 3003) {
          break;
        }
      } while (!"creativecop".equals(paramString));
      this.anY = 3003;
      a(l, null);
      return;
    } while (paramInt != 3005);
    this.anY = 3005;
    a(l, null);
  }
  
  public iki.a a(int paramInt1, int paramInt2)
  {
    if (this.anY == 3002) {
      o(0L, "getVideoPendant");
    }
    iki.a locala = super.a(paramInt1, paramInt2);
    if ((locala != null) && (locala.b != null)) {
      locala.b.extraParam = Integer.valueOf(this.anX);
    }
    return locala;
  }
  
  public List<PendantItem> a(int paramInt, String paramString)
  {
    Object localObject = super.a(paramInt, paramString);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendantItem localPendantItem = (PendantItem)((Iterator)localObject).next();
        if (localPendantItem != null) {
          localArrayList.add(localPendantItem);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "parse, cid[" + paramInt + "], config[" + paramString + "], size[" + localArrayList.size() + "]");
    }
    return localArrayList;
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((!tz()) && (bool) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      ijt localijt = (ijt)this.mApp.a(12);
      if (localijt != null) {
        localijt.X(3004, paramPendantItem.getId());
      }
    }
    return bool;
  }
  
  public int am(String paramString)
  {
    Integer localInteger = null;
    if (!TextUtils.isEmpty(paramString)) {
      localInteger = (Integer)this.aC.get(paramString);
    }
    if (localInteger == null) {
      return 50;
    }
    return localInteger.intValue();
  }
  
  public void d(String paramString, int paramInt, boolean paramBoolean)
  {
    if (tz()) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.equals(paramString, this.Nv)) && (paramInt == this.anX));
      this.Nv = paramString;
      this.anX = paramInt;
    } while (TextUtils.isEmpty(this.Nv));
    this.aC.put(this.Nv, Integer.valueOf(paramInt));
  }
  
  public int getConfigID()
  {
    return 591;
  }
  
  public int kU()
  {
    return 3004;
  }
  
  public void o(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "clearMuteFlag, muteFlag[" + this.anY + "], from[" + paramString + "], cur[" + this.Nv + "], value[" + this.anX + "]");
    }
    if ((this.anY == 3003) || (this.anY == 3005)) {
      d(paramLong, this.Nv);
    }
    this.anY = 0;
  }
  
  public boolean tz()
  {
    return (this.anY == 3002) || (this.anY == 3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikd
 * JD-Core Version:    0.7.0.1
 */