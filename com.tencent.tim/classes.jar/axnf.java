import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.a;

public final class axnf
  implements aolm.b
{
  public axnf(AEEditorMusicHelper.a parama, axnb.a parama1, String paramString) {}
  
  public void onResp(aomh paramaomh)
  {
    boolean bool2 = true;
    axim localaxim;
    if ((paramaomh != null) && (paramaomh.mResult == 0))
    {
      bool1 = true;
      axiy.i("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + bool1);
      if (this.a != null) {
        this.a.a(this.c, bool1, this.val$localPath);
      }
      if (paramaomh != null)
      {
        localaxim = axim.a();
        if (paramaomh.mResult != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localaxim.a(bool1, 5, "AEEditorMusicDownload", this.c.getSongMid(), paramaomh.mErrCode, paramaomh.reqCost);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnf
 * JD-Core Version:    0.7.0.1
 */