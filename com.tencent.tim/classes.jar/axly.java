import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.5.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.5.2;
import mqq.os.MqqHandler;

public class axly
  implements aolm.b
{
  public axly(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt) {}
  
  public void onResp(aomh paramaomh)
  {
    AEEditorImageEditFragment.a(this.this$0, null);
    if (AEEditorImageEditFragment.a(this.this$0) == null) {}
    while (AEEditorImageEditFragment.a(this.this$0)) {
      return;
    }
    if (paramaomh.mRespData != null)
    {
      paramaomh = AEEditorImageEditFragment.a(this.this$0, this.val$currentIndex, paramaomh.mRespData, paramaomh.reqCost);
      if (!TextUtils.isEmpty(paramaomh))
      {
        paramaomh = new axkq(paramaomh);
        AEEditorImageEditFragment.a(this.this$0).put(this.val$currentIndex, paramaomh);
        AEEditorImageEditFragment.a(this.this$0, this.val$currentIndex, paramaomh);
        return;
      }
      axiy.e(AEEditorImageEditFragment.access$100(), "processComicResponse return path is empty");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.5.1(this));
      return;
    }
    axim.a().l(paramaomh.mErrCode, paramaomh.reqCost + "", "lut_comics", -2);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.5.2(this));
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axly
 * JD-Core Version:    0.7.0.1
 */