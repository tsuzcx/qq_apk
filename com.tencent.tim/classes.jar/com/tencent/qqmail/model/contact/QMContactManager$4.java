package com.tencent.qqmail.model.contact;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

class QMContactManager$4
  implements QMContactManager.ContactConvWatcher
{
  QMContactManager$4(QMContactManager paramQMContactManager, MailContact paramMailContact) {}
  
  public void onLocalSync(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, boolean paramBoolean)
  {
    MailContact localMailContact = QMContactManager.access$100(this.this$0, this.val$modifyContact, paramMailContact);
    int i;
    if ((localMailContact.getType() == MailContact.ContactType.QQFriendContact) && (!StringUtils.isEmpty(localMailContact.getMark())))
    {
      paramMailContact = new String[1];
      paramMailContact[0] = localMailContact.getMark();
      int j = paramMailContact.length;
      i = 0;
      label56:
      if (i < j)
      {
        CharSequence localCharSequence = paramMailContact[i];
        if (StringUtils.isEmpty(localCharSequence)) {
          break label195;
        }
        paramMailContact = ContactsHelper.generatePinyin(localCharSequence);
        localMailContact.setPinyin((String)paramMailContact.get(0));
        localMailContact.setFullPinyin((String)paramMailContact.get(1));
      }
      if (!paramBoolean) {
        break label204;
      }
      localMailContact.setOfflineType(2);
      QMContactManager.access$200(this.this$0).contact.insertContact(paramSQLiteDatabase, localMailContact.getAccountId(), localMailContact);
    }
    for (;;)
    {
      QMContactManager.access$200(this.this$0).contact.rebuildContactHash(paramSQLiteDatabase, new int[] { localMailContact.getHash() });
      return;
      paramMailContact = new String[2];
      paramMailContact[0] = localMailContact.getName();
      paramMailContact[1] = localMailContact.getNick();
      break;
      label195:
      i += 1;
      break label56;
      label204:
      localMailContact.setOfflineType(1);
      QMContactManager.access$200(this.this$0).contact.updateContact(paramSQLiteDatabase, localMailContact);
    }
  }
  
  public void onRemoteSync(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, boolean paramBoolean)
  {
    paramMailContact = QMContactManager.access$100(this.this$0, this.val$modifyContact, paramMailContact);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMailContact);
    int j;
    int i;
    if ((paramMailContact.getType() == MailContact.ContactType.QQFriendContact) && (!StringUtils.isEmpty(paramMailContact.getMark())))
    {
      paramSQLiteDatabase = new String[1];
      paramSQLiteDatabase[0] = paramMailContact.getMark();
      j = paramSQLiteDatabase.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        CharSequence localCharSequence = paramSQLiteDatabase[i];
        if (!StringUtils.isEmpty(localCharSequence))
        {
          paramSQLiteDatabase = ContactsHelper.generatePinyin(localCharSequence);
          paramMailContact.setPinyin((String)paramSQLiteDatabase.get(0));
          paramMailContact.setFullPinyin((String)paramSQLiteDatabase.get(1));
        }
      }
      else
      {
        if (paramMailContact.getType() != MailContact.ContactType.ProtocolContact) {
          break label210;
        }
        if ((!paramBoolean) && (paramMailContact.getOfflineType() != 2)) {
          break label193;
        }
        QMContactManager.access$300(this.this$0).addContact(paramMailContact.getAccountId(), localArrayList);
        return;
        paramSQLiteDatabase = new String[2];
        paramSQLiteDatabase[0] = paramMailContact.getName();
        paramSQLiteDatabase[1] = paramMailContact.getNick();
        break;
      }
      i += 1;
    }
    label193:
    QMContactManager.access$300(this.this$0).editContact(paramMailContact.getAccountId(), localArrayList);
    return;
    label210:
    if ((paramBoolean) || (paramMailContact.getOfflineType() == 2))
    {
      QMContactManager.access$400(this.this$0).addContact(paramMailContact.getAccountId(), paramMailContact);
      return;
    }
    QMContactManager.access$400(this.this$0).editContact(paramMailContact);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactManager.4
 * JD-Core Version:    0.7.0.1
 */