package com.tencent.qqmail.utilities.translate;

public class ClientTranslateHandlerFactory
  extends TranslateHandlerFactory
{
  public ITranslateHandler createTranslateHandler()
  {
    return ClientTranslateHandler.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.translate.ClientTranslateHandlerFactory
 * JD-Core Version:    0.7.0.1
 */