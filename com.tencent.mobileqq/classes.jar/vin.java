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
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.net.URI;

class vin
  implements wec
{
  vin(vim paramvim, uxk paramuxk) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    paramString = BaseApplicationImpl.getContext();
    Object localObject = new PollContainerLayout(paramString);
    ((PollContainerLayout)localObject).a(this.jdField_a_of_type_Uxk, -1, null);
    FrameLayout localFrameLayout = new FrameLayout(paramString);
    localFrameLayout.setBackgroundDrawable(new BitmapDrawable(paramString.getResources(), paramBitmap));
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight()));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramBitmap.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramBitmap.getHeight(), 1073741824));
    localFrameLayout.layout(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    ((PollContainerLayout)localObject).a(this.jdField_a_of_type_Uxk, -1, null);
    localObject = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.drawBitmap(paramBitmap, new Matrix(), null);
    localFrameLayout.draw(localCanvas);
    paramString = paramString.getCacheDir().getAbsolutePath() + "/" + System.currentTimeMillis() + ".png";
    if (xqw.a((Bitmap)localObject, paramString)) {
      this.jdField_a_of_type_Vim.a("result", new File(paramString).toURI().toString());
    }
    for (;;)
    {
      ((Bitmap)localObject).recycle();
      vim.a(this.jdField_a_of_type_Vim, true);
      return;
      this.jdField_a_of_type_Vim.a("result", this.jdField_a_of_type_Vim.a.mVideoThumbnailUrl);
    }
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Vim.a("result", this.jdField_a_of_type_Vim.a.mVideoThumbnailUrl);
    vim.b(this.jdField_a_of_type_Vim, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vin
 * JD-Core Version:    0.7.0.1
 */