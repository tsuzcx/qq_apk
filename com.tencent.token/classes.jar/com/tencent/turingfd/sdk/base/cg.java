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
    if ((paramString1 != null) && (!"".equals(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramString1 = this.b.createElement(paramString2);
    } else {
      paramString1 = this.b.createElementNS(paramString1, paramString3);
    }
    int k = paramArrayOfcc.length;
    int i = 0;
    while (i < k)
    {
      paramString2 = paramArrayOfcc[i];
      paramString3 = paramString2.c;
      int j;
      if ((paramString3 != null) && (!"".equals(paramString3))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0)
      {
        paramString1.setAttribute(paramString2.a, paramString2.d);
      }
      else
      {
        paramString3 = paramString2.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2.b);
        localStringBuilder.append(':');
        localStringBuilder.append(paramString2.a);
        paramString1.setAttributeNS(paramString3, localStringBuilder.toString(), paramString2.d);
      }
      i += 1;
    }
    ((Node)this.a.peek()).appendChild(paramString1);
    this.a.push(paramString1);
  }
  
  public void b(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cg
 * JD-Core Version:    0.7.0.1
 */