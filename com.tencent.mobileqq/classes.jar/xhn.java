import android.os.Message;

public class xhn
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "BOOLEAN";
    case 1: 
      return "TRUE";
    }
    return "FALSE";
  }
  
  public static String a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return "OTHERS[" + paramMessage.what + "] - " + paramMessage.arg1;
    case 1: 
      return "ACTION_VISIBILITY - " + paramMessage.arg1;
    case 2: 
      return "ACTION_KEEP_SHOWING - " + a(paramMessage.arg1);
    case 3: 
      return "ACTION_PLAY_ANIMATION";
    case 4: 
      return "ACTION_STOP_ANIMATION";
    case 5: 
      return "ACTION_SET_PROGRESS";
    case 7: 
      return "ACTION_UI_EVENT_CLICK - " + b(paramMessage.arg1);
    case 8: 
      return "ACTION_UI_EVENT_LONG_CLICK - " + b(paramMessage.arg1);
    case 9: 
      return "ACTION_UI_EVENT_TOUCH - " + b(paramMessage.arg1);
    case 10: 
      return "ACTION_UI_VISIBILITY_CHANGED - " + paramMessage.arg1;
    }
    return "ACTION_SET_STUBMODE";
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "BOOLEAN";
    case 0: 
      return "UNREGISTER";
    }
    return "REGISTER";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhn
 * JD-Core Version:    0.7.0.1
 */