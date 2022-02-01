import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tof
  implements ots
{
  tof(toc paramtoc) {}
  
  public void a()
  {
    if (toc.a(this.a) != null) {
      toc.a(this.a).a();
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
    toc.a(this.a, true);
    toc.a(this.a).c();
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
      toc.a(this.a).e();
      toc.a(this.a, false);
      toc.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tof
 * JD-Core Version:    0.7.0.1
 */