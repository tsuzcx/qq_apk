import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.wordsegment.WordSegment.ILogCallback;

final class adpp
  implements WordSegment.ILogCallback
{
  public void OnLog(String paramString1, String paramString2)
  {
    ArkAppCenter.r("ArkApp.Dict.WordSegment." + paramString1, String.format("%s", new Object[] { paramString2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpp
 * JD-Core Version:    0.7.0.1
 */