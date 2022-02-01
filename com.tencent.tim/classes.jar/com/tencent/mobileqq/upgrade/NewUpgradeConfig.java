package com.tencent.mobileqq.upgrade;

import akrf;
import android.os.Parcel;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;

public class NewUpgradeConfig
  implements Serializable
{
  private static String TAG = "NewUpgradeConfig";
  private static NewUpgradeConfig a;
  public a dialog;
  
  private NewUpgradeConfig() {}
  
  public NewUpgradeConfig(Parcel paramParcel) {}
  
  public static NewUpgradeConfig getInstance()
  {
    try
    {
      if (a == null) {
        a = new NewUpgradeConfig();
      }
      NewUpgradeConfig localNewUpgradeConfig = a;
      return localNewUpgradeConfig;
    }
    finally {}
  }
  
  public void parseConfig4Dialog(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    a.prepareDialog();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        int i = localXmlPullParser.getEventType();
        if (i == 1) {
          break;
        }
        if (i == 2)
        {
          paramString = localXmlPullParser.getName();
          if (paramString.equalsIgnoreCase("configId")) {
            a.dialog.id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          }
        }
        else
        {
          i = localXmlPullParser.next();
          continue;
        }
        if (paramString.equalsIgnoreCase("taskName"))
        {
          a.dialog.name = localXmlPullParser.nextText();
          continue;
        }
        if (!paramString.equalsIgnoreCase("taskTime")) {
          break label212;
        }
      }
      catch (Exception paramString)
      {
        a.dialog = null;
        if (QLog.isDevelopLevel()) {
          QLog.d(TAG, 4, "updateDialogParseFail : " + paramString.getMessage());
        }
        paramString.printStackTrace();
        return;
      }
      a.dialog.time = akrf.ah(localXmlPullParser.nextText());
      continue;
      label212:
      if (paramString.equalsIgnoreCase("showTime")) {
        a.dialog.showTime = akrf.ah(localXmlPullParser.nextText());
      } else if (paramString.equalsIgnoreCase("title")) {
        a.dialog.title = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("content")) {
        a.dialog.content = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("desc")) {
        a.dialog.desc = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("installFail")) {
        a.dialog.csb = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("info")) {
        a.dialog.info = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("yellowBar")) {
        a.dialog.aCm = Integer.valueOf(localXmlPullParser.nextText()).intValue();
      } else if (paramString.equalsIgnoreCase("barContent")) {
        a.dialog.csc = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("barContent2")) {
        a.dialog.csd = localXmlPullParser.nextText();
      } else if (paramString.equalsIgnoreCase("lBtnText")) {
        a.dialog.cse = localXmlPullParser.getText();
      } else if (paramString.equalsIgnoreCase("rBtnText")) {
        a.dialog.csf = localXmlPullParser.getText();
      }
    }
  }
  
  public void prepareDialog()
  {
    this.dialog = new a();
  }
  
  public static class a
  {
    public int aCm;
    public boolean cTi;
    public String content;
    public String csb;
    public String csc;
    public String csd;
    public String cse;
    public String csf;
    public int dYf;
    public int dYg;
    public int dYh;
    public int dYi;
    public String desc;
    public int id;
    public String info;
    public String name;
    public long showTime;
    public long time;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeConfig
 * JD-Core Version:    0.7.0.1
 */