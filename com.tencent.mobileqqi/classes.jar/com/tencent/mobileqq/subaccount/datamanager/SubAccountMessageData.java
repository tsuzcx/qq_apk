package com.tencent.mobileqq.subaccount.datamanager;

import com.tencent.mobileqq.data.SubAccountMessage;

public class SubAccountMessageData
{
  private SubAccountMessage a;
  public CharSequence a;
  public String a;
  public boolean a;
  
  public SubAccountMessageData() {}
  
  public SubAccountMessageData(SubAccountMessage paramSubAccountMessage)
  {
    this.a = paramSubAccountMessage;
  }
  
  public SubAccountMessage a()
  {
    return this.a;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.isread = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.datamanager.SubAccountMessageData
 * JD-Core Version:    0.7.0.1
 */