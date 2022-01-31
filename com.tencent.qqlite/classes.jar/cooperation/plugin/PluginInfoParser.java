package cooperation.plugin;

import android.util.Xml;
import java.io.StringWriter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlSerializer;

public class PluginInfoParser
  extends DefaultHandler
{
  private static final String jdField_a_of_type_JavaLangString = "PluginInfo";
  private static final String b = "ID";
  private static final String c = "Name";
  private static final String d = "Version";
  private static final String e = "MD5";
  private static final String f = "URL";
  private static final String g = "Type";
  private static final String h = "PackageName";
  private static final String i = "CurVersion";
  private static final String j = "Length";
  private static final String k = "State";
  private static final String l = "Processes";
  private static final String m = "UpdateType";
  private static final String n = "InstallType";
  private PluginInfo jdField_a_of_type_CooperationPluginPluginInfo;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  
  static String a(PluginInfo paramPluginInfo)
  {
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    localXmlSerializer.setOutput(localStringWriter);
    localXmlSerializer.startDocument("utf-8", null);
    localXmlSerializer.startTag("", "PluginInfo");
    localXmlSerializer.startTag("", "ID");
    localXmlSerializer.text(paramPluginInfo.mID);
    localXmlSerializer.endTag("", "ID");
    localXmlSerializer.startTag("", "Name");
    localXmlSerializer.text(paramPluginInfo.mName);
    localXmlSerializer.endTag("", "Name");
    localXmlSerializer.startTag("", "Version");
    localXmlSerializer.text(paramPluginInfo.mVersion);
    localXmlSerializer.endTag("", "Version");
    localXmlSerializer.startTag("", "URL");
    localXmlSerializer.text(paramPluginInfo.mURL);
    localXmlSerializer.endTag("", "URL");
    localXmlSerializer.startTag("", "MD5");
    localXmlSerializer.text(paramPluginInfo.mMD5);
    localXmlSerializer.endTag("", "MD5");
    localXmlSerializer.startTag("", "Type");
    localXmlSerializer.text(String.valueOf(paramPluginInfo.mType));
    localXmlSerializer.endTag("", "Type");
    localXmlSerializer.startTag("", "PackageName");
    localXmlSerializer.text(paramPluginInfo.mPackageName);
    localXmlSerializer.endTag("", "PackageName");
    localXmlSerializer.startTag("", "CurVersion");
    localXmlSerializer.text(String.valueOf(paramPluginInfo.mCurVersion));
    localXmlSerializer.endTag("", "CurVersion");
    localXmlSerializer.startTag("", "Length");
    localXmlSerializer.text(String.valueOf(paramPluginInfo.mLength));
    localXmlSerializer.endTag("", "Length");
    localXmlSerializer.startTag("", "State");
    localXmlSerializer.text(String.valueOf(paramPluginInfo.mState));
    localXmlSerializer.endTag("", "State");
    String str1 = "";
    String str2 = str1;
    if (paramPluginInfo.mProcesses != null)
    {
      String[] arrayOfString = paramPluginInfo.mProcesses;
      int i2 = arrayOfString.length;
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= i2) {
          break;
        }
        str2 = arrayOfString[i1];
        str1 = str1 + str2 + "|";
        i1 += 1;
      }
    }
    localXmlSerializer.startTag("", "Processes");
    localXmlSerializer.text(str2);
    localXmlSerializer.endTag("", "Processes");
    localXmlSerializer.startTag("", "UpdateType");
    localXmlSerializer.text(String.valueOf(paramPluginInfo.mUpdateType));
    localXmlSerializer.endTag("", "UpdateType");
    localXmlSerializer.startTag("", "InstallType");
    localXmlSerializer.text(String.valueOf(paramPluginInfo.mInstallType));
    localXmlSerializer.endTag("", "InstallType");
    localXmlSerializer.endTag("", "PluginInfo");
    localXmlSerializer.endDocument();
    return localStringWriter.toString();
  }
  
  PluginInfo a()
  {
    return this.jdField_a_of_type_CooperationPluginPluginInfo;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endDocument()
  {
    this.jdField_a_of_type_JavaLangStringBuilder = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    if ("ID".equals(paramString2)) {
      this.jdField_a_of_type_CooperationPluginPluginInfo.mID = paramString1;
    }
    do
    {
      return;
      if ("Name".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mName = paramString1;
        return;
      }
      if ("Version".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mVersion = paramString1;
        return;
      }
      if ("URL".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mURL = paramString1;
        return;
      }
      if ("MD5".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mMD5 = paramString1;
        return;
      }
      if ("Type".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mType = Integer.valueOf(paramString1).intValue();
        return;
      }
      if ("PackageName".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mPackageName = paramString1;
        return;
      }
      if ("CurVersion".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mCurVersion = Long.parseLong(paramString1);
        return;
      }
      if ("Length".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mLength = Long.parseLong(paramString1);
        return;
      }
      if ("State".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mState = Integer.parseInt(paramString1);
        return;
      }
      if ("Processes".equals(paramString2))
      {
        if (paramString1 != null)
        {
          this.jdField_a_of_type_CooperationPluginPluginInfo.mProcesses = paramString1.split("\\|");
          return;
        }
        this.jdField_a_of_type_CooperationPluginPluginInfo.mProcesses = new String[0];
        return;
      }
      if ("UpdateType".equals(paramString2))
      {
        this.jdField_a_of_type_CooperationPluginPluginInfo.mUpdateType = Integer.parseInt(paramString1);
        return;
      }
    } while (!"InstallType".equals(paramString2));
    this.jdField_a_of_type_CooperationPluginPluginInfo.mInstallType = Integer.parseInt(paramString1);
  }
  
  public void startDocument()
  {
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if ("PluginInfo".equals(paramString2)) {
      this.jdField_a_of_type_CooperationPluginPluginInfo = new PluginInfo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.plugin.PluginInfoParser
 * JD-Core Version:    0.7.0.1
 */