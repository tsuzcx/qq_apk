import java.util.Comparator;
import java.util.List;

public class aeyq<T>
{
  private final aeyq.a<T> jdField_a_of_type_Aeyq$a;
  private final aeyq.b jdField_a_of_type_Aeyq$b;
  private final Comparator<T> mComparator;
  private int mSize;
  
  public aeyq(Comparator<T> paramComparator, aeyq.b<T> paramb)
  {
    this.jdField_a_of_type_Aeyq$b = paramb;
    this.jdField_a_of_type_Aeyq$a = new aeyq.a();
    this.mComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, aeyq.a<T> parama)
  {
    if ((aewr.a().a().isDebug()) && ((paramList == null) || (paramList.isEmpty())) && (!isEmpty()) && ((parama.mData instanceof aexe)))
    {
      paramList = (aexe)parama.mData;
      long l = Math.abs(paramList.getTime() - paramLong);
      if (l > 60000L) {
        aeyw.w("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    aeyq.a locala = this.jdField_a_of_type_Aeyq$a.b;
    int j;
    for (int i = 0; (i < paramInt) && (locala != this.jdField_a_of_type_Aeyq$a) && (this.jdField_a_of_type_Aeyq$b.a(locala.mData, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(locala.mData);
        j = i + 1;
      }
      this.mSize -= 1;
      locala = locala.b;
    }
    a(paramLong, paramList, locala);
    this.jdField_a_of_type_Aeyq$a.b = locala;
    locala.c = this.jdField_a_of_type_Aeyq$a;
    return paramList;
  }
  
  public void clear()
  {
    this.jdField_a_of_type_Aeyq$a.b = this.jdField_a_of_type_Aeyq$a;
    this.jdField_a_of_type_Aeyq$a.c = this.jdField_a_of_type_Aeyq$a;
    this.mSize = 0;
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_Aeyq$a.b == this.jdField_a_of_type_Aeyq$a;
  }
  
  public boolean n(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (aeyq.a locala = this.jdField_a_of_type_Aeyq$a.c; (locala != this.jdField_a_of_type_Aeyq$a) && (this.mComparator.compare(locala.mData, paramT) > 0); locala = locala.c) {}
    if (paramT.equals(locala.mData)) {
      return false;
    }
    paramT = new aeyq.a(paramT, locala.b, locala);
    locala.b.c = paramT;
    locala.b = paramT;
    this.mSize += 1;
    return true;
  }
  
  public boolean o(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (aeyq.a locala = this.jdField_a_of_type_Aeyq$a.b; (locala != this.jdField_a_of_type_Aeyq$a) && (this.mComparator.compare(locala.mData, paramT) < 0); locala = locala.b) {}
    if (paramT.equals(locala.mData)) {
      return false;
    }
    paramT = new aeyq.a(paramT, locala, locala.c);
    locala.c.b = paramT;
    locala.c = paramT;
    this.mSize += 1;
    return true;
  }
  
  public T peekFirst()
  {
    return this.jdField_a_of_type_Aeyq$a.b.mData;
  }
  
  public T peekLast()
  {
    aeyq.a locala = this.jdField_a_of_type_Aeyq$a.c;
    if (locala != this.jdField_a_of_type_Aeyq$a) {
      return locala.mData;
    }
    return null;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  static final class a<T>
  {
    public a<T> b;
    public a<T> c;
    public final T mData;
    
    public a()
    {
      this.mData = null;
      this.b = this;
      this.c = this;
    }
    
    public a(T paramT, a<T> parama1, a<T> parama2)
    {
      this.mData = paramT;
      this.b = parama1;
      this.c = parama2;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract int a(T paramT, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyq
 * JD-Core Version:    0.7.0.1
 */