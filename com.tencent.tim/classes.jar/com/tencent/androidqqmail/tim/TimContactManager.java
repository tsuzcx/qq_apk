package com.tencent.androidqqmail.tim;

import alld;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TimContactManager
{
  private static final boolean ENABLE = false;
  private static final String TAG = "TimContactManager";
  private static final TimContactManager instance = new TimContactManager();
  private final Set<String> contactKeys = new HashSet();
  private Uri uri = Uri.parse("content://tim.MailPluginContactProvider/MailPluginContacts");
  
  private TimContactManager()
  {
    Uri.Builder localBuilder = this.uri.buildUpon();
    localBuilder.appendQueryParameter("uin", QMAppInterface.sharedInstance().getUin());
    this.uri = localBuilder.build();
  }
  
  private void clear()
  {
    QMAppInterface.sharedInstance().getQmApplicationContext().getContentResolver().delete(this.uri, "1", null);
  }
  
  public static TimContactManager getInstance()
  {
    return instance;
  }
  
  private void insert(MailContact paramMailContact)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", Long.valueOf(paramMailContact.getId()));
    localContentValues.put("name", paramMailContact.getName());
    localContentValues.put("pinyin", paramMailContact.getFullPinyin());
    StringBuilder localStringBuilder = new StringBuilder("");
    int j;
    int i;
    if ((paramMailContact.getEmails() != null) && (paramMailContact.getEmails().size() > 1))
    {
      j = paramMailContact.getEmails().size();
      i = 0;
    }
    while (i < j)
    {
      localStringBuilder.append(((ContactEmail)paramMailContact.getEmails().get(i)).getEmail());
      if (i != j - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
      continue;
      localStringBuilder.append(paramMailContact.getAddress());
    }
    localContentValues.put("email", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramMailContact.getAddress())) {
      localContentValues.put("avatarPath", "");
    }
    for (;;)
    {
      Log.i("TimContactManager", "name " + paramMailContact.getName() + " mail " + localStringBuilder);
      QMAppInterface.sharedInstance().getQmApplicationContext().getContentResolver().insert(this.uri, localContentValues);
      return;
      String str = FileUtil.getEmailIconDirPath() + paramMailContact.getAddress() + File.separator;
      localContentValues.put("avatarPath", str + 1);
    }
  }
  
  private void query()
  {
    Cursor localCursor = alld.query(QMAppInterface.sharedInstance().getQmApplicationContext().getContentResolver(), this.uri, null, null, null, null);
    if (localCursor != null)
    {
      Log.i("TimContactManager", "getContentResolver c = " + localCursor.getCount());
      return;
    }
    Log.i("TimContactManager", "getContentResolver c = null");
  }
  
  public void sync() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimContactManager
 * JD-Core Version:    0.7.0.1
 */