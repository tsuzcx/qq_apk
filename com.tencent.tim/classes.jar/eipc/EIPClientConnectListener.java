package eipc;

public abstract interface EIPClientConnectListener
{
  public abstract void connectFailed();
  
  public abstract void connectSuccess(EIPCConnection paramEIPCConnection);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     eipc.EIPClientConnectListener
 * JD-Core Version:    0.7.0.1
 */