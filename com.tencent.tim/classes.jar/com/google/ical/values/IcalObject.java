package com.google.ical.values;

import java.util.Map;

public abstract interface IcalObject
{
  public abstract Map<String, String> getExtParams();
  
  public abstract String getName();
  
  public abstract String toIcal();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.IcalObject
 * JD-Core Version:    0.7.0.1
 */