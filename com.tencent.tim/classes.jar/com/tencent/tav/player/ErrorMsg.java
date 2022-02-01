package com.tencent.tav.player;

public class ErrorMsg
{
  private int errorCode;
  private String errorMsg;
  
  public ErrorMsg(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.player.ErrorMsg
 * JD-Core Version:    0.7.0.1
 */