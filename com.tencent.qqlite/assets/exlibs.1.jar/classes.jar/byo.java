import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;

public class byo
  implements GestureSelectGridView.OnSelectListener
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int b = 2147483647;
  
  public byo(AIOImageListScene paramAIOImageListScene) {}
  
  public void a()
  {
    if (!AIOImageListScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectEnd");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.b = 2147483647;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    if (!AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {
      return;
    }
    AIOImageInfo localAIOImageInfo = AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).a(paramInt);
    label37:
    AIOImageListScene localAIOImageListScene;
    if (localAIOImageInfo.b() == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      localAIOImageListScene = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene;
      if (this.jdField_a_of_type_Boolean) {
        break label122;
      }
    }
    label122:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (AIOImageListScene.a(localAIOImageListScene, localAIOImageInfo, bool1))
      {
        AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
        AIOImageListScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).n();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageListScene", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
      bool1 = false;
      break label37;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int j;
    int i;
    label81:
    AIOImageInfo localAIOImageInfo;
    AIOImageListScene localAIOImageListScene;
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
      localAIOImageInfo = AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).a(paramInt1);
      localAIOImageListScene = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene;
      if (this.jdField_a_of_type_Boolean) {
        break label154;
      }
    }
    label154:
    for (boolean bool = true;; bool = false)
    {
      AIOImageListScene.a(localAIOImageListScene, localAIOImageInfo, bool);
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
      localAIOImageInfo = AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).a(paramInt1);
      AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, localAIOImageInfo, this.jdField_a_of_type_Boolean);
      paramInt1 += 1;
    }
    paramInt1 = this.b;
    while (paramInt1 < i)
    {
      localAIOImageInfo = AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).a(paramInt1);
      AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, localAIOImageInfo, this.jdField_a_of_type_Boolean);
      paramInt1 += 1;
    }
    AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
    AIOImageListScene.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byo
 * JD-Core Version:    0.7.0.1
 */