import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.35.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import mqq.os.MqqHandler;
import pb.unite.search.RequestSearchWord.Rcmd;

public class nfx
  implements acnm.a
{
  public nfx(ReadInJoyListViewGroup paramReadInJoyListViewGroup, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2) {}
  
  public void a(PBRepeatMessageField<RequestSearchWord.Rcmd> paramPBRepeatMessageField, PBStringField paramPBStringField)
  {
    if ((paramPBRepeatMessageField == null) || (paramPBRepeatMessageField.size() <= 0)) {
      return;
    }
    if (ReadInJoyListViewGroup.a(this.this$0).containsKey(this.d.mRefreshTime)) {
      ReadInJoyListViewGroup.a(this.this$0).put(this.d.mRefreshTime, Integer.valueOf(this.aYu + 1));
    }
    for (;;)
    {
      aqmj.bn("search_word_prefix_show_times", aqmj.bd("search_word_prefix_show_times") + 1L);
      ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.35.1(this, paramPBRepeatMessageField, paramPBStringField));
      return;
      ReadInJoyListViewGroup.a(this.this$0).put(this.d.mRefreshTime, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nfx
 * JD-Core Version:    0.7.0.1
 */