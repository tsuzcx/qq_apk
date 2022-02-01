package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaApp
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_NAME = "name";
  private static final String PARAM_URL = "url";
  private static final String TAG = "SchemaApp";
  private static final String VALUE_BROWSER = "browser";
  private static final String VALUE_OPEN = "open";
  private String action = "";
  private String name = "";
  private String url = "";
  
  public SchemaApp(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    if ((this.action != null) && (this.action.equals("open")) && (this.name != null) && (this.name.equals("browser")) && (this.url != null)) {}
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.url));
        if (localIntent == null) {
          break;
        }
        this.context.startActivity(localIntent);
        return true;
      }
      catch (Exception localException)
      {
        QMLog.log(6, "SchemaApp", localException.getMessage());
      }
      Object localObject = null;
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
              break label133;
            }
            str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("name")) {
              this.name = ((String)localObject);
            } else if (str.equals("action")) {
              this.action = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaApp", localException.getMessage());
      }
      return;
      if (str.equals("url")) {
        this.url = ((String)localObject);
      }
      label133:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaApp
 * JD-Core Version:    0.7.0.1
 */