import java.util.HashMap;

class vfg
  extends veh
{
  vfg(vez paramvez, String paramString1, String paramString2, boolean paramBoolean, vgd paramvgd)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_Vgd.a = ((String)a("EncryptUrlJob_encryptedUrl"));
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.jdField_a_of_type_Vgd.a, this.jdField_a_of_type_Vgd.a);
    a("ShortenUrlJob_shortenedUrls", localHashMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfg
 * JD-Core Version:    0.7.0.1
 */