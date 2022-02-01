import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class nko
  implements nmq.a
{
  public nko(FastWebActivity paramFastWebActivity) {}
  
  public void b(nmq.b paramb)
  {
    ArticleInfo localArticleInfo = paramb.b;
    int i = FastWebActivity.e(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.i(FastWebActivity.a(this.this$0), 2, "articleInfo" + localArticleInfo);
    }
    nns.a(localArticleInfo, FastWebActivity.f(this.this$0), i, paramb.asN, this.this$0.mChannelID, FastWebActivity.g(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nko
 * JD-Core Version:    0.7.0.1
 */