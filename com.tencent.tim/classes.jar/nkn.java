import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.34.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class nkn
  implements XListView.a
{
  public nkn(FastWebActivity paramFastWebActivity) {}
  
  public void aDi()
  {
    FastWebActivity.i(this.this$0);
    FastWebActivity.a(this.this$0).l(FastWebActivity.a(this.this$0), 0);
    if (FastWebActivity.i(this.this$0))
    {
      FastWebActivity.a(this.this$0).tN(FastWebActivity.a(this.this$0).getWidth());
      FastWebActivity.g(this.this$0, false);
      FastWebActivity.j(this.this$0);
      FastWebActivity.a(this.this$0, new nlj(FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0).getFirstVisiblePosition(), FastWebActivity.a(this.this$0).getLastVisiblePosition()));
      long l = nnw.J("FastWebActivity.show");
      nnw.K("fast_web_show_light_house_draw_finish");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FastWebActivity.a(this.this$0));
      ThreadManager.post(new FastWebActivity.34.1(this, l, localArrayList), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkn
 * JD-Core Version:    0.7.0.1
 */