public abstract class ifc
{
  private static ien b;
  
  public static ien a()
  {
    try
    {
      if (b == null) {
        b = new ien();
      }
      return b;
    }
    finally {}
  }
  
  public static boolean si()
  {
    return b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifc
 * JD-Core Version:    0.7.0.1
 */