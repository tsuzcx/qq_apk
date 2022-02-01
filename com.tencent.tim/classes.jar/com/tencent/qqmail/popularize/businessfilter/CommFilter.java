package com.tencent.qqmail.popularize.businessfilter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class CommFilter
  implements PopularizeFilter
{
  private static final String SHARED_PREF_POPULARIZE_FILE = "popularize_info";
  private static final String TAG = "CommFilter";
  private static final HashMap<Integer, Integer> isShownMap = new HashMap();
  private static HashMap<Integer, Integer> showTypeOneDayMap = null;
  private final boolean isRender;
  
  public CommFilter()
  {
    this(true);
  }
  
  public CommFilter(boolean paramBoolean)
  {
    this.isRender = paramBoolean;
  }
  
  private ArrayList<Popularize> filterProductId(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Popularize localPopularize = (Popularize)paramArrayList.next();
      int i = localPopularize.getProductId();
      if (i > 0)
      {
        Integer localInteger = (Integer)isShownMap.get(Integer.valueOf(i));
        if (localInteger == null)
        {
          localArrayList.add(localPopularize);
          isShownMap.put(Integer.valueOf(i), Integer.valueOf(localPopularize.getId()));
        }
        else if (localInteger.intValue() == localPopularize.getId())
        {
          localArrayList.add(localPopularize);
        }
      }
      else
      {
        localArrayList.add(localPopularize);
      }
    }
    return localArrayList;
  }
  
  private static boolean filterWithShowType(Popularize paramPopularize)
  {
    switch (paramPopularize.getShowType())
    {
    default: 
      return false;
    case 0: 
      return paramPopularize.isRender();
    case 1: 
      return paramPopularize.isClick();
    case 2: 
      return paramPopularize.isCancel();
    case 3: 
      return false;
    case 4: 
      return false;
    case 5: 
      return false;
    case 6: 
      if (showTypeOneDayMap == null) {
        showTypeOneDayMap = new HashMap();
      }
      Object localObject = new GregorianCalendar();
      int i = ((GregorianCalendar)localObject).get(1) * 10000 + (((GregorianCalendar)localObject).get(2) + 1) * 100 + ((GregorianCalendar)localObject).get(5);
      localObject = (Integer)showTypeOneDayMap.get(Integer.valueOf(paramPopularize.getId()));
      if ((localObject == null) || (i - ((Integer)localObject).intValue() > 0))
      {
        showTypeOneDayMap.put(Integer.valueOf(paramPopularize.getId()), Integer.valueOf(i));
        return false;
      }
      return true;
    }
    return false;
  }
  
  private static int getTurnIdFromSharedPref(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("popularize_info", 0).getInt(String.format("turnId_%d", new Object[] { Integer.valueOf(paramInt) }), -1);
  }
  
  private static long getTurnIdTimeFromSharedPref(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("popularize_info", 0).getLong(String.format("turnId_time_%d", new Object[] { Integer.valueOf(paramInt) }), 0L);
  }
  
  private static void setTurnIdTimeToSharedPref(Context paramContext, int paramInt, long paramLong)
  {
    paramContext.getSharedPreferences("popularize_info", 0).edit().putLong(String.format("turnId_time_%d", new Object[] { Integer.valueOf(paramInt) }), paramLong).apply();
  }
  
  private static void setTurnIdToSharedPref(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext.getSharedPreferences("popularize_info", 0).edit().putInt(String.format("turnId_%d", new Object[] { Integer.valueOf(paramInt1) }), paramInt2).apply();
  }
  
  private void turn5dayFilter(ArrayList<Popularize> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Object localObject3 = paramArrayList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Popularize localPopularize = (Popularize)((Iterator)localObject3).next();
      if (localPopularize.getTurnId() > 10000)
      {
        localObject2 = (ArrayList)localHashMap.get(Integer.valueOf(localPopularize.getTurnId()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          localHashMap.put(Integer.valueOf(localPopularize.getTurnId()), localObject1);
        }
        ((ArrayList)localObject1).add(localPopularize);
        Log.v("CommFilter", "turn5dayFilter: " + localPopularize);
      }
    }
    long l2 = System.currentTimeMillis();
    Object localObject1 = QMApplicationContext.sharedInstance();
    Object localObject2 = localHashMap.keySet().iterator();
    int j;
    int i;
    long l1;
    while (((Iterator)localObject2).hasNext())
    {
      j = ((Integer)((Iterator)localObject2).next()).intValue();
      localObject3 = (ArrayList)localHashMap.get(Integer.valueOf(j));
      if (((ArrayList)localObject3).size() < 2)
      {
        QMLog.log(5, "CommFilter", String.format("turn5dayFilter config error turnId[%d], size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(((ArrayList)localObject3).size()) }));
      }
      else
      {
        Collections.sort((List)localObject3, new CommFilter.3(this));
        i = getTurnIdFromSharedPref((Context)localObject1, j);
        l1 = getTurnIdTimeFromSharedPref((Context)localObject1, j);
        if ((i >= 0) && ((l1 <= 0L) || (l2 - l1 < 432000000L))) {
          break label404;
        }
        i = (i + 1) % ((ArrayList)localObject3).size();
        setTurnIdToSharedPref((Context)localObject1, j, i);
        setTurnIdTimeToSharedPref((Context)localObject1, j, 0L);
        l1 = 0L;
      }
    }
    label404:
    for (;;)
    {
      if ((l1 == 0L) && (((Popularize)((ArrayList)localObject3).get(i)).isClick())) {
        setTurnIdTimeToSharedPref((Context)localObject1, j, l2);
      }
      j = 0;
      while (j < ((ArrayList)localObject3).size())
      {
        if (j != i)
        {
          PopularizeManager.sharedInstance().updatePopularizeClick(((Popularize)((ArrayList)localObject3).get(0)).getId(), false);
          paramArrayList.remove(((ArrayList)localObject3).get(j));
        }
        j += 1;
      }
      break;
      return;
    }
  }
  
  private void turnWorkDayFilter(ArrayList<Popularize> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Object localObject3 = paramArrayList.iterator();
    Object localObject4;
    Object localObject2;
    Object localObject1;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Popularize)((Iterator)localObject3).next();
      if ((((Popularize)localObject4).getTurnId() > 0) && (((Popularize)localObject4).getTurnId() <= 10000))
      {
        localObject2 = (ArrayList)localHashMap.get(Integer.valueOf(((Popularize)localObject4).getTurnId()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          localHashMap.put(Integer.valueOf(((Popularize)localObject4).getTurnId()), localObject1);
        }
        ((ArrayList)localObject1).add(localObject4);
        Log.v("CommFilter", "turnWorkDayFilter: " + localObject4);
      }
    }
    int i = new GregorianCalendar().get(7);
    if ((i != 1) && (i != 7)) {}
    for (i = 1;; i = 0)
    {
      localObject4 = localHashMap.keySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext()) {
          return;
        }
        int j = ((Integer)((Iterator)localObject4).next()).intValue();
        localObject1 = (ArrayList)localHashMap.get(Integer.valueOf(j));
        if (((ArrayList)localObject1).size() == 2) {
          break;
        }
        QMLog.log(5, "CommFilter", String.format("turnWorkDayFilter config error turnId[%d], size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(((ArrayList)localObject1).size()) }));
      }
    }
    if (((Popularize)((ArrayList)localObject1).get(0)).getWeight() >= ((Popularize)((ArrayList)localObject1).get(1)).getWeight())
    {
      localObject2 = (Popularize)((ArrayList)localObject1).get(0);
      localObject1 = (Popularize)((ArrayList)localObject1).get(1);
      label321:
      PopularizeManager localPopularizeManager = PopularizeManager.sharedInstance();
      if (i == 0) {
        break label384;
      }
      localObject3 = localObject1;
      label334:
      localPopularizeManager.updatePopularizeClick(((Popularize)localObject3).getId(), false);
      if (i == 0) {
        break label391;
      }
    }
    for (;;)
    {
      paramArrayList.remove(localObject1);
      break;
      localObject2 = (Popularize)((ArrayList)localObject1).get(1);
      localObject1 = (Popularize)((ArrayList)localObject1).get(0);
      break label321;
      label384:
      localObject3 = localObject2;
      break label334;
      label391:
      localObject1 = localObject2;
    }
  }
  
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis() / 1000L;
    paramArrayList = paramArrayList.iterator();
    Popularize localPopularize;
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        localPopularize = (Popularize)paramArrayList.next();
        if ((localPopularize.getStartTime() > l) || (l > localPopularize.getEndTime())) {
          QMLog.log(4, "CommFilter", "renderPopularizeView not in time, svrId:" + localPopularize.getServerId());
        } else if (filterWithShowType(localPopularize)) {
          QMLog.log(4, "CommFilter", "renderPopularizeView filterWithShowType, svrId:" + localPopularize.getServerId());
        } else if ((!localPopularize.isRender()) && (localPopularize.isNeedWifi()) && (!QMNetworkUtils.isWifiConnected())) {
          QMLog.log(4, "CommFilter", "renderPopularizeView need wifi but without" + localPopularize.getReportId());
        } else {
          if (StringUtils.isBlank(localPopularize.getPopularizeAppName())) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = QMApplicationContext.sharedInstance().getPackageManager().getPackageInfo(localPopularize.getPopularizeAppName(), 0);
        if (localObject == null) {
          break label480;
        }
        boolean bool = StringExtention.isNullOrEmpty(localPopularize.getPopularizeAppVersion());
        if (bool)
        {
          i = 1;
          if ((i == 0) || (localPopularize.getAppInstallAction() != 1)) {
            continue;
          }
          QMLog.log(4, "CommFilter", "renderPopularizeView app install cancel" + localPopularize.getSubject());
          break;
        }
        localObject = ((PackageInfo)localObject).versionName;
        if ((StringExtention.isNullOrEmpty((String)localObject)) || (QMPushConfigUtil.compareVersion(localPopularize.getPopularizeAppVersion(), (String)localObject, false))) {
          break label480;
        }
        QMLog.log(4, "CommFilter", "app install,name:" + localPopularize.getPopularizeAppName() + ",version" + (String)localObject);
        i = 1;
        continue;
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
        if ((i == 0) && (localPopularize.getAppInstallAction() == 3)) {
          QMLog.log(4, "CommFilter", "renderPopularizeView app uninstall cancel" + localPopularize.getSubject());
        }
      }
      localArrayList.add(localPopularize);
      break;
      turnWorkDayFilter(localArrayList);
      turn5dayFilter(localArrayList);
      paramArrayList = filterProductId(localArrayList);
      if (this.isRender)
      {
        Threads.runInBackground(new CommFilter.1(this, paramArrayList));
        Threads.runInBackground(new CommFilter.2(this, paramArrayList));
      }
      return paramArrayList;
      label480:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.CommFilter
 * JD-Core Version:    0.7.0.1
 */