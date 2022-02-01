package com.tencent.mm.vfs;

import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class VFSFileOutputStream
  extends FilterOutputStream
{
  public VFSFileOutputStream(VFSFile paramVFSFile)
    throws FileNotFoundException
  {
    super(VFSFileOp.openWrite(paramVFSFile.getUri(), paramVFSFile.resolve(), false));
  }
  
  public VFSFileOutputStream(VFSFile paramVFSFile, boolean paramBoolean)
    throws FileNotFoundException
  {
    super(VFSFileOp.openWrite(paramVFSFile.getUri(), paramVFSFile.resolve(), paramBoolean));
  }
  
  public VFSFileOutputStream(String paramString)
    throws FileNotFoundException
  {
    super(VFSFileOp.openWrite(paramString, false));
  }
  
  public VFSFileOutputStream(String paramString, boolean paramBoolean)
    throws FileNotFoundException
  {
    super(VFSFileOp.openWrite(paramString, paramBoolean));
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileOutputStream
 * JD-Core Version:    0.7.0.1
 */