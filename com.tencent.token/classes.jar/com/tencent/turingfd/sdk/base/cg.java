package com.tencent.turingfd.sdk.base;

import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class cg
{
  public Stack<Node> a = new Stack();
  public Document b;
  public final DocumentBuilder c = DocumentBuilderFactory.newInstance().newDocumentBuilder();
  
  public void a() {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString1, String paramString2, String paramString3, cc[] paramArrayOfcc)
  {
    int i;
    label32:
    label40:
    int j;
    if ((paramString1 == null) || ("".equals(paramString1)))
    {
      i = 1;
      if (i == 0) {
        break label108;
      }
      paramString1 = this.b.createElement(paramString2);
      int k = paramArrayOfcc.length;
      i = 0;
      if (i >= k) {
        break label175;
      }
      paramString2 = paramArrayOfcc[i];
      paramString3 = paramString2.c;
      if ((paramString3 != null) && (!"".equals(paramString3))) {
        break label123;
      }
      j = 1;
      label74:
      if (j == 0) {
        break label129;
      }
      paramString1.setAttribute(paramString2.a, paramString2.d);
    }
    for (;;)
    {
      i += 1;
      break label40;
      i = 0;
      break;
      label108:
      paramString1 = this.b.createElementNS(paramString1, paramString3);
      break label32;
      label123:
      j = 0;
      break label74;
      label129:
      paramString1.setAttributeNS(paramString2.c, paramString2.b + ':' + paramString2.a, paramString2.d);
    }
    label175:
    ((Node)this.a.peek()).appendChild(paramString1);
    this.a.push(paramString1);
  }
  
  public void b(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cg
 * JD-Core Version:    0.7.0.1
 */