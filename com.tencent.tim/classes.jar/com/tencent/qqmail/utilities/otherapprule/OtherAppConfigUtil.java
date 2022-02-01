package com.tencent.qqmail.utilities.otherapprule;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.trd.guava.Joiner;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Splitter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OtherAppConfigUtil
{
  private static final String APP_NOT_NOTIFY_KEY = "app_not_notify";
  private static final String APP_NOT_TO_OPEN_FILE_KEY = "app_not_to_open_file";
  private static final String LINE_SEP = "\n";
  private static final String OTHER_APP_CONFIG_SP_NAME = "other_app_config";
  private static final String TAG = "OtherAppConfigUtil";
  
  public static List<ResolveInfo> filterResolveInfos(List<ResolveInfo> paramList, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localArrayList2 = getAppNotToOpenFile();
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        paramList = paramList.iterator();
      }
    }
    label187:
    for (;;)
    {
      ResolveInfo localResolveInfo;
      int i;
      if (paramList.hasNext())
      {
        localResolveInfo = (ResolveInfo)paramList.next();
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          AppNotToOpenFile localAppNotToOpenFile = (AppNotToOpenFile)localIterator.next();
          if (localResolveInfo.activityInfo.packageName.equals(localAppNotToOpenFile.getPackageName()))
          {
            localIterator = localAppNotToOpenFile.getAllowMimeList().iterator();
            while (localIterator.hasNext()) {
              if (((String)localIterator.next()).equals(paramString)) {
                i = 0;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label187;
        }
        localArrayList1.add(localResolveInfo);
        break;
        localArrayList1.addAll(paramList);
        return localArrayList1;
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  private static ArrayList<AppNotToOpenFile> getAppNotToOpenFile()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = QMApplicationContext.sharedInstance().getSharedPreferences("other_app_config", 0).getString("app_not_to_open_file", "");
    if (!StringExtention.isNullOrEmpty((String)localObject))
    {
      localObject = Lists.newArrayList(Splitter.on("\n").trimResults().omitEmptyStrings().split((String)localObject));
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",", -1);
          if (arrayOfString.length == 2)
          {
            AppNotToOpenFile localAppNotToOpenFile = new AppNotToOpenFile();
            localAppNotToOpenFile.setPackageName(arrayOfString[0]);
            ArrayList localArrayList2 = new ArrayList();
            if (!StringExtention.isNullOrEmpty(arrayOfString[1]))
            {
              arrayOfString = arrayOfString[1].split(";");
              if (arrayOfString.length > 0)
              {
                int i = 0;
                while (i < arrayOfString.length)
                {
                  localArrayList2.add(IntentUtil.getMIMEType("." + arrayOfString[i]));
                  i += 1;
                }
              }
            }
            localAppNotToOpenFile.setAllowMimeList(localArrayList2);
            localArrayList1.add(localAppNotToOpenFile);
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public static void saveAppNotNotify(ArrayList<AppNotNotify> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(((AppNotNotify)paramArrayList.next()).toString());
      }
      paramArrayList = Joiner.on("\n").skipNulls().join(localArrayList);
      QMLog.log(4, "OtherAppConfigUtil", "save AppNotNotify:" + paramArrayList);
      QMApplicationContext.sharedInstance().getSharedPreferences("other_app_config", 0).edit().putString("app_not_notify", paramArrayList).commit();
    }
  }
  
  public static void saveAppNotToOpenFile(ArrayList<AppNotToOpenFile> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(((AppNotToOpenFile)paramArrayList.next()).toString());
      }
      paramArrayList = Joiner.on("\n").skipNulls().join(localArrayList);
      QMLog.log(4, "OtherAppConfigUtil", "save AppNotToOpenFile:" + paramArrayList);
      QMApplicationContext.sharedInstance().getSharedPreferences("other_app_config", 0).edit().putString("app_not_to_open_file", paramArrayList).commit();
    }
  }
  
  public static boolean shouldNotifyOtherApps()
  {
    Object localObject2 = QMApplicationContext.sharedInstance().getSharedPreferences("other_app_config", 0).getString("app_not_notify", "");
    if (!StringExtention.isNullOrEmpty((String)localObject2))
    {
      Object localObject1 = new ArrayList();
      localObject2 = Lists.newArrayList(Splitter.on("\n").trimResults().omitEmptyStrings().split((String)localObject2));
      Object localObject3;
      Object localObject4;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((String)((Iterator)localObject2).next()).split(",", -1);
          if (localObject3.length == 2)
          {
            localObject4 = new AppNotNotify();
            ((AppNotNotify)localObject4).setPackageName(localObject3[0]);
            ((AppNotNotify)localObject4).setPackageVersion(localObject3[1]);
            ((ArrayList)localObject1).add(localObject4);
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (AppNotNotify)((Iterator)localObject1).next();
          localObject2 = ((AppNotNotify)localObject4).getPackageVersion();
          localObject3 = ((AppNotNotify)localObject4).getPackageName();
          if ((!StringExtention.isNullOrEmpty((String)localObject3)) && (!StringExtention.isNullOrEmpty((String)localObject2))) {
            try
            {
              localObject4 = QMApplicationContext.sharedInstance().getPackageManager().getPackageInfo(((AppNotNotify)localObject4).getPackageName(), 0);
              if (localObject4 != null)
              {
                localObject4 = ((PackageInfo)localObject4).versionName;
                if ((!StringExtention.isNullOrEmpty((String)localObject4)) && (!QMPushConfigUtil.compareVersion((String)localObject2, (String)localObject4, false)))
                {
                  QMLog.log(4, "OtherAppConfigUtil", "app install,name:" + (String)localObject3 + ",version" + (String)localObject4);
                  return false;
                }
              }
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.otherapprule.OtherAppConfigUtil
 * JD-Core Version:    0.7.0.1
 */