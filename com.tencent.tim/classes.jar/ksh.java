import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class ksh
  implements afmf
{
  public ksh(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void a(afmi paramafmi)
  {
    if ((paramafmi instanceof afpu))
    {
      paramafmi = (afpu)paramafmi;
      Context localContext = ReadInJoyCommentComponentFragment.a(this.this$0).getApplicationContext();
      this.this$0.ix.setImageDrawable(paramafmi.a(localContext, localContext.getResources().getDisplayMetrics().density));
      this.this$0.eP.setVisibility(0);
      ReadInJoyCommentComponentFragment.a(this.this$0);
      return;
    }
    ReadInJoyBaseDeliverActivity.a(ReadInJoyCommentComponentFragment.a(this.this$0).app, paramafmi, this.this$0.a);
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return true;
  }
  
  public void b(afmi paramafmi) {}
  
  public void delete()
  {
    if (this.this$0.a.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.this$0.a.getText();
        int i = this.this$0.a.getSelectionStart();
        int j = TextUtils.getOffsetBefore(this.this$0.a.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void gq() {}
  
  public void send() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksh
 * JD-Core Version:    0.7.0.1
 */