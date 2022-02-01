package com.facebook.stetho.dumpapp;

class UnexpectedFrameException
  extends DumpappFramingException
{
  public UnexpectedFrameException(byte paramByte1, byte paramByte2)
  {
    super("Expected '" + paramByte1 + "', got: '" + paramByte2 + "'");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.UnexpectedFrameException
 * JD-Core Version:    0.7.0.1
 */