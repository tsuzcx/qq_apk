package com.tencent.qqmail.utilities.translate;

public class ServerTranslateHandlerFactory
  extends TranslateHandlerFactory
{
  public ITranslateHandler createTranslateHandler()
  {
    return ServerTranslateHandler.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.translate.ServerTranslateHandlerFactory
 * JD-Core Version:    0.7.0.1
 */