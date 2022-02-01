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

class qbl
  implements qpm.a
{
  qbl(qbk paramqbk) {}
  
  public void h(String paramString, Throwable paramThrowable)
  {
    this.a.p("result", this.a.e.mVideoThumbnailUrl);
    qbk.b(this.a, true);
  }
  
  public void m(String paramString, Bitmap paramBitmap)
  {
    paramString = BaseApplicationImpl.getContext();
    Object localObject = new InteractContainerLayout(paramString);
    ((InteractContainerLayout)localObject).t(this.a.e);
    FrameLayout localFrameLayout = new FrameLayout(paramString);
    localFrameLayout.setBackgroundDrawable(new BitmapDrawable(paramString.getResources(), paramBitmap));
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight()));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramBitmap.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramBitmap.getHeight(), 1073741824));
    localFrameLayout.layout(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    ((InteractContainerLayout)localObject).t(this.a.e);
    localObject = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.drawBitmap(paramBitmap, new Matrix(), null);
    localFrameLayout.draw(localCanvas);
    paramString = paramString.getCacheDir().getAbsolutePath() + "/" + System.currentTimeMillis() + ".png";
    if (rop.d((Bitmap)localObject, paramString)) {
      this.a.p("result", new File(paramString).toURI().toString());
    }
    for (;;)
    {
      ((Bitmap)localObject).recycle();
      qbk.a(this.a, true);
      return;
      this.a.p("result", this.a.e.mVideoThumbnailUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbl
 * JD-Core Version:    0.7.0.1
 */