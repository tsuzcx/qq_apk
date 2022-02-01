import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class zrs
{
  public int a;
  public ArrayList<zrt> a;
  public int b;
  public int c;
  public int d;
  
  public zrs()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public zrs(String paramString)
  {
    a(paramString);
  }
  
  public static zrs a(int paramInt, String paramString)
  {
    long l;
    byte[] arrayOfByte;
    Object localObject;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
      if (paramString != null)
      {
        l = Long.parseLong(paramString);
        paramString = new zrs();
        paramString.jdField_a_of_type_Int = 1;
        paramString.b = 1;
        paramString.c = paramInt;
        paramString.d = 0;
        paramString.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        arrayOfByte = zvc.a(l);
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
      localObject = new zrt(paramInt, (short)4, arrayOfByte);
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
      for (int i = 4;; i = ((zrt)((Iterator)localObject1).next()).a() + i)
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
        zrt localzrt = (zrt)((Iterator)localObject2).next();
        ((ByteBuffer)localObject1).put((byte)localzrt.jdField_a_of_type_Int);
        ((ByteBuffer)localObject1).putShort(localzrt.jdField_a_of_type_Short);
        ((ByteBuffer)localObject1).put(localzrt.jdField_a_of_type_ArrayOfByte);
      }
    }
    ((ByteBuffer)localObject1).flip();
    Object localObject2 = new byte[((ByteBuffer)localObject1).limit()];
    ((ByteBuffer)localObject1).get((byte[])localObject2);
    return bgmj.a((byte[])localObject2);
  }
  
  public zrt a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return (zrt)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    Object localObject = bgmj.a(paramString);
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
      localObject = new zrt();
      ((zrt)localObject).jdField_a_of_type_Int = paramString.get();
      byte[] arrayOfByte = new byte[2];
      paramString.get(arrayOfByte);
      ((zrt)localObject).jdField_a_of_type_Short = zvc.a(arrayOfByte);
      arrayOfByte = new byte[((zrt)localObject).jdField_a_of_type_Short];
      paramString.get(arrayOfByte);
      ((zrt)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrs
 * JD-Core Version:    0.7.0.1
 */