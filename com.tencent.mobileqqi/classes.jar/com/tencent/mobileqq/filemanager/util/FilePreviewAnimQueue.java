package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import android.view.animation.Animation;
import fyl;
import java.util.ArrayList;
import java.util.List;

public class FilePreviewAnimQueue
{
  public View a;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = new int[1];
  
  public FilePreviewAnimQueue(View paramView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void b(FilePreviewAnimQueue.FilePreviewAnim paramFilePreviewAnim)
  {
    Animation localAnimation = (Animation)paramFilePreviewAnim.jdField_a_of_type_JavaLangObject;
    localAnimation.setDuration(paramFilePreviewAnim.jdField_a_of_type_Int);
    localAnimation.setAnimationListener(new fyl(this, paramFilePreviewAnim));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        continue;
      }
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = (FilePreviewAnimQueue.FilePreviewAnim)this.jdField_a_of_type_JavaUtilList.get(0);
        this.jdField_a_of_type_JavaUtilList.remove(0);
        if ((localFilePreviewAnim == null) || ((localFilePreviewAnim.jdField_a_of_type_Boolean == true) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) || ((!localFilePreviewAnim.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4)))) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewView.setAnimation((Animation)localFilePreviewAnim.jdField_a_of_type_JavaLangObject);
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localFilePreviewAnim.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
  }
  
  public void a(FilePreviewAnimQueue.FilePreviewAnim paramFilePreviewAnim)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramFilePreviewAnim);
      b(paramFilePreviewAnim);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue
 * JD-Core Version:    0.7.0.1
 */