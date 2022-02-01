package com.tencent.tim.cloudfile;

import android.content.res.Resources;
import ateh;
import com.tencent.cloudfile.FileInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class CloudFileHandler$7
  implements Runnable
{
  public CloudFileHandler$7(ateh paramateh, FileInfo paramFileInfo) {}
  
  public void run()
  {
    int i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627);
    QQToast.a(BaseApplicationImpl.getContext(), 1, BaseApplication.getContext().getResources().getString(2131689763, new Object[] { this.a.fileName }), 0).show(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileHandler.7
 * JD-Core Version:    0.7.0.1
 */