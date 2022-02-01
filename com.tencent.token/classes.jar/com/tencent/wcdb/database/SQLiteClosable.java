package com.tencent.wcdb.database;

import java.io.Closeable;

public abstract class SQLiteClosable
  implements Closeable
{
  private int mReferenceCount = 1;
  
  public void acquireReference()
  {
    try
    {
      if (this.mReferenceCount > 0)
      {
        this.mReferenceCount += 1;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attempt to re-open an already-closed object: ");
      localStringBuilder.append(this);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    finally {}
  }
  
  public void close()
  {
    releaseReference();
  }
  
  protected abstract void onAllReferencesReleased();
  
  @Deprecated
  protected void onAllReferencesReleasedFromContainer()
  {
    onAllReferencesReleased();
  }
  
  public void releaseReference()
  {
    for (;;)
    {
      try
      {
        int j = this.mReferenceCount;
        i = 1;
        j -= 1;
        this.mReferenceCount = j;
        if (j == 0)
        {
          if (i != 0) {
            onAllReferencesReleased();
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  @Deprecated
  public void releaseReferenceFromContainer()
  {
    for (;;)
    {
      try
      {
        int j = this.mReferenceCount;
        i = 1;
        j -= 1;
        this.mReferenceCount = j;
        if (j == 0)
        {
          if (i != 0) {
            onAllReferencesReleased();
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteClosable
 * JD-Core Version:    0.7.0.1
 */