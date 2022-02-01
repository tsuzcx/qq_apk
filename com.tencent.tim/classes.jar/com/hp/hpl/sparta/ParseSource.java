package com.hp.hpl.sparta;

public abstract interface ParseSource
{
  public static final ParseLog DEFAULT_LOG = new DefaultLog();
  public static final int MAXLOOKAHEAD = "<?xml version=\"1.0\" encoding=\"\"".length() + 40;
  
  public abstract int getLineNumber();
  
  public abstract String getSystemId();
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.ParseSource
 * JD-Core Version:    0.7.0.1
 */