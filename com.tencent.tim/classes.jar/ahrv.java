import com.tencent.mobileqq.gamecenter.data.GameNoticeInfo;
import java.util.Comparator;

public final class ahrv
  implements Comparator<GameNoticeInfo>
{
  public int a(GameNoticeInfo paramGameNoticeInfo1, GameNoticeInfo paramGameNoticeInfo2)
  {
    if (paramGameNoticeInfo1.startTime == paramGameNoticeInfo2.startTime) {
      return paramGameNoticeInfo1.bannerType - paramGameNoticeInfo2.bannerType;
    }
    if (paramGameNoticeInfo1.startTime < paramGameNoticeInfo2.startTime) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrv
 * JD-Core Version:    0.7.0.1
 */