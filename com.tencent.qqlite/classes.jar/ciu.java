import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;

public class ciu
  implements GestureSelectGridView.OnSelectListener
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ciu(PhotoListActivity paramPhotoListActivity) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Boolean) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("OnSelectListener", 2, "onSelectEnd");
  }
  
  public void a(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Boolean) {}
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OnSelectListener", 2, "onSelectBegin beginIndex:" + paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = -2147483648;
      this.b = 2147483647;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Cja.a(paramInt);
      if (localLocalMediaInfo.b == 2) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
    } while (!PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, localLocalMediaInfo, this.jdField_a_of_type_Boolean));
    PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.n();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnSelectListener", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int i = Math.min(paramInt1, paramInt2);
    int j = Math.max(paramInt1, paramInt2);
    if (paramInt2 < paramInt1) {
      this.b = Math.min(paramInt2, this.b);
    }
    for (;;)
    {
      paramInt1 = i;
      while (paramInt1 <= j)
      {
        PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Cja.a(paramInt1), this.jdField_a_of_type_Boolean);
        paramInt1 += 1;
      }
      this.jdField_a_of_type_Int = Math.max(paramInt2, this.jdField_a_of_type_Int);
    }
    paramInt1 = this.b;
    PhotoListActivity localPhotoListActivity;
    LocalMediaInfo localLocalMediaInfo;
    boolean bool;
    if (paramInt1 < i)
    {
      localPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Cja.a(paramInt1);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        PhotoListActivity.a(localPhotoListActivity, localLocalMediaInfo, bool);
        paramInt1 += 1;
        break;
      }
    }
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Cja.a(paramInt1);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        PhotoListActivity.a(localPhotoListActivity, localLocalMediaInfo, bool);
        paramInt1 += 1;
        break;
      }
    }
    PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ciu
 * JD-Core Version:    0.7.0.1
 */