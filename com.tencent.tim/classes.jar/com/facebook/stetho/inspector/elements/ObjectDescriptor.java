package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;

public final class ObjectDescriptor
  extends Descriptor
{
  public void getAccessibilityStyles(Object paramObject, StyleAccumulator paramStyleAccumulator) {}
  
  public void getAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator) {}
  
  public void getChildren(Object paramObject, Accumulator<Object> paramAccumulator) {}
  
  public String getLocalName(Object paramObject)
  {
    return getNodeName(paramObject);
  }
  
  public String getNodeName(Object paramObject)
  {
    return paramObject.getClass().getName();
  }
  
  public NodeType getNodeType(Object paramObject)
  {
    return NodeType.ELEMENT_NODE;
  }
  
  public String getNodeValue(Object paramObject)
  {
    return null;
  }
  
  public void getStyles(Object paramObject, StyleAccumulator paramStyleAccumulator) {}
  
  public void hook(Object paramObject) {}
  
  public void setAttributesAsText(Object paramObject, String paramString) {}
  
  public void unhook(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.ObjectDescriptor
 * JD-Core Version:    0.7.0.1
 */