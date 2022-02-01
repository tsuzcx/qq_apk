package com.facebook.stetho.inspector.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public abstract interface AsyncPrettyPrinter
{
  public abstract PrettyPrinterDisplayType getPrettifiedType();
  
  public abstract void printTo(PrintWriter paramPrintWriter, InputStream paramInputStream)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.AsyncPrettyPrinter
 * JD-Core Version:    0.7.0.1
 */