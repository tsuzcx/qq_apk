import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageViewPager;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;

public class axlx
  implements StickerOperationCallback
{
  public axlx(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onDeleteButtonClick(String paramString) {}
  
  public void onStickerClick(TextEditorData paramTextEditorData)
  {
    onTextEditButtonClick(paramTextEditorData);
  }
  
  public void onStickerMoving(String paramString) {}
  
  public void onStickerTouchEnd(String paramString)
  {
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.show();
    AEEditorImageEditFragment.a(this.this$0).setScrollable(true);
    this.this$0.e.removeMessages(0);
    this.this$0.e.sendEmptyMessageDelayed(0, 2000L);
  }
  
  public void onStickerTouchStart(String paramString)
  {
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.hide();
    AEEditorImageEditFragment.a(this.this$0).setScrollable(false);
    this.this$0.e.removeMessages(0);
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    this.this$0.jdField_a_of_type_Axnw.a(this.this$0.getActivity(), paramTextEditorData, AEEditorImageEditFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axlx
 * JD-Core Version:    0.7.0.1
 */