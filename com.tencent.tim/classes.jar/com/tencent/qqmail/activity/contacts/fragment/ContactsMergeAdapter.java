package com.tencent.qqmail.activity.contacts.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContactsMergeAdapter
  extends BaseAdapter
{
  private static final String TAG = ContactsMergeAdapter.class.getSimpleName();
  private static final int TYPE_GROUP_TITLE = 0;
  private static final int TYPE_MERGE_BY_EMAIL = 2;
  private static final int TYPE_MERGE_BY_NAME = 1;
  private OnItemClickListener mOnItemClickListener;
  private ContactsMergeFragment.MegeByNameData megeByNameData;
  private ContactsMergeFragment.MegeByEmailData mergeByEmalData;
  
  ContactsMergeAdapter(ContactsMergeFragment.MegeByNameData paramMegeByNameData, ContactsMergeFragment.MegeByEmailData paramMegeByEmailData)
  {
    this.megeByNameData = paramMegeByNameData;
    this.mergeByEmalData = paramMegeByEmailData;
  }
  
  static TextView generateEmailTextView(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return null;
    }
    TextView localTextView = new TextView(paramContext);
    if (paramString.trim().equals("")) {
      localTextView.setText(QMApplicationContext.sharedInstance().getString(2131692058));
    }
    for (;;)
    {
      localTextView.setTextColor(paramContext.getResources().getColor(2131167531));
      localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localTextView.setSingleLine(true);
      localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131297027));
      localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      return localTextView;
      localTextView.setText(paramString);
    }
  }
  
  private int getPositionInGroup(int paramInt)
  {
    int i = paramInt;
    if (hasMergeByNameGroup()) {
      if (paramInt != 0) {}
    }
    while ((!hasMergeByEmailGroup()) || (i == 0) || (!isInMergeByEmailContactsGroup(i - 1)))
    {
      return -1;
      if (isInMergeByNameContactsGroup(paramInt - 1)) {
        return paramInt - 1;
      }
      i = paramInt - this.megeByNameData.nameList.size() - 1;
    }
    return i - 1;
  }
  
  private boolean hasMergeByEmailGroup()
  {
    return (this.mergeByEmalData.emailList != null) && (this.mergeByEmalData.emailList.size() > 0);
  }
  
  private boolean hasMergeByNameGroup()
  {
    return (this.megeByNameData.nameList != null) && (this.megeByNameData.nameList.size() > 0);
  }
  
  private boolean isInMergeByEmailContactsGroup(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.mergeByEmalData.emailList.size());
  }
  
  private boolean isInMergeByNameContactsGroup(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.megeByNameData.nameList.size());
  }
  
  public ItemViewHolder createItemViewHolder(View paramView, int paramInt)
  {
    if (1 == paramInt) {
      return new MergeByNameItemHolder(paramView, paramInt);
    }
    if (2 == paramInt) {
      return new MergeByEmailItemHolder(paramView, paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    int i = 0;
    if (hasMergeByNameGroup()) {
      i = this.megeByNameData.nameList.size() + 1;
    }
    int j = i;
    if (hasMergeByEmailGroup()) {
      j = i + (this.mergeByEmalData.emailList.size() + 1);
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    int i = paramInt;
    if (hasMergeByNameGroup())
    {
      if (paramInt == 0) {
        return QMApplicationContext.sharedInstance().getString(2131692051);
      }
      if (isInMergeByNameContactsGroup(paramInt - 1)) {
        return this.megeByNameData.nameList.get(paramInt - 1);
      }
      i = paramInt - this.megeByNameData.nameList.size() - 1;
    }
    if (hasMergeByEmailGroup())
    {
      if (i == 0) {
        return QMApplicationContext.sharedInstance().getString(2131692049);
      }
      if (isInMergeByEmailContactsGroup(i - 1)) {
        return this.mergeByEmalData.emailList.get(i - 1);
      }
    }
    return "";
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (hasMergeByNameGroup()) {
      if (paramInt != 0) {}
    }
    while ((!hasMergeByEmailGroup()) || (i == 0) || (!isInMergeByEmailContactsGroup(i - 1)))
    {
      return 0;
      if (isInMergeByNameContactsGroup(paramInt - 1)) {
        return 1;
      }
      i = paramInt - this.megeByNameData.nameList.size() - 1;
    }
    return 2;
  }
  
  public OnItemClickListener getOnItemClickListener()
  {
    return this.mOnItemClickListener;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt < 0) {}
    int i;
    for (View localView = paramView;; localView = paramView)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return paramView;
      i = getItemViewType(paramInt);
      switch (i)
      {
      }
    }
    Object localObject1;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559101, paramViewGroup, false);
      localObject1 = new GroupViewHolder(localView);
      localView.setTag(localObject1);
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = getItem(paramInt);
      paramView = localView;
      if (!(localObject2 instanceof String)) {
        break;
      }
      ((ViewHolder)localObject1).bindData((String)localObject2, -1);
      paramView = localView;
      break;
      localObject1 = (ViewHolder)paramView.getTag();
      localView = paramView;
    }
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559102, paramViewGroup, false);
      localObject1 = createItemViewHolder(localView, i);
      localView.setTag(localObject1);
      label193:
      localObject2 = getItem(paramInt);
      if (getItemViewType(paramInt + 1) != 0) {
        break label265;
      }
      ((ViewHolder)localObject1).setBackgroundResource(2130845612);
    }
    for (;;)
    {
      paramView = localView;
      if (!(localObject2 instanceof String)) {
        break;
      }
      ((ViewHolder)localObject1).bindData(localObject2, getPositionInGroup(paramInt));
      paramView = localView;
      break;
      localObject1 = (ViewHolder)paramView.getTag();
      localView = paramView;
      break label193;
      label265:
      ((ViewHolder)localObject1).setBackgroundResource(2130850490);
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public static class GroupViewHolder
    implements ContactsMergeAdapter.ViewHolder<String>
  {
    TextView mNameTextView;
    
    public GroupViewHolder(View paramView)
    {
      this.mNameTextView = ((TextView)paramView);
    }
    
    public void bindData(String paramString, int paramInt)
    {
      if (paramString != null) {
        this.mNameTextView.setText(paramString);
      }
    }
    
    public void setBackgroundResource(int paramInt)
    {
      this.mNameTextView.setBackgroundResource(paramInt);
    }
  }
  
  public abstract class ItemViewHolder
    implements ContactsMergeAdapter.ViewHolder<String>
  {
    public boolean isCheck;
    public ImageView mActionImageView;
    public CheckBox mCheckBox;
    public LinearLayout mEmailContainer;
    int mItemType;
    public View mItemView;
    public TextView mNameTextView;
    
    public ItemViewHolder(View paramView, int paramInt)
    {
      this.mCheckBox = ((CheckBox)paramView.findViewById(2131365307));
      this.mNameTextView = ((TextView)paramView.findViewById(2131365308));
      this.mEmailContainer = ((LinearLayout)paramView.findViewById(2131365310));
      this.mActionImageView = ((ImageView)paramView.findViewById(2131365306));
      this.mItemType = paramInt;
      this.mItemView = paramView;
    }
    
    private void initEmalListView(Set<ContactEmail> paramSet)
    {
      this.mEmailContainer.removeAllViews();
      if ((paramSet != null) && (paramSet.size() != 0))
      {
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          Object localObject = (ContactEmail)paramSet.next();
          if (localObject != null)
          {
            localObject = ContactsMergeAdapter.generateEmailTextView(QMApplicationContext.sharedInstance(), ((ContactEmail)localObject).getEmail());
            if (localObject != null) {
              this.mEmailContainer.addView((View)localObject);
            }
          }
        }
      }
    }
    
    private void initPhonesListView(Set<ContactCustom> paramSet)
    {
      this.mEmailContainer.removeAllViews();
      if ((paramSet != null) && (paramSet.size() != 0))
      {
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          Object localObject = (ContactCustom)paramSet.next();
          if (localObject != null)
          {
            localObject = ContactsMergeAdapter.generateEmailTextView(QMApplicationContext.sharedInstance(), ((ContactCustom)localObject).getValue());
            if (localObject != null) {
              this.mEmailContainer.addView((View)localObject);
            }
          }
        }
      }
    }
    
    public void bindData(String paramString, int paramInt)
    {
      Set localSet = getEmails(paramString, paramInt);
      if ((localSet != null) && (localSet.size() != 0))
      {
        initEmalListView(localSet);
        return;
      }
      paramString = getPhones(paramString, paramInt);
      if ((paramString != null) && (paramString.size() != 0))
      {
        initPhonesListView(paramString);
        return;
      }
      this.mEmailContainer.setVisibility(8);
    }
    
    abstract Set<ContactEmail> getEmails(String paramString, int paramInt);
    
    abstract Set<ContactCustom> getPhones(String paramString, int paramInt);
    
    public void setBackgroundResource(int paramInt)
    {
      this.mItemView.setBackgroundResource(paramInt);
    }
  }
  
  public class MergeByEmailItemHolder
    extends ContactsMergeAdapter.ItemViewHolder
  {
    public MergeByEmailItemHolder(View paramView, int paramInt)
    {
      super(paramView, paramInt);
      this.mActionImageView.setVisibility(0);
    }
    
    private void setName(String paramString, int paramInt)
    {
      String str = "(" + paramInt + ")";
      if (TextUtils.isEmpty(paramString))
      {
        this.mNameTextView.setText(QMApplicationContext.sharedInstance().getString(2131692061) + str);
        return;
      }
      this.mNameTextView.setText(paramString + str);
    }
    
    public void bindData(String paramString, int paramInt)
    {
      super.bindData(paramString, paramInt);
      paramString = (List)ContactsMergeAdapter.this.mergeByEmalData.emalContactsMap.get(paramString);
      if (paramString != null) {
        setName(((MailContact)paramString.get(ContactsMergeAdapter.this.mergeByEmalData.positionChooseName[paramInt])).getName(), paramString.size());
      }
      this.mActionImageView.setOnClickListener(new ContactsMergeAdapter.MergeByEmailItemHolder.1(this, paramInt));
      if (ContactsMergeAdapter.this.mergeByEmalData.checkArray[paramInt] != 0) {
        this.mCheckBox.setChecked(true);
      }
      for (;;)
      {
        this.mCheckBox.setOnCheckedChangeListener(new ContactsMergeAdapter.MergeByEmailItemHolder.2(this, paramInt));
        this.mItemView.setOnClickListener(new ContactsMergeAdapter.MergeByEmailItemHolder.3(this, paramInt));
        return;
        this.mCheckBox.setChecked(false);
      }
    }
    
    Set<ContactEmail> getEmails(String paramString, int paramInt)
    {
      return (Set)ContactsMergeAdapter.this.mergeByEmalData.emailToEmailsMap.get(paramString);
    }
    
    Set<ContactCustom> getPhones(String paramString, int paramInt)
    {
      return (Set)ContactsMergeAdapter.this.mergeByEmalData.emailPhonesMap.get(paramString);
    }
  }
  
  public class MergeByNameItemHolder
    extends ContactsMergeAdapter.ItemViewHolder
  {
    public MergeByNameItemHolder(View paramView, int paramInt)
    {
      super(paramView, paramInt);
      this.mActionImageView.setVisibility(8);
    }
    
    private void setName(String paramString)
    {
      Object localObject = (List)ContactsMergeAdapter.this.megeByNameData.nameContactsMap.get(paramString);
      if (localObject != null) {}
      for (int i = ((List)localObject).size();; i = 0)
      {
        localObject = "(" + i + ")";
        if (TextUtils.isEmpty(paramString))
        {
          this.mNameTextView.setText(QMApplicationContext.sharedInstance().getString(2131692061) + (String)localObject);
          return;
        }
        this.mNameTextView.setText(paramString + (String)localObject);
        return;
      }
    }
    
    public void bindData(String paramString, int paramInt)
    {
      super.bindData(paramString, paramInt);
      setName(paramString);
      if (ContactsMergeAdapter.this.megeByNameData.checkArray[paramInt] != 0) {
        this.mCheckBox.setChecked(true);
      }
      for (;;)
      {
        this.mCheckBox.setOnCheckedChangeListener(new ContactsMergeAdapter.MergeByNameItemHolder.1(this, paramInt));
        this.mItemView.setOnClickListener(new ContactsMergeAdapter.MergeByNameItemHolder.2(this, paramInt));
        return;
        this.mCheckBox.setChecked(false);
      }
    }
    
    Set<ContactEmail> getEmails(String paramString, int paramInt)
    {
      return (Set)ContactsMergeAdapter.this.megeByNameData.nameEmailsMap.get(paramString);
    }
    
    Set<ContactCustom> getPhones(String paramString, int paramInt)
    {
      return (Set)ContactsMergeAdapter.this.megeByNameData.namePhonesMap.get(paramString);
    }
  }
  
  public static abstract interface OnItemClickListener
  {
    public abstract void onChooseNameClick(int paramInt);
    
    public abstract void onEmailListItemClick(int paramInt, boolean paramBoolean);
    
    public abstract void onNameListItemClick(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface ViewHolder<T>
  {
    public abstract void bindData(T paramT, int paramInt);
    
    public abstract void setBackgroundResource(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeAdapter
 * JD-Core Version:    0.7.0.1
 */