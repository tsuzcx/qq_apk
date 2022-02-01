import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ubt
  implements pbv
{
  ubt(ubq paramubq) {}
  
  public void a()
  {
    if (ubq.a(this.a) != null) {
      ubq.a(this.a).a();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaCommentManager", 2, "setFirstCommentVisible: visible=" + paramBoolean);
    }
    if (paramBoolean) {
      return;
    }
    ubq.a(this.a, true);
    ubq.a(this.a).d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ubq.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubt
 * JD-Core Version:    0.7.0.1
 */