package com.tencent.qqmail.maillist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.contacts.fragment.AvatarViewHolder;
import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.maillist.view.MailListItemView.MailListItemData;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.cursor.QMAllDraftMailCursor;
import com.tencent.qqmail.model.mail.cursor.QMDraftFolderCursor;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.mail.cursor.QMSendOrToSendFolderCursor;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.MailTag;
import com.tencent.qqmail.search.fragment.SearchListAdapter;
import com.tencent.qqmail.trd.guava.Joiner;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAvatarView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ListViewHelper
{
  public static final float MAX_SCROLL_TIMES = 1.5F;
  private static final String PREFIX_ADDRESS = "asyncLoadAvatar-";
  private static Map<Integer, Bitmap> mDrawableBitmap = Collections.synchronizedMap(new WeakHashMap());
  
  public static void addCustomSmoothScrolling(ListView paramListView, OnSmoothScroll paramOnSmoothScroll)
  {
    paramListView.setOnTouchListener(new ScrollTracker(paramOnSmoothScroll));
  }
  
  public static void addListScrollHandler(ListView paramListView, OnHandleListScroll paramOnHandleListScroll)
  {
    paramListView.setOnScrollListener(new ListViewHelper.1(paramOnHandleListScroll));
  }
  
  private static void asyncLoadAvatar(QMAvatar paramQMAvatar, View paramView, String paramString, MailListItemView.MailListItemData paramMailListItemData)
  {
    Object localObject = QMPrivateProtocolManager.getPhotoBitmapByEmailFromCache(paramString, 3);
    if (localObject != null)
    {
      paramView = (Bitmap)mDrawableBitmap.get(Integer.valueOf(localObject.hashCode()));
      if (paramView != null)
      {
        paramMailListItemData.avatarBitmap = paramView;
        return;
      }
      paramMailListItemData.avatarBitmap = generateAvatar(paramQMAvatar, (Bitmap)localObject, paramMailListItemData.avatarOptionalName);
      return;
    }
    localObject = "asyncLoadAvatar-" + paramString;
    localObject = (Bitmap)mDrawableBitmap.get(Integer.valueOf(((String)localObject).hashCode()));
    if (localObject != null)
    {
      paramMailListItemData.avatarBitmap = ((Bitmap)localObject);
      return;
    }
    paramMailListItemData.avatarBitmap = generateAvatar(paramQMAvatar, null, paramMailListItemData.nickName);
    Threads.runInBackground(new ListViewHelper.2(paramMailListItemData, paramString, paramQMAvatar, paramView));
  }
  
  public static void asyncLoadContactAvatar(QMAvatar paramQMAvatar, View paramView, AvatarViewHolder paramAvatarViewHolder, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = QMPrivateProtocolManager.getPhotoBitmapByEmailFromCache(paramString2, 3);
    if (localObject != null)
    {
      paramView = (Bitmap)mDrawableBitmap.get(Integer.valueOf(localObject.hashCode()));
      if (paramView != null)
      {
        if (paramBoolean)
        {
          paramAvatarViewHolder.avatarView.setAvatar(paramView, paramAvatarViewHolder.avatarName);
          return;
        }
        paramAvatarViewHolder.avatarView.setAvatarBitmap(paramView);
        return;
      }
      if (paramBoolean)
      {
        paramAvatarViewHolder.avatarView.setAvatar((Bitmap)localObject, paramAvatarViewHolder.avatarName);
        return;
      }
      paramAvatarViewHolder.avatarView.setAvatarBitmap(generateAvatar(paramQMAvatar, (Bitmap)localObject, paramAvatarViewHolder.avatarName));
      return;
    }
    localObject = "asyncLoadAvatar-" + paramAvatarViewHolder.avatarName;
    localObject = (Bitmap)mDrawableBitmap.get(Integer.valueOf(((String)localObject).hashCode()));
    if (localObject != null)
    {
      if (paramBoolean)
      {
        paramAvatarViewHolder.avatarView.setAvatar((Bitmap)localObject, paramAvatarViewHolder.avatarName);
        return;
      }
      paramAvatarViewHolder.avatarView.setAvatarBitmap((Bitmap)localObject);
      return;
    }
    if (paramBoolean) {
      paramAvatarViewHolder.avatarView.setAvatar(null, paramAvatarViewHolder.avatarName);
    }
    for (;;)
    {
      Threads.runInBackground(new ListViewHelper.3(paramAvatarViewHolder, paramString1, paramString2, paramQMAvatar, paramBoolean, paramView));
      return;
      paramAvatarViewHolder.avatarView.setAvatarBitmap(generateAvatar(paramQMAvatar, null, paramAvatarViewHolder.avatarName));
    }
  }
  
  public static View bindItemData(int paramInt, View paramView, QMMailListAdapter paramQMMailListAdapter, boolean paramBoolean)
  {
    Context localContext = paramQMMailListAdapter.getContext();
    Object localObject2 = paramQMMailListAdapter.getCursor();
    Object localObject1;
    if ((paramView == null) || (!(paramView instanceof MailListItemView)) || (paramView.getTag() == null))
    {
      localObject1 = new MailListItemView(localContext);
      ((MailListItemView)localObject1).setShowAvatar(paramBoolean);
    }
    for (;;)
    {
      MailListItemView localMailListItemView = (MailListItemView)localObject1;
      MailListItemView.MailListItemData localMailListItemData = localMailListItemView.getItemData();
      localMailListItemData.reset();
      Mail localMail = paramQMMailListAdapter.getItem(paramInt);
      if (localMail == null)
      {
        paramView = new Mail();
        paramView.setInformation(new MailInformation());
        paramView.setStatus(new MailStatus());
        QMLog.log(6, "QMMailListAdapter", "no mail data:" + paramInt);
        paramView = null;
        return paramView;
      }
      MailInformation localMailInformation = localMail.getInformation();
      MailStatus localMailStatus = localMail.getStatus();
      int j = localMailInformation.getAccountId();
      String str = QMUIKit.ELLIPSIZE_FIXED;
      Object localObject3;
      if (paramQMMailListAdapter.isEditing())
      {
        if (!localMailListItemView.isInEditMode()) {
          localMailListItemView.setItemToEditMode();
        }
        localMailListItemView.setEnabled(true);
        localMailListItemView.setTag("");
        if ((!(localObject2 instanceof QMDraftFolderCursor)) && (!(localObject2 instanceof QMAllDraftMailCursor)) && ((!(localObject2 instanceof QMSearchCursor)) || (((QMSearchCursor)localObject2).getFolderType() != 4))) {
          break label1088;
        }
        paramView = Lists.newArrayList();
        if (!(localObject2 instanceof QMSendOrToSendFolderCursor)) {
          break label407;
        }
        localObject3 = localMailInformation.getToList();
        if (localObject3 != null) {
          paramView.addAll((Collection)localObject3);
        }
        localObject3 = localMailInformation.getCcList();
        if (localObject3 != null) {
          paramView.addAll((Collection)localObject3);
        }
        if (localMailStatus.isSepCpy())
        {
          localObject3 = localMailInformation.getBccList();
          if (localObject3 != null) {
            paramView.addAll((Collection)localObject3);
          }
        }
      }
      Object localObject4;
      for (;;)
      {
        localObject3 = Lists.newArrayList();
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          localObject4 = paramView.next();
          if ((localObject4 instanceof MailContact)) {
            ((List)localObject3).add(QMContactManager.sharedInstance().getPossibleNickname(j, ((MailContact)localObject4).getAddress(), ((MailContact)localObject4).getName(), localMail));
          }
        }
        if (!localMailListItemView.isInEditMode()) {
          break;
        }
        localMailListItemView.setItemToNormalMode();
        break;
        label407:
        localObject3 = localMailInformation.getToList();
        if (localObject3 != null) {
          paramView.addAll((Collection)localObject3);
        }
        localObject3 = localMailInformation.getCcList();
        if (localObject3 != null) {
          paramView.addAll((Collection)localObject3);
        }
        localObject3 = localMailInformation.getBccList();
        if (localObject3 != null) {
          paramView.addAll((Collection)localObject3);
        }
      }
      label517:
      label541:
      label585:
      int i;
      if (((List)localObject3).size() > 0)
      {
        paramView = Joiner.on(QMApplicationContext.sharedInstance().getString(2131695610)).join((Iterable)localObject3);
        localMailListItemData.avatarOptionalName = ((String)((List)localObject3).get(0));
        localMailListItemData.nickName = (paramView + str);
        localObject3 = new QMAvatar();
        if ((!localMail.getStatus().isAdConv()) && (!localMail.getStatus().isSubscribeConv())) {
          break label1178;
        }
        if (!localMail.getStatus().isAdConv()) {
          break label1158;
        }
        paramInt = 0;
        if (!paramBoolean) {
          break label1163;
        }
        i = 0;
        label592:
        paramInt = new int[] { 2130838761, 2130838762, 2130838765, 2130838766 }[(i + paramInt)];
        localMailListItemData.avatarBitmap = ((Bitmap)mDrawableBitmap.get(Integer.valueOf(paramInt)));
        if (localMailListItemData.avatarBitmap == null)
        {
          localMailListItemData.avatarBitmap = BitmapFactory.decodeResource(localContext.getResources(), paramInt);
          if (paramBoolean) {
            localMailListItemData.avatarBitmap = ((QMAvatar)localObject3).setAvatar(localMailListItemData.avatarBitmap, localMailListItemData.avatarOptionalName);
          }
          mDrawableBitmap.put(Integer.valueOf(paramInt), localMailListItemData.avatarBitmap);
        }
        if (localMailStatus.isAdConv())
        {
          paramInt = QMMailManager.sharedInstance().getUnreadAdCount(j);
          if ((paramInt <= 0) || (!localMailStatus.isUnread())) {
            break label1169;
          }
          localMailListItemData.unreadNumber = paramInt;
        }
      }
      label760:
      label895:
      ArrayList localArrayList;
      for (;;)
      {
        if ((paramQMMailListAdapter instanceof SearchListAdapter))
        {
          SearchListViewHelper.fillSubjectAndAbstract(localMailListItemData, localMail, str);
          long l = localMailStatus.getToppedAdTime();
          if ((l <= 0L) || (!localMailStatus.isUnread()) || (new Date().getTime() >= l * 1000L)) {
            break label1523;
          }
          localMailListItemData.isToppedAd = true;
          label808:
          paramInt = 0;
          if ((!localMailStatus.isForward()) || (!localMailStatus.isFirstShowForward())) {
            break label1539;
          }
          paramInt = 2;
          label828:
          localMailListItemData.statusId = paramInt;
          paramInt = 0;
          if (!localMailStatus.isUnread()) {
            break label1565;
          }
          paramInt = 1;
          label846:
          localMailListItemData.stateId = paramInt;
          if (localMailStatus.isConversation())
          {
            paramInt = localMailInformation.getConvCount();
            if (paramInt <= 0) {
              break label1580;
            }
            localMailListItemData.conversationNumber = (paramInt + "");
          }
          localMailListItemData.isStarred = localMailStatus.isStarred();
          localMailListItemData.isTopped = localMailStatus.isTopped();
          localMailListItemView.refreshTopMode(localMailStatus.isTopped());
          localMailListItemData.hasAttach = localMailStatus.hasAttach();
          paramView = (View)localObject1;
          if (localMailInformation.getTagList() == null) {
            break;
          }
          paramQMMailListAdapter = localMailInformation.getTagList();
          paramView = (View)localObject1;
          if (paramQMMailListAdapter.size() <= 0) {
            break;
          }
          paramView = (MailTag)paramQMMailListAdapter.get(0);
          localObject2 = paramView.getColor();
          localMailListItemData.tagName1 = (paramView.getName() + str);
          localMailListItemData.tagColor1 = QMUIHelper.getMailTagColorByColorId(localContext, (String)localObject2);
          paramView = (View)localObject1;
          if (paramQMMailListAdapter.size() <= 1) {
            break;
          }
          paramView = (MailTag)paramQMMailListAdapter.get(1);
          paramView.getColor();
          localMailListItemData.tagName2 = paramView.getName();
          localMailListItemData.tagColor2 = QMUIHelper.getMailTagColorByColorId(localContext, paramView.getColor());
          return localObject1;
          paramView = QMApplicationContext.sharedInstance().getString(2131695609);
          localMailListItemData.avatarOptionalName = "";
          break label517;
          label1088:
          paramView = localMailInformation.getFrom().getAddress();
          localObject3 = localMailInformation.getFrom().getName();
          paramView = QMContactManager.sharedInstance().getPossibleNickname(j, paramView, (String)localObject3, localMail);
          localMailListItemData.nickName = (paramView + str);
          localMailListItemData.avatarOptionalName = localMailListItemData.nickName;
          break label541;
          label1158:
          paramInt = 2;
          break label585;
          label1163:
          i = 1;
          break label592;
          label1169:
          localMailListItemData.unreadNumber = 0;
          continue;
          label1178:
          if (paramBoolean) {
            if (((localObject2 instanceof QMDraftFolderCursor)) || ((localObject2 instanceof QMAllDraftMailCursor)))
            {
              paramView = localMailInformation.getToList();
              localObject4 = localMailInformation.getCcList();
              localArrayList = localMailInformation.getBccList();
              if ((localObject2 instanceof QMSendOrToSendFolderCursor)) {
                if ((paramView != null) && (paramView.size() > 0)) {
                  paramView = (MailContact)paramView.get(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        label1246:
        if (paramView != null)
        {
          localObject2 = QMPrivateProtocolManager.getPhotoBitmapByEmail(paramView.getAddress(), 3);
          QMPrivateProtocolManager.sharedInstance().loadEmailIcon(paramView.getAddress());
          localObject2 = generateAvatar((QMAvatar)localObject3, (Bitmap)localObject2, localMailListItemData.avatarOptionalName);
          localMailListItemView.setTag(paramView.getAddress());
          paramView = (View)localObject2;
        }
        for (;;)
        {
          localMailListItemData.avatarBitmap = paramView;
          break;
          if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
          {
            paramView = (MailContact)((ArrayList)localObject4).get(0);
            break label1246;
          }
          if ((!localMailStatus.isSepCpy()) || (localArrayList == null) || (localArrayList.size() <= 0)) {
            break label1591;
          }
          paramView = (MailContact)localArrayList.get(0);
          break label1246;
          if ((paramView == null) || (paramView.size() <= 0)) {
            break label1591;
          }
          paramView = (MailContact)paramView.get(0);
          break label1246;
          localObject2 = (Bitmap)mDrawableBitmap.get(Integer.valueOf(2130838764));
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = ((QMAvatar)localObject3).setAvatar(BitmapFactory.decodeResource(localContext.getResources(), 2130838764), localMailListItemData.avatarOptionalName);
            mDrawableBitmap.put(Integer.valueOf(2130838764), paramView);
          }
          localMailListItemView.setTag("");
        }
        QMPrivateProtocolManager.sharedInstance().loadEmailIcon(localMailInformation.getFrom().getAddress());
        localMailListItemView.setTag(localMailInformation.getFrom().getAddress());
        asyncLoadAvatar((QMAvatar)localObject3, localMailListItemView, localMailInformation.getFrom().getAddress(), localMailListItemData);
        break;
        fillSubjectAndAbstract(localMailListItemData, localMail, str);
        break label760;
        label1523:
        localMailListItemData.dateTime = DateExtension.shortDateName(localMailInformation.getDate());
        break label808;
        label1539:
        if (localMailStatus.isReply())
        {
          paramInt = 1;
          break label828;
        }
        if (!localMailStatus.isForward()) {
          break label828;
        }
        paramInt = 2;
        break label828;
        label1565:
        if (localMailInformation.getSendUtc() <= 0L) {
          break label846;
        }
        paramInt = 2;
        break label846;
        label1580:
        localMailListItemData.conversationNumber = "n";
        break label895;
        label1591:
        paramView = null;
      }
      localObject1 = paramView;
    }
  }
  
  protected static void fillSubjectAndAbstract(MailListItemView.MailListItemData paramMailListItemData, Mail paramMail, String paramString)
  {
    MailInformation localMailInformation = paramMail.getInformation();
    String str = localMailInformation.getSubject();
    if (str != null)
    {
      paramMail = str;
      if (!str.equals("")) {}
    }
    else
    {
      paramMail = QMApplicationContext.sharedInstance().getResources().getString(2131693126);
    }
    paramMailListItemData.subjectTitle = (paramMail + paramString);
    str = localMailInformation.getAbstractContent();
    if (str != null)
    {
      paramMail = str;
      if (!str.equals("")) {}
    }
    else
    {
      paramMail = QMApplicationContext.sharedInstance().getResources().getString(2131693123);
    }
    paramMailListItemData.abstractText = (paramMail + paramString);
    paramMailListItemData.canSplitAbstractText = false;
  }
  
  public static Bitmap generateAvatar(QMAvatar paramQMAvatar, Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {}
    for (Bitmap localBitmap = null;; localBitmap = (Bitmap)mDrawableBitmap.get(Integer.valueOf(paramBitmap.hashCode())))
    {
      Object localObject = localBitmap;
      if (localBitmap == null)
      {
        paramQMAvatar = paramQMAvatar.setAvatar(paramBitmap, paramString);
        localObject = paramQMAvatar;
        if (paramBitmap != null)
        {
          mDrawableBitmap.put(Integer.valueOf(paramBitmap.hashCode()), paramQMAvatar);
          localObject = paramQMAvatar;
        }
      }
      return localObject;
    }
  }
  
  public static void getNextUnread(PtrListView paramPtrListView, IMailListCursor paramIMailListCursor, OnHandleNextUnread paramOnHandleNextUnread)
  {
    int n;
    int i;
    int j;
    int k;
    label34:
    View localView;
    int m;
    if (paramIMailListCursor != null)
    {
      n = paramPtrListView.getHeaderViewsCount();
      if (paramIMailListCursor.canLoadMore())
      {
        i = paramIMailListCursor.getCount() - 1;
        j = 0;
        k = 0;
        if (j >= paramPtrListView.getChildCount()) {
          break label264;
        }
        localView = paramPtrListView.getChildAt(j);
        if (localView.getTop() + localView.getHeight() > 0) {
          break label92;
        }
        m = k;
      }
    }
    label264:
    for (;;)
    {
      j += 1;
      k = m;
      break label34;
      i = paramIMailListCursor.getCount();
      break;
      label92:
      if (((localView instanceof MailListItemView)) || ((localView instanceof HorizontalScrollItemView)))
      {
        String str = (localView.getTag() + "").split("#")[0];
        m = k;
        if (str != null)
        {
          m = k;
          if (!str.equals("null"))
          {
            if (k != 0) {}
            for (k = -1;; k = Integer.parseInt(str))
            {
              m = getViewPosition(paramIMailListCursor, k);
              Log.d("hill-title", localView.getTag() + "--itemPos:" + k + ",i:" + j + ",destPos:" + m);
              if ((paramOnHandleNextUnread != null) && ((!isEndOfList(paramPtrListView)) || (paramOnHandleNextUnread.onReachEnd(i + n)))) {
                break;
              }
              return;
            }
            if (m == -1)
            {
              paramOnHandleNextUnread.onFoundUnread(-1, i + n);
              return;
            }
            paramOnHandleNextUnread.onFoundUnread(m + n, i + n);
          }
        }
      }
      else
      {
        m = 1;
      }
    }
  }
  
  public static void getNextUnread(PtrListView paramPtrListView, List<Integer> paramList, OnHandleNextUnread paramOnHandleNextUnread)
  {
    int k = paramPtrListView.getHeaderViewsCount();
    int m = paramPtrListView.getChildCount();
    int j = paramPtrListView.getFirstVisiblePosition();
    int i = 0;
    while (i < m)
    {
      View localView = paramPtrListView.getChildAt(i);
      int n = localView.getTop();
      if (localView.getHeight() + n > 0) {
        break;
      }
      j += 1;
      i += 1;
    }
    i = getViewPosition(paramList, j, k);
    if (paramOnHandleNextUnread != null)
    {
      j = paramPtrListView.getCount();
      if ((!isEndOfList(paramPtrListView)) || (paramOnHandleNextUnread.onReachEnd(j))) {}
    }
    else
    {
      return;
    }
    if (i == -1)
    {
      paramOnHandleNextUnread.onFoundUnread(-1, j);
      return;
    }
    paramOnHandleNextUnread.onFoundUnread(i, j);
  }
  
  private static int getViewPosition(IMailListCursor paramIMailListCursor, int paramInt)
  {
    if (paramIMailListCursor != null)
    {
      paramIMailListCursor = paramIMailListCursor.getUnreadItemPosition();
      int i = 0;
      while (i < paramIMailListCursor.length)
      {
        if (paramInt < paramIMailListCursor[i]) {
          return paramIMailListCursor[i];
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private static int getViewPosition(List<Integer> paramList, int paramInt1, int paramInt2)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Integer localInteger = (Integer)paramList.next();
        if (paramInt1 < localInteger.intValue() + paramInt2) {
          return localInteger.intValue() + paramInt2;
        }
      }
    }
    return -1;
  }
  
  public static boolean isEndOfList(PtrListView paramPtrListView)
  {
    if (paramPtrListView != null)
    {
      View localView = paramPtrListView.getChildAt(paramPtrListView.getChildCount() - 1);
      int[] arrayOfInt1 = new int[2];
      paramPtrListView.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      if (localView != null) {
        localView.getLocationOnScreen(arrayOfInt2);
      }
      if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (paramPtrListView.getLastVisiblePosition() == paramPtrListView.getCount() - 1))
      {
        int i = paramPtrListView.getHeight();
        if (arrayOfInt1[1] + i <= localView.getHeight() + arrayOfInt2[1]) {
          return true;
        }
      }
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static void scrollToPosition(ListView paramListView, int paramInt)
  {
    float f;
    if (Build.VERSION.SDK_INT >= 8)
    {
      int i = paramListView.getFirstVisiblePosition();
      f = paramListView.getChildCount() * 1.5F;
      if (Math.abs(i - paramInt) > f)
      {
        if (i <= paramInt) {
          break label59;
        }
        paramListView.setSelectionFromTop((int)(paramInt + f), 0);
      }
    }
    for (;;)
    {
      ((PtrListView)paramListView).smoothScrollToPositionFromTop(paramInt, 0);
      return;
      label59:
      paramListView.setSelectionFromTop((int)(paramInt - f), 0);
    }
  }
  
  public static void scrollToTop(Activity paramActivity, ListView paramListView)
  {
    int j;
    int k;
    if (Build.VERSION.SDK_INT >= 8)
    {
      j = (int)(QMUIHelper.getWindowSize(paramActivity)[1] * 1.5D);
      paramActivity = paramListView.getChildAt(0);
      k = paramListView.getFirstVisiblePosition();
      if (paramActivity == null) {
        break label84;
      }
    }
    label84:
    for (int i = paramActivity.getTop() + paramActivity.getHeight() * k;; i = 0)
    {
      if (i > j) {
        paramListView.setSelectionFromTop(Math.min(j / paramActivity.getHeight(), k), 0);
      }
      paramListView.smoothScrollToPosition(0);
      return;
      paramListView.setSelectionFromTop(0, 0);
      return;
    }
  }
  
  public static void setShowCommercialAdTag(View paramView, boolean paramBoolean)
  {
    ((MailListItemView)paramView).getItemData().isShowCommercialAdTag = paramBoolean;
  }
  
  public static abstract interface OnHandleListScroll
  {
    public abstract void onScrollFlingSpeed(float paramFloat, int paramInt1, int paramInt2);
    
    public abstract void onScrollIdle(int paramInt1, int paramInt2);
    
    public abstract void onScrollToEnd(ListView paramListView);
    
    public abstract void onTouchScrollSpeed(float paramFloat, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnHandleNextUnread
  {
    public abstract void onFoundUnread(int paramInt1, int paramInt2);
    
    public abstract boolean onReachEnd(int paramInt);
  }
  
  public static abstract interface OnSmoothScroll
  {
    public abstract boolean onScroll(View paramView, MotionEvent paramMotionEvent);
    
    public abstract boolean onScrollDown(ListView paramListView, float paramFloat);
    
    public abstract boolean onScrollUp(ListView paramListView, float paramFloat);
  }
  
  static class ScrollTracker
    implements View.OnTouchListener
  {
    private final int MAX_DURATION = 6;
    private final int MIN_DISTANCE = 100;
    private int duration = 0;
    private ListViewHelper.OnSmoothScroll onScrollListener;
    private float y1;
    private float y2;
    
    public ScrollTracker(ListViewHelper.OnSmoothScroll paramOnSmoothScroll)
    {
      this.onScrollListener = paramOnSmoothScroll;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      if (this.onScrollListener.onScroll(paramView, paramMotionEvent)) {
        return true;
      }
      if ((i == 0) || (i == 2)) {
        if (this.duration == 0) {
          this.y1 = paramMotionEvent.getY();
        }
      }
      for (this.duration += 1;; this.duration = 0)
      {
        do
        {
          return false;
        } while ((i != 1) && (i != 3));
        this.y2 = paramMotionEvent.getY();
        float f = this.y2 - this.y1;
        if ((this.duration < 6) && (Math.abs(f) > 100.0F))
        {
          if (f > 0.0F)
          {
            this.duration = 0;
            return this.onScrollListener.onScrollUp((ListView)paramView, Math.abs(f));
          }
          if (f < 0.0F)
          {
            this.duration = 0;
            return this.onScrollListener.onScrollDown((ListView)paramView, Math.abs(f));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.ListViewHelper
 * JD-Core Version:    0.7.0.1
 */