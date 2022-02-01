package com.tencent.mobileqq.apollo;

import abyo;
import abyp;
import abyq;

final class ApolloRender$14
  implements Runnable
{
  ApolloRender$14(String paramString1, String paramString2, String[] paramArrayOfString, byte[] paramArrayOfByte, abyp paramabyp, abyo paramabyo1, abyo paramabyo2) {}
  
  public void run()
  {
    if ((this.val$url.startsWith("http://stubcmshow.qq.com/cm3d/")) || (this.val$url.startsWith("https://stubcmshow.qq.com/cm3d/")))
    {
      abyq.a(this.val$url, this.val$method, this.dp, this.val$body, this.jdField_a_of_type_Abyp, this.jdField_a_of_type_Abyo, this.b);
      return;
    }
    abyq.b(this.val$url, this.val$method, this.dp, this.val$body, this.jdField_a_of_type_Abyp, this.jdField_a_of_type_Abyo, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.14
 * JD-Core Version:    0.7.0.1
 */