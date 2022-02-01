package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;

public abstract class ControlFrame
  extends FramedataImpl1
{
  public ControlFrame(Opcode paramOpcode)
  {
    super(paramOpcode);
  }
  
  public void isValid()
    throws InvalidDataException
  {
    if (!isFin()) {
      throw new InvalidFrameException("Control frame cant have fin==false set");
    }
    if (isRSV1()) {
      throw new InvalidFrameException("Control frame cant have rsv1==true set");
    }
    if (isRSV2()) {
      throw new InvalidFrameException("Control frame cant have rsv2==true set");
    }
    if (isRSV3()) {
      throw new InvalidFrameException("Control frame cant have rsv3==true set");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.framing.ControlFrame
 * JD-Core Version:    0.7.0.1
 */