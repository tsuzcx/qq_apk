package wf7;

public class dm
{
  public static final int aa(int paramInt)
  {
    return paramInt % 100;
  }
  
  public static final int ab(int paramInt)
  {
    return paramInt % 10000 - aa(paramInt);
  }
  
  public static final int ac(int paramInt)
  {
    return paramInt % 1000000 - ab(paramInt) - aa(paramInt);
  }
  
  public static int ad(int paramInt)
  {
    if (paramInt == 0) {
      return paramInt;
    }
    if (aa(paramInt) != 0) {
      return paramInt;
    }
    int i;
    switch (ac(paramInt))
    {
    default: 
      i = paramInt;
      break;
    case -130000: 
    case -50000: 
      i = paramInt - 4;
      break;
    case -160000: 
      i = paramInt - 6;
      break;
    case -170000: 
      i = paramInt - 15;
      break;
    case -220000: 
      i = paramInt - 2;
      break;
    case -230000: 
      i = paramInt - 7;
      break;
    case -280000: 
    case -250000: 
      i = paramInt - 5;
      break;
    case -300000: 
    case -290000: 
      i = paramInt - 16;
      break;
    case -500000: 
    case -490000: 
    case -480000: 
    case -470000: 
    case -460000: 
    case -450000: 
    case -440000: 
    case -430000: 
    case -420000: 
    case -410000: 
    case -400000: 
    case -390000: 
    case -380000: 
    case -370000: 
    case -360000: 
    case -350000: 
    case -340000: 
    case -330000: 
    case -320000: 
    case -310000: 
    case -210000: 
    case -190000: 
    case -180000: 
    case -150000: 
    case -140000: 
    case -120000: 
    case -110000: 
    case -100000: 
    case -90000: 
    case -80000: 
    case -70000: 
    case -60000: 
    case -40000: 
    case -10000: 
      i = paramInt - 3;
    }
    if (i == paramInt)
    {
      int j = ab(paramInt);
      if (j == -1500) {
        break label546;
      }
      if (j == -1400) {
        break label542;
      }
      if (j == -1300) {
        break label537;
      }
      if (j == -1200) {
        break label532;
      }
      if ((j != -1100) && (j != -1000))
      {
        if (j == -900) {
          break label546;
        }
        if (j == -800) {
          break label542;
        }
        if ((j == -400) || (j == -300)) {
          break label546;
        }
      }
    }
    else
    {
      return i;
    }
    return paramInt - 13;
    label532:
    return paramInt - 14;
    label537:
    return paramInt - 9;
    label542:
    return paramInt - 3;
    label546:
    return paramInt - 5;
  }
  
  public static final int g(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    if (paramString.contains("socket failed: EACCES (Permission denied)")) {
      return -350000;
    }
    if (paramString.contains("Permission denied")) {
      return -360000;
    }
    if (paramString.contains("isConnected failed: EHOSTUNREACH (No route to host)")) {
      return -370000;
    }
    if (paramString.contains("No route to host")) {
      return -380000;
    }
    if (paramString.contains("socket failed: ECONNRESET (Connection reset by peer)")) {
      return -390000;
    }
    if (paramString.contains("setsockopt failed: ENOPROTOOPT (Protocol not available)")) {
      return -400000;
    }
    if (paramString.contains("Protocol not available")) {
      return -410000;
    }
    if (paramString.contains("Permission denied (missing INTERNET permission?)")) {
      return -430000;
    }
    if (paramString.contains("failed: ENETUNREACH (Network is unreachable)")) {
      return -450000;
    }
    if (paramString.contains("failed: ENOTSOCK (Socket operation on non-socket)")) {
      return -460000;
    }
    if (paramString.contains("isConnected failed: ECONNREFUSED (Connection refused)")) {
      return -470000;
    }
    if (paramString.contains("isConnected failed: ECONNRESET (Connection reset by peer)")) {
      return -480000;
    }
    if (paramString.contains("connect failed: errno ")) {
      return -490000;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.dm
 * JD-Core Version:    0.7.0.1
 */