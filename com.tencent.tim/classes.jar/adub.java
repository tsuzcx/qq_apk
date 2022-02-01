import com.tencent.qphone.base.util.QLog;

public class adub
  implements acci
{
  public void d(boolean paramBoolean, int paramInt, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapObserver", 2, new Object[] { "onUpdate, type=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!(paramObject instanceof Object[]));
    paramObject = (Object[])paramObject;
    d(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adub
 * JD-Core Version:    0.7.0.1
 */