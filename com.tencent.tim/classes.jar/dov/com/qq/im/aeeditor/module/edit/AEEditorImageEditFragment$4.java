package dov.com.qq.im.aeeditor.module.edit;

import android.graphics.Bitmap;
import axiy;
import axjm;
import java.util.List;

class AEEditorImageEditFragment$4
  implements Runnable
{
  AEEditorImageEditFragment$4(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt) {}
  
  public void run()
  {
    Bitmap localBitmap = AEEditorImageEditFragment.a(this.this$0, (String)AEEditorImageEditFragment.a(this.this$0).get(this.val$currentIndex), ((axjm)AEEditorImageEditFragment.b(this.this$0).get(this.val$currentIndex)).cropConfig);
    if (localBitmap == null)
    {
      axiy.e(AEEditorImageEditFragment.access$100(), "bitmap null error.");
      return;
    }
    AEEditorImageEditFragment.a(this.this$0, localBitmap, this.val$currentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.4
 * JD-Core Version:    0.7.0.1
 */