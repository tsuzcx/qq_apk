public class itn
{
  public int fps;
  public int height;
  public long intervalTime = 67L;
  public int width;
  
  public boolean a(itn paramitn)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramitn == null) || (!paramitn.isValid()))
    {
      bool2 = false;
      return bool2;
    }
    if (this.width != paramitn.width)
    {
      this.width = paramitn.width;
      bool1 = true;
    }
    if (this.height != paramitn.height)
    {
      this.height = paramitn.height;
      bool1 = bool2;
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.fps == paramitn.fps) {
        break;
      }
      this.fps = paramitn.fps;
      if (this.fps == 0) {
        this.fps = 15;
      }
      this.intervalTime = (1000 / this.fps);
      return bool1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label71:
    label74:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof itn)) {
        break;
      }
      paramObject = (itn)paramObject;
      if (this.width == paramObject.width)
      {
        i = 1;
        if ((i == 0) || (this.height != paramObject.height)) {
          break label71;
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (this.fps == paramObject.fps)) {
          break label74;
        }
        return false;
        i = 0;
        break;
      }
    }
    return false;
  }
  
  public boolean isValid()
  {
    return (this.width != 0) && (this.height != 0) && (this.fps != 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParam{").append("width: ").append(this.width).append(", height: ").append(this.height).append(", fps: ").append(this.fps).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itn
 * JD-Core Version:    0.7.0.1
 */