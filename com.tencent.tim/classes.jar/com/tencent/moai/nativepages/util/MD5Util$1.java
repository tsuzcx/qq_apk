package com.tencent.moai.nativepages.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class MD5Util$1
  extends ThreadLocal<MessageDigest>
{
  protected MessageDigest initialValue()
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.MD5Util.1
 * JD-Core Version:    0.7.0.1
 */