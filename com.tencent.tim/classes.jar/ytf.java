import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.d;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class ytf
  implements TabLayoutCompat.b
{
  public ytf(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(TabLayoutCompat.d paramd)
  {
    int j;
    if (paramd != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramd.getPosition() + " tabid = " + (Integer)paramd.getTag());
      }
      SystemMsgListView.a(this.this$0).fT(((Integer)paramd.getTag()).intValue(), paramd.getPosition());
      i = SystemMsgListView.a(this.this$0).xt();
      paramd = (yrp)SystemMsgListView.a(this.this$0).get(i);
      if (paramd == null) {
        break label141;
      }
      j = paramd.caJ;
    }
    for (int i = paramd.caK;; i = SystemMsgListView.a(this.this$0).caK)
    {
      SystemMsgListView.a(this.this$0).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.this$0).gs(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.this$0).caJ;
    }
  }
  
  public void b(TabLayoutCompat.d paramd) {}
  
  public void c(TabLayoutCompat.d paramd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytf
 * JD-Core Version:    0.7.0.1
 */