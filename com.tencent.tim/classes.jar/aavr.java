import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;

public final class aavr
  implements aawe
{
  private aawc jdField_a_of_type_Aawc;
  private aawd jdField_a_of_type_Aawd;
  private aawg jdField_a_of_type_Aawg;
  private aawd b;
  private boolean mSelectable = true;
  
  private aavp b()
  {
    aavp localaavp = aavp.a();
    if (this != localaavp.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localaavp;
  }
  
  public void Ci(int paramInt)
  {
    aavp.a().Ci(paramInt);
  }
  
  public void Di(boolean paramBoolean)
  {
    b().Di(paramBoolean);
  }
  
  public void GF(int paramInt)
  {
    b().GF(paramInt);
  }
  
  public void GG(int paramInt)
  {
    aavp.a().GG(paramInt);
  }
  
  public void O(ChatMessage paramChatMessage)
  {
    aavp localaavp = aavp.a();
    aavr localaavr = localaavp.a();
    if (localaavr != null)
    {
      if (this == localaavr) {}
      localaavp.detach();
    }
    localaavp.a(this);
    localaavp.a(this.jdField_a_of_type_Aawc);
    localaavp.a(this.jdField_a_of_type_Aawd, this.b);
    localaavp.a(this.jdField_a_of_type_Aawg);
    localaavp.O(paramChatMessage);
  }
  
  public void P(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    aavp localaavp;
    do
    {
      do
      {
        do
        {
          return;
          localaavp = aavp.a();
        } while ((!localaavp.isSelected()) || (localaavp.p == null));
        if (paramChatMessage.uniseq == localaavp.p.uniseq) {
          break;
        }
      } while (this != localaavp.a());
      localaavp.czD();
      return;
    } while (this == localaavp.a());
    localaavp.a(this);
    localaavp.a(this.jdField_a_of_type_Aawc);
    localaavp.a(this.jdField_a_of_type_Aawd, this.b);
    if (localaavp.jdField_a_of_type_Aawg != null) {
      a(localaavp.jdField_a_of_type_Aawg);
    }
    localaavp.czC();
  }
  
  public boolean XA()
  {
    return (this.b != null) && (this.b.go(2));
  }
  
  public boolean XB()
  {
    return (Xz()) && (XA());
  }
  
  public boolean Xy()
  {
    return b().Xy();
  }
  
  public boolean Xz()
  {
    return (this.jdField_a_of_type_Aawd != null) && (this.jdField_a_of_type_Aawd.go(1));
  }
  
  public void a(@NonNull aawc paramaawc)
  {
    this.jdField_a_of_type_Aawc = paramaawc;
    this.jdField_a_of_type_Aawc.bind(this);
  }
  
  public void a(@NonNull aawd paramaawd1, @NonNull aawd paramaawd2)
  {
    this.jdField_a_of_type_Aawd = paramaawd1;
    this.jdField_a_of_type_Aawd.bind(this);
    this.b = paramaawd2;
    this.b.bind(this);
  }
  
  public void a(@NonNull aawg paramaawg)
  {
    this.jdField_a_of_type_Aawg = paramaawg;
    this.jdField_a_of_type_Aawg.bind(this);
  }
  
  public int b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    aavp localaavp = aavp.a();
    if (this == localaavp.a()) {
      return localaavp.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public void bg(int paramInt, boolean paramBoolean)
  {
    b().bg(paramInt, paramBoolean);
  }
  
  public void czA()
  {
    b().czA();
  }
  
  public void czB()
  {
    aavp.a().czB();
  }
  
  public void czz()
  {
    b().czz();
  }
  
  public void detach()
  {
    aavp localaavp = aavp.a();
    if (this == localaavp.a()) {
      localaavp.detach();
    }
  }
  
  public int endIndex()
  {
    return b().endIndex();
  }
  
  public void gy(int paramInt1, int paramInt2)
  {
    b().gy(paramInt1, paramInt2);
  }
  
  public boolean isSelectable()
  {
    return this.mSelectable;
  }
  
  public boolean isSelected()
  {
    aavp localaavp = aavp.a();
    return (this == localaavp.a()) && (localaavp.isSelected());
  }
  
  public int length()
  {
    return b().length();
  }
  
  @Nullable
  public String qK()
  {
    return b().qK();
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    b().selectContent(paramInt1, paramInt2);
  }
  
  public int startIndex()
  {
    return b().startIndex();
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    return b().touchIndex(paramInt1, paramInt2);
  }
  
  public void u(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b().u(paramInt1, paramInt2, paramBoolean);
  }
  
  public int zo()
  {
    return b().zo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavr
 * JD-Core Version:    0.7.0.1
 */