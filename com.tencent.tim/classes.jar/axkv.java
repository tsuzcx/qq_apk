import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment.a;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorClipPageTopBar;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorClipPageTopBar.a;
import java.util.ArrayList;

public class axkv
  implements AEEditorClipPageTopBar.a
{
  public axkv(AEEditorImageClipFragment paramAEEditorImageClipFragment) {}
  
  public void eLT()
  {
    this.a.a().m(this.a.getActivity(), true);
  }
  
  public void eLU()
  {
    if (AEEditorImageClipFragment.a(this.a)) {}
    while ((AEEditorImageClipFragment.a(this.a) < 0) || (AEEditorImageClipFragment.a(this.a) >= AEEditorImageClipFragment.a(this.a).size()) || (AEEditorImageClipFragment.b(this.a))) {
      return;
    }
    AEEditorImageClipFragment.a(this.a)[AEEditorImageClipFragment.a(this.a)] = 0;
    int i = AEEditorImageClipFragment.a(this.a, AEEditorImageClipFragment.a(this.a));
    AEEditorImageClipFragment.a(this.a, i);
    if (AEEditorImageClipFragment.a(this.a) != null) {
      AEEditorImageClipFragment.a(this.a).notifyDataSetChanged();
    }
    AEEditorImageClipFragment.a(this.a).setIndex(AEEditorImageClipFragment.b(this.a, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axkv
 * JD-Core Version:    0.7.0.1
 */