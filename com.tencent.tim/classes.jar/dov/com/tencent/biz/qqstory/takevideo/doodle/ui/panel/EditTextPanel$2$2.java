package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import arxa;
import aynp;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;

public class EditTextPanel$2$2
  implements Runnable
{
  public EditTextPanel$2$2(aynp paramaynp, boolean paramBoolean, EditTextEffectView.b paramb, DynamicTextConfigManager paramDynamicTextConfigManager) {}
  
  public void run()
  {
    if (!this.val$isSuccess)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$b.ZH(this.val$isSuccess);
      arxa.a().showToast(2131700390);
    }
    do
    {
      do
      {
        return;
      } while (!this.e.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$b.c));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$b.ZH(this.val$isSuccess);
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$b.position != this.jdField_a_of_type_Aynp.this$0.eKM);
    this.jdField_a_of_type_Aynp.this$0.ii(-1, this.jdField_a_of_type_Aynp.this$0.eKM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2.2
 * JD-Core Version:    0.7.0.1
 */