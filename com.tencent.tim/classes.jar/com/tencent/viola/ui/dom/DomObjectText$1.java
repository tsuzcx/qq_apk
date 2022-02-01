package com.tencent.viola.ui.dom;

import android.text.Layout;
import android.text.Layout.Alignment;
import com.tencent.viola.ui.dom.style.FlexConstants;
import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexNode.MeasureFunction;
import com.tencent.viola.ui.dom.style.FlexStyle;
import com.tencent.viola.ui.dom.style.FloatUtils;
import com.tencent.viola.ui.dom.style.MeasureOutput;

class DomObjectText$1
  implements FlexNode.MeasureFunction
{
  DomObjectText$1(DomObjectText paramDomObjectText) {}
  
  public void measure(FlexNode paramFlexNode, float paramFloat, MeasureOutput paramMeasureOutput)
  {
    DomObjectText localDomObjectText = (DomObjectText)paramFlexNode;
    float f = paramFloat;
    if (FlexConstants.isUndefined(paramFloat)) {
      f = paramFlexNode.flexStyle.maxWidth;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (f > 0.0F)
    {
      bool1 = bool2;
      if (paramFlexNode.getParent() != null)
      {
        bool1 = bool2;
        if (DomObjectText.access$000(localDomObjectText) == Layout.Alignment.ALIGN_CENTER) {
          bool1 = FloatUtils.floatsEqual(f, paramFlexNode.getParent().getLayoutWidth());
        }
      }
    }
    DomObjectText.access$102(localDomObjectText, true);
    paramFloat = localDomObjectText.getTextWidth(DomObjectText.access$200(localDomObjectText), f, bool1);
    if ((paramFloat > 0.0F) && ((DomObjectText.access$300(localDomObjectText) != null) || (DomObjectText.access$400(this.this$0) != null)))
    {
      DomObjectText.access$502(localDomObjectText, DomObjectText.access$600(localDomObjectText, paramFloat, true, null));
      DomObjectText.access$702(localDomObjectText, DomObjectText.access$500(localDomObjectText).getWidth());
      paramMeasureOutput.height = (DomObjectText.access$500(localDomObjectText).getHeight() + 5);
      paramMeasureOutput.width = DomObjectText.access$700(localDomObjectText);
      return;
    }
    paramMeasureOutput.height = 0.0F;
    paramMeasureOutput.width = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectText.1
 * JD-Core Version:    0.7.0.1
 */