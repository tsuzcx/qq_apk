package com.hp.hpl.sparta;

class CharCircBuffer
{
  private final int[] buf_;
  private boolean enabled_ = true;
  private int next_ = 0;
  private int total_ = 0;
  
  CharCircBuffer(int paramInt)
  {
    this.buf_ = new int[paramInt];
  }
  
  private void addRaw(int paramInt)
  {
    if (this.enabled_)
    {
      this.buf_[this.next_] = paramInt;
      this.next_ = ((this.next_ + 1) % this.buf_.length);
      this.total_ += 1;
    }
  }
  
  void addChar(char paramChar)
  {
    addRaw(paramChar);
  }
  
  void addInt(int paramInt)
  {
    addRaw(65536 + paramInt);
  }
  
  void addString(String paramString)
  {
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      addChar(paramString[i]);
      i += 1;
    }
  }
  
  void disable()
  {
    this.enabled_ = false;
  }
  
  void enable()
  {
    this.enabled_ = true;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.buf_.length * 11 / 10);
    if (this.total_ < this.buf_.length) {}
    for (int i = this.buf_.length - this.total_; i >= this.buf_.length; i = 0) {
      return localStringBuffer.toString();
    }
    int j = this.next_;
    int k = this.buf_.length;
    j = this.buf_[((j + i) % k)];
    if (j < 65536) {
      localStringBuffer.append((char)j);
    }
    for (;;)
    {
      i += 1;
      break;
      localStringBuffer.append(Integer.toString(j - 65536));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.CharCircBuffer
 * JD-Core Version:    0.7.0.1
 */