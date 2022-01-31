import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class vsn
{
  public int a;
  public ArrayList<vso> a;
  public int b;
  public int c;
  public int d;
  
  public vsn()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public vsn(String paramString)
  {
    a(paramString);
  }
  
  public static vsn a(int paramInt, String paramString)
  {
    long l;
    byte[] arrayOfByte;
    Object localObject;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
      if (paramString != null)
      {
        l = Long.parseLong(paramString);
        paramString = new vsn();
        paramString.jdField_a_of_type_Int = 1;
        paramString.b = 1;
        paramString.c = paramInt;
        paramString.d = 0;
        paramString.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        arrayOfByte = vvp.a(l);
        localObject = ByteBuffer.allocate(4);
        ((ByteBuffer)localObject).put(arrayOfByte, 4, 4);
        ((ByteBuffer)localObject).flip();
        arrayOfByte = new byte[((ByteBuffer)localObject).limit()];
        ((ByteBuffer)localObject).get(arrayOfByte);
        if (paramInt != 2) {
          break label145;
        }
        paramInt = 2;
      }
    }
    for (;;)
    {
      localObject = new vso(paramInt, (short)4, arrayOfByte);
      paramString.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return paramString;
      l = 0L;
      break;
      label145:
      if (paramInt == 3)
      {
        paramInt = 7;
        continue;
        return null;
      }
      else
      {
        paramInt = 1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (int i = 4;; i = ((vso)((Iterator)localObject1).next()).a() + i)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      }
    }
    int j = 4;
    Object localObject1 = ByteBuffer.allocate(j);
    ((ByteBuffer)localObject1).put((byte)this.jdField_a_of_type_Int);
    ((ByteBuffer)localObject1).put((byte)this.b);
    ((ByteBuffer)localObject1).put((byte)this.c);
    ((ByteBuffer)localObject1).put((byte)this.d);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      ((ByteBuffer)localObject1).put((byte)this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        vso localvso = (vso)((Iterator)localObject2).next();
        ((ByteBuffer)localObject1).put((byte)localvso.jdField_a_of_type_Int);
        ((ByteBuffer)localObject1).putShort(localvso.jdField_a_of_type_Short);
        ((ByteBuffer)localObject1).put(localvso.jdField_a_of_type_ArrayOfByte);
      }
    }
    ((ByteBuffer)localObject1).flip();
    Object localObject2 = new byte[((ByteBuffer)localObject1).limit()];
    ((ByteBuffer)localObject1).get((byte[])localObject2);
    return bach.a((byte[])localObject2);
  }
  
  public vso a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return (vso)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    Object localObject = bach.a(paramString);
    paramString = ByteBuffer.allocate(localObject.length);
    paramString.put((byte[])localObject);
    paramString.flip();
    this.jdField_a_of_type_Int = paramString.get();
    this.b = paramString.get();
    this.c = paramString.get();
    this.d = paramString.get();
    int j = paramString.get();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localObject = new vso();
      ((vso)localObject).jdField_a_of_type_Int = paramString.get();
      byte[] arrayOfByte = new byte[2];
      paramString.get(arrayOfByte);
      ((vso)localObject).jdField_a_of_type_Short = vvp.a(arrayOfByte);
      arrayOfByte = new byte[((vso)localObject).jdField_a_of_type_Short];
      paramString.get(arrayOfByte);
      ((vso)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     vsn
 * JD-Core Version:    0.7.0.1
 */