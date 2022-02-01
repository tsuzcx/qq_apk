import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.image.AbstractGifImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class nkc
  implements AbsListView.e
{
  public nkc(FastWebActivity paramFastWebActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FastWebActivity.a(this.this$0) != null)
    {
      FastWebActivity.a(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      FastWebActivity.a(this.this$0).a(this.this$0.app, paramAbsListView, paramInt1, paramInt2);
    }
    FastWebActivity.a(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (FastWebActivity.a(this.this$0) != null) {
      FastWebActivity.a(this.this$0).a(FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0).getFirstVisiblePosition(), paramInt2);
    }
    FastWebActivity.a(this.this$0, paramAbsListView, paramInt1 + paramInt2 - 1, false);
    FastWebActivity.c(this.this$0, 0);
    paramAbsListView = paramAbsListView.getChildAt(0);
    if ((paramAbsListView != null) && (FastWebActivity.c(this.this$0) != paramAbsListView.getTop()))
    {
      FastWebActivity.d(this.this$0, paramAbsListView.getTop());
      FastWebActivity.e(this.this$0, 0);
    }
    if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0) && (paramInt1 == 0))
    {
      QLog.d(FastWebActivity.a(this.this$0), 2, "on scroller top");
      FastWebActivity.c(this.this$0, 1);
    }
    if (paramInt2 + paramInt1 == paramInt3)
    {
      QLog.d(FastWebActivity.a(this.this$0), 2, "on scroller bottom");
      FastWebActivity.c(this.this$0, 2);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool1 = FastWebActivity.a(this.this$0, FastWebActivity.a(this.this$0).getLastVisiblePosition());
    String str1;
    String str2;
    if (bool1)
    {
      str1 = "list_comment_kandian";
      str2 = str1;
      if (lvy.a().CN())
      {
        str2 = str1;
        if (TextUtils.equals(str1, "list_kandian_native_web")) {
          str2 = "list_kandian_native_web_lite";
        }
      }
      if (paramInt != 0) {
        break label341;
      }
      AbstractGifImage.resumeAll();
      int i = FastWebActivity.a(this.this$0).getFirstVisiblePosition();
      FastWebActivity.e(this.this$0);
      FastWebActivity.a(this.this$0, i);
      txn.a().stopMonitorScene(str2, false);
      label101:
      boolean bool2 = FastWebActivity.b(this.this$0, FastWebActivity.a(this.this$0).getFirstVisiblePosition());
      nns.a(paramAbsListView, paramInt, FastWebActivity.a(this.this$0).innerUniqueID, FastWebActivity.a(this.this$0, paramAbsListView, paramInt), bool2);
      if (FastWebActivity.a(this.this$0) != null) {
        FastWebActivity.a(this.this$0).l(paramAbsListView, paramInt);
      }
      FastWebActivity.a(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
      FastWebActivity.f(this.this$0);
      if (FastWebActivity.a(this.this$0) != null) {
        FastWebActivity.a(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
      }
      if (paramInt == 1) {
        FastWebActivity.e(this.this$0);
      }
      if (!bool1) {
        break label355;
      }
      FastWebActivity.a(this.this$0).wakeUp();
      if ((FastWebActivity.a(this.this$0) != null) && (FastWebActivity.a(this.this$0) != null) && (FastWebActivity.a(this.this$0).a() != null)) {
        FastWebActivity.a(this.this$0).a().cx(FastWebActivity.a(this.this$0).getFirstVisiblePosition() - FastWebActivity.a(this.this$0).getCount(), FastWebActivity.a(this.this$0).getLastVisiblePosition() - FastWebActivity.a(this.this$0).getCount());
      }
    }
    for (;;)
    {
      this.this$0.f(paramAbsListView, paramInt);
      return;
      str1 = "list_kandian_native_web";
      break;
      label341:
      AbstractGifImage.pauseAll();
      txn.a().startMonitorScene(str2);
      break label101;
      label355:
      FastWebActivity.a(this.this$0).aIc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkc
 * JD-Core Version:    0.7.0.1
 */