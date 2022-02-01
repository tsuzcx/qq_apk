package com.tencent.qqlive.module.videoreport.report.element;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class ElementExposureReporter$1
  implements ListenerMgr.INotifyCallback<OnElementTraverseListener>
{
  ElementExposureReporter$1(ElementExposureReporter paramElementExposureReporter) {}
  
  public void onNotify(OnElementTraverseListener paramOnElementTraverseListener)
  {
    paramOnElementTraverseListener.onTraverseEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter.1
 * JD-Core Version:    0.7.0.1
 */