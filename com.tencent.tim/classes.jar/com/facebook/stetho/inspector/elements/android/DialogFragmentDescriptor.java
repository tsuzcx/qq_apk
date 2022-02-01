package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.DialogFragmentAccessor;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.Descriptor.Host;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import javax.annotation.Nullable;

final class DialogFragmentDescriptor
  extends Descriptor
  implements ChainedDescriptor, HighlightableDescriptor
{
  private final DialogFragmentAccessor mAccessor;
  private Descriptor mSuper;
  
  private DialogFragmentDescriptor(FragmentCompat paramFragmentCompat)
  {
    this.mAccessor = paramFragmentCompat.forDialogFragment();
  }
  
  private static void maybeRegister(DescriptorMap paramDescriptorMap, @Nullable FragmentCompat paramFragmentCompat)
  {
    if (paramFragmentCompat != null)
    {
      Class localClass = paramFragmentCompat.getDialogFragmentClass();
      LogUtil.d("Adding support for %s", new Object[] { localClass });
      paramDescriptorMap.register(localClass, new DialogFragmentDescriptor(paramFragmentCompat));
    }
  }
  
  public static DescriptorMap register(DescriptorMap paramDescriptorMap)
  {
    maybeRegister(paramDescriptorMap, FragmentCompat.getMoaiLibInstance());
    maybeRegister(paramDescriptorMap, FragmentCompat.getSupportLibInstance());
    maybeRegister(paramDescriptorMap, FragmentCompat.getFrameworkInstance());
    return paramDescriptorMap;
  }
  
  public void getAccessibilityStyles(Object paramObject, StyleAccumulator paramStyleAccumulator) {}
  
  public void getAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator)
  {
    this.mSuper.getAttributes(paramObject, paramAttributeAccumulator);
  }
  
  public void getChildren(Object paramObject, Accumulator<Object> paramAccumulator)
  {
    paramAccumulator.store(this.mAccessor.getDialog(paramObject));
  }
  
  public String getLocalName(Object paramObject)
  {
    return this.mSuper.getLocalName(paramObject);
  }
  
  public String getNodeName(Object paramObject)
  {
    return this.mSuper.getNodeName(paramObject);
  }
  
  public NodeType getNodeType(Object paramObject)
  {
    return this.mSuper.getNodeType(paramObject);
  }
  
  @Nullable
  public String getNodeValue(Object paramObject)
  {
    return this.mSuper.getNodeValue(paramObject);
  }
  
  public void getStyles(Object paramObject, StyleAccumulator paramStyleAccumulator) {}
  
  @Nullable
  public View getViewForHighlighting(Object paramObject)
  {
    Descriptor.Host localHost = getHost();
    if ((localHost instanceof AndroidDescriptorHost))
    {
      paramObject = this.mAccessor.getDialog(paramObject);
      return ((AndroidDescriptorHost)localHost).getHighlightingView(paramObject);
    }
    return null;
  }
  
  public void hook(Object paramObject)
  {
    this.mSuper.hook(paramObject);
  }
  
  public void setAttributesAsText(Object paramObject, String paramString)
  {
    this.mSuper.setAttributesAsText(paramObject, paramString);
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
  
  public void unhook(Object paramObject)
  {
    this.mSuper.unhook(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.DialogFragmentDescriptor
 * JD-Core Version:    0.7.0.1
 */