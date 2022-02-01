package com.tencent.mobileqq.apollo;

import abyn;
import abyq;

final class ApolloRender$10
  implements Runnable
{
  ApolloRender$10(String paramString1, String paramString2, String[] paramArrayOfString, abyn paramabyn, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    String str = this.val$method.toUpperCase();
    if (str.equals("GET")) {
      abyq.a(this.val$url, this.dp, this.a);
    }
    while (!str.equals("POST")) {
      return;
    }
    if (this.bDd)
    {
      abyq.a(this.val$url, this.bgh, this.bgi, this.lr, this.dp, this.a);
      return;
    }
    abyq.a(this.val$url, this.bgh, this.dp, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.10
 * JD-Core Version:    0.7.0.1
 */