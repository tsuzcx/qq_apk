package com.facebook.stetho.dumpapp;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class GlobalOptions
{
  public final Option optionHelp = new Option("h", "help", false, "Print this help");
  public final Option optionListPlugins = new Option("l", "list", false, "List available plugins");
  public final Option optionProcess = new Option("p", "process", true, "Specify target process");
  public final Options options = new Options();
  
  public GlobalOptions()
  {
    this.options.addOption(this.optionHelp);
    this.options.addOption(this.optionListPlugins);
    this.options.addOption(this.optionProcess);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.GlobalOptions
 * JD-Core Version:    0.7.0.1
 */