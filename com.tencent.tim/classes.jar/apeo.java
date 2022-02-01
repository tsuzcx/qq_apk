import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class apeo
{
  private static volatile apeo a;
  protected List<amjz> Ch;
  protected List<apep> HJ;
  
  public static ArrayList<Long> E(List<? extends amka> paramList)
  {
    ArrayList localArrayList = null;
    int j;
    int i;
    if (paramList != null)
    {
      j = paramList.size();
      localArrayList = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = (amka)paramList.get(i);
        if ((localObject instanceof amjk))
        {
          localObject = (amjk)localObject;
          try
          {
            if ((((amjk)localObject).IN() == 0) || (((amjk)localObject).IN() == 3)) {
              break label116;
            }
            localArrayList.add(Long.valueOf(Long.parseLong(((amjk)localObject).getIdentifier())));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
          catch (NullPointerException localNullPointerException)
          {
            localNullPointerException.printStackTrace();
          }
        }
      }
      else
      {
        return localArrayList;
      }
      label116:
      i += 1;
    }
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (paramString1 == null) {}
    for (paramString1 = ""; TextUtils.isEmpty(paramString1); paramString1 = paramString1.trim().toLowerCase()) {
      return 0;
    }
    if (paramString3 == null)
    {
      paramString3 = null;
      if (paramString4 != null) {
        break label106;
      }
      paramString4 = null;
      label39:
      if (paramString5 != null) {
        break label117;
      }
      paramString5 = null;
      label47:
      if (paramString6 != null) {
        break label130;
      }
      paramString6 = null;
      label55:
      if (paramString7 != null) {
        break label143;
      }
      paramString7 = null;
      label63:
      if (paramString8 != null) {
        break label156;
      }
      paramString8 = null;
      label71:
      if (paramString2 != null) {
        break label169;
      }
    }
    label130:
    label143:
    label156:
    label169:
    for (paramString2 = null;; paramString2 = paramString2.trim().toLowerCase())
    {
      if ((TextUtils.isEmpty(paramString2)) || (!paramString2.contains(paramString1))) {
        break label180;
      }
      return 7;
      paramString3 = paramString3.trim().toLowerCase();
      break;
      label106:
      paramString4 = paramString4.trim().toLowerCase();
      break label39;
      label117:
      paramString5 = paramString5.trim().toLowerCase();
      break label47;
      paramString6 = paramString6.trim().toLowerCase();
      break label55;
      paramString7 = paramString7.trim().toLowerCase();
      break label63;
      paramString8 = paramString8.trim().toLowerCase();
      break label71;
    }
    label180:
    if ((!TextUtils.isEmpty(paramString6)) && (paramString6.contains(paramString1))) {
      return 4;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (paramString3.contains(paramString1))) {
      return 1;
    }
    if ((!TextUtils.isEmpty(paramString7)) && (paramString7.contains(paramString1))) {
      return 5;
    }
    if ((!TextUtils.isEmpty(paramString8)) && (paramString8.contains(paramString1))) {
      return 6;
    }
    if (((!TextUtils.isEmpty(paramString4)) && (paramString4.contains(paramString1))) || ((!TextUtils.isEmpty(paramString5)) && (paramString5.contains(paramString1)))) {
      return 2;
    }
    if (((!TextUtils.isEmpty(paramString4)) && (paramString4.contains(paramString1))) || ((!TextUtils.isEmpty(paramString5)) && (paramString5.contains(paramString1)))) {
      return 3;
    }
    return 0;
  }
  
  public static apeo a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new apeo();
      }
      return a;
    }
    finally {}
  }
  
  public static final String b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramInt == 1) {}
    while ((paramInt == 2) || (paramInt == 3)) {
      return paramString2;
    }
    if (paramInt == 4) {
      return paramString3;
    }
    if (paramInt == 5) {
      return paramString3;
    }
    if (paramInt == 6) {
      return paramString3;
    }
    if (paramInt == 7) {
      return paramString1;
    }
    return null;
  }
  
  public final amjk a(String paramString)
  {
    if (this.Ch == null) {
      return null;
    }
    int j = this.Ch.size();
    int i = 0;
    while (i < j)
    {
      amjz localamjz = (amjz)this.Ch.get(i);
      if (((localamjz instanceof amjk)) && (paramString.equals(localamjz.getIdentifier()))) {
        return (amjk)localamjz;
      }
      i += 1;
    }
    return null;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public List<amjz> a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ExecutorService localExecutorService = Executors.newFixedThreadPool(1);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localExecutorService.submit(new apeo.a(paramContext, paramQQAppInterface, amjz.ajr, paramInt)));
    paramInt = 0;
    try
    {
      while (paramInt < localArrayList2.size())
      {
        paramContext = (List)((Future)localArrayList2.get(paramInt)).get();
        localArrayList1.addAll(paramContext);
        paramContext.clear();
        paramInt += 1;
      }
      localArrayList2.clear();
      localExecutorService.shutdown();
    }
    catch (InterruptedException paramContext)
    {
      for (;;)
      {
        long l2;
        paramContext.printStackTrace();
      }
    }
    catch (ExecutionException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileSearchManager", 2, "initSearchData() time cost = " + (l2 - l1) + " , size = " + localArrayList1.size());
    }
    return localArrayList1;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public List<amjz> a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    acff localacff = (acff)paramQQAppInterface.getManager(51);
    Object localObject;
    if (localacff != null)
    {
      localObject = localacff.co();
      if (localObject != null)
      {
        Iterator localIterator1 = ((List)localObject).iterator();
        while (localIterator1.hasNext())
        {
          Groups localGroups = (Groups)localIterator1.next();
          localObject = localacff.B(String.valueOf(localGroups.group_id));
          if (localObject != null)
          {
            Iterator localIterator2 = ((List)localObject).iterator();
            label105:
            Friends localFriends;
            if (localIterator2.hasNext())
            {
              localFriends = (Friends)localIterator2.next();
              if (localFriends.gathtertype != 1) {
                break label176;
              }
            }
            label176:
            for (localObject = paramContext.getResources().getString(2131721547);; localObject = localGroups.group_name)
            {
              localArrayList.add(new amjk(paramContext, paramQQAppInterface, localFriends, (String)localObject, 0L, paramLong));
              break label105;
              break;
            }
          }
        }
      }
    }
    if (paramBoolean)
    {
      localObject = new Friends();
      ((Friends)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
      ((Friends)localObject).name = paramQQAppInterface.getCurrentNickname();
      localArrayList.add(new amjk(paramContext, paramQQAppInterface, (Friends)localObject, paramContext.getResources().getString(2131721547), 0L, paramLong));
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileSearchManager", 2, "getFriends() time cost = " + (paramLong - l) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public List<apep> a(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    acff localacff = (acff)paramQQAppInterface.getManager(51);
    if (localacff != null)
    {
      Object localObject1 = localacff.co();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = localacff.B(String.valueOf(((Groups)((Iterator)localObject1).next()).group_id));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Friends localFriends = (Friends)((Iterator)localObject2).next();
              localArrayList.add(new apep(paramContext, localFriends.uin, localFriends.name, localFriends.remark));
            }
          }
        }
      }
    }
    if (paramBoolean) {
      localArrayList.add(new apep(paramContext, paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentNickname(), null));
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileSearchManager", 2, "getFriendsSearchedSet() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public String bL(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    int i;
    int j;
    if (this.HJ == null)
    {
      i = 0;
      j = 0;
      label17:
      if (j >= i) {
        break label156;
      }
      localObject = (apep)this.HJ.get(j);
      if (!((apep)localObject).uin.equals(paramString2)) {
        break label147;
      }
    }
    label147:
    label156:
    for (Object localObject = apep.a(paramString1, (apep)localObject);; localObject = null)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileSearchManager", 2, "getFriendsSearchedSet() time cost = " + (l2 - l1) + " , hanzi = " + (String)localObject + ", input = " + paramString1 + ", uin = " + paramString2);
      }
      return localObject;
      i = this.HJ.size();
      break;
      j += 1;
      break label17;
    }
  }
  
  public void release()
  {
    if (this.Ch != null) {
      this.Ch.clear();
    }
    if (this.HJ != null) {
      this.HJ.clear();
    }
  }
  
  public class a
    implements Callable<List<amjz>>
  {
    private QQAppInterface app;
    private long aqW;
    private Context context;
    
    public a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
    {
      this.context = paramContext;
      this.app = paramQQAppInterface;
      this.aqW = paramLong;
    }
    
    public List<amjz> ge()
      throws Exception
    {
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      if (amjz.ajr == this.aqW)
      {
        apeo.this.Ch = apeo.this.a(this.context, this.app, this.aqW, true);
        localArrayList.addAll(apeo.this.Ch);
        apeo.this.HJ = apeo.this.a(this.context, this.app, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "CallableForSearchData time = " + (System.currentTimeMillis() - l));
      }
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apeo
 * JD-Core Version:    0.7.0.1
 */