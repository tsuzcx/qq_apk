package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.elements.StyleAccumulator;
import java.util.List;

class CSS$2$1
  implements StyleAccumulator
{
  CSS$2$1(CSS.2 param2) {}
  
  public void store(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      CSS.CSSProperty localCSSProperty = new CSS.CSSProperty(null);
      localCSSProperty.name = paramString1;
      localCSSProperty.value = paramString2;
      this.this$1.val$match.rule.style.cssProperties.add(localCSSProperty);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.CSS.2.1
 * JD-Core Version:    0.7.0.1
 */