package com.google.common.io;

import com.google.common.base.CharMatcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

class BaseEncoding$StandardBaseEncoding$2
  extends InputStream
{
  int bitBuffer = 0;
  int bitBufferLength = 0;
  boolean hitPadding = false;
  final CharMatcher paddingMatcher = this.this$0.padding();
  int readChars = 0;
  
  BaseEncoding$StandardBaseEncoding$2(BaseEncoding.StandardBaseEncoding paramStandardBaseEncoding, Reader paramReader) {}
  
  public void close()
    throws IOException
  {
    this.val$reader.close();
  }
  
  public int read()
    throws IOException
  {
    int j = -1;
    do
    {
      char c;
      for (;;)
      {
        i = this.val$reader.read();
        if (i == -1)
        {
          i = j;
          if (this.hitPadding) {
            return i;
          }
          i = j;
          if (this.this$0.alphabet.isValidPaddingStartPosition(this.readChars)) {
            return i;
          }
          throw new BaseEncoding.DecodingException("Invalid input length " + this.readChars);
        }
        this.readChars += 1;
        c = (char)i;
        if (!this.paddingMatcher.matches(c)) {
          break;
        }
        if ((!this.hitPadding) && ((this.readChars == 1) || (!this.this$0.alphabet.isValidPaddingStartPosition(this.readChars - 1)))) {
          throw new BaseEncoding.DecodingException("Padding cannot start at index " + this.readChars);
        }
        this.hitPadding = true;
      }
      if (this.hitPadding) {
        throw new BaseEncoding.DecodingException("Expected padding character but found '" + c + "' at index " + this.readChars);
      }
      this.bitBuffer <<= this.this$0.alphabet.bitsPerChar;
      i = this.bitBuffer;
      this.bitBuffer = (this.this$0.alphabet.decode(c) | i);
      this.bitBufferLength += this.this$0.alphabet.bitsPerChar;
    } while (this.bitBufferLength < 8);
    this.bitBufferLength -= 8;
    int i = this.bitBuffer >> this.bitBufferLength & 0xFF;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.BaseEncoding.StandardBaseEncoding.2
 * JD-Core Version:    0.7.0.1
 */