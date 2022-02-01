import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class aqrz
  implements Observer
{
  aqrz(aqry paramaqry) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      paramObservable = (ArrayList)paramObject;
      switch (((Integer)paramObservable.get(0)).intValue())
      {
      default: 
        return;
      }
      paramObservable = (RichStatus)paramObservable.get(1);
      aqry.a(this.this$0, paramObservable);
      if (aqry.a(this.this$0).plainText != null)
      {
        paramObject = amhd.a().k;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)aqry.a(this.this$0).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(aqry.a(this.this$0).topics);
        }
      }
      if (paramObservable != null) {
        aqry.b(this.this$0).copyFrom(paramObservable);
      }
      aqry.a(this.this$0).A().sendEmptyMessage(10003);
      amhd.a().deleteObserver(aqry.a(this.this$0));
      return;
    }
    aqry.a(this.this$0).A().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrz
 * JD-Core Version:    0.7.0.1
 */