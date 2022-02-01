import com.tencent.mobileqq.data.QCallRecord;
import java.util.Comparator;

class alkr
  implements Comparator<QCallRecord>
{
  alkr(alkq paramalkq) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    if (paramQCallRecord1.type == QCallRecord.TYPE_DATE) {
      return 0;
    }
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkr
 * JD-Core Version:    0.7.0.1
 */