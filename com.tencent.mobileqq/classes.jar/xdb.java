import java.util.HashMap;

class xdb
  extends xcc
{
  xdb(xcu paramxcu, String paramString1, String paramString2, boolean paramBoolean, xdy paramxdy)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_Xdy.a = ((String)a("EncryptUrlJob_encryptedUrl"));
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.jdField_a_of_type_Xdy.a, this.jdField_a_of_type_Xdy.a);
    a("ShortenUrlJob_shortenedUrls", localHashMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdb
 * JD-Core Version:    0.7.0.1
 */