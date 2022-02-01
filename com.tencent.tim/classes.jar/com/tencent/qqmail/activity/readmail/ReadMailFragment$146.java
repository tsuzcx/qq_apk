package com.tencent.qqmail.activity.readmail;

import alld;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import moai.fragment.app.FragmentActivity;

class ReadMailFragment$146
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$146(ReadMailFragment paramReadMailFragment, String paramString1, String paramString2) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131692640)))
    {
      this.this$0.dial(this.val$telNumber);
      paramQMBottomDialog.dismiss();
      return;
    }
    if (paramString.equals(this.this$0.getString(2131720364)))
    {
      this.this$0.sms(this.val$telNumber);
      paramQMBottomDialog.dismiss();
      return;
    }
    if (paramString.equals(this.this$0.getString(2131721918)))
    {
      paramView = ComposeMailActivity.createIntentWithUri(Uri.parse("mailto:" + this.val$telNumber + "@qq.com"), ReadMailFragment.access$200(this.this$0));
      this.this$0.startActivity(paramView);
      DataCollector.logEvent("Event_Content_Recognize_Compose_Mail_Using_Tel");
      paramQMBottomDialog.dismiss();
      return;
    }
    if (paramString.equals(this.this$0.getString(2131689836)))
    {
      ReadMailFragment.access$23000(this.this$0, this.val$telNumber);
      DataCollector.logEvent("Event_Content_Recognize_Add_To_Contact_Book");
      paramQMBottomDialog.dismiss();
      return;
    }
    int i;
    if (paramString.equals(this.this$0.getString(2131693004)))
    {
      paramView = alld.query(this.this$0.getActivity().getContentResolver(), ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
      if (!paramView.moveToFirst()) {
        break label484;
      }
      paramInt = -1;
      i = paramInt + 1;
      paramString = paramView.getString(paramView.getColumnIndex("display_name"));
      if (!this.val$existName.equals(paramString)) {}
    }
    for (;;)
    {
      for (;;)
      {
        paramView.moveToPosition(i);
        paramString = paramView.getString(paramView.getColumnIndex("lookup"));
        paramString = ContactsContract.Contacts.getLookupUri(paramView.getLong(paramView.getColumnIndex("_id")), paramString);
        try
        {
          Intent localIntent1 = new Intent("android.intent.action.EDIT");
          localIntent1.setDataAndType(paramString, "vnd.android.cursor.item/contact");
          localIntent1.setPackage("com.tencent.pb");
          this.this$0.startActivity(localIntent1);
          DataCollector.logEvent("Event_Content_Recognize_Has_Wx_Book_Edit_Contact_Book");
          paramView.close();
          paramQMBottomDialog.dismiss();
          return;
          paramInt = i;
          if (paramView.moveToNext()) {
            break;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Intent localIntent2 = new Intent("android.intent.action.EDIT");
            localIntent2.setDataAndType(paramString, "vnd.android.cursor.item/contact");
            this.this$0.startActivity(localIntent2);
            DataCollector.logEvent("Event_Content_Recognize_Edit_Contact_Book");
          }
        }
      }
      if (paramString.equals(this.this$0.getString(2131692324)))
      {
        this.this$0.copy(this.val$telNumber);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (!paramString.equals(this.this$0.getString(2131721643))) {
        break;
      }
      this.this$0.downloadWeChatPhoneBook();
      DataCollector.logEvent("Event_Content_Recognize_Use_Wx_Book");
      paramQMBottomDialog.dismiss();
      return;
      label484:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.146
 * JD-Core Version:    0.7.0.1
 */