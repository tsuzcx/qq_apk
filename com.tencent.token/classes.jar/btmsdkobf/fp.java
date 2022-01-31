package btmsdkobf;

import java.util.ArrayList;

class fp
  implements cy.b
{
  fp(cf paramcf, cf.a parama, int paramInt, an paraman) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 != 0)
    {
      eh.h("GuidCertifier", "[cu_guid]registerGuid(), retCode: " + paramInt1);
      this.a.a(this.b, 1, paramInt1, null);
      return;
    }
    if (paramArrayList == null)
    {
      eh.h("GuidCertifier", "[cu_guid]registerGuid(), null == serverSashimis");
      this.a.a(this.b, 1, -21250000, null);
      return;
    }
    if (paramArrayList.size() <= 0)
    {
      eh.h("GuidCertifier", "[cu_guid]registerGuid(), serverSashimis.size() <= 0");
      this.a.a(this.b, 1, -21250000, null);
      return;
    }
    paramArrayList = (ba)paramArrayList.get(0);
    if (paramArrayList == null)
    {
      eh.h("GuidCertifier", "[cu_guid]registerGuid(), serverSashimi is null");
      this.a.a(this.b, 1, -21250000, null);
      return;
    }
    if (paramArrayList.df != 0)
    {
      eh.h("GuidCertifier", "[cu_guid]registerGuid(), mazu error: " + paramArrayList.df);
      this.a.a(this.b, 1, paramArrayList.df, null);
      return;
    }
    if (paramArrayList.dg != 0)
    {
      eh.h("GuidCertifier", "[cu_guid]registerGuid(), dataRetCode: " + paramArrayList.dg);
      this.a.a(this.b, 1, -21300000, null);
      return;
    }
    byte[] arrayOfByte = paramArrayList.data;
    if (arrayOfByte == null)
    {
      eh.h("GuidCertifier", "[cu_guid]registerGuid(), null == respData");
      this.a.a(this.b, 1, -21000005, null);
      return;
    }
    eh.e("GuidCertifier", "[cu_guid]registerGuid() rs.data.length: " + paramArrayList.data.length);
    aw localaw = new aw();
    try
    {
      paramArrayList = cd.a(cf.a(this.d), cf.b(this.d).ai().is.getBytes(), arrayOfByte, localaw, false, paramArrayList.di);
      if (paramArrayList == null)
      {
        eh.h("GuidCertifier", "[cu_guid]registerGuid(), decode jce failed: null");
        this.a.a(this.b, 1, -21000400, null);
        return;
      }
    }
    catch (Exception paramArrayList)
    {
      eh.h("GuidCertifier", "[cu_guid]registerGuid(), decode jce exception: " + paramArrayList);
      this.a.a(this.b, 1, -21000400, null);
      return;
    }
    paramArrayList = (aw)paramArrayList;
    eh.e("GuidCertifier", "[cu_guid]registerGuid(), guid got: " + paramArrayList.guid);
    cf.a(this.d, paramArrayList.guid, this.c, true);
    this.a.a(this.b, 1, 0, paramArrayList.guid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fp
 * JD-Core Version:    0.7.0.1
 */