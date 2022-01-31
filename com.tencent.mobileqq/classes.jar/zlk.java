import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class zlk
  extends DefaultHandler
{
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public zlk(QQAppInterface paramQQAppInterface) {}
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, paramArrayOfChar);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void startDocument()
  {
    super.startDocument();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zlk
 * JD-Core Version:    0.7.0.1
 */