import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class awfp
  extends Handler
{
  awfp(awfn paramawfn) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String[])));
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = (String[])paramMessage.obj;
    localArrayList.add(awfn.a(this.this$0, arrayOfString));
    this.this$0.ai(localArrayList, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfp
 * JD-Core Version:    0.7.0.1
 */