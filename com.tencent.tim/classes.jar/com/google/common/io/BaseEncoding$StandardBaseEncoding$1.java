package com.google.common.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

class BaseEncoding$StandardBaseEncoding$1
  extends OutputStream
{
  int bitBuffer = 0;
  int bitBufferLength = 0;
  int writtenChars = 0;
  
  BaseEncoding$StandardBaseEncoding$1(BaseEncoding.StandardBaseEncoding paramStandardBaseEncoding, Writer paramWriter) {}
  
  public void close()
    throws IOException
  {
    if (this.bitBufferLength > 0)
    {
      int i = this.bitBuffer;
      int j = this.this$0.alphabet.bitsPerChar;
      int k = this.bitBufferLength;
      int m = this.this$0.alphabet.mask;
      this.val$out.write(this.this$0.alphabet.encode(i << j - k & m));
      this.writtenChars += 1;
      if (this.this$0.paddingChar != null) {
        while (this.writtenChars % this.this$0.alphabet.charsPerChunk != 0)
        {
          this.val$out.write(this.this$0.paddingChar.charValue());
          this.writtenChars += 1;
        }
      }
    }
    this.val$out.close();
  }
  
  public void flush()
    throws IOException
  {
    this.val$out.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.bitBuffer <<= 8;
    this.bitBuffer |= paramInt & 0xFF;
    for (this.bitBufferLength += 8; this.bitBufferLength >= this.this$0.alphabet.bitsPerChar; this.bitBufferLength -= this.this$0.alphabet.bitsPerChar)
    {
      paramInt = this.bitBuffer;
      int i = this.bitBufferLength;
      int j = this.this$0.alphabet.bitsPerChar;
      int k = this.this$0.alphabet.mask;
      this.val$out.write(this.this$0.alphabet.encode(paramInt >> i - j & k));
      this.writtenChars += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.BaseEncoding.StandardBaseEncoding.1
 * JD-Core Version:    0.7.0.1
 */