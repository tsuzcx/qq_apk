package com.tencent.qqmail.account.log;

public class AddAccountFailLogUtil
{
  public static final int ADD_ACCOUNT_ERR_SOURCE_3G = 3;
  public static final int ADD_ACCOUNT_ERR_SOURCE_OUTER = 1;
  public static final int ADD_ACCOUNT_ERR_SOURCE_WTLOGIN = 2;
  private static int inner_length = 5;
  private static int tail_length = 3;
  
  private static boolean checkSourceValid(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 1) || (paramInt == 2);
  }
  
  public static String genAddAccountErrorCode(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = Math.abs(paramInt3);
    paramInt4 = Math.abs(paramInt4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    if (paramInt1 == 3)
    {
      localStringBuilder.append("2");
      if (paramInt1 != 3) {
        break label119;
      }
      localStringBuilder.append(genErrCodeInner5Chars(paramInt3));
      label56:
      if (paramInt1 != 3) {
        break label156;
      }
      localStringBuilder.append(genErrCodeTail3Chars(paramInt4));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt1 == 2)
      {
        if (paramBoolean)
        {
          localStringBuilder.append("2");
          break;
        }
        localStringBuilder.append("1");
        break;
      }
      localStringBuilder.append(paramInt2);
      break;
      label119:
      if (paramInt1 == 2)
      {
        localStringBuilder.append(genErrCodeInner5Chars(paramInt3));
        break label56;
      }
      if (paramInt1 != 1) {
        break label56;
      }
      localStringBuilder.append(genErrCodeInner5Chars(paramInt4));
      break label56;
      label156:
      if (paramInt1 == 2)
      {
        if (paramBoolean) {
          localStringBuilder.append(genErrCodeTail3Chars(paramInt4));
        } else {
          localStringBuilder.append("000");
        }
      }
      else {
        localStringBuilder.append("000");
      }
    }
  }
  
  private static String genErrCodeInner5Chars(int paramInt)
  {
    String str = String.valueOf(paramInt);
    if (str.length() <= inner_length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = str.length();
      while (i < inner_length)
      {
        localStringBuilder.append("0");
        i += 1;
      }
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    return "00000";
  }
  
  private static String genErrCodeTail3Chars(int paramInt)
  {
    String str = String.valueOf(paramInt);
    if (str.length() <= tail_length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = str.length();
      while (i < tail_length)
      {
        localStringBuilder.append("0");
        i += 1;
      }
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    return "000";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.log.AddAccountFailLogUtil
 * JD-Core Version:    0.7.0.1
 */