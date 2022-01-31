package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.transaction.Transaction;

public abstract interface TransactionOps
{
  public abstract void cancelTransactionTask(Transaction paramTransaction);
  
  public abstract void preConnect();
  
  public abstract void resumeTransactionTask(Transaction paramTransaction);
  
  public abstract void stopTransactionTask(Transaction paramTransaction);
  
  public abstract int submitTransactionTask(Transaction paramTransaction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.api.TransactionOps
 * JD-Core Version:    0.7.0.1
 */