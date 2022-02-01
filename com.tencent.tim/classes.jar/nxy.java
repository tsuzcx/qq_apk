import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import java.util.List;

public class nxy
  extends Handler
{
  public nxy(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (List)paramMessage.obj;
    ReadInJoyNewSearchActivity.a(this.this$0, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxy
 * JD-Core Version:    0.7.0.1
 */