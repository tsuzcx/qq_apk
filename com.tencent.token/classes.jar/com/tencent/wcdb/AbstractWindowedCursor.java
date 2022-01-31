package com.tencent.wcdb;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor
  extends AbstractCursor
{
  protected CursorWindow mWindow;
  
  protected void checkPosition()
  {
    super.checkPosition();
    if (this.mWindow == null) {
      throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
    }
  }
  
  protected void clearOrCreateWindow(String paramString)
  {
    if (this.mWindow == null)
    {
      this.mWindow = new CursorWindow(paramString);
      return;
    }
    this.mWindow.clear();
  }
  
  protected void closeWindow()
  {
    if (this.mWindow != null)
    {
      this.mWindow.close();
      this.mWindow = null;
    }
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    checkPosition();
    this.mWindow.copyStringToBuffer(this.mPos, paramInt, paramCharArrayBuffer);
  }
  
  public byte[] getBlob(int paramInt)
  {
    checkPosition();
    return this.mWindow.getBlob(this.mPos, paramInt);
  }
  
  public double getDouble(int paramInt)
  {
    checkPosition();
    return this.mWindow.getDouble(this.mPos, paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    checkPosition();
    return this.mWindow.getFloat(this.mPos, paramInt);
  }
  
  public int getInt(int paramInt)
  {
    checkPosition();
    return this.mWindow.getInt(this.mPos, paramInt);
  }
  
  public long getLong(int paramInt)
  {
    checkPosition();
    return this.mWindow.getLong(this.mPos, paramInt);
  }
  
  public short getShort(int paramInt)
  {
    checkPosition();
    return this.mWindow.getShort(this.mPos, paramInt);
  }
  
  public String getString(int paramInt)
  {
    checkPosition();
    return this.mWindow.getString(this.mPos, paramInt);
  }
  
  public int getType(int paramInt)
  {
    checkPosition();
    return this.mWindow.getType(this.mPos, paramInt);
  }
  
  public CursorWindow getWindow()
  {
    return this.mWindow;
  }
  
  public boolean hasWindow()
  {
    return this.mWindow != null;
  }
  
  @Deprecated
  public boolean isBlob(int paramInt)
  {
    return getType(paramInt) == 4;
  }
  
  @Deprecated
  public boolean isFloat(int paramInt)
  {
    return getType(paramInt) == 2;
  }
  
  @Deprecated
  public boolean isLong(int paramInt)
  {
    return getType(paramInt) == 1;
  }
  
  public boolean isNull(int paramInt)
  {
    checkPosition();
    return this.mWindow.getType(this.mPos, paramInt) == 0;
  }
  
  @Deprecated
  public boolean isString(int paramInt)
  {
    return getType(paramInt) == 3;
  }
  
  protected void onDeactivateOrClose()
  {
    super.onDeactivateOrClose();
    closeWindow();
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    if (paramCursorWindow != this.mWindow)
    {
      closeWindow();
      this.mWindow = paramCursorWindow;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.AbstractWindowedCursor
 * JD-Core Version:    0.7.0.1
 */