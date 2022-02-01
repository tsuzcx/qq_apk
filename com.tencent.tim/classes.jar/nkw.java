import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class nkw
  implements kqd.a
{
  public nkw(FastWebActivity paramFastWebActivity) {}
  
  public void b(kqf paramkqf)
  {
    String str = FastWebActivity.a(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fastWeb");
    if (paramkqf == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramkqf.getResultCode()))
    {
      QLog.d(str, 1, localObject);
      if ((paramkqf != null) && (paramkqf.getResultCode() == 0))
      {
        if (FastWebActivity.a(this.this$0) != null)
        {
          localObject = FastWebActivity.a(this.this$0);
          ((FastWebArticleInfo)localObject).sN += 1L;
          FastWebActivity.a(this.this$0).a(this.this$0, FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0));
        }
        kqd.a(paramkqf.ii(), paramkqf.getCommentId(), paramkqf.getCommentType(), paramkqf.getFeedsType(), paramkqf.isIsSecondReply(), paramkqf.getReplyCommentId(), paramkqf.getReplyUin(), paramkqf.a());
        if ((paramkqf.getCommentType() == 1) && (!FastWebActivity.j(this.this$0)))
        {
          FastWebActivity.h(this.this$0, true);
          nmr.aS(this.this$0);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkw
 * JD-Core Version:    0.7.0.1
 */