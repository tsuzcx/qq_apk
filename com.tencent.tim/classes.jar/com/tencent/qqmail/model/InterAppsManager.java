package com.tencent.qqmail.model;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterAppsManager
{
  private static final String TAG = "InterAppsManager";
  private static final InterAppsManager instance = new InterAppsManager();
  protected List<String> bccList = new ArrayList();
  protected List<String> ccList = new ArrayList();
  protected CharSequence content;
  protected List<String> fileUris = new ArrayList();
  protected String fromApp;
  protected boolean isFromOtherApp = false;
  protected String subject;
  protected List<String> toList = new ArrayList();
  
  public static InterAppsManager getInstance()
  {
    return instance;
  }
  
  protected void addAddresses(List<String> paramList, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramList.add(paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  protected void clear()
  {
    this.toList.clear();
    this.ccList.clear();
    this.bccList.clear();
    this.subject = null;
    this.content = null;
    this.fileUris.clear();
    this.fromApp = null;
    this.isFromOtherApp = false;
  }
  
  public void clearBCC()
  {
    this.bccList.clear();
  }
  
  public void clearCC()
  {
    this.ccList.clear();
  }
  
  public void clearContent()
  {
    this.content = null;
  }
  
  public void clearFile()
  {
    this.fileUris.clear();
  }
  
  public void clearSubject()
  {
    this.subject = null;
  }
  
  public void clearTo()
  {
    this.toList.clear();
  }
  
  protected String decode(String paramString)
    throws UnsupportedEncodingException
  {
    return URLDecoder.decode(paramString, "UTF-8");
  }
  
  public List<String> getBccList()
  {
    return this.bccList;
  }
  
  public List<String> getCcList()
  {
    return this.ccList;
  }
  
  public CharSequence getContent()
  {
    return this.content;
  }
  
  public List<String> getFilePaths()
  {
    return this.fileUris;
  }
  
  public String getFromApp()
  {
    return this.fromApp;
  }
  
  protected List<String> getQueryParameters(Uri paramUri, String paramString)
  {
    try
    {
      paramUri = paramUri.getQueryParameters(paramString);
      return paramUri;
    }
    catch (Exception paramUri)
    {
      Log.e("InterAppsManager", "getQueryParameters ex: " + paramUri);
    }
    return null;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public List<String> getToList()
  {
    return this.toList;
  }
  
  public void handleCommand(Intent paramIntent)
  {
    clear();
    if (paramIntent == null) {}
    String str1;
    do
    {
      return;
      str1 = paramIntent.getAction();
      Log.d("InterAppsManager", "InterAppsManager#handleCommand: " + str1);
    } while ((!"android.intent.action.VIEW".equals(str1)) && (!"android.intent.action.SENDTO".equals(str1)) && (!"android.intent.action.SEND".equals(str1)) && (!"android.intent.action.SEND_MULTIPLE".equals(str1)));
    Object localObject = paramIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    addAddresses(this.toList, (String[])localObject);
    localObject = paramIntent.getStringArrayExtra("android.intent.extra.CC");
    addAddresses(this.ccList, (String[])localObject);
    localObject = paramIntent.getStringArrayExtra("android.intent.extra.BCC");
    addAddresses(this.bccList, (String[])localObject);
    this.subject = paramIntent.getStringExtra("android.intent.extra.SUBJECT");
    localObject = paramIntent.getData();
    if (localObject != null)
    {
      if (!"mailto".equals(((Uri)localObject).getScheme())) {
        break label335;
      }
      parseMailTo(((Uri)localObject).toString());
    }
    for (;;)
    {
      this.content = paramIntent.getCharSequenceExtra("android.intent.extra.TEXT");
      QMLog.log(4, "InterAppsManager", "share content " + this.content);
      if (!TextUtils.isEmpty(this.content)) {
        this.content = this.content.toString().replace("\n", "<br>");
      }
      if ((!"android.intent.action.SEND".equals(str1)) || (!paramIntent.hasExtra("android.intent.extra.STREAM"))) {
        break label401;
      }
      localObject = paramIntent.getParcelableExtra("android.intent.extra.STREAM");
      if (!(localObject instanceof Uri)) {
        break label401;
      }
      localObject = (Uri)localObject;
      localObject = CommUtils.contentUri2Path(QMApplicationContext.sharedInstance(), (Uri)localObject);
      if ((localObject != null) && (!((String)localObject).equals("")) && (FileUtil.isFileExist((String)localObject))) {
        break;
      }
      Toast.makeText(QMApplicationContext.sharedInstance(), "文件不存在,无法添加!", 0).show();
      QMLog.log(5, "InterAppsManager", "handleCommand. file not exist");
      return;
      label335:
      if ("file".equals(((Uri)localObject).getScheme())) {
        this.fileUris.add(((Uri)localObject).getPath());
      }
    }
    if (FileUtil.isFileDir((String)localObject))
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "文件夹无法添加!", 0).show();
      return;
    }
    this.fileUris.add(localObject);
    label401:
    if (("android.intent.action.SEND_MULTIPLE".equals(str1)) && (paramIntent.hasExtra("android.intent.extra.STREAM")))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      if (paramIntent != null) {
        localObject = paramIntent.iterator();
      }
    }
    label672:
    for (;;)
    {
      String str2;
      if (((Iterator)localObject).hasNext())
      {
        paramIntent = (Parcelable)((Iterator)localObject).next();
        if ((paramIntent instanceof Uri))
        {
          paramIntent = (Uri)paramIntent;
          str2 = CommUtils.contentUri2Path(QMApplicationContext.sharedInstance(), paramIntent);
          if ((str2 == null) || (str2.equals("")) || (!FileUtil.isFileExist(str2)))
          {
            str1 = FileUtil.trimFileNameSufix(str2);
            paramIntent = str1;
            if (str1 == null) {
              paramIntent = "";
            }
            Toast.makeText(QMApplicationContext.sharedInstance(), "文件" + paramIntent + "不存在,无法添加!", 0).show();
            QMLog.log(5, "InterAppsManager", "handleCommand. file not exist. filePath:" + str2);
          }
          else if (FileUtil.isFileDir(str2))
          {
            Toast.makeText(QMApplicationContext.sharedInstance(), "文件夹无法添加!", 0).show();
          }
          else
          {
            paramIntent = this.fileUris.iterator();
            do
            {
              if (!paramIntent.hasNext()) {
                break;
              }
            } while (!str2.equals((String)paramIntent.next()));
          }
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label672;
          }
          this.fileUris.add(str2);
          break;
          this.isFromOtherApp = true;
          return;
        }
      }
    }
  }
  
  public boolean hasBCC()
  {
    return this.bccList.size() > 0;
  }
  
  public boolean hasCC()
  {
    return this.ccList.size() > 0;
  }
  
  public boolean hasContent()
  {
    return this.content != null;
  }
  
  public boolean hasFile()
  {
    return this.fileUris.size() > 0;
  }
  
  public boolean hasSubject()
  {
    return this.subject != null;
  }
  
  public boolean hasTo()
  {
    return this.toList.size() > 0;
  }
  
  public boolean isFromOtherApp()
  {
    return this.isFromOtherApp;
  }
  
  protected void parseMailTo(String paramString)
  {
    int i = paramString.indexOf("?");
    int j = "mailto".length() + 1;
    if (i == -1) {}
    for (;;)
    {
      try
      {
        localObject = decode(paramString.substring(j));
        if (localObject != null) {
          addAddresses(this.toList, ((String)localObject).split(" ,"));
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Object localObject;
        Log.e("InterAppsManager", "parseMailTo uee: " + localUnsupportedEncodingException);
        continue;
      }
      paramString = Uri.parse("qqmailfoo://" + paramString);
      localObject = getQueryParameters(paramString, "to");
      if (localObject != null) {
        addAddresses(this.toList, (String[])((List)localObject).toArray(new String[((List)localObject).size()]));
      }
      localObject = getQueryParameters(paramString, "cc");
      if (localObject != null) {
        addAddresses(this.ccList, (String[])((List)localObject).toArray(new String[((List)localObject).size()]));
      }
      localObject = getQueryParameters(paramString, "bcc");
      if (localObject != null) {
        addAddresses(this.bccList, (String[])((List)localObject).toArray(new String[((List)localObject).size()]));
      }
      localObject = getQueryParameters(paramString, "subject");
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.subject = ((String)((List)localObject).get(0));
      }
      paramString = getQueryParameters(paramString, "body");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.content = ((CharSequence)paramString.get(0));
      }
      return;
      localObject = decode(paramString.substring(j, i));
    }
  }
  
  public void recycle()
  {
    clear();
  }
  
  public ArrayList<MailContact> toMailContact(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      MailContact localMailContact = new MailContact();
      localMailContact.setAddress(str);
      localArrayList.add(localMailContact);
    }
    return localArrayList;
  }
  
  public MailInformation toMailInformation()
  {
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InterAppsManager: {toList: " + this.toList).append(", ccList: " + this.ccList).append(", bccList: " + this.bccList).append(", subject: " + this.subject).append(", content: " + this.content).append(", fileUris: " + this.fileUris).append(", fromApp: " + this.fromApp).append(", isFromOtherApp: " + this.isFromOtherApp).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.InterAppsManager
 * JD-Core Version:    0.7.0.1
 */