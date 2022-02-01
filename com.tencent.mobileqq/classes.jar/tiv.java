import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tiv
  implements ost
{
  tiv(tis paramtis) {}
  
  public void a()
  {
    if (tis.a(this.a) != null) {
      tis.a(this.a).a();
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
    tis.a(this.a, true);
    tis.a(this.a).c();
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
      tis.a(this.a).e();
      tis.a(this.a, false);
      tis.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tiv
 * JD-Core Version:    0.7.0.1
 */