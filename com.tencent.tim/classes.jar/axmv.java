import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;

class axmv
  implements axiv.a
{
  axmv(axmr paramaxmr, axmr.a parama, String paramString1, AEEditorDownloadResBean paramAEEditorDownloadResBean, String paramString2, String paramString3) {}
  
  public void j(aomh paramaomh)
  {
    boolean bool3 = false;
    if (paramaomh == null)
    {
      if (this.a != null) {
        this.a.Ys(false);
      }
      axmr.a(this.this$0, this.val$md5, false);
      return;
    }
    boolean bool1;
    boolean bool2;
    if (paramaomh.mResult == 0)
    {
      bool1 = true;
      axiy.i("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---isSuccess=" + bool1 + ", id=" + this.b.getId());
      bool2 = bool3;
      if (bool1)
      {
        String str = aqhq.px(this.cVy);
        if ((str == null) || (!str.equalsIgnoreCase(this.val$md5))) {
          break label309;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool2 = axmr.a(this.this$0, this.cVy, this.cVz, this.b.getId(), this.val$md5);
        axim.a().a(bool1, 3, "AEEditorFilter", this.b.getId(), paramaomh.mErrCode, paramaomh.reqCost);
        if (!bool2) {
          aqhq.cn(this.cVz);
        }
        aqhq.deleteFile(this.cVy);
        axiy.i("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---REAL result=" + bool2 + ", id=" + this.b.getId());
        if (this.a != null) {
          this.a.Ys(bool2);
        }
        axmr.a(this.this$0, this.val$md5, bool2);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        axiy.e("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.b.getId(), localException);
        localException.printStackTrace();
        bool2 = bool3;
        continue;
      }
      label309:
      axiy.e("AEEditorFiltersManager", "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.b.getId());
      bool2 = bool3;
    }
  }
  
  public void onProgressUpdate(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmv
 * JD-Core Version:    0.7.0.1
 */