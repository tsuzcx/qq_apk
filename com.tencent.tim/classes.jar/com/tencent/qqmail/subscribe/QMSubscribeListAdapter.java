package com.tencent.qqmail.subscribe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor;
import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor.Util;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.view.QMSubscribeListItemView;
import com.tencent.qqmail.view.QMSubscribeListItemView.OnArticleClickListener;
import com.tencent.qqmail.view.QMSubscribeListItemView.OnArticleLongClickListener;
import java.util.ArrayList;
import java.util.HashMap;

public class QMSubscribeListAdapter
  extends BaseAdapter
{
  private static final String TAG = QMSubscribeListAdapter.class.getSimpleName();
  private static final int TYPE_DATA = 0;
  private static final SparseArray<QMSubscribeListItem> cacheList = new SparseArray();
  public static BitmapDrawable placeholder = null;
  private int cache_count = -1;
  private Context context;
  private QMSubscribeColumnCursor cursor;
  private boolean isFastScroll = false;
  private QMSubscribeListItemView.OnArticleClickListener onArticleClickListener;
  private QMSubscribeListItemView.OnArticleLongClickListener onArticleLongClickListener;
  
  public QMSubscribeListAdapter(Context paramContext, QMSubscribeColumnCursor paramQMSubscribeColumnCursor)
  {
    this.cursor = paramQMSubscribeColumnCursor;
    this.context = paramContext;
    placeholder = (BitmapDrawable)paramContext.getResources().getDrawable(2130841019);
    placeholder.setAlpha(0);
  }
  
  private void clearCacheData()
  {
    if (this.cursor != null) {
      this.cursor.close();
    }
  }
  
  private SparseArray<QMSubscribeListItem> getGroupedItems()
  {
    HashMap localHashMap = new HashMap();
    int m;
    int j;
    SubscribeMail localSubscribeMail;
    Object localObject1;
    Object localObject2;
    if (this.cursor != null)
    {
      int i = -1;
      int n = this.cursor.getCount();
      m = 0;
      j = 0;
      if (m < n)
      {
        localSubscribeMail = this.cursor.getSubscribeItem(m);
        if (localSubscribeMail.getIndex() == SubscribeMail.INDEX_ENTRANCE_MAIL)
        {
          localObject1 = new QMSubscribeListItem();
          ((QMSubscribeListItem)localObject1).setArticleList(new ArrayList());
          ((QMSubscribeListItem)localObject1).setEmail(localSubscribeMail.getFromAddress());
          ((QMSubscribeListItem)localObject1).setDate(localSubscribeMail.getReceive());
          ((QMSubscribeListItem)localObject1).setSender(localSubscribeMail.getFromName());
          ((QMSubscribeListItem)localObject1).setId(localSubscribeMail.getMid());
          if (Mail.isSubscribeByColid(localSubscribeMail.getRemoteId(), localSubscribeMail.getColId()))
          {
            localObject2 = ((QMSubscribeListItem)localObject1).getArticleList();
            localSubscribeMail.setBigIcon(QMSubscribeColumnCursor.Util.getMailSnapUrl(localSubscribeMail.getAccountId(), localSubscribeMail.getRemoteId()));
            SubscribeMailUI localSubscribeMailUI = new SubscribeMailUI();
            localSubscribeMailUI.setSubscribe(localSubscribeMail);
            localSubscribeMailUI.setTitle(localSubscribeMail.getSubject());
            ((ArrayList)localObject2).add(localSubscribeMailUI);
            ((QMSubscribeListItem)localObject1).setArticleList((ArrayList)localObject2);
          }
          localObject2 = cacheList;
          i += 1;
          ((SparseArray)localObject2).put(i, localObject1);
          localHashMap.put(localSubscribeMail.getRemoteId(), Integer.valueOf(i));
        }
      }
    }
    for (;;)
    {
      m += 1;
      break;
      localObject1 = (Integer)localHashMap.get(localSubscribeMail.getRemoteId());
      if (localObject1 != null)
      {
        localObject1 = (QMSubscribeListItem)cacheList.get(((Integer)localObject1).intValue());
        int k;
        if (localObject1 != null)
        {
          localObject2 = ((QMSubscribeListItem)localObject1).getSender();
          if ((localObject2 == null) || (((String)localObject2).equals(""))) {
            ((QMSubscribeListItem)localObject1).setSender(localSubscribeMail.getFromName());
          }
          if (((QMSubscribeListItem)localObject1).getArticleList().size() > 4) {
            continue;
          }
          if (j == 0)
          {
            k = j;
            if (localSubscribeMail.getBigIcon() != null) {
              if (localSubscribeMail.getBigIcon().equals("")) {
                continue;
              }
            }
          }
          else
          {
            k = 1;
            j = 1;
            if (localSubscribeMail.getIcon() != null)
            {
              if (localSubscribeMail.getIcon().equals("")) {
                continue;
              }
              j = 1;
            }
          }
        }
        else
        {
          for (;;)
          {
            localObject1 = ((QMSubscribeListItem)localObject1).getArticleList();
            localObject2 = new SubscribeMailUI();
            ((SubscribeMailUI)localObject2).setSubscribe(localSubscribeMail);
            ((SubscribeMailUI)localObject2).setTitle(localSubscribeMail.getSubject());
            ((ArrayList)localObject1).add(localObject2);
            break;
            localObject1 = new QMSubscribeListItem();
            ((QMSubscribeListItem)localObject1).setArticleList(new ArrayList());
          }
          return cacheList;
        }
        j = k;
      }
    }
  }
  
  private void loadImages(int paramInt, ArrayList<SubscribeMailUI> paramArrayList, QMSubscribeListItemView paramQMSubscribeListItemView)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      QMSubscribeThumbManager localQMSubscribeThumbManager = QMSubscribeThumbManager.sharedInstance();
      int k = paramArrayList.size();
      int i = 0;
      if (i < k)
      {
        Object localObject = (SubscribeMailUI)paramArrayList.get(i);
        int m = ((SubscribeMailUI)localObject).getSubscribe().getAccountId();
        int j;
        if (i == 0)
        {
          localObject = ((SubscribeMailUI)localObject).getSubscribe().getBigIcon();
          j = 0;
          label71:
          Bitmap localBitmap = localQMSubscribeThumbManager.getBitmapFromCache((String)localObject, j);
          if (localBitmap == null) {
            break label121;
          }
          paramQMSubscribeListItemView.setImage(localBitmap, j);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = ((SubscribeMailUI)localObject).getSubscribe().getIcon();
          j = i;
          break label71;
          label121:
          if (!this.isFastScroll) {
            localQMSubscribeThumbManager.loadSubscribeThumb(paramInt, m, (String)localObject, j);
          }
          paramQMSubscribeListItemView.setImage(null, j);
        }
      }
    }
  }
  
  public void clear()
  {
    if (cacheList != null) {
      cacheList.clear();
    }
  }
  
  public boolean cursorCanLoadMore()
  {
    if (this.cursor != null) {
      return this.cursor.canLoadMore();
    }
    return false;
  }
  
  public void cursorLoadMore()
  {
    if (cursorCanLoadMore())
    {
      this.cursor.loadMore();
      notifyDataSetChanged();
    }
  }
  
  public void destroy()
  {
    clearCacheData();
    clear();
    this.context = null;
    placeholder = null;
  }
  
  public int getCount()
  {
    int j = 0;
    int i = j;
    if (this.cursor != null)
    {
      i = j;
      if (this.cursor.getCount() > 0) {
        i = this.cursor.getColCount();
      }
    }
    return i;
  }
  
  public QMSubscribeColumnCursor getCursor()
  {
    return this.cursor;
  }
  
  public QMSubscribeListItem getItem(int paramInt)
  {
    if (this.cache_count != this.cursor.getCount())
    {
      this.cache_count = this.cursor.getCount();
      cacheList.clear();
    }
    if (cacheList.size() > 0) {
      return (QMSubscribeListItem)cacheList.get(paramInt);
    }
    return (QMSubscribeListItem)getGroupedItems().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null) {
      localObject = new QMSubscribeListItemView(this.context);
    }
    QMSubscribeListItemView localQMSubscribeListItemView;
    for (paramView = (QMSubscribeListItemView)localObject;; paramView = localQMSubscribeListItemView)
    {
      setViewImages(paramInt, paramView);
      paramView.setTag(Integer.valueOf(paramInt));
      paramView.setOnArticleClickListener(this.onArticleClickListener);
      paramView.setOnArticleLongClickListener(this.onArticleLongClickListener);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      localQMSubscribeListItemView = (QMSubscribeListItemView)paramView;
      localObject = paramView;
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  public void setOnArticleClick(QMSubscribeListItemView.OnArticleClickListener paramOnArticleClickListener)
  {
    this.onArticleClickListener = paramOnArticleClickListener;
  }
  
  public void setOnArticleLongClickListener(QMSubscribeListItemView.OnArticleLongClickListener paramOnArticleLongClickListener)
  {
    this.onArticleLongClickListener = paramOnArticleLongClickListener;
  }
  
  public void setViewImages(int paramInt, QMSubscribeListItemView paramQMSubscribeListItemView)
  {
    QMSubscribeListItem localQMSubscribeListItem = getItem(paramInt);
    ArrayList localArrayList;
    if (localQMSubscribeListItem != null)
    {
      localArrayList = localQMSubscribeListItem.getArticleList();
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        SubscribeMailUI localSubscribeMailUI = (SubscribeMailUI)localArrayList.get(0);
        if (localSubscribeMailUI.getSubscribe().getIndex() == SubscribeMail.INDEX_ENTRANCE_MAIL)
        {
          if (localArrayList.size() != 1) {
            break label99;
          }
          localSubscribeMailUI.getSubscribe().setSnapShot(true);
        }
      }
    }
    for (;;)
    {
      paramQMSubscribeListItemView.setArticles(localArrayList);
      paramQMSubscribeListItemView.setHeader(localQMSubscribeListItem.getSender(), localQMSubscribeListItem.getDateString());
      loadImages(paramInt, localArrayList, paramQMSubscribeListItemView);
      return;
      label99:
      localArrayList.remove(0);
    }
  }
  
  public void updateCursor()
  {
    if (this.cursor != null)
    {
      this.cursor.refresh(null);
      if (this.cursor.isChanged()) {
        clear();
      }
    }
  }
  
  public void updateScrollState(boolean paramBoolean)
  {
    this.isFastScroll = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.QMSubscribeListAdapter
 * JD-Core Version:    0.7.0.1
 */