package btmsdkobf;

import com.qq.taf.jce.JceStruct;

class hd
  implements cj
{
  hd(db paramdb, int paramInt) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    eh.f("SharkProtocolQueue", "[shark_push]sendGiftResp()-onFinish() seqNo: " + paramInt1 + " cmdId: " + paramInt2 + " retCode: " + paramInt3 + " dataRetCode: " + paramInt4);
    if (this.a == 156) {
      eh.i("SharkProtocolQueue", "[ip_list]sendGiftResp()-onFinish() seqNo: " + paramInt1 + " cmdId: " + paramInt2 + " retCode: " + paramInt3 + " dataRetCode: " + paramInt4 + " resp: " + paramJceStruct);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hd
 * JD-Core Version:    0.7.0.1
 */