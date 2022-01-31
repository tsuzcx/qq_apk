package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import dnk;

public class DiscOfflinePreviewController
  extends FilePreViewControllerBase
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  public String a;
  public boolean a;
  String b;
  
  public DiscOfflinePreviewController(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    a();
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dnk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.b, this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.DiscOfflinePreviewController
 * JD-Core Version:    0.7.0.1
 */