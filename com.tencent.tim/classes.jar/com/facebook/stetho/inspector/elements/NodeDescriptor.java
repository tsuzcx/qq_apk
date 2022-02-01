package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ThreadBound;
import javax.annotation.Nullable;

public abstract interface NodeDescriptor
  extends ThreadBound
{
  public abstract void getAccessibilityStyles(Object paramObject, StyleAccumulator paramStyleAccumulator);
  
  public abstract void getAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator);
  
  public abstract void getChildren(Object paramObject, Accumulator<Object> paramAccumulator);
  
  public abstract String getLocalName(Object paramObject);
  
  public abstract String getNodeName(Object paramObject);
  
  public abstract NodeType getNodeType(Object paramObject);
  
  @Nullable
  public abstract String getNodeValue(Object paramObject);
  
  public abstract void getStyles(Object paramObject, StyleAccumulator paramStyleAccumulator);
  
  public abstract void hook(Object paramObject);
  
  public abstract void setAttributesAsText(Object paramObject, String paramString);
  
  public abstract void unhook(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.NodeDescriptor
 * JD-Core Version:    0.7.0.1
 */