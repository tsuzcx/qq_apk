package com.tencent.tim.mvp.cloudfile;

import ateh;
import auhh;
import auhk.h;
import com.tencent.mobileqq.app.QQAppInterface;

class CloudFileAndFolderOperationPresenter$2$1
  implements Runnable
{
  CloudFileAndFolderOperationPresenter$2$1(CloudFileAndFolderOperationPresenter.2 param2) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.onConfirm();
    }
    ((ateh)auhh.b(this.a.this$0).getBusinessHandler(180)).a(this.a.hH, this.a.KO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.cloudfile.CloudFileAndFolderOperationPresenter.2.1
 * JD-Core Version:    0.7.0.1
 */