import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.MsgTabWorkThreadHandler.1;
import java.util.ArrayList;
import java.util.Set;

public class wvy
  extends Handler
{
  public wvy(wvs paramwvs, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        removeMessages(1);
        yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader.workHandler", "handleMessage() MSG_LOAD_USER_ITEM_FROM_UI");
        paramMessage = new ArrayList(this.a.jdField_a_of_type_JavaUtilSet);
        this.a.jdField_a_of_type_JavaUtilSet.clear();
      } while (!wvs.a(this.a, paramMessage, false));
      this.a.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.MsgTabWorkThreadHandler.1(this));
      return;
      yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader.workHandler", "handleMessage() MSG_SCHEDULE_REQUIRE_USER_ITEM");
      paramMessage = (String)paramMessage.obj;
    } while (this.a.jdField_a_of_type_JavaUtilSet.contains(paramMessage));
    this.a.jdField_a_of_type_JavaUtilSet.add(paramMessage);
    sendEmptyMessageDelayed(1, 2500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvy
 * JD-Core Version:    0.7.0.1
 */