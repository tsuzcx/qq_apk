import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class mom
  extends mot
{
  private mox a;
  
  public mom(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, mox parammox)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.a = parammox;
  }
  
  protected void a(mot.e parame, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.a == null) || (this.a.bd() == null) || (this.a.bd().isEmpty())) {
      return;
    }
    parame.checkBox.setBackgroundResource(2130850256);
    if (this.a.bd().contains(paramFriends.uin))
    {
      parame.checkBox.setEnabled(false);
      return;
    }
    parame.checkBox.setEnabled(true);
  }
  
  protected void aQM()
  {
    if ((this.a != null) && (this.b != null) && (this.b.size() >= this.a.pD()))
    {
      String str = this.mContext.getResources().getString(2131718508, new Object[] { String.valueOf(this.a.getMaxCount()) });
      QQToast.a(this.mContext, str, 0).show();
      return;
    }
    QQToast.a(this.mContext, this.mContext.getResources().getString(2131718502), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mom
 * JD-Core Version:    0.7.0.1
 */