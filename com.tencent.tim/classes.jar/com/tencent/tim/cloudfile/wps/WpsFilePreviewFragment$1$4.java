package com.tencent.tim.cloudfile.wps;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import aqzl;
import arcd;
import atmw;
import audx;
import ault;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class WpsFilePreviewFragment$1$4
  implements Runnable
{
  public WpsFilePreviewFragment$1$4(atmw paramatmw, Bundle paramBundle, String paramString) {}
  
  public void run()
  {
    try
    {
      QQToast.a(this.a.a.getHostActivity(), 2, "文档下载成功，可至本地文件查看。", 0).show(this.a.a.getTitleBarHeight());
      label31:
      this.a.a.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(0);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = this.bd.getBundle("_CB_USERDATA");
        if (localObject == null) {
          break label235;
        }
        QLog.i("IFileManagerProviderCallback", 1, "onDownloadSucess sha[" + ((Bundle)localObject).getString("sha") + "]");
      }
      for (;;)
      {
        WpsFilePreviewFragment.a(this.a.a).setVisibility(8);
        this.a.a.jdField_a_of_type_Arcd.mRootView.removeView(WpsFilePreviewFragment.c(this.a.a));
        WpsFilePreviewFragment.a(this.a.a, null);
        long l2 = this.a.a.ayu | 0x0 | 0x0 | 0x0;
        localObject = audx.getFileName(this.val$filePath);
        long l1 = l2;
        if (ault.cm(this.val$filePath, (String)localObject)) {
          l1 = l2 | 0x0;
        }
        this.a.a.mg((l1 | 0x0) ^ 0x20 ^ 0x2000);
        return;
        label235:
        QLog.e("IFileManagerProviderCallback", 1, "onDownloadSucess extData is Null");
      }
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment.1.4
 * JD-Core Version:    0.7.0.1
 */