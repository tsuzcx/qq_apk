import com.tencent.mobileqq.app.QQAppInterface;

public class aozx
{
  public aozy b = new aozy();
  public String frienduin;
  public int uinType = -1;
  
  public aozx()
  {
    clear();
  }
  
  public aozx(aozx paramaozx)
  {
    if (paramaozx != null)
    {
      this.b.a(paramaozx.b);
      return;
    }
    clear();
  }
  
  public static final boolean bq(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 == 11) {
      i = 31;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 11) {
      paramInt1 = 31;
    }
    if ((i == 2) || (i == 16)) {
      if (i + 1 < paramInt1) {}
    }
    while (i >= paramInt1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public int Lc()
  {
    if ((this.b.has()) && (apnt.mb(this.b.bizType))) {
      return this.b.bizType;
    }
    return 0;
  }
  
  public int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return b(paramQQAppInterface, true, paramString);
    }
    return Lc();
  }
  
  public aozx a(aozx paramaozx)
  {
    if (paramaozx != null) {
      this.b.a(paramaozx.b);
    }
    return this;
  }
  
  public boolean aAH()
  {
    return this.b.has();
  }
  
  public int b(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (this.b.has()) {
      return this.b.bizType;
    }
    return 0;
  }
  
  public void clear()
  {
    this.b.clear();
  }
  
  public long getShmsgseq()
  {
    if (this.b.has()) {
      return this.b.shmsgseq;
    }
    return -1L;
  }
  
  public long ho()
  {
    if ((this.b.has()) && (apnt.mb(this.b.bizType))) {
      return this.b.shmsgseq;
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozx
 * JD-Core Version:    0.7.0.1
 */