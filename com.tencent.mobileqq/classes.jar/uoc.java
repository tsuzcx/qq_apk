import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import java.util.List;

public class uoc
  extends Handler
{
  public uoc(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (List)paramMessage.obj;
    ReadInJoyNewSearchActivity.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoc
 * JD-Core Version:    0.7.0.1
 */