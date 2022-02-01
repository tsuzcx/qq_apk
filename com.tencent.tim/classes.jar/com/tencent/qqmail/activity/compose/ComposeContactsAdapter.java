package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.fragment.ContactsSelectAdapter;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactComposeListCursor;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMListItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class ComposeContactsAdapter
  extends ContactsSelectAdapter
  implements SectionIndexer
{
  private Context context;
  private ContactBaseListCursor cursor;
  private int defaultShowCount = 10;
  private boolean hasShowAll = true;
  private boolean hideEmailCount;
  private int historyContactCount;
  private int offsetIndex;
  private HashMap<String, Integer> sectionMap;
  
  public ComposeContactsAdapter(Context paramContext, ContactBaseListCursor paramContactBaseListCursor)
  {
    super(true);
    this.context = paramContext;
    this.cursor = paramContactBaseListCursor;
    initComposeContactLogic();
  }
  
  private String getCategory(MailContact paramMailContact)
  {
    return this.cursor.getCategory(paramMailContact);
  }
  
  private int getInsetLeft(ViewHolder paramViewHolder)
  {
    int j = this.context.getResources().getDimensionPixelSize(2131297032);
    int i = j;
    if (paramViewHolder.selectCheckBox != null)
    {
      i = j;
      if (paramViewHolder.selectCheckBox.getVisibility() != 8) {
        i = j + paramViewHolder.selectCheckBox.getWidth() + this.context.getResources().getDimensionPixelSize(2131297019);
      }
    }
    return i;
  }
  
  private void initComposeContactLogic()
  {
    if ((this.cursor instanceof ContactComposeListCursor))
    {
      this.historyContactCount = ((ContactComposeListCursor)this.cursor).getHistoryContactCount();
      if (this.historyContactCount > this.defaultShowCount)
      {
        this.offsetIndex = (this.historyContactCount - this.defaultShowCount);
        this.hasShowAll = false;
      }
    }
  }
  
  public void addSelectContacts(ArrayList<MailContact> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        addSelectContact((MailContact)paramArrayList.next());
      }
    }
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    if (this.cursor == null)
    {
      QMLog.log(6, "Contact", "cursor == null", new NullPointerException());
      return -1;
    }
    if (this.hasShowAll) {
      return this.cursor.getCount();
    }
    return this.cursor.getCount() - this.historyContactCount + this.defaultShowCount;
  }
  
  public int getDefaultShowCount()
  {
    return this.defaultShowCount;
  }
  
  public int getHistoryContactCount()
  {
    return this.historyContactCount;
  }
  
  public MailContact getItem(int paramInt)
  {
    if (this.cursor == null) {
      return null;
    }
    if (this.hasShowAll) {
      return this.cursor.getItem(paramInt);
    }
    if (paramInt < this.defaultShowCount) {
      return this.cursor.getItem(paramInt);
    }
    return this.cursor.getItem(this.offsetIndex + paramInt);
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
      localView = View.inflate(this.context, 2131559045, null);
      paramView = new ViewHolder(null);
      paramView.container = ((QMListItemView)localView.findViewById(2131365144));
      paramView.category = ((TextView)localView.findViewById(2131365143));
      paramView.nameTextView = ((TextView)localView.findViewById(2131365146));
      paramView.addressTextView = ((TextView)localView.findViewById(2131365142));
      paramView.selectCheckBox = ((CheckBox)localView.findViewById(2131365147));
      paramView.vipIcon = ((ImageView)localView.findViewById(2131382021));
      localView.setTag(paramView);
    }
    for (;;)
    {
      ViewHolder localViewHolder = (ViewHolder)localView.getTag();
      MailContact localMailContact = getItem(paramInt);
      Object localObject = getCategory(localMailContact);
      int i;
      if ((paramInt == 0) && (localObject != null))
      {
        localViewHolder.category.setText(((String)localObject).toUpperCase(Locale.getDefault()));
        localViewHolder.category.setVisibility(0);
        localViewHolder.category.setOnClickListener(null);
        i = 1;
        localObject = localMailContact.getName();
        paramView = (View)localObject;
        if (localMailContact.getType() == MailContact.ContactType.QQFriendContact)
        {
          paramView = (View)localObject;
          if (!StringUtils.isEmpty(localMailContact.getMark())) {
            paramView = localMailContact.getMark();
          }
        }
        localObject = paramView;
        if (StringUtils.isEmpty(paramView)) {
          localObject = this.context.getString(2131692061);
        }
        localViewHolder.nameTextView.setText((String)localObject + QMUIKit.ELLIPSIZE_FIXED);
        paramView = new StringBuilder();
        paramView.append(localMailContact.getAddress());
        if (!this.hideEmailCount)
        {
          localObject = QMContactManager.sharedInstance().getContactEmailCache(localMailContact.getId());
          if (((ArrayList)localObject).size() > 1) {
            paramView.append("(").append(((ArrayList)localObject).size()).append(")");
          }
        }
        localViewHolder.addressTextView.setText(paramView + QMUIKit.ELLIPSIZE_FIXED);
        if (!localMailContact.isVip()) {
          break label603;
        }
        localViewHolder.vipIcon.setVisibility(0);
        label400:
        boolean bool = isContactSelected(localMailContact);
        localViewHolder.selectCheckBox.setChecked(bool);
        localViewHolder.selectCheckBox.setTag(localMailContact.getCid());
        paramView = localViewHolder.container;
        if (i != 0) {
          break label616;
        }
        paramView.setDrawDivider(true, false);
        paramView.updateDividerInsetLeft(getInsetLeft(localViewHolder), 0);
        paramView.addOnLayoutChangeListener(new ComposeContactsAdapter.1(this, paramView, localViewHolder));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        paramView = getItem(paramInt - 1);
        if (paramView == null) {
          paramView = "";
        }
        for (;;)
        {
          if (localObject != null)
          {
            if (!((String)localObject).equals(paramView))
            {
              localViewHolder.category.setText(((String)localObject).toUpperCase(Locale.getDefault()));
              localViewHolder.category.setVisibility(0);
              localViewHolder.category.setOnClickListener(null);
              i = 1;
              break;
              paramView = getCategory(paramView);
              continue;
            }
            localViewHolder.category.setVisibility(8);
            i = 0;
            break;
          }
        }
        localViewHolder.category.setVisibility(8);
        i = 0;
        break;
        label603:
        localViewHolder.vipIcon.setVisibility(8);
        break label400;
        label616:
        paramView.setDrawDivider(false, false);
      }
      localView = paramView;
    }
  }
  
  public boolean isContactSelected(MailContact paramMailContact)
  {
    if (selectContacts != null)
    {
      Iterator localIterator = selectContacts.iterator();
      while (localIterator.hasNext())
      {
        MailContact localMailContact = (MailContact)localIterator.next();
        if ((localMailContact.getId() == paramMailContact.getId()) && (localMailContact.getAddress().equals(paramMailContact.getAddress()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isHasShowAll()
  {
    return this.hasShowAll;
  }
  
  public void setHideEmailCount(boolean paramBoolean)
  {
    this.hideEmailCount = paramBoolean;
  }
  
  public void setSectionMap(HashMap<String, Integer> paramHashMap)
  {
    this.sectionMap = paramHashMap;
  }
  
  public void toggleSelected(View paramView, int paramInt)
  {
    MailContact localMailContact = getItem(paramInt);
    paramView = (CheckBox)paramView.findViewById(2131365147);
    if (isContactSelected(localMailContact))
    {
      paramView.setChecked(false);
      removeSelectContact(localMailContact);
      return;
    }
    paramView.setChecked(true);
    addSelectContact(localMailContact);
  }
  
  class ViewHolder
  {
    TextView addressTextView;
    TextView category;
    QMListItemView container;
    TextView nameTextView;
    CheckBox selectCheckBox;
    ImageView vipIcon;
    
    private ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsAdapter
 * JD-Core Version:    0.7.0.1
 */