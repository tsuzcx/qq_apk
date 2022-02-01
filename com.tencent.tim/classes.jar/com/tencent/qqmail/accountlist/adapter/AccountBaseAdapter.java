package com.tencent.qqmail.accountlist.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.businessfilter.card.CardSubItemFilter;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.popularize.view.PopularizeFolderSubItems;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAvatarView;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.StringUtils;

public class AccountBaseAdapter
  extends BaseAdapter
  implements ItemScrollListView.ItemScrollAdapter
{
  public static final int ITEM_VIEW_TYPE_BOTTOM = 3;
  public static final int ITEM_VIEW_TYPE_ITEM = 1;
  public static final int ITEM_VIEW_TYPE_SECTION = 0;
  public static final int ITEM_VIEW_TYPE_SINGLE = 4;
  public static final int ITEM_VIEW_TYPE_TOP = 2;
  public static String TAG = AccountBaseAdapter.class.getSimpleName();
  private static WeakHashMap<Integer, Bitmap> mDrawableBitmap = new WeakHashMap();
  protected Context mContext;
  protected List<AccountListUI> mData;
  protected LayoutInflater mInflater;
  protected Map<Integer, ArrayList<PopularizeSubItem>> popularizeSubitems;
  
  public AccountBaseAdapter(Context paramContext, List<AccountListUI> paramList)
  {
    this.mData = paramList;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  private boolean ableDragTo(int paramInt)
  {
    AccountListUI.ITEMTYPE localITEMTYPE = getItemAtIndex(paramInt).mType;
    AccountListUI localAccountListUI = getItemAtIndex(paramInt);
    if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getType() == 140)) {}
    while ((localITEMTYPE == AccountListUI.ITEMTYPE.SECTION) || (localITEMTYPE == AccountListUI.ITEMTYPE.BTN)) {
      return false;
    }
    return true;
  }
  
  private void clearAccountExpUnread(ViewHolder paramViewHolder)
  {
    paramViewHolder.itemUnread.setVisibility(8);
  }
  
  private void formatRightView(int paramInt, HorizontalScrollItemView paramHorizontalScrollItemView, AccountListUI paramAccountListUI)
  {
    TextView localTextView1 = paramHorizontalScrollItemView.getDeleteView();
    TextView localTextView2 = paramHorizontalScrollItemView.getReadView();
    paramHorizontalScrollItemView = paramHorizontalScrollItemView.getTopView();
    if (canRightScroll(paramInt))
    {
      QMFolder localQMFolder = getItemAtIndex(paramInt).mFolder;
      if (QMFolderManager.isAppFolder(localQMFolder))
      {
        ItemScrollListView.formatRightViewStyle(localTextView1, 2);
        localTextView1.setText(2131694597);
        localTextView1.setVisibility(0);
        localTextView2.setVisibility(8);
        return;
      }
      if ((localQMFolder != null) && ((localQMFolder.getType() == -12) || (localQMFolder.getType() == 5) || (localQMFolder.getType() == 6)))
      {
        ItemScrollListView.formatRightViewStyle(localTextView1, 1);
        localTextView1.setText(2131691517);
        ItemScrollListView.formatRightViewStyle(localTextView2, 2);
        localTextView2.setText(2131695662);
        localTextView1.setVisibility(0);
        localTextView2.setVisibility(0);
        return;
      }
      ItemScrollListView.formatRightViewStyle(localTextView2, 2);
      localTextView2.setText(2131695662);
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(0);
      if ((paramAccountListUI.mData != null) && (!paramAccountListUI.mData.isPersistence()) && (!isSendingFolder(localQMFolder)))
      {
        ItemScrollListView.formatRightViewStyle(paramHorizontalScrollItemView, 3);
        paramHorizontalScrollItemView.setText(2131696391);
        paramHorizontalScrollItemView.setVisibility(0);
        return;
      }
      paramHorizontalScrollItemView.setVisibility(8);
      return;
    }
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(8);
  }
  
  private boolean isSendingFolder(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getType() == 103) && (paramQMFolder.getId() == -10);
  }
  
  private void renderBottleUnread(ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      QMLog.log(5, TAG, "renderBottleUnread holder null.");
    }
    do
    {
      return;
      if (paramViewHolder.itemUnread == null)
      {
        QMLog.log(5, TAG, "renderBottleUnread holder.itemUnread null.");
        return;
      }
      localObject = BottleManager.getInstance();
    } while (localObject == null);
    Object localObject = ((BottleManager)localObject).getBottleListController();
    if ((localObject != null) && (((BottleListController)localObject).getBottleUnreadCount() > 0))
    {
      paramViewHolder.itemUnread.setText("" + ((BottleListController)localObject).getBottleUnreadCount());
      if (((BottleListController)localObject).hasNewBottle()) {
        paramViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167626));
      }
      for (;;)
      {
        paramViewHolder.itemUnread.setVisibility(0);
        return;
        paramViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167625));
      }
    }
    paramViewHolder.itemUnread.setVisibility(8);
  }
  
  private void setAccountExpUnread(ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.itemUnread.setVisibility(0);
    paramViewHolder.itemUnread.setText(String.valueOf(paramInt));
    paramViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167179));
    paramViewHolder.itemUnread.setTypeface(Typeface.DEFAULT_BOLD);
  }
  
  private void setPopularizeSubitems()
  {
    this.popularizeSubitems = new HashMap();
    if ((this.mData != null) && (this.mData.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mData.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (AccountListUI)localIterator.next();
        if ((((AccountListUI)localObject).mType == AccountListUI.ITEMTYPE.ITEM) && (((AccountListUI)localObject).mFolder != null) && ((((AccountListUI)localObject).mFolder.getType() == 130) || (((AccountListUI)localObject).mFolder.getType() == 140) || (((AccountListUI)localObject).mFolder.getId() == -23))) {
          if (((AccountListUI)localObject).mFolder.getId() == -23)
          {
            localObject = PopularizeManager.sharedInstance().getPopularizeSubItem(new CardSubItemFilter());
            if (((HashMap)localObject).size() > 0)
            {
              localObject = ((HashMap)localObject).values().iterator();
              if (((Iterator)localObject).hasNext())
              {
                localObject = (ArrayList)((Iterator)localObject).next();
                this.popularizeSubitems.put(Integer.valueOf(-23), localObject);
              }
            }
          }
          else
          {
            localArrayList.add(Integer.valueOf(((AccountListUI)localObject).mFolder.getId()));
          }
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.popularizeSubitems.putAll(PopularizeUIHelper.getFolderPopularizeSubItems(localArrayList, 1));
      }
    }
  }
  
  public boolean canRightScroll(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.mData.size())) {
      throw new IllegalStateException("out of length! position:" + paramInt);
    }
    AccountListUI localAccountListUI = getItemAtIndex(paramInt);
    if (localAccountListUI == null) {}
    do
    {
      return false;
      if (localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM_ACCOUNT) {
        return true;
      }
    } while (localAccountListUI.mFolder == null);
    if (localAccountListUI.mFolder.getType() == 103)
    {
      switch (localAccountListUI.mFolder.getId())
      {
      case -21: 
      case -20: 
      case -19: 
      case -17: 
      case -15: 
      case -14: 
      case -8: 
      case -7: 
      case -6: 
      default: 
        return false;
      }
      return true;
    }
    if (localAccountListUI.mFolder.getId() == -14) {
      return true;
    }
    switch (localAccountListUI.mFolder.getType())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int getBottomPos(int paramInt)
  {
    int i = getCount();
    while (paramInt < i)
    {
      if (!ableDragTo(paramInt)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public int getCount()
  {
    if (this.mData != null) {
      return this.mData.size();
    }
    return 0;
  }
  
  public List<AccountListUI> getData()
  {
    return this.mData;
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public AccountListUI getItemAtIndex(int paramInt)
  {
    return (AccountListUI)this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItemAtIndex(paramInt).mType == AccountListUI.ITEMTYPE.SECTION) {
      return 0;
    }
    if ((paramInt == 0) || (getItemAtIndex(paramInt - 1).mType == AccountListUI.ITEMTYPE.SECTION))
    {
      if (paramInt == getCount() - 1) {
        return 4;
      }
      return 2;
    }
    if ((paramInt == getCount() - 1) || (getItemAtIndex(paramInt + 1).mType == AccountListUI.ITEMTYPE.SECTION)) {
      return 3;
    }
    return 1;
  }
  
  public int getTopDivPos(int paramInt)
  {
    while (paramInt >= 0)
    {
      if (!ableDragTo(paramInt)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = getItemViewType(paramInt);
    AccountListUI localAccountListUI = getItemAtIndex(paramInt);
    Object localObject1;
    if (k == 0)
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = this.mInflater.inflate(2131559340, paramViewGroup, false);
        paramView = new ViewHolder();
        paramView.sectionname = ((TextView)((View)localObject1).findViewById(2131379185));
        ((View)localObject1).setTag(paramView);
      }
      ((ViewHolder)((View)localObject1).getTag()).sectionname.setText(localAccountListUI.mSectionName);
      paramView = (View)localObject1;
      label91:
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mInflater.inflate(2131559338, paramViewGroup, false);
      localObject1 = new ViewHolder();
      ((ViewHolder)localObject1).leftContainer = ((LinearLayout)paramView.findViewById(2131367372));
      ((ViewHolder)localObject1).itemname = ((TextView)paramView.findViewById(2131367376));
      ((ViewHolder)localObject1).itemAccountName = ((TextView)paramView.findViewById(2131361949));
      ((ViewHolder)localObject1).itemIcon = ((ImageView)paramView.findViewById(2131367367));
      ((ViewHolder)localObject1).itemAvatar = ((QMAvatarView)paramView.findViewById(2131361912));
      ((ViewHolder)localObject1).checkbox = ((CheckBox)paramView.findViewById(2131367365));
      ((ViewHolder)localObject1).handler = ((ImageView)paramView.findViewById(2131367366));
      ((ViewHolder)localObject1).arrow = ((ImageView)paramView.findViewById(2131367364));
      ((ViewHolder)localObject1).itemUnread = ((TextView)paramView.findViewById(2131367377));
      ((ViewHolder)localObject1).subitems = ((PopularizeFolderSubItems)paramView.findViewById(2131367375));
      paramView = ItemScrollListView.wrap(paramView);
      paramView.setTag(localObject1);
    }
    label670:
    label698:
    label1012:
    label1653:
    label3064:
    label3067:
    for (;;)
    {
      localObject1 = getItemAtIndex(paramInt);
      formatRightView(paramInt, (HorizontalScrollItemView)paramView, (AccountListUI)localObject1);
      ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
      localViewHolder.data = ((AccountListUI)localObject1);
      localViewHolder.subitems.reset();
      localViewHolder.subitems.setVisibility(8);
      if (localAccountListUI.mType == AccountListUI.ITEMTYPE.BTN)
      {
        localViewHolder.itemname.setText(localAccountListUI.mSectionName + QMUIKit.ELLIPSIZE_FIXED);
        localViewHolder.itemIcon.setVisibility(8);
        localViewHolder.itemAvatar.setVisibility(8);
        localViewHolder.itemAccountName.setVisibility(8);
        localViewHolder.checkbox.setVisibility(8);
        localViewHolder.handler.setVisibility(8);
        localViewHolder.arrow.setVisibility(0);
        localViewHolder.itemUnread.setVisibility(8);
        paramView.setContentDescription(localAccountListUI.mSectionName);
        localObject1 = (KeepPressedRelativeLayout)((HorizontalScrollItemView)paramView).getContentView();
        if (paramInt == getCount() - 1)
        {
          ((KeepPressedRelativeLayout)localObject1).setDrawDivider(false, true);
          ((KeepPressedRelativeLayout)localObject1).updateDividerInsetLeft(0, localViewHolder.getInsetLeft(this.mContext));
        }
        for (;;)
        {
          localViewHolder.leftContainer.addOnLayoutChangeListener(new AccountBaseAdapter.1(this, (KeepPressedRelativeLayout)localObject1, localViewHolder));
          localObject1 = paramView;
          break;
          ((KeepPressedRelativeLayout)localObject1).setDrawDivider(false, false);
        }
      }
      localViewHolder.itemname.setText(localAccountListUI.mItemName + QMUIKit.ELLIPSIZE_FIXED);
      if (localViewHolder.data.mAccount != null)
      {
        localViewHolder.itemAccountName.setText(localViewHolder.data.mAccount.getEmail() + QMUIKit.ELLIPSIZE_FIXED);
        if ((localViewHolder.data.mData != null) && (!localViewHolder.data.mData.isPersistence()))
        {
          localViewHolder.itemAccountName.setVisibility(0);
          if (!TextUtils.isEmpty(localViewHolder.data.mAccount.getEmail())) {
            break label1653;
          }
          localViewHolder.itemname.setText(2131689702);
          localViewHolder.arrow.setImageBitmap(null);
          if (localAccountListUI.mType != AccountListUI.ITEMTYPE.ITEM_ACCOUNT) {
            break label1704;
          }
          localViewHolder.itemIcon.setVisibility(8);
          localViewHolder.itemAvatar.setVisibility(8);
          if ("-1".equals(localAccountListUI.mAccount.getPwd())) {
            localViewHolder.arrow.setImageResource(2130840938);
          }
        }
      }
      int j;
      int i;
      int m;
      Object localObject2;
      do
      {
        j = 0;
        i = 0;
        if ((localAccountListUI.mType != AccountListUI.ITEMTYPE.ITEM) || (localAccountListUI.mFolder == null) || ((localAccountListUI.mFolder.getType() != 130) && (localAccountListUI.mFolder.getType() != 140) && (localAccountListUI.mFolder.getId() != -23))) {
          break label2504;
        }
        localObject1 = (ArrayList)this.popularizeSubitems.get(Integer.valueOf(localAccountListUI.mFolder.getId()));
        if ((localAccountListUI.mFolder.getType() != 140) || ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))) {
          break label2172;
        }
        if (!FolderDataManager.sharedInstance().isShowInnerBottleUnread())
        {
          i = j;
          if (!FolderDataManager.sharedInstance().isShowInnerFtnUnread()) {
            break label3067;
          }
        }
        localViewHolder.subitems.setVisibility(0);
        localObject1 = QMApplicationContext.sharedInstance().getResources().getDrawable(2130840969);
        localViewHolder.subitems.setImage((Drawable)localObject1, 3);
        i = 0;
        if (isEnabled(paramInt)) {
          break label2642;
        }
        localViewHolder.itemname.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167531));
        if (Build.VERSION.SDK_INT > 10)
        {
          localViewHolder.itemIcon.setAlpha(0.5F);
          localViewHolder.itemAvatar.setAlpha(0.5F);
          localViewHolder.subitems.setAlpha(0.5F);
        }
        j = QMFolderManager.sharedInstance().getDisplayUnreadCount(localAccountListUI.mFolder);
        if ((localAccountListUI.mType != AccountListUI.ITEMTYPE.ITEM) || (j <= 0)) {
          break label2733;
        }
        localViewHolder.itemUnread.setText(String.valueOf(j));
        if (!QMFolderManager.sharedInstance().hasNewMail(localAccountListUI.mFolder)) {
          break label2700;
        }
        localViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167626));
        localViewHolder.itemUnread.setTypeface(Typeface.DEFAULT_BOLD);
        localViewHolder.itemUnread.setVisibility(0);
        if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getType() == 1) && (i != 0)) {
          localViewHolder.itemUnread.setVisibility(8);
        }
        if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getId() == -5))
        {
          localObject1 = FtnManager.sharedInstance();
          if (localObject1 == null) {
            break label3003;
          }
          m = ((FtnManager)localObject1).getAccountId();
          if (!((FtnManager)localObject1).isFtnExpUnreadNeedShow()) {
            break label2985;
          }
          setAccountExpUnread(localViewHolder, ((FtnManager)localObject1).getFtnExpUnreadCount());
          ((FtnManager)localObject1).setFtnExpUnreadShow(m, true);
          ((FtnManager)localObject1).setAccessFtnBefore(m, false);
        }
        if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getType() == 130) && (i == 0))
        {
          localObject1 = PopularizeUIHelper.getPopularizeItemSubInfoData(localAccountListUI.mFolder.getId());
          if ((localObject1 == null) || (((String)localObject1).equals(""))) {
            break label3016;
          }
          localViewHolder.itemUnread.setText((CharSequence)localObject1);
          localViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167626));
          localViewHolder.itemUnread.setVisibility(0);
        }
        localViewHolder.checkbox.setVisibility(8);
        localViewHolder.handler.setVisibility(8);
        localViewHolder.arrow.setVisibility(0);
        localObject2 = localAccountListUI.mItemName;
        localObject1 = localObject2;
        if (((String)localObject2).equals(QMApplicationContext.sharedInstance().getString(2131695181))) {
          localObject1 = (String)localObject2 + QMApplicationContext.sharedInstance().getString(2131720820);
        }
        localObject2 = localObject1;
        if (j > 0) {
          localObject2 = (String)localObject1 + String.format(QMApplicationContext.sharedInstance().getString(2131720859), new Object[] { Integer.valueOf(j) });
        }
        localObject1 = localObject2;
        if (localAccountListUI.mFolder != null) {
          break label3064;
        }
        localObject1 = localObject2;
        if (localAccountListUI.mItemName == null) {
          break label3064;
        }
        localObject2 = QMApplicationContext.sharedInstance().getString(2131720797) + localAccountListUI.mItemName;
        localObject1 = localObject2;
        if (localAccountListUI.accUnreadCount <= 0) {
          break label3064;
        }
        localObject1 = (String)localObject2 + String.format(QMApplicationContext.sharedInstance().getString(2131720859), new Object[] { Integer.valueOf(localAccountListUI.accUnreadCount) });
        localObject2 = (KeepPressedRelativeLayout)((HorizontalScrollItemView)paramView).getContentView();
        switch (k)
        {
        default: 
          localViewHolder.leftContainer.addOnLayoutChangeListener(new AccountBaseAdapter.2(this, (KeepPressedRelativeLayout)localObject2, localViewHolder));
          paramView.setContentDescription((CharSequence)localObject1);
          localObject1 = paramView;
          break label91;
          localViewHolder.itemAccountName.setVisibility(8);
          break label670;
          localViewHolder.itemname.setText(localViewHolder.data.mItemName + QMUIKit.ELLIPSIZE_FIXED);
          break label698;
          localViewHolder.itemAccountName.setVisibility(8);
          break label698;
          if (localAccountListUI.mType != AccountListUI.ITEMTYPE.ITEM) {
            break label2149;
          }
        }
      } while (localViewHolder.data.mFolder == null);
      if ((localViewHolder.data.mFolder.getType() == 1) && (localViewHolder.data.mFolder.getId() != -1)) {
        if (localViewHolder.data.mAccount == null) {
          break label3070;
        }
      }
      label2172:
      label3070:
      for (localObject1 = QMPrivateProtocolManager.getPhotoBitmapByEmail(localViewHolder.data.mAccount.getEmail(), 4);; localObject1 = null)
      {
        localViewHolder.itemIcon.setVisibility(8);
        localViewHolder.itemAvatar.setVisibility(0);
        i = 0;
        if (localObject1 != null) {
          i = localObject1.hashCode();
        }
        Object localObject3;
        for (;;)
        {
          if (i == 0) {
            break label1956;
          }
          localObject3 = (Bitmap)mDrawableBitmap.get(Integer.valueOf(i));
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            if (!((Bitmap)localObject3).isRecycled()) {}
          }
          else
          {
            localObject2 = localViewHolder.itemAvatar.generateAvatar((Bitmap)localObject1, localViewHolder.data.mAccount.getEmail());
            mDrawableBitmap.put(Integer.valueOf(i), localObject2);
          }
          localViewHolder.itemAvatar.setAvatarBitmap((Bitmap)localObject2);
          break;
          if (localViewHolder.data.mAccount.getEmail() != null)
          {
            i = localViewHolder.data.mAccount.getEmail().hashCode();
            QMPrivateProtocolManager.sharedInstance().loadEmailIcon(localViewHolder.data.mAccount.getEmail());
          }
        }
        localViewHolder.itemAvatar.setAvatar((Bitmap)localObject1, localViewHolder.data.mAccount.getEmail());
        break;
        if (localViewHolder.data.mFolder.getType() == 130)
        {
          localObject1 = PopularizeUIHelper.getPopularizeItemImage(localViewHolder.data.mFolder.getId());
          localViewHolder.itemIcon.setVisibility(0);
          localViewHolder.itemAvatar.setVisibility(8);
          if (localObject1 != null)
          {
            localViewHolder.itemIcon.setImageBitmap((Bitmap)localObject1);
            break;
          }
          i = QMUIHelper.getDrawableByFolder(localViewHolder.data.mFolder.getId(), localViewHolder.data.mFolder.getType());
          localViewHolder.itemIcon.setImageResource(i);
          break;
        }
        i = QMUIHelper.getDrawableByFolder(localViewHolder.data.mFolder.getId(), localViewHolder.data.mFolder.getType());
        localViewHolder.itemIcon.setVisibility(0);
        localViewHolder.itemIcon.setImageResource(i);
        localViewHolder.itemAvatar.setVisibility(8);
        break;
        localViewHolder.itemIcon.setVisibility(8);
        localViewHolder.itemAvatar.setVisibility(8);
        break;
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((ArrayList)localObject1).size() > 0)
          {
            localViewHolder.subitems.setVisibility(0);
            localObject2 = PopularizeUIHelper.getPopularizePosSubItems((ArrayList)localObject1, 2);
            localObject1 = PopularizeUIHelper.getPopularizePosSubItems((ArrayList)localObject1, 3);
            if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
            {
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (PopularizeSubItem)((Iterator)localObject2).next();
                if (!StringUtils.isBlank(((PopularizeSubItem)localObject3).getImageUrl()))
                {
                  localObject3 = PopularizeThumbManager.sharedInstance().getPopularizeThumb(((PopularizeSubItem)localObject3).getImageUrl());
                  if (localObject3 != null)
                  {
                    localObject3 = new BitmapDrawable(QMApplicationContext.sharedInstance().getResources(), (Bitmap)localObject3);
                    localViewHolder.subitems.setImage((Drawable)localObject3, 2);
                  }
                }
                else if (!StringUtils.isBlank(((PopularizeSubItem)localObject3).getText()))
                {
                  localViewHolder.subitems.setText(((PopularizeSubItem)localObject3).getText(), 2);
                }
              }
            }
            i = j;
            if (localObject1 != null)
            {
              i = j;
              if (((ArrayList)localObject1).size() > 0)
              {
                j = 1;
                localObject1 = ((ArrayList)localObject1).iterator();
                for (;;)
                {
                  i = j;
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localObject2 = (PopularizeSubItem)((Iterator)localObject1).next();
                  if ((StringUtils.isBlank(((PopularizeSubItem)localObject2).getText())) && (!StringUtils.isBlank(((PopularizeSubItem)localObject2).getImageUrl())))
                  {
                    localObject2 = PopularizeThumbManager.sharedInstance().getPopularizeThumb(((PopularizeSubItem)localObject2).getImageUrl());
                    if (localObject2 != null)
                    {
                      localObject2 = new BitmapDrawable(QMApplicationContext.sharedInstance().getResources(), (Bitmap)localObject2);
                      localViewHolder.subitems.setImage((Drawable)localObject2, 3);
                    }
                  }
                  else if (!StringUtils.isBlank(((PopularizeSubItem)localObject2).getText()))
                  {
                    localViewHolder.subitems.setText(((PopularizeSubItem)localObject2).getText(), 3);
                  }
                }
                if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getType() == 1))
                {
                  if ((QMNetworkUtils.isNetworkConnected()) && (!QMSyncErrorManager.sharedInstance().isNetworkUnavailable()))
                  {
                    j = QMSyncErrorManager.sharedInstance().getSyncErrorCode(localAccountListUI.mFolder.getAccountId());
                    if ((j == 4) || (j == 3))
                    {
                      localViewHolder.subitems.setVisibility(0);
                      localViewHolder.subitems.setImage(QMApplicationContext.sharedInstance().getResources().getDrawable(2130840922), 3);
                      i = 1;
                      break label943;
                    }
                    localViewHolder.subitems.setVisibility(8);
                    break label943;
                  }
                  localViewHolder.subitems.setVisibility(8);
                  break label943;
                }
                localViewHolder.subitems.setVisibility(8);
                break label943;
                localViewHolder.itemname.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167519));
                if (Build.VERSION.SDK_INT <= 10) {
                  break label1012;
                }
                localViewHolder.itemIcon.setAlpha(1.0F);
                localViewHolder.itemAvatar.setAlpha(1.0F);
                localViewHolder.subitems.setAlpha(1.0F);
                break label1012;
                localViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167625));
                localViewHolder.itemUnread.setTypeface(Typeface.DEFAULT);
                break label1098;
                if ((localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM_ACCOUNT) && (localAccountListUI.accUnreadCount > 0))
                {
                  localViewHolder.itemUnread.setText(String.valueOf(localAccountListUI.accUnreadCount));
                  if (localAccountListUI.accHasNewMail)
                  {
                    localViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167626));
                    localViewHolder.itemUnread.setTypeface(Typeface.DEFAULT_BOLD);
                  }
                  for (;;)
                  {
                    localViewHolder.itemUnread.setVisibility(0);
                    break;
                    localViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167625));
                    localViewHolder.itemUnread.setTypeface(Typeface.DEFAULT);
                  }
                }
                if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getId() == -10) && (localAccountListUI.accUnreadCount > 0))
                {
                  localViewHolder.itemUnread.setText("" + localAccountListUI.accUnreadCount);
                  localViewHolder.itemUnread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167625));
                  localViewHolder.itemUnread.setVisibility(0);
                  break label1107;
                }
                if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getId() == -16))
                {
                  renderBottleUnread(localViewHolder);
                  break label1107;
                }
                localViewHolder.itemUnread.setVisibility(8);
                break label1107;
                clearAccountExpUnread(localViewHolder);
                ((FtnManager)localObject1).setFtnExpUnreadShow(m, false);
                break label1208;
                localViewHolder.itemUnread.setVisibility(8);
                break label1217;
                localViewHolder.itemUnread.setVisibility(8);
                break label1310;
                ((KeepPressedRelativeLayout)localObject2).setDrawDivider(false, true);
                ((KeepPressedRelativeLayout)localObject2).updateDividerInsetLeft(0, localViewHolder.getInsetLeft(this.mContext));
                break label1608;
                ((KeepPressedRelativeLayout)localObject2).setDrawDivider(false, false);
                break label1608;
                break label1564;
              }
            }
          }
        }
        break label943;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return getItemAtIndex(paramInt).mType != AccountListUI.ITEMTYPE.SECTION;
  }
  
  public int isEnabledScroll(int paramInt)
  {
    if (canRightScroll(paramInt)) {
      return 2;
    }
    return 0;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void setAccountListUI(List<AccountListUI> paramList)
  {
    this.mData = paramList;
    setPopularizeSubitems();
    notifyDataSetChanged();
  }
  
  public void setMyAppUnreadRedDot(ListView paramListView)
  {
    int j = paramListView.getFirstVisiblePosition();
    int i = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    while (i >= j)
    {
      if (i >= k)
      {
        Object localObject = getItemAtIndex(i - k);
        if ((localObject != null) && (((AccountListUI)localObject).mType == AccountListUI.ITEMTYPE.ITEM) && (((AccountListUI)localObject).mFolder != null) && (((AccountListUI)localObject).mFolder.getType() == 140))
        {
          ViewHolder localViewHolder = (ViewHolder)paramListView.getChildAt(i - j).getTag();
          localObject = (ArrayList)this.popularizeSubitems.get(Integer.valueOf(((AccountListUI)localObject).mFolder.getId()));
          if (((localObject == null) || (((ArrayList)localObject).size() == 0)) && ((FolderDataManager.sharedInstance().isShowInnerBottleUnread()) || (FolderDataManager.sharedInstance().isShowInnerFtnUnread())))
          {
            localViewHolder.subitems.setVisibility(0);
            localObject = QMApplicationContext.sharedInstance().getResources().getDrawable(2130840969);
            localViewHolder.subitems.setImage((Drawable)localObject, 3);
          }
        }
      }
      i -= 1;
    }
  }
  
  public void updateAvatar(ListView paramListView)
  {
    int j = paramListView.getFirstVisiblePosition();
    ViewHolder localViewHolder;
    Bitmap localBitmap3;
    int i;
    if (j < paramListView.getLastVisiblePosition()) {
      if (paramListView.getChildAt(j) != null)
      {
        localViewHolder = (ViewHolder)paramListView.getChildAt(j).getTag();
        if ((localViewHolder != null) && (localViewHolder.data != null) && (localViewHolder.data.mAccount != null))
        {
          localBitmap3 = QMPrivateProtocolManager.getPhotoBitmapByEmail(localViewHolder.data.mAccount.getEmail(), 4);
          if (localBitmap3 == null) {
            break label175;
          }
          i = localBitmap3.hashCode();
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        Bitmap localBitmap2 = (Bitmap)mDrawableBitmap.get(Integer.valueOf(i));
        Bitmap localBitmap1;
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap2.isRecycled()) {}
        }
        else
        {
          localBitmap1 = localViewHolder.itemAvatar.generateAvatar(localBitmap3, localViewHolder.data.mAccount.getEmail());
          mDrawableBitmap.put(Integer.valueOf(i), localBitmap1);
        }
        localViewHolder.itemAvatar.setAvatarBitmap(localBitmap1);
      }
      j += 1;
      break;
      label175:
      if (localViewHolder.data.mAccount.getEmail() != null) {
        i = localViewHolder.data.mAccount.getEmail().hashCode();
      } else {
        i = 0;
      }
    }
  }
  
  public void updateBottleUnread(ListView paramListView)
  {
    int j = paramListView.getFirstVisiblePosition();
    int i = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    while (i >= j)
    {
      if ((this.mData != null) && (this.mData.size() > i) && (i - k >= 0))
      {
        AccountListUI localAccountListUI = getItemAtIndex(i - k);
        if ((localAccountListUI != null) && (localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM) && (localAccountListUI.mFolder.getId() == -16)) {
          renderBottleUnread((ViewHolder)paramListView.getChildAt(i - j).getTag());
        }
      }
      i -= 1;
    }
  }
  
  public static class ViewHolder
  {
    public ImageView arrow;
    public CheckBox checkbox;
    public AccountListUI data;
    public ImageView handler;
    public TextView itemAccountName;
    public QMAvatarView itemAvatar;
    public ImageView itemIcon;
    public TextView itemUnread;
    public TextView itemname;
    public LinearLayout leftContainer;
    public TextView sectionname;
    public PopularizeFolderSubItems subitems;
    
    public int getInsetLeft(Context paramContext)
    {
      int j = paramContext.getResources().getDimensionPixelSize(2131297032);
      int i = j;
      if (this.leftContainer != null)
      {
        i = j;
        if (this.leftContainer.getVisibility() != 8) {
          i = j + this.leftContainer.getWidth();
        }
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter
 * JD-Core Version:    0.7.0.1
 */