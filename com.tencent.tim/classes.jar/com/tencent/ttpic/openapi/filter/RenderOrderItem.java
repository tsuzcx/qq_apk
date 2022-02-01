package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.trigger.TriggerCtrlItem;

public class RenderOrderItem
  extends RenderItem
{
  public static final int RENDER_ORDER_AFTER = 2;
  public static final int RENDER_ORDER_BEFORE = 1;
  public static final int RENDER_ORDER_DEFAULT = 0;
  protected final int RENDER_OREDER;
  protected int mCurrentOrder = 0;
  
  public RenderOrderItem(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem)
  {
    this(paramAEFilterI, paramTriggerCtrlItem, 0);
  }
  
  public RenderOrderItem(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem, int paramInt)
  {
    super(paramAEFilterI, paramTriggerCtrlItem);
    this.RENDER_OREDER = paramInt;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if ((this.mCurrentOrder != 0) && (this.mCurrentOrder != this.RENDER_OREDER)) {
      return paramFrame;
    }
    return super.RenderProcess(paramFrame);
  }
  
  public void updateCurrentOrder(int paramInt)
  {
    this.mCurrentOrder = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RenderOrderItem
 * JD-Core Version:    0.7.0.1
 */