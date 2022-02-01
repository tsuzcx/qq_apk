package com.tencent.viola.ui.baseComponent;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.DomObject;
import java.lang.reflect.InvocationTargetException;

public abstract interface ComponentCreator
{
  public abstract VComponent createInstance(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
    throws IllegalAccessException, InvocationTargetException, InstantiationException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentCreator
 * JD-Core Version:    0.7.0.1
 */