import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.MoveVideoReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.ReqBody;

public class mmr
{
  public static void a(List<String> paramList, int paramInt, @Nullable mmr.a parama)
  {
    oidb_0xe2a.MoveVideoReq localMoveVideoReq = new oidb_0xe2a.MoveVideoReq();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str)) {
        localMoveVideoReq.rpt_rowkey_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    localMoveVideoReq.uint32_column_id.set(paramInt);
    localMoveVideoReq.uint32_oper_type.set(1);
    paramList = new oidb_0xe2a.ReqBody();
    paramList.msg_move_video_req.set(localMoveVideoReq);
    jnm.a(kxm.a(), new mmt(parama, paramInt), paramList.toByteArray(), "OidbSvc.0xe2a", 3626, 2);
  }
  
  public static void a(List<UgcVideo> paramList, @Nullable mmr.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((UgcVideo)paramList.next()).parseUgcVideo());
    }
    paramList = new oidb_0xe2a.ReqBody();
    oidb_0xe2a.AddVideoReq localAddVideoReq = new oidb_0xe2a.AddVideoReq();
    localAddVideoReq.rpt_video_list.set(localArrayList);
    paramList.msg_add_video_req.set(localAddVideoReq);
    jnm.a(kxm.a(), new mms(paramb), paramList.toByteArray(), "OidbSvc.0xe2a", 3626, 1, null, 120000L);
  }
  
  public static abstract interface a
  {
    public abstract void ay(int paramInt, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void bl(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmr
 * JD-Core Version:    0.7.0.1
 */