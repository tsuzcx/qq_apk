import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class ngp
  extends lge
{
  ngp(ngn paramngn, String paramString, int paramInt1, BaseArticleInfo paramBaseArticleInfo, int paramInt2, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(lfz paramlfz)
  {
    auvk.traceBegin("ReadInJoyBaseAdapter.Viewtype " + this.val$type);
    if (this.a.eb(this.val$type)) {
      if ((kvx.a(this.a.getVafContext(), this.val$type, this.b)) && (this.a.mChannelID != 56))
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
      this.aI = paramlfz.d(this.val$position, null, this.val$parent);
    }
    auvk.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngp
 * JD-Core Version:    0.7.0.1
 */