package com.qq.taf.jce.dynamic;

public final class ListField
  extends JceField
{
  private JceField[] data;
  
  ListField(JceField[] paramArrayOfJceField, int paramInt)
  {
    super(paramInt);
    this.data = paramArrayOfJceField;
  }
  
  public JceField get(int paramInt)
  {
    return this.data[paramInt];
  }
  
  public JceField[] get()
  {
    return this.data;
  }
  
  public void set(int paramInt, JceField paramJceField)
  {
    this.data[paramInt] = paramJceField;
  }
  
  public void set(JceField[] paramArrayOfJceField)
  {
    this.data = paramArrayOfJceField;
  }
  
  public int size()
  {
    return this.data.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.ListField
 * JD-Core Version:    0.7.0.1
 */