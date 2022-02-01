import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.net.URI;

class xfs
  implements ybi
{
  xfs(xfr paramxfr) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    paramString = BaseApplicationImpl.getContext();
    Object localObject = new InteractContainerLayout(paramString);
    ((InteractContainerLayout)localObject).a(this.a.a);
    FrameLayout localFrameLayout = new FrameLayout(paramString);
    localFrameLayout.setBackgroundDrawable(new BitmapDrawable(paramString.getResources(), paramBitmap));
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight()));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramBitmap.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramBitmap.getHeight(), 1073741824));
    localFrameLayout.layout(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    ((InteractContainerLayout)localObject).a(this.a.a);
    localObject = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.drawBitmap(paramBitmap, new Matrix(), null);
    localFrameLayout.draw(localCanvas);
    paramString = paramString.getCacheDir().getAbsolutePath() + "/" + System.currentTimeMillis() + ".png";
    if (zoc.a((Bitmap)localObject, paramString)) {
      this.a.a("result", new File(paramString).toURI().toString());
    }
    for (;;)
    {
      ((Bitmap)localObject).recycle();
      xfr.a(this.a, true);
      return;
      this.a.a("result", this.a.a.mVideoThumbnailUrl);
    }
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    this.a.a("result", this.a.a.mVideoThumbnailUrl);
    xfr.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfs
 * JD-Core Version:    0.7.0.1
 */