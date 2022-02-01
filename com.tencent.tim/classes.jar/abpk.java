import com.tencent.qphone.base.util.QLog;

class abpk
  extends aquy
{
  abpk(abpi paramabpi) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + paramaquz.getStatus());
  }
  
  public void onDoneFile(aquz paramaquz)
  {
    if ((paramaquz == null) || (abpi.a(this.this$0) == null)) {
      return;
    }
    if (paramaquz.getStatus() != 3)
    {
      abpi.a(this.this$0, 2);
      if (abpi.a(this.this$0) != null) {
        abpi.a(this.this$0).bK(-1005, abpi.a(this.this$0).packName);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + paramaquz.getStatus());
      return;
    }
    abpi.a(this.this$0);
  }
  
  public void onProgress(aquz paramaquz)
  {
    int i = (int)paramaquz.fj;
    if (abpi.a(this.this$0) != null) {
      abpi.a(this.this$0).C(i, abpi.a(this.this$0).gameId, abpi.a(this.this$0).packName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpk
 * JD-Core Version:    0.7.0.1
 */