import android.view.View;
import com.tencent.qphone.base.util.QLog;

class ivj
  implements ausj.a
{
  ivj(ivc.b paramb, long paramLong, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "showChooseTypeActionSheet, which[" + paramInt + "], seq[" + this.kQ + "], mIHandle[" + this.this$0.a + "]");
    }
    if (this.this$0.a == null) {
      return;
    }
    paramView = paramView.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.s.dismiss();
      return;
      this.this$0.c(this.kQ, paramView);
      continue;
      this.this$0.b(this.kQ, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivj
 * JD-Core Version:    0.7.0.1
 */