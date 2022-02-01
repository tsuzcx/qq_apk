import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.List;

public class aoqm
{
  public static aoqm.b a(aoql.a parama)
  {
    if ((parama != null) && (parama.a != null) && (parama.b != null) && (parama.He.size() != 0))
    {
      if ("c2c_pic_up".equals(parama.cmy)) {
        return new aopy();
      }
      if ("grp_pic_up".equals(parama.cmy)) {
        return new aoqc();
      }
      if ("grp_ptt_up".equals(parama.cmy)) {
        return new aoqe();
      }
      if ("c2c_pic_dw".equals(parama.cmy)) {
        return new aopx();
      }
      if ("grp_pic_dw".equals(parama.cmy)) {
        return new aoqb();
      }
      if ("c2c_ptt_up".equals(parama.cmy)) {
        return new aoqa();
      }
      if ("c2c_ptt_dw".equals(parama.cmy)) {
        return new aopz();
      }
      if ("grp_ptt_dw".equals(parama.cmy)) {
        return new aoqd();
      }
      if ("short_video_dw".equals(parama.cmy)) {
        return new aoqo();
      }
      if ("short_video_up".equals(parama.cmy)) {
        return new aoqq();
      }
      if ("multi_msg_dw".equals(parama.cmy)) {
        return new aoqf();
      }
      if ("multi_msg_up".equals(parama.cmy)) {
        return new aoqg();
      }
      if (("nearby_people_pic_up".equals(parama.cmy)) || ("friend_avatar_up".equals(parama.cmy))) {
        return new aoqh();
      }
      if ("short_video_fw".equals(parama.cmy)) {
        return new aoqp();
      }
      if ("bdh_common_up".equals(parama.cmy)) {
        return new aopv();
      }
      if ("pa_long_message".equals(parama.cmy)) {
        return new aoqi();
      }
      if ("art_filter_up".equals(parama.cmy)) {
        return new aopu();
      }
      if ("share_pic_to_wx".equals(parama.cmy)) {
        return new aoqn();
      }
    }
    return null;
  }
  
  public static void a(aoql.a parama, aoql.b paramb)
  {
    if ((parama != null) && (parama.b != null))
    {
      parama.c = null;
      parama.b.a(parama, paramb);
      parama.b = null;
      parama.a = null;
    }
  }
  
  public static void c(aoql.a parama)
  {
    aoqm.b localb = a(parama);
    if (localb != null) {
      localb.a(parama);
    }
  }
  
  public static void d(aoql.a parama)
  {
    if ((parama != null) && (parama.a != null))
    {
      parama.a.e(parama.c);
      parama.b = null;
      parama.c = null;
      parama.a = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(aoql.a parama, aoql.b paramb);
  }
  
  public static abstract interface b
  {
    public abstract void a(aoql.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqm
 * JD-Core Version:    0.7.0.1
 */