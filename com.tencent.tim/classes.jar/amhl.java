import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class amhl
  extends accz
{
  amhl(amhj paramamhj) {}
  
  protected void aV(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    amhj.a(this.e, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        amhj.b(this.e, System.currentTimeMillis());
        amhj.a(this.e).edit().putLong("k_update_time", amhj.a(this.e)).commit();
      }
      this.e.Ph(true);
    }
    if (amhj.a(this.e) != null)
    {
      Iterator localIterator = amhj.a(this.e).iterator();
      if (localIterator.hasNext())
      {
        amff localamff = (amff)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localamff.fk(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhl
 * JD-Core Version:    0.7.0.1
 */