package dov.com.qq.im.aeeditor.module.edit;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import axlu;
import com.tencent.mobileqq.widget.QQToast;

public class AEEditorImageEditFragment$11$2
  implements Runnable
{
  public AEEditorImageEditFragment$11$2(axlu paramaxlu) {}
  
  public void run()
  {
    this.a.this$0.bpm();
    QQToast.a(this.a.this$0.getActivity(), "导出成功", 0).show();
    Intent localIntent = new Intent();
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", AEEditorImageEditFragment.a(this.a.this$0, AEEditorImageEditFragment.b(this.a.this$0)));
    localIntent.putExtra("PhotoConst.PHOTO_PATHS", AEEditorImageEditFragment.b(this.a.this$0));
    this.a.this$0.getActivity().setResult(-1, localIntent);
    this.a.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.11.2
 * JD-Core Version:    0.7.0.1
 */