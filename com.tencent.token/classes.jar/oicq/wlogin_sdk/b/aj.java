package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class aj
  extends a
{
  public int h = 0;
  
  public aj()
  {
    this.g = 312;
  }
  
  public Boolean e()
  {
    if (this.e < 4) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int32(this.f, this.d);
    if (this.e < this.h * 10 + 4) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public int f()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (util.buf_to_int16(this.f, this.d + 4 + i * 10) == 266) {
          j = util.buf_to_int32(this.f, i * 10 + (this.d + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int g()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (util.buf_to_int16(this.f, this.d + 4 + i * 10) == 284) {
          j = util.buf_to_int32(this.f, i * 10 + (this.d + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int h()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (util.buf_to_int16(this.f, this.d + 4 + i * 10) == 288) {
          j = util.buf_to_int32(this.f, i * 10 + (this.d + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int i()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (util.buf_to_int16(this.f, this.d + 4 + i * 10) == 310) {
          j = util.buf_to_int32(this.f, i * 10 + (this.d + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int j()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (util.buf_to_int16(this.f, this.d + 4 + i * 10) == 258) {
          j = util.buf_to_int32(this.f, i * 10 + (this.d + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int k()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (util.buf_to_int16(this.f, this.d + 4 + i * 10) == 259) {
          j = util.buf_to_int32(this.f, i * 10 + (this.d + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int l()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (util.buf_to_int16(this.f, this.d + 4 + i * 10) == 323) {
          j = util.buf_to_int32(this.f, i * 10 + (this.d + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int m()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (util.buf_to_int16(this.f, this.d + 4 + i * 10) == 356) {
          j = util.buf_to_int32(this.f, i * 10 + (this.d + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.aj
 * JD-Core Version:    0.7.0.1
 */