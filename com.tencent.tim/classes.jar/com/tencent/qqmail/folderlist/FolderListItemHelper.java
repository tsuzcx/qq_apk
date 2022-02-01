package com.tencent.qqmail.folderlist;

import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.folderlist.model.IListItem.ItemType;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FolderListItemHelper
{
  public static final String TAG = FolderListItemHelper.class.getSimpleName();
  
  private static boolean canAddToUniversalSection(FolderData paramFolderData, int paramInt)
  {
    return (paramInt == -3) || (paramInt == -9) || (paramInt == -19) || (paramInt == -2) || (paramFolderData.getType() == 2);
  }
  
  public static List<IListFolder> createFolderItem(List<QMFolder> paramList, boolean paramBoolean1, boolean paramBoolean2, Account paramAccount)
  {
    if (paramBoolean1) {
      return createFolderItemsForMultiAccount(paramList, paramBoolean1);
    }
    return createFolderItemsForSingleAccount(paramList, paramBoolean1, paramBoolean2, paramAccount);
  }
  
  private static List<IListFolder> createFolderItemsForMultiAccount(List<QMFolder> paramList, boolean paramBoolean)
  {
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject2 = null;
    if (i < paramList.size())
    {
      Object localObject3 = (QMFolder)paramList.get(i);
      if (((QMFolder)localObject3).isDisplay()) {
        if ((((QMFolder)localObject3).getType() == 1) && (!hasEditedFolderOrder((QMFolder)localObject3)))
        {
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
      for (;;)
      {
        i += 1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
        if ((((QMFolder)localObject3).getType() == 16) && (!hasEditedFolderOrder((QMFolder)localObject3)))
        {
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        else
        {
          localArrayList.add(new IListFolder(IListItem.ItemType.ITEM, (QMFolder)localObject3, paramBoolean, false, false, -1));
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
    }
    topInboxAndStarredFolder(paramBoolean, localArrayList, localObject2, localObject1);
    return localArrayList;
  }
  
  private static List<IListFolder> createFolderItemsForSingleAccount(List<QMFolder> paramList, boolean paramBoolean1, boolean paramBoolean2, Account paramAccount)
  {
    ArrayList localArrayList = new ArrayList();
    label46:
    Object localObject2;
    int j;
    Object localObject3;
    if (paramAccount != null)
    {
      paramAccount = new AccountList(new Account[] { paramAccount });
      paramAccount = QMAccountHelper.getUniversalFolders(paramAccount);
      localObject1 = new StringBuilder();
      i = 0;
      if (i >= paramAccount.size()) {
        break label524;
      }
      localObject2 = (FolderData)paramAccount.get(i);
      j = ((FolderData)localObject2).getFolderId();
      if (canAddToUniversalSection((FolderData)localObject2, j))
      {
        localObject3 = QMFolderManager.sharedInstance();
        if (j != -3) {
          break label134;
        }
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      localObject3 = ((QMFolderManager)localObject3).getFolder(j, bool);
      if (localObject3 != null) {
        break label140;
      }
      i += 1;
      break label46;
      paramAccount = new AccountList();
      break;
    }
    label140:
    if (((QMFolder)localObject3).getId() == -19)
    {
      j = QMSettingManager.sharedInstance().getStarAttachDisplay();
      if (j == 0) {
        if (QMAttachManager.sharedInstance().isShowStarAttach())
        {
          ((FolderData)localObject2).setShouldShow(true);
          QMSettingManager.sharedInstance().setStarAttachDisplay(1);
          label185:
          localArrayList.add(new IListFolder(IListItem.ItemType.ITEM, (QMFolder)localObject3, paramBoolean1, paramBoolean2, ((FolderData)localObject2).isShouldShow(), i));
        }
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(((QMFolder)localObject3).getName() + ":" + ((FolderData)localObject2).isShouldShow() + " ");
      break;
      ((FolderData)localObject2).setShouldShow(false);
      break label185;
      if (j != 1) {
        break label185;
      }
      ((FolderData)localObject2).setShouldShow(true);
      break label185;
      if (((QMFolder)localObject3).getId() == -3)
      {
        j = QMSettingManager.sharedInstance().getAddrVipDisplay();
        if (j == 0) {
          if (QMSettingManager.sharedInstance().isShowAddrVip())
          {
            ((FolderData)localObject2).setShouldShow(true);
            QMSettingManager.sharedInstance().setAddrVipDisplay(1);
          }
        }
        for (;;)
        {
          localArrayList.add(new IListFolder(IListItem.ItemType.ITEM, (QMFolder)localObject3, paramBoolean1, paramBoolean2, ((FolderData)localObject2).isShouldShow(), i));
          break;
          ((FolderData)localObject2).setShouldShow(false);
          continue;
          if (j == 1) {
            ((FolderData)localObject2).setShouldShow(true);
          }
        }
      }
      IListFolder localIListFolder;
      if (((QMFolder)localObject3).getId() == -9)
      {
        localIListFolder = new IListFolder(IListItem.ItemType.ITEM, (QMFolder)localObject3, paramBoolean1, paramBoolean2, ((FolderData)localObject2).isShouldShow(), i);
        localIListFolder.setName(QMApplicationContext.sharedInstance().getString(2131693929));
        localArrayList.add(localIListFolder);
      }
      else if (((QMFolder)localObject3).getId() == -2)
      {
        localIListFolder = new IListFolder(IListItem.ItemType.ITEM, (QMFolder)localObject3, paramBoolean1, paramBoolean2, ((FolderData)localObject2).isShouldShow(), i);
        localIListFolder.setName(QMApplicationContext.sharedInstance().getString(2131693924));
        localArrayList.add(localIListFolder);
      }
      else
      {
        localArrayList.add(new IListFolder(IListItem.ItemType.ITEM, (QMFolder)localObject3, paramBoolean1, paramBoolean2, ((FolderData)localObject2).isShouldShow(), i));
      }
    }
    label524:
    QMLog.log(4, TAG, "universal folderData to folder:" + ((StringBuilder)localObject1).toString());
    Log.d("donald", "universal folderData to folder:" + ((StringBuilder)localObject1).toString());
    if (!paramBoolean2)
    {
      paramAccount = localArrayList.iterator();
      while (paramAccount.hasNext()) {
        if (!((IListFolder)paramAccount.next()).shouldShow()) {
          paramAccount.remove();
        }
      }
    }
    Object localObject1 = QMAccountHelper.getHomeAppFolders();
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localArrayList.add(new IListFolder(IListItem.ItemType.SECTION, QMApplicationContext.sharedInstance().getString(2131690444)));
      i = 0;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (FolderData)((ArrayList)localObject1).get(i);
        paramAccount = null;
        if (((FolderData)localObject2).getType() == 1)
        {
          localObject3 = PopularizeManager.sharedInstance().getPopularizeById(((FolderData)localObject2).getFolderId());
          if (localObject3 != null) {
            paramAccount = PopularizeManager.sharedInstance().generatePopularizeFolder((Popularize)localObject3);
          }
        }
        for (;;)
        {
          if (paramAccount != null)
          {
            paramAccount.setName(((FolderData)localObject2).getName());
            paramAccount.setSequence(((FolderData)localObject2).getSequence());
            localArrayList.add(new IListFolder(IListItem.ItemType.ITEM, paramAccount, false, false, ((FolderData)localObject2).isShouldShow(), i));
          }
          i += 1;
          break;
          if (((FolderData)localObject2).getType() == 4)
          {
            paramAccount = QMFolderManager.sharedInstance().getFolder(((FolderData)localObject2).getFolderId());
            paramAccount.setType(140);
          }
          else
          {
            paramAccount = QMFolderManager.sharedInstance().getFolder(((FolderData)localObject2).getFolderId());
          }
        }
      }
    }
    localArrayList.add(new IListFolder(IListItem.ItemType.SECTION, QMApplicationContext.sharedInstance().getString(2131693951)));
    paramAccount = localArrayList.iterator();
    while (paramAccount.hasNext())
    {
      localObject1 = (QMFolder)((IListFolder)paramAccount.next()).getData();
      if (localObject1 != null) {
        ((QMFolder)localObject1).setNameReserved(true);
      }
    }
    paramAccount = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      paramAccount.append(((QMFolder)paramList.get(i)).getName() + ":" + ((QMFolder)paramList.get(i)).isDisplay() + " ");
      if ((((QMFolder)paramList.get(i)).isDisplay()) && (((QMFolder)paramList.get(i)).getType() != 1) && (((QMFolder)paramList.get(i)).getType() != 16)) {
        localArrayList.add(new IListFolder(IListItem.ItemType.ITEM, (QMFolder)paramList.get(i), paramBoolean1, false, false, -1));
      }
      if (((QMFolder)paramList.get(i)).getType() == 4)
      {
        localObject1 = QMTaskManager.sharedInstance(1).getTaskList();
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          localObject2 = QMFolderManager.sharedInstance().getFolder(-10);
          ((QMFolder)localObject2).setCliUnreadCount(((ArrayList)localObject1).size());
          ((QMFolder)localObject2).setHasNewMail(false);
          localArrayList.add(new IListFolder(IListItem.ItemType.ITEM, (QMFolder)localObject2, paramBoolean1, false, false, -1));
        }
      }
      i += 1;
    }
    QMLog.log(4, TAG, "real folders:" + paramAccount.toString());
    return localArrayList;
  }
  
  public static boolean folderTypeIsEditable(int paramInt)
  {
    return (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 0);
  }
  
  public static ArrayList<IListFolder> getInnerAppFolderData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = QMAccountHelper.getInnerAppFolders(FolderDataManager.getHomeAppIdList());
    Object localObject1 = new ArrayList();
    Object localObject2 = localArrayList2.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(Integer.valueOf(((FolderData)((Iterator)localObject2).next()).getFolderId()));
    }
    if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
      localArrayList1.add(0, new IListFolder(IListItem.ItemType.SECTION, ""));
    }
    int i;
    if (((ArrayList)localObject1).indexOf(Integer.valueOf(-4)) != -1) {
      i = ((ArrayList)localObject1).indexOf(Integer.valueOf(-4)) + 2;
    }
    for (;;)
    {
      int k;
      int j;
      if (((ArrayList)localObject1).indexOf(Integer.valueOf(-5)) != -1)
      {
        k = ((ArrayList)localObject1).indexOf(Integer.valueOf(-5));
        if (i == -1)
        {
          j = 0;
          label153:
          j += k + 2;
        }
      }
      for (;;)
      {
        k = 0;
        label161:
        if (k < localArrayList2.size())
        {
          localObject2 = (FolderData)localArrayList2.get(k);
          localObject1 = null;
          Popularize localPopularize;
          if (((FolderData)localObject2).getType() == 1)
          {
            localPopularize = PopularizeManager.sharedInstance().getPopularizeById(((FolderData)localObject2).getFolderId());
            if (localPopularize == null) {}
          }
          for (localObject1 = PopularizeManager.sharedInstance().generatePopularizeFolder(localPopularize);; localObject1 = QMFolderManager.sharedInstance().getFolder(((FolderData)localObject2).getFolderId()))
          {
            if (localObject1 != null)
            {
              ((QMFolder)localObject1).setName(((FolderData)localObject2).getName());
              ((QMFolder)localObject1).setSequence(((FolderData)localObject2).getSequence());
              localArrayList1.add(new IListFolder(IListItem.ItemType.ITEM, (QMFolder)localObject1, false, false, ((FolderData)localObject2).isShouldShow(), k));
            }
            k += 1;
            break label161;
            if (((ArrayList)localObject1).indexOf(Integer.valueOf(-18)) != -1)
            {
              i = ((ArrayList)localObject1).indexOf(Integer.valueOf(-18)) + 2;
              break;
            }
            if (((ArrayList)localObject1).indexOf(Integer.valueOf(-22)) == -1) {
              break label405;
            }
            i = ((ArrayList)localObject1).indexOf(Integer.valueOf(-22)) + 2;
            break;
            j = 1;
            break label153;
          }
        }
        if (i != -1) {
          localArrayList1.add(i, new IListFolder(IListItem.ItemType.SECTION, ""));
        }
        if (j != -1) {
          localArrayList1.add(j, new IListFolder(IListItem.ItemType.SECTION, ""));
        }
        return localArrayList1;
        j = -1;
      }
      label405:
      i = -1;
    }
  }
  
  public static int getRealStarredFolderId(List<QMFolder> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QMFolder localQMFolder = (QMFolder)paramList.next();
        if (localQMFolder.getType() == 16) {
          return localQMFolder.getId();
        }
      }
    }
    return -1;
  }
  
  public static boolean hasEditedFolderOrder(QMFolder paramQMFolder)
  {
    return paramQMFolder.getSequence() < 10000;
  }
  
  private static void topInboxAndStarredFolder(boolean paramBoolean, ArrayList<IListFolder> paramArrayList, QMFolder paramQMFolder1, QMFolder paramQMFolder2)
  {
    if (paramQMFolder2 != null) {
      paramArrayList.add(0, new IListFolder(IListItem.ItemType.ITEM, paramQMFolder2, paramBoolean, false, false, -1));
    }
    if (paramQMFolder1 != null) {
      paramArrayList.add(0, new IListFolder(IListItem.ItemType.ITEM, paramQMFolder1, paramBoolean, false, false, -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListItemHelper
 * JD-Core Version:    0.7.0.1
 */