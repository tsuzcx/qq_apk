import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.8.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.8.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.8.3;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class axma
  implements axjp.a
{
  public axma(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, axkn paramaxkn)
  {
    if (this.this$0.a != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.8.1(this, paramaxkn));
    }
    if (paramInt == 0)
    {
      axiy.i(AEEditorImageEditFragment.access$100(), "onAIFilterApplySuccess:");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.8.3(this));
      if (AEEditorImageEditFragment.a(this.this$0) != null) {
        break label107;
      }
    }
    label107:
    while (paramaxkn == null)
    {
      return;
      axiy.i(AEEditorImageEditFragment.access$100(), "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.8.2(this));
      break;
    }
    paramaxkn = (axkp)paramaxkn;
    if (paramaxkn != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = 0;
      if (paramInt < AEEditorImageEditFragment.b(this.this$0))
      {
        if (paramInt == AEEditorImageEditFragment.a(this.this$0)) {
          localStringBuilder.append(AEEditorImageEditFragment.a(this.this$0).a((String)AEEditorImageEditFragment.a(this.this$0).get(paramInt)).getSceneLabel() + "(当前图)|");
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if ((AEEditorImageEditFragment.a(this.this$0).a((String)AEEditorImageEditFragment.a(this.this$0).get(paramInt)) != null) && (((axks)paramaxkn.Bu.get(paramInt)).bGa))
          {
            AEEditorImageEditFragment.a(this.this$0).b(paramInt, AEEditorImageEditFragment.a(this.this$0).a((String)AEEditorImageEditFragment.a(this.this$0).get(paramInt)));
            localStringBuilder.append(AEEditorImageEditFragment.a(this.this$0).a((String)AEEditorImageEditFragment.a(this.this$0).get(paramInt)).getSceneLabel() + "(err)|");
          }
          else
          {
            AEEditorImageEditFragment.a(this.this$0).a((String)AEEditorImageEditFragment.a(this.this$0).get(paramInt), (axkn)paramaxkn.Bu.get(paramInt));
            AEEditorImageEditFragment.a(this.this$0).put(String.valueOf(paramInt), this.this$0.a((axkn)paramaxkn.Bu.get(paramInt)));
            AEEditorImageEditFragment.a(this.this$0).b(paramInt, (axkn)paramaxkn.Bu.get(paramInt));
            localStringBuilder.append(((axks)paramaxkn.Bu.get(paramInt)).getSceneLabel() + "|");
          }
        }
      }
      this.this$0.jQ("智能滤镜label", localStringBuilder.toString());
    }
    AEEditorImageEditFragment.b(this.this$0, AEEditorImageEditFragment.a(this.this$0));
  }
  
  public void eLK()
  {
    if (this.this$0.a != null) {
      this.this$0.a.cancelLoading();
    }
    QQToast.a(this.this$0.context, "资源下载中，请稍后再试", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axma
 * JD-Core Version:    0.7.0.1
 */