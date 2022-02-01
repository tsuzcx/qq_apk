package com.tencent.qqmail.model.uidomain;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.InterAppsManager;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.common.CommUtils.Callback;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SendMailInterAppsManager
  extends InterAppsManager
{
  private static final String TAG = "SendMailInterAppsManager";
  private static final SendMailInterAppsManager instance = new SendMailInterAppsManager();
  private static int mCount = 0;
  private int mBoundaryValue = 0;
  private CommUtils.Callback mCallback;
  
  public static SendMailInterAppsManager getInstance()
  {
    return instance;
  }
  
  public int getBoundaryValue()
  {
    return this.mBoundaryValue;
  }
  
  public CommUtils.Callback getCallback()
  {
    return this.mCallback;
  }
  
  public void handleCommand(Intent paramIntent)
  {
    Object localObject1;
    do
    {
      try
      {
        mCount += 1;
        if ((paramIntent == null) || (mCount > 99)) {
          return;
        }
      }
      finally {}
      localObject1 = paramIntent.getAction();
      Log.d("SendMailInterAppsManager", "InterAppsManager#handleCommand: " + (String)localObject1);
    } while ((!"android.intent.action.VIEW".equals(localObject1)) && (!"android.intent.action.SENDTO".equals(localObject1)) && (!"android.intent.action.SEND".equals(localObject1)) && (!"android.intent.action.SEND_MULTIPLE".equals(localObject1)));
    Object localObject2 = paramIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    addAddresses(this.toList, (String[])localObject2);
    localObject2 = paramIntent.getStringArrayExtra("android.intent.extra.CC");
    addAddresses(this.ccList, (String[])localObject2);
    localObject2 = paramIntent.getStringArrayExtra("android.intent.extra.BCC");
    addAddresses(this.bccList, (String[])localObject2);
    this.subject = paramIntent.getStringExtra("android.intent.extra.SUBJECT");
    localObject2 = paramIntent.getData();
    if (localObject2 != null)
    {
      if (!"mailto".equals(((Uri)localObject2).getScheme())) {
        break label384;
      }
      parseMailTo(((Uri)localObject2).toString());
    }
    for (;;)
    {
      this.content = paramIntent.getCharSequenceExtra("android.intent.extra.TEXT");
      QMLog.log(4, "SendMailInterAppsManager", "share content " + this.content);
      if (!TextUtils.isEmpty(this.content)) {
        this.content = this.content.toString().replace("\n", "<br>");
      }
      if ((!"android.intent.action.SEND".equals(localObject1)) || (!paramIntent.hasExtra("android.intent.extra.STREAM"))) {
        break label488;
      }
      localObject2 = paramIntent.getParcelableExtra("android.intent.extra.STREAM");
      if (!(localObject2 instanceof Uri)) {
        break label488;
      }
      localObject3 = (Uri)localObject2;
      localObject2 = CommUtils.contentUri2Path(QMApplicationContext.sharedInstance(), (Uri)localObject3);
      if ((localObject2 != null) && (!((String)localObject2).equals("")) && (FileUtil.isFileExist((String)localObject2))) {
        break;
      }
      Toast.makeText(QMApplicationContext.sharedInstance(), "文件名含有非法字符，无法添加!", 0).show();
      QMLog.log(5, "SendMailInterAppsManager", "handleCommand. file not exist. filePath:" + (String)localObject2 + ", uri:" + localObject3);
      return;
      label384:
      if ("file".equals(((Uri)localObject2).getScheme())) {
        this.fileUris.add(((Uri)localObject2).getPath());
      }
    }
    if (FileUtil.isFileDir((String)localObject2))
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "暂不支持添加文件夹为附件!", 0).show();
      return;
    }
    Object localObject3 = this.fileUris.iterator();
    while (((Iterator)localObject3).hasNext()) {
      if (((String)localObject2).equals((String)((Iterator)localObject3).next())) {
        return;
      }
    }
    this.fileUris.add(localObject2);
    label488:
    if (("android.intent.action.SEND_MULTIPLE".equals(localObject1)) && (paramIntent.hasExtra("android.intent.extra.STREAM")))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      if (paramIntent != null) {
        paramIntent = paramIntent.iterator();
      }
    }
    label722:
    for (;;)
    {
      if (paramIntent.hasNext())
      {
        localObject1 = (Parcelable)paramIntent.next();
        if ((localObject1 instanceof Uri))
        {
          localObject2 = (Uri)localObject1;
          localObject1 = CommUtils.contentUri2Path(QMApplicationContext.sharedInstance(), (Uri)localObject2);
          if ((localObject1 == null) || (((String)localObject1).equals("")) || (!FileUtil.isFileExist((String)localObject1)))
          {
            Toast.makeText(QMApplicationContext.sharedInstance(), "文件名含有非法字符，无法添加!", 0).show();
            QMLog.log(5, "SendMailInterAppsManager", "handleCommand. file not exist. filePath:" + (String)localObject1 + ", uri:" + localObject2);
          }
          else if (FileUtil.isFileDir((String)localObject1))
          {
            Toast.makeText(QMApplicationContext.sharedInstance(), "暂不支持添加文件夹为附件!", 0).show();
          }
          else
          {
            localObject2 = this.fileUris.iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
            } while (!((String)localObject1).equals((String)((Iterator)localObject2).next()));
          }
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label722;
          }
          this.fileUris.add(localObject1);
          break;
          this.isFromOtherApp = true;
          return;
        }
      }
    }
  }
  
  public void partRecycle()
  {
    if ((this.fileUris == null) || (this.fileUris.size() <= 0)) {
      recycle();
    }
    for (;;)
    {
      return;
      if (this.mBoundaryValue == 0)
      {
        recycle();
        return;
      }
      int i = this.fileUris.size() - 1;
      while ((i >= this.mBoundaryValue) && (i >= 0))
      {
        this.fileUris.remove(i);
        i -= 1;
      }
    }
  }
  
  public void recycle()
  {
    super.recycle();
    try
    {
      mCount = 0;
      if (this.mCallback != null)
      {
        this.mCallback.call();
        this.mCallback = null;
      }
      return;
    }
    finally {}
  }
  
  public void resetBoundaryValue()
  {
    this.mBoundaryValue = 0;
  }
  
  public void setBoundaryValue()
  {
    this.mBoundaryValue = this.fileUris.size();
  }
  
  public void setCallback(CommUtils.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.SendMailInterAppsManager
 * JD-Core Version:    0.7.0.1
 */