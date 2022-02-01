import android.support.annotation.Nullable;
import dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import java.util.List;

public class axlo
  implements axzv<List<AEEditorFilterBean>>
{
  public axlo(AEEditorCommonEditFragment paramAEEditorCommonEditFragment, boolean paramBoolean) {}
  
  public void ah(@Nullable List<AEEditorFilterBean> paramList)
  {
    axiy.i(AEEditorCommonEditFragment.access$000(), "mFiltersObserver-onChanged");
    if (paramList != null) {
      this.this$0.a.setFiltersData(paramList, this.dvk);
    }
    this.this$0.eMr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axlo
 * JD-Core Version:    0.7.0.1
 */