import com.tencent.qphone.base.util.QLog;

public class aeix
{
  protected String mContent = "";
  
  public aeix() {}
  
  public aeix(String paramString)
  {
    if (paramString != null) {
      this.mContent = paramString;
    }
  }
  
  public aeix.a a()
  {
    if ((this instanceof aeix.a)) {
      return (aeix.a)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public aeix.b a()
  {
    if ((this instanceof aeix.b)) {
      return (aeix.b)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public aeix.c a()
  {
    if ((this instanceof aeix.c)) {
      return (aeix.c)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordSDKShareConfBean object");
    return null;
  }
  
  public aeix.d a()
  {
    if ((this instanceof aeix.d)) {
      return (aeix.d)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public aeix.e a()
  {
    if ((this instanceof aeix.e)) {
      return (aeix.e)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkPlatformConfigBean object");
    return null;
  }
  
  public String getContent()
  {
    return this.mContent;
  }
  
  public static class a
    extends aeix
  {
    private aeje.a b;
    
    a(String paramString, aeje.a parama)
    {
      super();
      this.b = parama;
    }
    
    public aeje.a e()
    {
      return this.b;
    }
  }
  
  public static class b
    extends aeix
  {
    private aeje.b jdField_a_of_type_Aeje$b;
    private aeje.l jdField_a_of_type_Aeje$l;
    
    public b(String paramString, aeje.b paramb, aeje.l paraml)
    {
      super();
      this.jdField_a_of_type_Aeje$b = paramb;
      this.jdField_a_of_type_Aeje$l = paraml;
    }
    
    public aeje.b a()
    {
      return this.jdField_a_of_type_Aeje$b;
    }
    
    public aeje.l a()
    {
      return this.jdField_a_of_type_Aeje$l;
    }
  }
  
  public static class c
    extends aeix
  {
    private aeje.c a;
    
    c(String paramString, aeje.c paramc)
    {
      super();
      this.a = paramc;
    }
    
    public aeje.c a()
    {
      return this.a;
    }
  }
  
  public static class d
    extends aeix
  {
    private aeje.g a;
    
    public d(String paramString, aeje.g paramg)
    {
      super();
      this.a = paramg;
    }
    
    public aeje.g a()
    {
      return this.a;
    }
  }
  
  public static class e
    extends aeix
  {
    private aeje.h a;
    
    public e(String paramString, aeje.h paramh)
    {
      super();
      this.a = paramh;
    }
    
    public aeje.h a()
    {
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeix
 * JD-Core Version:    0.7.0.1
 */