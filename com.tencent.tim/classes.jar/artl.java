import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class artl
{
  protected static artl c;
  protected static byte[] lock = new byte[1];
  protected List<Friend> JD = new ArrayList(5);
  protected List<String> JE = new ArrayList(20);
  public int ekR = -1;
  public int ekS = -1;
  protected List<artm> oW = new ArrayList(20);
  
  public static artl a()
  {
    if (c == null) {}
    synchronized (lock)
    {
      if (c == null) {
        c = new artl();
      }
      return c;
    }
  }
  
  public int Nf()
  {
    return this.JD.size();
  }
  
  public int Ng()
  {
    return this.oW.size();
  }
  
  public void WZ(String paramString)
  {
    if (!this.JE.contains(paramString)) {
      this.JE.add(paramString);
    }
  }
  
  public void Xa(String paramString)
  {
    if (this.JE.contains(paramString)) {
      this.JE.remove(paramString);
    }
  }
  
  public Friend a(int paramInt)
  {
    return (Friend)this.JD.get(paramInt);
  }
  
  public Friend a(String paramString)
  {
    Friend localFriend;
    do
    {
      Iterator localIterator1 = this.oW.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((artm)localIterator1.next()).friendList.iterator();
      }
      localFriend = (Friend)localIterator2.next();
    } while (!paramString.equals(localFriend.openId));
    return localFriend;
    return null;
  }
  
  public List<Friend> ao(int paramInt)
  {
    return ((artm)this.oW.get(paramInt)).friendList;
  }
  
  public int bA()
  {
    return this.JE.size();
  }
  
  public String ee(int paramInt)
  {
    return ((artm)this.oW.get(paramInt)).groupName;
  }
  
  public void g(List<artm> paramList, int paramInt1, int paramInt2)
  {
    label9:
    String str2;
    Iterator localIterator1;
    if (paramList.size() <= 0)
    {
      return;
    }
    else
    {
      this.ekR = paramInt1;
      this.ekS = paramInt2;
      this.oW.clear();
      this.JD.clear();
      this.JE.clear();
      str2 = aroi.a().getContext().getResources().getString(2131691772);
      localIterator1 = paramList.iterator();
    }
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramList = (artm)localIterator1.next();
        if (str2.equals(paramList.groupName)) {
          this.JD.addAll(paramList.friendList);
        }
      }
      else
      {
        break label9;
      }
      this.oW.add(paramList);
      paramList = paramList.friendList;
      if (paramList == null) {
        break;
      }
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        Friend localFriend = (Friend)localIterator2.next();
        String str1 = localFriend.label;
        if (str1 != null)
        {
          paramList = str1;
          if (!"".equals(str1)) {}
        }
        else
        {
          paramList = localFriend.nickName;
        }
        localFriend.cCi = ChnToSpell.aJ(paramList, 2);
        localFriend.cCj = ChnToSpell.aJ(paramList, 1);
      }
    }
  }
  
  public List<Friend> gS()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.oW.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((artm)localIterator1.next()).friendList.iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add(localIterator2.next());
      }
    }
    return localArrayList;
  }
  
  public List<String> gT()
  {
    return this.JE;
  }
  
  public int kI(int paramInt)
  {
    List localList = ((artm)this.oW.get(paramInt)).friendList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public boolean so(String paramString)
  {
    return this.JE.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artl
 * JD-Core Version:    0.7.0.1
 */