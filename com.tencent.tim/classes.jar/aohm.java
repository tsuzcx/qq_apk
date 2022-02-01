import com.tencent.mobileqq.app.QQAppInterface;

public class aohm
{
  public static final int[] ou = { 1, 2, 3 };
  
  public static void I(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    anot.a(paramQQAppInterface, "dc00898", "", paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, paramInt, 0, "0", "0", "", "");
  }
  
  public static final String fA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "BUSID_INTIMATE_ANNIVERSARY";
    case 1: 
      return "BUSID_BASE_PROFILE";
    }
    return "BUSID_NICE_PICS";
  }
  
  public static final int jx(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < ou.length)) {
      return ou[paramInt];
    }
    return -1;
  }
  
  public static final int jy(int paramInt)
  {
    int i = 0;
    while (i < ou.length)
    {
      if (ou[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohm
 * JD-Core Version:    0.7.0.1
 */