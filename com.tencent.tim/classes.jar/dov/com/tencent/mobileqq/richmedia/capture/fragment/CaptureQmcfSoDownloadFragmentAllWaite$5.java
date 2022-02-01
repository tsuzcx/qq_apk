package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$5
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$5(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "onStatusChanged: " + this.byL + " error:" + this.val$error);
    }
    if (!this.byL)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131718877, 0).show();
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, -1);
      return;
    }
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, 101);
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, "onStatusChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite.5
 * JD-Core Version:    0.7.0.1
 */