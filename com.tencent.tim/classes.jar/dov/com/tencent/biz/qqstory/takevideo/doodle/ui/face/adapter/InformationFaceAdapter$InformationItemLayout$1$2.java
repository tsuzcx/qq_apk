package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.widget.ImageView;
import android.widget.ProgressBar;
import aynl;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.lang.ref.WeakReference;

public class InformationFaceAdapter$InformationItemLayout$1$2
  implements Runnable
{
  public InformationFaceAdapter$InformationItemLayout$1$2(aynl paramaynl, int paramInt) {}
  
  public void run()
  {
    if (((QIMCommonLoadingView)this.a.jp.get()).getVisibility() == 8)
    {
      ((ProgressBar)this.a.jr.get()).setVisibility(8);
      ((QIMCommonLoadingView)this.a.jp.get()).setProgress(0L);
      ((QIMCommonLoadingView)this.a.jp.get()).setVisibility(0);
      ((ImageView)this.a.jq.get()).setVisibility(8);
    }
    ((QIMCommonLoadingView)this.a.jp.get()).setProgress(this.val$percent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.2
 * JD-Core Version:    0.7.0.1
 */