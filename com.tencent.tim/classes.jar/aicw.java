import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;

class aicw
  implements Callable<aibz>
{
  aicw(aicu paramaicu) {}
  
  public aibz a()
    throws Exception
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    return aicg.b(aicu.a(this.this$0).getApplication(), "GVideo", localQQAppInterface.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicw
 * JD-Core Version:    0.7.0.1
 */