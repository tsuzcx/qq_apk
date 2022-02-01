package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.namelist.NameListUIHelper;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.namelist.watcher.AddNameListWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class NameListMainFragment$18
  implements AddNameListWatcher
{
  NameListMainFragment$18(NameListMainFragment paramNameListMainFragment) {}
  
  public void onBefore(int paramInt1, int paramInt2, String[] paramArrayOfString) {}
  
  public void onError(int paramInt1, int paramInt2, String[] paramArrayOfString, QMNetworkError paramQMNetworkError)
  {
    NameListMainFragment.access$2600(this.this$0, this.this$0.getString(2131690880));
  }
  
  public void onSuccess(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    this.this$0.refreshData();
    NameListMainFragment.access$2400(this.this$0, this.this$0.getString(2131690881));
    NameListUIHelper.scrollTopNewContact(NameListMainFragment.access$200(this.this$0), NameListMainFragment.access$1500(this.this$0), NameListContact.generateId(paramInt1, paramArrayOfString[0]));
    if (NameListMainFragment.access$100(this.this$0) == NameListContact.NameListContactType.WHITE.ordinal())
    {
      DataCollector.logEvent("Event_White_Name_List_Add_To_List_Success");
      if (NameListMainFragment.access$2500(this.this$0) == NameListAddFragment.NameListAddChooseType.INPUT.ordinal()) {
        DataCollector.logEvent("Event_Black_White_Name_List_Add_White_By_Input");
      }
    }
    do
    {
      do
      {
        return;
        if (NameListMainFragment.access$2500(this.this$0) == NameListAddFragment.NameListAddChooseType.CONTACT.ordinal())
        {
          DataCollector.logEvent("Event_Black_White_Name_List_Add_White_By_Choose_Contact");
          return;
        }
      } while (NameListMainFragment.access$2500(this.this$0) != NameListAddFragment.NameListAddChooseType.RECENT.ordinal());
      DataCollector.logEvent("Event_Black_White_Name_List_Add_White_By_Choose_Recent");
      return;
      DataCollector.logEvent("Event_Black_Name_List_Add_To_List_Success");
      if (NameListMainFragment.access$2500(this.this$0) == NameListAddFragment.NameListAddChooseType.INPUT.ordinal())
      {
        DataCollector.logEvent("Event_Black_White_Name_List_Add_Black_By_Input");
        return;
      }
      if (NameListMainFragment.access$2500(this.this$0) == NameListAddFragment.NameListAddChooseType.CONTACT.ordinal())
      {
        DataCollector.logEvent("Event_Black_White_Name_List_Add_Black_By_Choose_Contact");
        return;
      }
    } while (NameListMainFragment.access$2500(this.this$0) != NameListAddFragment.NameListAddChooseType.RECENT.ordinal());
    DataCollector.logEvent("Event_Black_White_Name_List_Add_Black_By_Choose_Recent");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.18
 * JD-Core Version:    0.7.0.1
 */