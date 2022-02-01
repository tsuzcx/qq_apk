import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class afeo
  extends DefaultHandler
{
  private XmlData a;
  private Class<? extends XmlData> clazz;
  private StringBuilder mBuilder;
  
  public afeo(Class<? extends XmlData> paramClass)
  {
    this.clazz = paramClass;
  }
  
  public XmlData a()
  {
    return this.a;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    this.mBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endDocument()
    throws SAXException
  {
    this.mBuilder = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if (this.a == null) {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "endElement() return. data is null.");
      }
    }
    label21:
    label278:
    do
    {
      do
      {
        break label21;
        for (;;)
        {
          return;
          if (!this.clazz.getSimpleName().equals(paramString2))
          {
            paramString1 = afel.findField(this.clazz, paramString2);
            if (paramString1 == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("EarlyDown", 2, "endElement() return.can't find 'Field:" + paramString2);
              return;
            }
            if (!paramString1.isAccessible()) {
              paramString1.setAccessible(true);
            }
            paramString2 = this.mBuilder.toString();
            try
            {
              paramString3 = paramString1.getType();
              if (paramString3 == String.class)
              {
                paramString1.set(this.a, paramString2);
                return;
              }
            }
            catch (NumberFormatException paramString1)
            {
              if (QLog.isColorLevel())
              {
                QLog.e("EarlyDown", 2, "endElement() throws exception:" + paramString1.getMessage());
                return;
                if (paramString3 == Long.TYPE)
                {
                  long l = Long.parseLong(paramString2);
                  paramString1.setLong(this.a, l);
                  return;
                }
              }
            }
            catch (IllegalArgumentException paramString1)
            {
              if (QLog.isColorLevel())
              {
                QLog.e("EarlyDown", 2, "endElement() throws exception:" + paramString1.getMessage());
                return;
                if (paramString3 != Double.TYPE) {
                  break label278;
                }
                double d = Double.parseDouble(paramString2);
                paramString1.setDouble(this.a, d);
                return;
              }
            }
            catch (IllegalAccessException paramString1) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("EarlyDown", 2, "endElement() throws exception:" + paramString1.getMessage());
      return;
      if (paramString3 == Integer.TYPE)
      {
        int i = Integer.parseInt(paramString2);
        paramString1.setInt(this.a, i);
        return;
      }
      if (paramString3 == Float.TYPE)
      {
        float f = Float.parseFloat(paramString2);
        paramString1.setFloat(this.a, f);
        return;
      }
      if (paramString3 == Short.TYPE)
      {
        short s = Short.parseShort(paramString2);
        paramString1.setShort(this.a, s);
        return;
      }
      if (paramString3 == Byte.TYPE)
      {
        byte b = Byte.parseByte(paramString2);
        paramString1.setByte(this.a, b);
        return;
      }
      if (paramString3 == Boolean.TYPE)
      {
        boolean bool = Boolean.parseBoolean(paramString2);
        paramString1.setBoolean(this.a, bool);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("EarlyDown", 2, "endElement() return. Type:" + paramString3.toString() + " is NOT SUPPORT!");
  }
  
  public void startDocument()
    throws SAXException
  {
    this.mBuilder = new StringBuilder();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    this.mBuilder.setLength(0);
    if (this.clazz.getSimpleName().equals(paramString2)) {}
    try
    {
      this.a = ((XmlData)this.clazz.newInstance());
      return;
    }
    catch (InstantiationException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EarlyDown", 2, "startElement() throw exceptin:" + paramString1.getMessage());
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EarlyDown", 2, "startElement() throw exceptin:" + paramString1.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afeo
 * JD-Core Version:    0.7.0.1
 */