package btmsdkobf;

public class bz
{
  public static final int a(String paramString, int paramInt)
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
      if (paramString.contains("setsockopt failed: ENOPROTOOPT (tmsdk.Protocol not available)")) {
        return -400000;
      }
      if (paramString.contains("tmsdk.Protocol not available")) {
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
  
  public static final int m(int paramInt)
  {
    return paramInt % 100;
  }
  
  public static final int n(int paramInt)
  {
    return paramInt % 10000 - m(paramInt);
  }
  
  public static final int o(int paramInt)
  {
    return paramInt % 1000000 - n(paramInt) - m(paramInt);
  }
  
  public static int p(int paramInt)
  {
    if (paramInt == 0) {
      return paramInt;
    }
    int j;
    if (m(paramInt) != 0) {
      j = paramInt;
    }
    for (;;)
    {
      eh.f("ESharkCode", "appendNormalCode: " + paramInt + " -> " + j);
      return j;
      int i;
      switch (o(paramInt))
      {
      default: 
        i = paramInt;
      }
      for (;;)
      {
        j = i;
        if (i != paramInt) {
          break;
        }
        switch (n(paramInt))
        {
        default: 
          j = i;
          break;
        case -1500: 
          j = paramInt - 5;
          break;
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
      }
      j = paramInt - 5;
      continue;
      j = paramInt - 5;
      continue;
      j = paramInt - 3;
      continue;
      j = paramInt - 5;
      continue;
      j = paramInt - 13;
      continue;
      j = paramInt - 13;
      continue;
      j = paramInt - 14;
      continue;
      j = paramInt - 9;
      continue;
      j = paramInt - 3;
    }
  }
  
  public static boolean q(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      int i;
      do
      {
        return false;
        i = m(paramInt);
      } while ((i == -17) || (i == -18) || (i == -7) || (i == -19) || (i == -2));
      paramInt = o(paramInt);
    } while ((paramInt == -220000) || (paramInt == -230000) || (paramInt == -160000) || (paramInt == -540000));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bz
 * JD-Core Version:    0.7.0.1
 */