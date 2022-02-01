package com.tencent.qqmail.activity.compose;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

class MailAddrsViewControl$7
  implements TextWatcher
{
  MailAddrsViewControl$7(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.setSelectedAddrBtn(null);
    MailAddrsViewControl.access$100(this.this$0).setCursorVisible(true);
    int[] arrayOfInt = new int[2];
    MailAddrsViewControl.access$100(this.this$0).getLocationInWindow(arrayOfInt);
    paramInt1 = MailAddrsViewControl.access$200(this.this$0);
    int i = arrayOfInt[0];
    if (((int)((paramCharSequence.length() + paramInt3 - paramInt2) * MailAddrsViewControl.access$100(this.this$0).getTextSize()) > paramInt1 - i) && (MailAddrsViewControl.access$100(this.this$0).getWidth() != MailAddrsViewControl.access$200(this.this$0))) {
      MailAddrsViewControl.access$100(this.this$0).setMaxWidth(MailAddrsViewControl.access$200(this.this$0));
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = paramCharSequence.toString();
    Object localObject2;
    Object localObject3;
    if ((((String)localObject1).endsWith("\n")) || (((String)localObject1).endsWith(" ")))
    {
      localObject2 = Pattern.compile("\"?\\w+\"?<.+>");
      localObject3 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
      if (((Pattern)localObject2).matcher((CharSequence)localObject3).find())
      {
        localObject2 = ContactsHelper.parseAddrs((String)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MailContact)((Iterator)localObject2).next();
          this.this$0.insertMailAddr((MailContact)localObject3);
          this.this$0.clearUpInputArea();
          KvHelper.eventComposeReceiverNickType(new double[0]);
        }
      }
      MailAddrsViewControl.access$1000(this.this$0, (String)localObject1, true);
    }
    for (;;)
    {
      MailAddrsViewControl.mLastInput = (String)localObject1;
      if (MailAddrsViewControl.access$700(this.this$0) != null) {
        MailAddrsViewControl.access$700(this.this$0).addrControlScrollChanged(this.this$0);
      }
      MailAddrsViewControl.access$1100(this.this$0);
      if (MailAddrsViewControl.access$700(this.this$0) != null)
      {
        localObject1 = (MailAddrsViewControl.MailAddressAdapter)MailAddrsViewControl.access$100(this.this$0).getAdapter();
        if (localObject1 != null)
        {
          if (this.this$0.isDefaultSenderNeedExchangePrompt(paramCharSequence.toString())) {
            ((MailAddrsViewControl.MailAddressAdapter)localObject1).setLoading(true);
          }
          ((MailAddrsViewControl.MailAddressAdapter)localObject1).notifyDataSetChanged();
        }
        if (!StringUtils.contains(paramCharSequence, "EmailInfo")) {
          break;
        }
        QMLog.log(2, "alger", "clicksuggestitem triggered textchange  abort:" + paramCharSequence);
      }
      return;
      if (((((String)localObject1).endsWith(",")) || (((String)localObject1).endsWith(";"))) && (((String)localObject1).length() >= 2))
      {
        localObject2 = Pattern.compile("\"?\\w+\"?<.+>");
        localObject3 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        if (((Pattern)localObject2).matcher((CharSequence)localObject3).find())
        {
          localObject2 = ContactsHelper.parseAddrs((String)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MailContact)((Iterator)localObject2).next();
            this.this$0.insertMailAddr((MailContact)localObject3);
            this.this$0.clearUpInputArea();
            KvHelper.eventComposeReceiverNickType(new double[0]);
          }
        }
        else
        {
          MailAddrsViewControl.access$1000(this.this$0, ((String)localObject1).substring(0, ((String)localObject1).length() - 1), true);
        }
      }
    }
    MailAddrsViewControl.access$700(this.this$0).addrControlTextChanged(this.this$0, paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.7
 * JD-Core Version:    0.7.0.1
 */