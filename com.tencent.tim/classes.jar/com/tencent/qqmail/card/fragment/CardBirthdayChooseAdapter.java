package com.tencent.qqmail.card.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.common.base.Strings;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.fragment.AvatarViewHolder;
import com.tencent.qqmail.card.cursor.QMBirthdayFriendListCursor;
import com.tencent.qqmail.card.model.QMCardFriendInfo;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.view.QMAvatarView;
import java.util.ArrayList;
import java.util.Iterator;

public class CardBirthdayChooseAdapter
  extends BaseAdapter
{
  private static final String TAG = "CardBirthdayChooseAdapter";
  private Context mContext;
  private QMBirthdayFriendListCursor mCursor;
  private boolean mIsExpanded = false;
  private ArrayList<QMCardFriendInfo> selectFriend = Lists.newArrayList();
  
  public CardBirthdayChooseAdapter(Context paramContext, QMBirthdayFriendListCursor paramQMBirthdayFriendListCursor)
  {
    this.mContext = paramContext;
    this.mCursor = paramQMBirthdayFriendListCursor;
    while (i < this.mCursor.getCount())
    {
      this.selectFriend.add(getItem(i));
      i += 1;
    }
  }
  
  private void addSelectContact(QMCardFriendInfo paramQMCardFriendInfo)
  {
    this.selectFriend.add(paramQMCardFriendInfo);
  }
  
  private void removeSelectContact(QMCardFriendInfo paramQMCardFriendInfo)
  {
    int i;
    if (this.selectFriend != null)
    {
      i = 0;
      if (i >= this.selectFriend.size()) {
        break label66;
      }
      if (!paramQMCardFriendInfo.getId().equals(((QMCardFriendInfo)this.selectFriend.get(i)).getId())) {
        break label59;
      }
    }
    for (;;)
    {
      if (i != -1) {
        this.selectFriend.remove(i);
      }
      return;
      label59:
      i += 1;
      break;
      label66:
      i = -1;
    }
  }
  
  public int getCount()
  {
    int i;
    if (this.mCursor == null) {
      i = -1;
    }
    do
    {
      int j;
      do
      {
        return i;
        j = this.mCursor.getCount();
        i = j;
      } while (j <= 4);
      i = j;
    } while (this.mIsExpanded);
    return 3;
  }
  
  public QMCardFriendInfo getItem(int paramInt)
  {
    if (this.mCursor == null) {
      return null;
    }
    return this.mCursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    QMCardFriendInfo localQMCardFriendInfo = getItem(paramInt);
    if (localQMCardFriendInfo != null) {
      return localQMCardFriendInfo.getUin();
    }
    return 0L;
  }
  
  public ArrayList<QMCardFriendInfo> getSelectFriend()
  {
    return this.selectFriend;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    QMCardFriendInfo localQMCardFriendInfo;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131558820, paramViewGroup, false);
      paramView = new ViewHolder();
      paramView.avatarView = ((QMAvatarView)localView.findViewById(2131363175));
      paramView.nameTv = ((TextView)localView.findViewById(2131381440));
      paramView.birthdayTv = ((TextView)localView.findViewById(2131363516));
      paramView.checkbox = ((ImageView)localView.findViewById(2131364587));
      localView.setTag(paramView);
      localQMCardFriendInfo = getItem(paramInt);
      if (localQMCardFriendInfo != null)
      {
        if (!Strings.isNullOrEmpty(localQMCardFriendInfo.getNickName())) {
          break label295;
        }
        localObject = this.mContext.getString(2131692061);
        label131:
        paramView.nameTv.setText((CharSequence)localObject);
        paramView.avatarName = ((String)localObject);
        paramView.birthdayTv.setText(CardUtil.getBirthdayTipByTime(localQMCardFriendInfo.getToDayTo(), localQMCardFriendInfo.isChinese()));
        paramView.checkbox.setSelected(isFriendSelected(localQMCardFriendInfo));
        localObject = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(localQMCardFriendInfo.getIcon());
        paramView.avatarUrl = localQMCardFriendInfo.getIcon();
        if (localObject != null) {
          break label305;
        }
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).setUrl(paramView.avatarUrl);
        ((DownloadInfo)localObject).setImageDownloadListener(new CardBirthdayChooseAdapter.1(this, paramView));
        ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject);
        paramView.avatarView.setAvatar(null, paramView.avatarName);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label295:
      localObject = localQMCardFriendInfo.getNickName();
      break label131;
      label305:
      Log.v("CardBirthdayChooseAdapter", "getView: hasIcon: " + paramView.avatarUrl + ", name:" + paramView.avatarName);
      paramView.avatarView.setAvatar((Bitmap)localObject, paramView.avatarName);
    }
  }
  
  public boolean isExpanded()
  {
    return this.mIsExpanded;
  }
  
  protected boolean isFriendSelected(QMCardFriendInfo paramQMCardFriendInfo)
  {
    if (this.selectFriend != null)
    {
      Iterator localIterator = this.selectFriend.iterator();
      while (localIterator.hasNext()) {
        if (((QMCardFriendInfo)localIterator.next()).getId().equals(paramQMCardFriendInfo.getId())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void setIsExpanded(boolean paramBoolean)
  {
    this.mIsExpanded = paramBoolean;
  }
  
  public void togglerChecked(View paramView, int paramInt)
  {
    QMCardFriendInfo localQMCardFriendInfo = getItem(paramInt);
    paramView = (ImageView)paramView.findViewById(2131364587);
    if (isFriendSelected(localQMCardFriendInfo))
    {
      paramView.setSelected(false);
      removeSelectContact(localQMCardFriendInfo);
      return;
    }
    paramView.setSelected(true);
    addSelectContact(localQMCardFriendInfo);
  }
  
  static class ViewHolder
    extends AvatarViewHolder
  {
    public TextView birthdayTv;
    public ImageView checkbox;
    public TextView nameTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseAdapter
 * JD-Core Version:    0.7.0.1
 */