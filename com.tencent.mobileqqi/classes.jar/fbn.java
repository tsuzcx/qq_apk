import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class fbn
  extends DefaultHandler
{
  public static HashMap a;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "0";
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  private boolean jdField_a_of_type_Boolean = false;
  
  private boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return Pattern.compile("^([0-9]{0,5}|\\{([\\s\\S]*)\\})(,([0-9]{0,5}|\\{([\\s\\S]*)\\}))*$").matcher(paramString).matches();
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuffer.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!a(this.jdField_a_of_type_JavaLangStringBuffer.toString()))
      {
        if (QLog.isColorLevel()) {
          QLog.e(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "DPCXmlHandler format is error: " + paramString2 + "-" + this.jdField_a_of_type_JavaLangStringBuffer.toString());
        }
        return;
      }
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) {
        break label222;
      }
      paramString1 = (fbo)jdField_a_of_type_JavaUtilHashMap.get(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "DPCXmlHandler parse to TEMPMAP update oldInfo: " + paramString2 + "-" + paramString1.toString());
      }
      if (paramString1.jdField_a_of_type_Int < this.jdField_a_of_type_Int)
      {
        paramString1.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        paramString1.b = this.jdField_a_of_type_JavaLangStringBuffer.toString();
        paramString1.c = this.jdField_a_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "DPCXmlHandler parse to TEMPMAP update newInfo: " + paramString2 + "-" + paramString1.toString());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      label222:
      paramString1 = new fbo();
      paramString1.jdField_a_of_type_JavaLangString = paramString2;
      paramString1.b = this.jdField_a_of_type_JavaLangStringBuffer.toString();
      paramString1.c = this.jdField_a_of_type_JavaLangString;
      paramString1.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      jdField_a_of_type_JavaUtilHashMap.put(paramString2, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "DPCXmlHandler parse to TEMPMAP add: " + paramString2 + "-" + paramString1.toString());
      }
    }
  }
  
  public void startDocument()
  {
    super.startDocument();
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    int i = 0;
    if (paramString2.equals("features"))
    {
      if (i < paramAttributes.getLength())
      {
        if (paramAttributes.getLocalName(i).equals("weight")) {
          this.jdField_a_of_type_Int = Integer.parseInt(paramAttributes.getValue(i));
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramAttributes.getLocalName(i).equals("taskId")) {
            this.jdField_a_of_type_JavaLangString = paramAttributes.getValue(i);
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangStringBuffer.delete(0, this.jdField_a_of_type_JavaLangStringBuffer.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fbn
 * JD-Core Version:    0.7.0.1
 */