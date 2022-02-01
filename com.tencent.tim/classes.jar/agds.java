import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;

class agds
  implements rts.a
{
  agds(agdq paramagdq, int paramInt) {}
  
  public void bwu()
  {
    String str = (String)this.a.getGroup(this.Ju);
    if (agdq.a(this.a).isGroupExpanded(this.Ju))
    {
      QQAppInterface.EI(str + acfp.m(2131711041));
      return;
    }
    QQAppInterface.EI(str + acfp.m(2131711021));
  }
  
  public void bwv()
  {
    QLog.e("ACCESS_SILAS", 1, "onViewFocusClear");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agds
 * JD-Core Version:    0.7.0.1
 */