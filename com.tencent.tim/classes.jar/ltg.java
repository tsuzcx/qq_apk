import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class ltg
  extends lsz
{
  public ltg(NativeCommentView paramNativeCommentView, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.this$0.b.a.a();
    if (paramView.isPGCShortContent())
    {
      kxm.b(this.this$0.getContext(), paramView, (int)paramView.mChannelID);
      lrm.b(this.this$0.getContext(), paramView);
      return;
    }
    kxm.a(this.this$0.getContext(), this.this$0.b.a.a(), 1, false, 8, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltg
 * JD-Core Version:    0.7.0.1
 */