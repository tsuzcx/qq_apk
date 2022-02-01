class alzz
  implements alzd
{
  alzz(alzy paramalzy) {}
  
  public void fp(long paramLong)
    throws InterruptedException
  {}
  
  public void onDecodeCancel()
  {
    ram.d("FlowEdit_VideoFlowDecodeWrapper", "onDecodeCancel: ");
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    ram.d("FlowEdit_VideoFlowDecodeWrapper", paramThrowable, "onDecodeError: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void onDecodeFinish()
  {
    ram.d("FlowEdit_VideoFlowDecodeWrapper", "onDecodeFinish: ");
  }
  
  public void onDecodeRepeat()
  {
    ram.d("FlowEdit_VideoFlowDecodeWrapper", "onDecodeRepeat: ");
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    ram.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeSeekTo: %d", Long.valueOf(paramLong));
  }
  
  public void onDecodeStart()
  {
    ram.d("FlowEdit_VideoFlowDecodeWrapper", "onDecodeStart: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzz
 * JD-Core Version:    0.7.0.1
 */