package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import acfp;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import aoop;
import aqmr;
import ayne;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;
import ram;

class FaceListPage$2
  implements Runnable
{
  FaceListPage$2(FaceListPage paramFaceListPage, ayne paramayne, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.c.oQ(this.NA);
    if (this.dzY)
    {
      ram.d("FaceListPage", "FacePkg is already download.show face list.");
      FaceListPage.a(this.this$0).setMax(1);
      FaceListPage.a(this.this$0).setProgress(1);
      this.this$0.postDelayed(new FaceListPage.2.1(this), 30L);
    }
    do
    {
      return;
      FaceListPage.a(this.this$0).setVisibility(4);
      FaceListPage.b(this.this$0).setVisibility(4);
      FaceListPage.a(this.this$0).setVisibility(0);
      Object localObject = (String)FaceListPage.a(this.this$0).getTag(2131379238);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.c.aAD)))
      {
        FaceListPage.a(this.this$0).setTag(2131379238, this.c.aAD);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = FaceListPage.a(this.this$0);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = FaceListPage.a(this.this$0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.aS();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        localObject = URLDrawable.getDrawable(this.c.aAD, (URLDrawable.URLDrawableOptions)localObject);
        FaceListPage.a(this.this$0).setImageDrawable((Drawable)localObject);
      }
      TextView localTextView = FaceListPage.a(this.this$0);
      if (TextUtils.isEmpty(this.c.name)) {}
      for (localObject = "";; localObject = this.c.name)
      {
        localTextView.setText((CharSequence)localObject);
        if (!this.c.isDownloading) {
          break;
        }
        FaceListPage.a(this.this$0).setMax(this.c.brW);
        FaceListPage.a(this.this$0).setProgress(this.c.brX);
        FaceListPage.b(this.this$0).setText(acfp.m(2131706033));
        FaceListPage.a(this.this$0).setVisibility(0);
        return;
      }
      FaceListPage.a(this.this$0).setMax(1);
      FaceListPage.a(this.this$0).setProgress(0);
      FaceListPage.b(this.this$0).setBackgroundResource(2130847359);
      FaceListPage.a(this.this$0).setVisibility(4);
    } while (aqmr.isEmpty(this.c.cXe));
    FaceListPage.b(this.this$0).setText(this.c.cXe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.2
 * JD-Core Version:    0.7.0.1
 */