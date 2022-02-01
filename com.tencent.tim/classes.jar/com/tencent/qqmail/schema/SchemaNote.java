package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.note.NoteListActivity;
import com.tencent.qqmail.note.ReadNoteActivity;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaNote
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_CONTENT = "content";
  private static final String PARAM_NOTE_ID = "noteid";
  private static final String PARAM_SUBJECT = "subject";
  private static final String TAG = "SchemaNote";
  private static final String VALUE_LIST = "list";
  private static final String VALUE_READ = "read";
  private static final String VALUE_WRITE = "write";
  private String action;
  private String content;
  private String noteId;
  private String subject;
  
  public SchemaNote(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (AccountManager.shareInstance().getAccountList().getDefaultNoteAccount() != null)
    {
      QMSettingManager.sharedInstance().setNoteDisplay(true);
      localObject1 = localObject2;
      if (this.action != null)
      {
        if (!this.action.equals("list")) {
          break label74;
        }
        localObject1 = NoteListActivity.createIntent();
      }
    }
    while (localObject1 != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject1).putExtra("animationType", paramInt);
      this.context.startActivity((Intent)localObject1);
      return true;
      label74:
      if (this.action.equals("write"))
      {
        localObject1 = localObject2;
        if (this.subject != null)
        {
          localObject1 = localObject2;
          if (this.content != null) {
            localObject1 = ComposeNoteActivity.createIntent(this.subject, this.content);
          }
        }
      }
      else
      {
        localObject1 = localObject2;
        if (this.action.equals("read"))
        {
          localObject1 = localObject2;
          if (this.noteId != null)
          {
            localObject1 = new Intent(QMApplicationContext.sharedInstance(), ReadNoteActivity.class);
            ((Intent)localObject1).putExtra("noteId", this.noteId);
            continue;
            localObject1 = LoginFragmentActivity.createIntentFromSchema("NOTE", "", String.valueOf(AccountType.qqmail));
          }
        }
      }
    }
    return false;
  }
  
  public void parseParams()
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        if (this.params != null)
        {
          String[] arrayOfString = this.params.split("&");
          int j = arrayOfString.length;
          if (i < j)
          {
            localObject = arrayOfString[i].split("=");
            if (localObject.length != 2) {
              break label152;
            }
            str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("action")) {
              this.action = ((String)localObject);
            } else if (str.equals("noteid")) {
              this.noteId = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaNote", localException.getMessage());
      }
      return;
      if (str.equals("subject")) {
        this.subject = ((String)localObject);
      } else if (str.equals("content")) {
        this.content = ((String)localObject);
      }
      label152:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaNote
 * JD-Core Version:    0.7.0.1
 */