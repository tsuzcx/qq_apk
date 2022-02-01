import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class advo
{
  public ArrayList<advo.a> uQ;
  
  public static advo a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    advo localadvo;
    do
    {
      return localObject;
      localadvo = new advo();
      localObject = localadvo;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localadvo.uQ = advo.a.x(paramRspBody.rpt_msg_uin_head_list.get());
    return localadvo;
  }
  
  public static class a
  {
    public int timeStamp;
    public long tinyId;
    public ArrayList<advo.b> uR;
    public long uin;
    
    public static a a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
    {
      Object localObject;
      if (paramOneUinHeadInfo == null) {
        localObject = null;
      }
      a locala;
      do
      {
        return localObject;
        locala = new a();
        if (paramOneUinHeadInfo.uint64_uin.has()) {
          locala.uin = paramOneUinHeadInfo.uint64_uin.get();
        }
        if (paramOneUinHeadInfo.uint64_tinyid.has()) {
          locala.tinyId = paramOneUinHeadInfo.uint64_tinyid.get();
        }
        locala.timeStamp = ((int)(System.currentTimeMillis() / 1000L));
        localObject = locala;
      } while (!paramOneUinHeadInfo.rpt_msg_head_list.has());
      locala.uR = advo.b.x(paramOneUinHeadInfo.rpt_msg_head_list.get());
      return locala;
    }
    
    public static ArrayList<a> x(List<oidb_0x74b.OneUinHeadInfo> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      return localArrayList;
    }
  }
  
  public static class b
  {
    public String bvI;
    public int cKq;
    public int id;
    public int timeStamp;
    public int type;
    public ArrayList<advo.c> uS;
    
    public static b a(oidb_0x74b.HeadInfo paramHeadInfo)
    {
      Object localObject;
      if (paramHeadInfo == null) {
        localObject = null;
      }
      b localb;
      do
      {
        return localObject;
        localb = new b();
        if (paramHeadInfo.uint32_id.has()) {
          localb.id = paramHeadInfo.uint32_id.get();
        }
        if (paramHeadInfo.str_photohead.has()) {
          localb.bvI = paramHeadInfo.str_photohead.get();
        }
        if (paramHeadInfo.uint32_invalid.has()) {
          localb.cKq = paramHeadInfo.uint32_invalid.get();
        }
        if (paramHeadInfo.uint32_timestamp.has()) {
          localb.timeStamp = paramHeadInfo.uint32_timestamp.get();
        }
        if (paramHeadInfo.uint32_type.has()) {
          localb.type = paramHeadInfo.uint32_type.get();
        }
        localObject = localb;
      } while (!paramHeadInfo.rpt_videoheadlist.has());
      localb.uS = advo.c.x(paramHeadInfo.rpt_videoheadlist.get());
      return localb;
    }
    
    public static ArrayList<b> x(List<oidb_0x74b.HeadInfo> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        b localb = a((oidb_0x74b.HeadInfo)paramList.next());
        if (localb != null) {
          localArrayList.add(localb);
        }
      }
      return localArrayList;
    }
  }
  
  public static class c
  {
    public String url;
    public int videoSize;
    
    public static c a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
    {
      Object localObject;
      if (paramVideoHeadInfo == null) {
        localObject = null;
      }
      c localc;
      do
      {
        return localObject;
        localc = new c();
        if (paramVideoHeadInfo.str_url.has()) {
          localc.url = paramVideoHeadInfo.str_url.get();
        }
        localObject = localc;
      } while (!paramVideoHeadInfo.uint32_video_size.has());
      localc.videoSize = paramVideoHeadInfo.uint32_video_size.get();
      return localc;
    }
    
    public static ArrayList<c> x(List<oidb_0x74b.VideoHeadInfo> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        c localc = a((oidb_0x74b.VideoHeadInfo)paramList.next());
        if (localc != null) {
          localArrayList.add(localc);
        }
      }
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advo
 * JD-Core Version:    0.7.0.1
 */