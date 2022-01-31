package com.tencent.mm.sdk.channel;

import com.tencent.mm.algorithm.MD5;

class MMessageUtil
{
  static byte[] a(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString1 != null) {
      localStringBuffer.append(paramString1);
    }
    localStringBuffer.append(553910273);
    localStringBuffer.append(paramString2);
    localStringBuffer.append("mMcShCsTr");
    return MD5.getMessageDigest(localStringBuffer.toString().substring(1, 9).getBytes()).getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.channel.MMessageUtil
 * JD-Core Version:    0.7.0.1
 */