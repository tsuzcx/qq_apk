package com.tencent.moai.mailsdk.protocol.mime.model;

import android.util.Log;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.model.Address;
import com.tencent.moai.mailsdk.util.MimeUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MimeAddress
  extends Address
{
  private static final String TAG = "MimeAddress";
  
  public MimeAddress() {}
  
  public MimeAddress(String paramString1, String paramString2)
  {
    try
    {
      this.email = paramString1;
      this.nick = MimeUtility.encodeAddress(paramString2);
      return;
    }
    catch (Exception localException)
    {
      this.email = paramString1;
      this.nick = paramString2;
    }
  }
  
  private static int lengthOfFirstSegment(String paramString)
  {
    int i = paramString.indexOf("\r\n");
    if (i != -1) {
      return i;
    }
    return paramString.length();
  }
  
  private static int lengthOfLastSegment(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf("\r\n");
    if (i != -1) {
      return paramString.length() - i - 2;
    }
    return paramString.length() + paramInt;
  }
  
  private static MimeAddress[] parse(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws MessageException
  {
    if (paramString == null) {
      return null;
    }
    int i4 = -1;
    int i3 = -1;
    int i9 = paramString.length();
    int i7;
    int i;
    int i2;
    int k;
    ArrayList localArrayList;
    int i5;
    int m;
    int n;
    label55:
    int j;
    int i1;
    if ((paramBoolean2) && (!paramBoolean1))
    {
      i7 = 1;
      i = 0;
      i2 = 0;
      k = 0;
      localArrayList = new ArrayList();
      i5 = -1;
      m = 0;
      n = -1;
      if (m >= i9) {
        break label2086;
      }
      switch (paramString.charAt(m))
      {
      default: 
        if (i5 == -1)
        {
          j = m;
          i1 = m;
        }
        break;
      }
    }
    for (;;)
    {
      m = i1 + 1;
      i5 = j;
      break label55;
      i7 = 0;
      break;
      j = n;
      if (i5 >= 0)
      {
        j = n;
        if (n == -1) {
          j = m;
        }
      }
      k = m + 1;
      n = 1;
      if ((k < i9) && (n > 0))
      {
        switch (paramString.charAt(k))
        {
        }
        for (;;)
        {
          k += 1;
          break;
          k += 1;
          continue;
          n += 1;
          continue;
          n -= 1;
        }
      }
      if (n > 0)
      {
        if (i7 == 0) {
          throw new MessageException(2, 200002, paramString + " Missing ')'");
        }
        i1 = m + 1;
        k = 1;
        n = j;
        j = i5;
      }
      else
      {
        k -= 1;
        int i6 = i4;
        if (i4 == -1) {
          i6 = m + 1;
        }
        if (i3 == -1)
        {
          i1 = k;
          m = 1;
          i3 = k;
          n = j;
          k = m;
          j = i5;
          i4 = i6;
          continue;
          if (i7 == 0) {
            throw new MessageException(2, 200002, paramString + " Missing '('");
          }
          Object localObject1;
          Object localObject2;
          if (i5 == -1)
          {
            j = m;
            i1 = m;
            continue;
            if (i2 == 0) {
              break label2475;
            }
            if (i7 == 0) {
              throw new MessageException(2, 200002, paramString + " Extra route-addr");
            }
            if (i5 == -1)
            {
              i2 = 0;
              k = 0;
              j = -1;
              n = -1;
              i1 = m;
              continue;
            }
            if (i != 0) {
              break label2475;
            }
            j = n;
            if (n == -1) {
              j = m;
            }
            localObject1 = paramString.substring(i5, j).trim();
            localObject2 = new MimeAddress();
            ((MimeAddress)localObject2).setEmail((String)localObject1);
            if (i4 >= 0) {
              ((MimeAddress)localObject2).setNick(unquote(paramString.substring(i4, i3).trim()));
            }
            localArrayList.add(localObject2);
            n = -1;
            j = -1;
            k = -1;
            i1 = 0;
            i5 = 0;
            i2 = -1;
          }
          for (;;)
          {
            i6 = 0;
            i3 = m + 1;
            int i8;
            if (i3 < i9)
            {
              switch (paramString.charAt(i3))
              {
              default: 
                i8 = i3;
                i4 = i6;
              }
              do
              {
                for (;;)
                {
                  i3 = i8 + 1;
                  i6 = i4;
                  break;
                  i8 = i3 + 1;
                  i4 = i6;
                  continue;
                  if (i6 == 0)
                  {
                    i4 = 1;
                    i8 = i3;
                  }
                  else
                  {
                    i4 = 0;
                    i8 = i3;
                  }
                }
                i4 = i6;
                i8 = i3;
              } while (i6 != 0);
            }
            if (i6 != 0)
            {
              if (i7 == 0) {
                throw new MessageException(2, 200002, paramString + " Missing '\"'");
              }
              i4 = m + 1;
              i3 = i4;
              if (i4 < i9)
              {
                i6 = paramString.charAt(i4);
                if (i6 == 92) {
                  i3 = i4 + 1;
                }
                do
                {
                  i4 = i3 + 1;
                  break;
                  i3 = i4;
                } while (i6 != 62);
                i3 = i4;
              }
            }
            for (;;)
            {
              if (i3 >= i9)
              {
                if (i7 == 0) {
                  throw new MessageException(2, 200002, paramString + " Missing '>'");
                }
                i6 = m + 1;
                if (n != -1) {
                  break label2437;
                }
                n = i2;
                i4 = k;
                i3 = j;
                i2 = i1;
                j = m;
                i1 = i6;
                k = i5;
                break;
              }
              i1 = n;
              i2 = j;
              i4 = k;
              if (i == 0)
              {
                if (n < 0) {
                  break label2430;
                }
                j = m;
              }
              for (;;)
              {
                i1 = m + 1;
                i4 = n;
                i2 = j;
                j = i3;
                m = i2;
                i6 = 1;
                i2 = i1;
                n = i3;
                i1 = j;
                k = i5;
                j = i2;
                i2 = i6;
                i3 = m;
                break;
                if (i7 == 0) {
                  throw new MessageException(2, 200002, paramString + " Missing '<'");
                }
                Object localObject3;
                if (i5 == -1)
                {
                  j = m;
                  i1 = m;
                  break;
                  i8 = 1;
                  j = i5;
                  if (i5 == -1) {
                    j = m;
                  }
                  k = m + 1;
                  if (k < i9) {
                    switch (paramString.charAt(k))
                    {
                    default: 
                    case '\\': 
                      for (;;)
                      {
                        k += 1;
                        break;
                        k += 1;
                      }
                    }
                  }
                  i1 = k;
                  i6 = j;
                  if (k < i9) {
                    break label2420;
                  }
                  if (i7 == 0) {
                    throw new MessageException(2, 200002, paramString + " Missing '\"'");
                  }
                  i1 = m + 1;
                  k = i8;
                  break;
                  k = 1;
                  j = m + 1;
                  if (j < i9) {
                    switch (paramString.charAt(j))
                    {
                    default: 
                    case '\\': 
                      for (;;)
                      {
                        j += 1;
                        break;
                        j += 1;
                      }
                    }
                  }
                  i1 = j;
                  i6 = i5;
                  if (j < i9) {
                    break label2420;
                  }
                  if (i7 == 0) {
                    throw new MessageException(2, 200002, paramString + " Missing ']'");
                  }
                  i1 = m + 1;
                  j = i5;
                  break;
                  if (i5 == -1)
                  {
                    i2 = 0;
                    k = 0;
                    j = -1;
                    n = -1;
                    i1 = m;
                    break;
                  }
                  if (i != 0)
                  {
                    i6 = 0;
                    if ((paramBoolean2) && (!paramBoolean1) && (m + 1 < i9))
                    {
                      i1 = m;
                      i = i6;
                      j = i5;
                      if (paramString.charAt(m + 1) == '@') {
                        break;
                      }
                    }
                    localObject1 = new MimeAddress();
                    ((MimeAddress)localObject1).setEmail(paramString.substring(i5, m + 1).trim());
                    localArrayList.add(localObject1);
                    i2 = 0;
                    k = 0;
                    j = -1;
                    i3 = -1;
                    n = -1;
                    i4 = -1;
                    i1 = m;
                    i = i6;
                    break;
                  }
                  if (i7 == 0) {
                    throw new MessageException(2, 200002, paramString + " Illegal semicolon, not in group");
                  }
                  if (i5 == -1)
                  {
                    i2 = 0;
                    k = 0;
                    j = -1;
                    n = -1;
                    i1 = m;
                    break;
                  }
                  if (i != 0)
                  {
                    i2 = 0;
                    i1 = m;
                    j = i5;
                    break;
                  }
                  j = n;
                  if (n == -1) {
                    j = m;
                  }
                  localObject2 = paramString.substring(i5, j).trim();
                  localObject3 = null;
                  localObject1 = localObject3;
                  if (k != 0)
                  {
                    localObject1 = localObject3;
                    if (i4 >= 0)
                    {
                      localObject3 = unquote(paramString.substring(i4, i3).trim());
                      localObject1 = localObject3;
                      if (((String)localObject3).trim().length() == 0) {
                        localObject1 = null;
                      }
                    }
                  }
                  if ((!paramBoolean2) || (paramBoolean1) || (localObject1 == null) || (((String)localObject1).indexOf('@') < 0) || (((String)localObject2).indexOf('@') >= 0) || (((String)localObject2).indexOf('!') >= 0)) {
                    break label2405;
                  }
                }
                for (;;)
                {
                  if ((k != 0) || (paramBoolean1) || (paramBoolean2))
                  {
                    localObject3 = new MimeAddress();
                    ((MimeAddress)localObject3).setEmail((String)localObject1);
                    if (localObject2 != null) {
                      ((MimeAddress)localObject3).setNick((String)localObject2);
                    }
                    localArrayList.add(localObject3);
                  }
                  for (;;)
                  {
                    i2 = 0;
                    k = 0;
                    j = -1;
                    i3 = -1;
                    n = -1;
                    i4 = -1;
                    i1 = m;
                    break;
                    localObject1 = new StringTokenizer((String)localObject1);
                    while (((StringTokenizer)localObject1).hasMoreTokens())
                    {
                      localObject2 = ((StringTokenizer)localObject1).nextToken();
                      localObject3 = new MimeAddress();
                      ((MimeAddress)localObject3).setEmail((String)localObject2);
                      localArrayList.add(localObject3);
                    }
                  }
                  i6 = 1;
                  if ((i != 0) && (i7 == 0)) {
                    throw new MessageException(2, 200002, paramString + " Nested group");
                  }
                  j = i5;
                  if (i5 == -1) {
                    j = m;
                  }
                  if ((paramBoolean2) && (!paramBoolean1))
                  {
                    if (m + 1 < i9)
                    {
                      k = paramString.charAt(m + 1);
                      if (")>[]:@\\,.".indexOf(k) >= 0)
                      {
                        if (k != 64)
                        {
                          i1 = m;
                          k = i6;
                          break;
                        }
                        i1 = m + 2;
                        for (;;)
                        {
                          i5 = k;
                          if (i1 < i9)
                          {
                            k = paramString.charAt(i1);
                            if (k != 59) {
                              break label2026;
                            }
                            i5 = k;
                          }
                          label2026:
                          do
                          {
                            if (i5 != 59) {
                              break label2049;
                            }
                            i1 = m;
                            k = i6;
                            break;
                            i5 = k;
                          } while (")>[]:@\\,.".indexOf(k) >= 0);
                          i1 += 1;
                        }
                      }
                    }
                    label2049:
                    i = 1;
                    i1 = m;
                    k = i6;
                    break;
                  }
                  i = 1;
                  i1 = m;
                  k = i6;
                  break;
                  i1 = m;
                  j = i5;
                  break;
                  label2086:
                  if (i5 >= 0)
                  {
                    i = n;
                    if (n == -1) {
                      i = i9;
                    }
                    localObject2 = paramString.substring(i5, i).trim();
                    localObject3 = null;
                    localObject1 = localObject3;
                    if (k != 0)
                    {
                      localObject1 = localObject3;
                      if (i4 >= 0)
                      {
                        paramString = unquote(paramString.substring(i4, i3).trim());
                        localObject1 = paramString;
                        if (paramString.trim().length() == 0) {
                          localObject1 = null;
                        }
                      }
                    }
                    if ((!paramBoolean2) || (paramBoolean1) || (localObject1 == null) || (((String)localObject1).indexOf('@') < 0) || (((String)localObject2).indexOf('@') >= 0) || (((String)localObject2).indexOf('!') >= 0)) {
                      break label2384;
                    }
                    paramString = (String)localObject2;
                  }
                  for (;;)
                  {
                    if ((paramBoolean2) && (!paramBoolean1) && (paramString == null) && (((String)localObject1).indexOf('@') < 0) && (((String)localObject1).indexOf('!') < 0)) {}
                    for (paramString = "";; paramString = (String)localObject2)
                    {
                      if ((k != 0) || (paramBoolean1) || (paramBoolean2))
                      {
                        localObject2 = new MimeAddress();
                        ((MimeAddress)localObject2).setEmail(paramString);
                        if (localObject1 != null) {
                          ((MimeAddress)localObject2).setNick((String)localObject1);
                        }
                        localArrayList.add(localObject2);
                      }
                      for (;;)
                      {
                        paramString = new MimeAddress[localArrayList.size()];
                        localArrayList.toArray(paramString);
                        return paramString;
                        paramString = new StringTokenizer(paramString);
                        while (paramString.hasMoreTokens())
                        {
                          localObject1 = paramString.nextToken();
                          localObject2 = new MimeAddress();
                          ((MimeAddress)localObject2).setEmail((String)localObject1);
                          localArrayList.add(localObject2);
                        }
                      }
                      localObject2 = localObject1;
                      localObject1 = paramString;
                    }
                    label2384:
                    paramString = (String)localObject1;
                    localObject1 = localObject2;
                  }
                  i1 = m;
                  j = i5;
                  break;
                  label2405:
                  localObject3 = localObject2;
                  localObject2 = localObject1;
                  localObject1 = localObject3;
                }
                label2420:
                k = 1;
                j = i6;
                break;
                label2430:
                n = k;
              }
              label2437:
              i4 = k;
              i3 = j;
              m = i1;
              j = n;
              n = i2;
              i1 = i6;
              k = i5;
              i2 = m;
              break;
            }
            label2475:
            i6 = 1;
            j = n;
            n = i5;
            i1 = i2;
            k = i4;
            i2 = j;
            i5 = i6;
            j = i3;
          }
        }
        else
        {
          m = 1;
          n = j;
          i1 = k;
          k = m;
          j = i5;
          i4 = i6;
        }
      }
    }
  }
  
  public static MimeAddress parseAddress(String paramString)
  {
    try
    {
      paramString = parse(paramString, false, true);
      if ((paramString != null) && (paramString.length > 0))
      {
        MimeAddress localMimeAddress = new MimeAddress();
        localMimeAddress.setEmail(paramString[0].getEmail());
        localMimeAddress.setNick(MimeUtility.decodeText(paramString[0].getNick()));
        return localMimeAddress;
      }
    }
    catch (Exception paramString)
    {
      Logger.log(6, "MimeAddress", Log.getStackTraceString(paramString));
    }
    return null;
  }
  
  public static String parseAddressToString(Address[] paramArrayOfAddress, int paramInt)
  {
    if ((paramArrayOfAddress == null) || (paramArrayOfAddress.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < paramArrayOfAddress.length)
    {
      int i = paramInt;
      if (j != 0)
      {
        localStringBuilder.append(", ");
        i = paramInt + 2;
      }
      String str = MimeUtility.fold(0, paramArrayOfAddress[j].toString());
      paramInt = i;
      if (lengthOfFirstSegment(str) + i > 76)
      {
        paramInt = localStringBuilder.length();
        if ((paramInt > 0) && (localStringBuilder.charAt(paramInt - 1) == ' ')) {
          localStringBuilder.setLength(paramInt - 1);
        }
        localStringBuilder.append("\r\n\t");
        paramInt = 8;
      }
      localStringBuilder.append(str);
      paramInt = lengthOfLastSegment(str, paramInt);
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static MimeAddress[] parseAddresses(String paramString)
  {
    int i = 0;
    try
    {
      MimeAddress[] arrayOfMimeAddress2 = parse(paramString, false, true);
      if ((arrayOfMimeAddress2 != null) && (arrayOfMimeAddress2.length > 0))
      {
        MimeAddress[] arrayOfMimeAddress1 = new MimeAddress[arrayOfMimeAddress2.length];
        for (;;)
        {
          paramString = arrayOfMimeAddress1;
          if (i >= arrayOfMimeAddress2.length) {
            break;
          }
          paramString = new MimeAddress();
          paramString.setEmail(arrayOfMimeAddress2[i].getEmail());
          paramString.setNick(MimeUtility.decodeText(arrayOfMimeAddress2[i].getNick()));
          arrayOfMimeAddress1[i] = paramString;
          i += 1;
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      Logger.log(6, "MimeAddress", Log.getStackTraceString(paramString));
      paramString = null;
    }
  }
  
  private static String unquote(String paramString)
  {
    Object localObject = paramString;
    int i;
    char c;
    if (paramString.startsWith("\""))
    {
      localObject = paramString;
      if (paramString.endsWith("\""))
      {
        localObject = paramString;
        if (paramString.length() > 1)
        {
          paramString = paramString.substring(1, paramString.length() - 1);
          localObject = paramString;
          if (paramString.indexOf('\\') >= 0)
          {
            localObject = new StringBuffer(paramString.length());
            i = 0;
            if (i < paramString.length())
            {
              c = paramString.charAt(i);
              if ((c != '\\') || (i >= paramString.length() - 1)) {
                break label129;
              }
              i += 1;
              c = paramString.charAt(i);
            }
          }
        }
      }
    }
    label129:
    for (;;)
    {
      ((StringBuffer)localObject).append(c);
      i += 1;
      break;
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!StringUtility.isNullOrEmpty(this.nick))
    {
      localStringBuilder.append(this.nick);
      localStringBuilder.append("<");
      localStringBuilder.append(this.email);
      localStringBuilder.append(">");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.email);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.model.MimeAddress
 * JD-Core Version:    0.7.0.1
 */