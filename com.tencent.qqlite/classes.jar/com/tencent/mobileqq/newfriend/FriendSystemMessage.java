package com.tencent.mobileqq.newfriend;

public class FriendSystemMessage
  extends NewFriendMessage
{
  public FriendSystemMessage()
  {
    super(1);
  }
  
  public FriendSystemMessage(int paramInt)
  {
    super(1, paramInt);
  }
  
  public FriendSystemMessage(int paramInt, String paramString, long paramLong)
  {
    super(1);
    this.o = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.FriendSystemMessage
 * JD-Core Version:    0.7.0.1
 */