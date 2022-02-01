public class augb
  implements acci
{
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3) {}
  
  protected void bu(String paramString1, String paramString2, String paramString3) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramObject = (Object[])paramObject;
      String str1 = (String)paramObject[0];
      String str2 = (String)paramObject[3];
      a(paramBoolean, str1, ((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), str2, ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
      return;
    }
    paramObject = (Object[])paramObject;
    bu((String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augb
 * JD-Core Version:    0.7.0.1
 */