package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.HashMap;
import moai.fragment.app.FragmentActivity;
import org.apache.commons.lang3.StringUtils;

class ContactEditFragment$9
  implements QMUIDialogAction.ActionListener
{
  ContactEditFragment$9(ContactEditFragment paramContactEditFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    DataCollector.logEvent("Event_Delete_Contact_Click");
    QMContactManager.sharedInstance().deleteContact(ContactEditFragment.access$200(this.this$0));
    if (this.this$0.getBaseFragmentActivity() != null)
    {
      if ((this.this$0.from != 3) && (this.this$0.from != 2)) {
        break label96;
      }
      QMLog.log(4, "ContactEditFragment", "leave edit contact--finish " + this.this$0.from);
      this.this$0.getActivity().finish();
    }
    for (;;)
    {
      paramQMUIDialog.dismiss();
      return;
      label96:
      if (StringUtils.isEmpty(ContactEditFragment.access$900(this.this$0)))
      {
        QMLog.log(4, "ContactEditFragment", "leave edit contact--back");
        HashMap localHashMap = new HashMap();
        localHashMap.put("edit_delete_flag", Boolean.valueOf(true));
        this.this$0.setFragmentResult(-1, localHashMap);
        this.this$0.popBackStack();
        this.this$0.overridePendingTransition(2130772421, 2130772420);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment.9
 * JD-Core Version:    0.7.0.1
 */