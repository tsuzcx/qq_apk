package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import aoop;
import aqqx;
import aynl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.lang.ref.WeakReference;

public class InformationFaceAdapter$InformationItemLayout$1$1
  implements Runnable
{
  public InformationFaceAdapter$InformationItemLayout$1$1(aynl paramaynl, boolean paramBoolean) {}
  
  public void run()
  {
    ((QIMCommonLoadingView)this.a.jp.get()).setVisibility(8);
    ((ImageView)this.a.jq.get()).setVisibility(0);
    if (this.bIj)
    {
      URLDrawable localURLDrawable = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), this.a.val$path, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      Object localObject;
      if (localURLDrawable != null)
      {
        ImageView localImageView = (ImageView)this.a.jq.get();
        if (!this.a.dAd) {
          break label204;
        }
        localObject = localURLDrawable;
        localImageView.setImageDrawable((Drawable)localObject);
        ((ImageView)this.a.jq.get()).setTag(2131379203, Boolean.valueOf(true));
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.restartDownload();
        }
        if (localURLDrawable.getStatus() == 1) {
          this.a.a.onLoadSuccessed((View)this.a.jq.get(), localURLDrawable);
        }
        localObject = (ImageView)this.a.jq.get();
        if (!this.a.dAd) {
          break label209;
        }
      }
      for (;;)
      {
        ((ImageView)localObject).setImageDrawable(localURLDrawable);
        return;
        label204:
        localObject = null;
        break;
        label209:
        localURLDrawable = null;
      }
    }
    ((ImageView)this.a.jq.get()).setImageDrawable(aoop.TRANSPARENT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.1
 * JD-Core Version:    0.7.0.1
 */