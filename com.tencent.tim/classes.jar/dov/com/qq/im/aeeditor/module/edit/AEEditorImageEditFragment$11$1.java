package dov.com.qq.im.aeeditor.module.edit;

import axlu;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AEEditorImageEditFragment$11$1
  implements Runnable
{
  public AEEditorImageEditFragment$11$1(axlu paramaxlu, Collection paramCollection) {}
  
  public void run()
  {
    this.a.this$0.bpm();
    Object localObject = new ArrayList(this.d);
    if (((List)localObject).size() > 0) {}
    for (localObject = (String)((List)localObject).get(0);; localObject = "unknown")
    {
      QQToast.a(this.a.this$0.getActivity(), "导出失败: error code = " + (String)localObject, 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.11.1
 * JD-Core Version:    0.7.0.1
 */