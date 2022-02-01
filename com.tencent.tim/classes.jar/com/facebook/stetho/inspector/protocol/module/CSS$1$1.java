package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.elements.StyleAccumulator;
import java.util.List;

class CSS$1$1
  implements StyleAccumulator
{
  CSS$1$1(CSS.1 param1) {}
  
  public void store(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      CSS.CSSComputedStyleProperty localCSSComputedStyleProperty = new CSS.CSSComputedStyleProperty(null);
      localCSSComputedStyleProperty.name = paramString1;
      localCSSComputedStyleProperty.value = paramString2;
      this.this$1.val$result.computedStyle.add(localCSSComputedStyleProperty);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.CSS.1.1
 * JD-Core Version:    0.7.0.1
 */