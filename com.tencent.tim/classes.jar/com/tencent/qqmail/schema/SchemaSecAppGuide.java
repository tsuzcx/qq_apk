package com.tencent.qqmail.schema;

import android.content.Context;
import android.net.Uri;
import com.tencent.qqmail.activity.setting.SecurityAppTipsActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaSecAppGuide
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String TAG = "SchemaSecAppGuide";
  private String action;
  
  public SchemaSecAppGuide(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    if ((this.action != null) && (!this.action.equals("")))
    {
      QMLog.log(4, "SchemaSecAppGuide", "go exec feature:" + this.action);
      SecurityAppTipsActivity.execIntent(this.action);
      DataCollector.logEvent("Event_SecApp_Alert_Gotoset");
    }
    for (;;)
    {
      return false;
      QMLog.log(4, "SchemaSecAppGuide", "feature invalid:" + this.action);
    }
  }
  
  public void parseParams()
  {
    int i = 0;
    try
    {
      if (this.params != null)
      {
        String[] arrayOfString = this.params.split("&");
        int j = arrayOfString.length;
        while (i < j)
        {
          Object localObject = arrayOfString[i].split("=");
          if (localObject.length == 2)
          {
            String str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("action")) {
              this.action = ((String)localObject);
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QMLog.log(6, "SchemaSecAppGuide", localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaSecAppGuide
 * JD-Core Version:    0.7.0.1
 */