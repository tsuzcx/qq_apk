package com.tencent.mobileqq.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PlistHandler
  extends DefaultHandler
{
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  Stack jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean = false;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(new String(paramArrayOfChar, paramInt1, paramInt2).trim());
    }
  }
  
  public void endDocument() {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if ("plist".equals(paramString2)) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
      return;
      if ("array".equals(paramString2)) {
        this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaUtilStack.pop();
      } else if ("dict".equals(paramString2)) {
        this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaUtilStack.pop();
      } else if ("key".equals(paramString2)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangStringBuilder.toString();
      } else if (("string".equals(paramString2)) || ("integer".equals(paramString2))) {
        if ((this.jdField_a_of_type_JavaUtilStack.peek() instanceof HashMap)) {
          ((HashMap)this.jdField_a_of_type_JavaUtilStack.peek()).put(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        } else if ((this.jdField_a_of_type_JavaUtilStack.peek() instanceof ArrayList)) {
          ((ArrayList)this.jdField_a_of_type_JavaUtilStack.peek()).add(this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
      }
    }
  }
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if ("plist".equals(paramString2)) {
      this.jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      if ("array".equals(paramString2))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          paramString1 = new ArrayList();
          this.jdField_a_of_type_JavaUtilStack.push(paramString1);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        paramString1 = this.jdField_a_of_type_JavaUtilStack.peek();
        paramString2 = new ArrayList();
        if ((paramString1 instanceof ArrayList)) {
          ((ArrayList)paramString1).add(paramString2);
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilStack.push(paramString2);
          return;
          if ((paramString1 instanceof HashMap)) {
            ((HashMap)paramString1).put(this.jdField_a_of_type_JavaLangString, paramString2);
          }
        }
      }
    } while (!"dict".equals(paramString2));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilStack.push(new HashMap());
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    paramString1 = this.jdField_a_of_type_JavaUtilStack.peek();
    paramString2 = new HashMap();
    if ((paramString1 instanceof ArrayList)) {
      ((ArrayList)paramString1).add(paramString2);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilStack.push(paramString2);
      return;
      if ((paramString1 instanceof HashMap)) {
        ((HashMap)paramString1).put(this.jdField_a_of_type_JavaLangString, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PlistHandler
 * JD-Core Version:    0.7.0.1
 */