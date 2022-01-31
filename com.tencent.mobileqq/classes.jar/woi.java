import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.widget.QQToast;

public class woi
  extends BizTroopObserver
{
  public woi(TroopFragment paramTroopFragment) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt2 == 0)
    {
      this.a.h();
      if (this.a.isResumed()) {
        if (paramInt1 != 0) {
          break label44;
        }
      }
    }
    label44:
    while (!this.a.isResumed())
    {
      QQToast.a(this.a.getActivity(), 2, "成功设为置顶群", 0).a();
      do
      {
        return;
      } while (paramInt1 != 1);
      QQToast.a(this.a.getActivity(), 2, "成功取消置顶群", 0).a();
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = this.a.getResources().getString(2131435580);
    }
    QQToast.a(this.a.getActivity(), 1, paramString1, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     woi
 * JD-Core Version:    0.7.0.1
 */