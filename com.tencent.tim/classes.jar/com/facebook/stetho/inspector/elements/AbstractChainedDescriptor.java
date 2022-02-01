package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import javax.annotation.Nullable;

public abstract class AbstractChainedDescriptor<E>
  extends Descriptor
  implements ChainedDescriptor
{
  private Descriptor mSuper;
  
  public final void getAccessibilityStyles(Object paramObject, StyleAccumulator paramStyleAccumulator)
  {
    this.mSuper.getAccessibilityStyles(paramObject, paramStyleAccumulator);
    onGetAccessibilityStyles(paramObject, paramStyleAccumulator);
  }
  
  public final void getAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator)
  {
    this.mSuper.getAttributes(paramObject, paramAttributeAccumulator);
    onGetAttributes(paramObject, paramAttributeAccumulator);
  }
  
  public final void getChildren(Object paramObject, Accumulator<Object> paramAccumulator)
  {
    this.mSuper.getChildren(paramObject, paramAccumulator);
    onGetChildren(paramObject, paramAccumulator);
  }
  
  public final String getLocalName(Object paramObject)
  {
    return onGetLocalName(paramObject);
  }
  
  public final String getNodeName(Object paramObject)
  {
    return onGetNodeName(paramObject);
  }
  
  public final NodeType getNodeType(Object paramObject)
  {
    return onGetNodeType(paramObject);
  }
  
  public final String getNodeValue(Object paramObject)
  {
    return onGetNodeValue(paramObject);
  }
  
  public final void getStyles(Object paramObject, StyleAccumulator paramStyleAccumulator)
  {
    this.mSuper.getStyles(paramObject, paramStyleAccumulator);
    onGetStyles(paramObject, paramStyleAccumulator);
  }
  
  final Descriptor getSuper()
  {
    return this.mSuper;
  }
  
  public final void hook(Object paramObject)
  {
    verifyThreadAccess();
    this.mSuper.hook(paramObject);
    onHook(paramObject);
  }
  
  protected void onGetAccessibilityStyles(E paramE, StyleAccumulator paramStyleAccumulator) {}
  
  protected void onGetAttributes(E paramE, AttributeAccumulator paramAttributeAccumulator) {}
  
  protected void onGetChildren(E paramE, Accumulator<Object> paramAccumulator) {}
  
  protected String onGetLocalName(E paramE)
  {
    return this.mSuper.getLocalName(paramE);
  }
  
  protected String onGetNodeName(E paramE)
  {
    return this.mSuper.getNodeName(paramE);
  }
  
  protected NodeType onGetNodeType(E paramE)
  {
    return this.mSuper.getNodeType(paramE);
  }
  
  @Nullable
  public String onGetNodeValue(E paramE)
  {
    return this.mSuper.getNodeValue(paramE);
  }
  
  protected void onGetStyles(E paramE, StyleAccumulator paramStyleAccumulator) {}
  
  protected void onHook(E paramE) {}
  
  protected void onSetAttributesAsText(E paramE, String paramString)
  {
    this.mSuper.setAttributesAsText(paramE, paramString);
  }
  
  protected void onUnhook(E paramE) {}
  
  public final void setAttributesAsText(Object paramObject, String paramString)
  {
    onSetAttributesAsText(paramObject, paramString);
  }
  
  public void setSuper(Descriptor paramDescriptor)
  {
    Util.throwIfNull(paramDescriptor);
    if (paramDescriptor != this.mSuper)
    {
      if (this.mSuper != null) {
        throw new IllegalStateException();
      }
      this.mSuper = paramDescriptor;
    }
  }
  
  public final void unhook(Object paramObject)
  {
    verifyThreadAccess();
    onUnhook(paramObject);
    this.mSuper.unhook(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
 * JD-Core Version:    0.7.0.1
 */