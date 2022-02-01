import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;

public class ngg
  implements kqd.a
{
  public ngg(ReadInJoyListViewGroup paramReadInJoyListViewGroup, ArticleInfo paramArticleInfo) {}
  
  public void b(kqf paramkqf)
  {
    if (paramkqf.getResultCode() == 0) {
      ksz.a(this.d, new CommentInfo(), false);
    }
    ReadInJoyListViewGroup.a(this.this$0).clear();
    ReadInJoyListViewGroup.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngg
 * JD-Core Version:    0.7.0.1
 */