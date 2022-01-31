package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.util.Utils;

public class MessageDecContent
{
  public int a;
  public long a;
  public Object a;
  public String a;
  
  public MessageDecContent(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("-----MessageDecContent----");
    localStringBuilder.append("msgType:").append(this.jdField_a_of_type_Int).append(" content:").append(Utils.a(this.jdField_a_of_type_JavaLangString));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageDecContent
 * JD-Core Version:    0.7.0.1
 */