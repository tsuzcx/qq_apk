package com.dataline.util;

public class DatalineMsgEntity
{
  private int jdField_a_of_type_Int;
  private DatalineMsgEntity.FileEntity jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$FileEntity;
  private DatalineMsgEntity.ImageEntity jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$ImageEntity;
  private DatalineMsgEntity.TextEntity jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$TextEntity;
  private DatalineMsgEntity.VideoEntity jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$VideoEntity;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public DatalineMsgEntity()
  {
    b(false);
    this.jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$FileEntity = new DatalineMsgEntity.FileEntity(this);
    this.jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$ImageEntity = new DatalineMsgEntity.ImageEntity(this);
    this.jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$TextEntity = new DatalineMsgEntity.TextEntity(this);
    this.jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$VideoEntity = new DatalineMsgEntity.VideoEntity(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public DatalineMsgEntity.FileEntity a()
  {
    return this.jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$FileEntity;
  }
  
  public DatalineMsgEntity.ImageEntity a()
  {
    return this.jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$ImageEntity;
  }
  
  public DatalineMsgEntity.TextEntity a()
  {
    return this.jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$TextEntity;
  }
  
  public DatalineMsgEntity.VideoEntity a()
  {
    return this.jdField_a_of_type_ComDatalineUtilDatalineMsgEntity$VideoEntity;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.DatalineMsgEntity
 * JD-Core Version:    0.7.0.1
 */