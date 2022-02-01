package org.apache.commons.io.input;

public class TailerListenerAdapter
  implements TailerListener
{
  public void endOfFileReached() {}
  
  public void fileNotFound() {}
  
  public void fileRotated() {}
  
  public void handle(Exception paramException) {}
  
  public void handle(String paramString) {}
  
  public void init(Tailer paramTailer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.TailerListenerAdapter
 * JD-Core Version:    0.7.0.1
 */