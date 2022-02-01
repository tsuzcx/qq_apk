package com.tencent.ttpic.trigger.triggerctrlitem;

import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.listener.IDetectorSettingListener;
import com.tencent.ttpic.openapi.listener.IStickerListener;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;

public class DetectorSettingTrigerCtrlItem
  extends TriggerCtrlItem
{
  private IDetectorSettingListener mListener;
  
  public DetectorSettingTrigerCtrlItem(StickerItem paramStickerItem)
  {
    super(paramStickerItem);
  }
  
  public void setDetectorSettingLisener(IStickerListener paramIStickerListener)
  {
    if (paramIStickerListener == null) {
      this.mListener = null;
    }
    while (!(paramIStickerListener instanceof IDetectorSettingListener)) {
      return;
    }
    this.mListener = ((IDetectorSettingListener)paramIStickerListener);
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    super.updateTriggerStatus(paramPTDetectInfo);
    if ((isTriggered()) && (this.mListener != null)) {
      this.mListener.disableDetector(this.mStickerItem.disableDetectors);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.trigger.triggerctrlitem.DetectorSettingTrigerCtrlItem
 * JD-Core Version:    0.7.0.1
 */