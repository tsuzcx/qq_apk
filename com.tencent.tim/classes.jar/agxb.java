import android.view.View;
import android.view.View.OnLongClickListener;

class agxb
  implements View.OnLongClickListener
{
  agxb(agxa paramagxa) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.this$0.a.b();
    agxa.a(this.this$0, paramView);
    String str = this.this$0.vE() + "(" + ahbj.g(this.this$0.a.getFileSize()) + ")";
    this.this$0.a(paramView, str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxb
 * JD-Core Version:    0.7.0.1
 */