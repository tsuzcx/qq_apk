package com.tencent.qqmail.popularize.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.qqmail.WelcomeActivity;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.businessfilter.FolderListSubItemFilter;
import com.tencent.qqmail.popularize.businessfilter.WelcomeFilter;
import com.tencent.qqmail.popularize.businessfilter.card.CardWithSubitemFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeAppConfig;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

public class PopularizeUIHelper
{
  public static final String HTTP = "http://";
  public static final String HTTPS = "https://";
  public static final String TAG = "PopularizeUIHelper";
  private static Calendar calendar;
  private static ConcurrentHashMap<Integer, Integer> cancelCache;
  private static ConcurrentHashMap<Integer, Integer> clickCache;
  private static boolean isGoBackgroundBeforeForPopularize = false;
  private static Calendar lastRender;
  private static int myAppRelatedPopularizeId;
  private static ConcurrentHashMap<Integer, Integer> renderCache = new ConcurrentHashMap();
  
  static
  {
    clickCache = new ConcurrentHashMap();
    cancelCache = new ConcurrentHashMap();
    calendar = Calendar.getInstance();
    lastRender = Calendar.getInstance();
    myAppRelatedPopularizeId = -1;
  }
  
  public static ArrayList<PopularizeSubItem> getAllPopularizeSubItems(int paramInt)
  {
    Popularize localPopularize = PopularizeManager.sharedInstance().getPopularizeById(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localPopularize != null)
    {
      if (localPopularize.getSubItems() != null) {
        localArrayList.addAll(localPopularize.getSubItems());
      }
      if ((localPopularize.getAppConfig() != null) && (localPopularize.getAppConfig().getSubitems() != null)) {
        localArrayList.addAll(localPopularize.getAppConfig().getSubitems());
      }
    }
    return localArrayList;
  }
  
  public static int getAnimationTypeByPopularize(int paramInt)
  {
    int i = 0;
    if ((paramInt == 0) || (paramInt == 4) || (paramInt == 10)) {
      i = 1;
    }
    while ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      return i;
    }
    return 2;
  }
  
  public static Map<Integer, ArrayList<PopularizeSubItem>> getFolderPopularizeSubItems(ArrayList<Integer> paramArrayList, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2;
    Set localSet;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (paramArrayList.contains(Integer.valueOf(-20))) {
        localHashMap1.put(Integer.valueOf(-20), getMyAppSubitems());
      }
      localHashMap2 = PopularizeManager.sharedInstance().getPopularizeSubItem(new FolderListSubItemFilter(paramInt));
      localSet = localHashMap2.keySet();
      paramArrayList = paramArrayList.iterator();
    }
    label192:
    for (;;)
    {
      int i;
      if (paramArrayList.hasNext())
      {
        i = ((Integer)paramArrayList.next()).intValue();
        if (i != -20)
        {
          Iterator localIterator = localSet.iterator();
          while (localIterator.hasNext())
          {
            Popularize localPopularize = (Popularize)localIterator.next();
            if (localPopularize.getId() == i) {
              localHashMap1.put(Integer.valueOf(i), localHashMap2.get(localPopularize));
            }
          }
        }
      }
      else
      {
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label192;
          }
          localHashMap1.put(Integer.valueOf(i), new ArrayList());
          break;
          return localHashMap1;
        }
      }
    }
  }
  
  private static ArrayList<PopularizeSubItem> getMyAppSubitems()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = FolderDataManager.getInnerAppIdList();
    Object localObject3 = new ArrayList();
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    int i;
    Object localObject2;
    label137:
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      localObject2 = null;
      if (i > 0) {
        localObject1 = PopularizeManager.sharedInstance().getPopularizeById(i);
      }
      for (;;)
      {
        if ((localObject1 == null) || (((Popularize)localObject1).getAppConfig() == null)) {
          break label137;
        }
        ((ArrayList)localObject3).add(((Popularize)localObject1).getAppConfig());
        break;
        localObject1 = localObject2;
        if (i == -23)
        {
          ArrayList localArrayList2 = PopularizeManager.sharedInstance().getPopularize(new CardWithSubitemFilter());
          localObject1 = localObject2;
          if (localArrayList2.size() > 0) {
            localObject1 = (Popularize)localArrayList2.get(0);
          }
        }
      }
    }
    if (((ArrayList)localObject3).size() > 0)
    {
      Collections.sort((List)localObject3);
      localObject1 = ((ArrayList)localObject3).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((PopularizeAppConfig)((Iterator)localObject1).next()).getSubitems();
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (PopularizeSubItem)((Iterator)localObject2).next();
            if (((PopularizeSubItem)localObject3).isCancel())
            {
              QMLog.log(4, "PopularizeUIHelper", "renderPopularizeSubItem item cancel.text:" + ((PopularizeSubItem)localObject3).getText() + " image:" + ((PopularizeSubItem)localObject3).getImageUrl());
            }
            else
            {
              i = ((PopularizeSubItem)localObject3).getShowType();
              if ((i == 1) && (((PopularizeSubItem)localObject3).isClickMyApp()))
              {
                handleSubItemCancel((PopularizeSubItem)localObject3);
                QMLog.log(4, "PopularizeUIHelper", "renderPopularizeSubItem item click once.text:" + ((PopularizeSubItem)localObject3).getText() + " image:" + ((PopularizeSubItem)localObject3).getImageUrl());
              }
              else if ((i == 7) && (((PopularizeSubItem)localObject3).isClick()))
              {
                handleSubItemCancel((PopularizeSubItem)localObject3);
                QMLog.log(4, "PopularizeUIHelper", "renderPopularizeSubItem item click related once.text:" + ((PopularizeSubItem)localObject3).getText() + " image:" + ((PopularizeSubItem)localObject3).getImageUrl());
              }
              else if ((i == 0) && (((PopularizeSubItem)localObject3).isRender()))
              {
                handleSubItemCancel((PopularizeSubItem)localObject3);
                QMLog.log(4, "PopularizeUIHelper", "renderPopularizeSubItem item render once.text:" + ((PopularizeSubItem)localObject3).getText() + " image:" + ((PopularizeSubItem)localObject3).getImageUrl());
              }
              else
              {
                localArrayList1.add(localObject3);
              }
            }
          }
        }
      } while (localArrayList1.size() <= 0);
    }
    Threads.runInBackground(new PopularizeUIHelper.1(localArrayList1));
    if (localArrayList1.size() > 0)
    {
      myAppRelatedPopularizeId = ((PopularizeSubItem)localArrayList1.get(0)).getPopularizeId();
      return localArrayList1;
    }
    myAppRelatedPopularizeId = -1;
    return localArrayList1;
  }
  
  public static Bitmap getPopularizeItemImage(int paramInt)
  {
    Object localObject = PopularizeManager.sharedInstance().getPopularizeById(paramInt);
    if ((localObject != null) && (((Popularize)localObject).getImageUrl() != null))
    {
      Bitmap localBitmap = PopularizeThumbManager.sharedInstance().getPopularizeThumb(((Popularize)localObject).getImageUrl());
      localObject = localBitmap;
      if (localBitmap != null) {
        localObject = DrawBitmapUtil.drawSquredIcon(localBitmap);
      }
      return localObject;
    }
    return null;
  }
  
  public static Bitmap getPopularizeItemSubImage(int paramInt)
  {
    Popularize localPopularize = PopularizeManager.sharedInstance().getPopularizeById(paramInt);
    if ((localPopularize != null) && (localPopularize.getSubImageUrl() != null)) {
      return PopularizeThumbManager.sharedInstance().getPopularizeThumb(localPopularize.getSubImageUrl());
    }
    return null;
  }
  
  public static double getPopularizeItemSubImagePosition(int paramInt)
  {
    Popularize localPopularize = PopularizeManager.sharedInstance().getPopularizeById(paramInt);
    if (localPopularize != null) {
      return localPopularize.getBannerHeight();
    }
    return 0.0D;
  }
  
  public static String getPopularizeItemSubInfoData(int paramInt)
  {
    Popularize localPopularize = PopularizeManager.sharedInstance().getPopularizeById(paramInt);
    if ((localPopularize != null) && (!localPopularize.isClick())) {
      return localPopularize.getSubInformationData();
    }
    return null;
  }
  
  public static ArrayList<PopularizeSubItem> getPopularizePosSubItems(ArrayList<PopularizeSubItem> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)paramArrayList.next();
        if (localPopularizeSubItem.getPosition() == paramInt) {
          localArrayList.add(localPopularizeSubItem);
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        Collections.sort(localArrayList);
      }
      return localArrayList;
    }
    return null;
  }
  
  public static void handleAction(Context paramContext, Popularize paramPopularize, PopularizeActionDelegate paramPopularizeActionDelegate)
  {
    int i;
    if (paramPopularize != null)
    {
      for (;;)
      {
        try
        {
          switch (paramPopularize.getType())
          {
          case 0: 
            PopularizeManager.sharedInstance().updatePopularizeClick(paramPopularize.getId(), true);
            if (clickCache.get(Integer.valueOf(paramPopularize.getId())) != null) {
              break label1116;
            }
            i = 0;
            label73:
            clickCache.put(Integer.valueOf(paramPopularize.getId()), Integer.valueOf(i + 1));
            if (paramPopularize.getType() == 1)
            {
              localObject = new ArrayList();
              ((ArrayList)localObject).addAll(paramPopularize.getSubItems());
              if ((paramPopularize.getAppConfig() != null) && (paramPopularize.getAppConfig().getSubitems() != null)) {
                ((ArrayList)localObject).addAll(paramPopularize.getAppConfig().getSubitems());
              }
              if (localObject != null) {
                PopularizeManager.sharedInstance().updatePopularizeSubItemClick((ArrayList)localObject, true);
              }
            }
            QMLog.log(4, "PopularizeUIHelper", "handleAction type" + paramPopularize.getType());
            i = getAnimationTypeByPopularize(paramPopularize.getType());
            if ((paramPopularize.getSessionType() == 1) && (AccountManager.shareInstance().getAccountList().getPureQQMailAccountNumber() <= 0))
            {
              if ((!paramPopularize.getOpenUrl().startsWith("qqmail://greetingcard")) && (!paramPopularize.getOpenUrl().startsWith("qqmail://ftn")) && (!paramPopularize.getOpenUrl().startsWith("qqmail://note")) && (!paramPopularize.getOpenUrl().startsWith("qqmail://calendar")) && (!paramPopularize.getOpenUrl().startsWith("qqmail://bottle"))) {
                break label1139;
              }
              paramPopularize.setAction(4);
              QMLog.log(4, "PopularizeUIHelper", "handle popular card no qq account");
            }
            if (StringUtils.isBlank(paramPopularize.getPopularizeAppName())) {
              break label1176;
            }
            Object localObject = paramPopularize.getPopularizeAppName();
            Intent localIntent = new Intent("android.intent.action.MAIN");
            localIntent.setPackage((String)localObject);
            localIntent.addCategory("android.intent.category.LAUNCHER");
            localObject = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              break label1176;
            }
            localObject = (ResolveInfo)((List)localObject).iterator().next();
            if ((localObject == null) || ((paramPopularize.getAppInstallAction() != 2) && (paramPopularize.getAppInstallAction() != 3))) {
              break label1176;
            }
            paramPopularize = new Intent("android.intent.action.VIEW");
            paramPopularize.setFlags(268435456);
            paramPopularize.setComponent(new ComponentName(((ResolveInfo)localObject).activityInfo.packageName, ((ResolveInfo)localObject).activityInfo.name));
            paramContext.startActivity(paramPopularize);
            return;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          QMLog.log(6, "PopularizeUIHelper", paramContext.getMessage());
        }
        DataCollector.logEvent("Event_Banner_popularize_Click");
        DataCollector.logDetailEvent("DetailEvent_Banner_Popularize_Click", 0L, 0L, paramPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Banner_Popularize_Click", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
        QMLog.log(4, "PopularizeUIHelper", "Event_Banner_popularize_Click");
      }
      label1116:
      label1260:
      for (;;)
      {
        DataCollector.submit();
        return;
        if (paramPopularize.getBannerPosition() == 0)
        {
          DataCollector.logEvent("Event_Top_Box_popularize_Click");
          DataCollector.logDetailEvent("DetailEvent_Top_Box_Popularize_Click", 0L, 0L, paramPopularize.getReportId() + "");
          DataCollector.logDetailEventWithDetailMessage("DetailEvent_Top_Box_Popularize_Click", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
          QMLog.log(4, "PopularizeUIHelper", "Event_Top_Box_popularize_Click");
          break;
        }
        if (paramPopularize.getBannerPosition() != 1) {
          break;
        }
        DataCollector.logEvent("Event_Bottom_Box_popularize_Click");
        DataCollector.logDetailEvent("DetailEvent_Bottom_Box_Popularize_Click", 0L, 0L, paramPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Bottom_Box_Popularize_Click", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
        QMLog.log(4, "PopularizeUIHelper", "Event_Bottom_Box_popularize_Click");
        break;
        DataCollector.logEvent("Event_Admail_popularize_Click");
        DataCollector.logDetailEvent("DetailEvent_Admail_Popularize_Click", 0L, 0L, paramPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Admail_Popularize_Click", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
        QMLog.log(4, "PopularizeUIHelper", "Event_Admail_popularize_Click");
        break;
        DataCollector.logEvent("Event_Bookmail_popularize_Click");
        DataCollector.logDetailEvent("DetailEvent_Bookmail_Popularize_Click", 0L, 0L, paramPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Bookmail_Popularize_Click", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
        QMLog.log(4, "PopularizeUIHelper", "Event_Bookmail_popularize_Click");
        break;
        DataCollector.logEvent("Event_Splash_popularize_Click");
        DataCollector.logDetailEvent("DetailEvent_Splash_Popularize_Click", 0L, 0L, paramPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Splash_Popularize_Click", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
        QMLog.log(4, "PopularizeUIHelper", "Event_Splash_popularize_Click");
        break;
        i = ((Integer)clickCache.get(Integer.valueOf(paramPopularize.getId()))).intValue();
        break label73;
        label1139:
        DataCollector.logEvent("Event_Click_popularize_To_Login");
        paramPopularize = LoginFragmentActivity.createIntentFromSchema("ACCOUNT", "", String.valueOf(AccountType.qqmail));
        paramPopularize.putExtra("animationType", i);
        paramContext.startActivity(paramPopularize);
        return;
        i = paramPopularize.getAction();
        paramContext = paramPopularize.getOpenUrl();
        if (i == 0) {
          QMLog.log(4, "PopularizeUIHelper", "handle none");
        }
        for (;;)
        {
          if (paramPopularizeActionDelegate == null) {
            break label1260;
          }
          paramPopularizeActionDelegate.onAction(paramPopularize);
          break;
          if (i != 1) {
            break label1578;
          }
          if ((paramContext == null) || (!paramContext.startsWith("qqmail://"))) {
            break label1262;
          }
          QMLog.log(4, "PopularizeUIHelper", "handle schema " + paramContext);
        }
      }
      label1176:
      label1199:
      label1262:
      if ((paramContext != null) && ((paramContext.startsWith("http://")) || (paramContext.startsWith("https://")))) {
        switch (paramPopularize.getType())
        {
        }
      }
    }
    for (;;)
    {
      DataCollector.logEvent("Event_Click_popularize_To_WebView");
      QMLog.log(4, "PopularizeUIHelper", "handle url " + paramContext);
      break label1199;
      DataCollector.logDetailEvent("DetailEvent_ad_Webview_Banner", 0L, 0L, paramContext);
      QMLog.log(4, "PopularizeUIHelper", "DetailEvent_ad_Webview_Banner," + paramContext);
      continue;
      DataCollector.logDetailEvent("DetailEvent_ad_Webview_Mailbox", 0L, 0L, paramContext);
      QMLog.log(4, "PopularizeUIHelper", "DetailEvent_ad_Webview_Mailbox," + paramContext);
      continue;
      DataCollector.logDetailEvent("DetailEvent_ad_Webview_AdMail", 0L, 0L, paramContext);
      QMLog.log(4, "PopularizeUIHelper", "DetailEvent_ad_Webview_AdMail," + paramContext);
      continue;
      DataCollector.logDetailEvent("DetailEvent_ad_Webview_BookMail", 0L, 0L, paramContext);
      QMLog.log(4, "PopularizeUIHelper", "DetailEvent_ad_Webview_BookMail," + paramContext);
      continue;
      DataCollector.logDetailEvent("DetailEvent_ad_Webview_Splash", 0L, 0L, paramContext);
      QMLog.log(4, "PopularizeUIHelper", "DetailEvent_ad_Webview_Splash," + paramContext);
      continue;
      QMLog.log(4, "PopularizeUIHelper", "handle error url " + paramContext);
      break label1199;
      label1578:
      if (i == 4)
      {
        QMLog.log(4, "PopularizeUIHelper", "handle skip");
        break label1199;
      }
      QMLog.log(4, "PopularizeUIHelper", "handle unsupported action " + i);
      break label1199;
      break;
      return;
    }
  }
  
  public static void handleActionAndGotoLink(Context paramContext, Popularize paramPopularize)
  {
    handleAction(paramContext, paramPopularize, new PopularizeUIHelper.3(paramContext));
  }
  
  public static void handleCancel(Popularize paramPopularize)
  {
    if (paramPopularize != null)
    {
      switch (paramPopularize.getType())
      {
      }
      for (;;)
      {
        PopularizeManager.sharedInstance().updatePopularizeCancel(paramPopularize.getId(), true);
        Object localObject = paramPopularize.getSubItems();
        if (localObject == null) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject).next();
          PopularizeManager.sharedInstance().updatePopularizeSubItemCancel(paramPopularize.getId(), localPopularizeSubItem.getId(), true);
        }
        DataCollector.logEvent("Event_Banner_popularize_Cancel");
        DataCollector.logDetailEvent("DetailEvent_Banner_Popularize_Cancel", 0L, 0L, paramPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Banner_Popularize_Cancel", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
        QMLog.log(4, "PopularizeUIHelper", "DATACOLLECTION_EVENT_BANNER_POPULARIZE_CANCEL");
        continue;
        DataCollector.logEvent("Event_Admail_popularize_Cancel");
        DataCollector.logDetailEvent("DetailEvent_Admail_Popularize_Cancel", 0L, 0L, paramPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Admail_Popularize_Cancel", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
        QMLog.log(4, "PopularizeUIHelper", "DATACOLLECTION_EVENT_ADMAIL_POPULARIZE_CANCEL");
        continue;
        DataCollector.logEvent("Event_Bookmail_popularize_Cancel");
        DataCollector.logDetailEvent("DetailEvent_Bookmail_Popularize_Cancel", 0L, 0L, paramPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Bookmail_Popularize_Cancel", paramPopularize.getReportId() + "", 0L, 0L, paramPopularize.getReportId() + "");
        QMLog.log(4, "PopularizeUIHelper", "DATACOLLECTION_EVENT_BOOKMAIL_POPULARIZE_CANCEL");
      }
      if (cancelCache.get(Integer.valueOf(paramPopularize.getId())) != null) {
        break label453;
      }
    }
    label453:
    for (int i = 0;; i = ((Integer)cancelCache.get(Integer.valueOf(paramPopularize.getId()))).intValue())
    {
      cancelCache.put(Integer.valueOf(paramPopularize.getId()), Integer.valueOf(i + 1));
      DataCollector.submit();
      return;
    }
  }
  
  public static int handleCardPopularize(Popularize paramPopularize)
  {
    if (paramPopularize != null)
    {
      PopularizeManager.sharedInstance().updatePopularizeCancel(paramPopularize.getId(), true);
      localObject = paramPopularize.getSubItems();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject).next();
          PopularizeManager.sharedInstance().updatePopularizeSubItemCancel(paramPopularize.getId(), localPopularizeSubItem.getId(), true);
        }
      }
      if ((paramPopularize.getAppConfig() != null) && (paramPopularize.getAppConfig().getSubitems() != null))
      {
        localObject = paramPopularize.getAppConfig().getSubitems().iterator();
        while (((Iterator)localObject).hasNext()) {
          handleSubItemCancel((PopularizeSubItem)((Iterator)localObject).next());
        }
      }
      switch (paramPopularize.getType())
      {
      }
    }
    while (!isFestivalPopularizeInTime())
    {
      Object localObject;
      PopularizeSubItem localPopularizeSubItem;
      return -1;
      CardUtil.setBirthdayRedDotClick(System.currentTimeMillis());
      return 2;
      return 3;
    }
    return 3;
  }
  
  public static void handleMyAppAction()
  {
    if (myAppRelatedPopularizeId != -1)
    {
      Popularize localPopularize = PopularizeManager.sharedInstance().getPopularizeById(myAppRelatedPopularizeId);
      if ((localPopularize != null) && (localPopularize.getAppConfig() != null) && (localPopularize.getAppConfig().getSubitems() != null)) {
        Threads.runInBackground(new PopularizeUIHelper.2(localPopularize.getAppConfig().getSubitems()));
      }
    }
  }
  
  public static void handleSubItemCancel(PopularizeSubItem paramPopularizeSubItem)
  {
    Threads.runInBackground(new PopularizeUIHelper.5(paramPopularizeSubItem));
  }
  
  public static void handleSubItemClick(PopularizeSubItem paramPopularizeSubItem)
  {
    Threads.runInBackground(new PopularizeUIHelper.4(paramPopularizeSubItem));
  }
  
  private static boolean isFestivalPopularizeInTime()
  {
    Object localObject = PopularizeManager.sharedInstance().getPopularizeByType(7);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Popularize localPopularize = (Popularize)((Iterator)localObject).next();
        long l = System.currentTimeMillis() / 1000L;
        if ((localPopularize.getStartTime() <= l) && (localPopularize.getEndTime() >= l))
        {
          QMLog.log(4, "PopularizeUIHelper", "festival popularize in time");
          return true;
        }
      }
    }
    return false;
  }
  
  public static void setIsGoBackgroundBefore()
  {
    isGoBackgroundBeforeForPopularize = true;
  }
  
  public static void shouldShowWakeupWelcomePopularize(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramBoolean) && (PopularizeManager.sharedInstance().getPopularize(new WelcomeFilter(true)).size() > 0))
    {
      Log.i("PopularizeUIHelper", "shouldShowWakeupWelcomePopularize WelcomeActivity");
      paramActivity.startActivity(WelcomeActivity.createIntent(true));
    }
  }
  
  public static abstract interface PopularizeActionDelegate
  {
    public abstract boolean onAction(Popularize paramPopularize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeUIHelper
 * JD-Core Version:    0.7.0.1
 */