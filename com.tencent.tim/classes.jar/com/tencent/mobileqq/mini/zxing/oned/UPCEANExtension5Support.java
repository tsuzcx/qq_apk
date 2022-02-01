package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultMetadataType;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.HashMap;
import java.util.Map;

final class UPCEANExtension5Support
{
  private static final int[] CHECK_DIGIT_ENCODINGS = { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
  private final int[] decodeMiddleCounters = new int[4];
  private final StringBuilder decodeRowStringBuffer = new StringBuilder();
  
  private int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws NotFoundException
  {
    int[] arrayOfInt = this.decodeMiddleCounters;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int n = paramBitArray.getSize();
    int i = paramArrayOfInt[1];
    int k = 0;
    int m;
    for (int j = 0; (k < 5) && (i < n); j = m)
    {
      int i1 = UPCEANReader.decodeDigit(paramBitArray, arrayOfInt, i, UPCEANReader.L_AND_G_PATTERNS);
      paramStringBuilder.append((char)(i1 % 10 + 48));
      int i2 = arrayOfInt.length;
      m = 0;
      while (m < i2)
      {
        int i3 = arrayOfInt[m];
        m += 1;
        i = i3 + i;
      }
      m = j;
      if (i1 >= 10) {
        m = j | 1 << 4 - k;
      }
      j = i;
      if (k != 4) {
        j = paramBitArray.getNextUnset(paramBitArray.getNextSet(i));
      }
      k += 1;
      i = j;
    }
    if (paramStringBuilder.length() != 5) {
      throw NotFoundException.getNotFoundInstance();
    }
    j = determineCheckDigit(j);
    if (extensionChecksum(paramStringBuilder.toString()) != j) {
      throw NotFoundException.getNotFoundInstance();
    }
    return i;
  }
  
  private static int determineCheckDigit(int paramInt)
    throws NotFoundException
  {
    int i = 0;
    while (i < 10)
    {
      if (paramInt == CHECK_DIGIT_ENCODINGS[i]) {
        return i;
      }
      i += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int extensionChecksum(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int i = k - 2;
    while (i >= 0)
    {
      j += paramCharSequence.charAt(i) - '0';
      i -= 2;
    }
    j *= 3;
    i = k - 1;
    while (i >= 0)
    {
      j += paramCharSequence.charAt(i) - '0';
      i -= 2;
    }
    return j * 3 % 10;
  }
  
  private static String parseExtension5String(String paramString)
  {
    String str;
    int j;
    int i;
    switch (paramString.charAt(0))
    {
    default: 
      str = "";
      j = Integer.parseInt(paramString.substring(1));
      i = j / 100;
      j %= 100;
      if (j >= 10) {
        break;
      }
    }
    for (paramString = "0" + j;; paramString = String.valueOf(j))
    {
      return str + String.valueOf(i) + '.' + paramString;
      str = "£";
      break;
      str = "$";
      break;
      if ("90000".equals(paramString)) {
        return null;
      }
      if ("99991".equals(paramString)) {
        return "0.00";
      }
      if ("99990".equals(paramString)) {
        return "Used";
      }
      str = "";
      break;
    }
  }
  
  private static Map<ResultMetadataType, Object> parseExtensionString(String paramString)
  {
    if (paramString.length() != 5) {}
    do
    {
      return null;
      paramString = parseExtension5String(paramString);
    } while (paramString == null);
    HashMap localHashMap = new HashMap();
    localHashMap.put(ResultMetadataType.SUGGESTED_PRICE, paramString);
    return localHashMap;
  }
  
  Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt)
    throws NotFoundException
  {
    Object localObject = this.decodeRowStringBuffer;
    ((StringBuilder)localObject).setLength(0);
    int i = decodeMiddle(paramBitArray, paramArrayOfInt, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    paramBitArray = parseExtensionString((String)localObject);
    paramArrayOfInt = new ResultPoint((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt);
    ResultPoint localResultPoint = new ResultPoint(i, paramInt);
    BarcodeFormat localBarcodeFormat = BarcodeFormat.UPC_EAN_EXTENSION;
    paramArrayOfInt = new Result((String)localObject, null, new ResultPoint[] { paramArrayOfInt, localResultPoint }, localBarcodeFormat);
    if (paramBitArray != null) {
      paramArrayOfInt.putAllMetadata(paramBitArray);
    }
    return paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.UPCEANExtension5Support
 * JD-Core Version:    0.7.0.1
 */