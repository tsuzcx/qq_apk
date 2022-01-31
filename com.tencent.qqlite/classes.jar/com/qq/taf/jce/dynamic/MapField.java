package com.qq.taf.jce.dynamic;

public final class MapField
  extends JceField
{
  private JceField[] keys;
  private JceField[] values;
  
  MapField(JceField[] paramArrayOfJceField1, JceField[] paramArrayOfJceField2, int paramInt)
  {
    super(paramInt);
    this.keys = paramArrayOfJceField1;
    this.values = paramArrayOfJceField2;
  }
  
  public JceField getKey(int paramInt)
  {
    return this.keys[paramInt];
  }
  
  public JceField[] getKeys()
  {
    return this.keys;
  }
  
  public JceField getValue(int paramInt)
  {
    return this.values[paramInt];
  }
  
  public JceField[] getValues()
  {
    return this.values;
  }
  
  public void setKey(int paramInt, JceField paramJceField)
  {
    this.keys[paramInt] = paramJceField;
  }
  
  public void setValue(int paramInt, JceField paramJceField)
  {
    this.values[paramInt] = paramJceField;
  }
  
  public int size()
  {
    return this.keys.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.MapField
 * JD-Core Version:    0.7.0.1
 */