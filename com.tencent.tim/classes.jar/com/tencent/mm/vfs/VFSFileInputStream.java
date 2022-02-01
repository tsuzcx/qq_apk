package com.tencent.mm.vfs;

import java.io.FileNotFoundException;
import java.io.FilterInputStream;

public class VFSFileInputStream
  extends FilterInputStream
{
  public VFSFileInputStream(VFSFile paramVFSFile)
    throws FileNotFoundException
  {
    super(VFSFileOp.openRead(paramVFSFile.getUri(), paramVFSFile.resolve()));
  }
  
  public VFSFileInputStream(String paramString)
    throws FileNotFoundException
  {
    super(VFSFileOp.openRead(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileInputStream
 * JD-Core Version:    0.7.0.1
 */