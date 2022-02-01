import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ansg
  extends DefaultHandler
  implements anrc
{
  ansf b;
  private boolean cJM;
  private boolean cJN;
  private String cic;
  Stack<ansf> l = new Stack();
  
  public void Qt(boolean paramBoolean)
  {
    this.cJN = paramBoolean;
  }
  
  public void Rv(String paramString)
  {
    this.cic = paramString;
  }
  
  public AbsStructMsg c()
  {
    Object localObject1 = null;
    if (this.b == null) {}
    label161:
    for (;;)
    {
      return localObject1;
      if (this.b.Ks() > 0) {}
      for (Object localObject2 = this.b.a(0);; localObject2 = null)
      {
        if (localObject2 == null) {
          break label161;
        }
        int i = Integer.parseInt(this.b.getAttribute("serviceID"));
        if (i == 2) {
          return new StructMsgForAudioShare(this.b);
        }
        if ((i == 3) || (i == 82) || (i == 120)) {
          return new StructMsgForHypertext(this.b, i);
        }
        if ((i == 5) || (i == 137)) {
          return new StructMsgForImageShare(this.b);
        }
        if (i == 150)
        {
          localObject2 = new StructMsgSubImageVideo(this.b);
          localObject1 = localObject2;
          if (((StructMsgSubImageVideo)localObject2).isValid()) {
            break;
          }
        }
        return new StructMsgForGeneralShare(this.b);
      }
    }
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    super.characters(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    ansf localansf;
    if (!this.l.isEmpty())
    {
      localansf = (ansf)this.l.peek();
      if (localansf != null) {
        if (localansf.value != null) {
          break label81;
        }
      }
    }
    for (;;)
    {
      localansf.value = paramArrayOfChar;
      localansf.value = aoff.d(localansf.value, this.cic, this.cJN);
      return;
      label81:
      paramArrayOfChar = localansf.value.concat(paramArrayOfChar);
    }
  }
  
  public void endDocument()
    throws SAXException
  {
    super.endDocument();
    this.l.clear();
    this.l = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    super.endElement(paramString1, paramString2, paramString3);
    if (!this.l.isEmpty())
    {
      paramString1 = (ansf)this.l.pop();
      if (this.l.isEmpty()) {
        this.b = paramString1;
      }
      if (this.cJM)
      {
        if ((paramString1 != null) && (!"".equals(paramString1.value))) {
          paramString1.type = 3;
        }
        this.cJM = false;
      }
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    super.startElement(paramString1, paramString2, paramString3, paramAttributes);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      localHashMap.put(paramAttributes.getLocalName(i), aoff.d(paramAttributes.getValue(i), this.cic, this.cJN));
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("StructMsg", 2, "StructMsgParserHandler startElement uri = " + paramString1 + ", localName = " + paramString2 + ", qName = " + paramString3 + ", map = " + localHashMap);
    }
    paramString1 = new ansf(paramString2, localHashMap);
    if (!this.l.isEmpty())
    {
      paramString2 = (ansf)this.l.peek();
      if (paramString2 != null)
      {
        paramString1.a = paramString2;
        paramString2.a(paramString1);
      }
    }
    this.l.push(paramString1);
    this.cJM = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansg
 * JD-Core Version:    0.7.0.1
 */