package btmsdkobf;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;

class ie
  implements cj
{
  ie(dk paramdk) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if ((paramInt3 != 0) || (paramInt4 != 0) || (paramJceStruct == null)) {
      eh.g("VidCertifier", "[cu_vid]registerVidIfNeed()-onFinish(), seqNo: " + paramInt1 + " retCode: " + paramInt3 + " dataRetCode: " + paramInt4 + " resp: " + paramJceStruct);
    }
    for (;;)
    {
      dk.a(this.a, false);
      return;
      paramJceStruct = ((ax)paramJceStruct).dr;
      if (!TextUtils.isEmpty(paramJceStruct))
      {
        eh.f("VidCertifier", "[cu_vid]registerVidIfNeed()-onFinish(), succ, vid: " + paramJceStruct);
        dk.a(this.a, paramJceStruct);
        dk.a(this.a).bL().c(paramJceStruct, true);
        dk.a(this.a).bL().d(paramJceStruct, true);
      }
      else
      {
        eh.g("VidCertifier", "[cu_vid]registerVidIfNeed()-onFinish(), seqNo: " + paramInt1 + ", vid is empty: " + paramJceStruct);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ie
 * JD-Core Version:    0.7.0.1
 */