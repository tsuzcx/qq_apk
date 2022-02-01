package com.tencent.qqmail.activity.contacts.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.watcher.ContactPhoneItemWatcher;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAvatarView;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class ContactsListAdapter
  extends ContactsSelectAdapter
  implements SectionIndexer
{
  private Context context;
  private ContactBaseListCursor cursor;
  private HashMap<String, Integer> sectionMap;
  private ArrayList<String> selfEmailList;
  
  public ContactsListAdapter(Context paramContext, ContactBaseListCursor paramContactBaseListCursor, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramBoolean1, paramBoolean2);
    this.context = paramContext;
    this.cursor = paramContactBaseListCursor;
    this.selfEmailList = new ArrayList();
    initSelf();
  }
  
  private String getCategory(MailContact paramMailContact)
  {
    return this.cursor.getCategory(paramMailContact);
  }
  
  private int getInsetLeft(ContactViewHolder paramContactViewHolder, Context paramContext)
  {
    int j = paramContext.getResources().getDimensionPixelSize(2131297032);
    int i = j;
    if (paramContactViewHolder.contactCheckBox != null)
    {
      i = j;
      if (paramContactViewHolder.contactCheckBox.getVisibility() != 8) {
        i = j + paramContactViewHolder.contactCheckBox.getWidth() + paramContext.getResources().getDimensionPixelSize(2131297019);
      }
    }
    j = i;
    if (paramContactViewHolder.avatarView != null)
    {
      j = i;
      if (paramContactViewHolder.avatarView.getVisibility() != 8) {
        j = i + paramContactViewHolder.avatarView.getWidth() + paramContext.getResources().getDimensionPixelSize(2131297017);
      }
    }
    return j;
  }
  
  private void initSelf()
  {
    Threads.runInBackground(new ContactsListAdapter.1(this));
  }
  
  private boolean isSelfMail(ArrayList<String> paramArrayList)
  {
    if ((this.selfEmailList != null) && (paramArrayList != null))
    {
      String str;
      Iterator localIterator2;
      do
      {
        Iterator localIterator1 = this.selfEmailList.iterator();
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          str = (String)localIterator1.next();
          localIterator2 = paramArrayList.iterator();
        }
      } while (!str.equals((String)localIterator2.next()));
      return true;
    }
    return false;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    if (this.cursor == null) {
      return -1;
    }
    return this.cursor.getCount();
  }
  
  public MailContact getItem(int paramInt)
  {
    if (this.cursor == null) {
      return null;
    }
    return this.cursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    MailContact localMailContact = getItem(paramInt);
    if (localMailContact != null) {
      return localMailContact.getId();
    }
    return 0L;
  }
  
  public int getPositionForSection(int paramInt)
  {
    if ((paramInt < 0) || (this.sectionMap == null) || (this.sectionMap.size() == 0)) {
      return 0;
    }
    int i = paramInt;
    if (paramInt >= this.sectionMap.size()) {
      i = this.sectionMap.size() - 1;
    }
    Iterator localIterator = this.sectionMap.entrySet().iterator();
    paramInt = 0;
    int j = 0;
    for (;;)
    {
      if ((!localIterator.hasNext()) || (i == paramInt)) {
        return j + 1;
      }
      j += ((Integer)((Map.Entry)localIterator.next()).getValue()).intValue();
      paramInt += 1;
    }
  }
  
  public int getSectionForPosition(int paramInt)
  {
    return 0;
  }
  
  public Object[] getSections()
  {
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(this.context, 2131559096, null);
      paramView = new ContactViewHolder();
      paramView.itemLayout = ((KeepPressedRelativeLayout)localView.findViewById(2131369468));
      paramView.category = ((TextView)localView.findViewById(2131365291));
      paramView.contactCheckBox = ((CheckBox)localView.findViewById(2131365251));
      paramView.avatarView = ((QMAvatarView)localView.findViewById(2131365290));
      paramView.contactName = ((TextView)localView.findViewById(2131365293));
      paramView.contactAddr = ((TextView)localView.findViewById(2131365292));
      paramView.vipIcon = ((ImageView)localView.findViewById(2131365295));
      paramView.selfTextView = ((TextView)localView.findViewById(2131365294));
      localView.setTag(paramView);
    }
    for (;;)
    {
      ContactViewHolder localContactViewHolder = (ContactViewHolder)localView.getTag();
      MailContact localMailContact = getItem(paramInt);
      paramView = getCategory(localMailContact);
      int i;
      Object localObject2;
      Object localObject3;
      Object localObject1;
      if ((paramInt == 0) && (paramView != null))
      {
        localContactViewHolder.category.setText(paramView.toUpperCase(Locale.getDefault()));
        localContactViewHolder.category.setVisibility(0);
        localContactViewHolder.category.setOnClickListener(null);
        i = 1;
        localObject2 = localMailContact.getName();
        localObject3 = localMailContact.getMark();
        localObject1 = localObject3;
        paramView = (View)localObject2;
        if (localMailContact.getType() == MailContact.ContactType.QQFriendContact)
        {
          localObject1 = localObject3;
          paramView = (View)localObject2;
          if (!StringUtils.isEmpty(localMailContact.getMark()))
          {
            paramView = localMailContact.getMark();
            localObject1 = localMailContact.getName();
          }
        }
        localObject3 = QMContactManager.sharedInstance().getContactEmailCache(localMailContact.getId());
        if (this.isFromBlackWhiteList)
        {
          paramView = localMailContact.getName();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localMailContact.getAddress());
          if ((localObject3 != null) && (((ArrayList)localObject3).size() > 1)) {
            ((StringBuilder)localObject1).append("(" + ((ArrayList)localObject3).size() + ")");
          }
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = paramView;
        if (StringUtils.isEmpty(paramView)) {
          localObject2 = this.context.getString(2131692061);
        }
        localContactViewHolder.contactName.setText((String)localObject2 + QMUIKit.ELLIPSIZE_FIXED);
        if (StringUtils.isEmpty((CharSequence)localObject1)) {
          break label713;
        }
        localContactViewHolder.contactAddr.setText((CharSequence)localObject1);
        label452:
        if ((!isSelfMail((ArrayList)localObject3)) || (this.isFromBlackWhiteList)) {
          break label864;
        }
        localContactViewHolder.selfTextView.setVisibility(0);
        label477:
        if (!localMailContact.isVip()) {
          break label877;
        }
        localContactViewHolder.vipIcon.setVisibility(0);
        label494:
        if (!this.isEditable) {
          break label890;
        }
        boolean bool = isContactSelected(localMailContact);
        localContactViewHolder.contactCheckBox.setChecked(bool);
        localContactViewHolder.contactCheckBox.setTag(localMailContact.getCid());
        localContactViewHolder.contactCheckBox.setVisibility(0);
        localContactViewHolder.avatarView.setVisibility(8);
        label551:
        paramView = localContactViewHolder.itemLayout;
        if (i != 0) {
          break label1019;
        }
        paramView.setDrawDivider(true, false);
        paramView.updateDividerInsetLeft(getInsetLeft(localContactViewHolder, this.context), 0);
        paramView.addOnLayoutChangeListener(new ContactsListAdapter.2(this, paramView, localContactViewHolder));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject1 = getCategory(getItem(paramInt - 1));
        if (paramView != null)
        {
          if (!paramView.equals(localObject1))
          {
            localContactViewHolder.category.setText(paramView.toUpperCase(Locale.getDefault()));
            localContactViewHolder.category.setVisibility(0);
            localContactViewHolder.category.setOnClickListener(null);
            i = 1;
            break;
          }
          localContactViewHolder.category.setVisibility(8);
          i = 0;
          break;
        }
        localContactViewHolder.category.setVisibility(8);
        i = 0;
        break;
        label713:
        paramView = new StringBuilder();
        paramView.append(localMailContact.getAddress());
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 1)) {
          paramView.append("(").append(((ArrayList)localObject3).size()).append(")");
        }
        if (!StringUtils.isEmpty(paramView))
        {
          localContactViewHolder.contactAddr.setText(paramView + QMUIKit.ELLIPSIZE_FIXED);
          break label452;
        }
        paramView = QMContactManager.sharedInstance().getContactTelCache(localMailContact.getId());
        if ((paramView != null) && (paramView.size() > 0))
        {
          localContactViewHolder.contactAddr.setText(ContactPhoneItemWatcher.formatPhone((String)paramView.get(0)));
          break label452;
        }
        localContactViewHolder.contactAddr.setText("");
        break label452;
        label864:
        localContactViewHolder.selfTextView.setVisibility(8);
        break label477;
        label877:
        localContactViewHolder.vipIcon.setVisibility(8);
        break label494;
        label890:
        localContactViewHolder.contactCheckBox.setVisibility(8);
        if (this.isFromBlackWhiteList)
        {
          localContactViewHolder.avatarView.setVisibility(8);
          break label551;
        }
        if (QMSettingManager.sharedInstance().getMailListIcon())
        {
          if ((StringUtils.isEmpty(localMailContact.getName())) && (localMailContact.getType() != MailContact.ContactType.QQFriendContact)) {}
          for (localContactViewHolder.avatarName = "";; localContactViewHolder.avatarName = ((String)localObject2))
          {
            localContactViewHolder.avatarView.setVisibility(0);
            ListViewHelper.asyncLoadContactAvatar(new QMAvatar(), localView, localContactViewHolder, localContactViewHolder.avatarName, localMailContact.getAddress(), false);
            break;
          }
        }
        localContactViewHolder.avatarView.setVisibility(8);
        break label551;
        label1019:
        paramView.setDrawDivider(false, false);
      }
      localView = paramView;
    }
  }
  
  public void setSectionMap(HashMap<String, Integer> paramHashMap)
  {
    this.sectionMap = paramHashMap;
  }
  
  public void toggleSelected(View paramView, int paramInt)
  {
    MailContact localMailContact = getItem(paramInt);
    paramView = (CheckBox)paramView.findViewById(2131365251);
    if (isContactSelected(localMailContact))
    {
      paramView.setChecked(false);
      removeSelectContact(localMailContact);
      return;
    }
    paramView.setChecked(true);
    addSelectContact(localMailContact);
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
                if (str.equals(localMailContact.getAddress()))
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
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListAdapter
 * JD-Core Version:    0.7.0.1
 */