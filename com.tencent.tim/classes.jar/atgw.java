import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;

public class atgw
  implements TabBarView.a
{
  public atgw(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    CloudFileSendRecvActivity.a(this.this$0).setSelected(true);
    paramInt1 = -1;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.this$0.setType(paramInt1);
      this.this$0.etu();
      CloudFileSendRecvActivity.b(this.this$0, true);
      this.this$0.onLoading();
      if (!this.this$0.dhF)
      {
        atsj localatsj = new atsj();
        localatsj.aaC(paramInt2);
        this.this$0.app.a().a(3, localatsj);
      }
      return;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
      continue;
      paramInt1 = 8;
      continue;
      paramInt1 = 52;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgw
 * JD-Core Version:    0.7.0.1
 */