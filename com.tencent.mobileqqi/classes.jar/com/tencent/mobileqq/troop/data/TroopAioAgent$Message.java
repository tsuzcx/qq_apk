package com.tencent.mobileqq.troop.data;

public final class TroopAioAgent$Message
{
  public int a;
  public long a;
  public int b;
  public long b;
  public int c;
  
  public static Message a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.jdField_a_of_type_Int = TroopAioAgent.jdField_b_of_type_Int;
    localMessage.jdField_b_of_type_Int = paramInt;
    return localMessage;
  }
  
  public static Message a(int paramInt, long paramLong1, long paramLong2)
  {
    Message localMessage = new Message();
    localMessage.jdField_a_of_type_Int = TroopAioAgent.jdField_a_of_type_Int;
    localMessage.jdField_a_of_type_Long = paramLong1;
    localMessage.jdField_b_of_type_Long = paramLong2;
    localMessage.c = paramInt;
    return localMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioAgent.Message
 * JD-Core Version:    0.7.0.1
 */