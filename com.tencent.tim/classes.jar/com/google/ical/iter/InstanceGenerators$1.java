package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.Predicate;

final class InstanceGenerators$1
  extends Generator
{
  InstanceGenerators$1(Generator paramGenerator1, Generator paramGenerator2, Generator paramGenerator3, Predicate paramPredicate) {}
  
  public boolean generate(DTBuilder paramDTBuilder)
    throws Generator.IteratorShortCircuitingException
  {
    do
    {
      if (!this.val$dayGenerator.generate(paramDTBuilder))
      {
        do
        {
          if (this.val$monthGenerator.generate(paramDTBuilder)) {
            break;
          }
        } while (this.val$yearGenerator.generate(paramDTBuilder));
        return false;
      }
    } while (!this.val$filter.apply(paramDTBuilder.toDate()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.InstanceGenerators.1
 * JD-Core Version:    0.7.0.1
 */