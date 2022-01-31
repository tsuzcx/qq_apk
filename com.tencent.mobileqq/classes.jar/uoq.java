import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

class uoq
  extends atzm
{
  uoq(uop paramuop) {}
  
  protected void a(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof oidb_0x791.RedDotInfo)))
    {
      paramObject = (oidb_0x791.RedDotInfo)paramObject;
      if (paramObject.uint32_appid.get() == 21)
      {
        int i = paramObject.uint32_number.get();
        int j = paramObject.uint32_last_time.get();
        this.a.a.a(i, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uoq
 * JD-Core Version:    0.7.0.1
 */