package com.tencent.biz.subscribe.other.story;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import sfp;

public class VSUploadVideoManager$3
  implements Runnable
{
  public VSUploadVideoManager$3(sfp paramsfp, VSUploadVideoEntry paramVSUploadVideoEntry, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (this.d.isSuccess())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), "上传成功！", 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), this.k.errorMsg, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoManager.3
 * JD-Core Version:    0.7.0.1
 */