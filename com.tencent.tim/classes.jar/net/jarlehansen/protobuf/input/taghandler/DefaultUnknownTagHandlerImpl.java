package net.jarlehansen.protobuf.input.taghandler;

public class DefaultUnknownTagHandlerImpl
  implements UnknownTagHandler
{
  public static DefaultUnknownTagHandlerImpl newInstance()
  {
    return new DefaultUnknownTagHandlerImpl();
  }
  
  public void unknownTag(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.input.taghandler.DefaultUnknownTagHandlerImpl
 * JD-Core Version:    0.7.0.1
 */