import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class lbr
  extends acfd
{
  public lbr(KandianMergeManager paramKandianMergeManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(KandianMergeManager.b(this.this$0), paramString)) && (!TextUtils.equals(paramString, acbn.blx))) {
      KandianMergeManager.a(this.this$0).getBusinessHandler(1).notifyUI(4, true, new Object[] { acbn.blx });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbr
 * JD-Core Version:    0.7.0.1
 */