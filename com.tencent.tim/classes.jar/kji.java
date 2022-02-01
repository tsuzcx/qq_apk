import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;

public class kji
  implements RIJRedPacketManager.f
{
  public kji(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void lJ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReadInJoyVideoSubChannelActivity.a(this.this$0).setVisibility(0);
      if (ReadInJoyVideoSubChannelActivity.a(this.this$0).c() != null) {}
      for (String str = ReadInJoyVideoSubChannelActivity.a(this.this$0).c().getInnerUniqueID();; str = null)
      {
        ReadInJoyVideoSubChannelActivity.a(this.this$0).a(4, ReadInJoyVideoSubChannelActivity.a(this.this$0).Dw(), str);
        return;
      }
    }
    ReadInJoyVideoSubChannelActivity.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kji
 * JD-Core Version:    0.7.0.1
 */