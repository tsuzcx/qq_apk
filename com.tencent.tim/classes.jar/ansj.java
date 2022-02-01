import com.tencent.mm.vfs.VFSFileInputStream;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class ansj
{
  public static AbsStructMsg a(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    ansg localansg = new ansg();
    SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
    try
    {
      localSAXParserFactory.newSAXParser().parse(paramString, localansg);
      paramString.close();
      paramString = localansg.c();
      return paramString;
    }
    catch (ParserConfigurationException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TestStructMsg", 2, "getStructMsgFromXmlBuffByStream", paramString);
      }
      return null;
    }
    catch (SAXException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TestStructMsg", 2, "getStructMsgFromXmlBuffByStream", paramString);
        }
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TestStructMsg", 2, "getStructMsgFromXmlBuffByStream", paramString);
        }
      }
    }
  }
  
  public static String nJ(String paramString)
  {
    try
    {
      paramString = new VFSFileInputStream(paramString);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramString.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramString = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansj
 * JD-Core Version:    0.7.0.1
 */