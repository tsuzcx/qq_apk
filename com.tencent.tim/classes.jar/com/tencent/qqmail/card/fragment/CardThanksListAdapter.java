package com.tencent.qqmail.card.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.common.base.Strings;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.fragment.AvatarViewHolder;
import com.tencent.qqmail.card.cursor.QMCardThanksFriendListCursor;
import com.tencent.qqmail.card.model.QMCardFriendInfo;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.view.QMAvatarView;

public class CardThanksListAdapter
  extends BaseAdapter
{
  private Context mContext;
  private QMCardThanksFriendListCursor mCursor;
  
  public CardThanksListAdapter(Context paramContext, QMCardThanksFriendListCursor paramQMCardThanksFriendListCursor)
  {
    this.mContext = paramContext;
    this.mCursor = paramQMCardThanksFriendListCursor;
  }
  
  public int getCount()
  {
    if (this.mCursor == null) {
      return 0;
    }
    return this.mCursor.getCount();
  }
  
  public QMCardFriendInfo getItem(int paramInt)
  {
    return this.mCursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.mCursor.getItemId(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131558827, paramViewGroup, false);
      paramView = new ViewHolder();
      paramView.avatarView = ((QMAvatarView)localView.findViewById(2131363175));
      paramView.contentTv = ((TextView)localView.findViewById(2131365360));
      localView.setTag(paramView);
      localObject2 = getItem(paramInt);
      if (!Strings.isNullOrEmpty(((QMCardFriendInfo)localObject2).getNickName())) {
        break label231;
      }
      localObject1 = this.mContext.getString(2131692061);
      label92:
      paramView.avatarName = ((String)localObject1);
      paramView.contentTv.setText(String.format(this.mContext.getResources().getString(2131691330), new Object[] { localObject1 }));
      localObject1 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(((QMCardFriendInfo)localObject2).getIcon());
      localObject2 = ((QMCardFriendInfo)localObject2).getIcon();
      if (localObject1 != null) {
        break label241;
      }
      localObject1 = new DownloadInfo();
      ((DownloadInfo)localObject1).setUrl((String)localObject2);
      ((DownloadInfo)localObject1).setImageDownloadListener(new CardThanksListAdapter.1(this, (String)localObject2, paramView));
      ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject1);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
      label231:
      localObject1 = ((QMCardFriendInfo)localObject2).getNickName();
      break label92;
      label241:
      paramView.avatarView.setAvatar((Bitmap)localObject1, paramView.avatarName);
    }
  }
  
  public class ViewHolder
    extends AvatarViewHolder
  {
    TextView contentTv;
    
    public ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardThanksListAdapter
 * JD-Core Version:    0.7.0.1
 */