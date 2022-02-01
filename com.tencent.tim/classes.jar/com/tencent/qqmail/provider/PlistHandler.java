package com.tencent.qqmail.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PlistHandler
  extends DefaultHandler
{
  private boolean isRootElement = false;
  private boolean keyElementBegin = false;
  private StringBuilder keyStringbuBuilder;
  private Object root;
  Stack<Object> stack = new Stack();
  private boolean valueElementBegin = false;
  private StringBuilder valueStringbuBuilder;
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    if (paramInt2 > 0)
    {
      if (this.keyElementBegin) {
        this.keyStringbuBuilder.append(new String(paramArrayOfChar, paramInt1, paramInt2));
      }
      if (this.valueElementBegin)
      {
        if (!(this.stack.peek() instanceof HashMap)) {
          break label68;
        }
        this.valueStringbuBuilder.append(new String(paramArrayOfChar, paramInt1, paramInt2));
      }
    }
    label68:
    while (!(this.stack.peek() instanceof ArrayList)) {
      return;
    }
    this.valueStringbuBuilder.append(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public void endDocument()
    throws SAXException
  {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if ((!"plist".equals(paramString3)) || ("key".equals(paramString3))) {
      this.keyElementBegin = false;
    }
    if ("string".equals(paramString3))
    {
      this.valueElementBegin = false;
      if (!(this.stack.peek() instanceof HashMap)) {
        break label119;
      }
      ((HashMap)this.stack.peek()).put(this.keyStringbuBuilder.toString(), this.valueStringbuBuilder.toString());
    }
    for (;;)
    {
      if ("array".equals(paramString3)) {
        this.root = this.stack.pop();
      }
      if ("dict".equals(paramString3)) {
        this.root = this.stack.pop();
      }
      return;
      label119:
      if ((this.stack.peek() instanceof ArrayList)) {
        ((ArrayList)this.stack.peek()).add(this.valueStringbuBuilder.toString());
      }
    }
  }
  
  public List<Object> getArrayResult()
  {
    return (List)this.root;
  }
  
  public HashMap<String, Object> getMapResult()
  {
    return (HashMap)this.root;
  }
  
  public void startDocument()
    throws SAXException
  {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    boolean bool2 = false;
    if ("plist".equals(paramString3)) {
      this.isRootElement = true;
    }
    boolean bool1;
    if ("dict".equals(paramString3))
    {
      if (!this.isRootElement) {
        break label242;
      }
      this.stack.push(new HashMap());
      if (!this.isRootElement)
      {
        bool1 = true;
        this.isRootElement = bool1;
      }
    }
    else
    {
      if ("key".equals(paramString3))
      {
        this.keyElementBegin = true;
        this.keyStringbuBuilder = new StringBuilder();
      }
      if ("true".equals(paramString3)) {
        ((HashMap)this.stack.peek()).put(this.keyStringbuBuilder.toString(), Boolean.valueOf(true));
      }
      if ("false".equals(paramString3)) {
        ((HashMap)this.stack.peek()).put(this.keyStringbuBuilder.toString(), Boolean.valueOf(false));
      }
      if ("array".equals(paramString3))
      {
        if (!this.isRootElement) {
          break label312;
        }
        paramString1 = new ArrayList();
        this.stack.push(paramString1);
        bool1 = bool2;
        if (!this.isRootElement) {
          bool1 = true;
        }
        this.isRootElement = bool1;
      }
    }
    for (;;)
    {
      if ("string".equals(paramString3))
      {
        this.valueElementBegin = true;
        this.valueStringbuBuilder = new StringBuilder();
      }
      return;
      bool1 = false;
      break;
      label242:
      paramString1 = this.stack.peek();
      paramString2 = new HashMap();
      if ((paramString1 instanceof ArrayList)) {
        ((ArrayList)paramString1).add(paramString2);
      }
      for (;;)
      {
        this.stack.push(paramString2);
        break;
        if ((paramString1 instanceof HashMap)) {
          ((HashMap)paramString1).put(this.keyStringbuBuilder.toString(), paramString2);
        }
      }
      label312:
      paramString1 = (HashMap)this.stack.peek();
      paramString2 = new ArrayList();
      this.stack.push(paramString2);
      paramString1.put(this.keyStringbuBuilder.toString(), paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.provider.PlistHandler
 * JD-Core Version:    0.7.0.1
 */