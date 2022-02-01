package com.tencent.viola.ui.view;

import com.tencent.viola.ui.baseComponent.VComponent;

public abstract interface IVView<T extends VComponent>
{
  public abstract void bindComponent(T paramT);
  
  public abstract T getComponent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.IVView
 * JD-Core Version:    0.7.0.1
 */