package org.junit.experimental.theories;

import java.util.List;

public abstract class ParameterSupplier
{
  public abstract List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
    throws Throwable;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.ParameterSupplier
 * JD-Core Version:    0.7.0.1
 */