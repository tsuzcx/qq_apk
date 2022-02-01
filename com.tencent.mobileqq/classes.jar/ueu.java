import NS_KING_SOCIALIZE_META.stMetaPerson;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;

public class ueu
{
  public static stMetaPerson a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    return new stMetaPerson(paramstSimpleMetaPerson.id, paramstSimpleMetaPerson.type, paramstSimpleMetaPerson.uid, paramstSimpleMetaPerson.createtime, paramstSimpleMetaPerson.nick, paramstSimpleMetaPerson.avatar, paramstSimpleMetaPerson.sex, "", "", "", "", "", "", -1, 0, "");
  }
  
  public static stSimpleComment a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaComment.poster;
    if (TextUtils.isEmpty(localstSimpleMetaPerson.nick)) {}
    for (;;)
    {
      return new stSimpleComment(paramstSimpleMetaComment.id, paramstSimpleMetaComment.wording, paramstSimpleMetaComment.poster_id, a(paramstSimpleMetaPerson), paramstSimpleMetaComment.dingNum, paramstSimpleMetaComment.isDing, paramstSimpleMetaComment.feedId, null);
      paramstSimpleMetaPerson = localstSimpleMetaPerson;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ueu
 * JD-Core Version:    0.7.0.1
 */