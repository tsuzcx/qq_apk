import com.tencent.qphone.base.util.QLog;

public class ilo
{
  private static volatile ilo jdField_a_of_type_Ilo;
  private ilo.a[] jdField_a_of_type_ArrayOfIlo$a = new ilo.a[4];
  private Object av = new Object();
  
  public static ilo a()
  {
    if (jdField_a_of_type_Ilo == null) {}
    try
    {
      if (jdField_a_of_type_Ilo == null) {
        jdField_a_of_type_Ilo = new ilo();
      }
      return jdField_a_of_type_Ilo;
    }
    finally {}
  }
  
  public void bB(int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject1 = this.av;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfIlo$a.length)
        {
          if (this.jdField_a_of_type_ArrayOfIlo$a[i].state == paramInt1)
          {
            this.jdField_a_of_type_ArrayOfIlo$a[i].state = paramInt2;
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            QLog.i("FrameBufMgr", 1, "setFrameBufState failed. oldState = " + paramInt1 + ", newState = " + paramInt2);
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public byte[] c(int paramInt)
  {
    Object localObject1 = this.av;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfIlo$a.length)
        {
          if (this.jdField_a_of_type_ArrayOfIlo$a[i].state == paramInt)
          {
            byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfIlo$a[i].buf;
            return arrayOfByte;
          }
        }
        else
        {
          QLog.i("FrameBufMgr", 1, "getFrameBufByState failed. state = " + paramInt);
          return null;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void clear()
  {
    int i = 0;
    QLog.i("FrameBufMgr", 1, "clear.");
    for (;;)
    {
      synchronized (this.av)
      {
        if (i < this.jdField_a_of_type_ArrayOfIlo$a.length)
        {
          if (this.jdField_a_of_type_ArrayOfIlo$a[i] != null)
          {
            this.jdField_a_of_type_ArrayOfIlo$a[i].buf = null;
            this.jdField_a_of_type_ArrayOfIlo$a[i].state = 0;
          }
        }
        else {
          return;
        }
      }
      i += 1;
    }
  }
  
  public boolean cn(int paramInt)
  {
    int i = 0;
    QLog.i("FrameBufMgr", 1, "init. bufSize = " + paramInt);
    synchronized (this.av)
    {
      while (i < this.jdField_a_of_type_ArrayOfIlo$a.length)
      {
        if (this.jdField_a_of_type_ArrayOfIlo$a[i] == null) {
          this.jdField_a_of_type_ArrayOfIlo$a[i] = new ilo.a();
        }
        if ((this.jdField_a_of_type_ArrayOfIlo$a[i].buf == null) || (this.jdField_a_of_type_ArrayOfIlo$a[i].buf.length != paramInt)) {
          this.jdField_a_of_type_ArrayOfIlo$a[i].buf = new byte[paramInt];
        }
        this.jdField_a_of_type_ArrayOfIlo$a[i].state = 0;
        i += 1;
      }
      return true;
    }
  }
  
  public void d(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = this.av;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfIlo$a.length)
        {
          if (this.jdField_a_of_type_ArrayOfIlo$a[i].buf == paramArrayOfByte) {
            this.jdField_a_of_type_ArrayOfIlo$a[i].state = paramInt;
          }
        }
        else
        {
          QLog.i("FrameBufMgr", 1, "setFrameBufState failed. dataBuf = " + paramArrayOfByte + ", state = " + paramInt);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public int lc()
  {
    return this.jdField_a_of_type_ArrayOfIlo$a.length;
  }
  
  public class a
  {
    public byte[] buf;
    public int state = 0;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilo
 * JD-Core Version:    0.7.0.1
 */