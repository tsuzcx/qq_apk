package com.tencent.tbs.reader;

class ReaderEngine$1$1
  implements Runnable
{
  ReaderEngine$1$1(ReaderEngine.1 param1, ITbsReaderCallback paramITbsReaderCallback, int paramInt) {}
  
  public void run()
  {
    if (this.val$callBackListener != null) {
      this.val$callBackListener.onCallBackAction(Integer.valueOf(16), Integer.valueOf(this.val$args), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderEngine.1.1
 * JD-Core Version:    0.7.0.1
 */