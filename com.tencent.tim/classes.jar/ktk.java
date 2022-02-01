import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

public class ktk
{
  public static class a
  {
    View divider;
    View ka;
    TextView tvTitle;
    
    public View a(kte paramkte, int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        localView = paramkte.a().inflate(2131560291, paramViewGroup, false);
        this.tvTitle = ((TextView)localView.findViewById(2131380976));
        if (this.tvTitle.getPaint() != null) {
          this.tvTitle.getPaint().setFakeBoldText(true);
        }
        this.ka = localView.findViewById(2131381928);
        this.ka.setVisibility(0);
        this.divider = localView.findViewById(2131381913);
        this.divider.setVisibility(0);
      }
      localView.setTag(this);
      return localView;
    }
    
    public void a(kte paramkte, int paramInt)
    {
      if (paramkte == null) {
        return;
      }
      ktm localktm = (ktm)paramkte.getItem(paramInt);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (localktm.a != null) {
        paramkte.a().D(localktm.a.commentId);
      }
      this.tvTitle.setText(localSpannableStringBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktk
 * JD-Core Version:    0.7.0.1
 */