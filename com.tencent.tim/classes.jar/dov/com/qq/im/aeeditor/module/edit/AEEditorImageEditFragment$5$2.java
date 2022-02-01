package dov.com.qq.im.aeeditor.module.edit;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import axly;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class AEEditorImageEditFragment$5$2
  implements Runnable
{
  public AEEditorImageEditFragment$5$2(axly paramaxly) {}
  
  public void run()
  {
    this.a.this$0.a.cancelLoading();
    QQToast.a(this.a.this$0.getActivity(), this.a.this$0.getActivity().getResources().getString(2131721494), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.5.2
 * JD-Core Version:    0.7.0.1
 */