package com.tencent.mobileqq.service;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class TextMsgTask
{
  private static final int c = 160;
  private int jdField_a_of_type_Int;
  private DataLineMsgRecord jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
  private ToServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private Long jdField_b_of_type_JavaLangLong;
  
  public TextMsgTask(String paramString, Long paramLong, DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.jdField_b_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_JavaLangString.length() + 160 - 1) / 160);
    if (i < this.jdField_a_of_type_JavaLangString.length())
    {
      if (i + 160 > this.jdField_a_of_type_JavaLangString.length()) {}
      for (int j = this.jdField_a_of_type_JavaLangString.length() - i;; j = 160)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(i, j + i));
        i += 160;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord = paramDataLineMsgRecord;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(StringBuffer paramStringBuffer)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return -1;
    }
    paramStringBuffer.append((String)this.jdField_a_of_type_JavaUtilArrayList.remove(0));
    int i = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = (i + 1);
    return i;
  }
  
  public DataLineMsgRecord a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
  }
  
  public ToServiceMsg a()
  {
    return this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  }
  
  public Long a()
  {
    return this.jdField_b_of_type_JavaLangLong;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.isEmpty();
  }
  
  public Long b()
  {
    return this.jdField_a_of_type_JavaLangLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.TextMsgTask
 * JD-Core Version:    0.7.0.1
 */