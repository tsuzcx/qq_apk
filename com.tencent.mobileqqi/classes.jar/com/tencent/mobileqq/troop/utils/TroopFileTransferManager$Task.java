package com.tencent.mobileqq.troop.utils;

public abstract class TroopFileTransferManager$Task
  implements Runnable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public TroopFileTransferManager.Item a;
  public boolean a;
  public boolean b = false;
  
  protected TroopFileTransferManager$Task(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    paramTroopFileTransferManager.a[paramInt].a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Task
 * JD-Core Version:    0.7.0.1
 */