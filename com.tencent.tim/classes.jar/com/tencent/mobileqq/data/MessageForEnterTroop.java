package com.tencent.mobileqq.data;

import java.util.ArrayList;
import java.util.List;

public class MessageForEnterTroop
  extends ChatMessage
{
  public List<a> mList = new ArrayList();
  
  protected void doParse() {}
  
  public static final class a
  {
    public String nick;
    public String uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForEnterTroop
 * JD-Core Version:    0.7.0.1
 */