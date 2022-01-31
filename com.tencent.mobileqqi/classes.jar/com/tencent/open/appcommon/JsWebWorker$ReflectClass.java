package com.tencent.open.appcommon;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsWebWorker$ReflectClass
{
  public Class a;
  public String a;
  public Map a;
  public Map b = new HashMap();
  
  protected JsWebWorker$ReflectClass(JsWebWorker paramJsWebWorker)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    this.jdField_a_of_type_JavaUtilMap = null;
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.JsWebWorker.ReflectClass
 * JD-Core Version:    0.7.0.1
 */