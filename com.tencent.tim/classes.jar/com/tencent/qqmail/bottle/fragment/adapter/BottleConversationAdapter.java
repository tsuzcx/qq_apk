package com.tencent.qqmail.bottle.fragment.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleConversationCursor;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottleManager.ViewHolderTag;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.bottle.view.BottleViewHolderCache;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.ui.AnimationListBaseAdapter;
import java.util.Date;

public class BottleConversationAdapter
  extends AnimationListBaseAdapter<BottleConversation>
{
  public static final long LOADING_ITEM_ID = 9223372036854775807L;
  private static final String TAG = BottleConversationAdapter.class.getSimpleName();
  private static final int TYPE_CONVERSATION_ITEM = 0;
  private static final int TYPE_LOADING_ITEM = 1;
  private final int[] bottle_beach_item_top_colors_resource = { 2130838969, 2130838970, 2130838971 };
  private BottleConversationCursor mAnimationCompleteCursor = null;
  private BottleManager mBottleManager = null;
  private BottleViewHolderCache mCacheView = null;
  private Context mContext;
  private BottleConversationCursor mCursor = null;
  private boolean mFromBeach;
  private LayoutInflater mInflater = null;
  private boolean mIsEnabled = true;
  private ListView mListView;
  private final OnDetailClickBridge mOnDetailClickListener = new OnDetailClickBridge();
  
  public BottleConversationAdapter(Context paramContext, BottleManager paramBottleManager, BottleViewHolderCache paramBottleViewHolderCache, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mBottleManager = paramBottleManager;
    this.mCacheView = paramBottleViewHolderCache;
    this.mFromBeach = paramBoolean;
  }
  
  private void updateAvatar(String paramString, Bitmap paramBitmap)
  {
    if (this.mListView != null)
    {
      int j = this.mListView.getFirstVisiblePosition();
      int i = this.mListView.getLastVisiblePosition();
      while (i >= j)
      {
        Object localObject = this.mListView.getChildAt(i - j);
        if ((localObject != null) && ((((View)localObject).getTag() instanceof ViewHolder)))
        {
          localObject = (ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (((ViewHolder)localObject).avatarUin != null) && (((ViewHolder)localObject).avatarUin.toString().equals(paramString))) {
            ((ViewHolder)localObject).avatar.setImageBitmap(paramBitmap);
          }
        }
        i -= 1;
      }
    }
  }
  
  public boolean cursorCanLoadMore()
  {
    if (this.mCursor != null) {
      return this.mCursor.hasMoreItem();
    }
    return false;
  }
  
  public BottleViewHolderCache getCache()
  {
    return this.mCacheView;
  }
  
  public int getCount()
  {
    if (this.mCursor == null) {
      return 0;
    }
    return this.mCursor.getCount();
  }
  
  public BottleConversationCursor getCursor()
  {
    return this.mCursor;
  }
  
  public BottleConversation getItem(int paramInt)
  {
    if ((paramInt >= 0) && (this.mCursor != null) && (paramInt < this.mCursor.getCount())) {
      return this.mCursor.getItem(paramInt);
    }
    return null;
  }
  
  public int getItemId(BottleConversation paramBottleConversation)
  {
    if (paramBottleConversation == null) {}
    while (paramBottleConversation.getMsgId() == null) {
      return 0;
    }
    return paramBottleConversation.getMsgId().hashCode();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.mCursor.getCount() > paramInt) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    BottleConversation localBottleConversation = getItem(paramInt);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = this.mInflater.inflate(2131558776, null);
      paramView = new ViewHolder(null);
      paramView.nickname = null;
      paramView.unsend = ((ImageView)localView.findViewById(2131377100));
      paramView.unsendText = ((TextView)localView.findViewById(2131363598));
      paramView.content = ((TextView)localView.findViewById(2131363593));
      paramView.time = ((TextView)localView.findViewById(2131365593));
      paramView.geo = ((TextView)localView.findViewById(2131363605));
      paramView.topcolor = null;
      paramView.avatar = ((ImageView)localView.findViewById(2131363175));
      localView.setTag(paramView);
    }
    ViewHolder localViewHolder = (ViewHolder)localView.getTag();
    localViewHolder.bottleid = localBottleConversation.getBottleId();
    localViewHolder.msgid = localBottleConversation.getMsgId();
    label361:
    int i;
    if ((this.mCursor.getLastOtherMsgId() != null) && (this.mCursor.getLastOtherMsgId().equals(localBottleConversation.getMsgId())))
    {
      localViewHolder.geo.setText(CommonUI.getFormatDistance(this.mCursor.getDistance(), this.mCursor.getCity()));
      localViewHolder.geo.setVisibility(0);
      this.mOnDetailClickListener.bindViewOnClickListener(localViewHolder.avatar, localBottleConversation.getBottler());
      localViewHolder.avatarUin = localBottleConversation.getUin();
      if (!this.mBottleManager.loadAvatar(localBottleConversation.getAvatar(), localBottleConversation.getUin(), 0, new BottleConversationAdapter.1(this, localViewHolder))) {
        localViewHolder.avatar.setImageBitmap(this.mBottleManager.getDefalAvatar(localBottleConversation.getUin(), 0));
      }
      if ((localViewHolder.unsend != null) && (localViewHolder.unsendText != null))
      {
        if (localBottleConversation.isUnsend() != true) {
          break label665;
        }
        localViewHolder.unsend.setVisibility(0);
        localViewHolder.unsendText.setVisibility(0);
      }
      i = this.mInflater.getContext().getResources().getDimensionPixelSize(2131296684);
      String str = localBottleConversation.getContent();
      paramView = str;
      if (localBottleConversation.getImageUrl() != null)
      {
        paramView = str;
        if (localBottleConversation.getImageUrl().length() > 0) {
          paramView = str + this.mContext.getString(2131690957);
        }
      }
      if ((localBottleConversation.getAudioUrl() == null) || (localBottleConversation.getAudioUrl().length() <= 0)) {
        break label688;
      }
      paramView = paramView + this.mContext.getString(2131690956);
    }
    label665:
    label688:
    for (;;)
    {
      this.mBottleManager.setContentWithEmoji(localViewHolder.content, paramView, localBottleConversation.getEmoji(), localBottleConversation.getBottleId(), localBottleConversation.getMsgId(), localViewHolder, i);
      if (localViewHolder.time != null)
      {
        paramView = DateExtension.shortDateName(new Date(localBottleConversation.getTime() * 1000L));
        localViewHolder.time.setText(paramView);
      }
      if (localViewHolder.topcolor != null)
      {
        i = this.bottle_beach_item_top_colors_resource[(java.lang.Math.abs(localBottleConversation.getBottleId().hashCode()) % this.bottle_beach_item_top_colors_resource.length)];
        localViewHolder.topcolor.setBackgroundResource(i);
      }
      long l2 = System.currentTimeMillis();
      Log.v(TAG, "GetView-Time_2: " + (l2 - l1));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localViewHolder.geo.setVisibility(8);
      break;
      localViewHolder.unsend.setVisibility(8);
      localViewHolder.unsendText.setVisibility(8);
      break label361;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.mIsEnabled;
  }
  
  public void notifyDataSetChanged()
  {
    if (!isAnimating()) {
      super.notifyDataSetChanged();
    }
  }
  
  public void onRowAdditionAnimationEnd()
  {
    super.onRowAdditionAnimationEnd();
    if (this.mAnimationCompleteCursor != null)
    {
      update(this.mAnimationCompleteCursor);
      this.mAnimationCompleteCursor = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.mIsEnabled != paramBoolean)
    {
      this.mIsEnabled = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public void setListView(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public void setOnDetailClickListener(OnDetailClickBridge.OnDetailClickListener paramOnDetailClickListener)
  {
    this.mOnDetailClickListener.setOnDetailClickListener(paramOnDetailClickListener);
  }
  
  public void update(BottleConversationCursor paramBottleConversationCursor)
  {
    if (isAnimating())
    {
      if ((this.mAnimationCompleteCursor != null) && (this.mAnimationCompleteCursor != paramBottleConversationCursor)) {
        this.mAnimationCompleteCursor.close();
      }
      this.mAnimationCompleteCursor = paramBottleConversationCursor;
      return;
    }
    if ((this.mCursor != null) && (this.mCursor != paramBottleConversationCursor)) {
      this.mCursor.close();
    }
    this.mCursor = paramBottleConversationCursor;
    notifyDataSetChanged();
  }
  
  public void updateWithAnimation(BottleConversationCursor paramBottleConversationCursor)
  {
    if (paramBottleConversationCursor != null) {
      notifyPrepareAnimation(1);
    }
    update(paramBottleConversationCursor);
  }
  
  static class ViewHolder
    extends BottleManager.ViewHolderTag
  {
    ImageView avatar;
    String avatarUin;
    TextView content;
    TextView geo;
    TextView nickname;
    TextView time;
    View topcolor;
    ImageView unsend;
    TextView unsendText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.adapter.BottleConversationAdapter
 * JD-Core Version:    0.7.0.1
 */