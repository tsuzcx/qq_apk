package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class InetAddresses
{
  private static final Inet4Address ANY4 = (Inet4Address)forString("0.0.0.0");
  private static final int IPV4_PART_COUNT = 4;
  private static final Splitter IPV4_SPLITTER = Splitter.on('.').limit(4);
  private static final int IPV6_PART_COUNT = 8;
  private static final Inet4Address LOOPBACK4 = (Inet4Address)forString("127.0.0.1");
  
  private static InetAddress bytesToInetAddress(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = InetAddress.getByAddress(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (UnknownHostException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static int coerceToInteger(InetAddress paramInetAddress)
  {
    return ByteStreams.newDataInput(getCoercedIPv4Address(paramInetAddress).getAddress()).readInt();
  }
  
  private static void compressLongestRunOfZeroes(int[] paramArrayOfInt)
  {
    int i = 0;
    int m = -1;
    int j = -1;
    int k = -1;
    int n;
    int i1;
    int i2;
    if (i < paramArrayOfInt.length + 1)
    {
      if ((i < paramArrayOfInt.length) && (paramArrayOfInt[i] == 0))
      {
        n = m;
        i1 = j;
        i2 = k;
        if (m < 0)
        {
          n = i;
          i2 = k;
          i1 = j;
        }
      }
      do
      {
        i += 1;
        m = n;
        j = i1;
        k = i2;
        break;
        n = m;
        i1 = j;
        i2 = k;
      } while (m < 0);
      n = i - m;
      if (n <= j) {
        break label128;
      }
      j = n;
    }
    for (;;)
    {
      n = -1;
      i1 = j;
      i2 = m;
      break;
      if (j >= 2) {
        Arrays.fill(paramArrayOfInt, k, k + j, -1);
      }
      return;
      label128:
      m = k;
    }
  }
  
  @Nullable
  private static String convertDottedQuadToHex(String paramString)
  {
    int i = paramString.lastIndexOf(':');
    String str = paramString.substring(0, i + 1);
    Object localObject = textToNumericFormatV4(paramString.substring(i + 1));
    if (localObject == null) {
      return null;
    }
    paramString = Integer.toHexString((localObject[0] & 0xFF) << 8 | localObject[1] & 0xFF);
    i = localObject[2];
    localObject = Integer.toHexString(localObject[3] & 0xFF | (i & 0xFF) << 8);
    return str + paramString + ":" + (String)localObject;
  }
  
  public static InetAddress decrement(InetAddress paramInetAddress)
  {
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = arrayOfByte.length - 1;
    while ((i >= 0) && (arrayOfByte[i] == 0))
    {
      arrayOfByte[i] = -1;
      i -= 1;
    }
    if (i >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Decrementing %s would wrap.", paramInetAddress);
      arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
      return bytesToInetAddress(arrayOfByte);
    }
  }
  
  public static InetAddress forString(String paramString)
  {
    byte[] arrayOfByte = ipStringToBytes(paramString);
    if (arrayOfByte == null) {
      throw formatIllegalArgumentException("'%s' is not an IP string literal.", new Object[] { paramString });
    }
    return bytesToInetAddress(arrayOfByte);
  }
  
  public static InetAddress forUriString(String paramString)
  {
    InetAddress localInetAddress = forUriStringNoThrow(paramString);
    if (localInetAddress == null) {
      throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", new Object[] { paramString });
    }
    return localInetAddress;
  }
  
  @Nullable
  private static InetAddress forUriStringNoThrow(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
      paramString = paramString.substring(1, paramString.length() - 1);
    }
    for (int i = 16;; i = 4)
    {
      paramString = ipStringToBytes(paramString);
      if ((paramString != null) && (paramString.length == i)) {
        break;
      }
      return null;
    }
    return bytesToInetAddress(paramString);
  }
  
  private static IllegalArgumentException formatIllegalArgumentException(String paramString, Object... paramVarArgs)
  {
    return new IllegalArgumentException(String.format(Locale.ROOT, paramString, paramVarArgs));
  }
  
  public static Inet4Address fromInteger(int paramInt)
  {
    return getInet4Address(Ints.toByteArray(paramInt));
  }
  
  public static InetAddress fromLittleEndianByteArray(byte[] paramArrayOfByte)
    throws UnknownHostException
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = paramArrayOfByte[(paramArrayOfByte.length - i - 1)];
      i += 1;
    }
    return InetAddress.getByAddress(arrayOfByte);
  }
  
  public static Inet4Address get6to4IPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(is6to4Address(paramInet6Address), "Address '%s' is not a 6to4 address.", toAddrString(paramInet6Address));
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 2, 6));
  }
  
  public static Inet4Address getCoercedIPv4Address(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet4Address)) {
      return (Inet4Address)paramInetAddress;
    }
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = 0;
    if (i < 15) {
      if (arrayOfByte[i] == 0) {}
    }
    for (i = 0;; i = 1)
    {
      if ((i != 0) && (arrayOfByte[15] == 1))
      {
        return LOOPBACK4;
        i += 1;
        break;
      }
      if ((i != 0) && (arrayOfByte[15] == 0)) {
        return ANY4;
      }
      paramInetAddress = (Inet6Address)paramInetAddress;
      if (hasEmbeddedIPv4ClientAddress(paramInetAddress)) {}
      for (long l = getEmbeddedIPv4ClientAddress(paramInetAddress).hashCode();; l = ByteBuffer.wrap(paramInetAddress.getAddress(), 0, 8).getLong())
      {
        int j = Hashing.murmur3_32().hashLong(l).asInt() | 0xE0000000;
        i = j;
        if (j == -1) {
          i = -2;
        }
        return getInet4Address(Ints.toByteArray(i));
      }
    }
  }
  
  public static Inet4Address getCompatIPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(isCompatIPv4Address(paramInet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(paramInet6Address));
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 12, 16));
  }
  
  public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address)
  {
    if (isCompatIPv4Address(paramInet6Address)) {
      return getCompatIPv4Address(paramInet6Address);
    }
    if (is6to4Address(paramInet6Address)) {
      return get6to4IPv4Address(paramInet6Address);
    }
    if (isTeredoAddress(paramInet6Address)) {
      return getTeredoInfo(paramInet6Address).getClient();
    }
    throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", new Object[] { toAddrString(paramInet6Address) });
  }
  
  private static Inet4Address getInet4Address(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 4) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Byte array has invalid length for an IPv4 address: %s != 4.", paramArrayOfByte.length);
      return (Inet4Address)bytesToInetAddress(paramArrayOfByte);
    }
  }
  
  public static Inet4Address getIsatapIPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(isIsatapAddress(paramInet6Address), "Address '%s' is not an ISATAP address.", toAddrString(paramInet6Address));
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 12, 16));
  }
  
  public static TeredoInfo getTeredoInfo(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(isTeredoAddress(paramInet6Address), "Address '%s' is not a Teredo address.", toAddrString(paramInet6Address));
    byte[] arrayOfByte = paramInet6Address.getAddress();
    paramInet6Address = getInet4Address(Arrays.copyOfRange(arrayOfByte, 4, 8));
    int j = ByteStreams.newDataInput(arrayOfByte, 8).readShort();
    int k = ByteStreams.newDataInput(arrayOfByte, 10).readShort();
    arrayOfByte = Arrays.copyOfRange(arrayOfByte, 12, 16);
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ 0xFFFFFFFF));
      i += 1;
    }
    return new TeredoInfo(paramInet6Address, getInet4Address(arrayOfByte), (k ^ 0xFFFFFFFF) & 0xFFFF, j & 0xFFFF);
  }
  
  public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address)
  {
    return (isCompatIPv4Address(paramInet6Address)) || (is6to4Address(paramInet6Address)) || (isTeredoAddress(paramInet6Address));
  }
  
  private static String hextetsToIPv6String(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(39);
    int j = 0;
    int k = 0;
    if (j < paramArrayOfInt.length)
    {
      int i;
      if (paramArrayOfInt[j] >= 0)
      {
        i = 1;
        label29:
        if (i == 0) {
          break label71;
        }
        if (k != 0) {
          localStringBuilder.append(':');
        }
        localStringBuilder.append(Integer.toHexString(paramArrayOfInt[j]));
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = 0;
        break label29;
        label71:
        if ((j == 0) || (k != 0)) {
          localStringBuilder.append("::");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static InetAddress increment(InetAddress paramInetAddress)
  {
    boolean bool = false;
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = arrayOfByte.length - 1;
    while ((i >= 0) && (arrayOfByte[i] == -1))
    {
      arrayOfByte[i] = 0;
      i -= 1;
    }
    if (i >= 0) {
      bool = true;
    }
    Preconditions.checkArgument(bool, "Incrementing %s would wrap.", paramInetAddress);
    arrayOfByte[i] = ((byte)(arrayOfByte[i] + 1));
    return bytesToInetAddress(arrayOfByte);
  }
  
  @Nullable
  private static byte[] ipStringToBytes(String paramString)
  {
    int i = 0;
    int k = 0;
    int j = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (c == '.') {
        k = 1;
      }
      label55:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (c != ':') {
            break label55;
          }
          if (k != 0) {
            return null;
          }
          j = 1;
        }
      } while (Character.digit(c, 16) != -1);
      return null;
    }
    if (j != 0)
    {
      String str = paramString;
      if (k != 0)
      {
        paramString = convertDottedQuadToHex(paramString);
        str = paramString;
        if (paramString == null) {
          return null;
        }
      }
      return textToNumericFormatV6(str);
    }
    if (k != 0) {
      return textToNumericFormatV4(paramString);
    }
    return null;
  }
  
  public static boolean is6to4Address(Inet6Address paramInet6Address)
  {
    paramInet6Address = paramInet6Address.getAddress();
    return (paramInet6Address[0] == 32) && (paramInet6Address[1] == 2);
  }
  
  public static boolean isCompatIPv4Address(Inet6Address paramInet6Address)
  {
    if (!paramInet6Address.isIPv4CompatibleAddress()) {}
    do
    {
      return false;
      paramInet6Address = paramInet6Address.getAddress();
    } while ((paramInet6Address[12] == 0) && (paramInet6Address[13] == 0) && (paramInet6Address[14] == 0) && ((paramInet6Address[15] == 0) || (paramInet6Address[15] == 1)));
    return true;
  }
  
  public static boolean isInetAddress(String paramString)
  {
    return ipStringToBytes(paramString) != null;
  }
  
  public static boolean isIsatapAddress(Inet6Address paramInet6Address)
  {
    if (isTeredoAddress(paramInet6Address)) {}
    do
    {
      return false;
      paramInet6Address = paramInet6Address.getAddress();
    } while (((paramInet6Address[8] | 0x3) != 3) || (paramInet6Address[9] != 0) || (paramInet6Address[10] != 94) || (paramInet6Address[11] != -2));
    return true;
  }
  
  public static boolean isMappedIPv4Address(String paramString)
  {
    int k = 10;
    paramString = ipStringToBytes(paramString);
    int i;
    if ((paramString != null) && (paramString.length == 16)) {
      i = 0;
    }
    int j;
    for (;;)
    {
      j = k;
      if (i >= 10) {
        break;
      }
      if (paramString[i] != 0) {
        return false;
      }
      i += 1;
    }
    do
    {
      j += 1;
      if (j >= 12) {
        break;
      }
    } while (paramString[j] == -1);
    return false;
    return true;
  }
  
  public static boolean isMaximum(InetAddress paramInetAddress)
  {
    paramInetAddress = paramInetAddress.getAddress();
    int i = 0;
    while (i < paramInetAddress.length)
    {
      if (paramInetAddress[i] != -1) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isTeredoAddress(Inet6Address paramInet6Address)
  {
    paramInet6Address = paramInet6Address.getAddress();
    return (paramInet6Address[0] == 32) && (paramInet6Address[1] == 1) && (paramInet6Address[2] == 0) && (paramInet6Address[3] == 0);
  }
  
  public static boolean isUriInetAddress(String paramString)
  {
    return forUriStringNoThrow(paramString) != null;
  }
  
  private static short parseHextet(String paramString)
  {
    int i = Integer.parseInt(paramString, 16);
    if (i > 65535) {
      throw new NumberFormatException();
    }
    return (short)i;
  }
  
  private static byte parseOctet(String paramString)
  {
    int i = Integer.parseInt(paramString);
    if ((i > 255) || ((paramString.startsWith("0")) && (paramString.length() > 1))) {
      throw new NumberFormatException();
    }
    return (byte)i;
  }
  
  @Nullable
  private static byte[] textToNumericFormatV4(String paramString)
  {
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = IPV4_SPLITTER.split(paramString).iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        arrayOfByte[i] = parseOctet((String)paramString.next());
        i += 1;
      }
      if (i != 4) {
        break label60;
      }
    }
    catch (NumberFormatException paramString)
    {
      return null;
    }
    return arrayOfByte;
    label60:
    return null;
  }
  
  @Nullable
  private static byte[] textToNumericFormatV6(String paramString)
  {
    paramString = paramString.split(":", 10);
    if ((paramString.length < 3) || (paramString.length > 9)) {
      return null;
    }
    int i = -1;
    int j = 1;
    int k;
    while (j < paramString.length - 1)
    {
      k = i;
      if (paramString[j].length() == 0)
      {
        if (i >= 0) {
          return null;
        }
        k = j;
      }
      j += 1;
      i = k;
    }
    int m;
    label153:
    ByteBuffer localByteBuffer;
    if (i >= 0)
    {
      m = paramString.length - i - 1;
      if (paramString[0].length() == 0)
      {
        k = i - 1;
        j = k;
        if (k != 0) {
          return null;
        }
      }
      else
      {
        j = i;
      }
      k = m;
      if (paramString[(paramString.length - 1)].length() == 0)
      {
        m -= 1;
        k = m;
        if (m != 0) {
          return null;
        }
      }
    }
    else
    {
      k = paramString.length;
      j = 0;
      m = 8 - (k + j);
      if (i < 0) {
        break label254;
      }
      if (m < 1) {
        break label259;
      }
      localByteBuffer = ByteBuffer.allocate(16);
      i = 0;
      if (i >= k) {
        break label261;
      }
    }
    for (;;)
    {
      try
      {
        localByteBuffer.putShort(parseHextet(paramString[i]));
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        return null;
      }
      k = j;
      if (i < m)
      {
        localByteBuffer.putShort((short)0);
        i += 1;
      }
      else if (k > 0)
      {
        localByteBuffer.putShort(parseHextet(paramString[(paramString.length - k)]));
        k -= 1;
      }
      else
      {
        return localByteBuffer.array();
        m = j;
        j = k;
        k = m;
        break;
        label254:
        if (m == 0) {
          break label153;
        }
        label259:
        return null;
        label261:
        i = 0;
      }
    }
  }
  
  public static String toAddrString(InetAddress paramInetAddress)
  {
    Preconditions.checkNotNull(paramInetAddress);
    if ((paramInetAddress instanceof Inet4Address)) {
      return paramInetAddress.getHostAddress();
    }
    Preconditions.checkArgument(paramInetAddress instanceof Inet6Address);
    paramInetAddress = paramInetAddress.getAddress();
    int[] arrayOfInt = new int[8];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = Ints.fromBytes(0, 0, paramInetAddress[(i * 2)], paramInetAddress[(i * 2 + 1)]);
      i += 1;
    }
    compressLongestRunOfZeroes(arrayOfInt);
    return hextetsToIPv6String(arrayOfInt);
  }
  
  public static String toUriString(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet6Address)) {
      return "[" + toAddrString(paramInetAddress) + "]";
    }
    return toAddrString(paramInetAddress);
  }
  
  @Beta
  public static final class TeredoInfo
  {
    private final Inet4Address client;
    private final int flags;
    private final int port;
    private final Inet4Address server;
    
    public TeredoInfo(@Nullable Inet4Address paramInet4Address1, @Nullable Inet4Address paramInet4Address2, int paramInt1, int paramInt2)
    {
      if ((paramInt1 >= 0) && (paramInt1 <= 65535))
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "port '%s' is out of range (0 <= port <= 0xffff)", paramInt1);
        if ((paramInt2 < 0) || (paramInt2 > 65535)) {
          break label99;
        }
      }
      label99:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "flags '%s' is out of range (0 <= flags <= 0xffff)", paramInt2);
        this.server = ((Inet4Address)MoreObjects.firstNonNull(paramInet4Address1, InetAddresses.ANY4));
        this.client = ((Inet4Address)MoreObjects.firstNonNull(paramInet4Address2, InetAddresses.ANY4));
        this.port = paramInt1;
        this.flags = paramInt2;
        return;
        bool1 = false;
        break;
      }
    }
    
    public Inet4Address getClient()
    {
      return this.client;
    }
    
    public int getFlags()
    {
      return this.flags;
    }
    
    public int getPort()
    {
      return this.port;
    }
    
    public Inet4Address getServer()
    {
      return this.server;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.net.InetAddresses
 * JD-Core Version:    0.7.0.1
 */