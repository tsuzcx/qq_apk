package org.junit.experimental.theories;

public abstract class PotentialAssignment
{
  public static PotentialAssignment forValue(String paramString, Object paramObject)
  {
    return new PotentialAssignment.1(paramObject, paramString);
  }
  
  public abstract String getDescription()
    throws PotentialAssignment.CouldNotGenerateValueException;
  
  public abstract Object getValue()
    throws PotentialAssignment.CouldNotGenerateValueException;
  
  public static class CouldNotGenerateValueException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    
    public CouldNotGenerateValueException() {}
    
    public CouldNotGenerateValueException(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.PotentialAssignment
 * JD-Core Version:    0.7.0.1
 */