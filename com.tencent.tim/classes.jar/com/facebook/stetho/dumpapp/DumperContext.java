package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.Util;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import org.apache.commons.cli.CommandLineParser;

@Immutable
public class DumperContext
{
  private final List<String> mArgs;
  private final CommandLineParser mParser;
  private final PrintStream mStderr;
  private final InputStream mStdin;
  private final PrintStream mStdout;
  
  protected DumperContext(DumperContext paramDumperContext, List<String> paramList)
  {
    this(paramDumperContext.getStdin(), paramDumperContext.getStdout(), paramDumperContext.getStderr(), paramDumperContext.getParser(), paramList);
  }
  
  public DumperContext(InputStream paramInputStream, PrintStream paramPrintStream1, PrintStream paramPrintStream2, CommandLineParser paramCommandLineParser, List<String> paramList)
  {
    this.mStdin = ((InputStream)Util.throwIfNull(paramInputStream));
    this.mStdout = ((PrintStream)Util.throwIfNull(paramPrintStream1));
    this.mStderr = ((PrintStream)Util.throwIfNull(paramPrintStream2));
    this.mParser = ((CommandLineParser)Util.throwIfNull(paramCommandLineParser));
    this.mArgs = ((List)Util.throwIfNull(paramList));
  }
  
  public List<String> getArgsAsList()
  {
    return this.mArgs;
  }
  
  public CommandLineParser getParser()
  {
    return this.mParser;
  }
  
  public PrintStream getStderr()
  {
    return this.mStderr;
  }
  
  public InputStream getStdin()
  {
    return this.mStdin;
  }
  
  public PrintStream getStdout()
  {
    return this.mStdout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.DumperContext
 * JD-Core Version:    0.7.0.1
 */