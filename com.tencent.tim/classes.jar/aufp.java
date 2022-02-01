import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.widget.SendBottomBar;
import com.tencent.tim.filemanager.widget.SendBottomBar.6;
import java.util.ArrayList;

public class aufp
  extends AsyncTask<Void, Void, Void>
{
  public aufp(SendBottomBar.6 param6) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = SendBottomBar.a(this.a.this$0).uV();
    int i = SendBottomBar.a(this.a.this$0).DW();
    if (i == 5) {}
    for (;;)
    {
      return null;
      if (paramVarArgs.equals(acbn.bkw))
      {
        paramVarArgs = atwb.ep();
        ((acde)SendBottomBar.a(this.a.this$0).getBusinessHandler(8)).dA(paramVarArgs);
      }
      while (SendBottomBar.a(this.a.this$0) != null)
      {
        SendBottomBar.a(this.a.this$0).a().eux();
        return null;
        Object localObject;
        if (i == 6002)
        {
          localObject = atwb.ep();
          ((RouterHandler)SendBottomBar.a(this.a.this$0).getBusinessHandler(48)).a((ArrayList)localObject, null, null, Long.parseLong(paramVarArgs));
        }
        else if (i == 9501)
        {
          ((szy)SendBottomBar.a(this.a.this$0).getBusinessHandler(49)).a().b(paramVarArgs, atwb.ep());
        }
        else
        {
          localObject = SendBottomBar.a(this.a.this$0).uW();
          SendBottomBar.a(this.a.this$0).a().ae((String)localObject, paramVarArgs, i);
        }
      }
    }
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.this$0.btB();
    atwb.clearSelected();
    SendBottomBar.d(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufp
 * JD-Core Version:    0.7.0.1
 */