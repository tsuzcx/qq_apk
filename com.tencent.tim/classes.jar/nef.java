import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class nef
  extends lge
{
  nef(ndi paramndi, String paramString, int paramInt1, BaseArticleInfo paramBaseArticleInfo, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(lfz paramlfz)
  {
    auvk.traceBegin("ReadInJoyBaseAdapter.Viewtype " + this.val$type);
    if (this.this$0.eb(this.val$type)) {
      if ((kvx.a(this.this$0.getVafContext(), this.val$type, this.b)) && (this.this$0.mChannelID != 56))
      {
        if ((paramlfz instanceof lgb)) {}
      }
      else {
        while ((paramlfz instanceof lgb)) {
          return;
        }
      }
    }
    if (paramlfz.df(this.val$type)) {
      this.aI = paramlfz.d(this.val$position, this.mm, this.val$parent);
    }
    auvk.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nef
 * JD-Core Version:    0.7.0.1
 */