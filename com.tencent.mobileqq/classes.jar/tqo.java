import java.util.HashMap;

class tqo
  extends tpp
{
  tqo(tqh paramtqh, String paramString1, String paramString2, boolean paramBoolean, trl paramtrl)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_Trl.a = ((String)a("EncryptUrlJob_encryptedUrl"));
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.jdField_a_of_type_Trl.a, this.jdField_a_of_type_Trl.a);
    a("ShortenUrlJob_shortenedUrls", localHashMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqo
 * JD-Core Version:    0.7.0.1
 */