package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;

public abstract class DataFrame
  extends FramedataImpl1
{
  public DataFrame(Opcode paramOpcode)
  {
    super(paramOpcode);
  }
  
  public void isValid()
    throws InvalidDataException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.framing.DataFrame
 * JD-Core Version:    0.7.0.1
 */