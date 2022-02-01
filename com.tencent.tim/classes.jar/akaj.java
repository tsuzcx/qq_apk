import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class akaj
  implements akio.a
{
  akaj(akai paramakai) {}
  
  public void y(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      akio localakio = (akio)this.a.a.this$0.app.getManager(263);
      if (localakio != null) {
        localakio.Ns(paramString);
      }
      ajzv.a(this.a.a.this$0, paramString);
      if ((this.a.a.this$0.Fb.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.this$0.Fb.getContext()).finish();
      }
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131709737), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akaj
 * JD-Core Version:    0.7.0.1
 */