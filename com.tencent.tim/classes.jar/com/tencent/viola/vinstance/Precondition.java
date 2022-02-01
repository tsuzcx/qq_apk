package com.tencent.viola.vinstance;

public abstract class Precondition
{
  protected PreconditionAdapter adapter;
  private boolean isSuccess;
  protected Preconditor preconditor;
  private Object result;
  
  public Precondition(PreconditionAdapter paramPreconditionAdapter, Preconditor paramPreconditor)
  {
    this.adapter = paramPreconditionAdapter;
    this.preconditor = paramPreconditor;
  }
  
  public boolean isSuccess()
  {
    return this.isSuccess;
  }
  
  public abstract void onProcess();
  
  public void setResult(boolean paramBoolean)
  {
    setResult(paramBoolean, null);
  }
  
  public void setResult(boolean paramBoolean, Object paramObject)
  {
    this.isSuccess = paramBoolean;
    this.result = paramObject;
    this.preconditor.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.Precondition
 * JD-Core Version:    0.7.0.1
 */