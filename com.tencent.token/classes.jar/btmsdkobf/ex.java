package btmsdkobf;

import com.qq.taf.jce.JceStruct;

final class ex
  implements cj
{
  ex(be parambe) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    eg.e("ActionStats", "sendShark, ECmd.Cmd_CSFeature, retCode:[" + paramInt3 + "]dataRetCode:[" + paramInt4 + "]");
    if (paramInt3 == 0)
    {
      this.a.s();
      this.a.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ex
 * JD-Core Version:    0.7.0.1
 */