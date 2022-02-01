package org.apache.commons.cli;

import java.util.Iterator;
import java.util.List;

public class MissingOptionException
  extends ParseException
{
  private List missingOptions;
  
  public MissingOptionException(String paramString)
  {
    super(paramString);
  }
  
  public MissingOptionException(List paramList)
  {
    this(createMessage(paramList));
    this.missingOptions = paramList;
  }
  
  private static String createMessage(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer("Missing required option");
    if (paramList.size() == 1) {}
    for (String str = "";; str = "s")
    {
      localStringBuffer.append(str);
      localStringBuffer.append(": ");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localStringBuffer.append(paramList.next());
        if (paramList.hasNext()) {
          localStringBuffer.append(", ");
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public List getMissingOptions()
  {
    return this.missingOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.MissingOptionException
 * JD-Core Version:    0.7.0.1
 */