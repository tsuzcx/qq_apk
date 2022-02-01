package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.setting.SettingAboutActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class SchemaSetting
  extends SchemaBase
{
  private static final String PARAM_PAGE = "page";
  private static final String TAG = "SchemaSetting";
  private static final String VALUE_ABOUT = "about";
  private String page;
  
  public SchemaSetting(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!StringExtention.isNullOrEmpty(this.page))
    {
      localObject1 = localObject2;
      if (this.page.equals("about")) {
        localObject1 = SettingAboutActivity.createIntent();
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
            if (str.equals("page")) {
              this.page = ((String)localObject);
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
      QMLog.log(6, "SchemaSetting", localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaSetting
 * JD-Core Version:    0.7.0.1
 */