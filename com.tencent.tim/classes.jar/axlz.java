import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class axlz
  implements axjp.a
{
  public axlz(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, axkn paramaxkn)
  {
    if (this.this$0.a != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.7.1(this, paramaxkn));
    }
    if (paramInt == 0)
    {
      axiy.i(AEEditorImageEditFragment.access$100(), "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.7.3(this));
      if (AEEditorImageEditFragment.a(this.this$0) != null) {
        break label107;
      }
    }
    label107:
    axks localaxks;
    do
    {
      do
      {
        return;
        axiy.i(AEEditorImageEditFragment.access$100(), "onAIFilterAppliedFailed:" + paramInt);
        ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.7.2(this));
        break;
      } while (paramaxkn == null);
      AEEditorImageEditFragment.a(this.this$0).a((String)AEEditorImageEditFragment.a(this.this$0).get(AEEditorImageEditFragment.a(this.this$0)), paramaxkn);
      AEEditorImageEditFragment.a(this.this$0).put(String.valueOf(AEEditorImageEditFragment.a(this.this$0)), this.this$0.a(paramaxkn));
      localaxks = (axks)paramaxkn;
    } while (localaxks == null);
    AEEditorImageEditFragment.a(this.this$0).b(AEEditorImageEditFragment.a(this.this$0), paramaxkn);
    AEEditorImageEditFragment.a(this.this$0).setOverlayImage(AEEditorImageEditFragment.a(this.this$0), null);
    AEEditorImageEditFragment.a(this.this$0).setAEKitAIFilter(AEEditorImageEditFragment.a(this.this$0), localaxks.lutPath, localaxks.lutStrengt, localaxks.adjustParam, (int)(localaxks.smoothLevel * 100.0F), localaxks.glowStrength);
    this.this$0.aO(new String[] { "智能滤镜label", localaxks.sceneLabel, "智能滤镜errCode", String.valueOf(paramInt) });
    paramaxkn = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localaxks.sceneLabel)) {
        break label424;
      }
      paramaxkn = localNewEnhanceCategories.filterType;
    }
    label424:
    for (;;)
    {
      break;
      axip.a().a().rd.put(Integer.valueOf(AEEditorImageEditFragment.a(this.this$0)), "lut_aieffect_" + paramaxkn);
      axip.a().a().re.put(Integer.valueOf(AEEditorImageEditFragment.a(this.this$0)), Float.valueOf(-1.0F));
      return;
    }
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
 * Qualified Name:     axlz
 * JD-Core Version:    0.7.0.1
 */