package com.tencent.kingkong;

import java.io.FileDescriptor;

public class ParcelFileDescriptor
  extends android.os.ParcelFileDescriptor
{
  private final FileDescriptor mFileDescriptor;
  private final ParcelFileDescriptor mWrapped;
  
  public ParcelFileDescriptor(FileDescriptor paramFileDescriptor)
  {
    super(null);
    if (paramFileDescriptor == null) {
      throw new NullPointerException("descriptor must not be null");
    }
    this.mWrapped = null;
    this.mFileDescriptor = paramFileDescriptor;
  }
  
  public static ParcelFileDescriptor adoptFd(int paramInt)
  {
    return new ParcelFileDescriptor(getFileDescriptorFromFdNoDup(paramInt));
  }
  
  private static native FileDescriptor getFileDescriptorFromFdNoDup(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.ParcelFileDescriptor
 * JD-Core Version:    0.7.0.1
 */