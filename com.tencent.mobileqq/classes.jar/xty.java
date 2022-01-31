import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class xty
{
  public int a;
  public ArrayList<xtz> a;
  public int b;
  public int c;
  public int d;
  
  public xty()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public xty(String paramString)
  {
    a(paramString);
  }
  
  public static xty a(int paramInt, String paramString)
  {
    long l;
    byte[] arrayOfByte;
    Object localObject;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
      if (paramString != null)
      {
        l = Long.parseLong(paramString);
        paramString = new xty();
        paramString.jdField_a_of_type_Int = 1;
        paramString.b = 1;
        paramString.c = paramInt;
        paramString.d = 0;
        paramString.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        arrayOfByte = xxb.a(l);
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
      localObject = new xtz(paramInt, (short)4, arrayOfByte);
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
      for (int i = 4;; i = ((xtz)((Iterator)localObject1).next()).a() + i)
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
        xtz localxtz = (xtz)((Iterator)localObject2).next();
        ((ByteBuffer)localObject1).put((byte)localxtz.jdField_a_of_type_Int);
        ((ByteBuffer)localObject1).putShort(localxtz.jdField_a_of_type_Short);
        ((ByteBuffer)localObject1).put(localxtz.jdField_a_of_type_ArrayOfByte);
      }
    }
    ((ByteBuffer)localObject1).flip();
    Object localObject2 = new byte[((ByteBuffer)localObject1).limit()];
    ((ByteBuffer)localObject1).get((byte[])localObject2);
    return bdcv.a((byte[])localObject2);
  }
  
  public xtz a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return (xtz)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    Object localObject = bdcv.a(paramString);
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
      localObject = new xtz();
      ((xtz)localObject).jdField_a_of_type_Int = paramString.get();
      byte[] arrayOfByte = new byte[2];
      paramString.get(arrayOfByte);
      ((xtz)localObject).jdField_a_of_type_Short = xxb.a(arrayOfByte);
      arrayOfByte = new byte[((xtz)localObject).jdField_a_of_type_Short];
      paramString.get(arrayOfByte);
      ((xtz)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xty
 * JD-Core Version:    0.7.0.1
 */