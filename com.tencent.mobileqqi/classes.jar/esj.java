import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.SpecialCareTipsController;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class esj
  extends QvipSpecialCareObserver
{
  public esj(QvipSpecialCareActivity paramQvipSpecialCareActivity) {}
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      QvipSpecialCareActivity.f(this.a);
      if (QvipSpecialCareActivity.a(this.a) != null) {
        QvipSpecialCareActivity.a(this.a).removeMessages(0);
      }
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    do
    {
      return;
      QvipSpecialCareActivity.a(this.a).setVisibility(8);
      if (!QvipSpecialCareActivity.g(this.a)) {
        QvipSpecialCareActivity.d(this.a);
      }
      QvipSpecialCareActivity.a(this.a);
      return;
      QvipSpecialCareActivity.a(this.a);
      return;
      QvipSpecialCareActivity.a(this.a).setVisibility(8);
    } while (QvipSpecialCareActivity.a(this.a) == null);
    QvipSpecialCareActivity.a(this.a).a();
  }
  
  public void b(Object paramObject)
  {
    if (paramObject != null)
    {
      QvipSpecialCareActivity.h(this.a);
      if (QvipSpecialCareActivity.a(this.a) != null) {
        QvipSpecialCareActivity.a(this.a).removeMessages(0);
      }
      if (((Integer)paramObject).intValue() != 10010) {
        break label83;
      }
      QvipSpecialCareActivity.a(this.a, this.a.getString(2131562091));
      QvipSpecialCareActivity.a(this.a).a(null, 1, null);
    }
    for (;;)
    {
      QvipSpecialCareActivity.a(this.a);
      return;
      label83:
      QvipSpecialCareActivity.a(this.a, this.a.getString(2131562882));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esj
 * JD-Core Version:    0.7.0.1
 */