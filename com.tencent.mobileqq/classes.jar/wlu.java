import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class wlu
  implements wtd
{
  wlu(wlt paramwlt) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof ArrayList))) {
        this.a.a((ArrayList)paramVarArgs[0]);
      }
      return;
    }
    QLog.d(wlt.a, 4, "get drafts failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlu
 * JD-Core Version:    0.7.0.1
 */