import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class dbs
  implements Runnable
{
  public dbs(QQBrowserActivity paramQQBrowserActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.getWidth() < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.setMove(true);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.getWidth() < this.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setMove(true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.setMove(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dbs
 * JD-Core Version:    0.7.0.1
 */