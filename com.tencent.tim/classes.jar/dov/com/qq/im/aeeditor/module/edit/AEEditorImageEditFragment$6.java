package dov.com.qq.im.aeeditor.module.edit;

import axkq;
import axmz;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;

class AEEditorImageEditFragment$6
  implements Runnable
{
  AEEditorImageEditFragment$6(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt, axkq paramaxkq) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setShowResult(true);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(false);
    if (this.this$0.aOT()) {
      this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.Yz(false);
    }
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.select(2);
    AEEditorImageEditFragment.a(this.this$0).b(this.val$currentIndex, this.a);
    if (AEEditorImageEditFragment.a(this.this$0) != null) {
      AEEditorImageEditFragment.a(this.this$0).setOverlayImage(this.val$currentIndex, this.a.HT());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.6
 * JD-Core Version:    0.7.0.1
 */