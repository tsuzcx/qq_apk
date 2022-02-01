import com.tencent.mobileqq.ark.ArkAppCenter;

class adpx
  implements adpq.b
{
  adpx(adpq paramadpq, adpq.a parama, String paramString, adpq.c paramc) {}
  
  public void aY(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.r("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_b_of_type_Adpq$a.name, this.jdField_b_of_type_Adpq$a.url }));
    }
    for (;;)
    {
      this.jdField_b_of_type_Adpq$c.GG(false);
      return;
      if (!adpq.f(paramArrayOfByte, this.jdField_b_of_type_Adpq$a.md5))
      {
        ArkAppCenter.r("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_b_of_type_Adpq$a.name, this.jdField_b_of_type_Adpq$a.url, this.jdField_b_of_type_Adpq$a.md5 }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.buY, this.jdField_b_of_type_Adpq$a.name });
        if (adpq.e(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.r("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_b_of_type_Adpq$a.name, this.jdField_b_of_type_Adpq$a.url, str }));
      }
    }
    this.jdField_b_of_type_Adpq$c.GG(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpx
 * JD-Core Version:    0.7.0.1
 */