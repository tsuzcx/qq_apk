package com.tencent.qqmail.model.mail;

public class RetryTask
{
  private static long retryTimes = 0L;
  private int[] retryAddAccountTimeInterval = { 1, 5, 10, 20, 40, 80, 160, 320, 680, 1200 };
  
  public void ddd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.RetryTask
 * JD-Core Version:    0.7.0.1
 */