package com.tencent.mobileqq.richmediabrowser.presenter;

import amcn;
import amcv;
import amdo;
import amdq;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.view.BrowserAdapter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.page.Gallery;
import xsi;

public class AIOBrowserPresenter$2
  implements Runnable
{
  public AIOBrowserPresenter$2(amcv paramamcv, long paramLong, AIOBrowserBaseData paramAIOBrowserBaseData, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.rJ == this.a.msgId) || (this.biV))
    {
      BrowserBaseView localBrowserBaseView = this.this$0.jdField_b_of_type_Amdq.getCurrentView();
      if ((localBrowserBaseView instanceof amdo)) {
        ((amdo)localBrowserBaseView).fG(this.rJ);
      }
      xsi.b(this.this$0.jdField_b_of_type_Amdq.mActivity, this.this$0.jdField_b_of_type_Amdq.mRoot);
    }
    int i;
    do
    {
      return;
      if (this.this$0.jdField_b_of_type_Amcn.b(this.rJ) == null)
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + this.rJ + ", selectItem seq:" + this.a.msgId);
        return;
      }
      i = this.this$0.aa(this.a.msgId);
    } while ((i < 0) || (this.this$0.jdField_b_of_type_Amdq.mAdapter == null));
    this.this$0.jdField_b_of_type_Amdq.mAdapter.notifyDataSetChanged();
    this.this$0.jdField_b_of_type_Amdq.mGallery.setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2
 * JD-Core Version:    0.7.0.1
 */