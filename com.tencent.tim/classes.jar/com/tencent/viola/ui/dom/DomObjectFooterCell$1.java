package com.tencent.viola.ui.dom;

import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexNode.MeasureFunction;
import com.tencent.viola.ui.dom.style.MeasureOutput;

final class DomObjectFooterCell$1
  implements FlexNode.MeasureFunction
{
  public void measure(FlexNode paramFlexNode, float paramFloat, MeasureOutput paramMeasureOutput)
  {
    if ((paramFlexNode != null) && ((paramFlexNode instanceof DomObjectFooterCell)))
    {
      paramFlexNode.setLayoutWidth(paramFloat);
      paramMeasureOutput.width = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectFooterCell.1
 * JD-Core Version:    0.7.0.1
 */