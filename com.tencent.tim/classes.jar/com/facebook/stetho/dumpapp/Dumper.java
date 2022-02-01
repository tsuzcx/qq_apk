package com.facebook.stetho.dumpapp;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;

public class Dumper
{
  private final Map<String, DumperPlugin> mDumperPlugins;
  private final GlobalOptions mGlobalOptions;
  private final CommandLineParser mParser;
  
  public Dumper(Iterable<DumperPlugin> paramIterable)
  {
    this(paramIterable, new GnuParser());
  }
  
  public Dumper(Iterable<DumperPlugin> paramIterable, CommandLineParser paramCommandLineParser)
  {
    this.mDumperPlugins = generatePluginMap(paramIterable);
    this.mParser = paramCommandLineParser;
    this.mGlobalOptions = new GlobalOptions();
  }
  
  private int doDump(InputStream paramInputStream, PrintStream paramPrintStream1, PrintStream paramPrintStream2, String[] paramArrayOfString)
    throws ParseException, DumpException
  {
    paramArrayOfString = this.mParser.parse(this.mGlobalOptions.options, paramArrayOfString, true);
    if (paramArrayOfString.hasOption(this.mGlobalOptions.optionHelp.getOpt()))
    {
      dumpUsage(paramPrintStream1);
      return 0;
    }
    if (paramArrayOfString.hasOption(this.mGlobalOptions.optionListPlugins.getOpt()))
    {
      dumpAvailablePlugins(paramPrintStream1);
      return 0;
    }
    if (!paramArrayOfString.getArgList().isEmpty())
    {
      dumpPluginOutput(paramInputStream, paramPrintStream1, paramPrintStream2, paramArrayOfString);
      return 0;
    }
    dumpUsage(paramPrintStream2);
    return 1;
  }
  
  private void dumpAvailablePlugins(PrintStream paramPrintStream)
  {
    Object localObject = new ArrayList();
    Iterator localIterator = this.mDumperPlugins.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(((DumperPlugin)localIterator.next()).getName());
    }
    Collections.sort((List)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramPrintStream.println((String)((Iterator)localObject).next());
    }
  }
  
  private void dumpPluginOutput(InputStream paramInputStream, PrintStream paramPrintStream1, PrintStream paramPrintStream2, CommandLine paramCommandLine)
    throws DumpException
  {
    paramCommandLine = new ArrayList(paramCommandLine.getArgList());
    if (paramCommandLine.size() < 1) {
      throw new DumpException("Expected plugin argument");
    }
    String str = (String)paramCommandLine.remove(0);
    DumperPlugin localDumperPlugin = (DumperPlugin)this.mDumperPlugins.get(str);
    if (localDumperPlugin == null) {
      throw new DumpException("No plugin named '" + str + "'");
    }
    localDumperPlugin.dump(new DumperContext(paramInputStream, paramPrintStream1, paramPrintStream2, this.mParser, paramCommandLine));
  }
  
  private void dumpUsage(PrintStream paramPrintStream)
  {
    HelpFormatter localHelpFormatter = new HelpFormatter();
    paramPrintStream.println("Usage: dumpapp [options] <plugin> [plugin-options]");
    paramPrintStream = new PrintWriter(paramPrintStream);
    try
    {
      localHelpFormatter.printOptions(paramPrintStream, localHelpFormatter.getWidth(), this.mGlobalOptions.options, localHelpFormatter.getLeftPadding(), localHelpFormatter.getDescPadding());
      return;
    }
    finally
    {
      paramPrintStream.flush();
    }
  }
  
  private static Map<String, DumperPlugin> generatePluginMap(Iterable<DumperPlugin> paramIterable)
  {
    HashMap localHashMap = new HashMap();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      DumperPlugin localDumperPlugin = (DumperPlugin)paramIterable.next();
      localHashMap.put(localDumperPlugin.getName(), localDumperPlugin);
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public int dump(InputStream paramInputStream, PrintStream paramPrintStream1, PrintStream paramPrintStream2, String[] paramArrayOfString)
  {
    try
    {
      int i = doDump(paramInputStream, paramPrintStream1, paramPrintStream2, paramArrayOfString);
      return i;
    }
    catch (ParseException paramInputStream)
    {
      paramPrintStream2.println(paramInputStream.getMessage());
      dumpUsage(paramPrintStream2);
      return 1;
    }
    catch (DumpException paramInputStream)
    {
      paramPrintStream2.println(paramInputStream.getMessage());
      return 1;
    }
    catch (DumpappOutputBrokenException paramInputStream)
    {
      throw paramInputStream;
    }
    catch (RuntimeException paramInputStream)
    {
      paramInputStream.printStackTrace(paramPrintStream2);
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.Dumper
 * JD-Core Version:    0.7.0.1
 */