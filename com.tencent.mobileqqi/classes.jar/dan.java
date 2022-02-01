import com.tencent.mobileqq.activity.PublicAccountActivity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;

public class dan
  extends PublicAccountObserver
{
  public dan(PublicAccountActivity paramPublicAccountActivity) {}
  
  public void a()
  {
    this.a.a(true);
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.a(true);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt == 0) {
        this.a.c();
      }
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Boolean = false;
      }
      if (paramInt != 0) {
        break label79;
      }
      PublicAccountActivity.a(this.a).a(0);
      PublicAccountActivity.a(this.a).sendEmptyMessageDelayed(1, 800L);
    }
    for (;;)
    {
      PublicAccountActivity.a(this.a).sendEmptyMessageDelayed(3, 1200L);
      return;
      label79:
      this.a.jdField_a_of_type_ComTencentWidgetXListView.B();
      QQToast.a(this.a, 1, 2131562097, 0).b(this.a.d());
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dan
 * JD-Core Version:    0.7.0.1
 */