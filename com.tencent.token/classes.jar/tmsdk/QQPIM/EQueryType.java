package tmsdk.QQPIM;

public final class EQueryType
{
  public static final EQueryType E_QUERY_ALL;
  public static final EQueryType E_QUERY_MAX = new EQueryType(4, 4, "E_QUERY_MAX");
  public static final EQueryType E_QUERY_MIN;
  public static final EQueryType E_QUERY_MONEY;
  public static final EQueryType E_QUERY_TRAFFIC;
  public static final int _E_QUERY_ALL = 1;
  public static final int _E_QUERY_MAX = 4;
  public static final int _E_QUERY_MIN = 0;
  public static final int _E_QUERY_MONEY = 3;
  public static final int _E_QUERY_TRAFFIC = 2;
  private static EQueryType[] es = new EQueryType[5];
  private int eb;
  private String ec = new String();
  
  static
  {
    E_QUERY_MIN = new EQueryType(0, 0, "E_QUERY_MIN");
    E_QUERY_ALL = new EQueryType(1, 1, "E_QUERY_ALL");
    E_QUERY_TRAFFIC = new EQueryType(2, 2, "E_QUERY_TRAFFIC");
    E_QUERY_MONEY = new EQueryType(3, 3, "E_QUERY_MONEY");
  }
  
  private EQueryType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    es[paramInt1] = this;
  }
  
  public static EQueryType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EQueryType[] arrayOfEQueryType = es;
      if (i >= arrayOfEQueryType.length) {
        break;
      }
      if (arrayOfEQueryType[i].value() == paramInt) {
        return es[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EQueryType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EQueryType[] arrayOfEQueryType = es;
      if (i >= arrayOfEQueryType.length) {
        break;
      }
      if (arrayOfEQueryType[i].toString().equals(paramString)) {
        return es[i];
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    return this.ec;
  }
  
  public int value()
  {
    return this.eb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.EQueryType
 * JD-Core Version:    0.7.0.1
 */