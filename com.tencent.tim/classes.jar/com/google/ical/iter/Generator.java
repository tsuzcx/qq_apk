package com.google.ical.iter;

import com.google.ical.util.DTBuilder;

abstract class Generator
{
  static
  {
    IteratorShortCircuitingException.instance();
  }
  
  abstract boolean generate(DTBuilder paramDTBuilder)
    throws Generator.IteratorShortCircuitingException;
  
  static class IteratorShortCircuitingException
    extends Exception
  {
    private static final IteratorShortCircuitingException INSTANCE = new IteratorShortCircuitingException();
    
    private IteratorShortCircuitingException()
    {
      setStackTrace(new StackTraceElement[0]);
    }
    
    static IteratorShortCircuitingException instance()
    {
      return INSTANCE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generator
 * JD-Core Version:    0.7.0.1
 */