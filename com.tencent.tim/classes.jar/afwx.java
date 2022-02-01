import com.tencent.qphone.base.util.QLog;

public class afwx
{
  private afwx.a jdField_a_of_type_Afwx$a;
  private afwx.b jdField_a_of_type_Afwx$b;
  private afwx.c jdField_a_of_type_Afwx$c;
  private afwx.d jdField_a_of_type_Afwx$d;
  
  public afwx(afwh paramafwh)
  {
    this.jdField_a_of_type_Afwx$d = new afwx.d(this, paramafwh);
    this.jdField_a_of_type_Afwx$c = new afwx.c(this, paramafwh);
    this.jdField_a_of_type_Afwx$b = new afwx.b(this, paramafwh);
    this.jdField_a_of_type_Afwx$a = this.jdField_a_of_type_Afwx$d;
  }
  
  public int DK()
  {
    return this.jdField_a_of_type_Afwx$a.id;
  }
  
  public void Ny(int paramInt)
  {
    hW(paramInt, -1);
  }
  
  public afwx.a a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Afwx$b;
    case 0: 
      return this.jdField_a_of_type_Afwx$d;
    }
    return this.jdField_a_of_type_Afwx$c;
  }
  
  public void hV(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Afwx$a.id)
    {
      afwx.a locala = a(paramInt1);
      if (locala != null)
      {
        this.jdField_a_of_type_Afwx$a.onEnd();
        this.jdField_a_of_type_Afwx$a = locala;
        this.jdField_a_of_type_Afwx$a.onStart(paramInt2);
      }
    }
  }
  
  public void hW(int paramInt1, int paramInt2)
  {
    hX(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Afwx$a.id;
    if ((!this.jdField_a_of_type_Afwx$a.aU(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
      QLog.e("LimitChatUiStateMachine", 2, "state " + i + " not handle event " + paramInt1 + ", subEvent " + paramInt2);
    }
  }
  
  public void hX(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Afwx$a.id == 0);
    this.jdField_a_of_type_Afwx$a.ddy();
    this.jdField_a_of_type_Afwx$a = this.jdField_a_of_type_Afwx$d;
    this.jdField_a_of_type_Afwx$a.onStart(-1);
  }
  
  public static class a
  {
    protected afwh b;
    protected afwx b;
    public int id = -1;
    
    public a(afwx paramafwx, afwh paramafwh)
    {
      this.jdField_b_of_type_Afwh = paramafwh;
      this.jdField_b_of_type_Afwx = paramafwx;
    }
    
    public boolean aU(int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUiStateMachine", 2, "state " + this.id + " start handle event " + paramInt1 + ", subEvent " + paramInt2);
      }
      return false;
    }
    
    public void ddy()
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUiStateMachine", 2, "state " + this.id + " onForceEnd");
      }
    }
    
    public void onEnd()
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUiStateMachine", 2, "state " + this.id + " onEnd");
      }
    }
    
    public void onStart(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUiStateMachine", 2, "state " + this.id + " onStart subinfo:" + paramInt);
      }
    }
  }
  
  public static class b
    extends afwx.a
  {
    public b(afwx paramafwx, afwh paramafwh)
    {
      super(paramafwh);
      this.id = -1;
    }
  }
  
  public static class c
    extends afwx.a
  {
    public c(afwx paramafwx, afwh paramafwh)
    {
      super(paramafwh);
      this.id = 2;
    }
    
    public boolean aU(int paramInt1, int paramInt2)
    {
      super.aU(paramInt1, paramInt2);
      switch (paramInt1)
      {
      default: 
        return false;
      case 103: 
        this.jdField_b_of_type_Afwh.a().apK();
      case 104: 
        this.jdField_b_of_type_Afwx.hV(0, paramInt2);
      case 105: 
        for (;;)
        {
          return true;
          this.jdField_b_of_type_Afwx.hV(0, paramInt2);
        }
      }
      this.jdField_b_of_type_Afwh.a().apK();
      this.jdField_b_of_type_Afwx.hV(0, paramInt2);
      this.jdField_b_of_type_Afwx.hW(paramInt1, paramInt2);
      return false;
    }
    
    public void ddy()
    {
      super.ddy();
      this.jdField_b_of_type_Afwh.a().apK();
    }
    
    public void onStart(int paramInt)
    {
      super.onStart(paramInt);
      this.jdField_b_of_type_Afwh.dde();
      this.jdField_b_of_type_Afwh.a().NB(paramInt);
    }
  }
  
  public static class d
    extends afwx.a
  {
    public d(afwx paramafwx, afwh paramafwh)
    {
      super(paramafwh);
      this.id = 0;
    }
    
    public boolean aU(int paramInt1, int paramInt2)
    {
      super.aU(paramInt1, paramInt2);
      switch (paramInt1)
      {
      default: 
        return false;
      }
      this.jdField_b_of_type_Afwx.hV(2, paramInt2);
      return true;
    }
    
    public void onStart(int paramInt)
    {
      super.onStart(paramInt);
      this.jdField_b_of_type_Afwh.dde();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwx
 * JD-Core Version:    0.7.0.1
 */