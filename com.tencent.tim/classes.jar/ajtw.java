import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.1;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.2;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.3;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

public class ajtw
  implements Manager
{
  public QQAppInterface app;
  protected Object ei = new Object();
  public EntityManager em;
  public Object mLock = new Object();
  public Map<String, RecentInviteUser> mc = new HashMap();
  
  public ajtw(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    ThreadManager.post(new WerewolvesDataManager.1(this, paramQQAppInterface), 5, null, false);
  }
  
  public void U(String arg1, int paramInt, String paramString2)
  {
    String str = RecentInviteUser.getKey(paramInt, ???);
    synchronized (this.mLock)
    {
      ??? = (RecentInviteUser)this.mc.get(str);
      ??? = ???;
      if (??? == null)
      {
        ??? = new RecentInviteUser();
        ((RecentInviteUser)???).uniKey = str;
      }
      synchronized (this.mLock)
      {
        this.mc.put(str, ???);
        ((RecentInviteUser)???).uin = ???;
        ((RecentInviteUser)???).uinType = paramInt;
        ((RecentInviteUser)???).lastInviteId = paramString2;
      }
    }
    synchronized (this.ei)
    {
      ((RecentInviteUser)???).lastInviteTime = System.currentTimeMillis();
      a((RecentInviteUser)???);
      return;
      ??? = finally;
      throw ???;
      ??? = finally;
      throw ???;
    }
  }
  
  public void a(RecentInviteUser paramRecentInviteUser)
  {
    ThreadManager.post(new WerewolvesDataManager.3(this, paramRecentInviteUser), 5, null, false);
  }
  
  public void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, ajtw.a parama)
  {
    ThreadManager.post(new WerewolvesDataManager.2(this, paramString1, paramString2, paramArrayList, parama), 8, null, true);
  }
  
  public List<RecentInviteUser> fJ()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mLock)
    {
      Object localObject3 = this.mc.values();
      ??? = ((Collection)localObject3).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (RecentInviteUser)((Iterator)???).next();
        if (((RecentInviteUser)localObject3).uinType == 0) {
          localArrayList.add(localObject3);
        }
      }
    }
    synchronized (this.ei)
    {
      Collections.sort(localList);
      return localList;
    }
  }
  
  public List<RecentInviteUser> fK()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mLock)
    {
      Object localObject2 = this.mc.values();
      ??? = ((Collection)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (RecentInviteUser)((Iterator)???).next();
        if (((RecentInviteUser)localObject2).uinType == 1) {
          localArrayList.add(localObject2);
        }
      }
    }
    Collections.sort(localList);
    return localList;
  }
  
  public boolean k(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.mLock)
    {
      paramString1 = (RecentInviteUser)this.mc.get(RecentInviteUser.getKey(paramInt, paramString1));
      if (paramString1 != null)
      {
        boolean bool = TextUtils.equals(paramString1.lastInviteId, paramString2);
        return bool;
      }
      return false;
    }
  }
  
  public void onDestroy() {}
  
  public static abstract interface a
  {
    public abstract void au(List<ajtw.b> paramList, boolean paramBoolean);
  }
  
  public class b
  {
    public boolean cqf;
    public String displayName;
    public String uin;
    public int uinType;
    
    public b() {}
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        bool1 = bool2;
        if (paramObject.uin.equals(this.uin))
        {
          bool1 = bool2;
          if (paramObject.uinType == this.uinType) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtw
 * JD-Core Version:    0.7.0.1
 */