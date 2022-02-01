import com.tencent.qphone.base.util.QLog;

class xvl
  implements avor.a
{
  xvl(xvk paramxvk) {}
  
  public void ansyBack(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null))
    {
      QLog.i(xvk.TAG, 2, "error get pskey...");
      return;
    }
    xvk.a(this.b, paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvl
 * JD-Core Version:    0.7.0.1
 */