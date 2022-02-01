package com.tencent.tmediacodec;

import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.codec.CodecWrapper;

class TMediaCodec$1
  implements Runnable
{
  TMediaCodec$1(TMediaCodec paramTMediaCodec) {}
  
  public void run()
  {
    if (TMediaCodec.access$000(this.this$0) != null) {
      TMediaCodec.access$000(this.this$0).setCodecCallback(TMediaCodec.access$100(this.this$0));
    }
    if (TMediaCodec.access$100(this.this$0) != null) {
      TMediaCodec.access$100(this.this$0).onCreate(Boolean.valueOf(this.this$0.isReUsed));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec.1
 * JD-Core Version:    0.7.0.1
 */