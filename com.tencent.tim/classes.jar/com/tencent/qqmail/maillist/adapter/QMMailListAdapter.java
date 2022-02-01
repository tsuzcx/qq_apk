package com.tencent.qqmail.maillist.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.maillist.view.MailListItemView.MailListItemData;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.cursor.QMFolderCursor;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.nativepages.NativeAdsHelper;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.CommercialAdvertiseEnum;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeMailListItemView;
import com.tencent.qqmail.utilities.ConcurrentHashSet;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import moai.oss.KvHelper;

public class QMMailListAdapter
  extends ArrayAdapter<Object>
  implements ItemScrollListView.ItemScrollAdapter
{
  public static final int ITEM_VIEW_TYPE_LOAD_MORE = 1;
  public static final int ITEM_VIEW_TYPE_MAIL = 0;
  public static final int MORELOADING_HIDE = -1;
  public static final int MORELOADING_LOADING = 1;
  public static final int MORELOADING_NORMAL = 0;
  private static final String TAG = "QMMailListAdapter";
  private QMAvatar avatarTool = new QMAvatar();
  private Mail[] cacheItem = null;
  protected final Context context;
  public IMailListCursor cursor;
  private ConcurrentHashSet<Long> hitMailIds;
  private boolean isEditing;
  private ListView listView;
  private HashMap<Long, String> mailAbsCache = new HashMap();
  private int moreLoadingState;
  @NonNull
  protected ArrayList<Popularize> popularizedData = new ArrayList();
  private boolean showAvatar;
  private boolean[] whichRightViewShow = { 1, 1 };
  
  public QMMailListAdapter(Context paramContext, int paramInt, IMailListCursor paramIMailListCursor, ListView paramListView)
  {
    super(paramContext, paramInt);
    this.listView = paramListView;
    this.cursor = paramIMailListCursor;
    this.context = paramContext;
    this.showAvatar = QMSettingManager.sharedInstance().getMailListIcon();
    this.hitMailIds = new ConcurrentHashSet();
  }
  
  public int getCount()
  {
    if (this.cursor != null)
    {
      if (this.cursor.canLoadMore()) {
        return this.cursor.getCount() + 1;
      }
      return this.cursor.getCount();
    }
    return -1;
  }
  
  public IMailListCursor getCursor()
  {
    return this.cursor;
  }
  
  public ConcurrentHashSet<Long> getHitMailIds()
  {
    return this.hitMailIds;
  }
  
  public Mail getItem(int paramInt)
  {
    if (this.cursor == null) {}
    do
    {
      return null;
      if ((this.cacheItem == null) || (this.cursor.getCount() != this.cacheItem.length)) {
        this.cacheItem = new Mail[this.cursor.getCount()];
      }
    } while ((paramInt >= this.cacheItem.length) || (paramInt <= -1));
    if (this.cacheItem[paramInt] == null) {
      this.cacheItem[paramInt] = this.cursor.getItem(paramInt);
    }
    return this.cacheItem[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    Mail localMail = getItem(paramInt);
    if (localMail == null) {
      return 0L;
    }
    return localMail.getInformation().getId();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getMoreLoadingState() > -1) && (paramInt >= 0) && (this.cursor.canLoadMore()) && (paramInt >= this.cursor.getCount())) {
      return 1;
    }
    return 0;
  }
  
  public int getMoreLoadingState()
  {
    return this.moreLoadingState;
  }
  
  @NonNull
  public ArrayList<Popularize> getPopularizedData()
  {
    return this.popularizedData;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      if ((paramView != null) && ((paramView instanceof MailListMoreItemView))) {
        break label1307;
      }
      paramView = new MailListMoreItemView(this.context);
    }
    label658:
    label1301:
    label1307:
    for (;;)
    {
      Object localObject1 = (MailListMoreItemView)paramView;
      if (getMoreLoadingState() == 1)
      {
        ((MailListMoreItemView)localObject1).showLoading(true);
        ((MailListMoreItemView)localObject1).setEnabled(false);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
      ((MailListMoreItemView)localObject1).showLoading(false);
      if (!isEditing()) {}
      for (boolean bool = true;; bool = false)
      {
        ((MailListMoreItemView)localObject1).setEnabled(bool);
        if (getCursor().getState() != -1) {
          break;
        }
        ((MailListMoreItemView)localObject1).setEnabled(false);
        ((MailListMoreItemView)localObject1).invalidate();
        break;
      }
      Object localObject4;
      Object localObject5;
      Object localObject3;
      Object localObject2;
      int i;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        localObject1 = ListViewHelper.bindItemData(paramInt, null, this, this.showAvatar);
        paramView = ItemScrollListView.wrap((View)localObject1);
        localObject4 = QMUIKit.ELLIPSIZE_FIXED;
        localObject5 = getItem(paramInt);
        if (localObject5 == null) {
          break label1292;
        }
        localObject3 = ((Mail)localObject5).getInformation();
        localObject2 = ((HorizontalScrollItemView)paramView).getDeleteView();
        if (this.whichRightViewShow[0] == 0) {
          break label870;
        }
        if (((Mail)localObject5).getStatus() == null)
        {
          ValidateHelper.assertInDebug("mail status is null", false);
          ((Mail)localObject5).setStatus(new MailStatus());
        }
        if (!((Mail)localObject5).getStatus().isConversation()) {
          break label1301;
        }
        i = ((Mail)localObject5).getInformation().getConvCount();
        if (i <= 1) {
          break label1301;
        }
      }
      for (;;)
      {
        ItemScrollListView.formatRightViewStyle((TextView)localObject2, 1);
        if (i > 1)
        {
          ((TextView)localObject2).setText(this.context.getString(2131695605, new Object[] { Integer.valueOf(i) }));
          label292:
          ((TextView)localObject2).setVisibility(0);
          label298:
          localObject2 = ((HorizontalScrollItemView)paramView).getReadView();
          if (this.whichRightViewShow[1] == 0) {
            break label891;
          }
          ItemScrollListView.formatRightViewStyle((TextView)localObject2, 2);
          if ((!((Mail)localObject5).getStatus().isUnread()) && (!((Mail)localObject5).getStatus().isAdConv())) {
            break label880;
          }
          ((TextView)localObject2).setText(2131695668);
          label352:
          ((TextView)localObject2).setVisibility(0);
          label358:
          this.hitMailIds.add(Long.valueOf(((MailInformation)localObject3).getId()));
          ((View)localObject1).setTag(paramInt + "#" + ((View)localObject1).getTag());
          paramView.setTag(((View)localObject1).getTag());
          localObject2 = ((MailInformation)localObject3).getAbstractContent();
          if ((localObject2 != null) && (!((String)localObject2).trim().equals(""))) {
            break label1298;
          }
          localObject2 = this.context.getResources().getString(2131693123);
        }
        for (;;)
        {
          label495:
          long l1;
          if (this.mailAbsCache == null)
          {
            ((MailListItemView)localObject1).getItemData().abstractText = ((String)localObject2 + (String)localObject4);
            if (!((Mail)localObject5).getStatus().isAdConv()) {
              break label1292;
            }
            localObject2 = new StringBuilder();
            l1 = ((MailInformation)localObject3).getDate().getTime();
            long l2 = QMSharedPreferenceManager.getInstance().getAdvertiseMailReadTime();
            QMLog.log(4, "QMMailListAdapter", "latestAdsMailTime = " + l1 + " virtrulAdsMailReadTime = " + l2);
            if ((l2 <= 0L) || (l1 <= l2)) {
              break label1059;
            }
            bool = true;
            label589:
            if (!NativeAdsHelper.getInstance().isLockForUpdateMaillistExposeState()) {
              break label1295;
            }
            QMLog.log(4, "QMMailListAdapter", "set newMailAfterAdvertise false because of isLockForUpdateMaillistExposeState");
            bool = false;
          }
          for (;;)
          {
            if ((localObject1 != null) && (((MailListItemView)localObject1).getItemData() != null) && (this.popularizedData != null))
            {
              localObject3 = ((MailListItemView)localObject1).getItemData();
              ((MailListItemView.MailListItemData)localObject3).isShowNativeAdsPro = false;
              localObject4 = this.popularizedData.iterator();
              for (;;)
              {
                if (!((Iterator)localObject4).hasNext()) {
                  break label1292;
                }
                localObject5 = (Popularize)((Iterator)localObject4).next();
                if (((Popularize)localObject5).getType() == 9)
                {
                  Object localObject6 = ((Popularize)localObject5).getCommercialAdvertiseType();
                  QMLog.log(4, "QMMailListAdapter", "commercialAdvertiseEnum = " + localObject6 + "popularize isRead = " + ((Popularize)localObject5).isRead() + " newMailAfterAdvertise = " + bool);
                  if ((localObject6 == CommercialAdvertiseEnum.NATIVE_ADS_PRO) && (!((Popularize)localObject5).isPopByNewMail())) {
                    if ((((Popularize)localObject5).isRead()) && (bool))
                    {
                      ((Popularize)localObject5).setPopByNewMail(true);
                      PopularizeManager.sharedInstance().updatePopularizePop(((Popularize)localObject5).getId(), true);
                      NativeAdsHelper.getInstance().setIndexOfExposeAdsItemInMailList(-1);
                    }
                  }
                  for (;;)
                  {
                    if (((Popularize)localObject5).isRender()) {
                      break label1290;
                    }
                    ((Popularize)localObject5).setRender(true);
                    NativeAdsHelper.getInstance().maillistAdsItemHasExpose((Popularize)localObject5);
                    break label658;
                    localObject1 = ListViewHelper.bindItemData(paramInt, ((HorizontalScrollItemView)paramView).getContentView(), this, this.showAvatar);
                    if (localObject1 != null) {
                      ((View)localObject1).invalidate();
                    }
                    break;
                    ((TextView)localObject2).setText(2131692498);
                    break label292;
                    label870:
                    ((TextView)localObject2).setVisibility(8);
                    break label298;
                    label880:
                    ((TextView)localObject2).setText(2131695671);
                    break label352;
                    label891:
                    ((TextView)localObject2).setVisibility(8);
                    break label358;
                    l1 = ((Mail)localObject5).getInformation().getId();
                    if ((((Mail)localObject5).getInformation().getAbstractContent() != null) && (((Mail)localObject5).getInformation().getAbstractContent().equals("")) && (this.mailAbsCache.containsKey(Long.valueOf(l1))) && (!((String)this.mailAbsCache.get(Long.valueOf(l1))).equals("")))
                    {
                      ((MailListItemView)localObject1).getItemData().abstractText = ((String)this.mailAbsCache.get(Long.valueOf(l1)) + (String)localObject4);
                      break label495;
                    }
                    ((MailListItemView)localObject1).getItemData().abstractText = ((String)localObject2 + (String)localObject4);
                    break label495;
                    label1059:
                    bool = false;
                    break label589;
                    KvHelper.eventAdMailMailListShow(new double[0]);
                    ((MailListItemView.MailListItemData)localObject3).nickName = ((Popularize)localObject5).getSub_fromnick();
                    ((MailListItemView.MailListItemData)localObject3).subjectTitle = ((Popularize)localObject5).getSub_subject();
                    ((MailListItemView.MailListItemData)localObject3).abstractText = ((Popularize)localObject5).getSub_abstracts();
                    ((MailListItemView.MailListItemData)localObject3).isShowNativeAdsPro = true;
                    if (this.showAvatar)
                    {
                      localObject6 = PopularizeThumbManager.sharedInstance().getPopularizeThumb(((Popularize)localObject5).getAvatar_url());
                      if (localObject6 == null) {
                        break label1187;
                      }
                      localObject6 = ImageUtil.getRoundCornerBitmap((Bitmap)localObject6, Math.min(((Bitmap)localObject6).getWidth(), ((Bitmap)localObject6).getHeight()));
                      ((MailListItemView.MailListItemData)localObject3).avatarBitmap = this.avatarTool.setAvatar((Bitmap)localObject6, "AD");
                    }
                    for (;;)
                    {
                      NativeAdsHelper.getInstance().setLockForUpdateMaillistExposeState(true);
                      NativeAdsHelper.getInstance().setIndexOfExposeAdsItemInMailList(paramInt);
                      break;
                      label1187:
                      NativeAdsHelper.getInstance().makesureAvatarUrlDownload((Popularize)localObject5);
                    }
                    if ((localObject6 == CommercialAdvertiseEnum.VIRTURE_MAIL) || (localObject6 == CommercialAdvertiseEnum.NATIVE_ADS))
                    {
                      KvHelper.eventAdMailMailListShow(new double[0]);
                      ((StringBuilder)localObject2).append(((Popularize)localObject5).getCommercialFromNick()).append("，");
                      ((MailListItemView.MailListItemData)localObject3).abstractText = ((Popularize)localObject5).getAbstracts();
                      if (((Popularize)localObject5).isCommercialConfigList()) {
                        ListViewHelper.setShowCommercialAdTag((View)localObject1, true);
                      }
                      ((StringBuilder)localObject2).append(((MailListItemView.MailListItemData)localObject3).subjectTitle);
                      ((MailListItemView.MailListItemData)localObject3).subjectTitle = ((StringBuilder)localObject2).toString();
                      ((MailListItemView.MailListItemData)localObject3).isShowNativeAdsPro = false;
                    }
                  }
                }
              }
            }
            break;
          }
        }
        i = 0;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEditing()
  {
    return this.isEditing;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return super.isEnabled(paramInt);
  }
  
  public int isEnabledScroll(int paramInt)
  {
    paramInt = getItemViewType(paramInt);
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 0) {
      return 2;
    }
    throw new IllegalStateException("undefined itemViewType in QMMailListAdapter");
  }
  
  public void notifyDataSetChanged()
  {
    this.cacheItem = null;
    super.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.cacheItem = null;
    super.notifyDataSetInvalidated();
  }
  
  public void setCursor(QMFolderCursor paramQMFolderCursor)
  {
    this.cursor = paramQMFolderCursor;
    notifyDataSetChanged();
  }
  
  public void setIsEditing(boolean paramBoolean)
  {
    this.isEditing = paramBoolean;
  }
  
  public void setMailAbsCache(Long paramLong, String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    int j;
    int i;
    label45:
    do
    {
      return;
      this.mailAbsCache.put(paramLong, paramString);
      j = this.listView.getFirstVisiblePosition();
      int k = this.listView.getLastVisiblePosition();
      i = 0;
      if (j > k) {
        break label252;
      }
      localObject1 = this.listView.getChildAt(j);
      if ((!(localObject1 instanceof HorizontalScrollItemView)) || (((HorizontalScrollItemView)localObject1).getContentView() == null) || ((!(((HorizontalScrollItemView)localObject1).getContentView() instanceof MailListItemView)) && (!(((HorizontalScrollItemView)localObject1).getContentView() instanceof PopularizeMailListItemView)))) {
        break label254;
      }
      Object localObject2 = getItem(j - i);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Mail)localObject2).getInformation();
      if ((localObject2 == null) || (((MailInformation)localObject2).getId() != paramLong.longValue())) {
        break;
      }
    } while (!(((HorizontalScrollItemView)localObject1).getContentView() instanceof MailListItemView));
    Object localObject1 = (MailListItemView)((HorizontalScrollItemView)localObject1).getContentView();
    ((MailListItemView)localObject1).getItemData().abstractText = paramString;
    QMLog.log(2, "QMMailListAdapter", "pop-in set mail cache mailid " + paramLong + " abstract " + paramString + " viewtext " + ((MailListItemView)localObject1).getItemData().subjectTitle);
    ((MailListItemView)localObject1).postInvalidate();
    return;
    for (;;)
    {
      j += 1;
      break label45;
      label252:
      break;
      label254:
      i += 1;
    }
  }
  
  public void setMoreLoading()
  {
    setMoreLoadingState(1);
    int j = this.listView.getFirstVisiblePosition();
    int i = this.listView.getLastVisiblePosition();
    while (i >= j)
    {
      View localView = this.listView.getChildAt(i - j);
      if ((localView instanceof MailListMoreItemView))
      {
        ((MailListMoreItemView)localView).showLoading(true);
        localView.setEnabled(false);
        localView.invalidate();
      }
      i -= 1;
    }
  }
  
  public void setMoreLoadingEnabled(boolean paramBoolean)
  {
    int j = this.listView.getFirstVisiblePosition();
    int k = this.listView.getLastVisiblePosition();
    int i = j;
    while (i <= k)
    {
      Object localObject = this.listView.getChildAt(i - j);
      if ((localObject instanceof MailListMoreItemView))
      {
        localObject = (MailListMoreItemView)localObject;
        ((MailListMoreItemView)localObject).setEnabled(paramBoolean);
        ((MailListMoreItemView)localObject).invalidate();
      }
      i += 1;
    }
  }
  
  public void setMoreLoadingNormal(boolean paramBoolean)
  {
    setMoreLoadingState(0);
    int j = this.listView.getFirstVisiblePosition();
    int k = this.listView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      View localView = this.listView.getChildAt(i - j);
      if ((localView instanceof MailListMoreItemView))
      {
        ((MailListMoreItemView)localView).showError(paramBoolean);
        if (isEditing()) {
          break label88;
        }
      }
      label88:
      for (boolean bool = true;; bool = false)
      {
        localView.setEnabled(bool);
        localView.invalidate();
        i += 1;
        break;
      }
    }
  }
  
  public void setMoreLoadingState(int paramInt)
  {
    this.moreLoadingState = paramInt;
  }
  
  public void setPopularizedData(@NonNull ArrayList<Popularize> paramArrayList)
  {
    this.popularizedData = paramArrayList;
  }
  
  public void setWhichRightViewShow(boolean[] paramArrayOfBoolean)
  {
    this.whichRightViewShow = paramArrayOfBoolean;
  }
  
  public void verifyAvatar(List<String> paramList)
  {
    if (this.showAvatar)
    {
      QMAvatar localQMAvatar = new QMAvatar();
      int j = this.listView.getFirstVisiblePosition();
      int k = this.listView.getLastVisiblePosition();
      int i = j;
      if (i <= k)
      {
        View localView = this.listView.getChildAt(i - j);
        Object localObject;
        if ((((localView instanceof MailListItemView)) || ((localView instanceof HorizontalScrollItemView))) && ((localView.getTag() instanceof String)))
        {
          localObject = ((String)localView.getTag()).split("#");
          if (localObject.length != 2) {
            break label195;
          }
          localObject = localObject[1];
          label109:
          if (paramList.contains(localObject)) {
            if (!(localView instanceof MailListItemView)) {
              break label204;
            }
          }
        }
        label195:
        label204:
        for (MailListItemView.MailListItemData localMailListItemData = ((MailListItemView)localView).getItemData();; localMailListItemData = ((MailListItemView)((HorizontalScrollItemView)localView).getContentView()).getItemData())
        {
          localObject = QMPrivateProtocolManager.getPhotoBitmapByEmail((String)localObject, 3);
          if (localObject != null)
          {
            localMailListItemData.avatarBitmap = ListViewHelper.generateAvatar(localQMAvatar, (Bitmap)localObject, localMailListItemData.avatarOptionalName);
            getView(i - this.listView.getHeaderViewsCount(), localView, this.listView);
          }
          i += 1;
          break;
          localObject = localObject[0];
          break label109;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.adapter.QMMailListAdapter
 * JD-Core Version:    0.7.0.1
 */