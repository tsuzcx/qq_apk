package com.tencent.qqmail.activity.vipcontacts;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.fragment.ContactViewHolder;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAvatarView;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class VIPContactsIndexAdapter
  extends BaseAdapter
{
  private static final int ITEM_VIEW_TYPE_BOTTOM = 2;
  private static final int ITEM_VIEW_TYPE_BUTTON = 5;
  private static final int ITEM_VIEW_TYPE_MIDDLE = 1;
  private static final int ITEM_VIEW_TYPE_SEGMENT = 4;
  private static final int ITEM_VIEW_TYPE_SINGLE = 3;
  private static final int ITEM_VIEW_TYPE_TOP = 0;
  private Context context;
  private LayoutInflater mInflater;
  private ArrayList<MailContact> vipContacts = new ArrayList();
  
  public VIPContactsIndexAdapter(Context paramContext, ArrayList<MailContact> paramArrayList)
  {
    this.context = paramContext;
    this.vipContacts = paramArrayList;
    this.mInflater = LayoutInflater.from(this.context);
  }
  
  private int getInsetLeft(ContactViewHolder paramContactViewHolder)
  {
    int j = this.context.getResources().getDimensionPixelSize(2131297032);
    int i = j;
    if (paramContactViewHolder.avatarView != null)
    {
      i = j;
      if (paramContactViewHolder.avatarView.getVisibility() != 8) {
        i = j + paramContactViewHolder.avatarView.getWidth() + this.context.getResources().getDimensionPixelSize(2131297017);
      }
    }
    return i;
  }
  
  public int getCount()
  {
    return this.vipContacts.size() + 2;
  }
  
  public MailContact getItem(int paramInt)
  {
    if (paramInt < this.vipContacts.size()) {
      return (MailContact)this.vipContacts.get(paramInt);
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
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
    {
      if (getCount() == 3) {
        return 3;
      }
      return 0;
    }
    if (paramInt == getCount() - 1) {
      return 5;
    }
    if (paramInt == getCount() - 2) {
      return 4;
    }
    if (paramInt == getCount() - 3) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    ContactViewHolder localContactViewHolder;
    View localView;
    if (paramView == null)
    {
      localContactViewHolder = new ContactViewHolder();
      if (i == 5)
      {
        paramView = this.mInflater.inflate(2131563321, paramViewGroup, false);
        paramView.setTag(localContactViewHolder);
        localView = paramView;
        label47:
        if (i != 4) {
          break label192;
        }
      }
    }
    label192:
    MailContact localMailContact;
    do
    {
      do
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        if (i == 4)
        {
          paramView = this.mInflater.inflate(2131563323, paramViewGroup, false);
          localContactViewHolder.tagText = ((TextView)paramView.findViewById(2131364133));
          break;
        }
        paramView = this.mInflater.inflate(2131563322, paramViewGroup, false);
        localContactViewHolder.avatarView = ((QMAvatarView)paramView.findViewById(2131365242));
        localContactViewHolder.contactName = ((TextView)paramView.findViewById(2131365253));
        localContactViewHolder.contactAddr = ((TextView)paramView.findViewById(2131365241));
        localContactViewHolder.contactCheckBox = ((CheckBox)paramView.findViewById(2131382011));
        break;
        localContactViewHolder = (ContactViewHolder)paramView.getTag();
        localView = paramView;
        break label47;
      } while (i == 5);
      localMailContact = getItem(paramInt);
    } while (localMailContact == null);
    Object localObject2 = localMailContact.getName();
    paramView = localMailContact.getMark();
    Object localObject1;
    if ((localMailContact.getType() == MailContact.ContactType.QQFriendContact) && (!StringUtils.isEmpty(localMailContact.getMark()))) {
      localObject1 = localMailContact.getName();
    }
    for (;;)
    {
      localObject2 = paramView;
      if (StringUtils.isEmpty(paramView)) {
        localObject2 = this.context.getString(2131692061);
      }
      localContactViewHolder.contactName.setText((String)localObject2 + QMUIKit.ELLIPSIZE_FIXED);
      localContactViewHolder.avatarName = localMailContact.getName();
      if (!StringUtils.isEmpty((CharSequence)localObject1))
      {
        localContactViewHolder.contactAddr.setText((String)localObject1 + QMUIKit.ELLIPSIZE_FIXED);
        label349:
        if (!QMSettingManager.sharedInstance().getMailListIcon()) {
          break label600;
        }
        localObject1 = "";
        paramView = (View)localObject1;
        if (localMailContact.getEmails() != null)
        {
          paramView = (View)localObject1;
          if (localMailContact.getEmails().size() > 0) {
            paramView = ((ContactEmail)localMailContact.getEmails().get(0)).getEmail();
          }
        }
        ListViewHelper.asyncLoadContactAvatar(new QMAvatar(), localView, localContactViewHolder, localContactViewHolder.avatarName, paramView, true);
        label424:
        localContactViewHolder.contactCheckBox.setVisibility(8);
        if (!(localView instanceof KeepPressedRelativeLayout)) {
          break;
        }
        paramView = (KeepPressedRelativeLayout)localView;
        if (i != 3) {
          break label613;
        }
        paramView.setDrawDivider(true, true);
        paramView.updateDividerInsetLeft(0, 0);
      }
      for (;;)
      {
        paramView.addOnLayoutChangeListener(new VIPContactsIndexAdapter.1(this, i, paramView, localContactViewHolder));
        break;
        paramView = new StringBuilder();
        paramView.append(localMailContact.getAddress());
        if ((localMailContact.getEmails() != null) && (localMailContact.getEmails().size() > 1)) {
          paramView.append("(").append(localMailContact.getEmails().size()).append(")");
        }
        if (StringUtils.isEmpty(paramView))
        {
          localContactViewHolder.contactAddr.setText("");
          break label349;
        }
        localContactViewHolder.contactAddr.setText(paramView + QMUIKit.ELLIPSIZE_FIXED);
        break label349;
        label600:
        localContactViewHolder.avatarView.setVisibility(8);
        break label424;
        label613:
        if (i == 0)
        {
          paramView.setDrawDivider(true, true);
          paramView.updateDividerInsetLeft(0, getInsetLeft(localContactViewHolder));
        }
        else if (i == 2)
        {
          paramView.setDrawDivider(false, true);
          paramView.updateDividerInsetLeft(0, 0);
        }
        else if (i == 1)
        {
          paramView.setDrawDivider(false, true);
          paramView.updateDividerInsetLeft(0, getInsetLeft(localContactViewHolder));
        }
      }
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
  
  public void setVipContacts(ArrayList<MailContact> paramArrayList)
  {
    this.vipContacts = paramArrayList;
  }
  
  public void verifyAvatar(ListView paramListView, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = paramListView.getFirstVisiblePosition();
      while (i < paramListView.getLastVisiblePosition())
      {
        View localView = paramListView.getChildAt(i);
        if (localView != null)
        {
          ContactViewHolder localContactViewHolder = (ContactViewHolder)localView.getTag();
          int j = i - paramListView.getHeaderViewsCount();
          if ((j >= 0) && (j < getCount()))
          {
            MailContact localMailContact = getItem(j);
            if ((localContactViewHolder != null) && (localMailContact != null))
            {
              QMAvatar localQMAvatar = new QMAvatar();
              Iterator localIterator = paramList.iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                if ((str.equals(localMailContact.getAddress())) && (localContactViewHolder.avatarView != null))
                {
                  localContactViewHolder.avatarView.setAvatarBitmap(ListViewHelper.generateAvatar(localQMAvatar, QMPrivateProtocolManager.getPhotoBitmapByEmail(str, 3), localContactViewHolder.avatarName));
                  localView.postInvalidate();
                }
              }
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexAdapter
 * JD-Core Version:    0.7.0.1
 */