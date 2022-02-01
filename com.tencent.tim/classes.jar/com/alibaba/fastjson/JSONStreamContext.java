package com.alibaba.fastjson;

class JSONStreamContext
{
  static final int ArrayValue = 1005;
  static final int PropertyKey = 1002;
  static final int PropertyValue = 1003;
  static final int StartArray = 1004;
  static final int StartObject = 1001;
  protected final JSONStreamContext parent;
  protected int state;
  
  public JSONStreamContext(JSONStreamContext paramJSONStreamContext, int paramInt)
  {
    this.parent = paramJSONStreamContext;
    this.state = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.JSONStreamContext
 * JD-Core Version:    0.7.0.1
 */