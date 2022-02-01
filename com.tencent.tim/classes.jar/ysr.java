import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.d;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ysr
  extends ysa
  implements TabLayoutCompat.b
{
  public ysr(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Ytd.xu();
    int i = this.jdField_a_of_type_Ytd.xt();
    ysr.a locala;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysr.a)))
    {
      locala = new ysr.a();
      paramView = LayoutInflater.from(this.mContext).inflate(2131561505, null);
      locala.b = ((ThemeTabLayout)paramView.findViewById(2131379154));
      locala.b.b(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Ytv != null) || ((this.jdField_a_of_type_Ytv instanceof ytx))) {
        locala.b.w(((ytx)this.jdField_a_of_type_Ytv).data, i);
      }
      locala.b.setOnTabSelectedListener(this);
      paramView.setTag(locala);
    }
    for (;;)
    {
      fK(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((locala != null) && (locala.b != null) && ((this.jdField_a_of_type_Ytv != null) || ((this.jdField_a_of_type_Ytv instanceof ytx))))
      {
        ArrayList localArrayList = ((ytx)this.jdField_a_of_type_Ytv).data;
        locala.b.v(localArrayList, i);
      }
      return paramView;
      locala = (ysr.a)paramView.getTag();
    }
  }
  
  public void a(TabLayoutCompat.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramd.getPosition());
    }
    if ((this.jdField_a_of_type_Ytd != null) && (paramd != null))
    {
      this.jdField_a_of_type_Ytd.fU(((Integer)paramd.getTag()).intValue(), paramd.getPosition());
      int i = this.jdField_a_of_type_Ytd.xt();
      anot.a(this.mApp, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(TabLayoutCompat.d paramd) {}
  
  public ArrayList<yrh> bR()
  {
    if ((this.jdField_a_of_type_Ytv != null) || ((this.jdField_a_of_type_Ytv instanceof ytx))) {
      return ((ytx)this.jdField_a_of_type_Ytv).data;
    }
    return null;
  }
  
  public void c(TabLayoutCompat.d paramd) {}
  
  public void fK(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839642);
      return;
    }
    paramView.setBackgroundResource(2130851238);
  }
  
  public static class a
  {
    public ThemeTabLayout b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysr
 * JD-Core Version:    0.7.0.1
 */