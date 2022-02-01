package com.tencent.moai.database.sqlite;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ReadOnlyBufferException;
import java.sql.Blob;
import java.sql.SQLException;

public class SQLiteBlob
  implements Blob
{
  private static final int BUFFER_SIZE = 8192;
  private static final String TAG = "SQLiteBlob";
  private final int blobPtr;
  private int blobSize;
  private final byte[] buffer;
  private int bufferSize;
  private final int capacity;
  private final String columnName;
  private SQLiteDatabase database;
  private final String dbName;
  private final int flags;
  private int nativeBufferPtr;
  private int readOffset;
  private final int rowId;
  private final String tableName;
  private int writeOffset;
  
  SQLiteBlob(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramInt4, 8192);
  }
  
  SQLiteBlob(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5)
  {
    this.blobPtr = paramInt1;
    this.blobSize = paramInt4;
    this.flags = paramInt2;
    this.dbName = paramString1;
    this.tableName = paramString2;
    this.columnName = paramString3;
    this.rowId = paramInt3;
    this.capacity = paramInt5;
    this.buffer = new byte[paramInt5];
  }
  
  private boolean isReadOnly()
  {
    return this.flags == 0;
  }
  
  public void close()
  {
    this.database.getThreadSession().executeCloseBlob(this, this.database.getThreadDefaultConnectionFlags(isReadOnly()));
  }
  
  void flush()
  {
    if (this.bufferSize > 0)
    {
      this.database.getThreadSession().executeWriteBlob(this, this.database.getThreadDefaultConnectionFlags(isReadOnly()));
      this.writeOffset += this.bufferSize;
      this.bufferSize = 0;
    }
  }
  
  public void free()
  {
    this.database.getThreadSession().executeCloseBlob(this, this.database.getThreadDefaultConnectionFlags(isReadOnly()));
  }
  
  public InputStream getBinaryStream()
    throws SQLException
  {
    return new SQLiteBlob.1(this);
  }
  
  public InputStream getBinaryStream(long paramLong1, long paramLong2)
    throws SQLException
  {
    return null;
  }
  
  int getBlobPtr()
  {
    return this.blobPtr;
  }
  
  public byte[] getBuffer()
  {
    return this.buffer;
  }
  
  int getBufferSize()
  {
    if (isReadOnly()) {
      return Math.min(this.blobSize - this.readOffset, this.capacity);
    }
    return this.bufferSize;
  }
  
  public byte[] getBytes(long paramLong, int paramInt)
    throws SQLException
  {
    return new byte[0];
  }
  
  String getColumnName()
  {
    return this.columnName;
  }
  
  String getDbName()
  {
    return this.dbName;
  }
  
  int getFlags()
  {
    return this.flags;
  }
  
  public int getNativeBufferPtr()
  {
    return this.nativeBufferPtr;
  }
  
  int getRowId()
  {
    return this.rowId;
  }
  
  String getTableName()
  {
    return this.tableName;
  }
  
  int getWriteOffset()
  {
    return this.writeOffset;
  }
  
  public long length()
    throws SQLException
  {
    return this.blobSize;
  }
  
  public long position(Blob paramBlob, long paramLong)
    throws SQLException
  {
    throw new UnsupportedOperationException();
  }
  
  public long position(byte[] paramArrayOfByte, long paramLong)
    throws SQLException
  {
    throw new UnsupportedOperationException();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.readOffset >= this.blobSize) {
      return -1;
    }
    this.database.getThreadSession().executeReadSQLiteBlob(this, this.readOffset, this.database.getThreadDefaultConnectionFlags(isReadOnly()));
    paramInt2 = Math.min(this.blobSize - this.readOffset, paramInt2);
    System.arraycopy(this.buffer, 0, paramArrayOfByte, paramInt1, paramInt2);
    this.readOffset += paramInt2;
    return paramInt2;
  }
  
  public OutputStream setBinaryStream(long paramLong)
    throws SQLException
  {
    if (isReadOnly()) {
      throw new SQLiteBlobTooBigException();
    }
    return null;
  }
  
  void setBlobSize(int paramInt)
  {
    this.blobSize = paramInt;
  }
  
  public int setBytes(long paramLong, byte[] paramArrayOfByte)
    throws SQLException
  {
    if (isReadOnly()) {
      throw new SQLiteBlobTooBigException();
    }
    return 0;
  }
  
  public int setBytes(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws SQLException
  {
    if (isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    return 0;
  }
  
  void setDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    this.database = paramSQLiteDatabase;
  }
  
  public void setNativeBufferPtr(int paramInt)
  {
    this.nativeBufferPtr = paramInt;
  }
  
  void setReadOffset(int paramInt)
  {
    this.readOffset = paramInt;
  }
  
  public void truncate(long paramLong)
    throws SQLException
  {
    throw new UnsupportedOperationException();
  }
  
  public void write(int paramInt)
  {
    this.buffer[0] = ((byte)paramInt);
    this.bufferSize = 1;
    this.writeOffset += this.bufferSize;
    this.database.getThreadSession().executeWriteBlob(this, this.database.getThreadDefaultConnectionFlags(isReadOnly()));
    this.bufferSize = 0;
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.bufferSize = 0;
    int i = paramInt1;
    if (i < paramInt2)
    {
      if (this.bufferSize >= this.capacity) {
        flush();
      }
      for (;;)
      {
        i += 1;
        break;
        this.buffer[this.bufferSize] = paramArrayOfByte[(i + paramInt1)];
        this.bufferSize += 1;
      }
    }
    flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteBlob
 * JD-Core Version:    0.7.0.1
 */