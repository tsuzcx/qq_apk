import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class wmy
{
  private static ArraySet<Long> c = new ArraySet();
  
  public static void I(MessageRecord paramMessageRecord)
  {
    c.add(Long.valueOf(paramMessageRecord.uniseq));
  }
  
  public static void c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (!c.contains(Long.valueOf(paramMessageRecord.uniseq)))
    {
      c.add(Long.valueOf(paramMessageRecord.uniseq));
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A52B", "0X800A52B", 0, 0, "", "", "", "");
    }
  }
  
  public static void clear()
  {
    c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmy
 * JD-Core Version:    0.7.0.1
 */