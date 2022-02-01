import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Date;

class ahxa
{
  static ahxa k = new ahxa(false, new Date(0L), new Date(0L));
  final boolean ciO;
  final Date g;
  final Date h;
  
  ahxa(boolean paramBoolean, @NonNull Date paramDate1, @NonNull Date paramDate2)
  {
    this.ciO = paramBoolean;
    this.g = paramDate1;
    this.h = paramDate2;
  }
  
  private boolean aoq()
  {
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    return (this.g.getTime() <= l) && (this.h.getTime() >= l);
  }
  
  boolean aop()
  {
    return (aoq()) && (this.ciO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxa
 * JD-Core Version:    0.7.0.1
 */