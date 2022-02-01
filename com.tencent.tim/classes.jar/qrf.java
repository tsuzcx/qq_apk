import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

class qrf
  extends akll
{
  qrf(qre paramqre) {}
  
  protected void ak(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof oidb_0x791.RedDotInfo)))
    {
      paramObject = (oidb_0x791.RedDotInfo)paramObject;
      if (paramObject.uint32_appid.get() == 21)
      {
        int i = paramObject.uint32_number.get();
        int j = paramObject.uint32_last_time.get();
        this.b.b.dX(i, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrf
 * JD-Core Version:    0.7.0.1
 */