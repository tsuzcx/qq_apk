package com.tencent.qqmail.maillist.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailRecall;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMAvatarView;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class QMMailRecallAdapter
  extends BaseAdapter
  implements ItemScrollListView.ItemScrollAdapter
{
  public static final int STATE_QUERYED = 2;
  public static final int STATE_QUERYING = 1;
  public static final int STATE_RECALLING = 0;
  private static WeakHashMap<Integer, Bitmap> mDrawableBitmap = new WeakHashMap();
  private Context mContext;
  private LayoutInflater mInflater;
  private Mail mail;
  private List<MailContact> mailContactList;
  private List<MailRecall> mailRecallList;
  private int state;
  
  public QMMailRecallAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  private void showIcon(RecallViewHolder paramRecallViewHolder, boolean paramBoolean)
  {
    paramRecallViewHolder.statusIcon.setVisibility(0);
    paramRecallViewHolder.statusLoading.setVisibility(8);
    if (paramBoolean)
    {
      QMUIHelper.setBackground(paramRecallViewHolder.statusIcon, this.mContext.getResources().getDrawable(2130841070));
      paramRecallViewHolder.statusTips.setTextColor(this.mContext.getResources().getColor(2131167533));
      return;
    }
    QMUIHelper.setBackground(paramRecallViewHolder.statusIcon, this.mContext.getResources().getDrawable(2130841065));
    paramRecallViewHolder.statusTips.setTextColor(this.mContext.getResources().getColor(2131167539));
  }
  
  private void showLoading(RecallViewHolder paramRecallViewHolder, boolean paramBoolean)
  {
    paramRecallViewHolder.statusIcon.setVisibility(8);
    paramRecallViewHolder.statusLoading.setVisibility(0);
    paramRecallViewHolder.statusTips.setTextColor(this.mContext.getResources().getColor(2131167531));
    if (paramBoolean)
    {
      paramRecallViewHolder.statusTips.setText(this.mContext.getString(2131718625));
      return;
    }
    paramRecallViewHolder.statusTips.setText(this.mContext.getString(2131717251));
  }
  
  public int getCount()
  {
    if (this.mailContactList != null) {
      return this.mailContactList.size();
    }
    return -1;
  }
  
  public MailContact getItem(int paramInt)
  {
    if (this.mailContactList != null) {
      return (MailContact)this.mailContactList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    MailContact localMailContact = getItem(paramInt);
    if (localMailContact != null) {
      return localMailContact.getId();
    }
    return 0L;
  }
  
  public MailRecall getMailRecallByItem(int paramInt)
  {
    MailContact localMailContact = getItem(paramInt);
    if (localMailContact != null)
    {
      Iterator localIterator = this.mailRecallList.iterator();
      while (localIterator.hasNext())
      {
        MailRecall localMailRecall = (MailRecall)localIterator.next();
        if (localMailRecall.getReceiver().equals(localMailContact.getAddress())) {
          return localMailRecall;
        }
      }
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MailContact localMailContact = getItem(paramInt);
    MailRecall localMailRecall = getMailRecallByItem(paramInt);
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mInflater.inflate(2131562948, paramViewGroup, false);
      localObject = new RecallViewHolder();
      ((RecallViewHolder)localObject).anchor = paramView.findViewById(2131362705);
      ((RecallViewHolder)localObject).avatar = ((QMAvatarView)paramView.findViewById(2131376822));
      ((RecallViewHolder)localObject).statusLoading = ((QMLoading)paramView.findViewById(2131376824));
      ((RecallViewHolder)localObject).statusIcon = ((ImageView)paramView.findViewById(2131376823));
      ((RecallViewHolder)localObject).address = ((TextView)paramView.findViewById(2131376821));
      ((RecallViewHolder)localObject).nickName = ((TextView)paramView.findViewById(2131376825));
      ((RecallViewHolder)localObject).statusTips = ((TextView)paramView.findViewById(2131376826));
      paramView.setTag(localObject);
    }
    for (;;)
    {
      RecallViewHolder localRecallViewHolder = (RecallViewHolder)paramView.getTag();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRecallViewHolder.anchor.getLayoutParams();
      Bitmap localBitmap2;
      int i;
      if (QMSettingManager.sharedInstance().getMailListIcon())
      {
        localRecallViewHolder.avatar.setVisibility(0);
        localBitmap2 = QMPrivateProtocolManager.getPhotoBitmapByEmail(localMailContact.getAddress(), 3);
        if (localBitmap2 != null)
        {
          i = localBitmap2.hashCode();
          if (i == 0) {
            break label435;
          }
          Bitmap localBitmap1 = (Bitmap)mDrawableBitmap.get(Integer.valueOf(i));
          if (localBitmap1 != null)
          {
            localObject = localBitmap1;
            if (!localBitmap1.isRecycled()) {}
          }
          else
          {
            localObject = localRecallViewHolder.avatar.generateAvatar(localBitmap2, localMailContact.getAddress());
            mDrawableBitmap.put(Integer.valueOf(i), localObject);
          }
          localRecallViewHolder.avatar.setAvatarBitmap((Bitmap)localObject);
          label289:
          localLayoutParams.width = this.mContext.getResources().getDimensionPixelSize(2131296637);
          localRecallViewHolder.anchor.setLayoutParams(localLayoutParams);
          label317:
          localRecallViewHolder.address.setText(localMailContact.getAddress());
          localRecallViewHolder.nickName.setText(QMContactManager.sharedInstance().getPossibleNickname(this.mail.getInformation().getAccountId(), localMailContact.getAddress(), localMailContact.getName(), this.mail));
          if ((this.mail.getStatus().isRecall()) && (this.state != 0)) {
            break label494;
          }
          showLoading(localRecallViewHolder, true);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        i = localMailContact.getAddress().hashCode();
        QMPrivateProtocolManager.sharedInstance().loadEmailIcon(localMailContact.getAddress());
        break;
        label435:
        localRecallViewHolder.avatar.setAvatar(localBitmap2, localMailContact.getAddress());
        break label289;
        localRecallViewHolder.avatar.setVisibility(8);
        localLayoutParams.width = this.mContext.getResources().getDimensionPixelSize(2131299254);
        localRecallViewHolder.anchor.setLayoutParams(localLayoutParams);
        break label317;
        label494:
        if ((localMailRecall == null) || (this.state == 1)) {
          showLoading(localRecallViewHolder, false);
        } else if (this.state == 2) {
          if (localMailRecall != null)
          {
            switch (localMailRecall.getStatus())
            {
            default: 
              localRecallViewHolder.statusTips.setText(this.mContext.getString(2131718618));
              showLoading(localRecallViewHolder, false);
              break;
            case 0: 
            case 1: 
              localRecallViewHolder.statusTips.setText(this.mContext.getString(2131718625));
              showLoading(localRecallViewHolder, false);
              break;
            case 2: 
              localRecallViewHolder.statusTips.setText(this.mContext.getString(2131718623));
              showIcon(localRecallViewHolder, true);
              break;
            case 3: 
              localRecallViewHolder.statusTips.setText(this.mContext.getString(2131718620));
              showIcon(localRecallViewHolder, false);
              break;
            case 4: 
              localRecallViewHolder.statusTips.setText(this.mContext.getString(2131718618));
              showIcon(localRecallViewHolder, false);
              break;
            case 5: 
              localRecallViewHolder.statusTips.setText(this.mContext.getString(2131718617));
              showIcon(localRecallViewHolder, false);
              break;
            }
          }
          else
          {
            localRecallViewHolder.statusTips.setText(this.mContext.getString(2131718618));
            showIcon(localRecallViewHolder, false);
          }
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  public int isEnabledScroll(int paramInt)
  {
    return 0;
  }
  
  public void setMail(Mail paramMail)
  {
    this.mail = paramMail;
  }
  
  public void setMailContactList(List<MailContact> paramList)
  {
    this.mailContactList = paramList;
  }
  
  public void setMailRecallList(List<MailRecall> paramList)
  {
    this.mailRecallList = paramList;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void updateAvatar(ListView paramListView, List<String> paramList)
  {
    int i = paramListView.getFirstVisiblePosition();
    RecallViewHolder localRecallViewHolder;
    MailContact localMailContact;
    Bitmap localBitmap3;
    if (i < paramListView.getLastVisiblePosition()) {
      if (paramListView.getChildAt(i) != null)
      {
        localRecallViewHolder = (RecallViewHolder)paramListView.getChildAt(i).getTag();
        localMailContact = getItem(i);
        if ((localRecallViewHolder != null) && (localMailContact != null) && (paramList != null) && (paramList.contains(localMailContact.getAddress())))
        {
          localBitmap3 = QMPrivateProtocolManager.getPhotoBitmapByEmail(localMailContact.getAddress(), 3);
          if (localBitmap3 == null) {
            break label179;
          }
        }
      }
    }
    label179:
    for (int j = localBitmap3.hashCode();; j = 0)
    {
      if (j != 0)
      {
        Bitmap localBitmap2 = (Bitmap)mDrawableBitmap.get(Integer.valueOf(j));
        Bitmap localBitmap1;
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap2.isRecycled()) {}
        }
        else
        {
          localBitmap1 = localRecallViewHolder.avatar.generateAvatar(localBitmap3, localMailContact.getAddress());
          mDrawableBitmap.put(Integer.valueOf(j), localBitmap1);
        }
        localRecallViewHolder.avatar.setAvatarBitmap(localBitmap1);
      }
      i += 1;
      break;
      return;
    }
  }
  
  static class RecallViewHolder
  {
    TextView address;
    View anchor;
    QMAvatarView avatar;
    TextView nickName;
    ImageView statusIcon;
    QMLoading statusLoading;
    TextView statusTips;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.adapter.QMMailRecallAdapter
 * JD-Core Version:    0.7.0.1
 */