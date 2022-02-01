package com.tencent.qqmail.utilities.qmnetwork.ssl;

public class SSLStrategyFactory
{
  private static final SSLStraetgy IMPL = new SafeSSLStrategy();
  
  public static SSLStraetgy getSSLStrategy()
  {
    return IMPL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SSLStrategyFactory
 * JD-Core Version:    0.7.0.1
 */