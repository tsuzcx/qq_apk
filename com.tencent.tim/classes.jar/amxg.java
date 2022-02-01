import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.ArrayList;
import java.util.ArrayList<Lyow;>;
import java.util.Iterator;
import java.util.List;

public class amxg
{
  public static long[] av;
  public static String cco;
  public static int dDN;
  public static String sName;
  
  public static void C(List<ampx> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    long[] arrayOfLong;
    do
    {
      return;
      arrayOfLong = av;
    } while ((arrayOfLong == null) || (arrayOfLong.length != 2) || (arrayOfLong[0] != 1001L) || (arrayOfLong[1] != 1002L));
    amxk.d("all_search", "user_grp", "clk_more_grp", 0, c(paramList, paramString), new String[] { "", "", paramString, "" });
  }
  
  public static void a(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    dDN = paramInt;
    av = paramArrayOfLong;
    sName = paramString1;
    cco = paramString2;
  }
  
  public static void a(amow paramamow)
  {
    if ((paramamow == null) || (paramamow.IW() != 1002)) {}
    String str1;
    String str2;
    String str3;
    int i;
    long[] arrayOfLong;
    do
    {
      return;
      str1 = paramamow.getKeyword();
      str2 = paramamow.getUin();
      str3 = paramamow.zg();
      i = paramamow.dDm;
      paramamow = i + 1 + "";
      if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2))) {}
      for (i = 1;; i = 2)
      {
        arrayOfLong = av;
        if ((arrayOfLong == null) || (arrayOfLong.length != 2) || (arrayOfLong[0] != 1001L) || (arrayOfLong[1] != 1002L)) {
          break;
        }
        amxk.d("all_search", "user_grp", "clk_grp", 0, i, new String[] { str2, paramamow, str1, str3 });
        return;
      }
    } while ((arrayOfLong == null) || (arrayOfLong.length != 1) || (arrayOfLong[0] != 1002L));
    amxk.d("all_search", "more_grp", "clk_grp", 0, i, new String[] { str2, paramamow, str1, str3 });
  }
  
  public static void a(List<ampv> paramList, List<ampw> paramList1, boolean paramBoolean, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    int j = 2;
    if ((paramList1 != null) && (paramList1.size() > 0)) {}
    String str;
    for (paramString1 = "1";; paramString1 = "2")
    {
      str = "";
      if ((paramArrayOfLong == null) || (paramArrayOfLong.length != 2) || (paramArrayOfLong[0] != 1001L) || (paramArrayOfLong[1] != 1002L)) {
        break label418;
      }
      if (!paramBoolean) {
        break;
      }
      return;
    }
    paramArrayOfLong = str;
    int i = j;
    if (paramList1 != null)
    {
      paramArrayOfLong = str;
      i = j;
      if (paramList1.size() > 0)
      {
        paramList1 = paramList1.iterator();
        paramList = str;
        label103:
        paramArrayOfLong = paramList;
        i = j;
        if (paramList1.hasNext())
        {
          paramArrayOfLong = (ampw)paramList1.next();
          if ((!(paramArrayOfLong instanceof amov)) || (paramArrayOfLong.eX() == null)) {
            break label823;
          }
          paramArrayOfLong = (amov)paramArrayOfLong;
          if (paramArrayOfLong.ajO == 1001L) {
            if (TextUtils.isEmpty(paramList)) {
              paramList = "1";
            }
          }
        }
      }
    }
    label418:
    label814:
    label823:
    for (;;)
    {
      break label103;
      paramList = paramList + "::1";
      continue;
      if (paramArrayOfLong.ajO == 1002L)
      {
        if (TextUtils.isEmpty(paramList)) {}
        for (paramList = "2";; paramList = paramList + "::2")
        {
          paramArrayOfLong = paramArrayOfLong.eX();
          j = c(paramArrayOfLong, paramString2);
          paramArrayOfLong = paramArrayOfLong.iterator();
          while (paramArrayOfLong.hasNext())
          {
            paramString1 = (ampx)paramArrayOfLong.next();
            if ((paramString1 instanceof amow))
            {
              paramString1 = (amow)paramString1;
              if (paramString1.IW() == 1002)
              {
                i = paramString1.dDm;
                str = i + 1 + "";
                amxk.d("all_search", "user_grp", "exp_grp", 0, j, new String[] { paramString1.getUin(), str, paramString2, paramString1.zg() });
              }
            }
          }
        }
        amxk.d("all_search", "user_grp", "exp", 0, i, new String[] { "", paramArrayOfLong, paramString2, "" });
        return;
        if ((paramArrayOfLong == null) || (paramArrayOfLong.length != 1) || (paramArrayOfLong[0] != 1002L)) {
          break;
        }
        if ((paramBoolean) && (paramList != null) && (!paramList.isEmpty()))
        {
          paramList = paramList.iterator();
          i = 0;
          while (paramList.hasNext())
          {
            if (!((ampv)paramList.next() instanceof amow)) {
              break label814;
            }
            i += 1;
          }
        }
        for (;;)
        {
          int k = j;
          if (paramList1 != null)
          {
            k = j;
            if (paramList1.size() > 0)
            {
              paramList = paramList1.iterator();
              do
              {
                do
                {
                  k = j;
                  if (!paramList.hasNext()) {
                    break;
                  }
                  paramList1 = (ampw)paramList.next();
                } while ((!(paramList1 instanceof amov)) || (paramList1.eX() == null));
                paramList1 = (amov)paramList1;
              } while (paramList1.ajO != 1002L);
              paramList = paramList1.eX();
              j = c(paramList, paramString2);
              k = j;
              if (paramList != null)
              {
                paramList = paramList.iterator();
                for (;;)
                {
                  k = j;
                  if (!paramList.hasNext()) {
                    break;
                  }
                  paramList1 = (ampx)paramList.next();
                  if ((paramList1 instanceof amow))
                  {
                    paramList1 = (amow)paramList1;
                    if (paramList1.IW() == 1002)
                    {
                      paramList1.dDm += i;
                      k = paramList1.dDm;
                      paramArrayOfLong = k + 1 + "";
                      amxk.d("all_search", "more_grp", "exp_grp", 0, j, new String[] { paramList1.getUin(), paramArrayOfLong, paramString2, paramList1.zg() });
                    }
                  }
                }
              }
            }
          }
          if (paramBoolean)
          {
            amxk.d("all_search", "more_grp", "load_more", 0, k, new String[] { paramString1, "", paramString2, "" });
            return;
          }
          amxk.d("all_search", "more_grp", "exp", 0, k, new String[] { paramString1, "", paramString2, "" });
          return;
          break;
          i = 0;
        }
      }
    }
  }
  
  public static void b(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    a(paramInt, paramArrayOfLong, paramString1, paramString2);
    if (paramInt == 2) {}
    for (paramString1 = "2";; paramString1 = "1")
    {
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 2) && (paramArrayOfLong[0] == 1001L) && (paramArrayOfLong[1] == 1002L)) {
        amxk.d("all_search", "user_grp", "search_cnt", 0, 0, new String[] { "", paramString1, paramString2, "" });
      }
      while ((paramArrayOfLong == null) || (paramArrayOfLong.length != 1) || (paramArrayOfLong[0] != 1002L)) {
        return;
      }
      amxk.d("all_search", "more_grp", "search_cnt", 0, 0, new String[] { "", paramString1, paramString2, "" });
      return;
    }
  }
  
  public static int c(ArrayList<yow> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return 2;
    }
    int i = 2;
    Object localObject1 = "";
    Iterator localIterator1 = paramArrayList.iterator();
    paramArrayList = (ArrayList<yow>)localObject1;
    while (localIterator1.hasNext())
    {
      localObject1 = (yow)localIterator1.next();
      if (localObject1 != null)
      {
        int j = i;
        if (((yow)localObject1).resultType == 80000001)
        {
          j = i;
          if (((yow)localObject1).sS != null)
          {
            j = i;
            if (((yow)localObject1).sS.size() > 0)
            {
              Iterator localIterator2 = ((yow)localObject1).sS.iterator();
              do
              {
                j = i;
                if (!localIterator2.hasNext()) {
                  break;
                }
                localObject2 = (AccountSearchPb.record)localIterator2.next();
              } while (localObject2 == null);
              Object localObject2 = String.valueOf(((AccountSearchPb.record)localObject2).code.get());
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramString))) {}
              for (i = 1;; i = 2)
              {
                amxk.d("add_page", "all_result", "exp_grp", 0, i, new String[] { localObject2, "", paramString, "" });
                break;
              }
            }
          }
        }
        switch (((yow)localObject1).resultType)
        {
        }
        for (;;)
        {
          i = j;
          break;
          if (TextUtils.isEmpty(paramArrayList))
          {
            paramArrayList = "1";
          }
          else
          {
            paramArrayList = paramArrayList + "::1";
            continue;
            if (TextUtils.isEmpty(paramArrayList))
            {
              paramArrayList = "2";
            }
            else
            {
              paramArrayList = paramArrayList + "::2";
              continue;
              if (TextUtils.isEmpty(paramArrayList))
              {
                paramArrayList = "3";
              }
              else
              {
                paramArrayList = paramArrayList + "::3";
                continue;
                if (TextUtils.isEmpty(paramArrayList)) {
                  paramArrayList = "4";
                } else {
                  paramArrayList = paramArrayList + "::4";
                }
              }
            }
          }
        }
      }
    }
    amxk.d("add_page", "all_result", "exp", 0, i, new String[] { "", paramArrayList, paramString, "" });
    return i;
  }
  
  public static int c(List<ampx> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 2;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ampx)paramList.next();
      if ((localObject instanceof amow))
      {
        localObject = (amow)localObject;
        if ((((amow)localObject).IW() == 1002) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((amow)localObject).getUin()))) {
          return 1;
        }
      }
    }
    return 2;
  }
  
  public static void dOA()
  {
    dDN = 0;
    av = null;
    sName = null;
    cco = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxg
 * JD-Core Version:    0.7.0.1
 */