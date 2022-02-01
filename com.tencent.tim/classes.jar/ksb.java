import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import mqq.os.MqqHandler;

public class ksb
  implements TextWatcher
{
  public ksb(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i;
    label51:
    label86:
    ykm localykm;
    if ((paramEditable instanceof kpo))
    {
      i = ((kpo)paramEditable).nz();
      if (this.this$0.oN != null)
      {
        if (this.this$0.aLs - i >= -99) {
          break label236;
        }
        this.this$0.oN.setText("-99");
      }
      if (i - this.this$0.aLs <= 0) {
        break label261;
      }
      this.this$0.oN.setTextColor(Color.parseColor("#FF4222"));
      this.this$0.afa = true;
      ReadInJoyCommentComponentFragment.a(this.this$0);
      localykm = ReadInJoyCommentComponentFragment.a(this.this$0);
      if (localykm != null)
      {
        i = paramEditable.toString().trim().length();
        if (i > 0) {
          break label294;
        }
        this.this$0.iB.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((i <= 0) || (paramEditable.length() > 24) || (!localykm.b(paramEditable))) {
        break label308;
      }
      if (ReadInJoyCommentComponentFragment.a(this.this$0))
      {
        localykm.a(ReadInJoyCommentComponentFragment.a(this.this$0).app, paramEditable, null, 7220, false);
        this.this$0.uiHandler.removeMessages(84);
        this.this$0.uiHandler.sendEmptyMessageDelayed(84, 10000L);
      }
      this.this$0.iB.setImageResource(2130843649);
      return;
      i = paramEditable.length();
      break;
      label236:
      this.this$0.oN.setText(String.valueOf(this.this$0.aLs - i));
      break label51;
      label261:
      this.this$0.oN.setTextColor(this.this$0.getResources().getColor(2131165749));
      this.this$0.afa = false;
      break label86;
      label294:
      this.this$0.iB.setVisibility(0);
    }
    label308:
    localykm.ciX();
    ReadInJoyCommentComponentFragment.a(this.this$0, false);
    this.this$0.iB.setSelected(false);
    this.this$0.iB.setImageResource(2130844019);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (ReadInJoyCommentComponentFragment.b(this.this$0)) {
      ReadInJoyCommentComponentFragment.c(this.this$0, false);
    }
    while ((!ReadInJoyCommentComponentFragment.c(this.this$0)) || (paramInt3 != 1) || (paramInt2 != 0) || (!paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@"))) {
      return;
    }
    this.this$0.md("2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksb
 * JD-Core Version:    0.7.0.1
 */