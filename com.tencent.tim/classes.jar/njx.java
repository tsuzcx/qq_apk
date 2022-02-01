import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

public class njx
  implements MessageQueue.IdleHandler
{
  public njx(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    if (FastWebActivity.a(this.this$0).bat == 0) {}
    for (String str = "";; str = FastWebActivity.a(this.this$0).aml)
    {
      int i = this.this$0.getIntent().getIntExtra("floating_window_scene", 0);
      nnc.a(FastWebActivity.a(this.this$0).articleId, FastWebActivity.a(this.this$0).rowKey, String.valueOf(FastWebActivity.a(this.this$0).puin), FastWebActivity.a(this.this$0).tags, FastWebActivity.a(this.this$0).FP(), str, FastWebActivity.a(this.this$0).amj, FastWebActivity.a(this.this$0).amk, FastWebActivity.a(this.this$0), FastWebActivity.b(this.this$0), i, FastWebActivity.a(this.this$0).mChannelID);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njx
 * JD-Core Version:    0.7.0.1
 */