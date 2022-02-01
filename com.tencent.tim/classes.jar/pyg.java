import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class pyg
  implements ppv.b<pzv, qbb>
{
  public Set<String> aK = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    pzv localpzv = new pzv();
    localpzv.vid = paramString1;
    localpzv.awq = paramString2;
    localpzv.isLiveVideo = paramBoolean;
    localpzv.mSource = paramInt;
    localpzv.mCreateTime = paramLong;
    ppv.a().a(localpzv, this);
  }
  
  public void a(@NonNull pzv parampzv, @Nullable qbb paramqbb, @NonNull ErrorMessage paramErrorMessage)
  {
    pyg.a locala = new pyg.a();
    locala.b = paramErrorMessage;
    locala.vid = parampzv.vid;
    if (rnw.fy(locala.vid)) {
      parampzv.awq = "4_10000";
    }
    locala.uin = parampzv.awq;
    locala.isLiveVideo = parampzv.isLiveVideo;
    psu localpsu = (psu)psx.a(5);
    if ((parampzv.mSource == 3) || (parampzv.mSource == 4) || (parampzv.mSource == 31) || (parampzv.mSource == 62))
    {
      locala.unReadCount = localpsu.e("Q.qqstory.player.WatchVideoHandler", parampzv.awq, parampzv.vid);
      StoryItem localStoryItem = localpsu.a(parampzv.awq, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = locala.unReadCount;
        localpsu.a(parampzv.awq, 1, localStoryItem);
        ram.w("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { parampzv.vid, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramqbb == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.aK.add(parampzv.vid);
      pmi.a().dispatch(locala);
    }
    label281:
    label294:
    do
    {
      return;
      locala.unReadCount = localpsu.be(parampzv.awq);
      ram.b("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", parampzv.vid, Integer.valueOf(parampzv.mSource));
      break;
      localpsu.bp(parampzv.awq, 1);
      break label210;
      pmi.a().dispatch(locala);
      paramqbb = localpsu.a(parampzv.vid);
    } while (paramqbb == null);
    ((psq)psx.a(13)).a(parampzv.vid, parampzv.awq, parampzv.isLiveVideo, paramqbb.mCreateTime, parampzv.mSource, parampzv.bkb, true);
  }
  
  public static class a
    extends plt
  {
    public boolean isLiveVideo;
    public String uin;
    public int unReadCount;
    public String vid;
    
    public String toString()
    {
      return "WatchVideoEvent{vid='" + this.vid + '\'' + ", uin=" + this.uin + ", isLiveVideo=" + this.isLiveVideo + ", unReadCount=" + this.unReadCount + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyg
 * JD-Core Version:    0.7.0.1
 */