import com.tencent.mobileqq.data.MessageRecord;

public class acsq
{
  public static boolean ad(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.msgtype;
    return (i == -2011) || (i == -2060) || (i == -2065) || (i == -5008) || (i == -5010) || (i == -2050) || (i == -1051) || (i == -2021) || (i == -2018) || (i == -4502);
  }
  
  public static boolean iH(int paramInt)
  {
    return (paramInt == -2000) || (paramInt == -20000) || (paramInt == -3004) || (paramInt == -3005) || (paramInt == -3000) || (paramInt == -3001) || (paramInt == -1032);
  }
  
  public static boolean iI(int paramInt)
  {
    return paramInt == -2022;
  }
  
  public static boolean iJ(int paramInt)
  {
    return (paramInt == -2005) || (paramInt == -2014) || (paramInt == -2017);
  }
  
  public static boolean iK(int paramInt)
  {
    return paramInt == -1035;
  }
  
  public static boolean iL(int paramInt)
  {
    return paramInt == -2011;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsq
 * JD-Core Version:    0.7.0.1
 */