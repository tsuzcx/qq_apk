package com.facebook.stetho;

import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;

public abstract interface InspectorModulesProvider
{
  public abstract Iterable<ChromeDevtoolsDomain> get();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.InspectorModulesProvider
 * JD-Core Version:    0.7.0.1
 */