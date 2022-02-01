import com.tencent.mobileqq.app.QQAppInterface;

public class appa
  implements acci
{
  protected QQAppInterface mApp;
  
  public appa(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  protected void a(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt) {}
  
  protected void ab(long paramLong, boolean paramBoolean) {}
  
  protected void ac(long paramLong, boolean paramBoolean) {}
  
  protected void ad(long paramLong, boolean paramBoolean) {}
  
  protected void fZ(long paramLong) {}
  
  protected void i(long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      ac(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
      return;
    case 1: 
      ab(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), paramBoolean, ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      i(((Long)paramObject[0]).longValue(), paramBoolean, ((Integer)paramObject[1]).intValue());
      return;
    case 5: 
      ad(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
      return;
    }
    fZ(((Long)((Object[])(Object[])paramObject)[0]).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appa
 * JD-Core Version:    0.7.0.1
 */