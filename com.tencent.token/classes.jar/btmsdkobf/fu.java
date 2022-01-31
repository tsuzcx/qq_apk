package btmsdkobf;

import android.text.TextUtils;
import java.util.ArrayList;

class fu
  extends fv
{
  fu(cs paramcs, String paramString, as paramas, cs.a parama, int paramInt)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    eh.f("RsaKeyCertifier", "[rsa_key]updateRsaKey(), isTcpChannel: " + paramBoolean + ", seqNo " + this.a.dc + ", retCode: " + paramInt1);
    if (paramInt1 != 0)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), retCode: " + paramInt1);
      this.b.a(this.c, 152, paramInt1);
      return;
    }
    if (paramArrayList == null)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), null == serverSashimis");
      this.b.a(this.c, 152, -21250000);
      return;
    }
    if (paramArrayList.size() <= 0)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), serverSashimis.size() <= 0");
      this.b.a(this.c, 152, -21250000);
      return;
    }
    paramArrayList = (ba)paramArrayList.get(0);
    if (paramArrayList == null)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), serverSashimi is null");
      this.b.a(this.c, 152, -21250000);
      return;
    }
    if (paramArrayList.df != 0)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), mazu error: " + paramArrayList.df);
      this.b.a(this.c, 152, paramArrayList.df);
      return;
    }
    if (paramArrayList.dg != 0)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), rs.dataRetCode: " + paramArrayList.dg);
      this.b.a(this.c, 152, -21300000);
      return;
    }
    if (paramArrayList.data == null)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), null == rs.data");
      this.b.a(this.c, 152, -21000005);
      return;
    }
    am localam = new am();
    try
    {
      paramArrayList = cd.a(null, this.e.getBytes(), paramArrayList.data, localam, false, paramArrayList.di);
      if (paramArrayList == null)
      {
        eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), decode jce failed: null == js");
        this.b.a(this.c, 152, -21000400);
        return;
      }
    }
    catch (Exception paramArrayList)
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), decode jce exception: " + paramArrayList);
      this.b.a(this.c, 152, -21000400);
      return;
    }
    paramArrayList = (am)paramArrayList;
    if (TextUtils.isEmpty(paramArrayList.sessionId))
    {
      eh.h("RsaKeyCertifier", "[rsa_key]updateRsaKey(), ret.sessionId is null");
      this.b.a(this.c, 152, -21280000);
      return;
    }
    cs.a(this.d, this.e, paramArrayList.sessionId);
    eh.f("RsaKeyCertifier", "[rsa_key]updateRsaKey(), encodeKey: " + this.e + " sessionId: " + paramArrayList.sessionId);
    this.b.a(this.c, 152, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fu
 * JD-Core Version:    0.7.0.1
 */