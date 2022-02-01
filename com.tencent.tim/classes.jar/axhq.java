import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;
import dov.com.qq.im.ae.play.FaceImageViewer;

public class axhq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public axhq(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, FaceImageViewer paramFaceImageViewer, NodeItem paramNodeItem) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
      int i = (int)(this.a.maskRect.left * AEVideoShelfEditFragment.a(this.this$0));
      int j = (int)(this.a.maskRect.top * AEVideoShelfEditFragment.b(this.this$0));
      int k = (int)((1.0F - this.a.maskRect.right) * AEVideoShelfEditFragment.a(this.this$0));
      int m = (int)((1.0F - this.a.maskRect.bottom) * AEVideoShelfEditFragment.b(this.this$0));
      localMarginLayoutParams.leftMargin = i;
      localMarginLayoutParams.topMargin = j;
      localMarginLayoutParams.rightMargin = k;
      localMarginLayoutParams.bottomMargin = m;
      localMarginLayoutParams.width = (AEVideoShelfEditFragment.a(this.this$0) - k - i);
      localMarginLayoutParams.height = (AEVideoShelfEditFragment.b(this.this$0) - m - j);
      this.b.setLayoutParams(localMarginLayoutParams);
      return;
      this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhq
 * JD-Core Version:    0.7.0.1
 */