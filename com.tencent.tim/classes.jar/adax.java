import com.tencent.qphone.base.util.QLog;

public abstract class adax
  implements acci
{
  public abstract void a(adhf paramadhf);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARLBSObserver", 2, "type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    try
    {
      a((adhf)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new adhf());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adax
 * JD-Core Version:    0.7.0.1
 */