package com.tencent.qqmail.permission;

class Permission
{
  public final boolean granted;
  public final String name;
  
  public Permission(String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.granted = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (Permission)paramObject;
      bool1 = bool2;
    } while (this.granted != paramObject.granted);
    return this.name.equals(paramObject.name);
  }
  
  public int hashCode()
  {
    int j = this.name.hashCode();
    if (this.granted) {}
    for (int i = 1;; i = 0) {
      return i + j * 31;
    }
  }
  
  public String toString()
  {
    return "Permission{name='" + this.name + '\'' + ", granted=" + this.granted + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.Permission
 * JD-Core Version:    0.7.0.1
 */