import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ajlo
{
  public static HashMap<Integer, String> lI = new HashMap();
  
  static
  {
    lI.put(Integer.valueOf(10001), BaseApplication.getContext().getString(2131718932));
    lI.put(Integer.valueOf(10002), BaseApplication.getContext().getString(2131718930));
    lI.put(Integer.valueOf(10003), BaseApplication.getContext().getString(2131720422));
    lI.put(Integer.valueOf(10004), BaseApplication.getContext().getString(2131692327));
    lI.put(Integer.valueOf(10005), BaseApplication.getContext().getString(2131718927));
    lI.put(Integer.valueOf(10006), BaseApplication.getContext().getString(2131718950));
    lI.put(Integer.valueOf(10007), BaseApplication.getContext().getString(2131718931));
  }
  
  public static String getErrorMsg(int paramInt)
  {
    return (String)lI.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlo
 * JD-Core Version:    0.7.0.1
 */