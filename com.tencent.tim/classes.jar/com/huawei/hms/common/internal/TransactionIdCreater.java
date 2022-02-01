package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TransactionIdCreater
{
  public static String getId(String paramString1, String paramString2)
  {
    return StringUtil.addByteForNum(paramString1, 9, '0') + StringUtil.addByteForNum(paramString2, 6, '0') + new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(new Date()) + String.format(Locale.ENGLISH, "%06d", new Object[] { Integer.valueOf(new SecureRandom().nextInt(1000000)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.TransactionIdCreater
 * JD-Core Version:    0.7.0.1
 */