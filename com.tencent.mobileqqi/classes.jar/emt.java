import com.tencent.mobileqq.activity.photo.LocalPhotoInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;

public class emt
  implements GestureSelectGridView.OnSelectListener
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int b = 2147483647;
  
  public emt(PhotoListActivity paramPhotoListActivity) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnSelectListener", 2, "onSelectEnd");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.b = 2147483647;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Boolean) {
      return;
    }
    LocalPhotoInfo localLocalPhotoInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Emz.a(paramInt);
    label37:
    PhotoListActivity localPhotoListActivity;
    if (localLocalPhotoInfo.e == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      localPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
      if (this.jdField_a_of_type_Boolean) {
        break label122;
      }
    }
    label122:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (PhotoListActivity.a(localPhotoListActivity, localLocalPhotoInfo, bool1))
      {
        PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.n();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OnSelectListener", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
      bool1 = false;
      break label37;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnSelectListener", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int j;
    int i;
    label81:
    LocalPhotoInfo localLocalPhotoInfo;
    PhotoListActivity localPhotoListActivity;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.b > paramInt2)
      {
        this.b = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
      paramInt1 = i;
      if (paramInt1 > j) {
        break label160;
      }
      localLocalPhotoInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Emz.a(paramInt1);
      localPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
      if (this.jdField_a_of_type_Boolean) {
        break label154;
      }
    }
    label154:
    for (boolean bool = true;; bool = false)
    {
      PhotoListActivity.a(localPhotoListActivity, localLocalPhotoInfo, bool);
      paramInt1 += 1;
      break label81;
      if (this.jdField_a_of_type_Int < paramInt2) {
        this.jdField_a_of_type_Int = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
      break;
    }
    label160:
    paramInt1 = j + 1;
    while (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localLocalPhotoInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Emz.a(paramInt1);
      PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, localLocalPhotoInfo, this.jdField_a_of_type_Boolean);
      paramInt1 += 1;
    }
    paramInt1 = this.b;
    while (paramInt1 < i)
    {
      localLocalPhotoInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Emz.a(paramInt1);
      PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, localLocalPhotoInfo, this.jdField_a_of_type_Boolean);
      paramInt1 += 1;
    }
    PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     emt
 * JD-Core Version:    0.7.0.1
 */