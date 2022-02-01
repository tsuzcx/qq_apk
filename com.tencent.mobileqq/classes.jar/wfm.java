import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class wfm<Respond extends wfh>
{
  public int a;
  public long a;
  public wfn<Respond> a;
  public int b;
  private int c;
  
  public wfm()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 2;
  }
  
  @NonNull
  public static List<ByteStringMicro> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramList.next()));
    }
    return localArrayList;
  }
  
  public abstract String a();
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public abstract wfh a(byte[] paramArrayOfByte);
  
  public wfn<Respond> a()
  {
    return this.jdField_a_of_type_Wfn;
  }
  
  public void a(wfn<Respond> paramwfn)
  {
    this.jdField_a_of_type_Wfn = paramwfn;
  }
  
  protected abstract byte[] a();
  
  public int b()
  {
    int i = this.c;
    String str = a();
    int j = i;
    if (i == 0)
    {
      j = i;
      if (str.length() > 0)
      {
        j = 0;
        while (j < str.length())
        {
          i = i * 31 + str.charAt(j);
          j += 1;
        }
        this.c = i;
        j = i;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfm
 * JD-Core Version:    0.7.0.1
 */