package org.junit.runner.notification;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.junit.runner.Description;

public class Failure
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Description fDescription;
  private final Throwable fThrownException;
  
  public Failure(Description paramDescription, Throwable paramThrowable)
  {
    this.fThrownException = paramThrowable;
    this.fDescription = paramDescription;
  }
  
  public Description getDescription()
  {
    return this.fDescription;
  }
  
  public Throwable getException()
  {
    return this.fThrownException;
  }
  
  public String getMessage()
  {
    return getException().getMessage();
  }
  
  public String getTestHeader()
  {
    return this.fDescription.getDisplayName();
  }
  
  public String getTrace()
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    getException().printStackTrace(localPrintWriter);
    return localStringWriter.toString();
  }
  
  public String toString()
  {
    return getTestHeader() + ": " + this.fThrownException.getMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.notification.Failure
 * JD-Core Version:    0.7.0.1
 */