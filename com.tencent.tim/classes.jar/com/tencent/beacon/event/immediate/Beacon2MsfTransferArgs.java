package com.tencent.beacon.event.immediate;

public class Beacon2MsfTransferArgs
  extends BeaconTransferArgs
{
  private String b = "trpc.Beacon.BeaconLogServerLC.blslongconnection.SsoProcess";
  
  public Beacon2MsfTransferArgs(byte[] paramArrayOfByte)
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
 * Qualified Name:     com.tencent.beacon.event.immediate.Beacon2MsfTransferArgs
 * JD-Core Version:    0.7.0.1
 */