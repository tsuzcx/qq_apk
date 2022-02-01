package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;

public class BinaryFrame
  extends DataFrame
{
  public BinaryFrame()
  {
    super(Opcode.BINARY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.framing.BinaryFrame
 * JD-Core Version:    0.7.0.1
 */