package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaRead
  extends SchemaBase
{
  private static final String PARAM_FROM_APP = "fromapp";
  private static final String PARAM_LOCAL_MAIL_ID = "localmailid";
  private static final String TAG = "SchemaRead";
  private String fromapp;
  private long localmailid;
  
  public SchemaRead(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.localmailid != 0L)
    {
      localObject1 = localObject2;
      if (this.fromapp != null)
      {
        Mail localMail = QMMailManager.sharedInstance().readMailInfo(this.localmailid);
        localObject1 = localObject2;
        if (localMail != null) {
          localObject1 = MailFragmentActivity.createIntentToReadmailById(localMail.getInformation().getAccountId(), localMail.getInformation().getRemoteId());
        }
      }
    }
    if (localObject1 != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject1).putExtra("animationType", paramInt);
      this.context.startActivity((Intent)localObject1);
      return true;
    }
    return false;
  }
  
  public void parseParams()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.params != null)
        {
          String[] arrayOfString = this.params.split("&");
          int j = arrayOfString.length;
          if (i < j)
          {
            Object localObject = arrayOfString[i].split("=");
            if (localObject.length != 2) {
              break label120;
            }
            String str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("localmailid")) {
              this.localmailid = Long.parseLong((String)localObject);
            } else if (str.equals("fromapp")) {
              this.fromapp = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaRead", localException.getMessage());
      }
      return;
      label120:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaRead
 * JD-Core Version:    0.7.0.1
 */