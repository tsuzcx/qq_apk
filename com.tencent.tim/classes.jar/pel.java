public class pel<T>
{
  private int auE;
  private boolean ayN;
  private boolean fV;
  private T mData;
  private String mMsg;
  private int mPos;
  private int mTop;
  
  private pel(int paramInt)
  {
    this.auE = paramInt;
  }
  
  public static <T> pel<T> a()
  {
    return new pel(0);
  }
  
  public static <T> pel<T> a(int paramInt1, int paramInt2)
  {
    return new pel(5).a(paramInt1).b(paramInt2);
  }
  
  public static <T> pel<T> a(String paramString)
  {
    return new pel(4).b(paramString);
  }
  
  public static <T> pel<T> a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 3) {
      return new pel(i);
    }
  }
  
  public static <T> pel<T> b()
  {
    return new pel(1);
  }
  
  public boolean HU()
  {
    return this.fV;
  }
  
  public boolean HV()
  {
    return this.ayN;
  }
  
  public pel<T> a(int paramInt)
  {
    this.mPos = paramInt;
    return this;
  }
  
  public pel<T> a(boolean paramBoolean, T paramT)
  {
    this.ayN = paramBoolean;
    this.mData = paramT;
    return this;
  }
  
  public pel<T> b(int paramInt)
  {
    this.mTop = paramInt;
    return this;
  }
  
  public pel<T> b(String paramString)
  {
    this.mMsg = paramString;
    return this;
  }
  
  public pel<T> b(boolean paramBoolean)
  {
    this.ayN = paramBoolean;
    return this;
  }
  
  public pel<T> c(boolean paramBoolean)
  {
    this.fV = paramBoolean;
    return this;
  }
  
  public T getData()
  {
    return this.mData;
  }
  
  public String getMsg()
  {
    return this.mMsg;
  }
  
  public int getPos()
  {
    return this.mPos;
  }
  
  public int getState()
  {
    return this.auE;
  }
  
  public int getTop()
  {
    return this.mTop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pel
 * JD-Core Version:    0.7.0.1
 */