package com.tencent.qqmail.activity.contacts.fragment;

import java.util.List;

class ContactsMergeFragment$2
  implements ContactsMergeAdapter.OnItemClickListener
{
  ContactsMergeFragment$2(ContactsMergeFragment paramContactsMergeFragment) {}
  
  public void onChooseNameClick(int paramInt)
  {
    List localList;
    if (paramInt >= 0)
    {
      localList = ContactsMergeFragment.access$400(this.this$0, paramInt);
      if (localList != null) {}
    }
    else
    {
      return;
    }
    this.this$0.startFragmentForResult(new ContactsMergeChooseNameFragment(paramInt, ContactsMergeFragment.access$500(this.this$0).positionChooseName[paramInt], localList), 1000);
  }
  
  public void onEmailListItemClick(int paramInt, boolean paramBoolean)
  {
    if (ContactsMergeFragment.access$500(this.this$0).checkArray[paramInt] != paramBoolean)
    {
      ContactsMergeFragment.access$500(this.this$0).checkArray[paramInt] = paramBoolean;
      ContactsMergeFragment.access$700(this.this$0, paramBoolean);
    }
  }
  
  public void onNameListItemClick(int paramInt, boolean paramBoolean)
  {
    if (ContactsMergeFragment.access$600(this.this$0).checkArray[paramInt] != paramBoolean)
    {
      ContactsMergeFragment.access$600(this.this$0).checkArray[paramInt] = paramBoolean;
      ContactsMergeFragment.access$700(this.this$0, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeFragment.2
 * JD-Core Version:    0.7.0.1
 */