package org.apache.commons.cli;

public abstract interface CommandLineParser
{
  public abstract CommandLine parse(Options paramOptions, String[] paramArrayOfString)
    throws ParseException;
  
  public abstract CommandLine parse(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.CommandLineParser
 * JD-Core Version:    0.7.0.1
 */