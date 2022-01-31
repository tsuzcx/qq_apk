package com.tencent.biz.qrcode.activity;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import bnh;
import com.google.zxing.Result;
import com.tencent.biz.qrcode.CameraManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.lang.ref.WeakReference;

public final class ScannerActivity$ScannerActivityHandler
  extends Handler
{
  WeakReference a;
  
  ScannerActivity$ScannerActivityHandler(ScannerActivity paramScannerActivity)
  {
    this.a = new WeakReference(paramScannerActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (ScannerActivity)this.a.get();
    if ((localObject == null) || (((ScannerActivity)localObject).isFinishing())) {}
    do
    {
      do
      {
        return;
        if (!((ScannerActivity)localObject).isResume())
        {
          ((ScannerActivity)localObject).g = false;
          return;
        }
        switch (paramMessage.what)
        {
        case 106: 
        case 107: 
        case 108: 
        case 109: 
        case 110: 
        default: 
          return;
        case 103: 
          ((ScannerActivity)localObject).g = false;
          ((ScannerActivity)localObject).a((Result)paramMessage.obj);
          return;
        case 105: 
          ((ScannerActivity)localObject).g = false;
          ((ScannerActivity)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramMessage = DialogUtil.a((Context)localObject, 230);
          paramMessage.setMessage(2131560498);
          localObject = new bnh(this, (ScannerActivity)localObject);
          paramMessage.setPositiveButton(2131562539, (DialogInterface.OnClickListener)localObject);
          paramMessage.setOnCancelListener((DialogInterface.OnCancelListener)localObject);
          paramMessage.show();
          return;
        }
      } while (((ScannerActivity)localObject).g);
      ((ScannerActivity)localObject).a((Result)paramMessage.obj);
      return;
      ((ScannerActivity)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(2131560490);
      ((ScannerActivity)localObject).e = true;
      ((ScannerActivity)localObject).a();
      if (((ScannerActivity)localObject).jdField_a_of_type_ComTencentBizQrcodeCameraManager.a()) {
        ((ScannerActivity)localObject).b.setEnabled(true);
      }
    } while (((ScannerActivity)localObject).g);
    ((ScannerActivity)localObject).d();
    return;
    ((ScannerActivity)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(2131560492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity.ScannerActivityHandler
 * JD-Core Version:    0.7.0.1
 */