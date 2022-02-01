package com.facebook.stetho.inspector.elements.android;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor.Host;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

final class TextViewDescriptor
  extends AbstractChainedDescriptor<TextView>
{
  private static final String TEXT_ATTRIBUTE_NAME = "text";
  private final Map<TextView, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());
  
  protected void onGetAttributes(TextView paramTextView, AttributeAccumulator paramAttributeAccumulator)
  {
    paramTextView = paramTextView.getText();
    if (paramTextView.length() != 0) {
      paramAttributeAccumulator.store("text", paramTextView.toString());
    }
  }
  
  protected void onHook(TextView paramTextView)
  {
    ElementContext localElementContext = new ElementContext(null);
    localElementContext.hook(paramTextView);
    this.mElementToContextMap.put(paramTextView, localElementContext);
  }
  
  protected void onUnhook(TextView paramTextView)
  {
    ((ElementContext)this.mElementToContextMap.remove(paramTextView)).unhook();
  }
  
  final class ElementContext
    implements TextWatcher
  {
    private TextView mElement;
    
    private ElementContext() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() == 0)
      {
        TextViewDescriptor.this.getHost().onAttributeRemoved(this.mElement, "text");
        return;
      }
      TextViewDescriptor.this.getHost().onAttributeModified(this.mElement, "text", paramEditable.toString());
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void hook(TextView paramTextView)
    {
      this.mElement = ((TextView)Util.throwIfNull(paramTextView));
      this.mElement.addTextChangedListener(this);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void unhook()
    {
      if (this.mElement != null)
      {
        this.mElement.removeTextChangedListener(this);
        this.mElement = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.TextViewDescriptor
 * JD-Core Version:    0.7.0.1
 */