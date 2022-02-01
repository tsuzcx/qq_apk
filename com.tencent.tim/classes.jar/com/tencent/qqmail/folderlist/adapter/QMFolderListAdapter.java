package com.tencent.qqmail.folderlist.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.mobeta.android.dslv.DragSortListView.DragSortListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.folderlist.model.IListItem;
import com.tencent.qqmail.folderlist.model.IListItem.ItemType;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.businessfilter.card.CardSubItemFilter;
import com.tencent.qqmail.popularize.businessfilter.card.FestivalCardFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.popularize.view.PopularizeFolderSubItems;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.commons.lang3.StringUtils;

public class QMFolderListAdapter
  extends BaseAdapter
  implements DragSortListView.DragSortListener, ItemScrollListView.ItemScrollAdapter
{
  private static WeakHashMap<Integer, Bitmap> mDrawableBitmap = new WeakHashMap();
  private String TAG = QMFolderListAdapter.class.getSimpleName();
  private Set<Integer> activeFolderIds;
  private boolean isEditing = false;
  private int mAccountId;
  protected Context mContext;
  protected List<IListFolder> mData;
  protected LayoutInflater mInflater;
  private int mTotalAccountNum;
  protected Map<Integer, ArrayList<PopularizeSubItem>> popularizeSubitems;
  
  public QMFolderListAdapter(Context paramContext, int paramInt, List<IListFolder> paramList)
  {
    ValidateHelper.notNull(paramList);
    this.mData = paramList;
    this.mAccountId = paramInt;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mTotalAccountNum = AccountManager.shareInstance().getAccountList().size();
  }
  
  private boolean ableDragTo(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject == null) || ((((IListFolder)localObject).getData() != null) && (((QMFolder)((IListFolder)localObject).getData()).getId() == -20))) {
      return false;
    }
    localObject = ((IListFolder)localObject).getType();
    if ((localObject != IListItem.ItemType.SECTION) && (localObject != IListItem.ItemType.BTN)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void clearFolderExpUnread(ViewHolder paramViewHolder)
  {
    paramViewHolder.unread.setVisibility(8);
  }
  
  private void formatRightView(int paramInt, HorizontalScrollItemView paramHorizontalScrollItemView)
  {
    TextView localTextView1 = paramHorizontalScrollItemView.getDeleteView();
    TextView localTextView2 = paramHorizontalScrollItemView.getReadView();
    paramHorizontalScrollItemView = paramHorizontalScrollItemView.getTopView();
    if (canRightScroll(paramInt))
    {
      QMFolder localQMFolder = (QMFolder)getItem(paramInt).getData();
      if (QMFolderManager.isAppFolder(localQMFolder))
      {
        ItemScrollListView.formatRightViewStyle(localTextView1, 2);
        localTextView1.setVisibility(0);
        paramHorizontalScrollItemView.setVisibility(8);
        localTextView2.setVisibility(8);
        if (isInMyApp())
        {
          localTextView1.setText(2131720298);
          return;
        }
        localTextView1.setText(2131694597);
        return;
      }
      if ((localQMFolder.getType() == 5) || (localQMFolder.getType() == 6))
      {
        ItemScrollListView.formatRightViewStyle(localTextView1, 1);
        localTextView1.setText(2131691517);
        localTextView1.setVisibility(0);
        paramHorizontalScrollItemView.setVisibility(8);
        ItemScrollListView.formatRightViewStyle(localTextView2, 2);
        localTextView2.setText(2131695662);
        localTextView2.setVisibility(0);
        return;
      }
      ItemScrollListView.formatRightViewStyle(localTextView2, 2);
      localTextView1.setVisibility(8);
      localTextView2.setText(2131695662);
      localTextView2.setVisibility(0);
      if (shouldShowTop(localQMFolder))
      {
        ItemScrollListView.formatRightViewStyle(paramHorizontalScrollItemView, 3);
        paramHorizontalScrollItemView.setVisibility(0);
        if (this.mTotalAccountNum > 1)
        {
          if (isShowHomeFolderId(localQMFolder))
          {
            paramHorizontalScrollItemView.setText(2131696391);
            return;
          }
          paramHorizontalScrollItemView.setText(2131720298);
          return;
        }
        paramHorizontalScrollItemView.setText(2131695663);
        return;
      }
      paramHorizontalScrollItemView.setVisibility(8);
      return;
    }
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(8);
  }
  
  private boolean isInMyApp()
  {
    return this.mAccountId == 0;
  }
  
  private boolean isMyApp(IListFolder paramIListFolder)
  {
    return (paramIListFolder != null) && (paramIListFolder.getData() != null) && (((QMFolder)paramIListFolder.getData()).getType() == 140);
  }
  
  private boolean isSection(int paramInt)
  {
    if ((paramInt >= getCount()) || (paramInt < 0)) {}
    while (getItem(paramInt).getType() != IListItem.ItemType.SECTION) {
      return false;
    }
    return true;
  }
  
  private void renderBottleUnread(ViewHolder paramViewHolder)
  {
    Object localObject = BottleManager.getInstance();
    if (localObject != null)
    {
      localObject = ((BottleManager)localObject).getBottleListController();
      if (((BottleListController)localObject).getBottleUnreadCount() <= 0) {
        break label104;
      }
      paramViewHolder.unread.setText("" + ((BottleListController)localObject).getBottleUnreadCount());
      if (!((BottleListController)localObject).hasNewBottle()) {
        break label83;
      }
      paramViewHolder.unread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167626));
    }
    for (;;)
    {
      paramViewHolder.unread.setVisibility(0);
      return;
      label83:
      paramViewHolder.unread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167625));
    }
    label104:
    paramViewHolder.unread.setVisibility(8);
  }
  
  private void setFolderExpUnread(ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.unread.setVisibility(0);
    paramViewHolder.unread.setText(String.valueOf(paramInt));
    paramViewHolder.unread.setTextColor(QMApplicationContext.sharedInstance().getResources().getColor(2131167179));
    paramViewHolder.unread.setTypeface(Typeface.DEFAULT_BOLD);
  }
  
  private void setPopularizeSubItems(int paramInt)
  {
    this.popularizeSubitems = new HashMap();
    if ((this.mData != null) && (this.mData.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mData.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IListFolder)localIterator.next();
        if (((((IListFolder)localObject).getData() instanceof QMFolder)) && ((((QMFolder)((IListFolder)localObject).getData()).getType() == 130) || (((QMFolder)((IListFolder)localObject).getData()).getType() == 140) || (((QMFolder)((IListFolder)localObject).getData()).getId() == -23))) {
          if (((QMFolder)((IListFolder)localObject).getData()).getId() == -23)
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
            localArrayList.add(Integer.valueOf(((QMFolder)((IListFolder)localObject).getData()).getId()));
          }
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.popularizeSubitems.putAll(PopularizeUIHelper.getFolderPopularizeSubItems(localArrayList, paramInt));
      }
    }
  }
  
  private static boolean shouldShowTop(QMFolder paramQMFolder)
  {
    return (!QMFolderManager.isUniversalSection(paramQMFolder)) && (paramQMFolder.getType() != 14) && (paramQMFolder.getId() != -10);
  }
  
  public boolean canRightScroll(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mData.size())) {
      throw new IllegalStateException("position[" + paramInt + "] out of length[" + this.mData.size() + "]");
    }
    IListFolder localIListFolder = getItem(paramInt);
    if ((localIListFolder == null) || (localIListFolder.getData() == null)) {
      return false;
    }
    if (((QMFolder)localIListFolder.getData()).getType() == 103) {
      switch (((QMFolder)localIListFolder.getData()).getId())
      {
      }
    }
    for (;;)
    {
      return false;
      return true;
      if (((QMFolder)localIListFolder.getData()).getId() == -14) {
        return true;
      }
      switch (((QMFolder)localIListFolder.getData()).getType())
      {
      }
    }
    return true;
  }
  
  public void drag(int paramInt1, int paramInt2) {}
  
  public void drop(int paramInt1, int paramInt2) {}
  
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
  
  public int getChildPositionByFolderId(ListView paramListView, int paramInt)
  {
    int j = paramListView.getFirstVisiblePosition();
    int i = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    while (i >= j)
    {
      if (i >= k)
      {
        paramListView = getItem(i - k);
        if ((paramListView != null) && (paramListView.getData() != null) && (((QMFolder)paramListView.getData()).getId() == paramInt)) {
          return i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public List<IListFolder> getData()
  {
    return this.mData;
  }
  
  public IListFolder getItem(int paramInt)
  {
    return (IListFolder)this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    IListItem.ItemType localItemType;
    if (getItem(paramInt).getType() == IListItem.ItemType.SECTION) {
      localItemType = IListItem.ItemType.SECTION;
    }
    for (;;)
    {
      return localItemType.ordinal();
      if (getItem(paramInt).getType() == IListItem.ItemType.BTN) {
        localItemType = IListItem.ItemType.BTN;
      } else if (((paramInt == 0) && (isSection(1))) || ((isSection(paramInt - 1)) && (paramInt < getCount() - 1) && (isSection(paramInt + 1))) || ((paramInt == getCount() - 1) && (isSection(getCount() - 2)))) {
        localItemType = IListItem.ItemType.SINGLE;
      } else if ((paramInt == 0) || (isSection(paramInt - 1)))
      {
        if (paramInt == 0) {
          localItemType = IListItem.ItemType.FIRST;
        } else {
          localItemType = IListItem.ItemType.TOP;
        }
      }
      else if ((paramInt == getCount() - 1) || (isSection(paramInt + 1))) {
        localItemType = IListItem.ItemType.BOTTOM;
      } else {
        localItemType = IListItem.ItemType.ITEM;
      }
    }
  }
  
  public List<IListFolder> getShouldShowFoldersInTopArea()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mData.iterator();
    while (localIterator.hasNext())
    {
      IListFolder localIListFolder = (IListFolder)localIterator.next();
      if ((localIListFolder.shouldShow()) && (!QMFolderManager.isAppFolder((QMFolder)localIListFolder.getData()))) {
        localArrayList.add(localIListFolder);
      }
    }
    return localArrayList;
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
  
  @SuppressLint({"NewApi"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = getItemViewType(paramInt);
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if (j == IListItem.ItemType.SECTION.ordinal())
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = this.mInflater.inflate(2131559340, paramViewGroup, false);
        paramView = new ViewHolder();
        paramView.sectionname = ((TextView)((View)localObject1).findViewById(2131379185));
        ((View)localObject1).setTag(paramView);
      }
      paramView = (ViewHolder)((View)localObject1).getTag();
      localObject2 = ((IListFolder)localObject2).getSectionName();
      paramView.sectionname.setText((CharSequence)localObject2);
      paramView.data = null;
      paramView = (View)localObject1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mInflater.inflate(2131559338, paramViewGroup, false);
      localObject1 = new ViewHolder();
      ((ViewHolder)localObject1).leftContainer = ((LinearLayout)paramView.findViewById(2131367372));
      ((ViewHolder)localObject1).itemname = ((TextView)paramView.findViewById(2131367376));
      ((ViewHolder)localObject1).itemIcon = ((ImageView)paramView.findViewById(2131367367));
      ((ViewHolder)localObject1).tagIcon = ((ImageView)paramView.findViewById(2131367368));
      ((ViewHolder)localObject1).checkbox = ((CheckBox)paramView.findViewById(2131367365));
      ((ViewHolder)localObject1).handler = ((ImageView)paramView.findViewById(2131367366));
      ((ViewHolder)localObject1).arrow = ((ImageView)paramView.findViewById(2131367364));
      ((ViewHolder)localObject1).unread = ((TextView)paramView.findViewById(2131367377));
      ((ViewHolder)localObject1).subitems = ((PopularizeFolderSubItems)paramView.findViewById(2131367375));
      paramView = ItemScrollListView.wrap(paramView);
      paramView.setTag(localObject1);
    }
    for (;;)
    {
      formatRightView(paramInt, (HorizontalScrollItemView)paramView);
      localObject1 = (ViewHolder)paramView.getTag();
      ((ViewHolder)localObject1).data = getItem(paramInt);
      ((ViewHolder)localObject1).itemname.setText(((IListFolder)localObject2).getName() + QMUIKit.ELLIPSIZE_FIXED);
      ((ViewHolder)localObject1).subitems.reset();
      ((ViewHolder)localObject1).subitems.setVisibility(8);
      if (j == IListItem.ItemType.BTN.ordinal())
      {
        ((ViewHolder)localObject1).itemname.setText(((IListFolder)localObject2).getSectionName() + QMUIKit.ELLIPSIZE_FIXED);
        ((ViewHolder)localObject1).itemIcon.setVisibility(8);
        ((ViewHolder)localObject1).checkbox.setVisibility(8);
        ((ViewHolder)localObject1).handler.setVisibility(8);
        ((ViewHolder)localObject1).arrow.setVisibility(0);
        paramView.setContentDescription(((IListFolder)localObject2).getSectionName());
        localObject2 = (KeepPressedRelativeLayout)((HorizontalScrollItemView)paramView).getContentView();
        if (paramInt == getCount() - 1)
        {
          ((KeepPressedRelativeLayout)localObject2).setDrawDivider(false, true);
          ((KeepPressedRelativeLayout)localObject2).updateDividerInsetLeft(0, ((ViewHolder)localObject1).getInsetLeft(this.mContext));
        }
        for (;;)
        {
          ((KeepPressedRelativeLayout)localObject2).addOnLayoutChangeListener(new QMFolderListAdapter.1(this, (KeepPressedRelativeLayout)localObject2, (ViewHolder)localObject1));
          localObject1 = paramView;
          break;
          ((KeepPressedRelativeLayout)((HorizontalScrollItemView)paramView).getContentView()).setDrawDivider(false, false);
        }
      }
      Object localObject3 = ((IListFolder)localObject2).getIcon();
      label600:
      label624:
      Object localObject4;
      int i;
      label658:
      label755:
      Object localObject5;
      if (localObject3 == null)
      {
        ((ViewHolder)localObject1).itemIcon.setVisibility(0);
        ((ViewHolder)localObject1).itemIcon.setImageResource(2130840960);
        ((ViewHolder)localObject1).tagIcon.setVisibility(8);
        if ((!((IListFolder)localObject2).shouldDrawArrow()) && (this.isEditing)) {
          break label1577;
        }
        ((ViewHolder)localObject1).arrow.setVisibility(0);
        if ((((IListFolder)localObject2).getData() instanceof QMFolder))
        {
          localObject4 = (QMFolder)((IListFolder)localObject2).getData();
          if (!isEnabled(paramInt)) {
            break label1590;
          }
          i = 2131167523;
          localObject3 = QMApplicationContext.sharedInstance().getResources();
          ((ViewHolder)localObject1).itemname.setTextColor(((Resources)localObject3).getColor(i));
          i = QMFolderManager.sharedInstance().getDisplayUnreadCount((QMFolder)localObject4);
          if (i <= 0) {
            break label1627;
          }
          ((ViewHolder)localObject1).unread.setVisibility(0);
          ((ViewHolder)localObject1).unread.setText(String.valueOf(i));
          if (!QMFolderManager.sharedInstance().hasNewMail((QMFolder)localObject4)) {
            break label1598;
          }
          ((ViewHolder)localObject1).unread.setTextColor(((Resources)localObject3).getColor(2131167626));
          ((ViewHolder)localObject1).unread.setTypeface(Typeface.DEFAULT_BOLD);
          if (-5 == ((QMFolder)localObject4).getId())
          {
            localObject5 = FtnManager.sharedInstance();
            if (localObject5 == null) {
              break label1658;
            }
            i = ((FtnManager)localObject5).getAccountId();
            QMLog.log(2, this.TAG, "Ftn-expunread folder is-update: " + ((QMFolder)localObject4).isFtnExpUnreadUpdate() + " is-access: " + ((FtnManager)localObject5).isAccessFtnBefore(i) + " is-show: " + ((FtnManager)localObject5).isFtnExpUnreadShow(i));
            if (!((FtnManager)localObject5).isFtnExpUnreadNeedShow()) {
              break label1640;
            }
            setFolderExpUnread((ViewHolder)localObject1, ((FtnManager)localObject5).getFtnExpUnreadCount());
            ((FtnManager)localObject5).setFtnExpUnreadShow(i, true);
            label876:
            ((FtnManager)localObject5).setAccessFtnBefore(i, false);
          }
          label885:
          if (-16 == ((QMFolder)localObject4).getId()) {
            renderBottleUnread((ViewHolder)localObject1);
          }
          if ((((QMFolder)localObject4).getType() == 130) || (((QMFolder)localObject4).getType() == 140) || (((QMFolder)localObject4).getId() == -23))
          {
            if (((QMFolder)localObject4).getType() == 130)
            {
              localObject5 = PopularizeUIHelper.getPopularizeItemImage(((QMFolder)localObject4).getId());
              if (localObject5 != null) {
                ((ViewHolder)localObject1).itemIcon.setImageDrawable(new BitmapDrawable((Resources)localObject3, (Bitmap)localObject5));
              }
            }
            if (((QMFolder)localObject4).getId() == -23)
            {
              localObject5 = PopularizeManager.sharedInstance().getPopularize(new FestivalCardFilter());
              if (((List)localObject5).size() > 0)
              {
                localObject5 = PopularizeUIHelper.getPopularizeItemImage(((Popularize)((List)localObject5).get(0)).getId());
                if (localObject5 != null) {
                  ((ViewHolder)localObject1).itemIcon.setImageDrawable(new BitmapDrawable((Resources)localObject3, (Bitmap)localObject5));
                }
              }
            }
            localObject5 = (ArrayList)this.popularizeSubitems.get(Integer.valueOf(((QMFolder)localObject4).getId()));
            if ((((QMFolder)localObject4).getType() != 140) || ((localObject5 != null) && (((ArrayList)localObject5).size() != 0))) {
              break label1671;
            }
            if ((!FolderDataManager.sharedInstance().isShowInnerBottleUnread()) && (!FolderDataManager.sharedInstance().isShowInnerFtnUnread())) {
              break label2282;
            }
            ((ViewHolder)localObject1).subitems.setVisibility(0);
            localObject4 = ((Resources)localObject3).getDrawable(2130840969);
            ((ViewHolder)localObject1).subitems.setImage((Drawable)localObject4, 3);
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          localObject4 = ((IListFolder)localObject2).getSubInfo();
          if ((localObject4 != null) && (!((String)localObject4).equals("")))
          {
            ((ViewHolder)localObject1).unread.setVisibility(0);
            ((ViewHolder)localObject1).unread.setText((CharSequence)localObject4);
            ((ViewHolder)localObject1).unread.setTextColor(((Resources)localObject3).getColor(2131167626));
            ((ViewHolder)localObject1).unread.setTypeface(Typeface.DEFAULT);
          }
        }
        else
        {
          label1225:
          if (!isEnabled(paramInt)) {
            break label1985;
          }
          if (Build.VERSION.SDK_INT > 10)
          {
            ((ViewHolder)localObject1).itemIcon.setAlpha(1.0F);
            ((ViewHolder)localObject1).subitems.setAlpha(1.0F);
          }
          label1259:
          localObject3 = (KeepPressedRelativeLayout)((HorizontalScrollItemView)paramView).getContentView();
          if (!isInMyApp()) {
            break label2107;
          }
          if (j != IListItem.ItemType.SINGLE.ordinal()) {
            break label2018;
          }
          ((KeepPressedRelativeLayout)localObject3).setDrawDivider(true, true);
          ((KeepPressedRelativeLayout)localObject3).updateDividerInsetLeft(0, 0);
          label1303:
          ((KeepPressedRelativeLayout)localObject3).addOnLayoutChangeListener(new QMFolderListAdapter.2(this, j, (KeepPressedRelativeLayout)localObject3, (ViewHolder)localObject1));
          i = QMFolderManager.sharedInstance().getDisplayUnreadCount((QMFolder)((IListFolder)localObject2).getData());
          localObject1 = ((IListFolder)localObject2).getName();
          if (!((String)localObject1).equals(QMApplicationContext.sharedInstance().getString(2131695181))) {
            break label2273;
          }
          localObject1 = (String)localObject1 + QMApplicationContext.sharedInstance().getString(2131720820);
        }
        label1577:
        label1590:
        label1598:
        label1627:
        label2273:
        for (;;)
        {
          if (((QMFolder)((IListFolder)localObject2).getData()).getType() == 12) {
            localObject1 = QMApplicationContext.sharedInstance().getString(2131719927) + ((IListFolder)localObject2).getName();
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (i > 0) {
              localObject2 = (String)localObject1 + String.format(QMApplicationContext.sharedInstance().getString(2131720859), new Object[] { Integer.valueOf(i) });
            }
            paramView.setContentDescription((CharSequence)localObject2);
            localObject1 = paramView;
            break;
            if ((localObject3 instanceof ShapeDrawable))
            {
              ((ViewHolder)localObject1).itemIcon.setVisibility(8);
              ((ViewHolder)localObject1).tagIcon.setVisibility(0);
              QMUIHelper.setBackgroundWithNoPadding(((ViewHolder)localObject1).tagIcon, (Drawable)localObject3);
              break label600;
            }
            ((ViewHolder)localObject1).tagIcon.setVisibility(8);
            ((ViewHolder)localObject1).itemIcon.setVisibility(0);
            ((ViewHolder)localObject1).itemIcon.setImageDrawable((Drawable)localObject3);
            break label600;
            ((ViewHolder)localObject1).arrow.setVisibility(8);
            break label624;
            i = 2131167526;
            break label658;
            ((ViewHolder)localObject1).unread.setTextColor(((Resources)localObject3).getColor(2131167625));
            ((ViewHolder)localObject1).unread.setTypeface(Typeface.DEFAULT);
            break label755;
            ((ViewHolder)localObject1).unread.setVisibility(8);
            break label755;
            label1640:
            clearFolderExpUnread((ViewHolder)localObject1);
            ((FtnManager)localObject5).setFtnExpUnreadShow(i, false);
            break label876;
            label1658:
            ((ViewHolder)localObject1).unread.setVisibility(8);
            break label885;
            if ((localObject5 == null) || (((ArrayList)localObject5).size() <= 0)) {
              break label2282;
            }
            ((ViewHolder)localObject1).subitems.setVisibility(0);
            Object localObject6 = PopularizeUIHelper.getPopularizePosSubItems((ArrayList)localObject5, 2);
            localObject4 = PopularizeUIHelper.getPopularizePosSubItems((ArrayList)localObject5, 3);
            if ((localObject6 != null) && (((ArrayList)localObject6).size() > 0))
            {
              localObject5 = ((ArrayList)localObject6).iterator();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (PopularizeSubItem)((Iterator)localObject5).next();
                if (!StringUtils.isBlank(((PopularizeSubItem)localObject6).getImageUrl()))
                {
                  localObject6 = PopularizeThumbManager.sharedInstance().getPopularizeThumb(((PopularizeSubItem)localObject6).getImageUrl());
                  if (localObject6 != null)
                  {
                    localObject6 = new BitmapDrawable((Resources)localObject3, (Bitmap)localObject6);
                    ((ViewHolder)localObject1).subitems.setImage((Drawable)localObject6, 2);
                  }
                }
                else if (!StringUtils.isBlank(((PopularizeSubItem)localObject6).getText()))
                {
                  ((ViewHolder)localObject1).subitems.setText(((PopularizeSubItem)localObject6).getText(), 2);
                }
              }
            }
            if ((localObject4 == null) || (((ArrayList)localObject4).size() <= 0)) {
              break label2282;
            }
            localObject4 = ((ArrayList)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (PopularizeSubItem)((Iterator)localObject4).next();
              if ((StringUtils.isBlank(((PopularizeSubItem)localObject5).getText())) && (!StringUtils.isBlank(((PopularizeSubItem)localObject5).getImageUrl())))
              {
                localObject5 = PopularizeThumbManager.sharedInstance().getPopularizeThumb(((PopularizeSubItem)localObject5).getImageUrl());
                if (localObject5 != null)
                {
                  localObject5 = new BitmapDrawable((Resources)localObject3, (Bitmap)localObject5);
                  ((ViewHolder)localObject1).subitems.setImage((Drawable)localObject5, 3);
                }
              }
              else if (!StringUtils.isBlank(((PopularizeSubItem)localObject5).getText()))
              {
                ((ViewHolder)localObject1).subitems.setText(((PopularizeSubItem)localObject5).getText(), 3);
              }
            }
            ((ViewHolder)localObject1).unread.setVisibility(8);
            break label1225;
            if (Build.VERSION.SDK_INT <= 10) {
              break label1259;
            }
            ((ViewHolder)localObject1).itemIcon.setAlpha(0.5F);
            ((ViewHolder)localObject1).subitems.setAlpha(0.5F);
            break label1259;
            label2018:
            if (j == IListItem.ItemType.TOP.ordinal())
            {
              ((KeepPressedRelativeLayout)localObject3).setDrawDivider(true, true);
              ((KeepPressedRelativeLayout)localObject3).updateDividerInsetLeft(0, ((ViewHolder)localObject1).getInsetLeft(this.mContext));
              break label1303;
            }
            if (j == IListItem.ItemType.BOTTOM.ordinal())
            {
              ((KeepPressedRelativeLayout)localObject3).setDrawDivider(false, true);
              ((KeepPressedRelativeLayout)localObject3).updateDividerInsetLeft(0, 0);
              break label1303;
            }
            ((KeepPressedRelativeLayout)localObject3).setDrawDivider(false, true);
            ((KeepPressedRelativeLayout)localObject3).updateDividerInsetLeft(0, ((ViewHolder)localObject1).getInsetLeft(this.mContext));
            break label1303;
            if (((j == IListItem.ItemType.BOTTOM.ordinal()) || (j == IListItem.ItemType.SINGLE.ordinal())) && (paramInt != getCount() - 1))
            {
              ((KeepPressedRelativeLayout)localObject3).setDrawDivider(false, false);
              break label1303;
            }
            ((KeepPressedRelativeLayout)localObject3).setDrawDivider(false, true);
            ((KeepPressedRelativeLayout)localObject3).updateDividerInsetLeft(0, ((ViewHolder)localObject1).getInsetLeft(this.mContext));
            break label1303;
            if (((QMFolder)((IListFolder)localObject2).getData()).getType() == 13) {
              localObject1 = QMApplicationContext.sharedInstance().getString(2131719928) + ((IListFolder)localObject2).getName();
            } else if (((QMFolder)((IListFolder)localObject2).getData()).getType() == 14) {
              localObject1 = String.format(QMApplicationContext.sharedInstance().getString(2131720831), new Object[] { ((IListFolder)localObject2).getName() });
            }
          }
        }
        label1671:
        label1985:
        i = 1;
        label2107:
        continue;
        label2282:
        i = 0;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  public boolean isEditing()
  {
    return this.isEditing;
  }
  
  public boolean isEnabled(int paramInt)
  {
    IListFolder localIListFolder = getItem(paramInt);
    if (localIListFolder.getType() == IListItem.ItemType.SECTION) {
      return false;
    }
    if ((localIListFolder.getData() instanceof QMFolder))
    {
      if ((!this.isEditing) || (!QMFolderManager.sharedInstance().isFolderNameReserved((QMFolder)localIListFolder.getData()))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public int isEnabledScroll(int paramInt)
  {
    if (canRightScroll(paramInt)) {
      return 2;
    }
    return 0;
  }
  
  public boolean isShowHomeFolderId(QMFolder paramQMFolder)
  {
    return (this.activeFolderIds != null) && (this.activeFolderIds.contains(Integer.valueOf(paramQMFolder.getId())));
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void remove(int paramInt) {}
  
  public void setActiveFolderIds(Set<Integer> paramSet)
  {
    this.activeFolderIds = paramSet;
  }
  
  public void setFolderInfo(List<IListFolder> paramList, int paramInt)
  {
    ValidateHelper.notNull(paramList);
    this.mData = paramList;
    setPopularizeSubItems(paramInt);
    notifyDataSetChanged();
  }
  
  public void setIsEditing(boolean paramBoolean)
  {
    this.isEditing = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setMyAppUnreadRedDot(ListView paramListView)
  {
    int j = paramListView.getFirstVisiblePosition();
    int i = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    if ((i >= j) && (i >= k))
    {
      Object localObject = getItem(i - k);
      ViewHolder localViewHolder;
      if (isMyApp((IListFolder)localObject))
      {
        localViewHolder = (ViewHolder)paramListView.getChildAt(i - j).getTag();
        if (localViewHolder.subitems != null) {
          break label76;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label76:
        localObject = (ArrayList)this.popularizeSubitems.get(Integer.valueOf(((QMFolder)((IListFolder)localObject).getData()).getId()));
        if (((localObject == null) || (((ArrayList)localObject).size() == 0)) && ((FolderDataManager.sharedInstance().isShowInnerBottleUnread()) || (FolderDataManager.sharedInstance().isShowInnerFtnUnread())))
        {
          localViewHolder.subitems.setVisibility(0);
          localObject = QMApplicationContext.sharedInstance().getResources().getDrawable(2130840969);
          localViewHolder.subitems.setImage((Drawable)localObject, 3);
        }
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
      if (i >= k)
      {
        IListFolder localIListFolder = getItem(i - k);
        if ((localIListFolder != null) && (localIListFolder.getData() != null) && (((QMFolder)localIListFolder.getData()).getId() == -16)) {
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
    public IListItem<?> data;
    public ImageView handler;
    public ImageView itemIcon;
    public TextView itemname;
    public LinearLayout leftContainer;
    public TextView sectionname;
    public PopularizeFolderSubItems subitems;
    public ImageView tagIcon;
    public TextView unread;
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter
 * JD-Core Version:    0.7.0.1
 */