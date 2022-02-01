import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;

public final class axnd
  implements rxc.a<CLIENT.StSmartMatchMusicRsp>
{
  public axnd(rxc.a parama, long paramLong) {}
  
  public void b(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    axiy.i("AEEditorMusicHelper", "[requestRecommendedMusicList], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.a != null) {
      this.a.a(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.aCq;
    axim.a().l((int)paramLong, l1 - l2 + "", "AEEditorMusicList", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnd
 * JD-Core Version:    0.7.0.1
 */