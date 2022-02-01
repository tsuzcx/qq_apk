import com.tencent.qphone.base.util.QLog;

public class avkc
{
  private static int exi;
  private final boolean dnl = true;
  private int exj = 3;
  private String mTag;
  
  static
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    for (;;)
    {
      if (i < arrayOfStackTraceElement.length)
      {
        if (avkc.class.getName().equals(arrayOfStackTraceElement[i].getClassName())) {
          exi = i;
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private StringBuilder a(int paramInt)
  {
    return new StringBuilder();
  }
  
  private void b(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        localStringBuilder = a(paramInt3);
        if (paramString2 != null) {
          localStringBuilder.append(paramString2);
        }
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = this.mTag;
        }
        switch (paramInt2)
        {
        default: 
          return;
        }
      }
      finally {}
      if (!QLog.isDevelopLevel())
      {
        continue;
        if (!QLog.isColorLevel())
        {
          continue;
          QLog.e(paramString2, paramInt1, localStringBuilder.toString());
          continue;
          QLog.w(paramString2, paramInt1, localStringBuilder.toString());
          continue;
          QLog.i(paramString2, paramInt1, localStringBuilder.toString());
          continue;
          QLog.d(paramString2, paramInt1, localStringBuilder.toString());
        }
      }
    }
  }
  
  public avkc a(String paramString)
  {
    this.mTag = paramString;
    return this;
  }
  
  public avkc a(String paramString1, int paramInt, String paramString2)
  {
    b(paramString1, paramInt, 3, paramString2, this.exj);
    return this;
  }
  
  public final void abJ(int paramInt)
  {
    this.exj = paramInt;
  }
  
  public avkc b(String paramString1, int paramInt, String paramString2)
  {
    b(paramString1, paramInt, 4, paramString2, this.exj);
    return this;
  }
  
  public avkc c(String paramString1, int paramInt, String paramString2)
  {
    b(paramString1, paramInt, 6, paramString2, this.exj);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avkc
 * JD-Core Version:    0.7.0.1
 */