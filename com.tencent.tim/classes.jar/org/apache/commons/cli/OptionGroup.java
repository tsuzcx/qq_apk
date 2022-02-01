package org.apache.commons.cli;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OptionGroup
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Map optionMap = new HashMap();
  private boolean required;
  private String selected;
  
  public OptionGroup addOption(Option paramOption)
  {
    this.optionMap.put(paramOption.getKey(), paramOption);
    return this;
  }
  
  public Collection getNames()
  {
    return this.optionMap.keySet();
  }
  
  public Collection getOptions()
  {
    return this.optionMap.values();
  }
  
  public String getSelected()
  {
    return this.selected;
  }
  
  public boolean isRequired()
  {
    return this.required;
  }
  
  public void setRequired(boolean paramBoolean)
  {
    this.required = paramBoolean;
  }
  
  public void setSelected(Option paramOption)
    throws AlreadySelectedException
  {
    if ((this.selected == null) || (this.selected.equals(paramOption.getOpt())))
    {
      this.selected = paramOption.getOpt();
      return;
    }
    throw new AlreadySelectedException(this, paramOption);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = getOptions().iterator();
    localStringBuffer.append("[");
    if (localIterator.hasNext())
    {
      Option localOption = (Option)localIterator.next();
      if (localOption.getOpt() != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(localOption.getOpt());
      }
      for (;;)
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(localOption.getDescription());
        if (!localIterator.hasNext()) {
          break;
        }
        localStringBuffer.append(", ");
        break;
        localStringBuffer.append("--");
        localStringBuffer.append(localOption.getLongOpt());
      }
    }
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.OptionGroup
 * JD-Core Version:    0.7.0.1
 */