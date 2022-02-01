import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class apoo
{
  private LinkedHashMap<String, List<ChatHistoryTroopMemberFragment.a>> D = new LinkedHashMap();
  private List<ChatHistoryTroopMemberFragment.a> Ic;
  private List<ChatHistoryTroopMemberFragment.a> Id;
  private List<ChatHistoryTroopMemberFragment.a> Ie;
  private int[] ad = new int[0];
  public int bMd;
  public int bMe;
  private String[] k = new String[0];
  public int mItemCount;
  
  public apoo(List<ChatHistoryTroopMemberFragment.a> paramList)
  {
    this.Ic = paramList;
    this.Ie = new ArrayList();
  }
  
  private apoo.a a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, String paramString, apoo.a parama, boolean paramBoolean)
  {
    if (((apof.a(paramQQAppInterface, paramTroopInfo)) || (apof.b(paramQQAppInterface, paramTroopInfo))) && (!paramBoolean))
    {
      paramQQAppInterface = apon.a();
      if ((TextUtils.isEmpty(paramString)) || (apon.a(paramString, paramQQAppInterface))) {
        parama.Bu.add(0, paramQQAppInterface);
      }
    }
    return parama;
  }
  
  private apoo.a a(String paramString, boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    paramTroopInfo = a(paramString, paramTroopInfo);
    if (paramTroopInfo.length >= 3)
    {
      this.D = ((LinkedHashMap)paramTroopInfo[0]);
      this.ad = ((int[])paramTroopInfo[1]);
    }
    for (this.k = ((String[])paramTroopInfo[2]);; this.k = new String[0])
    {
      this.Ie = a(this.D);
      paramTroopInfo = new apoo.a();
      paramTroopInfo.keyWord = paramString;
      paramTroopInfo.cRP = paramBoolean;
      paramTroopInfo.oL = this.ad;
      paramTroopInfo.hD = this.k;
      paramTroopInfo.Bu = this.Ie;
      return paramTroopInfo;
      this.D.clear();
      this.ad = new int[0];
    }
  }
  
  private List<ChatHistoryTroopMemberFragment.a> a(LinkedHashMap<String, List<ChatHistoryTroopMemberFragment.a>> paramLinkedHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    while (paramLinkedHashMap.hasNext()) {
      localArrayList.addAll((Collection)((Map.Entry)paramLinkedHashMap.next()).getValue());
    }
    return localArrayList;
  }
  
  private Object[] a(String paramString, TroopInfo paramTroopInfo)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1;
    Object localObject2;
    int i;
    for (;;)
    {
      ChatHistoryTroopMemberFragment.a locala;
      try
      {
        this.mItemCount = 0;
        this.bMd = 0;
        this.bMe = 0;
        Iterator localIterator = this.Id.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (ChatHistoryTroopMemberFragment.a)localIterator.next();
        if ((locala.isTroopFollowed) || ((!TextUtils.isEmpty(paramString)) && (apof.a(locala.uin, paramTroopInfo)))) {
          break label664;
        }
        if ((TextUtils.isEmpty(paramString)) || (!apof.b(locala.uin, paramTroopInfo))) {
          break label228;
        }
      }
      finally {}
      localObject2 = localObject1;
      if (((String)localObject1).length() == 1)
      {
        i = ((String)localObject1).charAt(0);
        localObject2 = localObject1;
        if (!((String)localObject1).equals("★"))
        {
          if ((65 > i) || (i > 90)) {
            break label671;
          }
          label160:
          localObject2 = ((String)localObject1).toUpperCase();
        }
      }
      label167:
      if (localLinkedHashMap.get(localObject2) == null) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      this.mItemCount += 1;
      ((List)localLinkedHashMap.get(localObject2)).add(locala);
      continue;
      label228:
      localObject1 = locala.baj;
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        break label688;
      }
      localObject1 = ((String)localObject1).substring(0, 1);
    }
    paramTroopInfo = new apof.a(paramTroopInfo);
    paramString = new LinkedHashMap();
    long l = System.currentTimeMillis();
    if (localLinkedHashMap.get("★") != null)
    {
      this.bMd += 1;
      Collections.sort((List)localLinkedHashMap.get("★"), paramTroopInfo);
      paramString.put("★", localLinkedHashMap.get("★"));
    }
    for (;;)
    {
      if (c <= 'Z')
      {
        if (localLinkedHashMap.get(String.valueOf(c)) != null)
        {
          this.bMd += 1;
          Collections.sort((List)localLinkedHashMap.get(String.valueOf(c)), paramTroopInfo);
          paramString.put(String.valueOf(c), localLinkedHashMap.get(String.valueOf(c)));
        }
      }
      else
      {
        if (localLinkedHashMap.get("#") != null)
        {
          this.bMd += 1;
          Collections.sort((List)localLinkedHashMap.get("#"), paramTroopInfo);
          paramString.put("#", localLinkedHashMap.get("#"));
        }
        if (QLog.isColorLevel()) {
          QLog.i("SearchTask", 2, "constructHashStruct-sort: invoked.  cost: " + (System.currentTimeMillis() - l));
        }
        localLinkedHashMap.clear();
        paramTroopInfo = new int[paramString.keySet().size()];
        localObject1 = new String[paramTroopInfo.length];
        localObject2 = paramString.keySet().iterator();
        if (paramTroopInfo.length == 0) {
          return new Object[0];
        }
        paramTroopInfo[0] = 0;
        i = 1;
        while (i < paramTroopInfo.length)
        {
          int j = paramTroopInfo[i];
          int m = paramTroopInfo[(i - 1)];
          paramTroopInfo[i] = (((List)paramString.get(((Iterator)localObject2).next())).size() + m + j);
          i += 1;
        }
        localObject2 = paramString.keySet().iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1[i] = ((String)((Iterator)localObject2).next());
          i += 1;
        }
        return new Object[] { paramString, paramTroopInfo, localObject1 };
        label664:
        localObject1 = "★";
        break;
        label671:
        if ((97 <= i) && (i <= 122))
        {
          break label160;
          label688:
          localObject1 = "#";
          break;
        }
        localObject2 = "#";
        break label167;
        c = 'A';
        continue;
      }
      char c = (char)(c + '\001');
    }
  }
  
  public apoo.a a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, SessionInfo paramSessionInfo, boolean paramBoolean2)
  {
    TroopInfo localTroopInfo = null;
    if (paramSessionInfo != null)
    {
      paramSessionInfo = paramSessionInfo.aTl;
      localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (this.Id = apon.a(paramQQAppInterface, this.Ic, paramBoolean1);; this.Id = new ArrayList(apon.a(paramString, apon.a(paramQQAppInterface, this.Ic, paramBoolean1), paramQQAppInterface, localTroopInfo))) {
      return a(paramQQAppInterface, localTroopInfo, paramString, a(paramString, paramBoolean1, localTroopInfo), paramBoolean2);
    }
  }
  
  public static class a
  {
    public List<ChatHistoryTroopMemberFragment.a> Bu;
    public boolean cRP;
    public String[] hD;
    public String keyWord;
    public int[] oL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoo
 * JD-Core Version:    0.7.0.1
 */