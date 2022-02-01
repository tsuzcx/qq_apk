import com.tencent.qphone.base.util.QLog;

public class qwp
{
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString, 2, qwr.b(paramVarArgs));
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    ram.e(paramString, qwr.b(paramVarArgs));
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    ram.w(paramString, qwr.b(paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwp
 * JD-Core Version:    0.7.0.1
 */