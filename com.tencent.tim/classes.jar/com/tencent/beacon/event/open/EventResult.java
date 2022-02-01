package com.tencent.beacon.event.open;

public final class EventResult
{
  public static final int ERROR_CODE_NAME_NULL = 106;
  public static final int ERROR_CODE_NOT_ENABLE = 102;
  public static final int ERROR_CODE_OFFER_FAIL = 103;
  public static final int ERROR_CODE_OTHER = 199;
  public static final int ERROR_CODE_PREVENT = 100;
  public static final int ERROR_CODE_SAMPLE = 101;
  public static final int ERROR_CODE_SUCCESS = 0;
  public static final int ERROR_PARAMS_LONG = 105;
  public String errMsg;
  public int errorCode;
  public long eventID;
  
  public EventResult(int paramInt, long paramLong, String paramString)
  {
    this.errorCode = paramInt;
    this.eventID = paramLong;
    this.errMsg = paramString;
  }
  
  public boolean isSuccess()
  {
    return this.errorCode == 0;
  }
  
  public static final class a
  {
    public static EventResult a(int paramInt)
    {
      switch (paramInt)
      {
      case 104: 
      default: 
        return null;
      case 106: 
        return new EventResult(paramInt, -1L, "event code isEmpty!");
      case 105: 
        return new EventResult(paramInt, -1L, "event params length > 45K!");
      case 103: 
        return new EventResult(paramInt, -1L, "insert event to db error!");
      case 102: 
        return new EventResult(paramInt, -1L, "event report not enable!");
      case 101: 
        return new EventResult(paramInt, -1L, "sampled by svr rate (false).");
      }
      return new EventResult(paramInt, -1L, "not allowed in strategy (false).");
    }
    
    public static EventResult a(long paramLong)
    {
      return new EventResult(0, paramLong, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.open.EventResult
 * JD-Core Version:    0.7.0.1
 */