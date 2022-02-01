import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import org.apache.http.Header;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class ifm
  extends ier
{
  ifm(ifk paramifk, List paramList, ifv paramifv, Long paramLong) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    paramArrayOfHeader = null;
    try
    {
      localObject = this.b.a.parse(new InputSource(new StringReader(paramString)));
      paramArrayOfHeader = (Header[])localObject;
    }
    catch (SAXException localSAXException)
    {
      for (;;)
      {
        Object localObject;
        NodeList localNodeList;
        c(new TranslateError(localSAXException), paramString);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        c(new TranslateError(localIOException), paramString);
        continue;
        if (this.eV.get(paramInt) != null)
        {
          paramString.add(this.eV.get(paramInt));
        }
        else
        {
          paramString.add("");
          continue;
          localIOException.add(Language.AUTO_DETECT);
        }
      }
      this.a.a(localIOException, paramString, this.p);
    }
    paramString = new ArrayList();
    localObject = new ArrayList();
    if (paramArrayOfHeader != null)
    {
      localNodeList = paramArrayOfHeader.getElementsByTagName("TranslatedText");
      paramArrayOfHeader = paramArrayOfHeader.getElementsByTagName("From");
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= localNodeList.getLength()) {
          break label270;
        }
        Node localNode = localNodeList.item(paramInt);
        if (localNode.getFirstChild() == null) {
          break;
        }
        paramString.add(localNode.getFirstChild().getNodeValue());
        localNode = paramArrayOfHeader.item(paramInt);
        if (localNode.getFirstChild() == null) {
          break label256;
        }
        ((List)localObject).add(Language.fromString(localNode.getFirstChild().getNodeValue()));
        paramInt += 1;
      }
    }
    label256:
    label270:
    return;
  }
  
  public void c(Throwable paramThrowable, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "[Microsoft] onFailure:" + paramThrowable);
    }
    this.a.a(new TranslateError(paramThrowable), this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifm
 * JD-Core Version:    0.7.0.1
 */