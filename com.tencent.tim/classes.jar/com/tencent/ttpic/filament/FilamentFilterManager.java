package com.tencent.ttpic.filament;

public enum FilamentFilterManager
{
  INSTANCE;
  
  private FilamentFilter filter;
  
  private FilamentFilterManager() {}
  
  public static FilamentFilterManager getInstance()
  {
    return INSTANCE;
  }
  
  public FilamentFilter getFilter()
  {
    return this.filter;
  }
  
  public void setFilter(FilamentFilter paramFilamentFilter)
  {
    this.filter = paramFilamentFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilterManager
 * JD-Core Version:    0.7.0.1
 */