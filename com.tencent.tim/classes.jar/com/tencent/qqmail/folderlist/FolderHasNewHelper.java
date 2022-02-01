package com.tencent.qqmail.folderlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FolderHasNewHelper
{
  public static final int DELAY = 300;
  private static final String TAG = FolderHasNewHelper.class.getSimpleName();
  private static volatile FolderHasNewHelper instance;
  public static boolean tipFlag = false;
  private HashSet<OutofSightFolder> folderSet = new HashSet();
  
  public static FolderHasNewHelper getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new FolderHasNewHelper();
      }
      return instance;
    }
    finally {}
  }
  
  public OutOfSightHasNewHint getHasNewFolderOutOfSight(ListView paramListView, List<QMFolder> paramList)
  {
    QMLog.log(4, TAG, "[---Find has-new folder out-of-sight---");
    OutOfSightHasNewHint localOutOfSightHasNewHint = new OutOfSightHasNewHint();
    int i1 = paramListView.getFirstVisiblePosition() - paramListView.getHeaderViewsCount();
    int i2 = paramListView.getLastVisiblePosition() - paramListView.getHeaderViewsCount();
    paramListView = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    int j = 0;
    int i = -1;
    while (localIterator.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)localIterator.next();
      if (localQMFolder != null)
      {
        int n = QMFolderManager.sharedInstance().getDisplayUnreadCount(localQMFolder);
        int k = i;
        int m = j;
        if (QMFolderManager.sharedInstance().hasNewMail(localQMFolder))
        {
          k = i;
          m = j;
          if (n > 0)
          {
            if (localQMFolder.getType() == 1)
            {
              QMLog.log(4, TAG, "Inbox has-new, so,,,do nothing and go home");
              localOutOfSightHasNewHint.setCount(0);
              return localOutOfSightHasNewHint;
            }
            n = paramList.indexOf(localQMFolder);
            if ((n >= i1) && (n <= i2))
            {
              QMLog.log(4, TAG, "find has-new folder in-Sight Foldername[%s] hasNew[%s] ", new Object[] { localQMFolder.getName(), localQMFolder.hasNewMail() + "" });
              localOutOfSightHasNewHint.setCount(0);
              return localOutOfSightHasNewHint;
            }
            k = i;
            m = j;
            if (n > i1)
            {
              k = i;
              m = j;
              if (n > i2)
              {
                OutofSightFolder localOutofSightFolder = new OutofSightFolder(localQMFolder.getFromTime() + "", localQMFolder.getName() + "", localQMFolder.getCliUnreadCount());
                QMLog.log(4, TAG, "Out-of-sight name[%s], fromtime[%s], unread[%d]", new Object[] { localQMFolder.getName(), localQMFolder.getFromTime() + "", Integer.valueOf(localQMFolder.getCliUnreadCount()) });
                if (this.folderSet.contains(localOutofSightFolder))
                {
                  QMLog.log(4, TAG, "folderSet.contains(outofSightFolder)");
                  localOutOfSightHasNewHint.setDuplicated(true);
                  j += 1;
                  continue;
                }
                QMLog.log(4, TAG, "Hit!!! Out-of-sight name[%s], fromtime[%s], unread[%d], hasNew[%b]", new Object[] { localQMFolder.getName(), localQMFolder.getFromTime() + "", Integer.valueOf(localQMFolder.getCliUnreadCount()), Boolean.valueOf(localQMFolder.hasNewMail()) });
                m = j + 1;
                if (i != -1)
                {
                  k = i;
                  if (n >= i) {}
                }
                else
                {
                  k = n;
                }
                localOutOfSightHasNewHint.setCount(m);
                localOutOfSightHasNewHint.setFirstIndex(k);
                paramListView.append(localQMFolder.getFromTime() + "" + localQMFolder.getCliUnreadCount());
                localOutOfSightHasNewHint.setFromtimeIdentify(paramListView.toString());
                this.folderSet.add(localOutofSightFolder);
              }
            }
          }
        }
        j = m;
        i = k;
      }
    }
    if (localOutOfSightHasNewHint.getCount() > 0)
    {
      paramList = SharedPreferenceUtil.getOutOfSightHasNewIdentify();
      if ((paramListView.toString().equals(paramList)) || (paramList.contains(paramListView.toString()))) {
        break label686;
      }
      QMLog.log(4, TAG, "the 【diff】 OUT-OF-SIGHT-HAS-NEW");
      localOutOfSightHasNewHint.setDuplicated(false);
      SharedPreferenceUtil.setOutOfSightHasNewIdentify(paramListView.toString());
    }
    for (;;)
    {
      QMLog.log(4, TAG, "result outOfSightHasNewHint = " + localOutOfSightHasNewHint);
      QMLog.log(4, TAG, "Find has-new folder out-of-sight---]");
      return localOutOfSightHasNewHint;
      label686:
      QMLog.log(4, TAG, "the 【same】 OUT-OF-SIGHT-HAS-NEW");
      localOutOfSightHasNewHint.setDuplicated(true);
    }
  }
  
  public ArrayList<QMFolder> getQMFoldersFromAccountList(List<AccountListUI> paramList)
  {
    QMLog.log(4, TAG, "[---Init QMFolders from Account List---");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    label396:
    while (paramList.hasNext())
    {
      AccountListUI localAccountListUI = (AccountListUI)paramList.next();
      Object localObject1 = localAccountListUI.mFolder;
      if (localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM_ACCOUNT)
      {
        QMLog.log(4, TAG, "Getting virtual account folder name[%s], unread[%d], hasnew[%b]", new Object[] { localAccountListUI.mItemName, Integer.valueOf(localAccountListUI.accUnreadCount), Boolean.valueOf(localAccountListUI.accHasNewMail) });
        localObject1 = new QMFolder();
        ((QMFolder)localObject1).setName(localAccountListUI.mItemName);
        ((QMFolder)localObject1).setHasNewMail(localAccountListUI.accHasNewMail);
        ((QMFolder)localObject1).setCliUnreadCount(localAccountListUI.accUnreadCount);
        localArrayList.add(localObject1);
      }
      for (;;)
      {
        if ((localAccountListUI.mType != AccountListUI.ITEMTYPE.ITEM_ACCOUNT) || (localAccountListUI.mAccount == null)) {
          break label396;
        }
        localObject1 = QMFolderManager.sharedInstance().getAllFoldersByAccountId(localAccountListUI.mAccount.getId()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (QMFolder)((Iterator)localObject1).next();
          if (((QMFolder)localObject2).hasNewMail())
          {
            QMLog.log(4, TAG, "-- unread-folder of account[%s] foldername[%s] fromTime[%s] unread[%d] ", new Object[] { localAccountListUI.mItemName, ((QMFolder)localObject2).getName(), ((QMFolder)localObject2).getFromTime() + "", Integer.valueOf(((QMFolder)localObject2).getCliUnreadCount()) });
            localObject2 = new OutofSightFolder(((QMFolder)localObject2).getFromTime() + "", ((QMFolder)localObject2).getName() + "", ((QMFolder)localObject2).getCliUnreadCount());
            this.folderSet.add(localObject2);
          }
        }
        break;
        QMLog.log(4, TAG, "Getting real account folder name[%s], unread[%d], hasnew[%b]", new Object[] { localAccountListUI.mItemName, Integer.valueOf(localAccountListUI.accUnreadCount), Boolean.valueOf(localAccountListUI.accHasNewMail) });
        localArrayList.add(localObject1);
      }
    }
    QMLog.log(4, TAG, "---Init QMFolders from Account List---]");
    return localArrayList;
  }
  
  public ArrayList<QMFolder> getQMFoldersFromFolderList(List<IListFolder> paramList)
  {
    QMLog.log(4, TAG, "getQMFoldersFromFolderList");
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((IListFolder)paramList.next()).getData());
      }
    }
    return localArrayList;
  }
  
  public PopupWindow initOutOfSightHasNewPopUpWindow(boolean paramBoolean, ListView paramListView, OutOfSightHasNewHint paramOutOfSightHasNewHint)
  {
    QMLog.log(4, TAG, "initOutOfSightHasNewPopUpWindow = " + paramOutOfSightHasNewHint);
    View localView = ((LayoutInflater)paramListView.getContext().getSystemService("layout_inflater")).inflate(2131559775, null);
    Object localObject = (TextView)localView.findViewById(2131365360);
    Context localContext = paramListView.getContext();
    if (paramBoolean) {}
    for (int i = 2131720379;; i = 2131720378)
    {
      ((TextView)localObject).setText(String.format(localContext.getString(i), new Object[] { paramOutOfSightHasNewHint.getCount() + "" }));
      localObject = new PopupWindow(localView, -2, -2, true);
      ((PopupWindow)localObject).getContentView().measure(0, 0);
      ((PopupWindow)localObject).setBackgroundDrawable(new ColorDrawable());
      ((PopupWindow)localObject).setTouchable(true);
      ((PopupWindow)localObject).setOutsideTouchable(true);
      ((PopupWindow)localObject).setFocusable(false);
      ((PopupWindow)localObject).setTouchInterceptor(new FolderHasNewHelper.1(this, (PopupWindow)localObject));
      ((PopupWindow)localObject).setAnimationStyle(2131756142);
      ((PopupWindow)localObject).update();
      localView.setOnClickListener(new FolderHasNewHelper.2(this, paramOutOfSightHasNewHint, paramListView, (PopupWindow)localObject));
      return localObject;
    }
  }
  
  public void show(PopupWindow paramPopupWindow, View paramView)
  {
    if (tipFlag)
    {
      QMLog.log(4, TAG, "Try to show popwindow but tipFlag = " + tipFlag);
      return;
    }
    DataCollector.logEvent("Event_New_Mail_tips_Show");
    int i = paramPopupWindow.getContentView().getMeasuredWidth();
    int j = QMApplicationContext.sharedInstance().getResources().getDimensionPixelOffset(2131297348);
    paramPopupWindow.setOnDismissListener(new FolderHasNewHelper.3(this));
    paramPopupWindow.showAtLocation(paramView, 0, QMUIKit.getScreenWidth() / 2 - i / 2, QMUIKit.getScreenHeight() - j);
  }
  
  public void updateHasNewPopupWindowText(boolean paramBoolean, PopupWindow paramPopupWindow, OutOfSightHasNewHint paramOutOfSightHasNewHint)
  {
    QMLog.log(4, TAG, "updateHasNewPopupWindowText = " + paramOutOfSightHasNewHint.toString());
    if ((paramPopupWindow == null) || (paramPopupWindow.getContentView() == null)) {
      return;
    }
    TextView localTextView = (TextView)paramPopupWindow.getContentView().findViewById(2131365360);
    paramPopupWindow = paramPopupWindow.getContentView().getContext();
    if (paramBoolean) {}
    for (int i = 2131720379;; i = 2131720378)
    {
      localTextView.setText(String.format(paramPopupWindow.getString(i), new Object[] { paramOutOfSightHasNewHint.getCount() + "" }));
      return;
    }
  }
  
  public class OutOfSightHasNewHint
  {
    private int count;
    private boolean duplicated = true;
    private int firstIndex;
    private String fromtimeIdentify;
    
    public OutOfSightHasNewHint() {}
    
    public int getCount()
    {
      return Math.min(this.count, 99);
    }
    
    public int getFirstIndex()
    {
      return this.firstIndex;
    }
    
    public String getFromtimeIdentify()
    {
      return this.fromtimeIdentify;
    }
    
    public boolean isDuplicated()
    {
      return this.duplicated;
    }
    
    public boolean needToShow()
    {
      return (!isDuplicated()) && (getCount() > 0);
    }
    
    public void setCount(int paramInt)
    {
      this.count = paramInt;
    }
    
    public void setDuplicated(boolean paramBoolean)
    {
      this.duplicated = paramBoolean;
    }
    
    public void setFirstIndex(int paramInt)
    {
      this.firstIndex = paramInt;
    }
    
    public void setFromtimeIdentify(String paramString)
    {
      this.fromtimeIdentify = paramString;
    }
    
    public String toString()
    {
      return "count = " + this.count + " first = " + this.firstIndex + " duplicated = " + this.duplicated;
    }
  }
  
  public class OutofSightFolder
  {
    public String fromtime;
    public String name;
    public int unreadCount;
    
    public OutofSightFolder(String paramString1, String paramString2, int paramInt)
    {
      this.fromtime = paramString1;
      this.name = paramString2;
      this.unreadCount = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        do
        {
          return false;
        } while (!(paramObject instanceof OutofSightFolder));
        paramObject = (OutofSightFolder)paramObject;
      } while ((!this.fromtime.equals(paramObject.fromtime)) || (!this.name.equals(paramObject.name)) || (this.unreadCount != paramObject.unreadCount));
      return true;
    }
    
    public int hashCode()
    {
      return this.fromtime.hashCode() + this.name.hashCode() + this.unreadCount;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderHasNewHelper
 * JD-Core Version:    0.7.0.1
 */