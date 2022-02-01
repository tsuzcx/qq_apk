import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.b;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.c;

public class apkj
  implements aplb.a
{
  public apkj(XMediaEditor paramXMediaEditor) {}
  
  public void c(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (XMediaEditor.a(this.this$0) != this.this$0.a.aBi())
    {
      paramViewHolder = this.this$0;
      if (XMediaEditor.a(this.this$0)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      XMediaEditor.a(paramViewHolder, paramBoolean);
      if (XMediaEditor.a(this.this$0) != null) {
        XMediaEditor.a(this.this$0).RP(XMediaEditor.a(this.this$0));
      }
      return;
    }
  }
  
  public void h(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = ((aplc.a)paramViewHolder).a;
    this.this$0.df(paramViewHolder.mPosition);
  }
  
  public void i(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = ((aplc.a)paramViewHolder).a.mPosition;
    if (i == 0) {}
    while (this.this$0.a.a(i - 1).getType() == -1) {
      return;
    }
    this.this$0.df(i - 1);
  }
  
  public void j(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (aplj.a)paramViewHolder;
    if (XMediaEditor.a(this.this$0) != null) {
      XMediaEditor.a(this.this$0).cRf = false;
    }
    XMediaEditor.a(this.this$0, (apkt)paramViewHolder.a);
    if (XMediaEditor.a(this.this$0) != null) {
      XMediaEditor.a(this.this$0).onFocusChanged(paramViewHolder.mEditText, true);
    }
  }
  
  public void jR(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    paramInt1 = paramInt2 - paramInt1;
    if (XMediaEditor.a(this.this$0) != null) {
      XMediaEditor.a(this.this$0).jS(XMediaEditor.a(this.this$0), XMediaEditor.a(this.this$0) + paramInt1);
    }
    XMediaEditor.a(this.this$0, paramInt1 + XMediaEditor.a(this.this$0));
  }
  
  public void k(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (aplj.a)paramViewHolder;
    if (XMediaEditor.a(this.this$0) != null) {
      XMediaEditor.a(this.this$0).onFocusChanged(paramViewHolder.mEditText, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkj
 * JD-Core Version:    0.7.0.1
 */