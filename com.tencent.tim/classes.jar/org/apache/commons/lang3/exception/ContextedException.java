package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class ContextedException
  extends Exception
  implements ExceptionContext
{
  private static final long serialVersionUID = 20110706L;
  private final ExceptionContext exceptionContext;
  
  public ContextedException()
  {
    this.exceptionContext = new DefaultExceptionContext();
  }
  
  public ContextedException(String paramString)
  {
    super(paramString);
    this.exceptionContext = new DefaultExceptionContext();
  }
  
  public ContextedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.exceptionContext = new DefaultExceptionContext();
  }
  
  public ContextedException(String paramString, Throwable paramThrowable, ExceptionContext paramExceptionContext)
  {
    super(paramString, paramThrowable);
    paramString = paramExceptionContext;
    if (paramExceptionContext == null) {
      paramString = new DefaultExceptionContext();
    }
    this.exceptionContext = paramString;
  }
  
  public ContextedException(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.exceptionContext = new DefaultExceptionContext();
  }
  
  public ContextedException addContextValue(String paramString, Object paramObject)
  {
    this.exceptionContext.addContextValue(paramString, paramObject);
    return this;
  }
  
  public List<Pair<String, Object>> getContextEntries()
  {
    return this.exceptionContext.getContextEntries();
  }
  
  public Set<String> getContextLabels()
  {
    return this.exceptionContext.getContextLabels();
  }
  
  public List<Object> getContextValues(String paramString)
  {
    return this.exceptionContext.getContextValues(paramString);
  }
  
  public Object getFirstContextValue(String paramString)
  {
    return this.exceptionContext.getFirstContextValue(paramString);
  }
  
  public String getFormattedExceptionMessage(String paramString)
  {
    return this.exceptionContext.getFormattedExceptionMessage(paramString);
  }
  
  public String getMessage()
  {
    return getFormattedExceptionMessage(super.getMessage());
  }
  
  public String getRawMessage()
  {
    return super.getMessage();
  }
  
  public ContextedException setContextValue(String paramString, Object paramObject)
  {
    this.exceptionContext.setContextValue(paramString, paramObject);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.exception.ContextedException
 * JD-Core Version:    0.7.0.1
 */