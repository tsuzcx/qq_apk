package com.hp.hpl.sparta;

import java.util.Hashtable;

class Sparta$1
  implements Sparta.Internment
{
  private final Hashtable strings_ = new Hashtable();
  
  public String intern(String paramString)
  {
    String str = (String)this.strings_.get(paramString);
    if (str == null)
    {
      this.strings_.put(paramString, paramString);
      return paramString;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.Sparta.1
 * JD-Core Version:    0.7.0.1
 */