package com.tencent.qqmail.accountlist;

import android.content.res.Resources;
import android.util.Base64;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTask.QMTaskState;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.FolderListItemFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QMAccountHelper
{
  private static final String SHOW_HIDE_TIPS = "show_hide_tips";
  private static final String TAG = "QMAccountHelper";
  
  public static void addActiveFolderToDB(QMFolder paramQMFolder, AccountList paramAccountList)
  {
    if ((paramQMFolder != null) && (paramAccountList != null) && (paramAccountList.size() != 0))
    {
      paramQMFolder = FolderDataManager.generateUnOrderFolderData(paramQMFolder.getAccountId(), paramQMFolder.getId(), paramQMFolder.getName(), 0, 0, true, false);
      paramAccountList = getUniversalFolders(paramAccountList);
      paramQMFolder.setSequence(((FolderData)paramAccountList.get(paramAccountList.size() - 1)).getSequence() + 1);
      FolderDataManager.sharedInstance().insertFolderData(paramQMFolder);
    }
  }
  
  private static void addSingleInboxBehindInboxes(ArrayList<FolderData> paramArrayList, int paramInt, QMFolder paramQMFolder)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if (((FolderData)paramArrayList.get(i)).getFolderId() == -1)
        {
          paramQMFolder = FolderDataManager.generateFolderData(paramInt, paramQMFolder.getId(), QMApplicationContext.sharedInstance().getString(2131693913), 0, i + 1, 2, true, true, false);
          paramArrayList.add(i + 1, paramQMFolder);
          QMLog.log(4, "QMAccountHelper", "first add single inbox:" + paramQMFolder.getFolderId() + ",seq:" + (i + 1));
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public static String calcGmailAccessToken(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user=" + paramString1).append('\001').append("auth=Bearer " + paramString2).append('\001').append('\001');
    return Base64.encodeToString(localStringBuilder.toString().getBytes("UTF-8"), 2);
  }
  
  private static FolderData generateDefaultApp(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (int i = 1;; i = 2) {
      return FolderDataManager.generateUnOrderFolderData(-1, paramInt, paramString, i, 0, paramBoolean2, true);
    }
  }
  
  public static ArrayList<FolderData> getDefaultInboxFolder(AccountList paramAccountList)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((paramAccountList == null) || (paramAccountList.size() == 0))
    {
      QMLog.log(6, "QMAccountHelper", "accList null");
      return localArrayList1;
    }
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    paramAccountList = paramAccountList.iterator();
    while (paramAccountList.hasNext())
    {
      Account localAccount = (Account)paramAccountList.next();
      i = QMFolderManager.sharedInstance().getInboxFolderId(localAccount.getId());
      QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(i);
      if (localQMFolder != null)
      {
        String str = localAccount.getEmail().split("@")[1].split("\\.")[0];
        if (localHashMap.containsKey(str)) {
          localHashMap.put(str, Integer.valueOf(2));
        }
        for (;;)
        {
          localArrayList2.add(localAccount);
          localArrayList3.add(str);
          localArrayList4.add(localQMFolder);
          break;
          localHashMap.put(str, Integer.valueOf(1));
        }
      }
    }
    int i = 0;
    if (i < localArrayList3.size())
    {
      if (((Integer)localHashMap.get(localArrayList3.get(i))).intValue() == 1)
      {
        paramAccountList = (String)localArrayList3.get(i);
        if ("qq".equalsIgnoreCase(paramAccountList)) {
          paramAccountList = "QQ" + QMApplicationContext.sharedInstance().getResources().getString(2131694793);
        }
      }
      for (;;)
      {
        localArrayList1.add(FolderDataManager.generateUnOrderFolderData(((Account)localArrayList2.get(i)).getId(), ((QMFolder)localArrayList4.get(i)).getId(), paramAccountList, 0, 3, true, true));
        i += 1;
        break;
        paramAccountList = new StringBuilder().append("").append(paramAccountList.charAt(0)).toString().toUpperCase() + paramAccountList.substring(1) + QMApplicationContext.sharedInstance().getResources().getString(2131694793);
        continue;
        paramAccountList = ((Account)localArrayList2.get(i)).getName() + QMApplicationContext.sharedInstance().getResources().getString(2131694793);
      }
    }
    return localArrayList1;
  }
  
  private static List<FolderData> getDefaultUniversalFolder()
  {
    ArrayList localArrayList = new ArrayList();
    FolderData localFolderData1 = FolderDataManager.generateUnOrderFolderData(-1, -1, getString(2131693934), 0, 0, true, true);
    FolderData localFolderData2 = FolderDataManager.generateUnOrderFolderData(-1, -3, getString(2131695181), 0, 0, true, true);
    FolderData localFolderData3 = FolderDataManager.generateUnOrderFolderData(-1, -2, getString(2131693937), 0, 0, true, true);
    FolderData localFolderData4 = FolderDataManager.generateUnOrderFolderData(-1, -9, getString(2131693939), 0, 0, false, true);
    FolderData localFolderData5 = FolderDataManager.generateUnOrderFolderData(-1, -14, getString(2131693935), 0, 0, false, true);
    FolderData localFolderData6 = FolderDataManager.generateUnOrderFolderData(-1, -19, getString(2131693940), 0, 0, false, true);
    FolderData localFolderData7 = FolderDataManager.generateUnOrderFolderData(-1, -11, getString(2131693933), 0, 0, false, true);
    FolderData localFolderData8 = FolderDataManager.generateUnOrderFolderData(-1, -13, getString(2131693936), 0, 0, false, true);
    FolderData localFolderData9 = FolderDataManager.generateUnOrderFolderData(-1, -12, getString(2131693938), 0, 0, false, true);
    localArrayList.add(localFolderData1);
    localArrayList.add(localFolderData2);
    localArrayList.add(localFolderData3);
    localArrayList.add(localFolderData4);
    localArrayList.add(localFolderData5);
    localArrayList.add(localFolderData6);
    localArrayList.add(localFolderData7);
    localArrayList.add(localFolderData8);
    localArrayList.add(localFolderData9);
    return localArrayList;
  }
  
  public static ArrayList<FolderData> getHomeAppFolders()
  {
    System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = FolderDataManager.getHomeAppCheckIdList();
    ArrayList localArrayList2 = FolderDataManager.getHomeAppIdList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator1;
    label72:
    if (!ChannelDefine.isGooglePlay())
    {
      localObject1 = PopularizeManager.sharedInstance().getPopularize(new FolderListItemFilter(1, 1));
      if ((localArrayList2 == null) || (localArrayList2.size() <= 0)) {
        break label470;
      }
      localIterator1 = localArrayList2.iterator();
    }
    for (;;)
    {
      int i;
      if (localIterator1.hasNext())
      {
        i = ((Integer)localIterator1.next()).intValue();
        if (((ArrayList)localObject2).indexOf(Integer.valueOf(i)) != -1) {
          break label209;
        }
      }
      label209:
      for (boolean bool = true;; bool = false)
      {
        if (i != 0) {
          break label214;
        }
        if (((ArrayList)localObject1).size() <= 0) {
          break label381;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Popularize)((Iterator)localObject1).next();
          localObject2 = PopularizeManager.sharedInstance().generatePopularizeFolder((Popularize)localObject2);
          localArrayList1.add(FolderDataManager.generateUnOrderFolderData(-1, ((QMFolder)localObject2).getId(), ((QMFolder)localObject2).getName(), 1, 1, true, true));
          localArrayList3.add(Integer.valueOf(((QMFolder)localObject2).getId()));
        }
        localObject1 = new ArrayList();
        break;
      }
      label214:
      if (i < 0)
      {
        localArrayList3.add(Integer.valueOf(i));
        switch (i)
        {
        default: 
          localArrayList3.remove(Integer.valueOf(i));
          break;
        case -22: 
          if (!QMSettingManager.sharedInstance().getContactDisplay()) {
            continue;
          }
          localArrayList1.add(generateDefaultApp(-22, getString(2131692063), true, bool));
          break;
        }
      }
      else
      {
        Iterator localIterator2 = ((ArrayList)localObject1).iterator();
        if (localIterator2.hasNext())
        {
          Object localObject3 = (Popularize)localIterator2.next();
          if (((Popularize)localObject3).getId() != i) {
            break label72;
          }
          localArrayList3.add(Integer.valueOf(i));
          localObject3 = PopularizeManager.sharedInstance().generatePopularizeFolder((Popularize)localObject3);
          localArrayList1.add(FolderDataManager.generateUnOrderFolderData(-1, ((QMFolder)localObject3).getId(), ((QMFolder)localObject3).getName(), 1, 1, bool, true));
          localIterator2.remove();
        }
      }
    }
    label381:
    Object localObject1 = getInnerAppFolders(localArrayList3);
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      if (localArrayList1.size() <= 0) {
        break label460;
      }
      localObject1 = getString(2131693943);
      localObject1 = FolderDataManager.generateUnOrderFolderData(-1, -20, (String)localObject1, 1, 4, true, true);
      localArrayList1.add(localObject1);
      localArrayList3.add(Integer.valueOf(((FolderData)localObject1).getFolderId()));
    }
    label460:
    label470:
    do
    {
      if (!localArrayList3.equals(localArrayList2)) {
        FolderDataManager.setHomeAppIdList(localArrayList3);
      }
      return localArrayList1;
      localObject1 = getString(2131693944);
      break;
      if (QMSettingManager.sharedInstance().getContactDisplay())
      {
        localArrayList1.add(generateDefaultApp(-22, getString(2131692063), true, true));
        localArrayList3.add(Integer.valueOf(-22));
      }
      if ((QMSettingManager.sharedInstance().getCardDisplay()) && (!ChannelDefine.isGooglePlay()))
      {
        localArrayList1.add(generateDefaultApp(-23, getString(2131691269), true, true));
        localArrayList3.add(Integer.valueOf(-23));
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Popularize)((Iterator)localObject1).next();
          localObject2 = PopularizeManager.sharedInstance().generatePopularizeFolder((Popularize)localObject2);
          localArrayList1.add(FolderDataManager.generateUnOrderFolderData(-1, ((QMFolder)localObject2).getId(), ((QMFolder)localObject2).getName(), 1, 1, true, true));
          localArrayList3.add(Integer.valueOf(((QMFolder)localObject2).getId()));
        }
      }
      localObject1 = getInnerAppFolders(localArrayList3);
    } while ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0));
    if (localArrayList1.size() > 0) {}
    for (localObject1 = getString(2131693943);; localObject1 = getString(2131693944))
    {
      localObject1 = FolderDataManager.generateUnOrderFolderData(-1, -20, (String)localObject1, 1, 4, true, true);
      localArrayList1.add(localObject1);
      localArrayList3.add(Integer.valueOf(((FolderData)localObject1).getFolderId()));
      break;
    }
  }
  
  public static ArrayList<FolderData> getInnerAppFolders(ArrayList<Integer> paramArrayList)
  {
    System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = FolderDataManager.getInnerAppIdList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = paramArrayList;
    if (paramArrayList == null) {
      localObject1 = new ArrayList();
    }
    if (((ArrayList)localObject1).indexOf(Integer.valueOf(-22)) == -1)
    {
      localArrayList3.add(Integer.valueOf(-22));
      if (QMSettingManager.sharedInstance().getContactDisplay()) {
        localArrayList1.add(generateDefaultApp(-22, getString(2131692063), false, false));
      }
    }
    new ArrayList();
    if (!ChannelDefine.isGooglePlay()) {}
    for (paramArrayList = PopularizeManager.sharedInstance().getPopularize(new FolderListItemFilter(2, 1)); (localArrayList2 != null) && (localArrayList2.size() > 0); paramArrayList = new ArrayList())
    {
      localObject1 = localArrayList2.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label267;
        }
        int i = ((Integer)((Iterator)localObject1).next()).intValue();
        if (i > 0)
        {
          Iterator localIterator = paramArrayList.iterator();
          if (localIterator.hasNext())
          {
            Object localObject2 = (Popularize)localIterator.next();
            if (((Popularize)localObject2).getId() != i) {
              break;
            }
            localArrayList3.add(Integer.valueOf(i));
            localObject2 = PopularizeManager.sharedInstance().generatePopularizeFolder((Popularize)localObject2);
            localArrayList1.add(FolderDataManager.generateUnOrderFolderData(-1, ((QMFolder)localObject2).getId(), ((QMFolder)localObject2).getName(), 2, 1, false, true));
            localIterator.remove();
          }
        }
      }
    }
    label267:
    if (paramArrayList.size() > 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (Popularize)paramArrayList.next();
        localObject1 = PopularizeManager.sharedInstance().generatePopularizeFolder((Popularize)localObject1);
        localArrayList1.add(FolderDataManager.generateUnOrderFolderData(-1, ((QMFolder)localObject1).getId(), ((QMFolder)localObject1).getName(), 2, 1, false, true));
        localArrayList3.add(Integer.valueOf(((QMFolder)localObject1).getId()));
      }
    }
    if (!localArrayList3.equals(localArrayList2))
    {
      FolderDataManager.sharedInstance();
      FolderDataManager.setInnerAppIdList(localArrayList3);
    }
    return localArrayList1;
  }
  
  private static String getString(int paramInt)
  {
    return QMApplicationContext.sharedInstance().getString(paramInt);
  }
  
  public static ArrayList<FolderData> getUniversalFolders(AccountList paramAccountList)
  {
    if ((paramAccountList != null) && (paramAccountList.size() > 1)) {}
    for (int i = 1;; i = 0)
    {
      ArrayList localArrayList = new ArrayList();
      boolean bool1 = readUniversalFolderFromDB(localArrayList);
      Object localObject1 = getDefaultUniversalFolder().iterator();
      Object localObject2;
      Iterator localIterator;
      FolderData localFolderData;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FolderData)((Iterator)localObject1).next();
        localIterator = localArrayList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localFolderData = (FolderData)localIterator.next();
        } while ((((FolderData)localObject2).getAccountId() != localFolderData.getAccountId()) || (((FolderData)localObject2).getFolderId() != localFolderData.getFolderId()));
      }
      for (int j = 0;; j = 1)
      {
        if (j != 0)
        {
          localArrayList.add(localObject2);
          bool1 = true;
        }
        for (;;)
        {
          break;
          if (i != 0) {
            localObject1 = localArrayList.iterator();
          }
          label547:
          label968:
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (FolderData)((Iterator)localObject1).next();
              if (((FolderData)localObject2).getType() == 3)
              {
                localIterator = paramAccountList.iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                } while (((Account)localIterator.next()).getId() != ((FolderData)localObject2).getAccountId());
              }
            }
            else
            {
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label968;
                }
                ((Iterator)localObject1).remove();
                break;
                localObject1 = getDefaultInboxFolder(paramAccountList);
                paramAccountList = QMApplicationContext.sharedInstance().getString(2131693913);
                localObject1 = ((List)localObject1).iterator();
                boolean bool2 = bool1;
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (FolderData)((Iterator)localObject1).next();
                  localIterator = localArrayList.iterator();
                  do
                  {
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localFolderData = (FolderData)localIterator.next();
                  } while ((((FolderData)localObject2).getAccountId() != localFolderData.getAccountId()) || (((FolderData)localObject2).getFolderId() != localFolderData.getFolderId()));
                }
                for (i = 0;; i = 1)
                {
                  if (i != 0)
                  {
                    i = 0;
                    while (i < localArrayList.size()) {
                      if ((((FolderData)localArrayList.get(i)).getFolderId() == -1) || ((((FolderData)localArrayList.get(i)).getName() != null) && (((FolderData)localArrayList.get(i)).getName().contains(paramAccountList))))
                      {
                        i += 1;
                      }
                      else
                      {
                        ((FolderData)localObject2).setSequence(i);
                        localArrayList.add(i, localObject2);
                      }
                    }
                    if (i == localArrayList.size())
                    {
                      ((FolderData)localObject2).setSequence(i);
                      localArrayList.add(localObject2);
                    }
                    bool1 = true;
                    break;
                  }
                  i = 0;
                  for (;;)
                  {
                    if (i >= localArrayList.size()) {
                      break label547;
                    }
                    if ((((FolderData)localArrayList.get(i)).getAccountId() == ((FolderData)localObject2).getAccountId()) && (((FolderData)localArrayList.get(i)).getFolderId() == ((FolderData)localObject2).getFolderId()))
                    {
                      if (((FolderData)localArrayList.get(i)).getName().equals(((FolderData)localObject2).getName())) {
                        break;
                      }
                      ((FolderData)localObject2).setSequence(i);
                      localArrayList.set(i, localObject2);
                      break;
                    }
                    i += 1;
                  }
                  break;
                  bool2 = bool1;
                  if (paramAccountList != null)
                  {
                    bool2 = bool1;
                    if (paramAccountList.size() == 1)
                    {
                      i = paramAccountList.get(0).getId();
                      paramAccountList = null;
                      localObject2 = localArrayList.iterator();
                      if (((Iterator)localObject2).hasNext())
                      {
                        localObject1 = (FolderData)((Iterator)localObject2).next();
                        if (((FolderData)localObject1).getType() == 3)
                        {
                          ((Iterator)localObject2).remove();
                          bool1 = true;
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    break;
                    if ((((FolderData)localObject1).getType() == 2) && (((FolderData)localObject1).getAccountId() != i))
                    {
                      ((Iterator)localObject2).remove();
                      bool1 = true;
                    }
                    else if ((((FolderData)localObject1).getType() == 2) && (((FolderData)localObject1).getAccountId() == i))
                    {
                      QMLog.log(4, "QMAccountHelper", "single inbox has exist:" + ((FolderData)localObject1).getFolderId() + ",show:" + ((FolderData)localObject1).isShouldShow());
                      paramAccountList = (AccountList)localObject1;
                      continue;
                      if (paramAccountList == null)
                      {
                        paramAccountList = QMFolderManager.sharedInstance().getFoldersByAccountId(i).iterator();
                        while (paramAccountList.hasNext())
                        {
                          localObject1 = (QMFolder)paramAccountList.next();
                          if (((QMFolder)localObject1).getType() == 1)
                          {
                            QMLog.log(4, "QMAccountHelper", "single inbox folder:" + ((QMFolder)localObject1).getId());
                            addSingleInboxBehindInboxes(localArrayList, i, (QMFolder)localObject1);
                          }
                        }
                      }
                      for (bool2 = true;; bool2 = bool1)
                      {
                        bool1 = bool2;
                        if (localArrayList.size() > 0)
                        {
                          bool1 = bool2 | FolderDataManager.setSeqByFolderDataListOrder(localArrayList);
                          paramAccountList = new StringBuilder();
                          localObject1 = localArrayList.iterator();
                          while (((Iterator)localObject1).hasNext())
                          {
                            localObject2 = (FolderData)((Iterator)localObject1).next();
                            paramAccountList.append(((FolderData)localObject2).getName()).append(",show:").append(((FolderData)localObject2).isShouldShow()).append(" ");
                          }
                          QMLog.log(4, "QMAccountHelper", "get universal folders:" + paramAccountList.toString());
                        }
                        if (bool1)
                        {
                          FolderDataManager.sharedInstance().deleteFolderDataList();
                          FolderDataManager.sharedInstance().insertFolderDataList(localArrayList);
                        }
                        return localArrayList;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static ArrayList<FolderData> readActiveFolderFromDB()
  {
    return FolderDataManager.sharedInstance().getActiveFolderDataList();
  }
  
  public static boolean readAppFolderFomDB(ArrayList<FolderData> paramArrayList, boolean paramBoolean)
  {
    Object localObject = FolderDataManager.sharedInstance();
    int i;
    if (paramBoolean)
    {
      i = 1;
      localObject = ((FolderDataManager)localObject).getFolderDataListBySection(i);
      if (paramArrayList == null) {
        break label207;
      }
      paramArrayList.clear();
      label24:
      localObject = ((ArrayList)localObject).iterator();
      paramBoolean = false;
      label31:
      if (!((Iterator)localObject).hasNext()) {
        return paramBoolean;
      }
      FolderData localFolderData = (FolderData)((Iterator)localObject).next();
      if (localFolderData != null) {
        break label218;
      }
      i = 1;
      label58:
      if ((i == 0) && ((localFolderData.isPersistence()) || (localFolderData.isShouldShow()) || (localFolderData.isProcessing()))) {
        break label223;
      }
      i = 1;
      label88:
      if ((i == 0) && ((localFolderData.getFolderId() != -4) || (QMSettingManager.sharedInstance().getNoteDisplay()))) {
        break label228;
      }
      i = 1;
      label113:
      if ((i == 0) && ((localFolderData.getFolderId() != -5) || (QMSettingManager.sharedInstance().getFtnDisplay()))) {
        break label233;
      }
      i = 1;
      label138:
      if ((i == 0) && ((localFolderData.getFolderId() != -16) || (QMSettingManager.sharedInstance().isBottleEnabled()))) {
        break label238;
      }
      i = 1;
      label163:
      if ((i == 0) && ((localFolderData.getFolderId() != -18) || (QMSettingManager.sharedInstance().getCalendarDisplay()))) {
        break label243;
      }
      i = 1;
      label188:
      if (i != 0) {
        break label248;
      }
      paramArrayList.add(localFolderData);
    }
    for (;;)
    {
      break label31;
      i = 2;
      break;
      label207:
      paramArrayList = new ArrayList();
      break label24;
      label218:
      i = 0;
      break label58;
      label223:
      i = 0;
      break label88;
      label228:
      i = 0;
      break label113;
      label233:
      i = 0;
      break label138;
      label238:
      i = 0;
      break label163;
      label243:
      i = 0;
      break label188;
      label248:
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static boolean readUniversalFolderFromDB(ArrayList<FolderData> paramArrayList)
  {
    boolean bool2 = false;
    Object localObject = FolderDataManager.sharedInstance().getFolderDataListBySection(0);
    boolean bool1;
    label45:
    int i;
    if (paramArrayList != null)
    {
      paramArrayList.clear();
      bool1 = bool2;
      if (localObject == null) {
        return bool1;
      }
      bool1 = bool2;
      if (((ArrayList)localObject).size() <= 0) {
        return bool1;
      }
      localObject = ((ArrayList)localObject).iterator();
      bool1 = false;
      if (!((Iterator)localObject).hasNext()) {
        return bool1;
      }
      FolderData localFolderData = (FolderData)((Iterator)localObject).next();
      if ((localFolderData.isPersistence()) || (localFolderData.isShouldShow()) || (localFolderData.isProcessing())) {
        break label118;
      }
      i = 1;
      label93:
      if (i != 0) {
        break label123;
      }
      paramArrayList.add(localFolderData);
    }
    for (;;)
    {
      break label45;
      paramArrayList = new ArrayList();
      break;
      label118:
      i = 0;
      break label93;
      label123:
      bool1 = true;
    }
    return bool1;
  }
  
  public static List<AccountListUI> returnAllAccount()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    Object localObject2 = new ArrayList(localAccountList.size());
    Object localObject1 = localAccountList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add(FolderDataManager.generateAccountFolderData(((Account)((Iterator)localObject1).next()).getId()));
    }
    localObject1 = new ArrayList(((ArrayList)localObject2).size());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FolderData localFolderData = (FolderData)((Iterator)localObject2).next();
      Account localAccount = localAccountList.getAccountById(localFolderData.getAccountId());
      if (localAccount == null) {
        QMLog.log(6, "terrytan", "returnAllAccount Lists.transform input:" + localFolderData.getAccountId() + ":" + localFolderData.getFolderId() + ":" + localFolderData.getSection() + ":" + localFolderData.getName());
      } else {
        ((ArrayList)localObject1).add(new AccountListUI(localAccount, localFolderData));
      }
    }
    return localObject1;
  }
  
  public static List<AccountListUI> returnFoldersAndAccounts(AccountList paramAccountList, boolean paramBoolean)
  {
    System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramAccountList == null) || (paramAccountList.size() <= 0))
    {
      QMLog.log(6, "QMAccountHelper", "accList null or empty");
      return localArrayList;
    }
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i;
    if (paramAccountList.size() > 1) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Object localObject1 = getUniversalFolders(paramAccountList);
        paramAccountList = (AccountList)localObject1;
        Object localObject2;
        if (paramBoolean)
        {
          paramAccountList = new ArrayList();
          localObject1 = ((ArrayList)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (FolderData)((Iterator)localObject1).next();
              if (((FolderData)localObject2).isShouldShow())
              {
                paramAccountList.add(localObject2);
                continue;
                i = 0;
                break;
              }
            }
          }
        }
        localObject1 = paramAccountList.iterator();
        label171:
        Object localObject3;
        boolean bool;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FolderData)((Iterator)localObject1).next();
          if (((FolderData)localObject2).getAccountId() == -1)
          {
            paramAccountList = null;
            localObject3 = QMFolderManager.sharedInstance();
            i = ((FolderData)localObject2).getFolderId();
            if (((FolderData)localObject2).getFolderId() == -1) {
              break label274;
            }
            bool = true;
            label193:
            localObject3 = ((QMFolderManager)localObject3).getFolder(i, bool);
            if (localObject3 != null) {
              break label290;
            }
            localObject2 = new StringBuilder().append("returnFolders folder_null:").append(((FolderData)localObject2).getFolderId()).append(", ");
            if (paramAccountList != null) {
              break label279;
            }
          }
          label274:
          label279:
          for (paramAccountList = null;; paramAccountList = Integer.valueOf(paramAccountList.getId()))
          {
            QMLog.log(5, "QMAccountHelper", paramAccountList);
            break;
            paramAccountList = localAccountList.getAccountById(((FolderData)localObject2).getAccountId());
            break label171;
            bool = false;
            break label193;
          }
          label290:
          localArrayList.add(new AccountListUI(paramAccountList, (QMFolder)localObject3, ((FolderData)localObject2).getName(), (FolderData)localObject2));
        }
        if (!paramBoolean) {
          localArrayList.add(new AccountListUI(getString(2131689644), AccountListUI.ITEMTYPE.BTN));
        }
        paramAccountList = QMTaskManager.sharedInstance(1).getTaskList();
        if ((paramAccountList != null) && (paramAccountList.size() > 0))
        {
          localArrayList.add(new AccountListUI(getString(2131693946), AccountListUI.ITEMTYPE.SECTION));
          localObject1 = QMFolderManager.sharedInstance().getFolder(-10);
          localObject2 = FolderDataManager.generateFolderData(((QMFolder)localObject1).getAccountId(), ((QMFolder)localObject1).getId(), ((QMFolder)localObject1).getName(), 4, 0, 0, true, false, false);
          bool = false;
          i = 0;
          while (i < paramAccountList.size())
          {
            if (((QMSendMailTask)paramAccountList.get(i)).getTaskState() == QMTask.QMTaskState.QMTaskStateFail) {
              bool = true;
            }
            i += 1;
          }
          localArrayList.add(new AccountListUI(((QMFolder)localObject1).getName(), (QMFolder)localObject1, paramAccountList.size(), Boolean.valueOf(bool), (FolderData)localObject2));
        }
        paramAccountList = getHomeAppFolders();
        if ((paramAccountList != null) && (paramAccountList.size() > 0))
        {
          localArrayList.add(new AccountListUI(getString(2131690444), AccountListUI.ITEMTYPE.SECTION));
          localObject2 = paramAccountList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FolderData)((Iterator)localObject2).next();
            paramAccountList = null;
            if (((FolderData)localObject3).getAccountId() == -1) {}
            for (localObject1 = null;; localObject1 = localAccountList.getAccountById(((FolderData)localObject3).getAccountId()))
            {
              if (((FolderData)localObject3).getType() != 1) {
                break label677;
              }
              Popularize localPopularize = PopularizeManager.sharedInstance().getPopularizeById(((FolderData)localObject3).getFolderId());
              if (localPopularize != null) {
                paramAccountList = PopularizeManager.sharedInstance().generatePopularizeFolder(localPopularize);
              }
              label612:
              if (paramAccountList == null) {
                break label758;
              }
              paramAccountList.setName(((FolderData)localObject3).getName());
              paramAccountList.setSequence(((FolderData)localObject3).getSequence());
              localArrayList.add(new AccountListUI((Account)localObject1, paramAccountList, ((FolderData)localObject3).getName(), (FolderData)localObject3));
              break;
            }
            label677:
            if (((FolderData)localObject3).getType() == 4)
            {
              paramAccountList = QMFolderManager.sharedInstance();
              i = ((FolderData)localObject3).getFolderId();
              if (((FolderData)localObject3).getFolderId() != -1) {}
              for (bool = true;; bool = false)
              {
                paramAccountList = paramAccountList.getFolder(i, bool);
                paramAccountList.setType(140);
                break;
              }
            }
            paramAccountList = QMFolderManager.sharedInstance();
            i = ((FolderData)localObject3).getFolderId();
            if (((FolderData)localObject3).getFolderId() != -1) {}
            for (bool = true;; bool = false)
            {
              paramAccountList = paramAccountList.getFolder(i, bool);
              break label612;
              label758:
              break;
            }
          }
        }
        localArrayList.add(new AccountListUI(getString(2131695185), AccountListUI.ITEMTYPE.SECTION));
        localArrayList.addAll(returnAllAccount());
        if (paramBoolean) {
          localArrayList.add(new AccountListUI(getString(2131689702), AccountListUI.ITEMTYPE.BTN));
        }
      }
    }
    for (;;)
    {
      return localArrayList;
      localArrayList.addAll(returnAllAccount());
      localArrayList.add(new AccountListUI(getString(2131689702), AccountListUI.ITEMTYPE.BTN));
    }
  }
  
  public static String revertRawGmailAccessToken(String paramString)
  {
    try
    {
      paramString = new String(Base64.decode(paramString.toString().getBytes("UTF-8"), 2)).split("\001")[1].split(" ")[1];
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static boolean saveAccountAndFolderToConfig(List<AccountListUI> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject2 = FolderDataManager.getHomeAppIdList();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      AccountListUI localAccountListUI = (AccountListUI)paramList.get(i);
      if (localAccountListUI == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localAccountListUI.mData != null) {
          if (localAccountListUI.mData.getSection() == 3) {
            localArrayList1.add(localAccountListUI.mAccount);
          } else if (localAccountListUI.mData.getSection() == 0) {
            localArrayList2.add(localAccountListUI.mData);
          } else {
            ((ArrayList)localObject1).add(Integer.valueOf(localAccountListUI.mData.getFolderId()));
          }
        }
      }
    }
    FolderDataManager.setSeqByFolderDataListOrder(localArrayList2);
    FolderDataManager.sharedInstance().deleteFolderDataList();
    FolderDataManager.sharedInstance().insertFolderDataList(localArrayList2);
    ((ArrayList)localObject1).add(Integer.valueOf(-20));
    if (!((ArrayList)localObject2).equals(localObject1)) {
      FolderDataManager.setHomeAppIdList((ArrayList)localObject1);
    }
    paramList = new ArrayList();
    localArrayList2 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      i = ((Integer)((Iterator)localObject2).next()).intValue();
      if ((i < 0) && (i != -20)) {
        paramList.add(Integer.valueOf(i));
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      i = ((Integer)((Iterator)localObject1).next()).intValue();
      if ((i < 0) && (i != -20)) {
        localArrayList2.add(Integer.valueOf(i));
      }
    }
    if (!paramList.equals(localArrayList2))
    {
      FolderDataManager.sharedInstance().sendApplicationShowInHome(localArrayList2);
      QMLog.log(3, "QMAccountHelper", "change default app seq to send config");
      DataCollector.logEvent("Event_Appfolder_Moved");
    }
    AccountManager.shareInstance().updateOrder(localArrayList1);
    return true;
  }
  
  public static void saveActiveFolderToDB(ArrayList<FolderData> paramArrayList, AccountList paramAccountList)
  {
    Object localObject = (ArrayList)paramArrayList.clone();
    paramArrayList = getUniversalFolders(paramAccountList);
    paramAccountList = paramArrayList.iterator();
    FolderData localFolderData1;
    while (paramAccountList.hasNext())
    {
      localFolderData1 = (FolderData)paramAccountList.next();
      if ((localFolderData1 != null) && (!localFolderData1.isPersistence()))
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          FolderData localFolderData2 = (FolderData)localIterator.next();
          if ((localFolderData2 != null) && (localFolderData2.getAccountId() == localFolderData1.getAccountId()) && (localFolderData2.getFolderId() == localFolderData1.getFolderId())) {
            localIterator.remove();
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localFolderData1.setShouldShow(true);
        break;
      }
      paramAccountList.remove();
      break;
      paramAccountList = ((ArrayList)localObject).iterator();
      while (paramAccountList.hasNext())
      {
        localObject = (FolderData)paramAccountList.next();
        if (localObject != null)
        {
          ((FolderData)localObject).setShouldShow(true);
          paramArrayList.add(localObject);
        }
      }
      FolderDataManager.setSeqByFolderDataListOrder(paramArrayList);
      FolderDataManager.sharedInstance().deleteFolderDataList();
      FolderDataManager.sharedInstance().insertFolderDataList(paramArrayList);
      return;
    }
  }
  
  public static void saveProcessingFolderToConfig(List<AccountListUI> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AccountListUI localAccountListUI = (AccountListUI)paramList.next();
      if ((localAccountListUI != null) && (localAccountListUI.mData != null) && ((localAccountListUI.mFolder == null) || (localAccountListUI.mFolder.getType() != 130)) && ((localAccountListUI.mFolder == null) || ((localAccountListUI.mFolder.getId() != -20) && (localAccountListUI.mFolder.getId() != -4) && (localAccountListUI.mFolder.getId() != -16) && (localAccountListUI.mFolder.getId() != -18) && (localAccountListUI.mFolder.getId() != -5))) && (localAccountListUI.mData.getSection() == 0))
      {
        if ((!localAccountListUI.mData.isPersistence()) && (!localAccountListUI.mData.isShouldShow())) {
          localAccountListUI.mData.setProcessing(true);
        }
        localArrayList.add(localAccountListUI.mData);
      }
    }
    FolderDataManager.sharedInstance().updateActiveFolderProcessing(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.QMAccountHelper
 * JD-Core Version:    0.7.0.1
 */