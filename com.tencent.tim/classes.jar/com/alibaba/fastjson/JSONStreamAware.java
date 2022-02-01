package com.alibaba.fastjson;

import java.io.IOException;

public abstract interface JSONStreamAware
{
  public abstract void writeJSONString(Appendable paramAppendable)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.JSONStreamAware
 * JD-Core Version:    0.7.0.1
 */