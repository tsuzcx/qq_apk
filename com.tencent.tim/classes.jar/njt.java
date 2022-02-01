import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

public class njt
  implements ksm.a
{
  public njt(FastWebActivity paramFastWebActivity) {}
  
  public void ch(long paramLong)
  {
    if (FastWebActivity.a(this.this$0) != null)
    {
      FastWebActivity.a(this.this$0).sN = paramLong;
      if (FastWebActivity.a(this.this$0).sN <= 0L)
      {
        FastWebActivity.a(this.this$0).sN = 0L;
        this.this$0.aZa();
      }
      FastWebActivity.a(this.this$0).a(this.this$0, FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njt
 * JD-Core Version:    0.7.0.1
 */