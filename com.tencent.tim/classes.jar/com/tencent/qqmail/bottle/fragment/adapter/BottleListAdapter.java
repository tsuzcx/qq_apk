package com.tencent.qqmail.bottle.fragment.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleListCursor;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottleManager.ViewHolderTag;
import com.tencent.qqmail.bottle.controller.BottlerController;
import com.tencent.qqmail.bottle.model.BottleList;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.view.QMListItemView;
import java.util.Date;

public class BottleListAdapter
  extends BaseAdapter
  implements ItemScrollListView.ItemScrollAdapter
{
  public static final int MORE_ITEM_ID = 2147483647;
  private static final String TAG = BottleListAdapter.class.getSimpleName();
  private static final int TYPE_BOTTLE_ITEM = 0;
  private static final int TYPE_MORE_ITEM = 1;
  private boolean isEditing;
  private BottleManager mBottleManager;
  private Context mContext;
  private BottleListCursor mCursor;
  private LayoutInflater mInflater = null;
  private boolean mLoading;
  private String mMyBottleUin;
  
  public BottleListAdapter(Context paramContext, BottleManager paramBottleManager)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mBottleManager = paramBottleManager;
  }
  
  public int getCount()
  {
    int i;
    if (this.mCursor == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = this.mCursor.getCount();
      i = j;
    } while (!this.mCursor.hasMoreItem());
    return j + 1;
  }
  
  public BottleListCursor getCursor()
  {
    return this.mCursor;
  }
  
  @Nullable
  public BottleList getItem(int paramInt)
  {
    if (this.mCursor == null) {
      QMLog.log(6, "BottleListAdapter", "cursor is null when getItem");
    }
    while ((this.mCursor.getCount() <= paramInt) || (paramInt < 0)) {
      return null;
    }
    return this.mCursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.mCursor.getCount() > paramInt) {
      return paramInt;
    }
    return 2147483647L;
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
    Object localObject1 = getItem(paramInt);
    if (localObject1 == null)
    {
      if (paramView != null) {
        break label661;
      }
      paramView = new MailListMoreItemView(this.mInflater.getContext());
    }
    label385:
    label650:
    label661:
    for (;;)
    {
      localObject1 = (MailListMoreItemView)paramView;
      if (this.mLoading)
      {
        ((MailListMoreItemView)localObject1).showLoading(true);
        ((MailListMoreItemView)localObject1).setEnabled(false);
        if (this.isEditing) {
          break label116;
        }
      }
      Object localObject2;
      label116:
      for (boolean bool = true;; bool = false)
      {
        ((MailListMoreItemView)localObject1).setEnabled(bool);
        localObject1 = paramView;
        localObject2 = localObject1;
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject2;
        ((MailListMoreItemView)localObject1).showLoading(false);
        ((MailListMoreItemView)localObject1).setEnabled(true);
        break;
      }
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = this.mInflater.inflate(2131558779, paramViewGroup, false);
        localObject2 = new ViewHolder(null);
        ((ViewHolder)localObject2).avatar = ((ImageView)paramView.findViewById(2131363175));
        ((ViewHolder)localObject2).readflag = ((ImageView)paramView.findViewById(2131376667));
        ((ViewHolder)localObject2).nickname = ((TextView)paramView.findViewById(2131372384));
        ((ViewHolder)localObject2).time = ((TextView)paramView.findViewById(2131379661));
        ((ViewHolder)localObject2).error = ((ImageView)paramView.findViewById(2131366496));
        ((ViewHolder)localObject2).content = ((TextView)paramView.findViewById(2131365360));
        paramView = ItemScrollListView.wrap(paramView);
        paramView.setTag(localObject2);
      }
      for (;;)
      {
        localObject2 = ((HorizontalScrollItemView)paramView).getDeleteView();
        ItemScrollListView.formatRightViewStyle((TextView)localObject2, 1);
        ((TextView)localObject2).setText(2131692498);
        localObject2 = (ViewHolder)paramView.getTag();
        ImageView localImageView = ((ViewHolder)localObject2).readflag;
        int i;
        if (((BottleList)localObject1).getUnreadCnt() > 0)
        {
          i = 0;
          label299:
          localImageView.setVisibility(i);
          localImageView = ((ViewHolder)localObject2).error;
          if (!((BottleList)localObject1).isUnsend()) {
            break label618;
          }
          i = 0;
          label324:
          localImageView.setVisibility(i);
          this.mMyBottleUin = this.mBottleManager.getBottlerController().getMyUin();
          if ((this.mMyBottleUin == null) || (!this.mMyBottleUin.equals(((BottleList)localObject1).getUin()))) {
            break label625;
          }
          i = 1;
          label370:
          if (i == 0) {
            break label631;
          }
          ((ViewHolder)localObject2).nickname.setText(2131690979);
          ((ViewHolder)localObject2).avatarUin = ((BottleList)localObject1).getUin();
          if (!this.mBottleManager.loadAvatar(((BottleList)localObject1).getAvatar(), ((BottleList)localObject1).getUin(), 1, new BottleListAdapter.1(this, (ViewHolder)localObject2))) {
            ((ViewHolder)localObject2).avatar.setImageBitmap(this.mBottleManager.getDefalAvatar(((BottleList)localObject1).getUin(), 1));
          }
          ((ViewHolder)localObject2).time.setText(DateExtension.shortDateName(new Date(((BottleList)localObject1).getTime() * 1000L)));
          ((ViewHolder)localObject2).bottleid = ((BottleList)localObject1).getBottleId();
          ((ViewHolder)localObject2).msgid = null;
          i = this.mInflater.getContext().getResources().getDimensionPixelSize(2131296699);
          this.mBottleManager.setContentWithEmoji(((ViewHolder)localObject2).content, ((BottleList)localObject1).getSummary(), ((BottleList)localObject1).getEmoji(), ((BottleList)localObject1).getBottleId(), null, (BottleManager.ViewHolderTag)localObject2, i);
          localObject1 = ((HorizontalScrollItemView)paramView).getContentView();
          if ((localObject1 instanceof QMListItemView))
          {
            localObject1 = (QMListItemView)localObject1;
            ((QMListItemView)localObject1).setDrawDivider(false, true);
            ((QMListItemView)localObject1).updateDividerInsetLeft(0, this.mContext.getResources().getDimensionPixelSize(2131297032));
            if (!this.isEditing) {
              break label650;
            }
            ((QMListItemView)localObject1).setItemToEditMode();
          }
        }
        for (;;)
        {
          localObject1 = paramView;
          localObject2 = paramView;
          break;
          i = 8;
          break label299;
          label618:
          i = 8;
          break label324;
          label625:
          i = 0;
          break label370;
          label631:
          ((ViewHolder)localObject2).nickname.setText(BottleManager.formatNickName(((BottleList)localObject1).getName()));
          break label385;
          ((QMListItemView)localObject1).setItemToNormalMode();
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public int isEnabledScroll(int paramInt)
  {
    if (this.isEditing) {
      return 0;
    }
    return 2;
  }
  
  public void setIsEditing(boolean paramBoolean)
  {
    this.isEditing = paramBoolean;
  }
  
  public void setLoading(boolean paramBoolean, ListView paramListView)
  {
    this.mLoading = paramBoolean;
    int j = paramListView.getFirstVisiblePosition();
    int i = paramListView.getLastVisiblePosition();
    if (i >= j)
    {
      View localView = paramListView.getChildAt(i - j);
      MailListMoreItemView localMailListMoreItemView;
      if ((localView instanceof MailListMoreItemView))
      {
        localMailListMoreItemView = (MailListMoreItemView)localView;
        if (!this.mLoading) {
          break label78;
        }
        localMailListMoreItemView.showLoading(true);
        localView.setEnabled(false);
      }
      for (;;)
      {
        localView.invalidate();
        i -= 1;
        break;
        label78:
        localMailListMoreItemView.showLoading(false);
        localView.setEnabled(true);
      }
    }
  }
  
  public boolean update(BottleListCursor paramBottleListCursor)
  {
    if ((this.mCursor != null) && (this.mCursor != paramBottleListCursor)) {
      this.mCursor.close();
    }
    this.mCursor = paramBottleListCursor;
    notifyDataSetChanged();
    return true;
  }
  
  static class ViewHolder
    extends BottleManager.ViewHolderTag
  {
    ImageView avatar;
    String avatarUin;
    TextView content;
    ImageView error;
    TextView nickname;
    ImageView readflag;
    TextView time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.adapter.BottleListAdapter
 * JD-Core Version:    0.7.0.1
 */