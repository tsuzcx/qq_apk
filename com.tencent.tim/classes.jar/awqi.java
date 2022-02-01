class awqi
  implements aolm.b
{
  awqi(awqd paramawqd, awqd.b paramb, String paramString1, String paramString2) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3) {
      return;
    }
    if (paramaomh.mResult == 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = paramaomh.mErrCode;
      this.a.a(this.cSd, this.val$filePath, bool, paramaomh.clO, i);
      return;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    this.a.onDownloadProgress(this.cSd, paramLong2, (float)paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqi
 * JD-Core Version:    0.7.0.1
 */