package com.idlefish.flutterboost.interfaces;

public abstract interface IContainerManager
{
  public abstract IFlutterViewContainer findContainerById(String paramString);
  
  public abstract IOperateSyncer generateSyncer(IFlutterViewContainer paramIFlutterViewContainer);
  
  public abstract IContainerRecord getCurrentTopRecord();
  
  public abstract IContainerRecord getLastGenerateRecord();
  
  public abstract boolean hasContainerAppear();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.interfaces.IContainerManager
 * JD-Core Version:    0.7.0.1
 */