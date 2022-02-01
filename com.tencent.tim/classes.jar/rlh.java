import android.os.Message;

public class rlh
{
  public static String a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return "OTHERS[" + paramMessage.what + "] - " + paramMessage.arg1;
    case 1: 
      return "ACTION_VISIBILITY - " + paramMessage.arg1;
    case 2: 
      return "ACTION_KEEP_SHOWING - " + cg(paramMessage.arg1);
    case 3: 
      return "ACTION_PLAY_ANIMATION";
    case 4: 
      return "ACTION_STOP_ANIMATION";
    case 5: 
      return "ACTION_SET_PROGRESS";
    case 7: 
      return "ACTION_UI_EVENT_CLICK - " + ch(paramMessage.arg1);
    case 8: 
      return "ACTION_UI_EVENT_LONG_CLICK - " + ch(paramMessage.arg1);
    case 9: 
      return "ACTION_UI_EVENT_TOUCH - " + ch(paramMessage.arg1);
    case 10: 
      return "ACTION_UI_VISIBILITY_CHANGED - " + paramMessage.arg1;
    }
    return "ACTION_SET_STUBMODE";
  }
  
  public static String cg(int paramInt)
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
  
  public static String ch(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlh
 * JD-Core Version:    0.7.0.1
 */