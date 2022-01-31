import com.tencent.biz.videostory.capture.AEBottomListAdapter.4.1;
import com.tencent.biz.videostory.capture.AEBottomListAdapter.4.2;
import com.tencent.biz.videostory.capture.AEBottomListAdapter.4.3;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class wqn
  implements bgxw
{
  wqn(wql paramwql) {}
  
  public void a(bgya parambgya, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.3(this, parambgya, paramInt));
  }
  
  public void a(bgya parambgya, boolean paramBoolean)
  {
    if ((!paramBoolean) || (wql.a(this.a) == null))
    {
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.1(this, parambgya));
      if (!paramBoolean) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = 1)
    {
      wye.a("record_decoration_download", wye.a(i, System.currentTimeMillis() - parambgya.jdField_a_of_type_Long, parambgya.c, parambgya.b, parambgya.jdField_a_of_type_JavaLangString));
      return;
      if (this.a.a(wql.a(this.a).a()) == wql.a(this.a)) {
        wql.a(this.a, wql.a(this.a));
      }
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.2(this, parambgya));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqn
 * JD-Core Version:    0.7.0.1
 */