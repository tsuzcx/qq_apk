import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class sbo
  implements shg.a
{
  sbo(sbn paramsbn) {}
  
  public void b(int paramInt, boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof ArrayList))) {
        this.a.setDatas((ArrayList)paramVarArgs[0]);
      }
      return;
    }
    QLog.d(sbn.TAG, 4, "get drafts failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbo
 * JD-Core Version:    0.7.0.1
 */