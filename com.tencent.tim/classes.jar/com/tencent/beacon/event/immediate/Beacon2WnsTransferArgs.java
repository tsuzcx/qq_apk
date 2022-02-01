package com.tencent.beacon.event.immediate;

public class Beacon2WnsTransferArgs
  extends BeaconTransferArgs
{
  private String b = "bls.longconnection";
  
  public Beacon2WnsTransferArgs(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public String getCommand()
  {
    return this.b;
  }
  
  public void setCommand(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.immediate.Beacon2WnsTransferArgs
 * JD-Core Version:    0.7.0.1
 */