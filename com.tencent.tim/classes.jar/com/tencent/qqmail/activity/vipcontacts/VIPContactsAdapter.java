package com.tencent.qqmail.activity.vipcontacts;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.fragment.ContactViewHolder;
import com.tencent.qqmail.activity.contacts.fragment.ContactsSelectAdapter;
import com.tencent.qqmail.activity.contacts.watcher.ContactPhoneItemWatcher;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAvatarView;
import com.tencent.qqmail.view.QMListItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class VIPContactsAdapter
  extends ContactsSelectAdapter
  implements SectionIndexer
{
  private Context context;
  private ContactBaseListCursor cursor;
  private HashMap<String, Integer> sectionMap;
  
  public VIPContactsAdapter(Context paramContext, ContactBaseListCursor paramContactBaseListCursor)
  {
    super(true);
    this.context = paramContext;
    this.cursor = paramContactBaseListCursor;
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
      localView = View.inflate(this.context, 2131559062, null);
      paramView = new ContactViewHolder();
      paramView.container = ((QMListItemView)localView.findViewById(2131365144));
      paramView.category = ((TextView)localView.findViewById(2131365143));
      paramView.contactName = ((TextView)localView.findViewById(2131365146));
      paramView.contactAddr = ((TextView)localView.findViewById(2131365142));
      paramView.contactCheckBox = ((CheckBox)localView.findViewById(2131365147));
      paramView.avatarView = ((QMAvatarView)localView.findViewById(2131365290));
      paramView.vipIcon = ((ImageView)localView.findViewById(2131382021));
      localView.setTag(paramView);
    }
    for (;;)
    {
      ContactViewHolder localContactViewHolder = (ContactViewHolder)localView.getTag();
      MailContact localMailContact = getItem(paramInt);
      paramView = getCategory(localMailContact);
      int i;
      Object localObject2;
      Object localObject1;
      if ((paramInt == 0) && (paramView != null))
      {
        localContactViewHolder.category.setText(paramView.toUpperCase(Locale.getDefault()));
        localContactViewHolder.category.setVisibility(0);
        localContactViewHolder.category.setOnClickListener(null);
        i = 1;
        localObject2 = localMailContact.getName();
        String str = localMailContact.getMark();
        localObject1 = str;
        paramView = (View)localObject2;
        if (localMailContact.getType() == MailContact.ContactType.QQFriendContact)
        {
          localObject1 = str;
          paramView = (View)localObject2;
          if (!StringUtils.isEmpty(localMailContact.getMark()))
          {
            paramView = localMailContact.getMark();
            localObject1 = localMailContact.getName();
          }
        }
        localObject2 = paramView;
        if (StringUtils.isEmpty(paramView)) {
          localObject2 = this.context.getString(2131692061);
        }
        localContactViewHolder.contactName.setText((String)localObject2 + QMUIKit.ELLIPSIZE_FIXED);
        paramView = QMContactManager.sharedInstance().getContactEmailCache(localMailContact.getId());
        if (StringUtils.isEmpty((CharSequence)localObject1)) {
          break label668;
        }
        localContactViewHolder.contactAddr.setText((CharSequence)localObject1);
        label346:
        if (!localMailContact.isVip()) {
          break label834;
        }
        localContactViewHolder.vipIcon.setVisibility(0);
        localContactViewHolder.contactName.setTextColor(this.context.getResources().getColor(2131167531));
        localContactViewHolder.contactCheckBox.setEnabled(false);
        localContactViewHolder.container.setEnabled(false);
        label402:
        if (!QMSettingManager.sharedInstance().getMailListIcon()) {
          break label896;
        }
        if ((!StringUtils.isEmpty(localMailContact.getName())) || (localMailContact.getType() == MailContact.ContactType.QQFriendContact)) {
          break label886;
        }
        localContactViewHolder.avatarName = "";
        label441:
        localContactViewHolder.avatarView.setVisibility(0);
        ListViewHelper.asyncLoadContactAvatar(new QMAvatar(), localView, localContactViewHolder, localContactViewHolder.avatarName, localMailContact.getAddress(), false);
        label475:
        boolean bool = isContactSelected(localMailContact);
        localContactViewHolder.contactCheckBox.setChecked(bool);
        localContactViewHolder.contactCheckBox.setTag(localMailContact.getCid());
        paramView = localContactViewHolder.container;
        if (i != 0) {
          break label909;
        }
        paramView.setDrawDivider(true, false);
        paramView.updateDividerInsetLeft(getInsetLeft(localContactViewHolder, this.context), 0);
        paramView.addOnLayoutChangeListener(new VIPContactsAdapter.1(this, paramView, localContactViewHolder));
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
        label668:
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localMailContact.getAddress());
        if ((paramView != null) && (paramView.size() > 1)) {
          ((StringBuilder)localObject1).append("(" + paramView.size() + ")");
        }
        if (!StringUtils.isEmpty((CharSequence)localObject1))
        {
          localContactViewHolder.contactAddr.setText(localObject1 + QMUIKit.ELLIPSIZE_FIXED);
          break label346;
        }
        paramView = QMContactManager.sharedInstance().getContactTelCache(localMailContact.getId());
        if ((paramView != null) && (paramView.size() > 0))
        {
          localContactViewHolder.contactAddr.setText(ContactPhoneItemWatcher.formatPhone((String)paramView.get(0)));
          break label346;
        }
        localContactViewHolder.contactAddr.setText("");
        break label346;
        label834:
        localContactViewHolder.vipIcon.setVisibility(8);
        localContactViewHolder.contactName.setTextColor(this.context.getResources().getColor(2131167519));
        localContactViewHolder.contactCheckBox.setEnabled(true);
        localContactViewHolder.container.setEnabled(true);
        break label402;
        label886:
        localContactViewHolder.avatarName = ((String)localObject2);
        break label441;
        label896:
        localContactViewHolder.avatarView.setVisibility(8);
        break label475;
        label909:
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
    paramView = (CheckBox)paramView.findViewById(2131365147);
    if (localMailContact.isVip())
    {
      paramView.setChecked(false);
      return;
    }
    if (isContactSelected(localMailContact))
    {
      paramView.setChecked(false);
      removeSelectContact(localMailContact);
      return;
    }
    paramView.setChecked(true);
    addSelectContact(localMailContact);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsAdapter
 * JD-Core Version:    0.7.0.1
 */