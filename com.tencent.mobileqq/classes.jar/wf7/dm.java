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
    if (paramInt == 0) {}
    while (aa(paramInt) != 0) {
      return paramInt;
    }
    int i;
    switch (ac(paramInt))
    {
    default: 
      i = paramInt;
    }
    while (i != paramInt)
    {
      return i;
      i = paramInt - 2;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 3;
      continue;
      i = paramInt - 15;
      continue;
      i = paramInt - 16;
      continue;
      i = paramInt - 16;
      continue;
      i = paramInt - 6;
      continue;
      i = paramInt - 4;
      continue;
      i = paramInt - 4;
      continue;
      i = paramInt - 7;
      continue;
      i = paramInt - 5;
      continue;
      i = paramInt - 5;
    }
    switch (ab(paramInt))
    {
    default: 
      return i;
    case -300: 
      return paramInt - 5;
    case -400: 
      return paramInt - 5;
    case -800: 
      return paramInt - 3;
    case -900: 
      return paramInt - 5;
    case -1000: 
      return paramInt - 13;
    case -1100: 
      return paramInt - 13;
    case -1200: 
      return paramInt - 14;
    case -1300: 
      return paramInt - 9;
    case -1400: 
      return paramInt - 3;
    }
    return paramInt - 5;
  }
  
  public static final int g(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return paramInt;
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
    } while (!paramString.contains("connect failed: errno "));
    return -490000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.dm
 * JD-Core Version:    0.7.0.1
 */