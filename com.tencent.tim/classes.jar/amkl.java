import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lampw;>;

public class amkl
{
  public static long ajN;
  public static boolean cDb;
  public static boolean cDc;
  public static HashMap<ampx, amkl.a> mS = new HashMap();
  public static final HashMap<ampv, amkl.a> mT = new HashMap();
  protected static final HashMap<String, Integer> mU = new HashMap();
  
  public static void O(TextView paramTextView)
  {
    float f = paramTextView.getResources().getDimensionPixelSize(2131298819) / paramTextView.getResources().getDisplayMetrics().densityDpi * acej.k.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
  
  public static int a(ampv paramampv)
  {
    if (paramampv == null) {
      return -1;
    }
    if (mU.size() == 0)
    {
      mU.put(ampi.class.getSimpleName(), Integer.valueOf(101));
      mU.put(ampk.class.getSimpleName(), Integer.valueOf(101));
      mU.put(ampj.class.getSimpleName(), Integer.valueOf(101));
      mU.put(amnu.class.getSimpleName(), Integer.valueOf(102));
      mU.put(ampl.class.getSimpleName(), Integer.valueOf(102));
      mU.put(avju.class.getSimpleName(), Integer.valueOf(103));
      mU.put(agnx.class.getSimpleName(), Integer.valueOf(104));
      mU.put(amph.class.getSimpleName(), Integer.valueOf(105));
      mU.put(amrd.class.getSimpleName(), Integer.valueOf(106));
      mU.put(ampq.class.getSimpleName(), Integer.valueOf(107));
      mU.put(ampm.class.getSimpleName(), Integer.valueOf(108));
      mU.put(ampo.class.getSimpleName(), Integer.valueOf(109));
    }
    Integer localInteger = (Integer)mU.get(paramampv.getClass().getSimpleName());
    if (localInteger == null) {
      return -1;
    }
    if ((paramampv instanceof amrd))
    {
      if (((amrd)paramampv).blx == -1) {
        return localInteger.intValue();
      }
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static List<ampv> a(List<ampw> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static List<ampv> a(List<ampw> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null)
    {
      QLog.d("Q.uniteSearch.SearchUtil", 2, "getItemListFromGroupResult  result is null.");
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = new HashMap();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if ((localObject1 instanceof amov))
      {
        localObject4 = (amov)localObject1;
        localObject1 = (Integer)((HashMap)localObject3).get(Long.valueOf(((amov)localObject4).ajO));
        if (localObject1 == null) {}
        for (localObject1 = Integer.valueOf(1);; localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1))
        {
          ((HashMap)localObject3).put(Long.valueOf(((amov)localObject4).ajO), localObject1);
          break;
        }
      }
    }
    ((HashMap)localObject3).size();
    localObject2 = new ArrayList();
    ((List)localObject2).addAll(((HashMap)localObject3).keySet());
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    mS.clear();
    localObject1 = "";
    Iterator localIterator = paramList.iterator();
    paramList = (List<ampw>)localObject1;
    label271:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof amov)) {
        break label1031;
      }
      amov localamov = (amov)localObject1;
      if (!TextUtils.isEmpty(paramList)) {
        break label1028;
      }
      paramList = localamov.getKeyword();
      Object localObject5;
      if (paramBoolean3)
      {
        if (!paramBoolean1) {
          break label729;
        }
        if (amxk.cF(localamov.ajO))
        {
          ((List)localObject3).add(Long.valueOf(localamov.ajO));
          if (localamov.eX() != null)
          {
            i = 0;
            if (i < localamov.eX().size())
            {
              localObject5 = (ampx)localamov.eX().get(i);
              amkl.a locala = new amkl.a();
              locala.key = paramList;
              if ((localObject5 instanceof amqg))
              {
                locala.ajO = ((amqg)localObject5).ajO;
                label385:
                locala.index = (i + 1);
                locala.acL = false;
                localObject1 = "";
                if (!(localObject5 instanceof amow)) {
                  break label516;
                }
                localObject1 = ((amow)localObject5).id;
              }
              for (;;)
              {
                locala.caE = ((String)localObject1);
                locala.cDd = cDb;
                mS.put(localObject5, locala);
                if ((localObject5 instanceof amow)) {
                  ((amow)localObject5).cDH = localamov.cDH;
                }
                i += 1;
                break;
                if ((localObject5 instanceof amow))
                {
                  locala.ajO = ((amow)localObject5).IW();
                  break label385;
                }
                locala.ajO = localamov.ajO;
                break label385;
                label516:
                if ((localObject5 instanceof amqg)) {
                  localObject1 = ((amqg)localObject5).id;
                }
              }
            }
          }
        }
        else
        {
          cDc = cDb;
          ((List)localObject4).add(Long.valueOf(localamov.ajO));
        }
      }
      localObject1 = localamov.eX();
      if (((List)localObject1).size() > 0)
      {
        boolean bool1;
        label590:
        label610:
        label636:
        int j;
        if (!TextUtils.isEmpty(localamov.zf()))
        {
          bool1 = true;
          boolean bool2 = localamov.cDG;
          if (TextUtils.isEmpty(localamov.cbj)) {
            break label754;
          }
          paramBoolean2 = true;
          localObject5 = new ampf(localamov, bool1, bool2);
          if (localamov.cDF) {
            break label759;
          }
          bool1 = true;
          ((ampf)localObject5).setVisibility(bool1);
          localArrayList1.add(localObject5);
          j = ((List)localObject1).size();
          i = 0;
          label665:
          if (i >= j) {
            break label847;
          }
          localObject5 = (ampx)((List)localObject1).get(i);
          if (!(localObject5 instanceof amow)) {
            break label765;
          }
          localObject5 = (amow)localObject5;
          amxl.a((ampx)localObject5, j, i);
          localArrayList1.add(localObject5);
        }
        for (;;)
        {
          i += 1;
          break label665;
          label729:
          localArrayList2.add(Long.valueOf(localamov.ajO));
          break;
          bool1 = false;
          break label590;
          label754:
          paramBoolean2 = false;
          break label610;
          label759:
          bool1 = false;
          break label636;
          label765:
          if ((localObject5 instanceof amqg))
          {
            localObject5 = (amqg)localObject5;
            amxl.a((ampx)localObject5, j, i);
            localArrayList1.add(localObject5);
          }
          else if ((localObject5 instanceof amrd))
          {
            localArrayList1.add((amrd)localObject5);
          }
          else if ((localObject5 instanceof ampx))
          {
            localArrayList1.add(localObject5);
          }
        }
        label847:
        if (!TextUtils.isEmpty(localamov.cbj))
        {
          localObject1 = new ampg(localamov.cbj, localamov.cbk, localamov.ajO);
          ((ampg)localObject1).setVisibility(paramBoolean2);
          localArrayList1.add(localObject1);
        }
      }
    }
    label1028:
    label1031:
    for (;;)
    {
      break;
      if (((List)localObject4).size() > 0) {
        if (!cDc) {
          break label1022;
        }
      }
      label1022:
      for (i = 2;; i = 1)
      {
        amxk.e("all_result", "exp_content", i, 0, new String[] { paramList, amxk.N((List)localObject4), "", amxk.i("dynamic_unite_search.1", (List)localObject2) });
        if (localArrayList2.size() > 0) {
          amxk.b("all_result", "load_content", new String[] { paramList, amxk.N(localArrayList2), "", amxk.i("dynamic_unite_search.1", (List)localObject2) });
        }
        cDb = false;
        return localArrayList1;
      }
      break label271;
    }
  }
  
  public static List<Long> b(long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static long[] b(List<Long> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static void clearCache()
  {
    mS.clear();
    mT.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtil", 2, "clearCache");
    }
  }
  
  public static List<ampv> e(List<ampw> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false, true);
  }
  
  public static boolean gM(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = (aptw)((QQAppInterface)localObject).getManager(203);
      if ((localObject != null) && (((aptw)localObject).gM(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public static class a
  {
    public boolean acL;
    public long ajO;
    public boolean cDd;
    public String caE;
    public int index;
    public String key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkl
 * JD-Core Version:    0.7.0.1
 */