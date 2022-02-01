import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment;
import com.tencent.mobileqq.widget.QQToast;

public class zco
  extends accd
{
  public zco(TroopFragment paramTroopFragment) {}
  
  protected void c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 0)
    {
      this.this$0.bOm();
      if (this.this$0.isResumed()) {
        if (paramInt1 != 0) {
          break label47;
        }
      }
    }
    label47:
    while (!this.this$0.isResumed())
    {
      QQToast.a(this.this$0.getActivity(), 2, acfp.m(2131715740), 0).show();
      do
      {
        return;
      } while (paramInt1 != 1);
      QQToast.a(this.this$0.getActivity(), 2, acfp.m(2131715739), 0).show();
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = this.this$0.getResources().getString(2131696690);
    }
    QQToast.a(this.this$0.getActivity(), 1, paramString1, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zco
 * JD-Core Version:    0.7.0.1
 */