import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;
import dov.com.qq.im.ae.play.EditTextViewer;

public class axhp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public axhp(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, EditTextViewer paramEditTextViewer, NodeItem paramNodeItem) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_DovComQqImAePlayEditTextViewer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_DovComQqImAePlayEditTextViewer.getLayoutParams();
      int i = (int)(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.left * AEVideoShelfEditFragment.a(this.this$0));
      int j = (int)(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.top * AEVideoShelfEditFragment.b(this.this$0));
      int k = (int)((1.0F - this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.right) * AEVideoShelfEditFragment.a(this.this$0));
      int m = (int)((1.0F - this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.bottom) * AEVideoShelfEditFragment.b(this.this$0));
      localMarginLayoutParams.leftMargin = i;
      localMarginLayoutParams.topMargin = j;
      localMarginLayoutParams.rightMargin = k;
      localMarginLayoutParams.bottomMargin = m;
      localMarginLayoutParams.width = (AEVideoShelfEditFragment.a(this.this$0) - k - i);
      localMarginLayoutParams.height = (AEVideoShelfEditFragment.b(this.this$0) - m - j);
      this.jdField_a_of_type_DovComQqImAePlayEditTextViewer.setLayoutParams(localMarginLayoutParams);
      return;
      this.jdField_a_of_type_DovComQqImAePlayEditTextViewer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhp
 * JD-Core Version:    0.7.0.1
 */