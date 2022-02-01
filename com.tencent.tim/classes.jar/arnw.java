public abstract interface arnw
{
  public abstract arnw.a getCodec(String paramString);
  
  public abstract int send(Object paramObject);
  
  public abstract void setNetTransportEventListener(String paramString, arnw.b paramb);
  
  public static abstract interface a
  {
    public abstract Object decode(Object paramObject);
    
    public abstract Object encode(Object paramObject);
  }
  
  public static abstract interface b
  {
    public abstract void f(Object paramObject1, Object paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnw
 * JD-Core Version:    0.7.0.1
 */