import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity.SpecialSoundAdapter;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;

public class exi
  extends QvipSpecialCareObserver
{
  public exi(QvipSpecialSoundActivity paramQvipSpecialSoundActivity) {}
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      QvipSpecialSoundActivity.d(this.a);
      if (QvipSpecialSoundActivity.a(this.a) != null) {
        QvipSpecialSoundActivity.a(this.a).removeMessages(2);
      }
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    do
    {
      do
      {
        return;
      } while (QvipSpecialSoundActivity.a(this.a) == null);
      QvipSpecialSoundActivity.b(this.a);
      QvipSpecialSoundActivity.a(this.a).notifyDataSetChanged();
      return;
      QvipSpecialSoundActivity.c(this.a);
    } while (QvipSpecialSoundActivity.a(this.a) == null);
    QvipSpecialSoundActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void b(Object paramObject)
  {
    if (paramObject != null)
    {
      QvipSpecialSoundActivity.e(this.a);
      if (QvipSpecialSoundActivity.a(this.a) != null) {
        QvipSpecialSoundActivity.a(this.a).removeMessages(2);
      }
      if (((Integer)paramObject).intValue() == 10010)
      {
        QvipSpecialSoundActivity.a(this.a, this.a.getString(2131562091));
        QvipSpecialSoundActivity.a(this.a).a(null, 1, null);
      }
    }
    else
    {
      return;
    }
    QvipSpecialSoundActivity.a(this.a, this.a.getString(2131562882));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exi
 * JD-Core Version:    0.7.0.1
 */