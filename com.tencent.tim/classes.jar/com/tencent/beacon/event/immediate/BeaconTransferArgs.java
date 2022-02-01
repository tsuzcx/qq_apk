package com.tencent.beacon.event.immediate;

public abstract class BeaconTransferArgs
{
  private byte[] a;
  
  public BeaconTransferArgs(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public abstract String getCommand();
  
  public byte[] getData()
  {
    return this.a;
  }
  
  public abstract void setCommand(String paramString);
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.immediate.BeaconTransferArgs
 * JD-Core Version:    0.7.0.1
 */